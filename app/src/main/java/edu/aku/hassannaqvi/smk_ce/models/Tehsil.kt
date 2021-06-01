package edu.aku.hassannaqvi.smk_ce.models

import android.database.Cursor
import android.provider.BaseColumns
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hussain.siddiqui on 01/06/2021.
 */

class Tehsil {
    var tehsilId: String = StringUtils.EMPTY
    var tehsil: String = StringUtils.EMPTY
    var dist_id: String = StringUtils.EMPTY

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Tehsil {
        tehsilId = jsonObject.getString(TableTehsil.COLUMN_TEHSIL_ID)
        tehsil = jsonObject.getString(TableTehsil.COLUMN_TEHSIL)
        dist_id = jsonObject.getString(TableTehsil.COLUMN_DIST_ID)
        return this
    }

    fun hydrate(cursor: Cursor): Tehsil {
        tehsilId = cursor.getString(cursor.getColumnIndex(TableTehsil.COLUMN_TEHSIL_ID))
        tehsil = cursor.getString(cursor.getColumnIndex(TableTehsil.COLUMN_TEHSIL))
        dist_id = cursor.getString(cursor.getColumnIndex(TableTehsil.COLUMN_DIST_ID))
        return this
    }

    object TableTehsil: BaseColumns {
        const val TABLE_NAME = "tehsil"
        const val COLUMN_NAME_NULLABLE = "nullColumnHack"
        const val COLUMN_ID = "_ID"
        const val COLUMN_TEHSIL_ID = "tehsil_id"
        const val COLUMN_TEHSIL = "tehsil"
        const val COLUMN_DIST_ID = "dist_id"
    }
}