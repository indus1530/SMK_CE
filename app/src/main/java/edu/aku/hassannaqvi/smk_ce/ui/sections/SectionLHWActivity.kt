package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.LHWHouseholdContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.HOUSEHOLDS_TO_RANDOMISE
import edu.aku.hassannaqvi.smk_ce.core.MainApp.lhwHousehold
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySectionLhwBinding
import edu.aku.hassannaqvi.smk_ce.models.HealthFacilities
import edu.aku.hassannaqvi.smk_ce.models.LHW
import edu.aku.hassannaqvi.smk_ce.models.LHWHouseholdModel
import edu.aku.hassannaqvi.smk_ce.models.Tehsil
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import edu.aku.hassannaqvi.smk_ce.ui.TakePhoto
import java.text.SimpleDateFormat
import java.util.*


var PhotoSerial: Int = 0

class SectionLHWActivity : AppCompatActivity() {

    private val TAG: String = "SectionLHWActivity"
    lateinit var bi: ActivitySectionLhwBinding

    /*    var tehsilName = mutableListOf("....")
        var tehsilCode = mutableListOf<String>()
        var hfName = mutableListOf("....")
        var hfCode = mutableListOf<String>()
        var lhwname = mutableListOf("....")
        var lhwCode = mutableListOf<String>()*/
    val tehsilName: MutableList<String> = ArrayList(listOf("...."))
    val tehsilCode: MutableList<String> = ArrayList(listOf("...."))
    val hfName: MutableList<String> = ArrayList(listOf("...."))
    val hfCode: MutableList<String> = ArrayList(listOf("...."))
    val lhwName: MutableList<String> = ArrayList(listOf("...."))
    val lhwCode: MutableList<String> = ArrayList(listOf("...."))
    var sectionLHWActivityResultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            // There are no request codes

            // There are no request codes
            //Intent data = result.getData();
            val data: Intent? = result.data

            // TODO: update textview

//            Toast.makeText(this, result.resultCode, Toast.LENGTH_SHORT).show()
/*
            val fileName = data?.getStringExtra("filename")
*/

            Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show()

            val fileName = data!!.getStringExtra("FileName")

            PhotoSerial++

            bi.lhwphoto.text = bi.lhwphoto.text.toString() + PhotoSerial.toString() + " - " + fileName + ";\r\n"
        } else {
            Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show()

            //TODO: Implement functionality below when photo was not taken
            // ...
            bi.lhwphoto.text = "Photo not taken."
        }

    }


    /*    lateinit var tehsilAdapter: ArrayAdapter<String>
        lateinit var hfAdapter: ArrayAdapter<String>
        lateinit var lhwAdapter: ArrayAdapter<String>*/
    lateinit var db: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_lhw)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setTitle(R.string.lhwinfo)
        populateSpinner()
        setupSkips()
        PhotoSerial = 1

    }


    private fun setupSkips() {
        bi.lhw04.minvalue = HOUSEHOLDS_TO_RANDOMISE.toFloat() + 2
    }


    private fun populateSpinner() {
        Log.d(TAG, "populateSpinner: Called ")
        db = MainApp.appInfo.dbHelper

        // Populating all Tehsils
        var tehsils: ArrayList<Tehsil> = db.allTehsils
        Log.d(TAG, "populateSpinner: Tehsils: " + tehsils.size)
        for (t in tehsils) {
            tehsilName.add(t.tehsil)
            tehsilCode.add(t.tehsilId)
            Log.d(TAG, "populateSpinner: tehsilName: " + tehsilName + " || tehsilCode: " + tehsilCode + "\r\n")
        }

        /*dcs.forEach {
            district.add(it.districtName)
            districtCode.add(it.districtCode)
        }
*/

        //  tehsilName.add("Test Tehsil")

        bi.lhw01.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tehsilName)
        //  bi.lhw01.adapter = districtAdapter
        //  bi.lhw02.adapter = hfAdapter
        //  bi.lhw03.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lhwname)

        // Added Listener for change in selected Tehsil to update HFAdapter
        bi.lhw01.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

                bi.lhw02.adapter = null
                bi.lhw03.adapter = null
                if (position == 0) return

                var hf: ArrayList<HealthFacilities> = db.getHFByTehsil(tehsilCode[position].toString())
                for (h in hf) {
                    hfName.add(h.hf_name)
                    hfCode.add(h.hfcode)
                }

                // Update HFAdapter
                bi.lhw02.adapter = ArrayAdapter<String>(this@SectionLHWActivity, android.R.layout.simple_spinner_dropdown_item, hfName)

