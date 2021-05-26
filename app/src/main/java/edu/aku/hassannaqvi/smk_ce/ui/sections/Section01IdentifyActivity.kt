package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.HHIdentifyContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.form
import edu.aku.hassannaqvi.smk_ce.core.MainApp.hhidentify
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01IdentifyBinding
import edu.aku.hassannaqvi.smk_ce.models.HHIdentifyModel
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section01IdentifyActivity : AppCompatActivity() {

    lateinit var bi: ActivitySection01IdentifyBinding
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01_identify)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setupSkips()

    }


    private fun setupSkips() {
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addHHIdentify(hhidentify)
        return if (updcount > 0) {
            hhidentify.id = updcount.toString()
            hhidentify.uid = hhidentify.deviceId + hhidentify.id
            var count = db.updatesHHIdentifyColumn(HHIdentifyContract.HHIdentifyTable.COLUMN_UID, hhidentify.uid)
            if (count > 0) count = db.updatesHHIdentifyColumn(HHIdentifyContract.HHIdentifyTable.COLUMN_SA, hhidentify.sAtoString())
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
            startActivity(Intent(this, Section01VerifyActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {
        hhidentify = HHIdentifyModel()
        hhidentify.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        hhidentify.uuid = form.uid
        hhidentify.userName = MainApp.user.userName
        hhidentify.districtCode = form.districtCode
        hhidentify.districtName = form.districtName
        hhidentify.tehsilCode = form.tehsilCode
        hhidentify.tehsilName = form.tehsilName
        hhidentify.lhwCode = form.lhwCode
        hhidentify.lhwName = form.lhwName
        hhidentify.khandanNumber = form.khandanNumber
        hhidentify.deviceId = MainApp.appInfo.deviceID
        hhidentify.deviceTag = MainApp.appInfo.tagName
        hhidentify.appver = MainApp.appInfo.appVersion

        hhidentify.khandanNumber = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
            else -> "-1"
        }

        hhidentify.hhi01 = when {
            bi.hhi01.text.toString().trim().isNotEmpty() -> bi.hhi01.text.toString()
            else -> "-1"
        }

        hhidentify.hhi02 = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
            else -> "-1"
        }

        hhidentify.hhi03 = when {
            bi.hhi03.text.toString().trim().isNotEmpty() -> bi.hhi03.text.toString()
            else -> "-1"
        }

        hhidentify.hhi04a = when {
            bi.hhi04a.text.toString().trim().isNotEmpty() -> bi.hhi04a.text.toString()
            else -> "-1"
        }

        hhidentify.hhi04b = when {
            bi.hhi04b.text.toString().trim().isNotEmpty() -> bi.hhi04b.text.toString()
            else -> "-1"
        }

        hhidentify.hhi04c = when {
            bi.hhi04c.text.toString().trim().isNotEmpty() -> bi.hhi04c.text.toString()
            else -> "-1"
        }

        hhidentify.hhi04d = when {
            bi.hhi04d.text.toString().trim().isNotEmpty() -> bi.hhi04d.text.toString()
            else -> "-1"
        }

        hhidentify.hhi04e = when {
            bi.hhi04e.text.toString().trim().isNotEmpty() -> bi.hhi04e.text.toString()
            else -> "-1"
        }

        hhidentify.hhi04f = when {
            bi.hhi04f.text.toString().trim().isNotEmpty() -> bi.hhi04f.text.toString()
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