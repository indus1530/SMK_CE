package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Clear
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection03Binding
import edu.aku.hassannaqvi.smk_ce.models.Form
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section03 : AppCompatActivity() {

    lateinit var bi: ActivitySection03Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section03)
        bi.callback
        setSupportActionBar(bi.toolbar)
        setupSkips()
    }


    private fun setupSkips() {

        //bi.chkWeight.setOnCheckedChangeListener { compoundButton, b -> Clear.clearAllFields(bi.mh012, !b) }


        bi.mwra04.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(bi.mwra04.text)) return
                if (bi.mwra04.text.toString().toInt() == 0) {
                    Clear.clearAllFields(bi.fldGrpCVmwra05)
                    bi.fldGrpCVmwra05.visibility = View.GONE
                } else {
                    bi.fldGrpCVmwra05.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })


        bi.mwra16.setOnCheckedChangeListener { radioGroup, i ->
            Clear.clearAllFields(bi.fldGrpCVmwra17)
            Clear.clearAllFields(bi.fldGrpCVmwra18)
            Clear.clearAllFields(bi.fldGrpCVmwra19)
            Clear.clearAllFields(bi.fldGrpCVmwra20)
            bi.fldGrpCVmwra17.visibility = View.GONE
            bi.fldGrpCVmwra18.visibility = View.GONE
            bi.fldGrpCVmwra19.visibility = View.GONE
            bi.fldGrpCVmwra20.visibility = View.GONE
            if (i == bi.mwra16a.id) bi.fldGrpCVmwra20.visibility = View.VISIBLE
            else {
                bi.fldGrpCVmwra17.visibility = View.VISIBLE
                bi.fldGrpCVmwra18.visibility = View.VISIBLE
                bi.fldGrpCVmwra19.visibility = View.VISIBLE
            }
        }


        rgLsnr(bi.mwra03, bi.mwra03b, arrayOf(bi.fldGrpCVmwra04))
        rgLsnr(bi.mwra07, bi.mwra07b, arrayOf(bi.fldGrpCVmwra08))
        rgLsnr(bi.mwra09, bi.mwra09b, arrayOf(bi.fldGrpCVmwra10, bi.fldGrpCVmwra11, bi.fldGrpCVmwra12))
        rgLsnr(bi.mwra11, bi.mwra11b, arrayOf(bi.fldGrpCVmwra12))
        rgLsnr(bi.mwra13, bi.mwra13b, arrayOf(bi.fldGrpCVmwra14, bi.fldGrpCVmwra15, bi.fldGrpCVmwra16, bi.fldGrpCVmwra17))
        rgLsnr(bi.mwra19, bi.mwra19b, arrayOf(bi.fldGrpCVmwra20))
        rgLsnr(bi.mwra21, bi.mwra21b, arrayOf(bi.fldGrpCVmwra22))
        rgLsnr(bi.mwra22, bi.mwra22a, arrayOf(bi.fldGrpCVmwra23))

    }


    private fun rgLsnr(rg: RadioGroup, rb: RadioButton, vgArray: Array<ViewGroup>) {
        rg.setOnCheckedChangeListener { radioGroup, i ->
            vgArray.forEach {
                Clear.clearAllFields(it)
                it.visibility = View.VISIBLE
                if (i == rb.id) it.visibility = View.GONE
            }
        }
    }


    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {
        MainApp.form = Form()
        MainApp.form.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        /*form.setUuid(MainApp.form.getUid())
        form.setUserName(MainApp.user.getUserName())
        form.setDcode(MainApp.form.getDcode())
        form.setUcode(MainApp.form.getUcode())
        form.setCluster(MainApp.form.getCluster())
        form.setHhno(MainApp.form.getHhno())
        form.setDeviceId(MainApp.appInfo.getDeviceID())
        form.setDeviceTag(MainApp.appInfo.getTagName())
        form.setAppver(MainApp.appInfo.getAppVersion())
        form.setMh01(if (bi.mh01.getText().toString().trim().isEmpty()) "-1" else bi.mh01.getText().toString())
        form.setMh02(if (bi.mh02.getText().toString().trim().isEmpty()) "-1" else bi.mh02.getText().toString())
        form.setMh03(if (bi.mh03.getText().toString().trim().isEmpty()) "-1" else bi.mh03.getText().toString())
        form.setMh04(if (bi.mh04.getText().toString().trim().isEmpty()) "-1" else bi.mh04.getText().toString())
        form.setMh05(if (bi.mh05.getText().toString().trim().isEmpty()) "-1" else bi.mh05.getText().toString())*/
    }


    fun BtnEnd(view: View) {
        //openSectionMainActivity(this, "G")
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }


    private fun updateDB(): Boolean {
        /*val db = MainApp.appInfo.dbHelper
        if (!MainApp.childInformation.isEditFlag) {
            val updcount = db.addChildInformation(MainApp.childInformation)
            return if (updcount > 0) {
                MainApp.childInformation.id = updcount.toString()
                MainApp.childInformation.uid = MainApp.childInformation.deviceId + MainApp.childInformation.id
                var count = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_UID, MainApp.childInformation.uid)
                if (count > 0) count = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_SCB, MainApp.childInformation.sCBtoString())
                if (count > 0) true else {
                    Toast.makeText(this, "Sorry. You can't go further.\n" +
                            " Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
                    false
                }
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            val updcount = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_SCB, MainApp.childInformation.sCBtoString())
            return if (updcount > 0) true else {
                Toast.makeText(this, "Sorry. You can't go further.\n" +
                        " Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
                false
            }
        }*/ return true
    }


    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }


}