package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.form
import edu.aku.hassannaqvi.smk_ce.core.MainApp.genRandNum
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection01IdentifyBinding
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity

class Section01IdentifyActivity : AppCompatActivity() {

    lateinit var bi: ActivitySection01IdentifyBinding
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
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01_identify)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        setupSkips()
        val hhsno: Int = MainApp.randHHNo[MainApp.randHHNoIndex];
        bi.hhi01.setText(hhsno);
        bi.hhsno.setText(hhsno);
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
            startActivity(Intent(this, Section01VerifyActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {
        /*form = Form()
        form.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
        form.userName = MainApp.user.userName
        form.districtCode = bi.lhw01.selectedItem.toString()
        form.districtName = bi.lhw01.selectedItem.toString()
        form.tehsilCode = bi.lhw02.selectedItem.toString()
        form.tehsilName = bi.lhw02.selectedItem.toString()
        form.lhwCode = bi.lhw03.selectedItem.toString()
        form.lhwName = bi.lhw03.selectedItem.toString()*/
        form.deviceId = MainApp.appInfo.deviceID
        form.deviceTag = MainApp.appInfo.tagName
        form.appver = MainApp.appInfo.appVersion

        form.khandanNumber = when {
            bi.hhi02.text.toString().trim().isNotEmpty() -> bi.hhi02.text.toString()
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