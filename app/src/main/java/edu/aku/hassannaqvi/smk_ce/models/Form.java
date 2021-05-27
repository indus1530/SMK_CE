package edu.aku.hassannaqvi.smk_ce.models;

import android.database.Cursor;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.LocalDate;

import edu.aku.hassannaqvi.smk_ce.BR;
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class Form extends BaseObservable implements Observable {

    private final String TAG = "Form";

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;


    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
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
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;


    // SECTION VARIABLES
    private String sA = StringUtils.EMPTY;
    private String sB = StringUtils.EMPTY;

    //Not saving in DB
    private LocalDate localDate = null;
    private boolean exist = false;

    // FIELD VARIABLES
    //L H W and HouseHold Information
    private String hhv01 = StringUtils.EMPTY;
    private String hhv02a = StringUtils.EMPTY;
    private String hhv02b = StringUtils.EMPTY;
    private String hhv02c = StringUtils.EMPTY;
    private String hhv02d = StringUtils.EMPTY;
    private String hhv02e = StringUtils.EMPTY;
    private String hhv02f = StringUtils.EMPTY;
    private String hhv02g = StringUtils.EMPTY;
    private String hhv03 = StringUtils.EMPTY;

    // V H C
    private String vhc01 = StringUtils.EMPTY;
    private String vhc02 = StringUtils.EMPTY;
    private String vhc03 = StringUtils.EMPTY;
    private String vhc04 = StringUtils.EMPTY;
    private String vhc05 = StringUtils.EMPTY;
    private String vhc06 = StringUtils.EMPTY;
    private String vhc06a = StringUtils.EMPTY;
    private String vhc06b = StringUtils.EMPTY;
    private String vhc06c = StringUtils.EMPTY;
    private String vhc06d = StringUtils.EMPTY;
    private String vhc06e = StringUtils.EMPTY;
    private String vhc06f = StringUtils.EMPTY;
    private String vhc06g = StringUtils.EMPTY;
    private String vhc06h = StringUtils.EMPTY;
    private String vhc06i = StringUtils.EMPTY;
    private String vhc06j = StringUtils.EMPTY;
    private String vhc0696 = StringUtils.EMPTY;
    private String vhc0696x = StringUtils.EMPTY;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    public Form() {

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

    public Form setUid(String uid) {
        this.uid = uid;
        return this;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public Form setUserName(String userName) {
        this.userName = userName;
        return this;
    }


    @Bindable
    public String getDistrictCode() {
        return districtCode;
    }

    public Form setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }


    @Bindable
    public String getDistrictName() {
        return districtName;
    }

    public Form setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }


    @Bindable
    public String getTehsilCode() {
        return tehsilCode;
    }

    public Form setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
        return this;
    }


    @Bindable
    public String getTehsilName() {
        return tehsilName;
    }

    public Form setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
        return this;
    }


    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public Form setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        return this;
    }


    @Bindable
    public String getLhwName() {
        return lhwName;
    }

    public Form setLhwName(String lhwName) {
        this.lhwName = lhwName;
        return this;
    }


    @Bindable
    public String getKhandanNumber() {
        return khandanNumber;
    }

    public Form setKhandanNumber(String khandanNumber) {
        this.khandanNumber = khandanNumber;
        return this;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public Form setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public Form setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        return this;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public Form setAppver(String appver) {
        this.appver = appver;
        return this;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public Form setSysDate(String sysDate) {
        this.sysDate = sysDate;
        return this;
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public Form setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Bindable
    public String getSynced() {
        return synced;
    }

    public Form setSynced(String synced) {
        this.synced = synced;
        return this;
    }


    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public Form setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        return this;
    }


    public String getsA() {
        return sA;
    }

    public Form setsA(String sA) {
        this.sA = sA;
        return this;
    }

    public String getsB() {
        return sB;
    }

    public Form setsB(String sB) {
        this.sB = sB;
        return this;
    }


    @Bindable
    public String getIStatus() {
        return iStatus;
    }

    public void setIStatus(String iStatus) {
        this.iStatus = iStatus;
        notifyPropertyChanged(BR.iStatus);
    }

    @Bindable
    public String getIStatus96x() {
        return iStatus96x;
    }

    public void setIStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
        notifyPropertyChanged(BR.iStatus96x);
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


    @Bindable
    public String getVhc01() {
        return vhc01;
    }

    public void setVhc01(String vhc01) {
        this.vhc01 = vhc01;
        notifyPropertyChanged(BR.vhc01);
    }

    @Bindable
    public String getVhc02() {
        return vhc02;
    }

    public void setVhc02(String vhc02) {
        this.vhc02 = vhc02;
        notifyPropertyChanged(BR.vhc02);
    }

    @Bindable
    public String getVhc03() {
        return vhc03;
    }

    public void setVhc03(String vhc03) {
        this.vhc03 = vhc03;
        notifyPropertyChanged(BR.vhc03);
    }

    @Bindable
    public String getVhc04() {
        return vhc04;
    }

    public void setVhc04(String vhc04) {
        this.vhc04 = vhc04;
        notifyPropertyChanged(BR.vhc04);
    }

    @Bindable
    public String getVhc05() {
        return vhc05;
    }

    public void setVhc05(String vhc05) {
        this.vhc05 = vhc05;
        notifyPropertyChanged(BR.vhc05);
    }

    @Bindable
    public String getVhc06() {
        return vhc06;
    }

    public void setVhc06(String vhc06) {
        this.vhc06 = vhc06;
        notifyPropertyChanged(BR.vhc06);
    }

    @Bindable
    public String getVhc06a() {
        return vhc06a;
    }

    public void setVhc06a(String vhc06a) {
        this.vhc06a = vhc06a;
        notifyPropertyChanged(BR.vhc06a);
    }

    @Bindable
    public String getVhc06b() {
        return vhc06b;
    }

    public void setVhc06b(String vhc06b) {
        this.vhc06b = vhc06b;
        notifyPropertyChanged(BR.vhc06b);
    }

    @Bindable
    public String getVhc06c() {
        return vhc06c;
    }

    public void setVhc06c(String vhc06c) {
        this.vhc06c = vhc06c;
        notifyPropertyChanged(BR.vhc06c);
    }

    @Bindable
    public String getVhc06d() {
        return vhc06d;
    }

    public void setVhc06d(String vhc06d) {
        this.vhc06d = vhc06d;
        notifyPropertyChanged(BR.vhc06d);
    }

    @Bindable
    public String getVhc06e() {
        return vhc06e;
    }

    public void setVhc06e(String vhc06e) {
        this.vhc06e = vhc06e;
        notifyPropertyChanged(BR.vhc06e);
    }

    @Bindable
    public String getVhc06f() {
        return vhc06f;
    }

    public void setVhc06f(String vhc06f) {
        this.vhc06f = vhc06f;
        notifyPropertyChanged(BR.vhc06f);
    }

    @Bindable
    public String getVhc06g() {
        return vhc06g;
    }

    public void setVhc06g(String vhc06g) {
        this.vhc06g = vhc06g;
        notifyPropertyChanged(BR.vhc06g);
    }

    @Bindable
    public String getVhc06h() {
        return vhc06h;
    }

    public void setVhc06h(String vhc06h) {
        this.vhc06h = vhc06h;
        notifyPropertyChanged(BR.vhc06h);
    }

    @Bindable
    public String getVhc06i() {
        return vhc06i;
    }

    public void setVhc06i(String vhc06i) {
        this.vhc06i = vhc06i;
        notifyPropertyChanged(BR.vhc06i);
    }

    @Bindable
    public String getVhc06j() {
        return vhc06j;
    }

    public void setVhc06j(String vhc06j) {
        this.vhc06j = vhc06j;
        notifyPropertyChanged(BR.vhc06j);
    }

    @Bindable
    public String getVhc0696() {
        return vhc0696;
    }

    public void setVhc0696(String vhc0696) {
        this.vhc0696 = vhc0696;
        notifyPropertyChanged(BR.vhc0696);
    }

    @Bindable
    public String getVhc0696x() {
        return vhc0696x;
    }

    public void setVhc0696x(String vhc0696x) {
        this.vhc0696x = vhc0696x;
        notifyPropertyChanged(BR.vhc0696x);
    }


    public Form Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(FormsContract.FormsTable.COLUMN_ID);
        this.uid = jsonObject.getString(FormsContract.FormsTable.COLUMN_UID);
        this.userName = jsonObject.getString(FormsContract.FormsTable.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYSDATE);
        this.districtCode = jsonObject.getString(FormsContract.FormsTable.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(FormsContract.FormsTable.COLUMN_DISTRICT_NAME);
        this.tehsilCode = jsonObject.getString(FormsContract.FormsTable.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(FormsContract.FormsTable.COLUMN_TEHSIL_NAME);
        this.lhwCode = jsonObject.getString(FormsContract.FormsTable.COLUMN_LHW_CODE);
        this.lhwName = jsonObject.getString(FormsContract.FormsTable.COLUMN_LHW_NAME);
        this.khandanNumber = jsonObject.getString(FormsContract.FormsTable.COLUMN_KHANDAN_NUMBER);
        this.deviceId = jsonObject.getString(FormsContract.FormsTable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(FormsContract.FormsTable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(FormsContract.FormsTable.COLUMN_APPVERSION);
        this.endTime = jsonObject.getString(FormsContract.FormsTable.COLUMN_ENDINGDATETIME);
        this.iStatus = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS);
        this.iStatus96x = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS96x);
        this.iStatus96x = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS96x);
        this.synced = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYNCED_DATE);

        this.sA = jsonObject.getString(FormsContract.FormsTable.COLUMN_SA);
        this.sB = jsonObject.getString(FormsContract.FormsTable.COLUMN_SB);

        return this;

    }


    public Form Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYSDATE));
        this.districtCode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DISTRICT_NAME));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_TEHSIL_NAME));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_LHW_CODE));
        this.lhwName = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_LHW_NAME));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_KHANDAN_NUMBER));
        this.deviceId = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_APPVERSION));
        this.endTime = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ENDINGDATETIME));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS));
        this.iStatus96x = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS96x));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED_DATE));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_S01HH));

        sAHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SA)));
        sBHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SB)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, Form.class);
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


    public String sBtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("vhc01", vhc01)
                    .put("vhc02", vhc02)
                    .put("vhc03", vhc03)
                    .put("vhc04", vhc04)
                    .put("vhc05", vhc05)
                    .put("vhc06", vhc06)
                    .put("vhc06a", vhc06a)
                    .put("vhc06b", vhc06b)
                    .put("vhc06c", vhc06c)
                    .put("vhc06d", vhc06d)
                    .put("vhc06e", vhc06e)
                    .put("vhc06f", vhc06f)
                    .put("vhc06g", vhc06g)
                    .put("vhc06h", vhc06h)
                    .put("vhc06i", vhc06i)
                    .put("vhc06j", vhc06j)
                    .put("vhc0696", vhc0696)
                    .put("vhc0696x", vhc0696x);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsContract.FormsTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(FormsContract.FormsTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
            json.put(FormsContract.FormsTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(FormsContract.FormsTable.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
            json.put(FormsContract.FormsTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
            json.put(FormsContract.FormsTable.COLUMN_DISTRICT_NAME, this.districtName == null ? JSONObject.NULL : this.districtName);
            json.put(FormsContract.FormsTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(FormsContract.FormsTable.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
            json.put(FormsContract.FormsTable.COLUMN_LHW_CODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(FormsContract.FormsTable.COLUMN_LHW_NAME, this.lhwName == null ? JSONObject.NULL : this.lhwName);
            json.put(FormsContract.FormsTable.COLUMN_KHANDAN_NUMBER, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(FormsContract.FormsTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(FormsContract.FormsTable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(FormsContract.FormsTable.COLUMN_ISTATUS, this.iStatus == null ? JSONObject.NULL : this.iStatus);
            json.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, this.iStatus96x == null ? JSONObject.NULL : this.iStatus96x);
            json.put(FormsContract.FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);

            json.put(FormsContract.FormsTable.COLUMN_SA, new JSONObject(sAtoString()));
            json.put(FormsContract.FormsTable.COLUMN_SB, new JSONObject(sBtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SA, new JSONObject(this.sA));
            }

            if (this.sB != null && !this.sB.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SB, new JSONObject(this.sB));
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


    public void sBHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.vhc01 = json.getString("vhc01");
                this.vhc02 = json.getString("vhc02");
                this.vhc03 = json.getString("vhc03");
                this.vhc04 = json.getString("vhc04");
                this.vhc05 = json.getString("vhc05");
                this.vhc06 = json.getString("vhc06");
                this.vhc06a = json.getString("vhc06a");
                this.vhc06b = json.getString("vhc06b");
                this.vhc06c = json.getString("vhc06c");
                this.vhc06d = json.getString("vhc06d");
                this.vhc06e = json.getString("vhc06e");
                this.vhc06f = json.getString("vhc06f");
                this.vhc06g = json.getString("vhc06g");
                this.vhc06h = json.getString("vhc06h");
                this.vhc06i = json.getString("vhc06i");
                this.vhc06j = json.getString("vhc06j");
                this.vhc0696 = json.getString("vhc0696");
                this.vhc0696x = json.getString("vhc0696x");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
