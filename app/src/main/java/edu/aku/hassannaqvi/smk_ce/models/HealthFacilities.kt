package edu.aku.hassannaqvi.smk_ce.models

import android.database.Cursor
import android.provider.BaseColumns
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hussain.siddiqui on 01/06/2021.
 */

class HealthFacilities {
    var tehsilId: String = StringUtils.EMPTY
    var uc_Id: String = StringUtils.EMPTY
    var hfcode: String = StringUtils.EMPTY
    var hf_name: String = StringUtils.EMPTY

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): HealthFacilities {
        tehsilId = jsonObject.getString(TableHealthFacilities.COLUMN_TEHSIL_ID)
        uc_Id = jsonObject.getString(TableHealthFacilities.COLUMN_UC_ID)
        hfcode = jsonObject.getString(TableHealthFacilities.COLUMN_HF_CODE)
        hf_name = jsonObject.getString(TableHealthFacilities.COLUMN_HF_NAME)
        return this
    }

    fun hydrate(cursor: Cursor): HealthFacilities {
        tehsilId = cursor.getString(cursor.getColumnIndex(TableHealthFacilities.COLUMN_TEHSIL_ID))
        uc_Id = cursor.getString(cursor.getColumnIndex(TableHealthFacilities.COLUMN_UC_ID))
        hfcode = cursor.getString(cursor.getColumnIndex(TableHealthFacilities.COLUMN_HF_CODE))
        hf_name = cursor.getString(cursor.getColumnIndex(TableHealthFacilities.COLUMN_HF_NAME))

        return this
    }

    object TableHealthFacilities : BaseColumns {
        const val TABLE_NAME = "lhw_hf"
        const val COLUMN_NAME_NULLABLE = "nullColumnHack"
        const val COLUMN_ID = "_ID"
        const val COLUMN_TEHSIL_ID = "tehsil_id"
        const val COLUMN_UC_ID = "uc_id"
        const val COLUMN_HF_CODE = "hfcode"
        const val COLUMN_HF_NAME = "hf_name"
    }
}