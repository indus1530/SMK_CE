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
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection04Binding
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity

class Section04Activity : AppCompatActivity() {

    lateinit var bi: ActivitySection04Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section04)
        bi.callback
        setSupportActionBar(bi.toolbar)
        setupSkips()
    }


    private fun setupSkips() {
        rgLsnr(bi.adol05, bi.adol05b, arrayOf(bi.fldGrpCVadol06, bi.fldGrpCVadol07))

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
        val count = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SD, MainApp.form.sDtoString())
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
            startActivity(Intent(this, Section05Activity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {

        MainApp.form.adol01 = when {
            bi.adol01.text.toString().trim().isNotEmpty() -> bi.adol01.text.toString()
            else -> "-1"
        }

        MainApp.form.adol02 = when {
            bi.adol02.text.toString().trim().isNotEmpty() -> bi.adol02.text.toString()
            else -> "-1"
        }

        MainApp.form.adol03 = when {
            bi.adol03a.isChecked -> "1"
            bi.adol03b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.adol04a = if (bi.adol04a.isChecked) "1" else "-1"
        MainApp.form.adol04b = if (bi.adol04b.isChecked) "2" else "-1"
        MainApp.form.adol04c = if (bi.adol04c.isChecked) "3" else "-1"
        MainApp.form.adol04d = if (bi.adol04d.isChecked) "4" else "-1"
        MainApp.form.adol04e = if (bi.adol04e.isChecked) "5" else "-1"
        MainApp.form.adol04f = if (bi.adol04f.isChecked) "6" else "-1"
        MainApp.form.adol04g = if (bi.adol04g.isChecked) "7" else "-1"
        MainApp.form.adol04h = if (bi.adol04h.isChecked) "8" else "-1"
        MainApp.form.adol0496 = if (bi.adol0496.isChecked) "96" else "-1"

        MainApp.form.adol0496x = when {
            bi.adol0496x.text.toString().trim().isNotEmpty() -> bi.adol0496x.text.toString()
            else -> "-1"
        }

        MainApp.form.adol05 = when {
            bi.adol05a.isChecked -> "1"
            bi.adol05b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.adol06a = if (bi.adol06a.isChecked) "1" else "-1"
        MainApp.form.adol06b = if (bi.adol06b.isChecked) "2" else "-1"
        MainApp.form.adol06c = if (bi.adol06c.isChecked) "3" else "-1"
        MainApp.form.adol06d = if (bi.adol06d.isChecked) "4" else "-1"
        MainApp.form.adol0696 = if (bi.adol0696.isChecked) "96" else "-1"

        MainApp.form.adol0696x = when {
            bi.adol0696x.text.toString().trim().isNotEmpty() -> bi.adol0696x.text.toString()
            else -> "-1"
        }

        MainApp.form.adol07 = when {
            bi.adol07a.isChecked -> "1"
            bi.adol07b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.adol08 = when {
            bi.adol08a.isChecked -> "1"
            bi.adol08b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.adol09 = when {
            bi.adol09a.isChecked -> "1"
            bi.adol09b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.adol10a = if (bi.adol10a.isChecked) "1" else "-1"
        MainApp.form.adol10b = if (bi.adol10b.isChecked) "2" else "-1"
        MainApp.form.adol10c = if (bi.adol10c.isChecked) "3" else "-1"
        MainApp.form.adol10d = if (bi.adol10d.isChecked) "4" else "-1"
        MainApp.form.adol10e = if (bi.adol10e.isChecked) "5" else "-1"
        MainApp.form.adol10f = if (bi.adol10f.isChecked) "6" else "-1"
        MainApp.form.adol10g = if (bi.adol10g.isChecked) "7" else "-1"
        MainApp.form.adol10h = if (bi.adol10h.isChecked) "8" else "-1"
        MainApp.form.adol10i = if (bi.adol10i.isChecked) "9" else "-1"
        MainApp.form.adol10j = if (bi.adol10j.isChecked) "10" else "-1"
        MainApp.form.adol1096 = if (bi.adol1096.isChecked) "96" else "-1"

        MainApp.form.adol1096x = when {
            bi.adol1096x.text.toString().trim().isNotEmpty() -> bi.adol1096x.text.toString()
            else -> "-1"
        }

        MainApp.form.adol11 = when {
            bi.adol11a.isChecked -> "1"
            bi.adol11b.isChecked -> "2"
            bi.adol1196.isChecked -> "96"
            else -> "-1"
        }

        MainApp.form.adol1196x = when {
            bi.adol1196x.text.toString().trim().isNotEmpty() -> bi.adol1196x.text.toString()
            else -> "-1"
        }

        MainApp.form.adol12a = if (bi.adol12a.isChecked) "1" else "-1"
        MainApp.form.adol12b = if (bi.adol12b.isChecked) "2" else "-1"
        MainApp.form.adol12c = if (bi.adol12c.isChecked) "3" else "-1"
        MainApp.form.adol12d = if (bi.adol12d.isChecked) "4" else "-1"
        MainApp.form.adol1296 = if (bi.adol1296.isChecked) "96" else "-1"

        MainApp.form.adol1296x = when {
            bi.adol1296x.text.toString().trim().isNotEmpty() -> bi.adol1296x.text.toString()
            else -> "-1"
        }

        MainApp.form.adol13 = when {
            bi.adol13a.isChecked -> "1"
            bi.adol13b.isChecked -> "2"
            else -> "-1"
        }

        MainApp.form.adol14 = when {
            bi.adol14a.isChecked -> "1"
            bi.adol14b.isChecked -> "2"
            bi.adol14c.isChecked -> "98"
            else -> "-1"
        }

        MainApp.form.adol15a = if (bi.adol15a.isChecked) "1" else "-1"
        MainApp.form.adol15b = if (bi.adol15b.isChecked) "2" else "-1"
        MainApp.form.adol15c = if (bi.adol15c.isChecked) "3" else "-1"
        MainApp.form.adol15d = if (bi.adol15d.isChecked) "4" else "-1"
        MainApp.form.adol15e = if (bi.adol15e.isChecked) "98" else "-1"
        MainApp.form.adol1596 = if (bi.adol1596.isChecked) "96" else "-1"

        MainApp.form.adol1596x = when {
            bi.adol1596x.text.toString().trim().isNotEmpty() -> bi.adol1596x.text.toString()
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