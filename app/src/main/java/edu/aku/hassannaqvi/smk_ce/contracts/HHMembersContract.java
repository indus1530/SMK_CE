package edu.aku.hassannaqvi.smk_ce.contracts;

import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class HHMembersContract {

    public static String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.smk_ce";

    public static abstract class HHMembersTable implements BaseColumns {
        public static final String TABLE_NAME = "HHInfo";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_SERIAL_NO = "serialNo";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_DISTRICT_CODE = "districtCode";
        public static final String COLUMN_DISTRICT_NAME = "districtName";
        public static final String COLUMN_TEHSIL_CODE = "tehsilCode";
        public static final String COLUMN_TEHSIL_NAME = "tehsilName";
        public static final String COLUMN_LHW_CODE = "lhwCode";
        public static final String COLUMN_LHW_NAME = "lhwName";
        public static final String COLUMN_KHANDAN_NUMBER = "khandanNumber";
        public static final String COLUMN_SA = "sA";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
    }
}
