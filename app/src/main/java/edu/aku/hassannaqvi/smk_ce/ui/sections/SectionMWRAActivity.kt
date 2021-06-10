package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Clear
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.ADOLContract
import edu.aku.hassannaqvi.smk_ce.contracts.MWRAContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.mwra
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySectionMwraBinding
import edu.aku.hassannaqvi.smk_ce.models.MWRAModel

class SectionMWRAActivity : AppCompatActivity() {

    lateinit var bi: ActivitySectionMwraBinding
    var position: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_mwra)
        bi.callback
        setSupportActionBar(bi.toolbar)
        setupSkips()


        position = MainApp.selectedFemale.toString()


        bi.mwra01.setText(MainApp.fm[position.toInt()].hh02.toString())
        bi.mwra02.setText(MainApp.fm[position.toInt()].hh05y.toString())
        bi.mwra04.setText(MainApp.fm[position.toInt()].hh07.toString())


    }


    private fun setupSkips() {

        //bi.chkWeight.setOnCheckedChangeListener { compoundButton, b -> Clear.clearAllFields(bi.mh012, !b) }


        bi.mwra04.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(bi.mwra04.text)) return
                if (bi.mwra04.text.toString().toInt() == 0) {
                    Clear.clearAllFields(bi.fldGrpCVmwra05)
                    bi.fldGrpCVmwra05.visibility = View.GONE
                } else {
                    bi.fldGrpCVmwra05.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })


        bi.mwra16.setOnCheckedChangeListener { radioGroup, i ->
            Clear.clearAllFields(bi.fldGrpCVmwra17)
            Clear.clearAllFields(bi.fldGrpCVmwra18)
            Clear.clearAllFields(bi.fldGrpCVmwra19)
            Clear.clearAllFields(bi.fldGrpCVmwra20)
            bi.fldGrpCVmwra17.visibility = View.GONE
            bi.fldGrpCVmwra18.visibility = View.GONE
            bi.fldGrpCVmwra19.visibility = View.GONE
            bi.fldGrpCVmwra20.visibility = View.GONE
            if (i == bi.mwra16a.id) bi.fldGrpCVmwra20.visibility = View.VISIBLE
            else {
                bi.fldGrpCVmwra17.visibility = View.VISIBLE
                bi.fldGrpCVmwra18.visibility = View.VISIBLE
                bi.fldGrpCVmwra19.visibility = View.VISIBLE
            }
        }


        rgLsnr(bi.mwra03, bi.mwra03b, arrayOf(bi.fldGrpCVmwra06))
        rgLsnr(bi.mwra07, bi.mwra07b, arrayOf(bi.fldGrpCVmwra08))
        rgLsnr(bi.mwra09, bi.mwra09b, arrayOf(bi.fldGrpCVmwra10, bi.fldGrpCVmwra11, bi.fldGrpCVmwra12))
        rgLsnr(bi.mwra11, bi.mwra11b, arrayOf(bi.fldGrpCVmwra12))
        rgLsnr(bi.mwra13, bi.mwra13b, arrayOf(bi.fldGrpCVmwra14, bi.fldGrpCVmwra15, bi.fldGrpCVmwra16, bi.fldGrpCVmwra17))
        rgLsnr(bi.mwra19, bi.mwra19b, arrayOf(bi.fldGrpCVmwra20))
        rgLsnr(bi.mwra21, bi.mwra21b, arrayOf(bi.fldGrpCVmwra22))
        rgLsnr(bi.mwra22, bi.mwra22a, arrayOf(bi.fldGrpCVmwra23))

    }


    private fun rgLsnr(rg: RadioGroup, rb: RadioButton, vgArray: Array<ViewGroup>) {
        rg.setOnCheckedChangeListener { radioGroup, i ->
            vgArray.forEach {
                Clear.clearAllFields(it)
                it.visibility = View.VISIBLE
                if (i == rb.id) it.visibility = View.GONE
            }
        }
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addMWRA(mwra)
        return if (updcount > 0) {
            mwra.id = updcount.toString()
            mwra.uid = mwra.deviceId + mwra.id
            db.updatesMWRAColumn(MWRAContract.MWRATable.COLUMN_UID, mwra.uid)
            db.updatesFemaleMemberbyUUID(MainApp.mwra.fmid) // Updates status in Family members table
            true
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
            startActivity(Intent(this, FemaleMembersActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun saveDraft() {

        mwra = MWRAModel()

        mwra.position = position


        mwra.sysDate = MainApp.form.sysDate
        mwra.uuid = MainApp.form.uid
        mwra.fmid = MainApp.fm.get(position.toInt()).uid
        mwra.userName = MainApp.user.userName
        mwra.districtCode = MainApp.form.hfCode
        mwra.districtName = MainApp.form.hfName
        mwra.tehsilCode = MainApp.form.tehsilCode
        mwra.tehsilName = MainApp.form.tehsilName
        mwra.lhwCode = MainApp.form.lhwCode
        mwra.lhwName = MainApp.form.lhwName
        mwra.khandanNumber = MainApp.form.khandanNumber
        mwra.deviceId = MainApp.appInfo.deviceID
        mwra.deviceTag = MainApp.appInfo.tagName
        mwra.appver = MainApp.appInfo.appVersion
        mwra.status = "1"

        mwra.mwra01 = when {
            bi.mwra01.text.toString().trim().isNotEmpty() -> bi.mwra01.text.toString()
            else -> "-1"
        }

        mwra.mwra02 = when {
            bi.mwra02.text.toString().trim().isNotEmpty() -> bi.mwra02.text.toString()
            else -> "-1"
        }

        mwra.mwra03 = when {
            bi.mwra03a.isChecked -> "1"
            bi.mwra03b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra04 = when {
            bi.mwra04.text.toString().trim().isNotEmpty() -> bi.mwra04.text.toString()
            else -> "-1"
        }

        mwra.mwra05a = when {
            bi.mwra05a.text.toString().trim().isNotEmpty() -> bi.mwra05a.text.toString()
            else -> "-1"
        }

        mwra.mwra05b = when {
            bi.mwra05b.text.toString().trim().isNotEmpty() -> bi.mwra05b.text.toString()
            else -> "-1"
        }

        mwra.mwra06 = when {
            bi.mwra06.text.toString().trim().isNotEmpty() -> bi.mwra06.text.toString()
            else -> "-1"
        }

        mwra.mwra07 = when {
            bi.mwra07a.isChecked -> "1"
            bi.mwra07b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra08a = if (bi.mwra08a.isChecked) "1" else "-1"
        mwra.mwra08b = if (bi.mwra08b.isChecked) "2" else "-1"
        mwra.mwra08c = if (bi.mwra08c.isChecked) "3" else "-1"
        mwra.mwra08d = if (bi.mwra08d.isChecked) "4" else "-1"
        mwra.mwra08e = if (bi.mwra08e.isChecked) "5" else "-1"
        mwra.mwra08f = if (bi.mwra08f.isChecked) "6" else "-1"
        mwra.mwra08g = if (bi.mwra08g.isChecked) "7" else "-1"
        mwra.mwra0896 = if (bi.mwra0896.isChecked) "96" else "-1"

        mwra.mwra0896x = when {
            bi.mwra0896x.text.toString().trim().isNotEmpty() -> bi.mwra0896x.text.toString()
            else -> "-1"
        }

        mwra.mwra09 = when {
            bi.mwra09a.isChecked -> "1"
            bi.mwra09b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra10 = when {
            bi.mwra10.text.toString().trim().isNotEmpty() -> bi.mwra10.text.toString()
            else -> "-1"
        }

        mwra.mwra11 = when {
            bi.mwra11a.isChecked -> "1"
            bi.mwra11b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra12a = if (bi.mwra12a.isChecked) "1" else "-1"
        mwra.mwra12b = if (bi.mwra12b.isChecked) "2" else "-1"
        mwra.mwra12c = if (bi.mwra12c.isChecked) "3" else "-1"
        mwra.mwra12d = if (bi.mwra12d.isChecked) "4" else "-1"
        mwra.mwra12e = if (bi.mwra12e.isChecked) "5" else "-1"
        mwra.mwra12f = if (bi.mwra12f.isChecked) "6" else "-1"
        mwra.mwra12g = if (bi.mwra12g.isChecked) "7" else "-1"
        mwra.mwra12h = if (bi.mwra12h.isChecked) "8" else "-1"
        mwra.mwra12i = if (bi.mwra12i.isChecked) "9" else "-1"
        mwra.mwra12j = if (bi.mwra12j.isChecked) "10" else "-1"
        mwra.mwra12k = if (bi.mwra12k.isChecked) "11" else "-1"
        mwra.mwra12l = if (bi.mwra12l.isChecked) "12" else "-1"
        mwra.mwra12m = if (bi.mwra12m.isChecked) "13" else "-1"
        mwra.mwra1296 = if (bi.mwra1296.isChecked) "96" else "-1"

        mwra.mwra1296x = when {
            bi.mwra1296x.text.toString().trim().isNotEmpty() -> bi.mwra1296x.text.toString()
            else -> "-1"
        }

        mwra.mwra13 = when {
            bi.mwra13a.isChecked -> "1"
            bi.mwra13b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra14 = when {
            bi.mwra14a.isChecked -> "1"
            bi.mwra14b.isChecked -> "2"
            bi.mwra14c.isChecked -> "3"
            bi.mwra14d.isChecked -> "4"
            bi.mwra14e.isChecked -> "5"
            bi.mwra14f.isChecked -> "6"
            bi.mwra14g.isChecked -> "7"
            bi.mwra14h.isChecked -> "8"
            bi.mwra14i.isChecked -> "9"
            bi.mwra14j.isChecked -> "10"
            bi.mwra14k.isChecked -> "11"
            bi.mwra14l.isChecked -> "12"
            bi.mwra14m.isChecked -> "13"
            bi.mwra1496.isChecked -> "96"
            else -> "-1"
        }

        mwra.mwra1496x = when {
            bi.mwra1496x.text.toString().trim().isNotEmpty() -> bi.mwra1496x.text.toString()
            else -> "-1"
        }

        mwra.mwra15 = when {
            bi.mwra15a.isChecked -> "1"
            bi.mwra15b.isChecked -> "2"
            bi.mwra15c.isChecked -> "3"
            bi.mwra15d.isChecked -> "4"
            bi.mwra15e.isChecked -> "5"
            bi.mwra15f.isChecked -> "6"
            bi.mwra15g.isChecked -> "7"
            bi.mwra15h.isChecked -> "8"
            bi.mwra15i.isChecked -> "9"
            else -> "-1"
        }

        mwra.mwra16 = when {
            bi.mwra16a.isChecked -> "1"
            bi.mwra16b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra17a = if (bi.mwra17a.isChecked) "1" else "-1"
        mwra.mwra17b = if (bi.mwra17b.isChecked) "2" else "-1"
        mwra.mwra17c = if (bi.mwra17c.isChecked) "3" else "-1"
        mwra.mwra17d = if (bi.mwra17d.isChecked) "4" else "-1"
        mwra.mwra17e = if (bi.mwra17e.isChecked) "5" else "-1"
        mwra.mwra1796 = if (bi.mwra1796.isChecked) "96" else "-1"

        mwra.mwra1796x = when {
            bi.mwra1796x.text.toString().trim().isNotEmpty() -> bi.mwra1796x.text.toString()
            else -> "-1"
        }

        mwra.mwra18a = if (bi.mwra18a.isChecked) "1" else "-1"
        mwra.mwra18b = if (bi.mwra18b.isChecked) "2" else "-1"
        mwra.mwra18c = if (bi.mwra18c.isChecked) "3" else "-1"
        mwra.mwra18d = if (bi.mwra18d.isChecked) "4" else "-1"
        mwra.mwra18e = if (bi.mwra18e.isChecked) "5" else "-1"
        mwra.mwra18f = if (bi.mwra18f.isChecked) "6" else "-1"
        mwra.mwra18g = if (bi.mwra18g.isChecked) "7" else "-1"
        mwra.mwra18h = if (bi.mwra18h.isChecked) "8" else "-1"
        mwra.mwra1896 = if (bi.mwra1896.isChecked) "96" else "-1"

        mwra.mwra1896x = when {
            bi.mwra1896x.text.toString().trim().isNotEmpty() -> bi.mwra1896x.text.toString()
            else -> "-1"
        }

        mwra.mwra19 = when {
            bi.mwra19a.isChecked -> "1"
            bi.mwra19b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra20 = when {
            bi.mwra20a.isChecked -> "1"
            bi.mwra20b.isChecked -> "2"
            bi.mwra20c.isChecked -> "3"
            bi.mwra20d.isChecked -> "4"
            bi.mwra20e.isChecked -> "5"
            bi.mwra20f.isChecked -> "6"
            bi.mwra20g.isChecked -> "7"
            bi.mwra20h.isChecked -> "8"
            bi.mwra20i.isChecked -> "9"
            bi.mwra20j.isChecked -> "10"
            bi.mwra20k.isChecked -> "11"
            bi.mwra20l.isChecked -> "12"
            bi.mwra20m.isChecked -> "13"
            bi.mwra2096.isChecked -> "96"
            else -> "-1"
        }

        mwra.mwra2096x = when {
            bi.mwra2096x.text.toString().trim().isNotEmpty() -> bi.mwra2096x.text.toString()
            else -> "-1"
        }

        mwra.mwra21 = when {
            bi.mwra21a.isChecked -> "1"
            bi.mwra21b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra22 = when {
            bi.mwra22a.isChecked -> "1"
            bi.mwra22b.isChecked -> "2"
            else -> "-1"
        }

        mwra.mwra23a = if (bi.mwra23a.isChecked) "1" else "-1"
        mwra.mwra23b = if (bi.mwra23b.isChecked) "2" else "-1"
        mwra.mwra23c = if (bi.mwra23c.isChecked) "3" else "-1"
        mwra.mwra23d = if (bi.mwra23d.isChecked) "4" else "-1"
        mwra.mwra23e = if (bi.mwra23e.isChecked) "5" else "-1"
        mwra.mwra23f = if (bi.mwra23f.isChecked) "6" else "-1"
        mwra.mwra23g = if (bi.mwra23g.isChecked) "7" else "-1"
        mwra.mwra23h = if (bi.mwra23h.isChecked) "8" else "-1"
        mwra.mwra23i = if (bi.mwra23i.isChecked) "9" else "-1"
        mwra.mwra23j = if (bi.mwra23j.isChecked) "10" else "-1"
        mwra.mwra2396 = if (bi.mwra2396.isChecked) "96" else "-1"

        mwra.mwra2396x = when {
            bi.mwra2396x.text.toString().trim().isNotEmpty() -> bi.mwra2396x.text.toString()
            else -> "-1"
        }

        mwra.mwra24 = when {
            bi.mwra24a.isChecked -> "1"
            bi.mwra24b.isChecked -> "2"
            else -> "-1"
        }


    }


    fun BtnEnd(view: View) {
        //openSectionMainActivity(this, "G")
        finish()
        startActivity(Intent(this, FemaleMembersActivity::class.java))
    }


    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }


}