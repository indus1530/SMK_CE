package edu.aku.hassannaqvi.smk_ce.models

import android.database.Cursor
import android.provider.BaseColumns
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hussain.siddiqui on 01/06/2021.
 */

class Lhw {
    var tehsilId: String = StringUtils.EMPTY
    var uc_Id: String = StringUtils.EMPTY
    var hf_Code: String = StringUtils.EMPTY
    var lhw_Name: String = StringUtils.EMPTY
    var lhw_Code: String = StringUtils.EMPTY

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Lhw {
        tehsilId = jsonObject.getString(TableLhw.COLUMN_TEHSIL_ID)
        uc_Id = jsonObject.getString(TableLhw.COLUMN_UC_ID)
        hf_Code = jsonObject.getString(TableLhw.COLUMN_HF_CODE)
        lhw_Name = jsonObject.getString(TableLhw.COLUMN_LHW_NAME)
        lhw_Code = jsonObject.getString(TableLhw.COLUMN_LHW_CODE)
        return this
    }

    fun hydrate(cursor: Cursor): Lhw {
        tehsilId = cursor.getString(cursor.getColumnIndex(TableLhw.COLUMN_TEHSIL_ID))
        uc_Id = cursor.getString(cursor.getColumnIndex(TableLhw.COLUMN_UC_ID))
        hf_Code = cursor.getString(cursor.getColumnIndex(TableLhw.COLUMN_HF_CODE))
        lhw_Name = cursor.getString(cursor.getColumnIndex(TableLhw.COLUMN_LHW_NAME))
        lhw_Code = cursor.getString(cursor.getColumnIndex(TableLhw.COLUMN_LHW_CODE))

        return this
    }

    object TableLhw : BaseColumns {
        const val TABLE_NAME = "lhw"
        const val COLUMN_NAME_NULLABLE = "nullColumnHack"
        const val COLUMN_ID = "_ID"
        const val COLUMN_TEHSIL_ID = "tehsil_id"
        const val COLUMN_UC_ID = "uc_id"
        const val COLUMN_HF_CODE = "hfcode"
        const val COLUMN_LHW_NAME = "lhw_name"
        const val COLUMN_LHW_CODE = "lhw_code"
    }
}