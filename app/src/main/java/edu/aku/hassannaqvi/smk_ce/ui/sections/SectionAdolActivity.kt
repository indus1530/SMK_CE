package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Clear
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.ADOLContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.adol
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySectionAdolBinding
import edu.aku.hassannaqvi.smk_ce.models.ADOLModel
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class SectionAdolActivity : AppCompatActivity() {

    lateinit var bi: ActivitySectionAdolBinding
    var position: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_adol)
        bi.callback
        setSupportActionBar(bi.toolbar)
        setupSkips()

        position = MainApp.selectedFemale.toString()


        bi.adol01.setText(MainApp.fm[position.toInt()].hh02.toString())
        bi.adol02.setText(MainApp.fm[position.toInt()].hh05y.toString())
    }


    private fun setupSkips() {
        rgLsnr(bi.adol05, bi.adol05b, arrayOf(bi.fldGrpCVadol06, bi.fldGrpCVadol07))
        bi.adol04h.setOnCheckedChangeListener { compoundButton, b -> Clear.clearAllFields(bi.adol04check, !b) }
        cbLsnr(bi.adol15d, bi.adol15e)
        cbLsnr(bi.adol15e, bi.adol15d)

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


    private fun cbLsnr(cb1: CheckBox, cb2: CheckBox) {
        cb1.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                Clear.clearAllFields(bi.adol15check, false)
                cb2.isEnabled = false
            } else {
                Clear.clearAllFields(bi.adol15check, true)
                cb2.isEnabled = true
            }
        }
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addADOL(adol)
        return if (updcount > 0) {
            adol.id = updcount.toString()
            adol.uid = adol.deviceId + adol.id
            db.updatesADOLColumn(ADOLContract.ADOLTable.COLUMN_UID, adol.uid) // updates UID in ADOL table
            db.updatesFemaleMemberbyUUID(adol.fmid) // Updates status in Family members table
            MainApp.fm[position.toInt()].status = "1"
            true
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show()
            false
        }
    }


    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            setResult(Activity.RESULT_OK);
            finish()
            //startActivity(Intent(this, FemaleMembersActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {

        adol = ADOLModel()

        adol.position = position

        adol.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        adol.uuid = MainApp.form.uid
        adol.fmid = MainApp.fm.get(position.toInt()).uid
        adol.userName = MainApp.user.userName
        adol.districtCode = MainApp.form.hfCode
        adol.districtName = MainApp.form.hfName
        adol.tehsilCode = MainApp.form.tehsilCode
        adol.tehsilName = MainApp.form.tehsilName
        adol.lhwCode = MainApp.form.lhwCode
        adol.lhwName = MainApp.form.lhwName
        adol.khandanNumber = MainApp.form.khandanNumber
        adol.deviceId = MainApp.appInfo.deviceID
        adol.deviceTag = MainApp.appInfo.tagName
        adol.appver = MainApp.appInfo.appVersion
        adol.status = "1"

        adol.adol01 = when {
            bi.adol01.text.toString().trim().isNotEmpty() -> bi.adol01.text.toString()
            else -> "-1"
        }

        adol.adol02 = when {
            bi.adol02.text.toString().trim().isNotEmpty() -> bi.adol02.text.toString()
            else -> "-1"
        }

        adol.adol03 = when {
            bi.adol03a.isChecked -> "1"
            bi.adol03b.isChecked -> "2"
            else -> "-1"
        }

        adol.adol04a = if (bi.adol04a.isChecked) "1" else "-1"
        adol.adol04b = if (bi.adol04b.isChecked) "2" else "-1"
        adol.adol04c = if (bi.adol04c.isChecked) "3" else "-1"
        adol.adol04d = if (bi.adol04d.isChecked) "4" else "-1"
        adol.adol04e = if (bi.adol04e.isChecked) "5" else "-1"
        adol.adol04f = if (bi.adol04f.isChecked) "6" else "-1"
        adol.adol04g = if (bi.adol04g.isChecked) "7" else "-1"
        adol.adol04h = if (bi.adol04h.isChecked) "8" else "-1"
        adol.adol0496 = if (bi.adol0496.isChecked) "96" else "-1"

        adol.adol0496x = when {
            bi.adol0496x.text.toString().trim().isNotEmpty() -> bi.adol0496x.text.toString()
            else -> "-1"
        }

        adol.adol05 = when {
            bi.adol05a.isChecked -> "1"
            bi.adol05b.isChecked -> "2"
            else -> "-1"
        }

        adol.adol06a = if (bi.adol06a.isChecked) "1" else "-1"
        adol.adol06b = if (bi.adol06b.isChecked) "2" else "-1"
        adol.adol06c = if (bi.adol06c.isChecked) "3" else "-1"
        adol.adol06d = if (bi.adol06d.isChecked) "4" else "-1"
        adol.adol0696 = if (bi.adol0696.isChecked) "96" else "-1"

        adol.adol0696x = when {
            bi.adol0696x.text.toString().trim().isNotEmpty() -> bi.adol0696x.text.toString()
            else -> "-1"
        }

        adol.adol07 = when {
            bi.adol07a.isChecked -> "1"
            bi.adol07b.isChecked -> "2"
            else -> "-1"
        }

        adol.adol08 = when {
            bi.adol08a.isChecked -> "1"
            bi.adol08b.isChecked -> "2"
            else -> "-1"
        }

        adol.adol09 = when {
            bi.adol09a.isChecked -> "1"
            bi.adol09b.isChecked -> "2"
            else -> "-1"
        }

        adol.adol10a = if (bi.adol10a.isChecked) "1" else "-1"
        adol.adol10b = if (bi.adol10b.isChecked) "2" else "-1"
        adol.adol10c = if (bi.adol10c.isChecked) "3" else "-1"
        adol.adol10d = if (bi.adol10d.isChecked) "4" else "-1"
        adol.adol10e = if (bi.adol10e.isChecked) "5" else "-1"
        adol.adol10f = if (bi.adol10f.isChecked) "6" else "-1"
        adol.adol10g = if (bi.adol10g.isChecked) "7" else "-1"
        adol.adol10h = if (bi.adol10h.isChecked) "8" else "-1"
        adol.adol10i = if (bi.adol10i.isChecked) "9" else "-1"
        adol.adol10j = if (bi.adol10j.isChecked) "10" else "-1"
        adol.adol1096 = if (bi.adol1096.isChecked) "96" else "-1"

        adol.adol1096x = when {
            bi.adol1096x.text.toString().trim().isNotEmpty() -> bi.adol1096x.text.toString()
            else -> "-1"
        }

        adol.adol11 = when {
            bi.adol11a.isChecked -> "1"
            bi.adol11b.isChecked -> "2"
            bi.adol1196.isChecked -> "96"
            else -> "-1"
        }

        adol.adol1196x = when {
            bi.adol1196x.text.toString().trim().isNotEmpty() -> bi.adol1196x.text.toString()
            else -> "-1"
        }

        adol.adol12a = if (bi.adol12a.isChecked) "1" else "-1"
        adol.adol12b = if (bi.adol12b.isChecked) "2" else "-1"
        adol.adol12c = if (bi.adol12c.isChecked) "3" else "-1"
        adol.adol12d = if (bi.adol12d.isChecked) "4" else "-1"
        adol.adol1296 = if (bi.adol1296.isChecked) "96" else "-1"

        adol.adol1296x = when {
            bi.adol1296x.text.toString().trim().isNotEmpty() -> bi.adol1296x.text.toString()
            else -> "-1"
        }

        adol.adol13 = when {
            bi.adol13a.isChecked -> "1"
            bi.adol13b.isChecked -> "2"
            else -> "-1"
        }

        adol.adol14 = when {
            bi.adol14a.isChecked -> "1"
            bi.adol14b.isChecked -> "2"
            bi.adol14c.isChecked -> "98"
            else -> "-1"
        }

        adol.adol15a = if (bi.adol15a.isChecked) "1" else "-1"
        adol.adol15b = if (bi.adol15b.isChecked) "2" else "-1"
        adol.adol15c = if (bi.adol15c.isChecked) "3" else "-1"
        adol.adol15d = if (bi.adol15d.isChecked) "4" else "-1"
        adol.adol15e = if (bi.adol15e.isChecked) "98" else "-1"
        adol.adol1596 = if (bi.adol1596.isChecked) "96" else "-1"

        adol.adol1596x = when {
            bi.adol1596x.text.toString().trim().isNotEmpty() -> bi.adol1596x.text.toString()
            else -> "-1"
        }

    }


    fun BtnEnd(view: View) {
        //openSectionMainActivity(this, "G")
        setResult(Activity.RESULT_CANCELED)
        finish()
    }


    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }


}