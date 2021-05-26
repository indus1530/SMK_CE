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
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01ABinding
import edu.aku.hassannaqvi.smk_ce.models.Districts
import edu.aku.hassannaqvi.smk_ce.models.Form
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section01AActivity : AppCompatActivity() {

    lateinit var bi: ActivitySection01ABinding
    var tehsilName = mutableListOf("....")
    var tehsilCode = mutableListOf<String>()
    var hfName = mutableListOf("....")
    var hfCode = mutableListOf<String>()
    var lhwname = mutableListOf("....")
    var lhwCode = mutableListOf<String>()
    lateinit var tehsilAdapter: ArrayAdapter<String>
    lateinit var hfAdapter: ArrayAdapter<String>
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01_a)
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

        bi.lhw01.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tehsilName)
        //bi.lhw01.adapter = districtAdapter
        hfAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, hfName)
        bi.lhw02.adapter = hfAdapter
        bi.lhw03.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lhwname)

        bi.lhw01.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.lhw02.setSelection(0)
                if (position == 0) {
                    bi.lhw02.isEnabled = false
                    return
                }
                bi.lhw02.isEnabled = true
                hfName.clear()
                hfCode.clear()
                hfName.add("....")
                hfName.add("Test Health Facility")
                //viewModel.getUCsDistrictFromDB(districtCode[position - 1])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        bi.lhw02.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.lhw03.setSelection(0)
                if (position == 0) {
                    bi.lhw03.isEnabled = false
                    return
                }
                bi.lhw03.isEnabled = true
                lhwname.clear()
                lhwCode.clear()
                lhwname.add("....")
                lhwname.add("Test Lady Health Worker")
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
            startActivity(Intent(this, Section01BActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {
        form = Form()
        form.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        form.userName = MainApp.user.userName
        form.districtCode = bi.lhw01.selectedItem.toString()
        form.districtName = bi.lhw01.selectedItem.toString()
        form.tehsilCode = bi.lhw02.selectedItem.toString()
        form.tehsilName = bi.lhw02.selectedItem.toString()
        form.lhwCode = bi.lhw03.selectedItem.toString()
        form.lhwName = bi.lhw03.selectedItem.toString()

        form.khandanNumber = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
            else -> "-1"
        }

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