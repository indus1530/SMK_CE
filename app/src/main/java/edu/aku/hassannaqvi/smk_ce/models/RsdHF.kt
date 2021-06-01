package edu.aku.hassannaqvi.smk_ce.models

import android.database.Cursor
import android.provider.BaseColumns
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hussain.siddiqui on 01/06/2021.
 */

/*"
"pro_id": "3",
"dist_id": "301",
"hfcode": "301001",*/
class RsdHF {
    var tehsil_id: String = StringUtils.EMPTY
    var uc_Id: String = StringUtils.EMPTY
    var hf_Code: String = StringUtils.EMPTY
    var pro_id: String = StringUtils.EMPTY
    var dist_id: String = StringUtils.EMPTY

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): RsdHF {
        tehsil_id = jsonObject.getString(TablersdHF.COLUMN_TEHSIL_ID)
        uc_Id = jsonObject.getString(TablersdHF.COLUMN_UC_ID)
        hf_Code = jsonObject.getString(TablersdHF.COLUMN_HF_CODE)
        pro_id = jsonObject.getString(TablersdHF.COLUMN_PRO_ID)
        dist_id = jsonObject.getString(TablersdHF.COLUMN_DIST_ID)
        return this
    }

    fun hydrate(cursor: Cursor): RsdHF {
        tehsil_id = cursor.getString(cursor.getColumnIndex(TablersdHF.COLUMN_TEHSIL_ID))
        uc_Id = cursor.getString(cursor.getColumnIndex(TablersdHF.COLUMN_UC_ID))
        hf_Code = cursor.getString(cursor.getColumnIndex(TablersdHF.COLUMN_HF_CODE))
        pro_id = cursor.getString(cursor.getColumnIndex(TablersdHF.COLUMN_PRO_ID))
        dist_id = cursor.getString(cursor.getColumnIndex(TablersdHF.COLUMN_DIST_ID))

        return this
    }

    object TablersdHF : BaseColumns {
        const val TABLE_NAME = "rsd_hf"
        const val COLUMN_NAME_NULLABLE = "nullColumnHack"
        const val COLUMN_ID = "_ID"
        const val COLUMN_TEHSIL_ID = "tehsil_id"
        const val COLUMN_UC_ID = "uc_id"
        const val COLUMN_HF_CODE = "hfcode"
        const val COLUMN_PRO_ID = "pro_id"
        const val COLUMN_DIST_ID = "dist_id"
    }
}