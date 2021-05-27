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
import edu.aku.hassannaqvi.smk_ce.contracts.LHWContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.lhw
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01Binding
import edu.aku.hassannaqvi.smk_ce.models.Districts
import edu.aku.hassannaqvi.smk_ce.models.LHWModel
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section01Activity : AppCompatActivity() {

    lateinit var bi: ActivitySection01Binding
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
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setTitle(R.string.lhwinfo)
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


    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            MainApp.randHHNoIndex = 0
            finish()
            startActivity(Intent(this, Section01IdentifyActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {

        MainApp.genRandNum(bi.lhw04.text.toString().toInt())

        lhw = LHWModel()
        lhw.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        lhw.userName = MainApp.user.userName
        lhw.districtCode = bi.lhw01.selectedItem.toString()
        lhw.districtName = bi.lhw01.selectedItem.toString()
        lhw.tehsilCode = bi.lhw02.selectedItem.toString()
        lhw.tehsilName = bi.lhw02.selectedItem.toString()
        lhw.lhwCode = bi.lhw03.selectedItem.toString()
        lhw.lhwName = bi.lhw03.selectedItem.toString()

        /*form.khandanNumber = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
            else -> "-1"
        }*/

        lhw.deviceId = MainApp.appInfo.deviceID
        lhw.deviceTag = MainApp.appInfo.tagName
        lhw.appver = MainApp.appInfo.appVersion

        lhw.lhw01 = bi.lhw01.selectedItem.toString()
        lhw.lhw02 = bi.lhw02.selectedItem.toString()
        lhw.lhw03 = bi.lhw03.selectedItem.toString()

        lhw.lhw04 = when {
            bi.lhw04.text.toString().trim().isNotEmpty() -> bi.lhw04.text.toString()
            else -> "-1"
        }

        lhw.lhw04sno = MainApp.randHHNo.toString()
        Toast.makeText(this, "Rand HHNo: " + lhw.lhw04sno, Toast.LENGTH_SHORT).show()

        lhw.lhwphoto = when {
            bi.lhwphoto.text.toString().trim().isNotEmpty() -> bi.lhwphoto.text.toString()
            else -> "-1"
        }
     //   lhw.setsA(lhw.sAtoString())
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val rowId = db.addLHW(lhw)
        return if (rowId > 0) {
            lhw.id = rowId.toString()
            lhw.uid = lhw.deviceId + lhw.id
            db.updatesLHWColumn(LHWContract.LHWTable.COLUMN_UID, lhw.uid)
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


    /*fun takePhoto(id: Int) {
        val intent = Intent(this, TakePhoto::class.java)
        intent.putExtra("picID", form.uid.toString() + "_" + form.lhwCode + "_")
        intent.putExtra("LhwName", form.lhwName)
        if (id == 1) {
            intent.putExtra("picView", "front".toUpperCase())
            startActivityForResult(intent, 1) // Activity is started with requestCode 1 = Front
        } else {
            intent.putExtra("picView", "back".toUpperCase())
            startActivityForResult(intent, 2) // Activity is started with requestCode 2 = Back
        }
    }*/


    // Call Back method  to get the Message form other Activity
    /*protected fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_CANCELED) {
            Toast.makeText(this, requestCode.toString() + "_" + resultCode, Toast.LENGTH_SHORT).show()
            val fileName = data.getStringExtra("FileName")

            // Check if the requestCode 1 = Front : 2 = Back -- resultCode 1 = Success : 2 = Failure
            // Results received with requestCode 1 = Front
            if (requestCode == 1 && resultCode == 1) {
                Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show()
                bi.lhwphoto.setText(fileName)
                bi.Photo.setEnabled(false)
            } else if (requestCode == 1 && resultCode != 1) {
                Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show()

                //TODO: Implement functionality below when photo was not taken
                // ...
                bi.lhwphoto.setText("Photo not taken.")
            }

            // Results received with requestCode 2 = Back
            if (requestCode == 2 && resultCode == 1) {
                Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show()
                bi.lhwphoto.setText(fileName)
                bi.Photo.setEnabled(false)
            } else if (requestCode == 2 && resultCode != 1) {
                Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show()

                //TODO: Implement functionality below when photo was not taken
                // ...
                bi.backFileName.setText("Photo not taken.")
            }
        }
    }*/

}


