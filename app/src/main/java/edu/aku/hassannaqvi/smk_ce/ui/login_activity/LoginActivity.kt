package edu.aku.hassannaqvi.smk_ce.ui.login_activity

import android.Manifest
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.github.amlcurran.showcaseview.ShowcaseView
import com.github.amlcurran.showcaseview.targets.ViewTarget
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.base.repository.GeneralRepository
import edu.aku.hassannaqvi.smk_ce.base.repository.ResponseStatus.*
import edu.aku.hassannaqvi.smk_ce.base.viewmodel.LoginViewModel
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivityLoginBinding
import edu.aku.hassannaqvi.smk_ce.models.Users
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import edu.aku.hassannaqvi.smk_ce.ui.SyncActivity
import edu.aku.hassannaqvi.smk_ce.ui.login_activity.login_view.LoginUISource
import edu.aku.hassannaqvi.smk_ce.utils.extension.gotoActivity
import edu.aku.hassannaqvi.smk_ce.utils.extension.obtainViewModel
import edu.aku.hassannaqvi.smk_ce.utils.isNetworkConnected
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity(), LoginUISource {

    lateinit var bi: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    var permissionFlag = false
    var approval = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_login)
        bi.callback = this
        bi.txtinstalldate.text = MainApp.appInfo.getAppInfo()
        viewModel = obtainViewModel(LoginViewModel::class.java, GeneralRepository(DatabaseHelper(this)))
        showcaseBuilderView()
        checkPermissions()

        /*
        * Get login confirmation from db. If it's null that means username or password - incorrect -
        * otherwise approve it
        *
        * */
        viewModel.loginResponse.observe(this, {
            when (it.status) {
                SUCCESS -> {
                    approval = true
                    MainApp.user = it.data
                    MainApp.admin = it.data!!.userName.contains("@")
                    gotoActivity(MainActivity::class.java)
                }
                ERROR -> {
                    setPasswordIncorrect()
                    showProgress(false)
                }
                LOADING -> {
                    lifecycleScope.launch {
                        delay(1000)
                    }
                }
            }
        })
    }

    /*
    * For uploading/downloading data, the network needs to work
    * */
    fun onSyncDataClick(v: View) {
        if (!isNetworkConnected(this)) {
            Toast.makeText(this, "Network connection not available!", Toast.LENGTH_SHORT).show()
            return
        }
        gotoActivity(SyncActivity::class.java)
    }

    /*
    * Toggle password view
    * */
    fun onShowPasswordClick(v: View) {
        if (bi.password.transformationMethod == null) {
            bi.password.transformationMethod = PasswordTransformationMethod()
            bi.password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_close, 0, 0, 0)
        } else {
            bi.password.transformationMethod = null
            bi.password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_open, 0, 0, 0)
        }
    }

    /*
    * Click on login button, it works in steps:
    * 1. Check the permissions @checkPermissions
    * 3. If both of above conditions are okay then start coroutine to check login and proceed to MainActivity
    * */
    fun onLoginClick(v: View) {
        if (!permissionFlag)
            checkPermissions()
        else {
            // Store values at the time of the login attempt.
            val username = bi.username.text.toString()
            val password = bi.password.text.toString()
            showProgress(true)
            lifecycleScope.launch {
                delay(1000)
                if (!formValidation(username, password)) {
                    this.cancel()
                    showProgress(false)
                }
                val job = launch {
                    isLoginApproved(username, password)
                }
                job.join()
                if (approval) {
                    showProgress(false)
                    gotoActivity(MainActivity::class.java)
                }
            }

        }
    }

    /*
    * Visible progress dialog and hide whole layout when @param{show} is true and vice versa
    * */
    override fun showProgress(show: Boolean) {
        val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime)

        bi.loginForm.visibility = if (show) View.GONE else View.VISIBLE
        bi.loginForm.animate().setDuration(shortAnimTime.toLong()).alpha(
                if (show) 0f else 1f).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                bi.loginForm.visibility = if (show) View.GONE else View.VISIBLE
            }
        })

        bi.loginProgress.visibility = if (show) View.VISIBLE else View.GONE
        bi.loginProgress.animate().setDuration(shortAnimTime.toLong()).alpha(
                if (show) 1f else 0f).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                bi.loginProgress.visibility = if (show) View.VISIBLE else View.GONE
            }
        })
    }

    /*
    * Validate username and password fields
    * */
    override fun formValidation(username: String, password: String): Boolean {
        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            bi.password.error = "Invalid Password"
            bi.password.requestFocus()
            return false
        }

        // Check for a valid username address.
        if (TextUtils.isEmpty(username)) {
            bi.username.error = "Username is required."
            bi.username.requestFocus()
            return false
        }

        return true
    }

    /*
    * Set error on password
    * */
    override fun setPasswordIncorrect(error: String?) {
        bi.password.error = error ?: "Incorrect Password"
        bi.password.requestFocus()
    }

    /*
    * @isLoginApproved takes @params{username & password} and to see if it's testing user else -
    * pass it to viewmodel @getLoginInfoFromDB to check whether it exist in db or not
    * */
    override suspend fun isLoginApproved(username: String, password: String) {
        if ((username == "dmu@aku" && password == "aku?dmu") ||
                (username == "test1234" && password == "test1234")) {
            MainApp.user = Users(username, "Test User")
            MainApp.admin = username.contains("@")
            approval = true
        } else
            viewModel.getLoginInfoFromDB(username, password)
    }

    /*
    * Showing showcase builder view
    * */
    private fun showcaseBuilderView() {
        ShowcaseView.Builder(this)
                .setTarget(ViewTarget(bi.syncData.id, this))
                .setStyle(R.style.CustomShowcaseTheme)
                .setContentText("\n\nPlease download data before login")
                .singleShot(42)
                .build()
    }

    /*
    * Runtime permissions that user needs to be accept all of it otherwise -
    * it won't route to another activity
    * */
    private fun checkPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            permissionFlag = true
            return
        }
        val permissions = arrayOf(
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val options: Permissions.Options = Permissions.Options()
                .setRationaleDialogTitle("Permissions Required")
                .setSettingsDialogTitle("Warning")
        Permissions.check(this, permissions, null, options, object : PermissionHandler() {
            override fun onGranted() {
                permissionFlag = true
            }
        })
    }

}