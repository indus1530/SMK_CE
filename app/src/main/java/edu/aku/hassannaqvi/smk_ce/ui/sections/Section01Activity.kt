package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.form
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01Binding
import edu.aku.hassannaqvi.smk_ce.models.Districts
import edu.aku.hassannaqvi.smk_ce.models.Form
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section01Activity : AppCompatActivity() {

    lateinit var bi: ActivitySection01Binding
    var district = mutableListOf("....")
    var districtCode = mutableListOf<String>()
    var uc = mutableListOf("....")
    var ucCode = mutableListOf<String>()
    lateinit var districtAdapter: ArrayAdapter<String>
    lateinit var ucAdapter: ArrayAdapter<String>
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        populateSpinner(this)
        setupSkips()

    }

    private fun setupSkips() {
    }


    private fun populateSpinner(context: Context) {
        db = MainApp.appInfo.dbHelper

        var dcs: ArrayList<Districts> = db.allDistricts
        /*for (dc in dcs) {
            district.add(dc.districtName)
            districtCode.add(dc.districtCode)
        }*/

        dcs.forEach {
            district.add(it.districtName)
            districtCode.add(it.districtCode)
        }

        bi.lhw01.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, district)
        //bi.lhw01.adapter = districtAdapter
        ucAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, uc)
        bi.lhw02.adapter = ucAdapter

        bi.lhw01.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.lhw02.setSelection(0)
                if (position == 0) {
                    bi.lhw02.isEnabled = false
                    return
                }
                bi.lhw02.isEnabled = true
                uc.clear()
                ucCode.clear()
                uc.add("....")
                //viewModel.getUCsDistrictFromDB(districtCode[position - 1])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addForm(form)
        return if (updcount > 0) {
            form.id = updcount.toString()
            form.uid = form.deviceId + form.id
            var count = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.uid)
            if (count > 0) count = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SA, form.sAtoString())
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
            startActivity(Intent(this, Section02Activity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {
        form = Form()
        form.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        form.uid = form.uid
        form.userName = MainApp.user.userName
        form.dcode = form.dcode
        form.ucode = form.ucode
        form.cluster = form.cluster
        form.hhno = form.hhno
        form.deviceId = MainApp.appInfo.deviceID
        form.deviceTag = MainApp.appInfo.tagName
        form.appver = MainApp.appInfo.appVersion

        form.lhw01 = bi.lhw01.selectedItem.toString()
        form.lhw02 = bi.lhw02.selectedItem.toString()
        form.lhw03 = bi.lhw03.selectedItem.toString()

        form.lhw04 = when {
            bi.lhw04.text.toString().trim().isNotEmpty() -> bi.lhw04.text.toString()
            else -> "-1"
        }

        form.hhi01 = when {
            bi.hhi01.text.toString().trim().isNotEmpty() -> bi.hhi01.text.toString()
            else -> "-1"
        }

        form.hhi02 = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
            else -> "-1"
        }

        form.hhi03 = when {
            bi.hhi03.text.toString().trim().isNotEmpty() -> bi.hhi03.text.toString()
            else -> "-1"
        }

        form.hhi04a = when {
            bi.hhi04a.text.toString().trim().isNotEmpty() -> bi.hhi04a.text.toString()
            else -> "-1"
        }

        form.hhi04b = when {
            bi.hhi04b.text.toString().trim().isNotEmpty() -> bi.hhi04b.text.toString()
            else -> "-1"
        }

        form.hhi04c = when {
            bi.hhi04c.text.toString().trim().isNotEmpty() -> bi.hhi04c.text.toString()
            else -> "-1"
        }

        form.hhi04d = when {
            bi.hhi04d.text.toString().trim().isNotEmpty() -> bi.hhi04d.text.toString()
            else -> "-1"
        }

        form.hhi04e = when {
            bi.hhi04e.text.toString().trim().isNotEmpty() -> bi.hhi04e.text.toString()
            else -> "-1"
        }

        form.hhi04f = when {
            bi.hhi04f.text.toString().trim().isNotEmpty() -> bi.hhi04f.text.toString()
            else -> "-1"
        }

        form.lhwphoto = when {
            bi.lhwphoto.text.toString().trim().isNotEmpty() -> bi.lhwphoto.text.toString()
            else -> "-1"
        }

        form.hhv01 = when {
            bi.hhv01.text.toString().trim().isNotEmpty() -> bi.hhv01.text.toString()
            else -> "-1"
        }

        form.hhv02 = when {
            bi.hhv02.text.toString().trim().isNotEmpty() -> bi.hhv02.text.toString()
            else -> "-1"
        }

        form.hhv03a = when {
            bi.hhv03a.text.toString().trim().isNotEmpty() -> bi.hhv03a.text.toString()
            else -> "-1"
        }

        form.hhv03b = when {
            bi.hhv03b.text.toString().trim().isNotEmpty() -> bi.hhv03b.text.toString()
            else -> "-1"
        }

        form.hhv03c = when {
            bi.hhv03c.text.toString().trim().isNotEmpty() -> bi.hhv03c.text.toString()
            else -> "-1"
        }

        form.hhv03d = when {
            bi.hhv03d.text.toString().trim().isNotEmpty() -> bi.hhv03d.text.toString()
            else -> "-1"
        }

        form.hhv03e = when {
            bi.hhv03e.text.toString().trim().isNotEmpty() -> bi.hhv03e.text.toString()
            else -> "-1"
        }

        form.hhv03f = when {
            bi.hhv03f.text.toString().trim().isNotEmpty() -> bi.hhv03f.text.toString()
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