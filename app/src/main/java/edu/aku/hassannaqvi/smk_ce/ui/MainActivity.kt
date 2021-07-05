package edu.aku.hassannaqvi.smk_ce.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.aku.hassannaqvi.smk_ce.R

import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.database.AndroidManager
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivityMainBinding
import edu.aku.hassannaqvi.smk_ce.ui.list_activity.FormsReportLHW
import edu.aku.hassannaqvi.smk_ce.ui.list_activity.FormsReportDate
import edu.aku.hassannaqvi.smk_ce.ui.list_activity.FormsReportPending
import edu.aku.hassannaqvi.smk_ce.ui.list_activity.HHIDReportDate
import edu.aku.hassannaqvi.smk_ce.ui.login_activity.LoginActivity
import edu.aku.hassannaqvi.smk_ce.ui.sections.*
import edu.aku.hassannaqvi.smk_ce.utils.extension.gotoActivity
import edu.aku.hassannaqvi.smk_ce.utils.extension.gotoActivityWithNoHistory
import edu.aku.hassannaqvi.smk_ce.utils.isNetworkConnected
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper
    lateinit var bi: ActivityMainBinding
    private var exit = false
    private var sysdateToday = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Date())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = MainApp.appInfo.dbHelper
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        if (MainApp.admin) bi.adminSection.visibility = View.VISIBLE
        if(MainApp.user.dist_id.length>0) {
            bi.username.text = "Welcome," + MainApp.user.fullname + "! \r\n You're working in '" + db.getDistrictNameByID(MainApp.user.dist_id) + "' today.";
        } else {
            bi.username.text = MainApp.user.userName +" is invalid User"
        }



    }

    /*
    * Back press button that will route to login activity after pressing -
    * back button two times
    * */
    override fun onBackPressed() {
        if (exit) {
            gotoActivityWithNoHistory(LoginActivity::class.java)
        } else {
            Toast.makeText(this, "Press back again to exit",
                    Toast.LENGTH_SHORT).show()
            exit = true
            Handler(Looper.getMainLooper()).postDelayed({ exit = false }, 3000)
        }
    }

    /*
    * Inflate menu on current activity
    * */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        if (MainApp.admin) menu.findItem(R.id.action_database).isVisible = true
        return true
    }

    /*
    * Menu items selection
    * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_data_sync -> {
                if (isNetworkConnected(this)) {
                    gotoActivity(SyncActivity::class.java)

                } else
                    Toast.makeText(this, "Network connection not available!", Toast.LENGTH_SHORT).show()

                return true
            }
            R.id.formsReportDate -> {
                gotoActivity(FormsReportDate::class.java)
                return true
            }            R.id.lhwsReportDate -> {
                gotoActivity(HHIDReportDate::class.java)
                return true
            }
    R.id.formsReportPending -> {
                gotoActivity(FormsReportPending::class.java)
                return true
            }

            R.id.formsReportCluster -> {
                gotoActivity(FormsReportLHW::class.java)
                return true
            }
            R.id.action_database -> {
                gotoActivity(AndroidManager::class.java)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }




    /*
    * Route to specific activity according to selection
    * For uploading/downloading data, the network needs to work
    * */
    fun openSpecificActivity(v: View) {
        if(MainApp.user.userName!=null) {
            when (v.id) {
                R.id.registerLHW -> gotoActivity(SectionLHWActivity::class.java)
                R.id.openForm -> gotoActivity(SectionHHVerifyActivity::class.java)
                R.id.btn01 -> gotoActivity(SectionAdolActivity::class.java)
                R.id.btn02 -> gotoActivity(SectionHHIdentifyActivity::class.java)
                R.id.btn03 -> gotoActivity(SectionHHVerifyActivity::class.java)
                R.id.btn04 -> gotoActivity(SectionLHWActivity::class.java)
                R.id.btn05 -> gotoActivity(SectionMemberInfoActivity::class.java)
                R.id.btn06 -> gotoActivity(SectionMWRAActivity::class.java)
                R.id.btn07 -> gotoActivity(SectionVHCActivity::class.java)
                R.id.btn08 -> gotoActivity(SectionVHCActivity::class.java)
                R.id.databaseBtn -> startActivity(Intent(this, AndroidManager::class.java))
            }
        } else {
            Toast.makeText(this, "* * * * * Invalid user! * * * * *", Toast.LENGTH_SHORT).show()
        }
    }



    fun openForm(view: View) {}


}