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
        bi.callback
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


    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {
        form = Form()
        form.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        /*form.setUuid(MainApp.form.getUid())
        form.setUserName(MainApp.user.getUserName())
        form.setDcode(MainApp.form.getDcode())
        form.setUcode(MainApp.form.getUcode())
        form.setCluster(MainApp.form.getCluster())
        form.setHhno(MainApp.form.getHhno())
        form.setDeviceId(MainApp.appInfo.getDeviceID())
        form.setDeviceTag(MainApp.appInfo.getTagName())
        form.setAppver(MainApp.appInfo.getAppVersion())
        form.setMh01(if (bi.mh01.getText().toString().trim().isEmpty()) "-1" else bi.mh01.getText().toString())
        form.setMh02(if (bi.mh02.getText().toString().trim().isEmpty()) "-1" else bi.mh02.getText().toString())
        form.setMh03(if (bi.mh03.getText().toString().trim().isEmpty()) "-1" else bi.mh03.getText().toString())
        form.setMh04(if (bi.mh04.getText().toString().trim().isEmpty()) "-1" else bi.mh04.getText().toString())
        form.setMh05(if (bi.mh05.getText().toString().trim().isEmpty()) "-1" else bi.mh05.getText().toString())*/
    }


    fun BtnEnd(view: View) {
        //openSectionMainActivity(this, "G")
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }


    private fun updateDB(): Boolean {
        /*val db = MainApp.appInfo.dbHelper
        if (!MainApp.childInformation.isEditFlag) {
            val updcount = db.addChildInformation(MainApp.childInformation)
            return if (updcount > 0) {
                MainApp.childInformation.id = updcount.toString()
                MainApp.childInformation.uid = MainApp.childInformation.deviceId + MainApp.childInformation.id
                var count = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_UID, MainApp.childInformation.uid)
                if (count > 0) count = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_SCB, MainApp.childInformation.sCBtoString())
                if (count > 0) true else {
                    Toast.makeText(this, "Sorry. You can't go further.\n" +
                            " Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
                    false
                }
            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            val updcount = db.updatesChildInformationColumn(ChildInformationContract.ChildInfoTable.COLUMN_SCB, MainApp.childInformation.sCBtoString())
            return if (updcount > 0) true else {
                Toast.makeText(this, "Sorry. You can't go further.\n" +
                        " Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show()
                false
            }
        }*/ return true
    }


    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }

}