package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection02Binding
import edu.aku.hassannaqvi.smk_ce.models.Form
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section02Activity : AppCompatActivity() {

    lateinit var bi: ActivitySection02Binding
    var dtFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section02)
        bi.callback = this
        setSupportActionBar(bi.toolbar)


        val txtListener = arrayOf<EditText>(bi.hh04a, bi.hh04b)
        for (txtItem in txtListener) {
            txtItem.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    bi.hh05y.text = null
                    bi.hh05m.text = null
                    bi.hh04c.text = null
                }

                override fun afterTextChanged(s: Editable) {}
            })
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


    fun hh04OnTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        segregate()
        /*Clear.clearAllFields(bi.fldGrpCVhh04, false)
        bi.fldGrpCVmh017.setVisibility(View.GONE)
        bi.llmh020.setVisibility(View.GONE)
        bi.fldGrpCVmh015.setVisibility(View.GONE)
        bi.fldGrpCVmh016.setVisibility(View.GONE)
        bi.fldGrpCVmh018.setVisibility(View.GONE)
        bi.llchild.setVisibility(View.GONE)
        patientType = "General"
        if (age >= 5110 && age < 18250 && bi.mh01002.isChecked()) {
            bi.fldGrpCVmh017.setVisibility(View.VISIBLE)
            bi.llmh020.setVisibility(View.VISIBLE)
            patientType = "MWRA"
        }
        if (age <= 1825) {
            bi.fldGrpCVmh015.setVisibility(View.VISIBLE)
            bi.fldGrpCVmh016.setVisibility(View.VISIBLE)
            bi.fldGrpCVmh018.setVisibility(View.VISIBLE)
            bi.llchild.setVisibility(View.VISIBLE)
            bi.mh012.setMinvalue(0.9f)
            bi.mh012.setMaxvalue(58f)
            bi.mh012.setMask("###.#")
            bi.mh012.setHint("###.#")
            patientType = "Child"
        }*/
    }

    private fun segregate() {

        /*var age: Int = 0
        Clear.clearAllFields(bi.fldGrpCVhh05, false)
        if (TextUtils.isEmpty(bi.hh04a.text) || TextUtils.isEmpty(bi.hh04b.text) || TextUtils.isEmpty(bi.hh04c.text)) return

        if ((bi.hh04a.text.toString() == "98" && bi.hh04b.text.toString() == "98" && bi.hh04c.text.toString() == "9998")) {
            Clear.clearAllFields(bi.fldGrpCVhh05, true)
        } else {
            age = bi.hh04a.text.toString().toInt() + bi.hh04b.text.toString().toInt() * 29 + bi.hh04c.text.toString().toInt() * 365
        }

        if (age in 1.. 5475) {
            Clear.clearAllFields(bi.llhh05)
            bi.llhh05.visibility = View.GONE
        } else {
            bi.llhh05.visibility = View.VISIBLE
        }*/
    }


}