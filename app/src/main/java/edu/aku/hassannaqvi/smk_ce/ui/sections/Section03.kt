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


        /*bi.mwra03.setOnCheckedChangeListener { radioGroup, i ->
            if (i == bi.mwra03b.id) {
                Clear.clearAllFields(bi.fldGrpCVmwra04)
                bi.fldGrpCVmwra04.visibility = View.GONE
            } else {
                bi.fldGrpCVmwra04.visibility = View.VISIBLE
            }
        }*/

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


        bi.mwra07.setOnCheckedChangeListener { radioGroup, i ->
            if (i == bi.mwra07b.id) {
                Clear.clearAllFields(bi.fldGrpCVmwra08)
                bi.fldGrpCVmwra08.visibility = View.GONE
            } else {
                bi.fldGrpCVmwra08.visibility = View.VISIBLE
            }
        }


        bi.mwra09.setOnCheckedChangeListener { radioGroup, i ->
            if (i == bi.mwra09b.id) {
                Clear.clearAllFields(bi.llmwra09)
                bi.llmwra09.visibility = View.GONE
            } else {
                bi.llmwra09.visibility = View.VISIBLE
            }
        }


        bi.mwra11.setOnCheckedChangeListener { radioGroup, i ->
            if (i == bi.mwra11b.id) {
                Clear.clearAllFields(bi.fldGrpCVmwra12)
                bi.fldGrpCVmwra12.visibility = View.GONE
            } else {
                bi.fldGrpCVmwra12.visibility = View.VISIBLE
            }
        }


        bi.mwra13.setOnCheckedChangeListener { radioGroup, i ->
            if (i == bi.mwra13b.id) {
                Clear.clearAllFields(bi.llmwra13)
                bi.llmwra13.visibility = View.GONE
            } else {
                bi.llmwra13.visibility = View.VISIBLE
            }
        }

        rgLsnr(bi.mwra03, bi.mwra03b, bi.fldGrpCVmwra04)

    }


    private fun rgLsnr(rg: RadioGroup, rb: RadioButton, vg: ViewGroup) {
        rg.setOnCheckedChangeListener { radioGroup, i ->
            Clear.clearAllFields(vg)
            vg.visibility = View.VISIBLE
            if (i == rb.id) vg.visibility = View.GONE
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