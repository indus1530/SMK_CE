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
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.form
import edu.aku.hassannaqvi.smk_ce.core.MainApp.lhw
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01VerifyBinding
import edu.aku.hassannaqvi.smk_ce.models.Districts
import edu.aku.hassannaqvi.smk_ce.models.Form
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section01VerifyActivity : AppCompatActivity() {

    lateinit var bi: ActivitySection01VerifyBinding
    var tehsilName = mutableListOf("....")
    var tehsilCode = mutableListOf<String>()
    var hfName = mutableListOf("....")
    var hfCode = mutableListOf<String>()
    var lhwname = mutableListOf("....")
    var lhwCode = mutableListOf<String>()
    var knum = mutableListOf("....")
    lateinit var tehsilAdapter: ArrayAdapter<String>
    lateinit var hfAdapter: ArrayAdapter<String>
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01_verify)
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

        /*dcs.forEach {
            district.add(it.districtName)
            districtCode.add(it.districtCode)
        }
*/

        tehsilName.add("Test Tehsil")

        bi.hhv04.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tehsilName)
        //bi.lhw01.adapter = districtAdapter
        hfAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, hfName)
        bi.hhv05.adapter = hfAdapter
        bi.hhv06.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lhwname)
        bi.hhv01.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, knum)

        bi.hhv04.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.hhv05.setSelection(0)
                if (position == 0) {
                    bi.hhv05.isEnabled = false
                    return
                }
                bi.hhv05.isEnabled = true
                hfName.clear()
                hfCode.clear()
                hfName.add("....")
                hfName.add("Test Health Facility")
                //viewModel.getUCsDistrictFromDB(districtCode[position - 1])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        bi.hhv05.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.hhv06.setSelection(0)
                if (position == 0) {
                    bi.hhv06.isEnabled = false
                    return
                }
                bi.hhv06.isEnabled = true
                lhwname.clear()
                lhwCode.clear()
                lhwname.add("....")
                lhwname.add("Test Lady Health Worker")
                //viewModel.getUCsDistrictFromDB(districtCode[position - 1])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        bi.hhv06.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.hhv01.setSelection(0)
                if (position == 0) {
                    bi.hhv01.isEnabled = false
                    return
                }
                bi.hhv01.isEnabled = true
                knum.clear()
                knum.add("....")
                knum.add("24568749")
                //viewModel.getUCsDistrictFromDB(districtCode[position - 1])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
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
        //form.uuid = form.uid
        form.userName = MainApp.user.userName

        //TODO: Need To Discuss saving Mechanism
        form.districtCode = lhw.districtCode
        form.districtName = lhw.districtName
        form.tehsilCode = lhw.tehsilCode
        form.tehsilName = lhw.tehsilName
        form.lhwCode = lhw.lhwCode
        form.lhwName = lhw.lhwName
        form.khandanNumber = form.khandanNumber
        form.deviceId = MainApp.appInfo.deviceID
        form.deviceTag = MainApp.appInfo.tagName
        form.appver = MainApp.appInfo.appVersion

        form.hhv01 = bi.hhv04.selectedItem.toString()
        form.hhv01 = bi.hhv05.selectedItem.toString()
        form.hhv01 = bi.hhv06.selectedItem.toString()
        form.hhv01 = bi.hhv01.selectedItem.toString()

        form.hhv02a = when {
            bi.hhv02a.text.toString().trim().isNotEmpty() -> bi.hhv02a.text.toString()
            else -> "-1"
        }

        form.hhv02b = when {
            bi.hhv02b.text.toString().trim().isNotEmpty() -> bi.hhv02b.text.toString()
            else -> "-1"
        }

        form.hhv02c = when {
            bi.hhv02c.text.toString().trim().isNotEmpty() -> bi.hhv02c.text.toString()
            else -> "-1"
        }

        form.hhv02d = when {
            bi.hhv02d.text.toString().trim().isNotEmpty() -> bi.hhv02d.text.toString()
            else -> "-1"
        }

        form.hhv02e = when {
            bi.hhv02e.text.toString().trim().isNotEmpty() -> bi.hhv02e.text.toString()
            else -> "-1"
        }

        form.hhv02f = when {
            bi.hhv02f.text.toString().trim().isNotEmpty() -> bi.hhv02f.text.toString()
            else -> "-1"
        }

        form.hhv02g = when {
            bi.hhv02g.text.toString().trim().isNotEmpty() -> bi.hhv02g.text.toString()
            else -> "-1"
        }

        form.hhv03 = when {
            bi.hhv03a.isChecked -> "1"
            bi.hhv03b.isChecked -> "2"
            else -> "-1"
        }
        form.setsA(form.sAtoString())
    }

    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val rowId = db.addLHW(lhw)
        return if (rowId > 0) {
            lhw.id = rowId.toString()
            lhw.uid = lhw.deviceId + lhw.id
         //   var count = db.updatesHHVerifyColumn(LHWContract.LHWTable.COLUMN_UID, lhw.uid)
            true
        } else {
            Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show()
            false
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