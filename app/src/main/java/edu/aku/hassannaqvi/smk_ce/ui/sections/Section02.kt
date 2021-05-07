package edu.aku.hassannaqvi.smk_ce.ui.sections

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.aku.hassannaqvi.smk_ce.R
import edu.aku.hassannaqvi.smk_ce.databinding.ActivitySection02Binding

class Section02 : AppCompatActivity() {

    lateinit var bi: ActivitySection02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section02)
        bi.callback = this
    }


    fun BtnContinue(view: View) {
        /*if (!formValidation()) return
        try {
            saveDraft()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        if (UpdateDB()) {
            finish()
            startActivity(Intent(this, SectionG415Activity::class.java))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }*/
    }


    fun BtnEnd(view: View) {
        //openSectionMainActivity(this, "G")
    }


}