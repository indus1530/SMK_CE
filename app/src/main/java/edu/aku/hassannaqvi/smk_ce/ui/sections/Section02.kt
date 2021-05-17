package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection02Binding
import edu.aku.hassannaqvi.smk_ce.models.Form
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity
import edu.aku.hassannaqvi.smk_ce.utils.datecollection.AgeModel
import edu.aku.hassannaqvi.smk_ce.utils.datecollection.DateRepository.Companion.getCalculatedAge
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Section02 : AppCompatActivity() {

    lateinit var bi: ActivitySection02Binding
    var dtFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section02)
        bi.callback
        setSupportActionBar(bi.toolbar)
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
        MainApp.form = Form()
        MainApp.form.sysDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(Date().time)
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


    fun hh04OnTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        bi.hh05.isEnabled = false
        bi.hh05.text = null
        MainApp.childInformation.calculatedDOB = null
        if (TextUtils.isEmpty(bi.hh04a.text) || TextUtils.isEmpty(bi.hh04b.text) || TextUtils.isEmpty(bi.hh04c.text)) return
        if (!bi.hh04a.isRangeTextValidate || !bi.hh04b.isRangeTextValidate || !bi.hh04c.isRangeTextValidate) return
        if (bi.hh04a.text.toString() == "98" && bi.hh04b.text.toString() == "98" && bi.hh04c.text.toString() == "9998") {
            bi.hh05.isEnabled = true
            dtFlag = true
            return
        }
        val day = if (bi.hh04a.text.toString() == "98") 15 else bi.hh04a.text.toString().toInt()
        val month = bi.hh04b.text.toString().toInt()
        val year = bi.hh04c.text.toString().toInt()
        val age: AgeModel?
        age = if (MainApp.form.localDate != null) getCalculatedAge(MainApp.form.localDate, year, month, day) else getCalculatedAge(year = year, month = month, day = day)
        if (age == null) {
            bi.hh04c.error = "Invalid date!!"
            dtFlag = false
            return
        }
        dtFlag = true
        bi.hh05.setText(age.year.toString())

        //Setting Date
        try {
            val instant = Instant.parse(SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(
                    "$day-$month-$year"
            )) + "T06:24:01Z")
            MainApp.childInformation.calculatedDOB = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }


}