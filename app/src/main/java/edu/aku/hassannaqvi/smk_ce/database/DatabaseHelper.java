package edu.aku.hassannaqvi.smk_ce.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.smk_ce.contracts.ADOLContract;
import edu.aku.hassannaqvi.smk_ce.contracts.FemaleMembersContract;
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract;
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.smk_ce.contracts.HHIDContract;
import edu.aku.hassannaqvi.smk_ce.contracts.LHWHouseholdContract.LHW_HOUSEHOLD_Table;
import edu.aku.hassannaqvi.smk_ce.contracts.MWRAContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;
import edu.aku.hassannaqvi.smk_ce.models.ADOLModel;
import edu.aku.hassannaqvi.smk_ce.models.Clusters;
import edu.aku.hassannaqvi.smk_ce.models.Clusters.TableClusters;
import edu.aku.hassannaqvi.smk_ce.models.Districts;
import edu.aku.hassannaqvi.smk_ce.models.Districts.TableDistricts;
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel;
import edu.aku.hassannaqvi.smk_ce.models.Form;
import edu.aku.hassannaqvi.smk_ce.models.HHIDModel;
import edu.aku.hassannaqvi.smk_ce.models.HealthFacilities;
import edu.aku.hassannaqvi.smk_ce.models.LHW;
import edu.aku.hassannaqvi.smk_ce.models.LHWHouseholdModel;
import edu.aku.hassannaqvi.smk_ce.models.MWRAModel;
import edu.aku.hassannaqvi.smk_ce.models.Province;
import edu.aku.hassannaqvi.smk_ce.models.Tehsil;
import edu.aku.hassannaqvi.smk_ce.models.Tehsil.TableTehsil;
import edu.aku.hassannaqvi.smk_ce.models.UCs;
import edu.aku.hassannaqvi.smk_ce.models.UCs.TableUCs;
import edu.aku.hassannaqvi.smk_ce.models.Users;
import edu.aku.hassannaqvi.smk_ce.models.Users.UsersTable;
import edu.aku.hassannaqvi.smk_ce.models.VersionApp;
import edu.aku.hassannaqvi.smk_ce.models.VersionApp.VersionAppTable;