//                spinnerDistrict.setAdapter(ArrayAdapter(this@LoginActivity, android.R.layout.simple_list_item_1, hFacilities))
                /*  bi.lhw02.setSelection(0)
                  if (position == 0) {
                      bi.lhw02.isEnabled = false
                      return
                  }
                  bi.lhw02.isEnabled = true
                  hfName.clear()
                  hfCode.clear()
                  hfName.add("....")
                  hfName.add("Test Health Facility")
                  //viewModel.getUCsDistrictFromDB(districtCode[position - 1])*/
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Added Listener for change in selected HF to update LHW Adapter
        bi.lhw02.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                bi.lhw03.adapter = null
                if (position == 0) return

                var lhw: ArrayList<LHW> = db.getLHWByHF(hfCode[position].toString())
                for (l in lhw) {
                    lhwName.add(l.lhw_Name)
                    lhwCode.add(l.lhw_Code)
                }

                // Update LHW Adapter
                bi.lhw03.adapter = ArrayAdapter(this@SectionLHWActivity, android.R.layout.simple_spinner_dropdown_item, lhwName)

//                spinnerDistrict.setAdapter(ArrayAdapter(this@LoginActivity, android.R.layout.simple_list_item_1, hFacilities))
                /*  bi.lhw02.setSelection(0)
                  if (position == 0) {
                      bi.lhw02.isEnabled = false
                      return
                  }
                  bi.lhw02.isEnabled = true
                  hfName.clear()
                  hfCode.clear()
                  hfName.add("....")
                  hfName.add("Test Health Facility")
                  //viewModel.getUCsDistrictFromDB(districtCode[position - 1])*/
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
            startActivity(Intent(this, SectionHHIdentifyActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }



    fun takePhoto(view: View) {
        if(!Validator.emptyCheckingContainer(this, bi.GrpName)) return
        val intent = Intent(this, TakePhoto::class.java)

        intent.putExtra("picID", lhwCode[bi.lhw01.selectedItemPosition] + "_" + PhotoSerial)
        intent.putExtra("lhwName", bi.lhw03.selectedItem.toString())

        if (view.id == bi.Photo.id) {
            //intent.putExtra("picView", bi.lhw03.selectedItem.toString().toUpperCase())
            intent.putExtra("picView", PhotoSerial)
            sectionLHWActivityResultLauncher.launch(intent)
        }
    }

    private fun saveDraft() {

        MainApp.genRandNum(bi.lhw04.text.toString().toInt())

        lhwHousehold = LHWHouseholdModel()
        lhwHousehold.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        lhwHousehold.userName = MainApp.user.userName
        lhwHousehold.deviceId = MainApp.appInfo.deviceID
        lhwHousehold.deviceTag = MainApp.appInfo.tagName
        lhwHousehold.appver = MainApp.appInfo.appVersion
        /* lhwHousehold.districtCode = bi.lhw01.selectedItem.toString()
        lhwHousehold.districtName = bi.lhw01.selectedItem.toString()*/
        lhwHousehold.lhw01 = tehsilCode[bi.lhw01.selectedItemPosition]
        lhwHousehold.tehsilCode = tehsilCode[bi.lhw01.selectedItemPosition]
        lhwHousehold.tehsilName = tehsilName[bi.lhw01.selectedItemPosition]

        lhwHousehold.lhw02 = hfCode[bi.lhw02.selectedItemPosition]
        lhwHousehold.hfCode = hfCode[bi.lhw02.selectedItemPosition]
        lhwHousehold.hfName = hfName[bi.lhw02.selectedItemPosition]

        lhwHousehold.lhw03 = lhwCode[bi.lhw03.selectedItemPosition]
        lhwHousehold.lhwCode = lhwCode[bi.lhw03.selectedItemPosition]
        lhwHousehold.lhwName = lhwName[bi.lhw03.selectedItemPosition]
        lhwHousehold.randSNo = Arrays.toString(MainApp.randHHNo)


        lhwHousehold.khandanNumber = when {
            bi.lhw04.text.toString().trim().isNotEmpty() -> bi.lhw04.text.toString()
            else -> "-1"
        }

        lhwHousehold.lhw04 = when {
            bi.lhw04.text.toString().trim().isNotEmpty() -> bi.lhw04.text.toString()
            else -> "-1"
        }

/*        lhwHousehold.lhw04sno = MainApp.randHHNo.toString()
        Toast.makeText(this, "Rand HHNo: " + lhwHousehold.lhw04sno, Toast.LENGTH_SHORT).show()*/

        lhwHousehold.lhwphoto = when {
            bi.lhwphoto.text.toString().trim().isNotEmpty() -> bi.lhwphoto.text.toString()
            else -> "-1"
        }
     //   lhw.setsA(lhw.sAtoString())
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val rowId = db.addLHW(lhwHousehold)
        return if (rowId > 0) {
            lhwHousehold.id = rowId.toString()
            lhwHousehold.uid = lhwHousehold.deviceId + lhwHousehold.id
            db.updatesLHWHouseholdColumn(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UID, lhwHousehold.uid)
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
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false;

        if (LHWRegistered()){
            Validator.emptyCustomTextBox(this, bi.lhw04,"LHW already registered.")
            return false
        }
        return true
    }




    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }

/*
    fun takePhoto(id: Int) {
        val intent = Intent(this, TakePhoto::class.java)
        intent.putExtra("picID", lhw.uid.toString() + "_" + lhw.lhwCode + "_")
        intent.putExtra("LHWName", lhw.lhwName)
        if (id == 1) {
            intent.putExtra("picView", "front".toUpperCase())
            someActivityResultLauncher.launch(intent)
        } else {
            intent.putExtra("picView", "back".toUpperCase())
            startActivityForResult(intent, 2) // Activity is started with requestCode 2 = Back
        }
    }*/



      // Call Back method  to get the Message form other Activity
      override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
          super.onActivityResult(requestCode, resultCode, data)
          if (resultCode != RESULT_CANCELED) {
              Toast.makeText(this, requestCode.toString() + "_" + resultCode, Toast.LENGTH_SHORT).show()
              val fileName = data?.getStringExtra("FileName")

              // Check if the requestCode 1 = Front : 2 = Back -- resultCode 1 = Success : 2 = Failure
              // Results received with requestCode 1 = Front
              if (requestCode == 1 && resultCode == 1) {
                  Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show()
                  bi.lhwphoto.text = fileName
                  bi.Photo.isEnabled = false
              } else if (requestCode == 1 && resultCode != 1) {
                  Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show()

                  //TODO: Implement functionality below when photo was not taken
                  // ...
                  bi.lhwphoto.text = "Photo not taken."
              }

              // Results received with requestCode 2 = Back
              /*if (requestCode == 2 && resultCode == 1) {
                  Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show()
                  bi.lhwphoto.setText(fileName)
                  bi.Photo.setEnabled(false)
              } else if (requestCode == 2 && resultCode != 1) {
                  Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show()

                  //TODO: Implement functionality below when photo was not taken
                  // ...
                  bi.backFileName.setText("Photo not taken.")
              }*/
          }
      }


    private fun LHWRegistered(): Boolean {
      //  Log.d(TAG, "LHWHHExists: LHW: "+ lhwHousehold.lhwCode+" | KNO: "+bi.hhi02.text.toString() )

        return db.checkLHW(lhwCode[bi.lhw03.selectedItemPosition]) > 0
    }
}


