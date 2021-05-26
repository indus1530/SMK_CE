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
import edu.aku.hassannaqvi.smk_ce.contracts.HHMembersContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.hhmem
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection02Binding
import edu.aku.hassannaqvi.smk_ce.models.HHMembersModel
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


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addHHMembers(hhmem)
        return if (updcount > 0) {
            hhmem.id = updcount.toString()
            hhmem.uid = hhmem.deviceId + hhmem.id
            var count = db.updatesHHMemColumn(HHMembersContract.HHMembersTable.COLUMN_UID, hhmem.uid)
            if (count > 0) count = db.updatesHHMemColumn(HHMembersContract.HHMembersTable.COLUMN_SA, hhmem.sAtoString())
            if (count > 0) true else {
                Toast.makeText(this, "SORRY!! Failed to update DB", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show()
            false
        }
    }


    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            finish()
            startActivity(Intent(this, Section03Activity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {

        hhmem = HHMembersModel()
        hhmem.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        hhmem.uuid = MainApp.form.uid
        hhmem.userName = MainApp.user.userName
        hhmem.districtCode = MainApp.form.districtCode
        hhmem.districtName = MainApp.form.districtName
        hhmem.tehsilCode = MainApp.form.tehsilCode
        hhmem.tehsilName = MainApp.form.tehsilName
        hhmem.lhwCode = MainApp.form.lhwCode
        hhmem.lhwName = MainApp.form.lhwName
        hhmem.khandanNumber = MainApp.form.khandanNumber
        hhmem.deviceId = MainApp.appInfo.deviceID
        hhmem.deviceTag = MainApp.appInfo.tagName
        hhmem.appver = MainApp.appInfo.appVersion

        hhmem.hh01 = when {
            bi.hh01.text.toString().trim().isNotEmpty() -> bi.hh01.text.toString()
            else -> "-1"
        }

        hhmem.hh02 = when {
            bi.hh02.text.toString().trim().isNotEmpty() -> bi.hh02.text.toString()
            else -> "-1"
        }

        hhmem.hh03 = when {
            bi.hh03a.isChecked -> "1"
            bi.hh03b.isChecked -> "2"
            else -> "-1"
        }

        hhmem.hh04a = when {
            bi.hh04a.text.toString().trim().isNotEmpty() -> bi.hh04a.text.toString()
            else -> "-1"
        }

        hhmem.hh04b = when {
            bi.hh04b.text.toString().trim().isNotEmpty() -> bi.hh04b.text.toString()
            else -> "-1"
        }

        hhmem.hh04c = when {
            bi.hh04c.text.toString().trim().isNotEmpty() -> bi.hh04c.text.toString()
            else -> "-1"
        }

        hhmem.hh05y = when {
            bi.hh05y.text.toString().trim().isNotEmpty() -> bi.hh05y.text.toString()
            else -> "-1"
        }

        hhmem.hh05m = when {
            bi.hh05m.text.toString().trim().isNotEmpty() -> bi.hh05m.text.toString()
            else -> "-1"
        }

        hhmem.hh06 = when {
            bi.hh06a.isChecked -> "1"
            bi.hh06b.isChecked -> "2"
            bi.hh06c.isChecked -> "3"
            bi.hh06d.isChecked -> "4"
            else -> "-1"
        }

        hhmem.hh07 = when {
            bi.hh07.text.toString().trim().isNotEmpty() -> bi.hh07.text.toString()
            else -> "-1"
        }

        hhmem.hh08 = when {
            bi.hh08.text.toString().trim().isNotEmpty() -> bi.hh08.text.toString()
            else -> "-1"
        }

        hhmem.hh09 = when {
            bi.hh09a.isChecked -> "1"
            bi.hh09b.isChecked -> "2"
            bi.hh09c.isChecked -> "3"
            bi.hh09d.isChecked -> "4"
            bi.hh09e.isChecked -> "5"
            bi.hh09f.isChecked -> "6"
            bi.hh09g.isChecked -> "7"
            bi.hh09h.isChecked -> "8"
            bi.hh09i.isChecked -> "9"
            bi.hh09j.isChecked -> "10"
            bi.hh09k.isChecked -> "11"
            bi.hh09l.isChecked -> "98"
            bi.hh09m.isChecked -> "99"
            else -> "-1"
        }

        hhmem.hh10 = when {
            bi.hh10a.isChecked -> "1"
            bi.hh10b.isChecked -> "2"
            bi.hh10c.isChecked -> "3"
            bi.hh10d.isChecked -> "4"
            bi.hh10e.isChecked -> "5"
            bi.hh10f.isChecked -> "6"
            bi.hh10g.isChecked -> "7"
            bi.hh10h.isChecked -> "8"
            bi.hh10i.isChecked -> "98"
            bi.hh10j.isChecked -> "99"
            else -> "-1"
        }

        hhmem.hh11 = when {
            bi.hh11a.isChecked -> "1"
            bi.hh11b.isChecked -> "2"
            else -> "-1"
        }


    }


    fun BtnEnd(view: View) {
        //openSectionMainActivity(this, "G")
        finish()
        startActivity(Intent(this, MainActivity::class.java))
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