/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, CreateTable.DATABASE_NAME, null, CreateTable.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable.SQL_CREATE_USERS);
        db.execSQL(CreateTable.SQL_CREATE_DISTRICTS);
        db.execSQL(CreateTable.SQL_CREATE_UCS);
        db.execSQL(CreateTable.SQL_CREATE_CLUSTERS);
        db.execSQL(CreateTable.SQL_CREATE_FORMS);
        db.execSQL(CreateTable.SQL_CREATE_HHIDENTIFY);
        db.execSQL(CreateTable.SQL_CREATE_LHW_HOUSEHOLD);
        db.execSQL(CreateTable.SQL_CREATE_HHMEMBERS);
        db.execSQL(CreateTable.SQL_CREATE_MWRA);
        db.execSQL(CreateTable.SQL_CREATE_ADOLESCENT);


        db.execSQL(CreateTable.SQL_CREATE_VERSIONAPP);

        db.execSQL(CreateTable.SQL_CREATE_LHW);
        db.execSQL(CreateTable.SQL_CREATE_TEHSIL);
        db.execSQL(CreateTable.SQL_CREATE_LHW_HF);
        db.execSQL(CreateTable.SQL_CREATE_PROVINCE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }


    /*
     * Addition in DB
     * */
    public Long addForm(Form form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsTable.COLUMN_UID, form.getUid());
        values.put(FormsTable.COLUMN_USERNAME, form.getUserName());
        values.put(FormsTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(FormsTable.COLUMN_HF_CODE, form.getHfCode());
        values.put(FormsTable.COLUMN_HF_NAME, form.getHfName());
        values.put(FormsTable.COLUMN_TEHSIL_CODE, form.getTehsilCode());
        values.put(FormsTable.COLUMN_TEHSIL_NAME, form.getTehsilName());
        values.put(FormsTable.COLUMN_LHW_CODE, form.getLhwCode());
        values.put(FormsTable.COLUMN_LHW_NAME, form.getLhwName());
        values.put(FormsTable.COLUMN_KHANDAN_NUMBER, form.getKhandanNumber());
        values.put(FormsTable.COLUMN_SA, form.getsA());
        values.put(FormsTable.COLUMN_SB, form.getsB());

        values.put(FormsTable.COLUMN_ISTATUS, form.getIStatus());
        values.put(FormsTable.COLUMN_ISTATUS96x, form.getIStatus96x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, form.getEndTime());

        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppver());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //HHIDENTIFY
    public Long addHHIdentify(HHIDModel model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HHIDContract.HHIDTable.COLUMN_PROJECT_NAME, model.getProjectName());
        values.put(HHIDContract.HHIDTable.COLUMN_UID, model.getUid());
        values.put(HHIDContract.HHIDTable.COLUMN_UUID, model.getUuid());
        values.put(HHIDContract.HHIDTable.COLUMN_SERIAL_NO, model.getSerialNo());
        values.put(HHIDContract.HHIDTable.COLUMN_USERNAME, model.getUserName());
        values.put(HHIDContract.HHIDTable.COLUMN_SYSDATE, model.getSysDate());
        values.put(HHIDContract.HHIDTable.COLUMN_HF_CODE, model.getHfCode());
        values.put(HHIDContract.HHIDTable.COLUMN_HF_NAME, model.getHfName());
        values.put(HHIDContract.HHIDTable.COLUMN_TEHSIL_CODE, model.getTehsilCode());
        values.put(HHIDContract.HHIDTable.COLUMN_TEHSIL_NAME, model.getTehsilName());
        values.put(HHIDContract.HHIDTable.COLUMN_LHW_CODE, model.getLhwCode());
        values.put(HHIDContract.HHIDTable.COLUMN_LHW_NAME, model.getLhwName());
        values.put(HHIDContract.HHIDTable.COLUMN_KHANDAN_NUMBER, model.getKhandanNumber());
        values.put(HHIDContract.HHIDTable.COLUMN_SA, model.getsA());
        values.put(HHIDContract.HHIDTable.COLUMN_STATUS, model.getStatus());
        values.put(HHIDContract.HHIDTable.COLUMN_ENDINGDATETIME, model.getEndTime());
        values.put(HHIDContract.HHIDTable.COLUMN_DEVICETAGID, model.getDeviceTag());
        values.put(HHIDContract.HHIDTable.COLUMN_DEVICEID, model.getDeviceId());
        values.put(HHIDContract.HHIDTable.COLUMN_APPVERSION, model.getAppver());

        long newRowId;
        newRowId = db.insert(
                HHIDContract.HHIDTable.TABLE_NAME,
                HHIDContract.HHIDTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //HHVERIFY
    public Long addLHW(LHWHouseholdModel model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LHW_HOUSEHOLD_Table.COLUMN_PROJECT_NAME, model.getProjectName());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_UID, model.getUid());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_USERNAME, model.getUserName());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_SYSDATE, model.getSysDate());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_HF_CODE, model.getHfCode());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_HF_NAME, model.getHfName());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_CODE, model.getTehsilCode());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_NAME, model.getTehsilName());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE, model.getLhwCode());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_LHW_NAME, model.getLhwName());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_KHANDAN_NUMBER, model.getKhandanNumber());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_RAND_NUMBERS, model.getRandSNo());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_LHWREG_PHOTO, model.getLhwphoto());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_DEVICETAGID, model.getDeviceTag());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_DEVICEID, model.getDeviceId());
        values.put(LHW_HOUSEHOLD_Table.COLUMN_APPVERSION, model.getAppver());

        long newRowId;
        newRowId = db.insert(
                LHW_HOUSEHOLD_Table.TABLE_NAME,
                LHW_HOUSEHOLD_Table.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;

    }


    //HHMEMBERS
    public Long addHHMembers(FemaleMembersModel model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_PROJECT_NAME, model.getProjectName());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_UID, model.getUid());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_UUID, model.getUuid());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SERIAL_NO, model.getSerialNo());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_USERNAME, model.getUserName());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SYSDATE, model.getSysDate());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_CODE, model.getHfCode());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_NAME, model.getHfName());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_CODE, model.getTehsilCode());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_NAME, model.getTehsilName());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_CODE, model.getLhwCode());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_NAME, model.getLhwName());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_KHANDAN_NUMBER, model.getKhandanNumber());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SA, model.getsA());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_STATUS, model.getStatus());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_ENDINGDATETIME, model.getEndTime());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICETAGID, model.getDeviceTag());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICEID, model.getDeviceId());
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_APPVERSION, model.getAppver());

        long newRowId;
        newRowId = db.insert(
                FemaleMembersContract.FemaleMembersTable.TABLE_NAME,
                FemaleMembersContract.FemaleMembersTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //MWRA
    public Long addMWRA(MWRAModel model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MWRAContract.MWRATable.COLUMN_PROJECT_NAME, model.getProjectName());
        values.put(MWRAContract.MWRATable.COLUMN_UID, model.getUid());
        values.put(MWRAContract.MWRATable.COLUMN_UUID, model.getUuid());
        values.put(MWRAContract.MWRATable.COLUMN_FMID, model.getFmid());
        values.put(MWRAContract.MWRATable.COLUMN_SERIAL_NO, model.getSerialNo());
        values.put(MWRAContract.MWRATable.COLUMN_USERNAME, model.getUserName());
        values.put(MWRAContract.MWRATable.COLUMN_SYSDATE, model.getSysDate());
        values.put(MWRAContract.MWRATable.COLUMN_DISTRICT_CODE, model.getDistrictCode());
        values.put(MWRAContract.MWRATable.COLUMN_DISTRICT_NAME, model.getDistrictName());
        values.put(MWRAContract.MWRATable.COLUMN_TEHSIL_CODE, model.getTehsilCode());
        values.put(MWRAContract.MWRATable.COLUMN_TEHSIL_NAME, model.getTehsilName());
        values.put(MWRAContract.MWRATable.COLUMN_LHW_CODE, model.getLhwCode());
        values.put(MWRAContract.MWRATable.COLUMN_LHW_NAME, model.getLhwName());
        values.put(MWRAContract.MWRATable.COLUMN_KHANDAN_NUMBER, model.getKhandanNumber());
        values.put(MWRAContract.MWRATable.COLUMN_SA, model.getsA());
        values.put(MWRAContract.MWRATable.COLUMN_STATUS, model.getStatus());
        values.put(MWRAContract.MWRATable.COLUMN_ENDINGDATETIME, model.getEndTime());
        values.put(MWRAContract.MWRATable.COLUMN_DEVICETAGID, model.getDeviceTag());
        values.put(MWRAContract.MWRATable.COLUMN_DEVICEID, model.getDeviceId());
        values.put(MWRAContract.MWRATable.COLUMN_APPVERSION, model.getAppver());

        long newRowId;
        newRowId = db.insert(
                MWRAContract.MWRATable.TABLE_NAME,
                MWRAContract.MWRATable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //ADOLESCENT
    public Long addADOL(ADOLModel model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ADOLContract.ADOLTable.COLUMN_PROJECT_NAME, model.getProjectName());
        values.put(ADOLContract.ADOLTable.COLUMN_UID, model.getUid());
        values.put(ADOLContract.ADOLTable.COLUMN_UUID, model.getUuid());
        values.put(ADOLContract.ADOLTable.COLUMN_FMID, model.getFmid());
        values.put(ADOLContract.ADOLTable.COLUMN_SERIAL_NO, model.getSerialNo());
        values.put(ADOLContract.ADOLTable.COLUMN_USERNAME, model.getUserName());
        values.put(ADOLContract.ADOLTable.COLUMN_SYSDATE, model.getSysDate());
        values.put(ADOLContract.ADOLTable.COLUMN_DISTRICT_CODE, model.getDistrictCode());
        values.put(ADOLContract.ADOLTable.COLUMN_DISTRICT_NAME, model.getDistrictName());
        values.put(ADOLContract.ADOLTable.COLUMN_TEHSIL_CODE, model.getTehsilCode());
        values.put(ADOLContract.ADOLTable.COLUMN_TEHSIL_NAME, model.getTehsilName());
        values.put(ADOLContract.ADOLTable.COLUMN_LHW_CODE, model.getLhwCode());
        values.put(ADOLContract.ADOLTable.COLUMN_LHW_NAME, model.getLhwName());
        values.put(ADOLContract.ADOLTable.COLUMN_KHANDAN_NUMBER, model.getKhandanNumber());
        values.put(ADOLContract.ADOLTable.COLUMN_SA, model.getsA());
        values.put(ADOLContract.ADOLTable.COLUMN_STATUS, model.getStatus());
        values.put(ADOLContract.ADOLTable.COLUMN_ENDINGDATETIME, model.getEndTime());
        values.put(ADOLContract.ADOLTable.COLUMN_DEVICETAGID, model.getDeviceTag());
        values.put(ADOLContract.ADOLTable.COLUMN_DEVICEID, model.getDeviceId());
        values.put(ADOLContract.ADOLTable.COLUMN_APPVERSION, model.getAppver());

        long newRowId;
        newRowId = db.insert(
                ADOLContract.ADOLTable.TABLE_NAME,
                ADOLContract.ADOLTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    /*
     * Functions that dealing with table data
     * */
    public Users getLoginUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UsersTable.COLUMN_ID,
                UsersTable.COLUMN_USERNAME,
                UsersTable.COLUMN_PASSWORD,
                UsersTable.COLUMN_FULLNAME,
                UsersTable.COLUMN_DIST_ID,
        };
        String whereClause = UsersTable.COLUMN_USERNAME + "=? AND " + UsersTable.COLUMN_PASSWORD + "=?";
        String[] whereArgs = {username, password};
        String groupBy = null;
        String having = null;
        String orderBy = UsersTable.COLUMN_ID + " ASC";

        Users allForms = null;
        try {
            c = db.query(
                    UsersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allForms = new Users().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }


    public ArrayList<Form> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS96x,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form forms = new Form();
                forms.setId(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                forms.setUid(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                forms.setSysDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                forms.setUserName(c.getString(c.getColumnIndex(FormsTable.COLUMN_USERNAME)));
                allForms.add(forms);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }


    public ArrayList<FemaleMembersModel> getFamilyMembersBYUID(String lhwcode, String khandannumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String whereClause = FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_CODE + " = ? AND " + FemaleMembersContract.FemaleMembersTable.COLUMN_KHANDAN_NUMBER + " = ? ";
        String[] whereArgs = {lhwcode, khandannumber};
        String groupBy = null;
        String having = null;
        String orderBy = FemaleMembersContract.FemaleMembersTable.COLUMN_ID + " ASC";
        ArrayList<FemaleMembersModel> FemalesByHH = new ArrayList<>();
        try {
            c = db.query(
                    FemaleMembersContract.FemaleMembersTable.TABLE_NAME,  // The table to query
                    null,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FemaleMembersModel femalemembers = new FemaleMembersModel().Hydrate(c);
                /* int age = Integer.parseInt(femalemembers.getHh05y());
                boolean isFemale = femalemembers.getHh03().equals("2");
                boolean notMarried = femalemembers.getHh06().equals("2");
               if (
                    // Adolescent: Male + Female - 10 to 19
                        (age >= 10 && age < 20 && notMarried)
                                ||
                                // MWRA: Married females between 14 to 49
                                (age >= 14 && age < 50 && !notMarried && isFemale)

                ) {*/
                FemalesByHH.add(femalemembers);
                // }
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return FemalesByHH;
    }


    public ArrayList<Districts> getAllDistricts() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = TableDistricts._ID + " ASC";
        ArrayList<Districts> all = new ArrayList<>();
        try {
            c = db.query(
                    TableDistricts.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                all.add(new Districts().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return all;
    }

    public Collection<LHW> getAllLHW() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = LHW.TableLhw._ID + " ASC";
        Collection<LHW> all = new ArrayList<>();
        try {
            c = db.query(
                    LHW.TableLhw.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                all.add(new LHW().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return all;
    }

    public String getDistrictNameByID(String dist_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = TableDistricts.COLUMN_DISTRICT_CODE + " = ?";
        String[] whereArgs = {dist_id};
        String groupBy = null;
        String having = null;

        String orderBy = TableDistricts._ID + " ASC";
        Districts all = new Districts();
        try {
            c = db.query(
                    TableDistricts.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {

                all = new Districts().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return all.getDistrictName();
    }


    public ArrayList<Tehsil> getAllTehsils() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = TableTehsil._ID + " ASC";
        ArrayList<Tehsil> all = new ArrayList<>();
        try {
            c = db.query(
                    TableTehsil.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                all.add(new Tehsil().hydrate(c));

            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return all;
    }


    public ArrayList<Tehsil> getTehsilsByDistID(String dist_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = TableTehsil.COLUMN_DIST_ID + "=?";
        String[] whereArgs = {dist_id};
        String groupBy = null;
        String having = null;

        String orderBy = TableTehsil._ID + " ASC";
        ArrayList<Tehsil> all = new ArrayList<>();
        try {
            c = db.query(
                    TableTehsil.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                all.add(new Tehsil().hydrate(c));

            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return all;
    }


    public ArrayList<HealthFacilities> getHFByTehsil(String tehsilCode) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = HealthFacilities.TableHealthFacilities.COLUMN_TEHSIL_ID + "=?";
        String[] whereArgs = {tehsilCode};
        String groupBy = null;
        String having = null;

        String orderBy = HealthFacilities.TableHealthFacilities.COLUMN_HF_NAME + " ASC";
        ArrayList<HealthFacilities> hf = new ArrayList<>();
        try {
            c = db.query(
                    HealthFacilities.TableHealthFacilities.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                hf.add(new HealthFacilities().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return hf;
    }

    public ArrayList<LHW> getLHWByHF(String hfCode) {
        Log.d(TAG, "getLHWByHF: hfcode " + hfCode);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = LHW.TableLhw.COLUMN_HF_CODE + "=?";
        String[] whereArgs = {hfCode};
        String groupBy = null;
        String having = null;

        String orderBy = LHW.TableLhw.COLUMN_LHW_NAME + " ASC";
        ArrayList<LHW> lhw = new ArrayList<>();
        try {
            c = db.query(
                    LHW.TableLhw.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                lhw.add(new LHW().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return lhw;
    }

    public Boolean getRegisteredLHWByCode(String lhwcode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE + "=?";
        String[] whereArgs = {lhwcode};
        String groupBy = null;
        String having = null;

        String orderBy = LHW_HOUSEHOLD_Table.COLUMN_LHW_NAME + " ASC";
        //LHWHouseholdModel lhwhousehold = null;
        int cCount = 0;
        try {
            c = db.query(
                    LHW_HOUSEHOLD_Table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            cCount = c.getCount();
         /*   while (c.moveToNext()) {
                lhwhousehold = new LHWHouseholdModel().Hydrate(c);
            }*/
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return cCount > 0;
    }

    public ArrayList<HHIDModel> getKhandanNumberByLHW(String lhwCode) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = HHIDContract.HHIDTable.COLUMN_LHW_CODE + "=?";
        String[] whereArgs = {lhwCode};
        String groupBy = null;
        String having = null;

        String orderBy = HHIDContract.HHIDTable.COLUMN_LHW_NAME + " ASC";
        ArrayList<HHIDModel> hhid = new ArrayList<>();
        try {
            c = db.query(
                    HHIDContract.HHIDTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                hhid.add(new HHIDModel().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return hhid;
    }


    public ArrayList<UCs> getUCsByDistricts(String dCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = TableUCs.COLUMN_DISTRICT_CODE + "=?";
        String[] whereArgs = new String[]{dCode};
        String groupBy = null;
        String having = null;

        String orderBy = TableUCs.COLUMN_UC_CODE + " ASC";

        ArrayList<UCs> allDC = new ArrayList<>();
        try {
            c = db.query(
                    TableUCs.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCs dc = new UCs();
                allDC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public Form getFormByClusterHH(String distCode, String subAreaCode, String hh) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_HF_CODE + "=? AND " +
                FormsTable.COLUMN_LHW_CODE + "=? AND " +
                FormsTable.COLUMN_KHANDAN_NUMBER + "=? AND " +
                FormsTable.COLUMN_SYNCED + " is null AND " +
                FormsTable.COLUMN_ISTATUS + "=?";

        String[] whereArgs = {distCode, subAreaCode, hh, "2"};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form allFC = null;
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allFC = new Form().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Form getFormByKhandanNumber(String lhwcode, String kno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause =
                FormsTable.COLUMN_LHW_CODE + "=? AND " +
                        FormsTable.COLUMN_KHANDAN_NUMBER + "=?";

        String[] whereArgs = {lhwcode, kno};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form allFC = null;
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allFC = new Form().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<Form> getFormByLHW(String lhwcode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause =
                FormsTable.COLUMN_LHW_CODE + "=?";

        String[] whereArgs = {"%" + lhwcode + "%"};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForm = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form Form = new Form();
                Form.setId(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                Form.setUid(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                Form.setSysDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                Form.setIStatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                Form.setKhandanNumber(c.getString(c.getColumnIndex(FormsTable.COLUMN_KHANDAN_NUMBER)));
                Form.setHfName(c.getString(c.getColumnIndex(FormsTable.COLUMN_HF_NAME)));
                Form.setLhwName(c.getString(c.getColumnIndex(FormsTable.COLUMN_LHW_NAME)));
                Form.setLhwCode(c.getString(c.getColumnIndex(FormsTable.COLUMN_LHW_CODE)));
                Form.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                Form.setsA(c.getString(c.getColumnIndex(FormsTable.COLUMN_SA)));
                allForm.add(Form);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForm;
    }

    public int checkLHWHHNo(String lhwcode, String kno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause =
                HHIDContract.HHIDTable.COLUMN_LHW_CODE + "=? AND " +
                        HHIDContract.HHIDTable.COLUMN_KHANDAN_NUMBER + "=?";

        String[] whereArgs = {lhwcode, kno};

        String groupBy = null;
        String having = null;

        String orderBy = HHIDContract.HHIDTable.COLUMN_ID + " ASC";

        int cCount;
        try {
            c = db.query(
                    HHIDContract.HHIDTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            cCount = c.getCount();
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return cCount;
    }

    public int checkLHW(String lhwcode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause =
                LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE + "=? ";

        String[] whereArgs = {lhwcode};

        String groupBy = null;
        String having = null;

        String orderBy = LHW_HOUSEHOLD_Table.COLUMN_ID + " ASC";

        int cCount;
        try {
            c = db.query(
                    HHIDContract.HHIDTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            cCount = c.getCount();

        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return cCount;
    }

    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public BLRandom getHHFromBLRandom(String subAreaCode, String hh) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        String[] columns = {
                BLRandomContract.BLRandomTable.COLUMN_ID,
                BLRandomContract.BLRandomTable.COLUMN_LUID,
                BLRandomContract.BLRandomTable.COLUMN_STRUCTURE_NO,
                BLRandomContract.BLRandomTable.COLUMN_FAMILY_EXT_CODE,
                BLRandomContract.BLRandomTable.COLUMN_HH,
                BLRandomContract.BLRandomTable.COLUMN_P_CODE,
                BLRandomContract.BLRandomTable.COLUMN_EB_CODE,
                BLRandomContract.BLRandomTable.COLUMN_RANDOMDT,
                BLRandomContract.BLRandomTable.COLUMN_HH_SELECTED_STRUCT,
                BLRandomContract.BLRandomTable.COLUMN_CONTACT,
                BLRandomContract.BLRandomTable.COLUMN_HH_HEAD,
                BLRandomContract.BLRandomTable.COLUMN_SNO_HH
        };

        String whereClause = BLRandomContract.BLRandomTable.COLUMN_P_CODE + "=? AND " + BLRandomContract.BLRandomTable.COLUMN_HH + "=?";
        String[] whereArgs = new String[]{subAreaCode, hh};
        String groupBy = null;
        String having = null;

        String orderBy =
                BLRandomContract.BLRandomTable.COLUMN_ID + " ASC";

        BLRandom allBL = null;
        try {
            c = db.query(
                    BLRandomContract.BLRandomTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allBL = new BLRandom().hydrate(c);
            }
        } catch (SQLiteException e) {


        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allBL;
    }*/


    /*
     * Update data in tables
     * */


    public int updatesFemaleMemberbyUUID(String uuid) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_STATUS, "1");

        String selection = FemaleMembersContract.FemaleMembersTable.COLUMN_UID + " =? ";
        String[] selectionArgs = {uuid};

        return db.update(FemaleMembersContract.FemaleMembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsContract.FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesHHIDColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = HHIDContract.HHIDTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.hhid.getId())};

        return db.update(HHIDContract.HHIDTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesLHWHouseholdColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = LHW_HOUSEHOLD_Table._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.lhwHousehold.getId())};

        return db.update(LHW_HOUSEHOLD_Table.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesHHMEMColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FemaleMembersContract.FemaleMembersTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.femalemembers.getId())};

        return db.update(FemaleMembersContract.FemaleMembersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesMWRAColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = MWRAContract.MWRATable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.mwra.getId())};

        return db.update(MWRAContract.MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesADOLColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ADOLContract.ADOLTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.adol.getId())};

        return db.update(ADOLContract.ADOLTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS, MainApp.form.getIStatus());
        //values.put(FormsContract.FormsTable.COLUMN_ISTATUS, MainApp.form.getHh26());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, MainApp.form.getIStatus96x());
        values.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, MainApp.form.getEndTime());

        // Which row to update, based on the ID
        String selection = FormsContract.FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    /*
     * Download data functions
     * */
    public int syncDistricts(JSONArray Districtslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Districts.TableDistricts.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < Districtslist.length(); i++) {
                JSONObject jsonObjectDistrict = Districtslist.getJSONObject(i);
                Districts District = new Districts();
                District.sync(jsonObjectDistrict);
                ContentValues values = new ContentValues();

                values.put(TableDistricts.COLUMN_DISTRICT_CODE, District.getDistrictCode());
                values.put(TableDistricts.COLUMN_DISTRICT_NAME, District.getDistrictName());
                long rowID = db.insert(TableDistricts.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncDistrict(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncCluster(JSONArray clusterList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableClusters.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < clusterList.length(); i++) {
                JSONObject jsonObjectCluster = clusterList.getJSONObject(i);
                Clusters cluster = new Clusters();
                cluster.sync(jsonObjectCluster);
                ContentValues values = new ContentValues();

                values.put(TableClusters.COLUMN_CLUSTER_CODE, cluster.getClusterCode());
                values.put(TableClusters.COLUMN_CLUSTER_NAME, cluster.getClustername());
                values.put(TableClusters.COLUMN_DIST_CODE, cluster.getDistCode());

                long rowID = db.insert(TableClusters.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncCluster(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public int syncUCs(JSONArray ucList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableUCs.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < ucList.length(); i++) {
                JSONObject jsonObjectUc = ucList.getJSONObject(i);
                UCs uc = new UCs();
                uc.sync(jsonObjectUc);
                ContentValues values = new ContentValues();

                values.put(TableUCs.COLUMN_UC_CODE, uc.getUcCode());
                values.put(TableUCs.COLUMN_UC_NAME, uc.getUcName());
                values.put(TableUCs.COLUMN_DISTRICT_CODE, uc.getDistrictCode());

                long rowID = db.insert(TableUCs.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncUc(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public int syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionAppTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionAppTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }


    public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
                values.put(UsersTable.COLUMN_DIST_ID, user.getDist_id());
                long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    //    Sync LHW
    public int syncLhw(JSONArray lhwList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LHW.TableLhw.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < lhwList.length(); i++) {
                JSONObject json = lhwList.getJSONObject(i);
                LHW lhw = new LHW();
                lhw.sync(json);
                ContentValues values = new ContentValues();

                values.put(LHW.TableLhw.COLUMN_HF_CODE, lhw.getHf_Code());
                values.put(LHW.TableLhw.COLUMN_LHW_CODE, lhw.getLhw_Code());
                values.put(LHW.TableLhw.COLUMN_LHW_NAME, lhw.getLhw_Name());
                values.put(LHW.TableLhw.COLUMN_TEHSIL_ID, lhw.getTehsilId());
                values.put(LHW.TableLhw.COLUMN_UC_ID, lhw.getUc_Id());

                long rowID = db.insert(LHW.TableLhw.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncLhw(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    //    Sync Tehsil
    public int syncTehsil(JSONArray tehsilList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Tehsil.TableTehsil.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < tehsilList.length(); i++) {
                JSONObject json = tehsilList.getJSONObject(i);
                Tehsil tehsil = new Tehsil();
                tehsil.sync(json);
                ContentValues values = new ContentValues();

                values.put(Tehsil.TableTehsil.COLUMN_DIST_ID, tehsil.getDist_id());
                values.put(Tehsil.TableTehsil.COLUMN_TEHSIL, tehsil.getTehsil());
                values.put(Tehsil.TableTehsil.COLUMN_TEHSIL_ID, tehsil.getTehsilId());

                long rowID = db.insert(Tehsil.TableTehsil.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncLhw(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    //    Sync LHWHF
    public int syncLhwHF(JSONArray lhwHFList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(HealthFacilities.TableHealthFacilities.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < lhwHFList.length(); i++) {
                JSONObject json = lhwHFList.getJSONObject(i);
                HealthFacilities lhwHF = new HealthFacilities();
                lhwHF.sync(json);
                ContentValues values = new ContentValues();

                values.put(HealthFacilities.TableHealthFacilities.COLUMN_HF_CODE, lhwHF.getHfcode());
                values.put(HealthFacilities.TableHealthFacilities.COLUMN_HF_NAME, lhwHF.getHf_name());
                values.put(HealthFacilities.TableHealthFacilities.COLUMN_TEHSIL_ID, lhwHF.getTehsilId());
                values.put(HealthFacilities.TableHealthFacilities.COLUMN_UC_ID, lhwHF.getUc_Id());

                long rowID = db.insert(HealthFacilities.TableHealthFacilities.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncLhw(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    //    Sync PROVINCE
    public int syncProvince(JSONArray provinceList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Province.TableProvince.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < provinceList.length(); i++) {
                JSONObject json = provinceList.getJSONObject(i);
                Province province = new Province();
                province.sync(json);
                ContentValues values = new ContentValues();

                values.put(Province.TableProvince.COLUMN_PROVINCE, province.getProvince());
                values.put(Province.TableProvince.COLUMN_PRO_ID, province.getPro_Id());

                long rowID = db.insert(Province.TableProvince.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncLhw(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }



    //get UnSyncedTables
    public JSONArray getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_SYNCED + " is null AND "+
                FormsTable.COLUMN_ISTATUS + "= '1'";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        JSONArray allForms = new JSONArray();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                /** WorkManager Upload
                 /*Form fc = new Form();
                 allFC.add(fc.Hydrate(c));*/
                Log.d(TAG, "getUnsyncedForms: " + c.getCount());
                Form form = new Form();
                allForms.put(form.Hydrate(c).toJSONObject());


            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedForms: " + allForms.toString().length());
        Log.d(TAG, "getUnsyncedForms: " + allForms);
        return allForms;
    }

    public JSONArray getUnsyncedLHW() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = LHW_HOUSEHOLD_Table.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = LHW_HOUSEHOLD_Table.COLUMN_ID + " ASC";

        JSONArray allLHW = new JSONArray();
        try {
            c = db.query(
                    LHW_HOUSEHOLD_Table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedLHW: " + c.getCount());
                LHWHouseholdModel lhw = new LHWHouseholdModel();
                allLHW.put(lhw.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedLHW: " + allLHW.toString().length());
        Log.d(TAG, "getUnsyncedLHW: " + allLHW);
        return allLHW;
    }

    public JSONArray getUnsyncedHHID() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = HHIDContract.HHIDTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = HHIDContract.HHIDTable.COLUMN_ID + " ASC";

        JSONArray allHHid = new JSONArray();
        try {
            c = db.query(
                    HHIDContract.HHIDTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedHHID: " + c.getCount());
                HHIDModel hhid = new HHIDModel();
                allHHid.put(hhid.hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedHHID: " + allHHid.toString().length());
        Log.d(TAG, "getUnsyncedHHID: " + allHHid);
        return allHHid;
    }

    public JSONArray getUnsyncedAdol() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = ADOLContract.ADOLTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = ADOLContract.ADOLTable.COLUMN_ID + " ASC";

        JSONArray allAdol = new JSONArray();
        try {
            c = db.query(
                    ADOLContract.ADOLTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedAdol: " + c.getCount());
                ADOLModel adol = new ADOLModel();
                allAdol.put(adol.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedAdol: " + allAdol.toString().length());
        Log.d(TAG, "getUnsyncedAdol: " + allAdol);
        return allAdol;
    }

    public JSONArray getUnsyncedMwra() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = MWRAContract.MWRATable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = MWRAContract.MWRATable.COLUMN_ID + " ASC";

        JSONArray allMwra = new JSONArray();
        try {
            c = db.query(
                    MWRAContract.MWRATable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedMwra: " + c.getCount());
                MWRAModel mwra = new MWRAModel();
                allMwra.put(mwra.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedMwra: " + allMwra.toString().length());
        Log.d(TAG, "getUnsyncedMwra: " + allMwra);
        return allMwra;
    }
    public JSONArray getUnsyncedFemaleMembers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FemaleMembersContract.FemaleMembersTable.COLUMN_ID + " ASC";

        JSONArray allFemaleMembers = new JSONArray();
        try {
            c = db.query(
                    FemaleMembersContract.FemaleMembersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedFemaleMembers: " + c.getCount());
                FemaleMembersModel femaleMembers = new FemaleMembersModel();
                allFemaleMembers.put(femaleMembers.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedFemaleMembers: " + allFemaleMembers.toString().length());
        Log.d(TAG, "getUnsyncedFemaleMembers: " + allFemaleMembers);
        return allFemaleMembers;
    }


    //update SyncedTables
    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_SYNCED, true);
        values.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsContract.FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsContract.FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedLHW_HOUSEHOLD(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(LHW_HOUSEHOLD_Table.COLUMN_SYNCED, true);
        values.put(LHW_HOUSEHOLD_Table.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = LHW_HOUSEHOLD_Table.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                LHW_HOUSEHOLD_Table.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedHHID(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(HHIDContract.HHIDTable.COLUMN_SYNCED, true);
        values.put(HHIDContract.HHIDTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = HHIDContract.HHIDTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                HHIDContract.HHIDTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedADOL(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ADOLContract.ADOLTable.COLUMN_SYNCED, true);
        values.put(ADOLContract.ADOLTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ADOLContract.ADOLTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ADOLContract.ADOLTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedMWRA(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRAContract.MWRATable.COLUMN_SYNCED, true);
        values.put(MWRAContract.MWRATable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = MWRAContract.MWRATable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                MWRAContract.MWRATable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedFemaleMembers(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED, true);
        values.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FemaleMembersContract.FemaleMembersTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FemaleMembersContract.FemaleMembersTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public Collection<Form> getUnclosedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_ISTATUS + " = ''";
        String[] whereArgs = null;
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        Collection<Form> allForm = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form Form = new Form();
                Form.setId(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                Form.setUid(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                Form.setSysDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                Form.setIStatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                Form.setKhandanNumber(c.getString(c.getColumnIndex(FormsTable.COLUMN_KHANDAN_NUMBER)));
                Form.setHfName(c.getString(c.getColumnIndex(FormsTable.COLUMN_HF_NAME)));
                Form.setLhwName(c.getString(c.getColumnIndex(FormsTable.COLUMN_LHW_NAME)));
                Form.setLhwCode(c.getString(c.getColumnIndex(FormsTable.COLUMN_LHW_CODE)));
                Form.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                Form.setsA(c.getString(c.getColumnIndex(FormsTable.COLUMN_SA)));

                allForm.add(Form);
            }
        } catch (SQLiteException e) {


        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForm;
    }






    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public void getFormByID(@NotNull String lhwCode, @NotNull String khandanNumber) {

    }


    public Collection<Form> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = {"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForm = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form Form = new Form();
                Form.setId(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                Form.setUid(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                Form.setSysDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                Form.setIStatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                Form.setKhandanNumber(c.getString(c.getColumnIndex(FormsTable.COLUMN_KHANDAN_NUMBER)));
                Form.setHfName(c.getString(c.getColumnIndex(FormsTable.COLUMN_HF_NAME)));
                Form.setLhwName(c.getString(c.getColumnIndex(FormsTable.COLUMN_LHW_NAME)));
                Form.setLhwCode(c.getString(c.getColumnIndex(FormsTable.COLUMN_LHW_CODE)));
                Form.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                Form.setsA(c.getString(c.getColumnIndex(FormsTable.COLUMN_SA)));
                allForm.add(Form);
            }
        } catch (SQLiteException e) {


        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForm;
    }

    public Collection<HHIDModel> getHHIDByLHW(String lhwcode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause =
                HHIDContract.HHIDTable.COLUMN_LHW_CODE + "=?";

        String[] whereArgs = {"%" + lhwcode + "%"};

        String groupBy = null;
        String having = null;

        String orderBy = HHIDContract.HHIDTable.COLUMN_ID + " ASC";

        Collection<HHIDModel> allHHID = new ArrayList<>();
        try {
            c = db.query(
                    HHIDContract.HHIDTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HHIDModel HHID = new HHIDModel();
                HHID.setId(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_ID)));
                HHID.setUid(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_UID)));
                HHID.setSysDate(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SYSDATE)));
                HHID.setKhandanNumber(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_KHANDAN_NUMBER)));
                HHID.setHfName(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_HF_NAME)));
                HHID.setLhwName(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_LHW_NAME)));
                HHID.setLhwCode(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_LHW_CODE)));
                HHID.setSynced(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SYNCED)));
                HHID.setsA(c.getString(c.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SA)));
                allHHID.add(HHID);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allHHID;
    }

}