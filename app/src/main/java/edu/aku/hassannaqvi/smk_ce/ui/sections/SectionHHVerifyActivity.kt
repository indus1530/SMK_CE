package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySectionHhverifyBinding
import edu.aku.hassannaqvi.smk_ce.models.*
import edu.aku.hassannaqvi.smk_ce.ui.FemaleMembersActivity
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SectionHHVerifyActivity : AppCompatActivity() {

    private val TAG: String = "SectionHHVerifyActivity"
    lateinit var bi: ActivitySectionHhverifyBinding
/*    var tehsilName = mutableListOf("....")
    var tehsilCode = mutableListOf<String>()
    var hfName = mutableListOf("....")
    var hfCode = mutableListOf<String>()
    var lhwname = mutableListOf("....")
    var lhwCode = mutableListOf<String>()
    var knum = mutableListOf("....")*/

    var tehsilName: MutableList<String> = ArrayList(listOf("...."))
    var tehsilCode: MutableList<String> = ArrayList(listOf("...."))
    var hfName: MutableList<String> = ArrayList(listOf("...."))
    var hfCode: MutableList<String> = ArrayList(listOf("...."))
    var lhwName: MutableList<String> = ArrayList(listOf("...."))
    var lhwCode: MutableList<String> = ArrayList(listOf("...."))
    var hhidList: MutableList<String> = ArrayList(listOf("...."))
    var hhid: ArrayList<HHIDModel> = ArrayList()

    /*
        lateinit var tehsilAdapter: ArrayAdapter<String>
        lateinit var hfAdapter: ArrayAdapter<String>*/
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_hhverify)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        populateSpinner()
        setupSkips()

    }

    private fun setupSkips() {
    }


    private fun populateSpinner() {
        Log.d(TAG, "populateSpinner: Called ")
        db = MainApp.appInfo.dbHelper

        // Populating all Tehsils
        var tehsils: ArrayList<Tehsil> = db.getTehsilsByDistID(MainApp.user.dist_id)
        Log.d(TAG, "populateSpinner: Tehsils: "+ tehsils.size)
        for (t in tehsils) {
            tehsilName.add(t.tehsil)
            tehsilCode.add(t.tehsilId)
            Log.d(TAG, "populateSpinner: tehsilName: $tehsilName || tehsilCode: $tehsilCode\r\n")
        }

        bi.hhv04.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tehsilName)

        // Added Listener for change in selected Tehsil to update HF adapter
        bi.hhv04.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

                bi.hhv05.setAdapter(null)
                bi.hhv06.setAdapter(null)
                bi.hhv01.setAdapter(null)
                bi.hhv02a.setText(null);
                bi.hhv02b.setText(null);
                bi.hhv02c.setText(null);
                bi.hhv02d.setText(null);
                bi.hhv02e.setText(null);
                bi.hhv02f.setText(null);
                bi.hhv02g.setText(null);
                bi.hhv03.clearCheck();
                bi.hhv03a.isEnabled = true

                if (position == 0) return

                var hf: ArrayList<HealthFacilities> = db.getHFByTehsil(tehsilCode[position].toString())
                Log.d(TAG, "onItemSelected: hf: " + hf.size)
                hfName = ArrayList(listOf("...."))
                hfCode = ArrayList(listOf("...."))
                for (h in hf) {
                    Log.d(TAG, "onItemSelected: HF " + h.hf_name)
                    hfName.add(h.hf_name)
                    hfCode.add(h.hfcode)
                }

                // update HF adapter
                bi.hhv05.setAdapter(ArrayAdapter<String>(this@SectionHHVerifyActivity, android.R.layout.simple_spinner_dropdown_item, hfName))

            }

            override fun onNothingSelected(
                    parent: AdapterView<*>?
            ) {}
        }

        // Added Listener for change in selected HF to update LHW Adapter
        bi.hhv05.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

                bi.hhv06.setAdapter(null)
                bi.hhv01.setAdapter(null)
                bi.hhv02a.setText(null);
                bi.hhv02b.setText(null);
                bi.hhv02c.setText(null);
                bi.hhv02d.setText(null);
                bi.hhv02e.setText(null);
                bi.hhv02f.setText(null);
                bi.hhv02g.setText(null);
                bi.hhv03.clearCheck();
                bi.hhv03a.isEnabled = true
                if (position == 0) return

                var lhw: ArrayList<LHW> = db.getLHWByHF(hfCode[position].toString())
                Log.d(TAG, "onItemSelected: lhw: " + lhw.size)
                lhwName = ArrayList(listOf("...."))
                lhwCode = ArrayList(listOf("...."))
                for (l in lhw) {
                    Log.d(TAG, "onItemSelected: LHW " + l.lhw_Name)

                    lhwName.add(l.lhw_Name)
                    lhwCode.add(l.lhw_Code)
                }

                // Update LHW adapter
                bi.hhv06.adapter = ArrayAdapter(this@SectionHHVerifyActivity, android.R.layout.simple_spinner_dropdown_item, lhwName)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Added Listener for change in selected LHW to update KhandanNumber Adapter
        bi.hhv06.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

                bi.hhv01.setAdapter(null)
                bi.hhv02a.setText(null);
                bi.hhv02b.setText(null);
                bi.hhv02c.setText(null);
                bi.hhv02d.setText(null);
                bi.hhv02e.setText(null);
                bi.hhv02f.setText(null);
                bi.hhv02g.setText(null);
                bi.hhv03.clearCheck();
                bi.hhv03a.isEnabled = true
                if (position == 0) return

                 hhid = db.getKhandanNumberByLHW(lhwCode[position].toString())
                 hhidList = ArrayList(listOf("...."))
                Log.d(TAG, "onItemSelected: HHID: " + hhid.size)
                for (h in hhid) {
                    Log.d(TAG, "onItemSelected: hh " + h.khandanNumber)
                    hhidList.add(h.khandanNumber)
                }

                // Update LHW adapter
                bi.hhv01.adapter = ArrayAdapter(this@SectionHHVerifyActivity, android.R.layout.simple_spinner_dropdown_item, hhidList)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        // Added Listener for change in selected LHW to update KhandanNumber Adapter
        bi.hhv01.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

                bi.hhv02a.setText(null);
                bi.hhv02b.setText(null);
                bi.hhv02c.setText(null);
                bi.hhv02d.setText(null);
                bi.hhv02e.setText(null);
                bi.hhv02f.setText(null);
                bi.hhv02g.setText(null);
                bi.hhv03.clearCheck();
                bi.hhv03a.isEnabled = true
                if (position == 0) return

             //   var hhid: ArrayList<HHIDModel> = db.getKhandanNumberByLHW(lhwCode[position].toString())

                MainApp.selectedHH = hhid[position-1]
                //hhid = ArrayList()


                // Update HH Info
                bi.hhv02a.setText(MainApp.selectedHH.hhi03);
                bi.hhv02b.setText(MainApp.selectedHH.hhi04a);
                bi.hhv02c.setText(MainApp.selectedHH.hhi04b);
                bi.hhv02d.setText(MainApp.selectedHH.hhi04c);
                bi.hhv02e.setText(MainApp.selectedHH.hhi04d);
                bi.hhv02f.setText(MainApp.selectedHH.hhi04e);
                bi.hhv02g.setText(MainApp.selectedHH.hhi04f);

                setHhv02Enable(false);


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    fun setHhv02Enable(enabled : Boolean){

        bi.hhv02a.isEnabled = enabled;
        bi.hhv02b.isEnabled = enabled;
        bi.hhv02c.isEnabled = enabled;
        bi.hhv02d.isEnabled = enabled;
        bi.hhv02e.isEnabled = enabled;
        bi.hhv02f.isEnabled = enabled;
        bi.hhv02g.isEnabled = enabled;
    }

    fun BtnContinue(view: View) {
        if (!formValidation()) return
        if (!hhExists()) {
            saveDraft()
        }
        //     if (updateDB()) {
        finish()
        startActivity(Intent(this, FemaleMembersActivity::class.java))
        /*   } else {
               Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
           }*/
    }

    private fun hhExists(): Boolean {
        form = Form()
        form = db.getFormByKhandanNumber(MainApp.selectedHH.lhwCode, MainApp.selectedHH.khandanNumber)

        return form != null
    }


    private fun saveDraft() {
        form = Form()
        form.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        //form.uuid = form.uid
        form.userName = MainApp.user.userName

        form.tehsilCode = tehsilCode[bi.hhv04.selectedItemPosition]
        form.tehsilCode = tehsilCode[bi.hhv04.selectedItemPosition]
        form.tehsilName = tehsilName[bi.hhv04.selectedItemPosition]

        form.hhv05 = hfCode[bi.hhv05.selectedItemPosition]
        form.hfCode = hfCode[bi.hhv05.selectedItemPosition]
        form.hfName = hfName[bi.hhv05.selectedItemPosition]

        form.hhv06 = lhwCode[bi.hhv06.selectedItemPosition]
        form.lhwCode = lhwCode[bi.hhv06.selectedItemPosition]
        form.lhwName = lhwName[bi.hhv06.selectedItemPosition]

        form.hhv01 = hhidList[bi.hhv01.selectedItemPosition]
        form.khandanNumber = hhidList[bi.hhv01.selectedItemPosition]


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
        val rowId = db.addForm(form)
        return if (rowId > 0) {
            form.id = rowId.toString()
            form.uid = form.deviceId + form.id
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