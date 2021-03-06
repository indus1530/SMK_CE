package edu.aku.hassannaqvi.smk_ce.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.LocalDate;

import java.util.ArrayList;

import edu.aku.hassannaqvi.smk_ce.BR;
import edu.aku.hassannaqvi.smk_ce.contracts.FemaleMembersContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class FemaleMembersModel extends BaseObservable implements Observable {

    private final String TAG = "HHMembersModel";

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

    private boolean expanded;
    // SECTION VARIABLES
    private String sA = StringUtils.EMPTY;

    //Not saving in DB
    private LocalDate localDate = null;
    private boolean exist = false;


    // FIELD VARIABLES

    //HouseHold Information verify
    private String hh01 = StringUtils.EMPTY;
    private String hh02 = StringUtils.EMPTY;
    private String hh03 = StringUtils.EMPTY;
    private String hh04a = StringUtils.EMPTY;
    private String hh04b = StringUtils.EMPTY;
    private String hh04c = StringUtils.EMPTY;
    private String hh05y = StringUtils.EMPTY;
    private String hh05m = StringUtils.EMPTY;
    private String hh06 = StringUtils.EMPTY;
    private String hh07 = StringUtils.EMPTY;
    private String hh08 = StringUtils.EMPTY;
    private String hh09 = StringUtils.EMPTY;
    private String hh10 = StringUtils.EMPTY;
    private String hh11 = StringUtils.EMPTY;
    private String memCategory = StringUtils.EMPTY;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();


    public FemaleMembersModel() {
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

    public FemaleMembersModel setUid(String uid) {
        this.uid = uid;
        return this;
    }


    @Bindable
    public String getUuid() {
        return uuid;
    }

    public FemaleMembersModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }


    @Bindable
    public String getSerialNo() {
        return serialNo;
    }

    public FemaleMembersModel setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }


    @Bindable
    public String getUserName() {
        return userName;
    }

    public FemaleMembersModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Bindable
    public String getHfCode() {
        return hfCode;
    }

    public FemaleMembersModel setHfCode(String hfCode) {
        this.hfCode = hfCode;
        return this;
    }


    @Bindable
    public String getHfName() {
        return hfName;
    }

    public FemaleMembersModel setHfName(String hfName) {
        this.hfName = hfName;
        return this;
    }


    @Bindable
    public String getTehsilCode() {
        return tehsilCode;
    }

    public FemaleMembersModel setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
        return this;
    }


    @Bindable
    public String getTehsilName() {
        return tehsilName;
    }

    public FemaleMembersModel setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
        return this;
    }


    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public FemaleMembersModel setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        return this;
    }


    @Bindable
    public String getLhwName() {
        return lhwName;
    }

    public FemaleMembersModel setLhwName(String lhwName) {
        this.lhwName = lhwName;
        return this;
    }


    @Bindable
    public String getKhandanNumber() {
        return khandanNumber;
    }

    public FemaleMembersModel setKhandanNumber(String khandanNumber) {
        this.khandanNumber = khandanNumber;
        return this;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public FemaleMembersModel setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public FemaleMembersModel setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        return this;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public FemaleMembersModel setAppver(String appver) {
        this.appver = appver;
        return this;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public FemaleMembersModel setSysDate(String sysDate) {
        this.sysDate = sysDate;
        return this;
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public FemaleMembersModel setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Bindable
    public String getSynced() {
        return synced;
    }

    public FemaleMembersModel setSynced(String synced) {
        this.synced = synced;
        return this;
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public FemaleMembersModel setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        return this;
    }


    public String getsA() {
        return sA;
    }

    public FemaleMembersModel setsA(String sA) {
        this.sA = sA;
        return this;
    }


    @Bindable
    public String getStatus() {
        Log.d(TAG, "getStatus: "+this.hh02+" = "+this.status);
        return status;
    }

    public void setStatus(String status) {
        Log.d(TAG, "setStatus: "+this.hh02+" = "+this.status);

        this.status = status;
        notifyPropertyChanged(BR.status);
    }


    @Bindable
    public String getHh01() {
        return hh01;
    }

    public void setHh01(String hh01) {
        this.hh01 = hh01;
        notifyPropertyChanged(BR.hh01);
    }

    @Bindable
    public String getHh02() {
        return hh02;
    }

    public void setHh02(String hh02) {
        this.hh02 = hh02;
        notifyPropertyChanged(BR.hh02);
    }

    @Bindable
    public String getHh03() {
        return hh03;
    }

    public void setHh03(String hh03) {
        this.hh03 = hh03;
        notifyPropertyChanged(BR.hh03);
    }

    @Bindable
    public String getHh04a() {
        return hh04a;
    }

    public void setHh04a(String hh04a) {
        this.hh04a = hh04a;
        notifyPropertyChanged(BR.hh04a);
    }

    @Bindable
    public String getHh04b() {
        return hh04b;
    }

    public void setHh04b(String hh04b) {
        this.hh04b = hh04b;
        notifyPropertyChanged(BR.hh04b);
    }

    @Bindable
    public String getHh04c() {
        return hh04c;
    }

    public void setHh04c(String hh04c) {
        this.hh04c = hh04c;
        notifyPropertyChanged(BR.hh04c);
    }

    @Bindable
    public String getHh05y() {
        return hh05y;
    }

    public void setHh05y(String hh05y) {
        this.hh05y = hh05y;
        Log.d(TAG, "setHh05y: "+ hh03 +" || "+hh05y);
/*        if((hh03.equals("1") && Integer.parseInt(hh05y) > 19)|| this.status.equals("1")){
        setStatus("1");}
        else {
            setStatus("");
    }*/
        notifyPropertyChanged(BR.hh05y);
    }

    @Bindable
    public String getHh05m() {
        return hh05m;
    }

    public void setHh05m(String hh05m) {
        this.hh05m = hh05m;
        notifyPropertyChanged(BR.hh05m);
    }

    @Bindable
    public String getHh06() {
        return hh06;
    }

    public void setHh06(String hh06) {
        this.hh06 = hh06;
        notifyPropertyChanged(BR.hh06);
    }

    @Bindable
    public String getHh07() {
        return hh07;
    }

    public void setHh07(String hh07) {
        this.hh07 = hh07;
        notifyPropertyChanged(BR.hh07);
    }

    @Bindable
    public String getHh08() {
        return hh08;
    }

    public void setHh08(String hh08) {
        this.hh08 = hh08;
        notifyPropertyChanged(BR.hh08);
    }

    @Bindable
    public String getHh09() {
        return hh09;
    }

    public void setHh09(String hh09) {
        this.hh09 = hh09;
        notifyPropertyChanged(BR.hh09);
    }

    @Bindable
    public String getHh10() {
        return hh10;
    }

    public void setHh10(String hh10) {
        this.hh10 = hh10;
        notifyPropertyChanged(BR.hh10);
    }

    @Bindable
    public String getHh11() {
        return hh11;
    }

    public void setHh11(String hh11) {
        this.hh11 = hh11;
/*        if (hh11.equals("2")|| this.status.equals("1")) {
            this.status = "1";
        } else {
            this.status = "";
        }*/
        notifyPropertyChanged(BR.hh11);
    }

    @Bindable
    public String getMemCategory() {
        return memCategory;
    }

    public void setMemCategory(String memCategory) {
        this.memCategory = memCategory;
        notifyPropertyChanged(BR.memCategory);
    }

    @Bindable
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        notifyChange(BR.expanded);
    }

    public FemaleMembersModel Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_ID);
        this.uid = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_UID);
        this.uuid = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_UUID);
        this.serialNo = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_SERIAL_NO);
        this.userName = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_SYSDATE);
        this.hfCode = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_CODE);
        this.hfName = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_NAME);
        this.tehsilCode = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_NAME);
        this.lhwCode = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_CODE);
        this.lhwName = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_NAME);
        this.khandanNumber = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_KHANDAN_NUMBER);
        this.deviceId = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_APPVERSION);
        this.endTime = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_ENDINGDATETIME);
        this.status = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_STATUS);
        this.synced = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED_DATE);

        this.sA = jsonObject.getString(FemaleMembersContract.FemaleMembersTable.COLUMN_SA);

        return this;

    }


    public FemaleMembersModel Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_UUID));
        this.serialNo = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_SERIAL_NO));
        this.userName = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_SYSDATE));
        this.hfCode = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_CODE));
        this.hfName = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_NAME));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_NAME));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_CODE));
        this.lhwName = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_NAME));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_KHANDAN_NUMBER));
        this.deviceId = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_APPVERSION));
        this.endTime = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_ENDINGDATETIME));
        this.status = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_STATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED_DATE));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(HHMembersContract.HHMembersTable.COLUMN_S01HH));

        sAHydrate(cursor.getString(cursor.getColumnIndex(FemaleMembersContract.FemaleMembersTable.COLUMN_SA)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, FemaleMembersModel.class);
    }

    public String sAtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("hh01", hh01)
                    .put("hh02", hh02)
                    .put("hh03", hh03)
                    .put("hh04a", hh04a)
                    .put("hh04b", hh04b)
                    .put("hh04c", hh04c)
                    .put("hh05y", hh05y)
                    .put("hh05m", hh05m)
                    .put("hh06", hh06)
                    .put("hh07", hh07)
                    .put("hh08", hh08)
                    .put("hh09", hh09)
                    .put("hh10", hh10)
                    .put("hh11", hh11)
                    .put("memCategory", memCategory);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_CODE, this.hfCode == null ? JSONObject.NULL : this.hfCode);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_HF_NAME, this.hfName == null ? JSONObject.NULL : this.hfName);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_CODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_NAME, this.lhwName == null ? JSONObject.NULL : this.lhwName);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_KHANDAN_NUMBER, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);

            json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SA, new JSONObject(sAtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(FemaleMembersContract.FemaleMembersTable.COLUMN_SA, new JSONObject(this.sA));
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
                this.hh01 = json.getString("hh01");
                this.hh02 = json.getString("hh02");
                this.hh03 = json.getString("hh03");
                this.hh04a = json.getString("hh04a");
                this.hh04b = json.getString("hh04b");
                this.hh04c = json.getString("hh04c");
                this.hh05y = json.getString("hh05y");
                this.hh05m = json.getString("hh05m");
                this.hh06 = json.getString("hh06");
                this.hh07 = json.getString("hh07");
                this.hh08 = json.getString("hh08");
                this.hh09 = json.getString("hh09");
                this.hh10 = json.getString("hh10");
                this.hh11 = json.getString("hh11");
                this.memCategory = json.getString("memCategory");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public static ArrayList<FemaleMembersModel> createFemaleMembersList(int numFemales) {
        ArrayList<FemaleMembersModel> femaleMembersModels = new ArrayList<FemaleMembersModel>();

        for (int i = 1; i <= numFemales; i++) {
            femaleMembersModels.add(new FemaleMembersModel());
        }

        return femaleMembersModels;
    }


    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }
}
