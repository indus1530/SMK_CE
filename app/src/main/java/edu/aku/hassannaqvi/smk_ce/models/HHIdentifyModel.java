package edu.aku.hassannaqvi.smk_ce.models;

import android.database.Cursor;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.LocalDate;

import edu.aku.hassannaqvi.smk_ce.BR;
import edu.aku.hassannaqvi.smk_ce.contracts.HHIdentifyContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class HHIdentifyModel extends BaseObservable {

    private final String TAG = "HHIdentifyModel";

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;


    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String uuid = StringUtils.EMPTY;
    private String serialNo = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String districtCode = StringUtils.EMPTY;
    private String districtName = StringUtils.EMPTY;
    private String tehsilCode = StringUtils.EMPTY;
    private String tehsilName = StringUtils.EMPTY;
    private String lhwCode = StringUtils.EMPTY;
    private String lhwName = StringUtils.EMPTY;
    private String khandanNumber = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String status = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;


    // SECTION VARIABLES
    private String sA = StringUtils.EMPTY;

    //Not saving in DB
    private LocalDate localDate = null;
    private boolean exist = false;


    // FIELD VARIABLES
    //HouseHold Information
    private String hhv01 = StringUtils.EMPTY;
    private String hhv02a = StringUtils.EMPTY;
    private String hhv02b = StringUtils.EMPTY;
    private String hhv02c = StringUtils.EMPTY;
    private String hhv02d = StringUtils.EMPTY;
    private String hhv02e = StringUtils.EMPTY;
    private String hhv02f = StringUtils.EMPTY;
    private String hhv02g = StringUtils.EMPTY;
    private String hhv03 = StringUtils.EMPTY;


    public HHIdentifyModel() {
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setForm(String userName, String sysDate, String dcode, String ucode, String cluster, String hhno, String deviceId, String deviceTag, String appver) {
        this.userName = userName;
        this.sysDate = sysDate;
        this.districtCode = dcode;
        this.tehsilCode = ucode;
        this.lhwCode = cluster;
        this.khandanNumber = hhno;
        this.deviceId = deviceId;
        this.deviceTag = deviceTag;
        this.appver = appver;
    }

    @Bindable
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        if (projectName != projectName)
            this.projectName = projectName;

        //TODO: Update field in layout
        // notifyPropertyChanged(BR.layoutFieldName);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    @Bindable
    public String getUid() {
        return uid;
    }

    public HHIdentifyModel setUid(String uid) {
        this.uid = uid;
        return this;
    }


    @Bindable
    public String getUuid() {
        return uuid;
    }

    public HHIdentifyModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }


    @Bindable
    public String getSerialNo() {
        return serialNo;
    }

    public HHIdentifyModel setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }


    @Bindable
    public String getUserName() {
        return userName;
    }

    public HHIdentifyModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Bindable
    public String getDistrictCode() {
        return districtCode;
    }

    public HHIdentifyModel setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }


    @Bindable
    public String getDistrictName() {
        return districtName;
    }

    public HHIdentifyModel setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }


    @Bindable
    public String getTehsilCode() {
        return tehsilCode;
    }

    public HHIdentifyModel setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
        return this;
    }


    @Bindable
    public String getTehsilName() {
        return tehsilName;
    }

    public HHIdentifyModel setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
        return this;
    }


    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public HHIdentifyModel setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        return this;
    }


    @Bindable
    public String getLhwName() {
        return lhwName;
    }

    public HHIdentifyModel setLhwName(String lhwName) {
        this.lhwName = lhwName;
        return this;
    }


    @Bindable
    public String getKhandanNumber() {
        return khandanNumber;
    }

    public HHIdentifyModel setKhandanNumber(String khandanNumber) {
        this.khandanNumber = khandanNumber;
        return this;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public HHIdentifyModel setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public HHIdentifyModel setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        return this;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public HHIdentifyModel setAppver(String appver) {
        this.appver = appver;
        return this;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public HHIdentifyModel setSysDate(String sysDate) {
        this.sysDate = sysDate;
        return this;
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public HHIdentifyModel setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Bindable
    public String getSynced() {
        return synced;
    }

    public HHIdentifyModel setSynced(String synced) {
        this.synced = synced;
        return this;
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public HHIdentifyModel setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        return this;
    }


    public String getsA() {
        return sA;
    }

    public HHIdentifyModel setsA(String sA) {
        this.sA = sA;
        return this;
    }


    @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    @Bindable
    public String getHhv01() {
        return hhv01;
    }

    public void setHhv01(String hhv01) {
        this.hhv01 = hhv01;
        notifyPropertyChanged(BR.hhv01);
    }

    @Bindable
    public String getHhv02a() {
        return hhv02a;
    }

    public void setHhv02a(String hhv02a) {
        this.hhv02a = hhv02a;
        notifyPropertyChanged(BR.hhv02a);
    }

    @Bindable
    public String getHhv02b() {
        return hhv02b;
    }

    public void setHhv02b(String hhv02b) {
        this.hhv02b = hhv02b;
        notifyPropertyChanged(BR.hhv02b);
    }

    @Bindable
    public String getHhv02c() {
        return hhv02c;
    }

    public void setHhv02c(String hhv02c) {
        this.hhv02c = hhv02c;
        notifyPropertyChanged(BR.hhv02c);
    }

    @Bindable
    public String getHhv02d() {
        return hhv02d;
    }

    public void setHhv02d(String hhv02d) {
        this.hhv02d = hhv02d;
        notifyPropertyChanged(BR.hhv02d);
    }

    @Bindable
    public String getHhv02e() {
        return hhv02e;
    }

    public void setHhv02e(String hhv02e) {
        this.hhv02e = hhv02e;
        notifyPropertyChanged(BR.hhv02e);
    }

    @Bindable
    public String getHhv02f() {
        return hhv02f;
    }

    public void setHhv02f(String hhv02f) {
        this.hhv02f = hhv02f;
        notifyPropertyChanged(BR.hhv02f);
    }

    @Bindable
    public String getHhv02g() {
        return hhv02g;
    }

    public void setHhv02g(String hhv02g) {
        this.hhv02g = hhv02g;
        notifyPropertyChanged(BR.hhv02g);
    }

    @Bindable
    public String getHhv03() {
        return hhv03;
    }

    public void setHhv03(String hhv03) {
        this.hhv03 = hhv03;
        notifyPropertyChanged(BR.hhv03);
    }


    public HHIdentifyModel Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_ID);
        this.uid = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_UID);
        this.uuid = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_UUID);
        this.serialNo = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_SERIAL_NO);
        this.userName = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_SYSDATE);
        this.districtCode = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_DISTRICT_NAME);
        this.tehsilCode = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_TEHSIL_NAME);
        this.lhwCode = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_LHW_CODE);
        this.lhwName = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_LHW_NAME);
        this.khandanNumber = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_KHANDAN_NUMBER);
        this.deviceId = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_APPVERSION);
        this.endTime = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_ENDINGDATETIME);
        this.status = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_STATUS);
        this.synced = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_SYNCED_DATE);

        this.sA = jsonObject.getString(HHIdentifyContract.HHIdentifyTable.COLUMN_SA);

        return this;

    }


    public HHIdentifyModel Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_UUID));
        this.serialNo = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_SERIAL_NO));
        this.userName = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_SYSDATE));
        this.districtCode = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_DISTRICT_NAME));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_TEHSIL_NAME));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_LHW_CODE));
        this.lhwName = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_LHW_NAME));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_KHANDAN_NUMBER));
        this.deviceId = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_APPVERSION));
        this.endTime = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_ENDINGDATETIME));
        this.status = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_STATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_SYNCED_DATE));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(HHInfoContract.HHInfoTable.COLUMN_S01HH));

        sAHydrate(cursor.getString(cursor.getColumnIndex(HHIdentifyContract.HHIdentifyTable.COLUMN_SA)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, HHIdentifyModel.class);
    }


    public String sAtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("hhv01", hhv01)
                    .put("hhv02a", hhv02a)
                    .put("hhv02b", hhv02b)
                    .put("hhv02c", hhv02c)
                    .put("hhv02d", hhv02d)
                    .put("hhv02e", hhv02e)
                    .put("hhv02f", hhv02f)
                    .put("hhv02g", hhv02g)
                    .put("hhv03", hhv03);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_DISTRICT_NAME, this.districtName == null ? JSONObject.NULL : this.districtName);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_LHW_CODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_LHW_NAME, this.lhwName == null ? JSONObject.NULL : this.lhwName);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_KHANDAN_NUMBER, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);

            json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_SA, new JSONObject(sAtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(HHIdentifyContract.HHIdentifyTable.COLUMN_SA, new JSONObject(this.sA));
            }

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void sAHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.hhv01 = json.getString("hhv01");
                this.hhv02a = json.getString("hhv02a");
                this.hhv02b = json.getString("hhv02b");
                this.hhv02c = json.getString("hhv02c");
                this.hhv02d = json.getString("hhv02d");
                this.hhv02e = json.getString("hhv02e");
                this.hhv02f = json.getString("hhv02f");
                this.hhv02g = json.getString("hhv02g");
                this.hhv03 = json.getString("hhv03");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
