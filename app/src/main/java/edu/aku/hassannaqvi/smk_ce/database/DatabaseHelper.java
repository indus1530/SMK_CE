package edu.aku.hassannaqvi.smk_ce.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.smk_ce.contracts.ChildContract;
import edu.aku.hassannaqvi.smk_ce.contracts.ChildContract.ChildTable;
import edu.aku.hassannaqvi.smk_ce.contracts.ChildInformationContract;
import edu.aku.hassannaqvi.smk_ce.contracts.ChildInformationContract.ChildInfoTable;
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract;
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.smk_ce.contracts.IMContract;
import edu.aku.hassannaqvi.smk_ce.contracts.IMContract.IMTable;
import edu.aku.hassannaqvi.smk_ce.contracts.MHContract;
import edu.aku.hassannaqvi.smk_ce.contracts.MHContract.MHTable;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;
import edu.aku.hassannaqvi.smk_ce.models.BLRandom;
import edu.aku.hassannaqvi.smk_ce.models.BLRandom.TableRandom;
import edu.aku.hassannaqvi.smk_ce.models.Camps;
import edu.aku.hassannaqvi.smk_ce.models.Child;
import edu.aku.hassannaqvi.smk_ce.models.ChildInformation;
import edu.aku.hassannaqvi.smk_ce.models.Clusters;
import edu.aku.hassannaqvi.smk_ce.models.Clusters.TableClusters;
import edu.aku.hassannaqvi.smk_ce.models.Districts;
import edu.aku.hassannaqvi.smk_ce.models.Districts.TableDistricts;
import edu.aku.hassannaqvi.smk_ce.models.Doctor;
import edu.aku.hassannaqvi.smk_ce.models.Form;
import edu.aku.hassannaqvi.smk_ce.models.FormIndicatorsModel;
import edu.aku.hassannaqvi.smk_ce.models.Immunization;
import edu.aku.hassannaqvi.smk_ce.models.MobileHealth;
import edu.aku.hassannaqvi.smk_ce.models.UCs;
import edu.aku.hassannaqvi.smk_ce.models.UCs.TableUCs;
import edu.aku.hassannaqvi.smk_ce.models.Users;
import edu.aku.hassannaqvi.smk_ce.models.Users.UsersTable;
import edu.aku.hassannaqvi.smk_ce.models.VersionApp;
import edu.aku.hassannaqvi.smk_ce.models.VersionApp.VersionAppTable;

