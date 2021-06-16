package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.app.Activity
import android.icu.util.Calendar
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.contracts.FemaleMembersContract
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract
import edu.aku.hassannaqvi.smk_ce.core.MainApp
import edu.aku.hassannaqvi.smk_ce.core.MainApp.femalemembers
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySectionMemeberinfoBinding
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel

class SectionMemberInfoActivity : AppCompatActivity() {

    private val TAG = "SectionMemberInfoActivity"
    lateinit var bi: ActivitySectionMemeberinfoBinding
    var dtFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_memeberinfo)
        bi.callback = this
        setSupportActionBar(bi.toolbar)
        bi.hh01.setText((MainApp.fmCount + 1).toString())

        val txtListener = arrayOf<EditText>(bi.hh04a, bi.hh04b)
        for (txtItem in txtListener) {
            txtItem.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    bi.hh05y.text = null
                    bi.hh05m.text = null
                    bi.hh04c.text = null
                }

                override fun afterTextChanged(s: Editable) {}
            })
        }

        // android:visibility="@{hh03a.checked || hh06b.checked?View.GONE:View.VISIBLE}"

        // Male
        bi.hh03a.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            bi.hh07.text = null
            bi.hh08.text = null
        })
        // Unmarried
        bi.hh06b.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            bi.hh07.text = null
            bi.hh08.text = null
        })
    }


    private fun updateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addHHMembers(femalemembers)
        return if (updcount > 0) {
            femalemembers.id = updcount.toString()
            femalemembers.uid = femalemembers.deviceId + femalemembers.id
            var count = db.updatesHHMEMColumn(FemaleMembersContract.FemaleMembersTable.COLUMN_UID, femalemembers.uid)
            if (count > 0) count = db.updatesHHMEMColumn(FemaleMembersContract.FemaleMembersTable.COLUMN_SA, femalemembers.sAtoString())
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
        if (!addForm()) return
        saveDraft()
        if (updateDB()) {
/*            val data = Intent()
            data.putExtra("streetkey", "streetname")
            data.putExtra("citykey", "cityname")
            data.putExtra("homekey", "homename")*/

            setResult(Activity.RESULT_OK)
            finish()
            // startActivity(Intent(this, SectionMWRAActivity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addForm(): Boolean {
        if (bi.hh01.text.toString().equals("1")) {
            val db = MainApp.appInfo.dbHelper
            val rowId = db.addForm(MainApp.form)
            return if (rowId > 0) {
                MainApp.form.id = rowId.toString()
                MainApp.form.uid = MainApp.form.deviceId + MainApp.form.id
                db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.form.uid)
                true
            } else {
                Toast.makeText(this, "SORRY! Failed to update DB", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            return true
        }
    }

    private fun saveDraft() {

        femalemembers = FemaleMembersModel()
        femalemembers.sysDate = MainApp.form.sysDate
        femalemembers.uuid = MainApp.form.uid
        femalemembers.userName = MainApp.user.userName
        femalemembers.hfCode = MainApp.form.hfCode
        femalemembers.hfName = MainApp.form.hfName
        femalemembers.tehsilCode = MainApp.form.tehsilCode
        femalemembers.tehsilName = MainApp.form.tehsilName
        femalemembers.lhwCode = MainApp.form.lhwCode
        femalemembers.lhwName = MainApp.form.lhwName
        femalemembers.khandanNumber = MainApp.form.khandanNumber
        femalemembers.deviceId = MainApp.appInfo.deviceID
        femalemembers.deviceTag = MainApp.appInfo.tagName
        femalemembers.appver = MainApp.appInfo.appVersion

        femalemembers.hh01 = when {
            bi.hh01.text.toString().trim().isNotEmpty() -> bi.hh01.text.toString()
            else -> "-1"
        }

        femalemembers.hh02 = when {
            bi.hh02.text.toString().trim().isNotEmpty() -> bi.hh02.text.toString()
            else -> "-1"
        }

        femalemembers.hh03 = when {
            bi.hh03a.isChecked -> "1"
            bi.hh03b.isChecked -> "2"
            else -> "-1"
        }

        femalemembers.hh04a = when {
            bi.hh04a.text.toString().trim().isNotEmpty() -> bi.hh04a.text.toString()
            else -> "-1"
        }

        femalemembers.hh04b = when {
            bi.hh04b.text.toString().trim().isNotEmpty() -> bi.hh04b.text.toString()
            else -> "-1"
        }

        femalemembers.hh04c = when {
            bi.hh04c.text.toString().trim().isNotEmpty() -> bi.hh04c.text.toString()
            else -> "-1"
        }

        femalemembers.hh05y = when {
            bi.hh05y.text.toString().trim().isNotEmpty() -> bi.hh05y.text.toString()
            else -> "-1"
        }

        femalemembers.hh05m = when {
            bi.hh05m.text.toString().trim().isNotEmpty() -> bi.hh05m.text.toString()
            else -> "-1"
        }

        femalemembers.hh06 = when {
            bi.hh06a.isChecked -> "1"
            bi.hh06b.isChecked -> "2"
            bi.hh06c.isChecked -> "3"
            bi.hh06d.isChecked -> "4"
            else -> "-1"
        }

        femalemembers.hh07 = when {
            bi.hh07.text.toString().trim().isNotEmpty() -> bi.hh07.text.toString()
            else -> "-1"
        }

        femalemembers.hh08 = when {
            bi.hh08.text.toString().trim().isNotEmpty() -> bi.hh08.text.toString()
            else -> "-1"
        }

        femalemembers.hh09 = when {
            bi.hh09a.isChecked -> "1"
            bi.hh09b.isChecked -> "2"
            bi.hh09c.isChecked -> "3"
            bi.hh09d.isChecked -> "4"
            bi.hh09e.isChecked -> "5"
            bi.hh09f.isChecked -> "6"
            bi.hh09g.isChecked -> "7"
            bi.hh09h.isChecked -> "8"
            bi.hh09i.isChecked -> "9"
            bi.hh09j.isChecked -> "10"
            bi.hh09k.isChecked -> "11"
            bi.hh09l.isChecked -> "98"
            bi.hh09m.isChecked -> "99"
            else -> "-1"
        }

        femalemembers.hh10 = when {
            bi.hh10a.isChecked -> "1"
            bi.hh10b.isChecked -> "2"
            bi.hh10c.isChecked -> "3"
            bi.hh10d.isChecked -> "4"
            bi.hh10e.isChecked -> "5"
            bi.hh10f.isChecked -> "6"
            bi.hh10g.isChecked -> "7"
            bi.hh10h.isChecked -> "8"
            bi.hh10i.isChecked -> "98"
            bi.hh10j.isChecked -> "99"
            else -> "-1"
        }

        femalemembers.hh11 = when {
            bi.hh11a.isChecked -> "1"
            bi.hh11b.isChecked -> "2"
            else -> "-1"
        }


    }


    fun BtnEnd(view: View) {
        //openSectionMainActivity(this, "G")
        setResult(Activity.RESULT_CANCELED)
        finish()
    }


    private fun formValidation(): Boolean {
       if(!Validator.emptyCheckingContainer(this, bi.GrpName)){
           return false
       }

        if(bi.hh08.text.toString() <bi.hh07.text.toString()){
            Validator.emptyCustomTextBox(this, bi.hh08, "Pregnancies cannot be less than children in [Q. HH07].")
            return false
        }
        return true
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }


    fun hh04OnTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        segregate()
        /*Clear.clearAllFields(bi.fldGrpCVhh04, false)
        bi.fldGrpCVmh017.setVisibility(View.GONE)
        bi.llmh020.setVisibility(View.GONE)
        bi.fldGrpCVmh015.setVisibility(View.GONE)
        bi.fldGrpCVmh016.setVisibility(View.GONE)
        bi.fldGrpCVmh018.setVisibility(View.GONE)
        bi.llchild.setVisibility(View.GONE)
        patientType = "General"
        if (age >= 5110 && age < 18250 && bi.mh01002.isChecked()) {
            bi.fldGrpCVmh017.setVisibility(View.VISIBLE)
            bi.llmh020.setVisibility(View.VISIBLE)
            patientType = "MWRA"
        }
        if (age <= 1825) {
            bi.fldGrpCVmh015.setVisibility(View.VISIBLE)
            bi.fldGrpCVmh016.setVisibility(View.VISIBLE)
            bi.fldGrpCVmh018.setVisibility(View.VISIBLE)
            bi.llchild.setVisibility(View.VISIBLE)
            bi.mh012.setMinvalue(0.9f)
            bi.mh012.setMaxvalue(58f)
            bi.mh012.setMask("###.#")
            bi.mh012.setHint("###.#")
            patientType = "Child"
        }*/
    }

    private fun segregate() {

        /*var age: Int = 0
        Clear.clearAllFields(bi.fldGrpCVhh05, false)
        if (TextUtils.isEmpty(bi.hh04a.text) || TextUtils.isEmpty(bi.hh04b.text) || TextUtils.isEmpty(bi.hh04c.text)) return

        if ((bi.hh04a.text.toString() == "98" && bi.hh04b.text.toString() == "98" && bi.hh04c.text.toString() == "9998")) {
            Clear.clearAllFields(bi.fldGrpCVhh05, true)
        } else {
            age = bi.hh04a.text.toString().toInt() + bi.hh04b.text.toString().toInt() * 29 + bi.hh04c.text.toString().toInt() * 365
        }

        if (age in 1.. 5475) {
            Clear.clearAllFields(bi.llhh05)
            bi.llhh05.visibility = View.GONE
        } else {
            bi.llhh05.visibility = View.VISIBLE
        }*/
    }

    fun calculateAge(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (!bi.hh04a.text.toString().equals("") && !bi.hh04b.text.toString().equals("") && !bi.hh04c.text.toString().equals("")) {


            var dobDD = bi.hh04a.text.toString()
            var dobMM = bi.hh04b.text.toString()
            var dobYYYY = bi.hh04c.text.toString()
            var ageinYears = 0
            var ageinMonth = 0
            var ageinDay = 0
            if (dobYYYY.toInt() <= Calendar.getInstance().get(Calendar.YEAR) && dobYYYY.toInt() >= Calendar.getInstance().get(Calendar.YEAR) - 100) {

                ageinYears = Calendar.getInstance().get(Calendar.YEAR) - dobYYYY.toInt()


                if (dobMM.toInt() <= 12) {

                    ageinMonth = Calendar.getInstance().get(Calendar.MONTH) + 1 - dobMM.toInt()
                    Log.d(TAG, "calculateAge: m1 $ageinMonth " + Calendar.getInstance().get(Calendar.MONTH))
                    if (ageinMonth < 0) {
                        ageinYears--
                        ageinMonth = 12 + ageinMonth
                        Log.d(TAG, "calculateAge: m2 $ageinMonth")

                    }
                    if (dobDD.toInt() <= 31) {
                        ageinDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1 - dobDD.toInt()
                        if (ageinDay < 0) {
                            ageinMonth--
                            if (ageinMonth < 0) {
                                ageinYears--
                                ageinMonth = 12 + ageinMonth
                            }
                            ageinDay = 30 + ageinDay
                        }
                    }
                    bi.hh05m.setText(ageinMonth.toString())
                    bi.hh05m.isEnabled = false
                } else {
                    bi.hh05m.text = null
                    bi.hh05m.isEnabled = true
                }

                bi.hh05y.setText(ageinYears.toString())
                bi.hh05y.isEnabled = false

            } else {
                bi.hh05y.text = null
                bi.hh05y.isEnabled = true
            }


            //Calendar rightNow = Calendar.getInstance)
            // val df = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            // val dob = df.format(bi.hh04c.text.toString() + "-" + bi.hh04b.text.toString() + "-" + bi.hh04a.text.toString())

/*
            if (dobDD<31) {

            val ageindayss: Int = dobDiffInDays(getCalDate(bi.tsf201.getText().toString()),
                    getCalDate(MainApp.form.sysDate)
            )
            bi.tsf202.setText(ageindayss.toString())*/
        }
    }
}


