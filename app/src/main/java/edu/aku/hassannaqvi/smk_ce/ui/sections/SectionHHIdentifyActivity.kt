package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.HHIDContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.*
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySectionHhidentifyBinding
import edu.aku.hassannaqvi.smk_ce.models.HHIDModel
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class SectionHHIdentifyActivity : AppCompatActivity() {

    lateinit var bi: ActivitySectionHhidentifyBinding
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_hhidentify)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setupSkips()
        val hhsno: Int = MainApp.randHHNo[MainApp.randHHNoIndex]

        bi.hhi01.setText(hhsno.toString())
        bi.hhsno.text = hhsno.toString()
        bi.hhnoCount.setText(Arrays.toString(MainApp.randHHNo))



    }

    private fun setupSkips() {
    }

    fun BtnContinue(view: View) {
        if (!formValidation()) return
        saveDraft()
        if (updateDB()) {
            // Loop this activity to record all random households
            if (MainApp.randHHNoIndex < randHHNo.size-1) {
                MainApp.randHHNoIndex++;
                finish()
                startActivity(Intent(this, SectionHHIdentifyActivity::class.java))
            }
            // If all random households recored; go to main activity
            else {
                MainApp.randHHNoIndex = 0;
                randHHNo = IntArray(HOUSEHOLDS_TO_RANDOMISE)
                finish()
                startActivity(Intent(this, MainActivity::class.java))
            }
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveDraft() {
        hhid = HHIDModel()
        hhid.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        hhid.uuid = lhwHousehold.uid
        hhid.userName = MainApp.user.userName
        hhid.hfCode = lhwHousehold.hfCode
        hhid.hfName = lhwHousehold.hfName
        hhid.tehsilCode = lhwHousehold.tehsilCode
        hhid.tehsilName = lhwHousehold.tehsilName
        hhid.lhwCode = lhwHousehold.lhwCode
        hhid.lhwName = lhwHousehold.lhwName
        hhid.khandanNumber = lhwHousehold.khandanNumber
        hhid.deviceId = MainApp.appInfo.deviceID
        hhid.deviceTag = MainApp.appInfo.tagName
        hhid.appver = MainApp.appInfo.appVersion

        hhid.khandanNumber = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
            else -> "-1"
        }

        hhid.hhi01 = when {
            bi.hhi01.text.toString().trim().isNotEmpty() -> bi.hhi01.text.toString()
            else -> "-1"
        }

        hhid.hhi02 = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
            else -> "-1"
        }

        hhid.hhi03 = when {
            bi.hhi03.text.toString().trim().isNotEmpty() -> bi.hhi03.text.toString()
            else -> "-1"
        }

        hhid.hhi04a = when {
            bi.hhi04a.text.toString().trim().isNotEmpty() -> bi.hhi04a.text.toString()
            else -> "-1"
        }

        hhid.hhi04b = when {
            bi.hhi04b.text.toString().trim().isNotEmpty() -> bi.hhi04b.text.toString()
            else -> "-1"
        }

        hhid.hhi04c = when {
            bi.hhi04c.text.toString().trim().isNotEmpty() -> bi.hhi04c.text.toString()
            else -> "-1"
        }

        hhid.hhi04d = when {
            bi.hhi04d.text.toString().trim().isNotEmpty() -> bi.hhi04d.text.toString()
            else -> "-1"
        }

        hhid.hhi04e = when {
            bi.hhi04e.text.toString().trim().isNotEmpty() -> bi.hhi04e.text.toString()
            else -> "-1"
        }

        hhid.hhi04f = when {
            bi.hhi04f.text.toString().trim().isNotEmpty() -> bi.hhi04f.text.toString()
            else -> "-1"
        }

        hhid.setsA(hhid.sAtoString())

    }

    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val rowId = db.addHHIdentify(hhid)
        return if (rowId > 0) {
            hhid.id = rowId.toString()
            hhid.uid = hhid.deviceId + hhid.id
            db.updatesHHIDColumn(HHIDContract.HHIDTable.COLUMN_UID, hhid.uid)
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