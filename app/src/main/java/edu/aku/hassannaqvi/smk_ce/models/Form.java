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
import edu.aku.hassannaqvi.smk_ce.contracts.FormsContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class Form extends BaseObservable {

    private final String TAG = "Form";

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;


    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String districtCode = StringUtils.EMPTY;
    private final String districtName = StringUtils.EMPTY;
    private String tehsilCode = StringUtils.EMPTY;
    private final String tehsilName = StringUtils.EMPTY;
    private String lhwCode = StringUtils.EMPTY;
    private final String lhwName = StringUtils.EMPTY;
    private String khandanNumber = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;
    private String g5Flag = "-1";
    private String hhflag = "-1";


    // SECTION VARIABLES
    private String sA = StringUtils.EMPTY;
    private String sB = StringUtils.EMPTY;

    //Not saving in DB
    private LocalDate localDate = null;
    private boolean exist = false;


    // FIELD VARIABLES
    //L H W and HouseHold Information
    private String lhw01 = StringUtils.EMPTY;
    private String lhw02 = StringUtils.EMPTY;
    private String lhw03 = StringUtils.EMPTY;
    private String lhw04 = StringUtils.EMPTY;
    private String hhi01 = StringUtils.EMPTY;
    private String hhi02 = StringUtils.EMPTY;
    private String hhi03 = StringUtils.EMPTY;
    private String hhi04a = StringUtils.EMPTY;
    private String hhi04b = StringUtils.EMPTY;
    private String hhi04c = StringUtils.EMPTY;
    private String hhi04d = StringUtils.EMPTY;
    private String hhi04e = StringUtils.EMPTY;
    private String hhi04f = StringUtils.EMPTY;
    private String lhwphoto = StringUtils.EMPTY;

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
    public String getTehsilCode() {
        return tehsilCode;
    }

    public Form setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
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

    public String getG5Flag() {
        return g5Flag;
    }

    public void setG5Flag(String g5Flag) {
        this.g5Flag = g5Flag;
    }

    public String getHhflag() {
        return hhflag;
    }

    public Form setHhflag(String hhflag) {
        this.hhflag = hhflag;
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
    public String getLhw01() {
        return lhw01;
    }

    public void setLhw01(String lhw01) {
        this.lhw01 = lhw01;
        notifyPropertyChanged(BR.lhw01);
    }

    @Bindable
    public String getLhw02() {
        return lhw02;
    }

    public void setLhw02(String lhw02) {
        this.lhw02 = lhw02;
        notifyPropertyChanged(BR.lhw02);
    }

    @Bindable
    public String getLhw03() {
        return lhw03;
    }

    public void setLhw03(String lhw03) {
        this.lhw03 = lhw03;
        notifyPropertyChanged(BR.lhw03);
    }

    @Bindable
    public String getLhw04() {
        return lhw04;
    }

    public void setLhw04(String lhw04) {
        this.lhw04 = lhw04;
        notifyPropertyChanged(BR.lhw04);
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

    @Bindable
    public String getLhwphoto() {
        return lhwphoto;
    }

    public void setLhwphoto(String lhwphoto) {
        this.lhwphoto = lhwphoto;
        notifyPropertyChanged(BR.lhwphoto);
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
        this.districtCode = jsonObject.getString(FormsContract.FormsTable.COLUMN_DCODE);
        this.tehsilCode = jsonObject.getString(FormsContract.FormsTable.COLUMN_UCODE);
        this.lhwCode = jsonObject.getString(FormsContract.FormsTable.COLUMN_CLUSTER);
        this.khandanNumber = jsonObject.getString(FormsContract.FormsTable.COLUMN_HHNO);
        this.deviceId = jsonObject.getString(FormsContract.FormsTable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(FormsContract.FormsTable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(FormsContract.FormsTable.COLUMN_APPVERSION);
        this.endTime = jsonObject.getString(FormsContract.FormsTable.COLUMN_ENDINGDATETIME);
        this.iStatus = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS);
        this.iStatus96x = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS96x);
        this.iStatus96x = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS96x);
        this.synced = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYNCED_DATE);
        this.g5Flag = jsonObject.getString(FormsContract.FormsTable.COLUMN_G5FLAG);
        this.hhflag = jsonObject.getString(FormsContract.FormsTable.COLUMN_HHFLAG);

        this.sA = jsonObject.getString(FormsContract.FormsTable.COLUMN_SA);
        this.sB = jsonObject.getString(FormsContract.FormsTable.COLUMN_SB);

        return this;

    }


    public Form Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYSDATE));
        this.districtCode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DCODE));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UCODE));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_CLUSTER));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_HHNO));
        this.deviceId = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_APPVERSION));
        this.endTime = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ENDINGDATETIME));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS));
        this.iStatus96x = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS96x));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED_DATE));
        this.g5Flag = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_G5FLAG));
        this.hhflag = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_HHFLAG));

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
            json.put("lhw01", lhw01)
                    .put("lhw02", lhw02)
                    .put("lhw03", lhw03)
                    .put("lhw04", lhw04)
                    .put("hhi01", hhi01)
                    .put("hhi02", hhi02)
                    .put("hhi03", hhi03)
                    .put("hhi04a", hhi04a)
                    .put("hhi04b", hhi04b)
                    .put("hhi04c", hhi04c)
                    .put("hhi04d", hhi04d)
                    .put("hhi04e", hhi04e)
                    .put("hhio4f", hhi04f)
                    .put("lhwphoto", lhwphoto);
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
            json.put(FormsContract.FormsTable.COLUMN_DCODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
            json.put(FormsContract.FormsTable.COLUMN_UCODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(FormsContract.FormsTable.COLUMN_CLUSTER, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(FormsContract.FormsTable.COLUMN_HHNO, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(FormsContract.FormsTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(FormsContract.FormsTable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(FormsContract.FormsTable.COLUMN_ISTATUS, this.iStatus == null ? JSONObject.NULL : this.iStatus);
            json.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, this.iStatus96x == null ? JSONObject.NULL : this.iStatus96x);
            json.put(FormsContract.FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);
            json.put(FormsContract.FormsTable.COLUMN_G5FLAG, this.g5Flag == null ? JSONObject.NULL : this.g5Flag);
            json.put(FormsContract.FormsTable.COLUMN_HHFLAG, this.hhflag == null ? JSONObject.NULL : this.hhflag);

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
                this.lhw01 = json.getString("lhw01");
                this.lhw02 = json.getString("lhw02");
                this.lhw03 = json.getString("lhw03");
                this.lhw04 = json.getString("lhw04");
                this.hhi01 = json.getString("hhi01");
                this.hhi02 = json.getString("hhi02");
                this.hhi03 = json.getString("hhi03");
                this.hhi04a = json.getString("hhi04a");
                this.hhi04b = json.getString("hhi04b");
                this.hhi04c = json.getString("hhi04c");
                this.hhi04d = json.getString("hhi04d");
                this.hhi04e = json.getString("hhi04e");
                this.hhi04f = json.getString("hhio4f");
                this.lhwphoto = json.getString("lhwphoto");
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
}
