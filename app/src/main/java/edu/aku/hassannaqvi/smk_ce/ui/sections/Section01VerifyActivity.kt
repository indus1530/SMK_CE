package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.HHVerifyContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.form
import edu.aku.hassannaqvi.smk_ce.core.MainApp.hhverify
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01VerifyBinding
import edu.aku.hassannaqvi.smk_ce.models.HHVerifyModel
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section01VerifyActivity : AppCompatActivity() {

    lateinit var bi: ActivitySection01VerifyBinding
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01_verify)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setupSkips()

    }

    private fun setupSkips() {
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addHHVerify(hhverify)
        return if (updcount > 0) {
            hhverify.id = updcount.toString()
            hhverify.uid = hhverify.deviceId + hhverify.id
            var count = db.updatesHHVerifyColumn(HHVerifyContract.HHVerifyTable.COLUMN_UID, hhverify.uid)
            if (count > 0) count = db.updatesHHVerifyColumn(HHVerifyContract.HHVerifyTable.COLUMN_SA, hhverify.sAtoString())
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
        hhverify = HHVerifyModel()
        hhverify.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        hhverify.uuid = form.uid
        hhverify.userName = MainApp.user.userName
        hhverify.districtCode = form.districtCode
        hhverify.districtName = form.districtName
        hhverify.tehsilCode = form.tehsilCode
        hhverify.tehsilName = form.tehsilName
        hhverify.lhwCode = form.lhwCode
        hhverify.lhwName = form.lhwName
        hhverify.khandanNumber = form.khandanNumber
        hhverify.deviceId = MainApp.appInfo.deviceID
        hhverify.deviceTag = MainApp.appInfo.tagName
        hhverify.appver = MainApp.appInfo.appVersion

        hhverify.hhv01 = when {
            bi.hhv01.text.toString().trim().isNotEmpty() -> bi.hhv01.text.toString()
            else -> "-1"
        }

        hhverify.hhv02a = when {
            bi.hhv02a.text.toString().trim().isNotEmpty() -> bi.hhv02a.text.toString()
            else -> "-1"
        }

        hhverify.hhv02b = when {
            bi.hhv02b.text.toString().trim().isNotEmpty() -> bi.hhv02b.text.toString()
            else -> "-1"
        }

        hhverify.hhv02c = when {
            bi.hhv02c.text.toString().trim().isNotEmpty() -> bi.hhv02c.text.toString()
            else -> "-1"
        }

        hhverify.hhv02d = when {
            bi.hhv02d.text.toString().trim().isNotEmpty() -> bi.hhv02d.text.toString()
            else -> "-1"
        }

        hhverify.hhv02e = when {
            bi.hhv02e.text.toString().trim().isNotEmpty() -> bi.hhv02e.text.toString()
            else -> "-1"
        }

        hhverify.hhv02f = when {
            bi.hhv02f.text.toString().trim().isNotEmpty() -> bi.hhv02f.text.toString()
            else -> "-1"
        }

        hhverify.hhv02g = when {
            bi.hhv02g.text.toString().trim().isNotEmpty() -> bi.hhv02g.text.toString()
            else -> "-1"
        }

        hhverify.hhv03 = when {
            bi.hhv03a.isChecked -> "1"
            bi.hhv03b.isChecked -> "2"
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