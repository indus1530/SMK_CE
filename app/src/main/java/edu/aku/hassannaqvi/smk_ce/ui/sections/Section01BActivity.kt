package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.form
import edu.aku.hassannaqvi.smk_ce.core.MainApp.hhinfo
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01BBinding
import edu.aku.hassannaqvi.smk_ce.models.HHInfoModel
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Section01BActivity : AppCompatActivity() {

    lateinit var bi: ActivitySection01BBinding
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01_b)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setupSkips()

    }

    private fun setupSkips() {
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
        hhinfo = HHInfoModel()
        hhinfo.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        hhinfo.uid = form.uid
        hhinfo.userName = MainApp.user.userName
        hhinfo.districtCode = form.districtCode
        hhinfo.tehsilCode = form.tehsilCode
        hhinfo.lhwCode = form.lhwCode
        hhinfo.khandanNumber = form.khandanNumber
        hhinfo.deviceId = MainApp.appInfo.deviceID
        hhinfo.deviceTag = MainApp.appInfo.tagName
        hhinfo.appver = MainApp.appInfo.appVersion

        hhinfo.hhv01 = when {
            bi.hhv01.text.toString().trim().isNotEmpty() -> bi.hhv01.text.toString()
            else -> "-1"
        }

        hhinfo.hhv02a = when {
            bi.hhv02a.text.toString().trim().isNotEmpty() -> bi.hhv02a.text.toString()
            else -> "-1"
        }

        hhinfo.hhv02b = when {
            bi.hhv02b.text.toString().trim().isNotEmpty() -> bi.hhv02b.text.toString()
            else -> "-1"
        }

        hhinfo.hhv02c = when {
            bi.hhv02c.text.toString().trim().isNotEmpty() -> bi.hhv02c.text.toString()
            else -> "-1"
        }

        hhinfo.hhv02d = when {
            bi.hhv02d.text.toString().trim().isNotEmpty() -> bi.hhv02d.text.toString()
            else -> "-1"
        }

        hhinfo.hhv02e = when {
            bi.hhv02e.text.toString().trim().isNotEmpty() -> bi.hhv02e.text.toString()
            else -> "-1"
        }

        hhinfo.hhv02f = when {
            bi.hhv02f.text.toString().trim().isNotEmpty() -> bi.hhv02f.text.toString()
            else -> "-1"
        }

        hhinfo.hhv02g = when {
            bi.hhv02g.text.toString().trim().isNotEmpty() -> bi.hhv02g.text.toString()
            else -> "-1"
        }

        hhinfo.hhv03 = when {
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