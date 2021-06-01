package edu.aku.hassannaqvi.smk_ce.models

import android.database.Cursor
import android.provider.BaseColumns
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hussain.siddiqui on 01/06/2021.
 */

class Province {
    var province: String = StringUtils.EMPTY
    var pro_Id: String = StringUtils.EMPTY

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Province {
        province = jsonObject.getString(TableProvince.COLUMN_PROVINCE)
        pro_Id = jsonObject.getString(TableProvince.COLUMN_PRO_ID)
        return this
    }

    fun hydrate(cursor: Cursor): Province {
        province = cursor.getString(cursor.getColumnIndex(TableProvince.COLUMN_PROVINCE))
        pro_Id = cursor.getString(cursor.getColumnIndex(TableProvince.COLUMN_PRO_ID))

        return this
    }

    object TableProvince : BaseColumns {
        const val TABLE_NAME = "province"
        const val COLUMN_NAME_NULLABLE = "nullColumnHack"
        const val COLUMN_ID = "_ID"
        const val COLUMN_PROVINCE = "province"
        const val COLUMN_PRO_ID = "pro_id"
    }
}