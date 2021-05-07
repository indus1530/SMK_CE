package edu.aku.hassannaqvi.smk_ce.contracts;

import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class MHContract {


    public static abstract class MHTable implements BaseColumns {
        public static final String TABLE_NAME = "MobileHealth";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_SA = "sA";
        public static final String COLUMN_MH01 = "mh01";
        public static final String COLUMN_MH02 = "mh02";
        public static final String COLUMN_MH03 = "mh03";
        public static final String COLUMN_MH04 = "mh04";
        public static final String COLUMN_MH05 = "mh05";
        public static final String COLUMN_MH06 = "mh06";
        public static final String COLUMN_MH07 = "mh07";

        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_STATUS = "status";
    }
}
