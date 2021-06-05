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
import edu.aku.hassannaqvi.smk_ce.contracts.HHIDContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class HHIDModel extends BaseObservable {

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
    private String hfCode = StringUtils.EMPTY;
    private String hfName = StringUtils.EMPTY;
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
    private String hhi01 = StringUtils.EMPTY;
    private String hhi02 = StringUtils.EMPTY;
    private String hhi03 = StringUtils.EMPTY;
    private String hhi04a = StringUtils.EMPTY;
    private String hhi04b = StringUtils.EMPTY;
    private String hhi04c = StringUtils.EMPTY;
    private String hhi04d = StringUtils.EMPTY;
    private String hhi04e = StringUtils.EMPTY;
    private String hhi04f = StringUtils.EMPTY;


    public HHIDModel() {
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
        this.hfCode = dcode;
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

    public HHIDModel setUid(String uid) {
        this.uid = uid;
        return this;
    }


    @Bindable
    public String getUuid() {
        return uuid;
    }

    public HHIDModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }


    @Bindable
    public String getSerialNo() {
        return serialNo;
    }

    public HHIDModel setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }


    @Bindable
    public String getUserName() {
        return userName;
    }

    public HHIDModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Bindable
    public String getHfCode() {
        return hfCode;
    }

    public HHIDModel setHfCode(String hfCode) {
        this.hfCode = hfCode;
        return this;
    }


    @Bindable
    public String getHfName() {
        return hfName;
    }

    public HHIDModel setHfName(String hfName) {
        this.hfName = hfName;
        return this;
    }


    @Bindable
    public String getTehsilCode() {
        return tehsilCode;
    }

    public HHIDModel setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
        return this;
    }


    @Bindable
    public String getTehsilName() {
        return tehsilName;
    }

    public HHIDModel setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
        return this;
    }


    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public HHIDModel setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        return this;
    }


    @Bindable
    public String getLhwName() {
        return lhwName;
    }

    public HHIDModel setLhwName(String lhwName) {
        this.lhwName = lhwName;
        return this;
    }


    @Bindable
    public String getKhandanNumber() {
        return khandanNumber;
    }

    public HHIDModel setKhandanNumber(String khandanNumber) {
        this.khandanNumber = khandanNumber;
        return this;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public HHIDModel setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public HHIDModel setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        return this;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public HHIDModel setAppver(String appver) {
        this.appver = appver;
        return this;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public HHIDModel setSysDate(String sysDate) {
        this.sysDate = sysDate;
        return this;
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public HHIDModel setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Bindable
    public String getSynced() {
        return synced;
    }

    public HHIDModel setSynced(String synced) {
        this.synced = synced;
        return this;
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public HHIDModel setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        return this;
    }


    public String getsA() {
        return sA;
    }

    public HHIDModel setsA(String sA) {
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
    public String getHhi01() {
        return hhi01;
    }

    public void setHhi01(String hhi01) {
        this.hhi01 = hhi01;
        notifyPropertyChanged(BR.hhi01);
    }

    @Bindable
    public String getHhi02() {
        return hhi02;
    }

    public void setHhi02(String hhi02) {
        this.hhi02 = hhi02;
        notifyPropertyChanged(BR.hhi02);
    }

    @Bindable
    public String getHhi03() {
        return hhi03;
    }

    public void setHhi03(String hhi03) {
        this.hhi03 = hhi03;
        notifyPropertyChanged(BR.hhi03);
    }

    @Bindable
    public String getHhi04a() {
        return hhi04a;
    }

    public void setHhi04a(String hhi04a) {
        this.hhi04a = hhi04a;
        notifyPropertyChanged(BR.hhi04a);
    }

    @Bindable
    public String getHhi04b() {
        return hhi04b;
    }

    public void setHhi04b(String hhi04b) {
        this.hhi04b = hhi04b;
        notifyPropertyChanged(BR.hhi04b);
    }

    @Bindable
    public String getHhi04c() {
        return hhi04c;
    }

    public void setHhi04c(String hhi04c) {
        this.hhi04c = hhi04c;
        notifyPropertyChanged(BR.hhi04c);
    }

    @Bindable
    public String getHhi04d() {
        return hhi04d;
    }

    public void setHhi04d(String hhi04d) {
        this.hhi04d = hhi04d;
        notifyPropertyChanged(BR.hhi04d);
    }

    @Bindable
    public String getHhi04e() {
        return hhi04e;
    }

    public void setHhi04e(String hhi04e) {
        this.hhi04e = hhi04e;
        notifyPropertyChanged(BR.hhi04e);
    }

    @Bindable
    public String getHhi04f() {
        return hhi04f;
    }

    public void setHhi04f(String hhi04f) {
        this.hhi04f = hhi04f;
        notifyPropertyChanged(BR.hhi04f);
    }


    public HHIDModel Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_ID);
        this.uid = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_UID);
        this.uuid = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_UUID);
        this.serialNo = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_SERIAL_NO);
        this.userName = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_SYSDATE);
        this.hfCode = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_HF_CODE);
        this.hfName = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_HF_NAME);
        this.tehsilCode = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_TEHSIL_NAME);
        this.lhwCode = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_LHW_CODE);
        this.lhwName = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_LHW_NAME);
        this.khandanNumber = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_KHANDAN_NUMBER);
        this.deviceId = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_APPVERSION);
        this.endTime = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_ENDINGDATETIME);
        this.status = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_STATUS);
        this.synced = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_SYNCED_DATE);

        this.sA = jsonObject.getString(HHIDContract.HHIDTable.COLUMN_SA);

        return this;

    }


    public HHIDModel hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_UUID));
        this.serialNo = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SERIAL_NO));
        this.userName = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SYSDATE));
        this.hfCode = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_HF_CODE));
        this.hfName = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_HF_NAME));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_TEHSIL_NAME));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_LHW_CODE));
        this.lhwName = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_LHW_NAME));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_KHANDAN_NUMBER));
        this.deviceId = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_APPVERSION));
        this.endTime = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_ENDINGDATETIME));
        this.status = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_STATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SYNCED_DATE));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(HHInfoContract.HHInfoTable.COLUMN_S01HH));

        sAHydrate(cursor.getString(cursor.getColumnIndex(HHIDContract.HHIDTable.COLUMN_SA)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, HHIDModel.class);
    }


    public String sAtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("hhi01", hhi01)
                    .put("hhi02", hhi02)
                    .put("hhi03", hhi03)
                    .put("hhi04a", hhi04a)
                    .put("hhi04b", hhi04b)
                    .put("hhi04c", hhi04c)
                    .put("hhi04d", hhi04d)
                    .put("hhi04e", hhi04e)
                    .put("hhio4f", hhi04f);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(HHIDContract.HHIDTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(HHIDContract.HHIDTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
            json.put(HHIDContract.HHIDTable.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
            json.put(HHIDContract.HHIDTable.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);
            json.put(HHIDContract.HHIDTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(HHIDContract.HHIDTable.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
            json.put(HHIDContract.HHIDTable.COLUMN_HF_CODE, this.hfCode == null ? JSONObject.NULL : this.hfCode);
            json.put(HHIDContract.HHIDTable.COLUMN_HF_NAME, this.hfName == null ? JSONObject.NULL : this.hfName);
            json.put(HHIDContract.HHIDTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(HHIDContract.HHIDTable.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
            json.put(HHIDContract.HHIDTable.COLUMN_LHW_CODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(HHIDContract.HHIDTable.COLUMN_LHW_NAME, this.lhwName == null ? JSONObject.NULL : this.lhwName);
            json.put(HHIDContract.HHIDTable.COLUMN_KHANDAN_NUMBER, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(HHIDContract.HHIDTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(HHIDContract.HHIDTable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(HHIDContract.HHIDTable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(HHIDContract.HHIDTable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(HHIDContract.HHIDTable.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
            json.put(HHIDContract.HHIDTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(HHIDContract.HHIDTable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);

            json.put(HHIDContract.HHIDTable.COLUMN_SA, new JSONObject(sAtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(HHIDContract.HHIDTable.COLUMN_SA, new JSONObject(this.sA));
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
                this.hhi01 = json.getString("hhi01");
                this.hhi02 = json.getString("hhi02");
                this.hhi03 = json.getString("hhi03");
                this.hhi04a = json.getString("hhi04a");
                this.hhi04b = json.getString("hhi04b");
                this.hhi04c = json.getString("hhi04c");
                this.hhi04d = json.getString("hhi04d");
                this.hhi04e = json.getString("hhi04e");
                this.hhi04f = json.getString("hhio4f");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
