package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
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
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySectionVhcBinding
import edu.aku.hassannaqvi.smk_ce.ui.EndingActivity
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity

class SectionVHCActivity : AppCompatActivity() {

    lateinit var bi: ActivitySectionVhcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_vhc)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setupSkips()
    }


    private fun setupSkips() {
        rgLsnr(bi.vhc01, bi.vhc01b, arrayOf(bi.fldGrpCVvhc02, bi.fldGrpCVvhc03, bi.fldGrpCVvhc04, bi.fldGrpCVvhc05, bi.fldGrpCVvhc06))
        rgLsnr(bi.vhc02, bi.vhc02b, arrayOf(bi.fldGrpCVvhc03, bi.fldGrpCVvhc04, bi.fldGrpCVvhc05, bi.fldGrpCVvhc06))
        rgLsnr(bi.vhc03, bi.vhc03b, arrayOf(bi.fldGrpCVvhc04, bi.fldGrpCVvhc05))
        rgLsnr(bi.vhc05, bi.vhc05a, arrayOf(bi.fldGrpCVvhc06))

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


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val count = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SB, MainApp.form.sBtoString())
        return if (count > 0) true
        else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show()
            false
        }
    }


    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            finish()
            startActivity(Intent(this, EndingActivity::class.java).putExtra("complete", true))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {

        MainApp.form.vhc01 = when {
            bi.vhc01a.isChecked -> "1"
            bi.vhc01b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.vhc02 = when {
            bi.vhc02a.isChecked -> "1"
            bi.vhc02b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.vhc03 = when {
            bi.vhc03a.isChecked -> "1"
            bi.vhc03b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.vhc04 = when {
            bi.vhc04a.isChecked -> "1"
            bi.vhc04b.isChecked -> "2"
            bi.vhc04c.isChecked -> "3"
            else -> "-1"
        }

        MainApp.form.vhc05 = when {
            bi.vhc05a.isChecked -> "1"
            bi.vhc05b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.vhc06a = if (bi.vhc06a.isChecked) "1" else "-1"
        MainApp.form.vhc06b = if (bi.vhc06b.isChecked) "2" else "-1"
        MainApp.form.vhc06c = if (bi.vhc06c.isChecked) "3" else "-1"
        MainApp.form.vhc06d = if (bi.vhc06d.isChecked) "4" else "-1"
        MainApp.form.vhc06e = if (bi.vhc06e.isChecked) "5" else "-1"
        MainApp.form.vhc06f = if (bi.vhc06f.isChecked) "6" else "-1"
        MainApp.form.vhc06g = if (bi.vhc06g.isChecked) "7" else "-1"
        MainApp.form.vhc06h = if (bi.vhc06h.isChecked) "8" else "-1"
        MainApp.form.vhc06i = if (bi.vhc06i.isChecked) "9" else "-1"
        MainApp.form.vhc06j = if (bi.vhc06j.isChecked) "10" else "-1"
        MainApp.form.vhc0696 = if (bi.vhc0696.isChecked) "96" else "-1"

        MainApp.form.vhc0696x = when {
            bi.vhc0696x.text.toString().trim().isNotEmpty() -> bi.vhc0696x.text.toString()
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


}