import static edu.aku.hassannaqvi.smk_ce.core.MainApp.mobileHealth;

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
        db.execSQL(CreateTable.SQL_CREATE_CHILD_INFO);
        db.execSQL(CreateTable.SQL_CREATE_CHILD);
        db.execSQL(CreateTable.SQL_CREATE_IMMUNIZATION);
        db.execSQL(CreateTable.SQL_CREATE_MOBILE_HEALTH);
        db.execSQL(CreateTable.SQL_CREATE_VERSIONAPP);
        db.execSQL(CreateTable.SQL_CREATE_BL_RANDOM);
        db.execSQL(CreateTable.SQL_CREATE_CAMP);
        db.execSQL(CreateTable.SQL_CREATE_DOCTOR);
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
        values.put(FormsTable.COLUMN_CLUSTER, form.getLhwCode());
        values.put(FormsTable.COLUMN_HHNO, form.getKhandanNumber());
        values.put(FormsTable.COLUMN_DCODE, form.getDistrictCode());
        values.put(FormsTable.COLUMN_UCODE, form.getTehsilCode());
        values.put(FormsTable.COLUMN_SA, form.getsA());
        values.put(FormsTable.COLUMN_SB, form.getsB());
        values.put(FormsTable.COLUMN_SC, form.getsC());
        values.put(FormsTable.COLUMN_SD, form.getsD());
        values.put(FormsTable.COLUMN_SE, form.getsE());

        values.put(FormsTable.COLUMN_ISTATUS, form.getIStatus());
        values.put(FormsTable.COLUMN_ISTATUS96x, form.getIStatus96x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, form.getEndTime());

        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppver());
        values.put(FormsTable.COLUMN_G5FLAG, form.getG5Flag());
        values.put(FormsTable.COLUMN_HHFLAG, form.getHhflag());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChild(Child child) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ChildContract.ChildTable.COLUMN_PROJECT_NAME, child.getProjectName());
        values.put(ChildContract.ChildTable.COLUMN_UID, child.getUid());
        values.put(ChildContract.ChildTable.COLUMN_UUID, child.getUuid());
        values.put(ChildContract.ChildTable.COLUMN_FMUID, child.getFmuid());
        values.put(ChildContract.ChildTable.COLUMN_USERNAME, child.getUserName());
        values.put(ChildContract.ChildTable.COLUMN_SYSDATE, child.getSysDate());
        values.put(ChildContract.ChildTable.COLUMN_DCODE, child.getDcode());
        values.put(ChildContract.ChildTable.COLUMN_UCODE, child.getUcode());
        values.put(ChildContract.ChildTable.COLUMN_CLUSTER, child.getCluster());
        values.put(ChildContract.ChildTable.COLUMN_HHNO, child.getHhno());
        values.put(ChildContract.ChildTable.COLUMN_SCS, child.s03CStoString());
        values.put(ChildContract.ChildTable.COLUMN_DEVICEID, child.getDeviceId());
        values.put(ChildContract.ChildTable.COLUMN_DEVICETAGID, child.getDeviceTag());
        values.put(ChildContract.ChildTable.COLUMN_SYNCED, child.getSynced());
        values.put(ChildContract.ChildTable.COLUMN_SYNCED_DATE, child.getSyncDate());
        values.put(ChildContract.ChildTable.COLUMN_APPVERSION, child.getAppver());
        values.put(ChildContract.ChildTable.COLUMN_STATUS, child.getStatus());
        values.put(ChildContract.ChildTable.COLUMN_CHILD_NAME, child.getChildname());
        values.put(ChildContract.ChildTable.COLUMN_MOTHER_NAME, child.getMothername());
        values.put(ChildContract.ChildTable.COLUMN_SERIAL, child.getSerial());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ChildContract.ChildTable.TABLE_NAME,
                ChildContract.ChildTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChildInformation(ChildInformation form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(ChildInfoTable.COLUMN_UID, form.getUid());
        values.put(ChildInfoTable.COLUMN_UUID, form.getUuid());
        values.put(ChildInfoTable.COLUMN_USERNAME, form.getUserName());
        values.put(ChildInfoTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(ChildInfoTable.COLUMN_DCODE, form.getDcode());
        values.put(ChildInfoTable.COLUMN_UCODE, form.getUcode());
        values.put(ChildInfoTable.COLUMN_CLUSTER, form.getCluster());
        values.put(ChildInfoTable.COLUMN_HHNO, form.getHhno());
        values.put(ChildInfoTable.COLUMN_SCB, form.sCBtoString());
        values.put(ChildInfoTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(ChildInfoTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(ChildInfoTable.COLUMN_SYNCED, form.getSynced());
        values.put(ChildInfoTable.COLUMN_SYNCED_DATE, form.getSyncDate());
        values.put(ChildInfoTable.COLUMN_APPVERSION, form.getAppver());
        values.put(ChildInfoTable.COLUMN_STATUS, form.getStatus());
        values.put(ChildInfoTable.COLUMN_ISSELECTED, form.getIsSelected());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ChildInfoTable.TABLE_NAME,
                ChildInfoTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addIM(Immunization form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(IMContract.IMTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(IMContract.IMTable.COLUMN_UID, form.getUid());
        values.put(IMContract.IMTable.COLUMN_UUID, form.getUuid());
        values.put(IMContract.IMTable.COLUMN_FMUID, form.getFmuid());
        values.put(IMContract.IMTable.COLUMN_USERNAME, form.getUserName());
        values.put(IMContract.IMTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(IMContract.IMTable.COLUMN_DCODE, form.getDcode());
        values.put(IMContract.IMTable.COLUMN_UCODE, form.getUcode());
        values.put(IMContract.IMTable.COLUMN_CLUSTER, form.getCluster());
        values.put(IMContract.IMTable.COLUMN_HHNO, form.getHhno());
        values.put(IMContract.IMTable.COLUMN_SIM, form.s04IMtoString());
        values.put(IMContract.IMTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(IMContract.IMTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(IMContract.IMTable.COLUMN_SYNCED, form.getSynced());
        values.put(IMContract.IMTable.COLUMN_SYNCED_DATE, form.getSyncDate());
        values.put(IMContract.IMTable.COLUMN_APPVERSION, form.getAppver());
        values.put(IMContract.IMTable.COLUMN_STATUS, form.getStatus());
        values.put(IMContract.IMTable.COLUMN_CHILD_NAME, form.getChildname());
        values.put(IMContract.IMTable.COLUMN_SERIAL, form.getSerial());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                IMContract.IMTable.TABLE_NAME,
                IMContract.IMTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMH(MobileHealth mobileHealth) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MHContract.MHTable.COLUMN_PROJECT_NAME, mobileHealth.getProjectName());
        values.put(MHContract.MHTable.COLUMN_UID, mobileHealth.getUid());
        values.put(MHContract.MHTable.COLUMN_USERNAME, mobileHealth.getUserName());
        values.put(MHContract.MHTable.COLUMN_SYSDATE, mobileHealth.getSysDate());
        values.put(MHContract.MHTable.COLUMN_SA, mobileHealth.sAtoString());
        values.put(MHContract.MHTable.COLUMN_MH01, mobileHealth.getMh01());
        values.put(MHContract.MHTable.COLUMN_MH02, mobileHealth.getMh02());
        values.put(MHContract.MHTable.COLUMN_MH03, mobileHealth.getMh03());
        values.put(MHContract.MHTable.COLUMN_MH04, mobileHealth.getMh04());
        values.put(MHContract.MHTable.COLUMN_MH05, mobileHealth.getMh05());
        values.put(MHContract.MHTable.COLUMN_MH06, mobileHealth.getMh06());
        values.put(MHContract.MHTable.COLUMN_MH07, mobileHealth.getMh07());
        values.put(MHContract.MHTable.COLUMN_DEVICEID, mobileHealth.getDeviceId());
        values.put(MHContract.MHTable.COLUMN_DEVICETAGID, mobileHealth.getDeviceTag());
        values.put(MHContract.MHTable.COLUMN_SYNCED, mobileHealth.getSynced());
        values.put(MHContract.MHTable.COLUMN_SYNCED_DATE, mobileHealth.getSyncDate());
        values.put(MHContract.MHTable.COLUMN_APPVERSION, mobileHealth.getAppver());
        values.put(MHContract.MHTable.COLUMN_STATUS, mobileHealth.getStatus());
        values.put(MHContract.MHTable.COLUMN_SERIAL, mobileHealth.getSerial());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MHContract.MHTable.TABLE_NAME,
                MHContract.MHTable.COLUMN_NAME_NULLABLE,
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

    public FormIndicatorsModel getFormStatusCount(String sysdate) {
        SQLiteDatabase db = this.getReadableDatabase();
        FormIndicatorsModel count = new FormIndicatorsModel();
        Cursor mCursor = db.rawQuery(
                String.format("select " +
                        "sum(case when %s = 1 then 1 else 0 end) as completed," +
                        "sum(case when %s != 1 OR %s is null then 1 else 0 end) as notCompleted " +
                        "from %s WHERE %s Like ?", FormsTable.COLUMN_ISTATUS, FormsTable.COLUMN_ISTATUS, FormsTable.COLUMN_ISTATUS, FormsTable.TABLE_NAME, FormsTable.COLUMN_SYSDATE),
                new String[]{"%" + sysdate + " %"}, null);
        if (mCursor != null && mCursor.moveToFirst()) {
            count = count.copy(Integer.parseInt(mCursor.getString(0)),
                    Integer.parseInt(mCursor.getString(1)));
            mCursor.close();
        }
        return count;
    }

    public FormIndicatorsModel getUploadStatusCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        FormIndicatorsModel count = new FormIndicatorsModel();
        Cursor mCursor = db.rawQuery(
                String.format("select " +
                        "sum(case when %s = 1 then 1 else 0 end) as completed," +
                        "sum(case when %s is null OR %s = '' then 1 else 0 end) as notCompleted " +
                        "from %s", FormsTable.COLUMN_SYNCED, FormsTable.COLUMN_SYNCED, FormsTable.COLUMN_SYNCED, FormsTable.TABLE_NAME),
                null, null);
        if (mCursor != null && mCursor.moveToFirst()) {
            count = count.copy(Integer.parseInt(mCursor.getString(0)),
                    Integer.parseInt(mCursor.getString(1)));
            mCursor.close();
        }
        return count;
    }


    public ArrayList<ChildInformation> getFamilyFromDB(String cluster, String hhno, String uuid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String whereClause = ChildInfoTable.COLUMN_CLUSTER + " =? AND "
                + ChildInfoTable.COLUMN_HHNO + " =? AND "
                + ChildInfoTable.COLUMN_UUID + " =?";
        String[] whereArgs = {cluster, hhno, uuid};
        String groupBy = null;
        String having = null;
        String orderBy = ChildInfoTable.COLUMN_ID + " ASC";
        ArrayList<ChildInformation> allForms = new ArrayList<>();
        try {
            c = db.query(
                    ChildInfoTable.TABLE_NAME,  // The table to query
                    null,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildInformation childItem = new ChildInformation().Hydrate(c);
                childItem.setMotherAvailable(childItem.getCb11().equals("1"));
                childItem.setTotalMonths((Integer.parseInt(childItem.getCb0501()) * 12) + Integer.parseInt(childItem.getCb0502()));
                allForms.add(childItem);
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

    public ArrayList<ChildInformation> getSelectedChildrenFromDB(String cluster, String hhno, String uuid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String whereClause = ChildInfoTable.COLUMN_CLUSTER + " =? AND "
                + ChildInfoTable.COLUMN_HHNO + " =? AND "
                + ChildInfoTable.COLUMN_UUID + " =?";
        String[] whereArgs = {cluster, hhno, uuid};
        String groupBy = null;
        String having = null;
        String orderBy = ChildInfoTable.COLUMN_ID + " ASC";
        ArrayList<ChildInformation> allForms = new ArrayList<>();
        try {
            c = db.query(
                    ChildInfoTable.TABLE_NAME,  // The table to query
                    null,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildInformation info = new ChildInformation().Hydrate(c);
                info.setMotherAvailable(info.getCb11().equals("1"));
                int calculateMonth = (Integer.parseInt(info.getCb0501()) * 12) + Integer.parseInt(info.getCb0502());
                if (calculateMonth <= 35) info.setUnder35(true);
                info.setChildTableDataExist(
                        (Child) getFormExist(
                                ChildContract.ChildTable.class,
                                info.getCluster(),
                                info.getHhno(),
                                info.getUuid(),
                                info.getUid()));
                allForms.add(info);
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

    public Object getFormExist(Class<?> tableName, String cluster, String hhno, String uuid, String fmuid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Object count = null;
        String query = "";
        String[] where = null;
        if (tableName.getName().equals(ChildContract.ChildTable.class.getName())) {
            query = String.format("select *from %s where %s=? AND %s=? AND %s=? AND %s=?",
                    ChildContract.ChildTable.TABLE_NAME,
                    ChildContract.ChildTable.COLUMN_CLUSTER,
                    ChildContract.ChildTable.COLUMN_HHNO,
                    ChildContract.ChildTable.COLUMN_UUID,
                    ChildContract.ChildTable.COLUMN_FMUID
            );
            where = new String[]{cluster, hhno, uuid, fmuid};
        } else if (tableName.getName().equals(IMContract.IMTable.class.getName())) {
            query = String.format("select *from %s where %s=? AND %s=? AND %s=? AND %s=?",
                    IMContract.IMTable.TABLE_NAME,
                    IMContract.IMTable.COLUMN_CLUSTER,
                    IMContract.IMTable.COLUMN_HHNO,
                    IMContract.IMTable.COLUMN_UUID,
                    IMContract.IMTable.COLUMN_FMUID
            );
            where = new String[]{cluster, hhno, uuid, fmuid};
        }
        Cursor mCursor = db.rawQuery(query, where, null);
        if (mCursor != null && mCursor.moveToFirst()) {
            if (tableName.getName().equals(ChildContract.ChildTable.class.getName())) {
                count = new Child().Hydrate(mCursor);
            } else if (tableName.getName().equals(IMContract.IMTable.class.getName())) {
                count = new Immunization().Hydrate(mCursor);
            }
            mCursor.close();
        }
        return count;
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

    public Camps getSpecificCamp(String campNo, String distCode) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = Camps.TableCamp.COLUMN_CAMP_NO + "=? AND" + Camps.TableCamp.COLUMN_DIST_ID + "=?";
        String[] whereArgs = {campNo, distCode};
        String groupBy = null;
        String having = null;

        String orderBy = Camps.TableCamp._ID + " ASC";
        Camps camp = null;
        try {
            c = db.query(
                    Camps.TableCamp.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                camp = new Camps().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return camp;
    }

    public ArrayList<Doctor> getDoctorByCamp(String camno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = Doctor.TableDoctor.COLUMN_ID_CAMP + "=?";
        String[] whereArgs = {camno};
        String groupBy = null;
        String having = null;

        String orderBy = Doctor.TableDoctor.COLUMN_STAFF_NAME + " ASC";

        ArrayList<Doctor> docs = new ArrayList<>();
        try {
            c = db.query(
                    Doctor.TableDoctor.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                docs.add(new Doctor().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return docs;
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

    public BLRandom getBLRandomByClusterHH(String distCode, String subAreaCode, String hh) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause = TableRandom.COLUMN_DIST_CODE + "=? AND " + TableRandom.COLUMN_CLUSTER_CODE + "=? AND " + TableRandom.COLUMN_HH + "=?";
        String[] whereArgs = {distCode, subAreaCode, hh};
        String groupBy = null;
        String having = null;
        String orderBy = TableRandom.COLUMN_ID + " ASC";
        BLRandom allBL = null;
        try {
            c = db.query(
                    TableRandom.TABLE_NAME,  // The table to query
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
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allBL;
    }

    public Form getFormByClusterHH(String distCode, String subAreaCode, String hh) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_DCODE + "=? AND " +
                FormsTable.COLUMN_CLUSTER + "=? AND " +
                FormsTable.COLUMN_HHNO + "=? AND " +
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
    public int updateSpecificChildInformationColumn(ChildInformation childInformation, String isSelected) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(ChildInfoTable.COLUMN_ISSELECTED, isSelected);

        String selection = ChildInfoTable.COLUMN_CLUSTER + " =? AND "
                + ChildInfoTable.COLUMN_HHNO + " =? AND "
                + ChildInfoTable.COLUMN_UUID + " =? AND "
                + ChildInfoTable.COLUMN_UID + " =? AND "
                + ChildInfoTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {childInformation.getCluster(), childInformation.getHhno(), childInformation.getUuid(), childInformation.getUid(), childInformation.getId()};

        int count = db.update(ChildInfoTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        updatesFormColumn(FormsTable.COLUMN_ISTATUS, "99");

        return count;
    }

    public int updatesChildInformationColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildInfoTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.childInformation.getId())};

        return db.update(ChildInfoTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesChildColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildContract.ChildTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.child.getId())};

        return db.update(ChildContract.ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesIMColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = IMContract.IMTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.immunization.getId())};

        return db.update(IMContract.IMTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesMHColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = MHContract.MHTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(mobileHealth.getId())};

        return db.update(MHContract.MHTable.TABLE_NAME,
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

    public int syncBLRandom(JSONArray blList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableRandom.TABLE_NAME, null, null);

        int insertCount = 0;
        for (int i = 0; i < blList.length(); i++) {
            JSONObject jsonObjectCC = null;
            try {
                jsonObjectCC = blList.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            BLRandom Vc = new BLRandom();
            try {
                Vc.sync(jsonObjectCC);
                Log.d(TAG, "syncBLRandom: " + Vc.getId());
                ContentValues values = new ContentValues();

                values.put(TableRandom.COLUMN_LUID, Vc.getLUID());
                values.put(TableRandom.COLUMN_STRUCTURE_NO, Vc.getStructure());
                values.put(TableRandom.COLUMN_FAMILY_EXT_CODE, Vc.getExtension());
                values.put(TableRandom.COLUMN_HH, Vc.getHh());
                values.put(TableRandom.COLUMN_DIST_CODE, Vc.getDistCode());
                values.put(TableRandom.COLUMN_CLUSTER_CODE, Vc.getClusterCode());
                values.put(TableRandom.COLUMN_RANDOMDT, Vc.getRandomDT());
                values.put(TableRandom.COLUMN_HH_HEAD, Vc.getHhhead());
                values.put(TableRandom.COLUMN_CONTACT, Vc.getContact());
                values.put(TableRandom.COLUMN_UPDATEDT, Vc.getUpdateDT());
                values.put(TableRandom.COLUMN_SNO_HH, Vc.getSno());

                long row = db.insert(TableRandom.TABLE_NAME, null, values);
                if (row != -1) insertCount++;

            } catch (JSONException e) {
                e.printStackTrace();
            }
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

    public int syncCamp(JSONArray campList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Camps.TableCamp.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < campList.length(); i++) {
                JSONObject json = campList.getJSONObject(i);
                Camps camps = new Camps();
                camps.sync(json);
                ContentValues values = new ContentValues();

                values.put(Camps.TableCamp.COLUMN_ID_CAMP, camps.getIdCamp());
                values.put(Camps.TableCamp.COLUMN_CAMP_NO, camps.getCamp_no());
                values.put(Camps.TableCamp.COLUMN_DIST_ID, camps.getDist_id());
                values.put(Camps.TableCamp.COLUMN_DISTRICT, camps.getDistrict());
                values.put(Camps.TableCamp.COLUMN_UC_CODE, camps.getUcCode());
                values.put(Camps.TableCamp.COLUMN_UC_NAME, camps.getUcName());
                values.put(Camps.TableCamp.COLUMN_AREA_NAME, camps.getArea_name());
                values.put(Camps.TableCamp.COLUMN_PLAN_DATE, camps.getPlan_date());

                long rowID = db.insert(Camps.TableCamp.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncCamp(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncDoctor(JSONArray docList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Doctor.TableDoctor.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < docList.length(); i++) {
                JSONObject json = docList.getJSONObject(i);
                Doctor doc = new Doctor();
                doc.sync(json);
                ContentValues values = new ContentValues();

                values.put(Doctor.TableDoctor.COLUMN_ID_CAMP, doc.getIdCamp());
                values.put(Doctor.TableDoctor.COLUMN_ID_DOCTOR, doc.getIddoctor());
                values.put(Doctor.TableDoctor.COLUMN_STAFF_NAME, doc.getStaff_name());

                long rowID = db.insert(Doctor.TableDoctor.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncDoctor(e): " + e);
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


    //get UnSyncedTables
    public JSONArray getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_SYNCED + " is null ";

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

    public JSONArray getUnsyncedChild() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildContract.ChildTable.COLUMN_ID,
                ChildContract.ChildTable.COLUMN_UID,
                ChildContract.ChildTable.COLUMN_UUID,
                ChildContract.ChildTable.COLUMN_FMUID,
                ChildContract.ChildTable.COLUMN_USERNAME,
                ChildContract.ChildTable.COLUMN_SYSDATE,
                ChildContract.ChildTable.COLUMN_DCODE,
                ChildContract.ChildTable.COLUMN_UCODE,
                ChildContract.ChildTable.COLUMN_CLUSTER,
                ChildContract.ChildTable.COLUMN_HHNO,
                ChildContract.ChildTable.COLUMN_DEVICEID,
                ChildContract.ChildTable.COLUMN_DEVICETAGID,
                ChildContract.ChildTable.COLUMN_APPVERSION,
                ChildContract.ChildTable.COLUMN_SYNCED,
                ChildContract.ChildTable.COLUMN_SYNCED_DATE,
                ChildContract.ChildTable.COLUMN_STATUS,
                ChildContract.ChildTable.COLUMN_MOTHER_NAME,
                ChildContract.ChildTable.COLUMN_CHILD_NAME,
                ChildContract.ChildTable.COLUMN_SERIAL,
                ChildContract.ChildTable.COLUMN_SCS,

        };

        String whereClause;
        whereClause = ChildContract.ChildTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = ChildContract.ChildTable.COLUMN_ID + " ASC";

//        Collection<Child> allFC = new ArrayList<>();
        JSONArray allFC = new JSONArray();

        try {
            c = db.query(
                    ChildContract.ChildTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
              /*  Child fc = new Child();
                allFC.add(fc.Hydrate(c));*/
                Log.d(TAG, "getUnsyncedChild: " + c.getCount());
                Child form = new Child();
                allFC.put(form.Hydrate(c).toJSONObject());

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

    public JSONArray getUnsyncedHHChildrens() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildInformationContract.ChildInfoTable.COLUMN_ID,
                ChildInformationContract.ChildInfoTable.COLUMN_UID,
                ChildInformationContract.ChildInfoTable.COLUMN_UUID,
                ChildInformationContract.ChildInfoTable.COLUMN_USERNAME,
                ChildInformationContract.ChildInfoTable.COLUMN_SYSDATE,
                ChildInformationContract.ChildInfoTable.COLUMN_DCODE,
                ChildInformationContract.ChildInfoTable.COLUMN_UCODE,
                ChildInformationContract.ChildInfoTable.COLUMN_CLUSTER,
                ChildInformationContract.ChildInfoTable.COLUMN_HHNO,
                ChildInformationContract.ChildInfoTable.COLUMN_DEVICEID,
                ChildInformationContract.ChildInfoTable.COLUMN_DEVICETAGID,
                ChildInformationContract.ChildInfoTable.COLUMN_APPVERSION,
                ChildInformationContract.ChildInfoTable.COLUMN_SYNCED,
                ChildInformationContract.ChildInfoTable.COLUMN_SYNCED_DATE,
                ChildInformationContract.ChildInfoTable.COLUMN_STATUS,
                ChildInformationContract.ChildInfoTable.COLUMN_ISSELECTED,

                ChildInformationContract.ChildInfoTable.COLUMN_SCB,

        };


        String whereClause;
        whereClause = ChildInformationContract.ChildInfoTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = ChildInformationContract.ChildInfoTable.COLUMN_ID + " ASC";

        /*      Collection<ChildInformation> allFC = new ArrayList<>();     */
        JSONArray allFC = new JSONArray();

        try {
            c = db.query(
                    ChildInformationContract.ChildInfoTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
             /*   ChildInformation fc = new ChildInformation();
                allFC.add(fc.Hydrate(c));*/
                Log.d(TAG, "getUnsyncedChildInfo: " + c.getCount());
                ChildInformation childInfo = new ChildInformation();
                allFC.put(childInfo.Hydrate(c).toJSONObject());

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

    public JSONArray getUnsyncedIM() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                IMContract.IMTable.COLUMN_ID,
                IMContract.IMTable.COLUMN_UID,
                IMContract.IMTable.COLUMN_UUID,
                IMContract.IMTable.COLUMN_FMUID,
                IMContract.IMTable.COLUMN_USERNAME,
                IMContract.IMTable.COLUMN_SYSDATE,
                IMContract.IMTable.COLUMN_DCODE,
                IMContract.IMTable.COLUMN_UCODE,
                IMContract.IMTable.COLUMN_CLUSTER,
                IMContract.IMTable.COLUMN_HHNO,
                IMContract.IMTable.COLUMN_DEVICEID,
                IMContract.IMTable.COLUMN_DEVICETAGID,
                IMContract.IMTable.COLUMN_APPVERSION,
                IMContract.IMTable.COLUMN_SYNCED,
                IMContract.IMTable.COLUMN_SYNCED_DATE,
                IMContract.IMTable.COLUMN_STATUS,
                IMContract.IMTable.COLUMN_MOTHER_NAME,
                IMContract.IMTable.COLUMN_CHILD_NAME,
                IMContract.IMTable.COLUMN_SERIAL,
                IMContract.IMTable.COLUMN_SIM
        };

        String whereClause;
        whereClause = IMContract.IMTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = IMContract.IMTable.COLUMN_ID + " ASC";

//        Collection<Immunization> allFC = new ArrayList<>();
        JSONArray allFC = new JSONArray();

        try {
            c = db.query(
                    IMContract.IMTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
               /* Immunization fc = new Immunization();
                allFC.add(fc.Hydrate(c));*/
                Log.d(TAG, "getUnsyncedIM: " + c.getCount());
                Immunization form = new Immunization();
                allFC.put(form.Hydrate(c).toJSONObject());
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

    public JSONArray getUnsyncedMH() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MHContract.MHTable.COLUMN_ID,
                MHContract.MHTable.COLUMN_UID,
                MHContract.MHTable.COLUMN_USERNAME,
                MHContract.MHTable.COLUMN_SYSDATE,
                MHContract.MHTable.COLUMN_DEVICEID,
                MHContract.MHTable.COLUMN_DEVICETAGID,
                MHContract.MHTable.COLUMN_APPVERSION,
                MHContract.MHTable.COLUMN_SYNCED,
                MHContract.MHTable.COLUMN_SYNCED_DATE,
                MHContract.MHTable.COLUMN_STATUS,
                MHContract.MHTable.COLUMN_SERIAL,
                MHContract.MHTable.COLUMN_MH01,
                MHContract.MHTable.COLUMN_MH02,
                MHContract.MHTable.COLUMN_MH03,
                MHContract.MHTable.COLUMN_MH04,
                MHContract.MHTable.COLUMN_MH05,
                MHContract.MHTable.COLUMN_MH06,
                MHContract.MHTable.COLUMN_MH07,
                MHContract.MHTable.COLUMN_SA
        };

        String whereClause;
        whereClause = MHContract.MHTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = MHContract.MHTable.COLUMN_ID + " ASC";

        JSONArray jsa = new JSONArray();

        try {
            c = db.query(
                    MHContract.MHTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedMH: " + c.getCount());
                MobileHealth mhForm = new MobileHealth();
                jsa.put(mhForm.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return jsa;
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

    public void updateSyncedCSChild(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SYNCED, true);
        values.put(ChildTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ChildTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ChildTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedHHChildrens(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildInfoTable.COLUMN_SYNCED, true);
        values.put(ChildInfoTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ChildInfoTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ChildInfoTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedIMChild(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(IMTable.COLUMN_SYNCED, true);
        values.put(IMTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = IMTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                IMTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedMobileHealth(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MHContract.MHTable.COLUMN_SYNCED, true);
        values.put(MHContract.MHTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = MHContract.MHTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                MHContract.MHTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public Collection<MobileHealth> getFormsByCluster(String cluster) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MHTable.COLUMN_ID,
                MHTable.COLUMN_UID,
                MHTable.COLUMN_SYSDATE,
                MHTable.COLUMN_MH02,
                MHTable.COLUMN_MH06,
                MHTable.COLUMN_MH07,
                MHTable.COLUMN_SA,
                MHTable.COLUMN_SYNCED,

        };
        String whereClause = MHTable.COLUMN_MH02 + " = ? ";
        String[] whereArgs = new String[]{cluster};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                MHTable.COLUMN_ID + " ASC";

        Collection<MobileHealth> allFC = new ArrayList<>();
        try {
            c = db.query(
                    MHTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MobileHealth fc = new MobileHealth();
                fc.setId(c.getString(c.getColumnIndex(MHTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndex(MHTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndex(MHTable.COLUMN_SYSDATE)));
                fc.setMh02(c.getString(c.getColumnIndex(MHTable.COLUMN_MH02)));
                fc.setMh06(c.getString(c.getColumnIndex(MHTable.COLUMN_MH06)));
                fc.setMh07(c.getString(c.getColumnIndex(MHTable.COLUMN_MH07)));
                fc.setSynced(c.getString(c.getColumnIndex(MHTable.COLUMN_SYNCED)));
                fc.sAHydrate(c.getString(c.getColumnIndex(MHTable.COLUMN_SA)));
                Log.d(TAG, "getFormsByCluster: " + c.getString(c.getColumnIndex(MHTable.COLUMN_SA)));
                allFC.add(fc);
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

    public ArrayList<Form> getUnclosedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_CLUSTER,
                FormsTable.COLUMN_HHNO,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,
        };
        String whereClause = FormsTable.COLUMN_ISTATUS + " = ''";
        String[] whereArgs = null;
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allFC = new ArrayList<>();
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
                Form fc = new Form();
                fc.setId(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                fc.setLhwCode(c.getString(c.getColumnIndex(FormsTable.COLUMN_CLUSTER)));
                fc.setKhandanNumber(c.getString(c.getColumnIndex(FormsTable.COLUMN_HHNO)));
                fc.setIStatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
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

    public int getChildrenByUUID(String UUID) {
        String countQuery = "SELECT  * FROM " + ChildTable.TABLE_NAME + " WHERE " + ChildTable.COLUMN_UUID + " = '" + UUID + "' AND " + ChildTable.COLUMN_STATUS + " = '1'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getChildrenPhotoCheck(String UID) {
        String countQuery = "SELECT  * FROM " + IMTable.TABLE_NAME +
                " WHERE " + IMTable.COLUMN_UUID + " = '" + UID +
                "' AND " + IMTable.COLUMN_STATUS + " = '1' " +
                " AND (" + IMTable.COLUMN_SIM + " NOT LIKE '%\"frontFileName\":\"\"%' " +
                " OR " + IMTable.COLUMN_SIM + " NOT LIKE '%\"backFileName\":\"\"%') ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getChildrenCardCheck(String UID) {
        String countQuery = "SELECT  * FROM " + IMTable.TABLE_NAME +
                " WHERE " + IMTable.COLUMN_UUID + " = '" + UID +
                "' AND " + IMTable.COLUMN_STATUS + " = '1' " +
                " AND " + IMTable.COLUMN_SIM + " LIKE '%\"im01\":\"1\"%' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public Collection<MobileHealth> getTodayForms(String sysdate) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MHTable.COLUMN_ID,
                MHTable.COLUMN_UID,
                MHTable.COLUMN_SYSDATE,
                MHTable.COLUMN_MH02,
                MHTable.COLUMN_MH06,
                MHTable.COLUMN_MH07,
                MHTable.COLUMN_SA,
                MHTable.COLUMN_SYNCED,


        };
        String whereClause = MHTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = MHTable.COLUMN_ID + " DESC";

        Collection<MobileHealth> allFC = new ArrayList<>();
        try {
            c = db.query(
                    MHTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MobileHealth fc = new MobileHealth();
                fc.setId(c.getString(c.getColumnIndex(MHTable.COLUMN_ID)));
                fc.setUid(c.getString(c.getColumnIndex(MHTable.COLUMN_UID)));
                fc.setSysDate(c.getString(c.getColumnIndex(MHTable.COLUMN_SYSDATE)));
                fc.setMh02(c.getString(c.getColumnIndex(MHTable.COLUMN_MH02)));
                fc.setMh06(c.getString(c.getColumnIndex(MHTable.COLUMN_MH06)));
                fc.setMh07(c.getString(c.getColumnIndex(MHTable.COLUMN_MH07)));
                fc.sAHydrate(c.getString(c.getColumnIndex(MHTable.COLUMN_SA)));
                fc.setSynced(c.getString(c.getColumnIndex(MHTable.COLUMN_SYNCED)));
                allFC.add(fc);
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
}