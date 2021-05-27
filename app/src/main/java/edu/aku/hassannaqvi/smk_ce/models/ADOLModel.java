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
import edu.aku.hassannaqvi.smk_ce.contracts.ADOLContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class ADOLModel extends BaseObservable {

    private final String TAG = "ADOLModel";

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

    //ADOLESCENT
    private String adol01 = StringUtils.EMPTY;
    private String adol02 = StringUtils.EMPTY;
    private String adol03 = StringUtils.EMPTY;
    private String adol04 = StringUtils.EMPTY;
    private String adol04a = StringUtils.EMPTY;
    private String adol04b = StringUtils.EMPTY;
    private String adol04c = StringUtils.EMPTY;
    private String adol04d = StringUtils.EMPTY;
    private String adol04e = StringUtils.EMPTY;
    private String adol04f = StringUtils.EMPTY;
    private String adol04g = StringUtils.EMPTY;
    private String adol04h = StringUtils.EMPTY;
    private String adol0496 = StringUtils.EMPTY;
    private String adol0496x = StringUtils.EMPTY;
    private String adol05 = StringUtils.EMPTY;
    private String adol06 = StringUtils.EMPTY;
    private String adol06a = StringUtils.EMPTY;
    private String adol06b = StringUtils.EMPTY;
    private String adol06c = StringUtils.EMPTY;
    private String adol06d = StringUtils.EMPTY;
    private String adol0696 = StringUtils.EMPTY;
    private String adol0696x = StringUtils.EMPTY;
    private String adol07 = StringUtils.EMPTY;
    private String adol08 = StringUtils.EMPTY;
    private String adol09 = StringUtils.EMPTY;
    private String adol10 = StringUtils.EMPTY;
    private String adol10a = StringUtils.EMPTY;
    private String adol10b = StringUtils.EMPTY;
    private String adol10c = StringUtils.EMPTY;
    private String adol10d = StringUtils.EMPTY;
    private String adol10e = StringUtils.EMPTY;
    private String adol10f = StringUtils.EMPTY;
    private String adol10g = StringUtils.EMPTY;
    private String adol10h = StringUtils.EMPTY;
    private String adol10i = StringUtils.EMPTY;
    private String adol10j = StringUtils.EMPTY;
    private String adol1096 = StringUtils.EMPTY;
    private String adol1096x = StringUtils.EMPTY;
    private String adol11 = StringUtils.EMPTY;
    private String adol1196x = StringUtils.EMPTY;
    private String adol12 = StringUtils.EMPTY;
    private String adol12a = StringUtils.EMPTY;
    private String adol12b = StringUtils.EMPTY;
    private String adol12c = StringUtils.EMPTY;
    private String adol12d = StringUtils.EMPTY;
    private String adol1296 = StringUtils.EMPTY;
    private String adol1296x = StringUtils.EMPTY;
    private String adol13 = StringUtils.EMPTY;
    private String adol14 = StringUtils.EMPTY;
    private String adol15 = StringUtils.EMPTY;
    private String adol15a = StringUtils.EMPTY;
    private String adol15b = StringUtils.EMPTY;
    private String adol15c = StringUtils.EMPTY;
    private String adol15d = StringUtils.EMPTY;
    private String adol15e = StringUtils.EMPTY;
    private String adol1596 = StringUtils.EMPTY;
    private String adol1596x = StringUtils.EMPTY;


    public ADOLModel() {
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

    public ADOLModel setUid(String uid) {
        this.uid = uid;
        return this;
    }


    @Bindable
    public String getUuid() {
        return uuid;
    }

    public ADOLModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }


    @Bindable
    public String getSerialNo() {
        return serialNo;
    }

    public ADOLModel setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }


    @Bindable
    public String getUserName() {
        return userName;
    }

    public ADOLModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Bindable
    public String getDistrictCode() {
        return districtCode;
    }

    public ADOLModel setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }


    @Bindable
    public String getDistrictName() {
        return districtName;
    }

    public ADOLModel setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }


    @Bindable
    public String getTehsilCode() {
        return tehsilCode;
    }

    public ADOLModel setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
        return this;
    }


    @Bindable
    public String getTehsilName() {
        return tehsilName;
    }

    public ADOLModel setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
        return this;
    }


    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public ADOLModel setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        return this;
    }


    @Bindable
    public String getLhwName() {
        return lhwName;
    }

    public ADOLModel setLhwName(String lhwName) {
        this.lhwName = lhwName;
        return this;
    }


    @Bindable
    public String getKhandanNumber() {
        return khandanNumber;
    }

    public ADOLModel setKhandanNumber(String khandanNumber) {
        this.khandanNumber = khandanNumber;
        return this;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public ADOLModel setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public ADOLModel setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        return this;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public ADOLModel setAppver(String appver) {
        this.appver = appver;
        return this;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public ADOLModel setSysDate(String sysDate) {
        this.sysDate = sysDate;
        return this;
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public ADOLModel setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Bindable
    public String getSynced() {
        return synced;
    }

    public ADOLModel setSynced(String synced) {
        this.synced = synced;
        return this;
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public ADOLModel setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        return this;
    }


    public String getsA() {
        return sA;
    }

    public ADOLModel setsA(String sA) {
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
    public String getAdol01() {
        return adol01;
    }

    public void setAdol01(String adol01) {
        this.adol01 = adol01;
        notifyPropertyChanged(BR.adol01);
    }

    @Bindable
    public String getAdol02() {
        return adol02;
    }

    public void setAdol02(String adol02) {
        this.adol02 = adol02;
        notifyPropertyChanged(BR.adol02);
    }

    @Bindable
    public String getAdol03() {
        return adol03;
    }

    public void setAdol03(String adol03) {
        this.adol03 = adol03;
        notifyPropertyChanged(BR.adol03);
    }

    @Bindable
    public String getAdol04() {
        return adol04;
    }

    public void setAdol04(String adol04) {
        this.adol04 = adol04;
        notifyPropertyChanged(BR.adol04);
    }

    @Bindable
    public String getAdol04a() {
        return adol04a;
    }

    public void setAdol04a(String adol04a) {
        this.adol04a = adol04a;
        notifyPropertyChanged(BR.adol04a);
    }

    @Bindable
    public String getAdol04b() {
        return adol04b;
    }

    public void setAdol04b(String adol04b) {
        this.adol04b = adol04b;
        notifyPropertyChanged(BR.adol04b);
    }

    @Bindable
    public String getAdol04c() {
        return adol04c;
    }

    public void setAdol04c(String adol04c) {
        this.adol04c = adol04c;
        notifyPropertyChanged(BR.adol04c);
    }

    @Bindable
    public String getAdol04d() {
        return adol04d;
    }

    public void setAdol04d(String adol04d) {
        this.adol04d = adol04d;
        notifyPropertyChanged(BR.adol04d);
    }

    @Bindable
    public String getAdol04e() {
        return adol04e;
    }

    public void setAdol04e(String adol04e) {
        this.adol04e = adol04e;
        notifyPropertyChanged(BR.adol04e);
    }

    @Bindable
    public String getAdol04f() {
        return adol04f;
    }

    public void setAdol04f(String adol04f) {
        this.adol04f = adol04f;
        notifyPropertyChanged(BR.adol04f);
    }

    @Bindable
    public String getAdol04g() {
        return adol04g;
    }

    public void setAdol04g(String adol04g) {
        this.adol04g = adol04g;
        notifyPropertyChanged(BR.adol04g);
    }

    @Bindable
    public String getAdol04h() {
        return adol04h;
    }

    public void setAdol04h(String adol04h) {
        this.adol04h = adol04h;
        notifyPropertyChanged(BR.adol04h);
    }

    @Bindable
    public String getAdol0496() {
        return adol0496;
    }

    public void setAdol0496(String adol0496) {
        this.adol0496 = adol0496;
        notifyPropertyChanged(BR.adol0496);
    }

    @Bindable
    public String getAdol0496x() {
        return adol0496x;
    }

    public void setAdol0496x(String adol0496x) {
        this.adol0496x = adol0496x;
        notifyPropertyChanged(BR.adol0496x);
    }

    @Bindable
    public String getAdol05() {
        return adol05;
    }

    public void setAdol05(String adol05) {
        this.adol05 = adol05;
        notifyPropertyChanged(BR.adol05);
    }

    @Bindable
    public String getAdol06() {
        return adol06;
    }

    public void setAdol06(String adol06) {
        this.adol06 = adol06;
        notifyPropertyChanged(BR.adol06);
    }

    @Bindable
    public String getAdol06a() {
        return adol06a;
    }

    public void setAdol06a(String adol06a) {
        this.adol06a = adol06a;
        notifyPropertyChanged(BR.adol06a);
    }

    @Bindable
    public String getAdol06b() {
        return adol06b;
    }

    public void setAdol06b(String adol06b) {
        this.adol06b = adol06b;
        notifyPropertyChanged(BR.adol06b);
    }

    @Bindable
    public String getAdol06c() {
        return adol06c;
    }

    public void setAdol06c(String adol06c) {
        this.adol06c = adol06c;
        notifyPropertyChanged(BR.adol06c);
    }

    @Bindable
    public String getAdol06d() {
        return adol06d;
    }

    public void setAdol06d(String adol06d) {
        this.adol06d = adol06d;
        notifyPropertyChanged(BR.adol06d);
    }

    @Bindable
    public String getAdol0696() {
        return adol0696;
    }

    public void setAdol0696(String adol0696) {
        this.adol0696 = adol0696;
        notifyPropertyChanged(BR.adol0696);
    }

    @Bindable
    public String getAdol0696x() {
        return adol0696x;
    }

    public void setAdol0696x(String adol0696x) {
        this.adol0696x = adol0696x;
        notifyPropertyChanged(BR.adol0696x);
    }

    @Bindable
    public String getAdol07() {
        return adol07;
    }

    public void setAdol07(String adol07) {
        this.adol07 = adol07;
        notifyPropertyChanged(BR.adol07);
    }

    @Bindable
    public String getAdol08() {
        return adol08;
    }

    public void setAdol08(String adol08) {
        this.adol08 = adol08;
        notifyPropertyChanged(BR.adol08);
    }

    @Bindable
    public String getAdol09() {
        return adol09;
    }

    public void setAdol09(String adol09) {
        this.adol09 = adol09;
        notifyPropertyChanged(BR.adol09);
    }

    @Bindable
    public String getAdol10() {
        return adol10;
    }

    public void setAdol10(String adol10) {
        this.adol10 = adol10;
        notifyPropertyChanged(BR.adol10);
    }

    @Bindable
    public String getAdol10a() {
        return adol10a;
    }

    public void setAdol10a(String adol10a) {
        this.adol10a = adol10a;
        notifyPropertyChanged(BR.adol10a);
    }

    @Bindable
    public String getAdol10b() {
        return adol10b;
    }

    public void setAdol10b(String adol10b) {
        this.adol10b = adol10b;
        notifyPropertyChanged(BR.adol10b);
    }

    @Bindable
    public String getAdol10c() {
        return adol10c;
    }

    public void setAdol10c(String adol10c) {
        this.adol10c = adol10c;
        notifyPropertyChanged(BR.adol10c);
    }

    @Bindable
    public String getAdol10d() {
        return adol10d;
    }

    public void setAdol10d(String adol10d) {
        this.adol10d = adol10d;
        notifyPropertyChanged(BR.adol10d);
    }

    @Bindable
    public String getAdol10e() {
        return adol10e;
    }

    public void setAdol10e(String adol10e) {
        this.adol10e = adol10e;
        notifyPropertyChanged(BR.adol10e);
    }

    @Bindable
    public String getAdol10f() {
        return adol10f;
    }

    public void setAdol10f(String adol10f) {
        this.adol10f = adol10f;
        notifyPropertyChanged(BR.adol10f);
    }

    @Bindable
    public String getAdol10g() {
        return adol10g;
    }

    public void setAdol10g(String adol10g) {
        this.adol10g = adol10g;
        notifyPropertyChanged(BR.adol10g);
    }

    @Bindable
    public String getAdol10h() {
        return adol10h;
    }

    public void setAdol10h(String adol10h) {
        this.adol10h = adol10h;
        notifyPropertyChanged(BR.adol10h);
    }

    @Bindable
    public String getAdol10i() {
        return adol10i;
    }

    public void setAdol10i(String adol10i) {
        this.adol10i = adol10i;
        notifyPropertyChanged(BR.adol10i);
    }

    @Bindable
    public String getAdol10j() {
        return adol10j;
    }

    public void setAdol10j(String adol10j) {
        this.adol10j = adol10j;
        notifyPropertyChanged(BR.adol10j);
    }

    @Bindable
    public String getAdol1096() {
        return adol1096;
    }

    public void setAdol1096(String adol1096) {
        this.adol1096 = adol1096;
        notifyPropertyChanged(BR.adol1096);
    }

    @Bindable
    public String getAdol1096x() {
        return adol1096x;
    }

    public void setAdol1096x(String adol1096x) {
        this.adol1096x = adol1096x;
        notifyPropertyChanged(BR.adol1096x);
    }

    @Bindable
    public String getAdol11() {
        return adol11;
    }

    public void setAdol11(String adol11) {
        this.adol11 = adol11;
        notifyPropertyChanged(BR.adol11);
    }

    @Bindable
    public String getAdol1196x() {
        return adol1196x;
    }

    public void setAdol1196x(String adol1196x) {
        this.adol1196x = adol1196x;
        notifyPropertyChanged(BR.adol1196x);
    }

    @Bindable
    public String getAdol12() {
        return adol12;
    }

    public void setAdol12(String adol12) {
        this.adol12 = adol12;
        notifyPropertyChanged(BR.adol12);
    }

    @Bindable
    public String getAdol12a() {
        return adol12a;
    }

    public void setAdol12a(String adol12a) {
        this.adol12a = adol12a;
        notifyPropertyChanged(BR.adol12a);
    }

    @Bindable
    public String getAdol12b() {
        return adol12b;
    }

    public void setAdol12b(String adol12b) {
        this.adol12b = adol12b;
        notifyPropertyChanged(BR.adol12b);
    }

    @Bindable
    public String getAdol12c() {
        return adol12c;
    }

    public void setAdol12c(String adol12c) {
        this.adol12c = adol12c;
        notifyPropertyChanged(BR.adol12c);
    }

    @Bindable
    public String getAdol12d() {
        return adol12d;
    }

    public void setAdol12d(String adol12d) {
        this.adol12d = adol12d;
        notifyPropertyChanged(BR.adol12d);
    }

    @Bindable
    public String getAdol1296() {
        return adol1296;
    }

    public void setAdol1296(String adol1296) {
        this.adol1296 = adol1296;
        notifyPropertyChanged(BR.adol1296);
    }

    @Bindable
    public String getAdol1296x() {
        return adol1296x;
    }

    public void setAdol1296x(String adol1296x) {
        this.adol1296x = adol1296x;
        notifyPropertyChanged(BR.adol1296x);
    }

    @Bindable
    public String getAdol13() {
        return adol13;
    }

    public void setAdol13(String adol13) {
        this.adol13 = adol13;
        notifyPropertyChanged(BR.adol13);
    }

    @Bindable
    public String getAdol14() {
        return adol14;
    }

    public void setAdol14(String adol14) {
        this.adol14 = adol14;
        notifyPropertyChanged(BR.adol14);
    }

    @Bindable
    public String getAdol15() {
        return adol15;
    }

    public void setAdol15(String adol15) {
        this.adol15 = adol15;
        notifyPropertyChanged(BR.adol15);
    }

    @Bindable
    public String getAdol15a() {
        return adol15a;
    }

    public void setAdol15a(String adol15a) {
        this.adol15a = adol15a;
        notifyPropertyChanged(BR.adol15a);
    }

    @Bindable
    public String getAdol15b() {
        return adol15b;
    }

    public void setAdol15b(String adol15b) {
        this.adol15b = adol15b;
        notifyPropertyChanged(BR.adol15b);
    }

    @Bindable
    public String getAdol15c() {
        return adol15c;
    }

    public void setAdol15c(String adol15c) {
        this.adol15c = adol15c;
        notifyPropertyChanged(BR.adol15c);
    }

    @Bindable
    public String getAdol15d() {
        return adol15d;
    }

    public void setAdol15d(String adol15d) {
        this.adol15d = adol15d;
        notifyPropertyChanged(BR.adol15d);
    }

    @Bindable
    public String getAdol15e() {
        return adol15e;
    }

    public void setAdol15e(String adol15e) {
        this.adol15e = adol15e;
        notifyPropertyChanged(BR.adol15e);
    }

    @Bindable
    public String getAdol1596() {
        return adol1596;
    }

    public void setAdol1596(String adol1596) {
        this.adol1596 = adol1596;
        notifyPropertyChanged(BR.adol1596);
    }

    @Bindable
    public String getAdol1596x() {
        return adol1596x;
    }

    public void setAdol1596x(String adol1596x) {
        this.adol1596x = adol1596x;
        notifyPropertyChanged(BR.adol1596x);
    }


    public ADOLModel Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_ID);
        this.uid = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_UID);
        this.uuid = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_UUID);
        this.serialNo = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_SERIAL_NO);
        this.userName = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_SYSDATE);
        this.districtCode = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_DISTRICT_NAME);
        this.tehsilCode = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_TEHSIL_NAME);
        this.lhwCode = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_LHW_CODE);
        this.lhwName = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_LHW_NAME);
        this.khandanNumber = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_KHANDAN_NUMBER);
        this.deviceId = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_APPVERSION);
        this.endTime = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_ENDINGDATETIME);
        this.status = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_STATUS);
        this.synced = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_SYNCED_DATE);

        this.sA = jsonObject.getString(ADOLContract.ADOLTable.COLUMN_SA);

        return this;

    }


    public ADOLModel Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_UUID));
        this.serialNo = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_SERIAL_NO));
        this.userName = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_SYSDATE));
        this.districtCode = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_DISTRICT_NAME));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_TEHSIL_NAME));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_LHW_CODE));
        this.lhwName = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_LHW_NAME));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_KHANDAN_NUMBER));
        this.deviceId = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_APPVERSION));
        this.endTime = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_ENDINGDATETIME));
        this.status = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_STATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_SYNCED_DATE));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(AdolescentContract.AdolescentTable.COLUMN_S01HH));

        sAHydrate(cursor.getString(cursor.getColumnIndex(ADOLContract.ADOLTable.COLUMN_SA)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, ADOLModel.class);
    }


    public String sAtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("adol01", adol01)
                    .put("adol02", adol02)
                    .put("adol03", adol03)
                    .put("adol04", adol04)
                    .put("adol04a", adol04a)
                    .put("adol04b", adol04b)
                    .put("adol04c", adol04c)
                    .put("adol04d", adol04d)
                    .put("adol04e", adol04e)
                    .put("adol04f", adol04f)
                    .put("adol04g", adol04g)
                    .put("adol04h", adol04h)
                    .put("adol0496", adol0496)
                    .put("adol0496x", adol0496x)
                    .put("adol05", adol05)
                    .put("adol06", adol06)
                    .put("adol06a", adol06a)
                    .put("adol06b", adol06b)
                    .put("adol06c", adol06c)
                    .put("adol06d", adol06d)
                    .put("adol0696", adol0696)
                    .put("adol0696x", adol0696x)
                    .put("adol07", adol07)
                    .put("adol08", adol08)
                    .put("adol09", adol09)
                    .put("adol10", adol10)
                    .put("adol10a", adol10a)
                    .put("adol10b", adol10b)
                    .put("adol10c", adol10c)
                    .put("adol10d", adol10d)
                    .put("adol10e", adol10e)
                    .put("adol10f", adol10f)
                    .put("adol10g", adol10g)
                    .put("adol10h", adol10h)
                    .put("adol10i", adol10i)
                    .put("adol10j", adol10j)
                    .put("adol1096", adol1096)
                    .put("adol1096x", adol1096x)
                    .put("adol11", adol11)
                    .put("adol1196x", adol1196x)
                    .put("adol12", adol12)
                    .put("adol12a", adol12a)
                    .put("adol12b", adol12b)
                    .put("adol12c", adol12c)
                    .put("adol12d", adol12d)
                    .put("adol1296", adol1296)
                    .put("adol1296x", adol1296x)
                    .put("adol13", adol13)
                    .put("adol14", adol14)
                    .put("adol15", adol15)
                    .put("adol15a", adol15a)
                    .put("adol15b", adol15b)
                    .put("adol15c", adol15c)
                    .put("adol15d", adol15d)
                    .put("adol15e", adol15e)
                    .put("adol1596", adol1596)
                    .put("adol1596x", adol1596x);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(ADOLContract.ADOLTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(ADOLContract.ADOLTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
            json.put(ADOLContract.ADOLTable.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
            json.put(ADOLContract.ADOLTable.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);
            json.put(ADOLContract.ADOLTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(ADOLContract.ADOLTable.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
            json.put(ADOLContract.ADOLTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
            json.put(ADOLContract.ADOLTable.COLUMN_DISTRICT_NAME, this.districtName == null ? JSONObject.NULL : this.districtName);
            json.put(ADOLContract.ADOLTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(ADOLContract.ADOLTable.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
            json.put(ADOLContract.ADOLTable.COLUMN_LHW_CODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(ADOLContract.ADOLTable.COLUMN_LHW_NAME, this.lhwName == null ? JSONObject.NULL : this.lhwName);
            json.put(ADOLContract.ADOLTable.COLUMN_KHANDAN_NUMBER, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(ADOLContract.ADOLTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(ADOLContract.ADOLTable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(ADOLContract.ADOLTable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(ADOLContract.ADOLTable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(ADOLContract.ADOLTable.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
            json.put(ADOLContract.ADOLTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(ADOLContract.ADOLTable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);

            json.put(ADOLContract.ADOLTable.COLUMN_SA, new JSONObject(sAtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(ADOLContract.ADOLTable.COLUMN_SA, new JSONObject(this.sA));
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
                this.adol01 = json.getString("adol01");
                this.adol02 = json.getString("adol02");
                this.adol03 = json.getString("adol03");
                this.adol04 = json.getString("adol04");
                this.adol04a = json.getString("adol04a");
                this.adol04b = json.getString("adol04b");
                this.adol04c = json.getString("adol04c");
                this.adol04d = json.getString("adol04d");
                this.adol04e = json.getString("adol04e");
                this.adol04f = json.getString("adol04f");
                this.adol04g = json.getString("adol04g");
                this.adol04h = json.getString("adol04h");
                this.adol0496 = json.getString("adol0496");
                this.adol0496x = json.getString("adol0496x");
                this.adol05 = json.getString("adol05");
                this.adol06 = json.getString("adol06");
                this.adol06a = json.getString("adol06a");
                this.adol06b = json.getString("adol06b");
                this.adol06c = json.getString("adol06c");
                this.adol06d = json.getString("adol06d");
                this.adol0696 = json.getString("adol0696");
                this.adol0696x = json.getString("adol0696x");
                this.adol07 = json.getString("adol07");
                this.adol08 = json.getString("adol08");
                this.adol09 = json.getString("adol09");
                this.adol10 = json.getString("adol10");
                this.adol10a = json.getString("adol10a");
                this.adol10b = json.getString("adol10b");
                this.adol10c = json.getString("adol10c");
                this.adol10d = json.getString("adol10d");
                this.adol10e = json.getString("adol10e");
                this.adol10f = json.getString("adol10f");
                this.adol10g = json.getString("adol10g");
                this.adol10h = json.getString("adol10h");
                this.adol10i = json.getString("adol10i");
                this.adol10j = json.getString("adol10j");
                this.adol1096 = json.getString("adol1096");
                this.adol1096x = json.getString("adol1096x");
                this.adol11 = json.getString("adol11");
                this.adol1196x = json.getString("adol1196x");
                this.adol12 = json.getString("adol12");
                this.adol12a = json.getString("adol12a");
                this.adol12b = json.getString("adol12b");
                this.adol12c = json.getString("adol12c");
                this.adol12d = json.getString("adol12d");
                this.adol1296 = json.getString("adol1296");
                this.adol1296x = json.getString("adol1296x");
                this.adol13 = json.getString("adol13");
                this.adol14 = json.getString("adol14");
                this.adol15 = json.getString("adol15");
                this.adol15a = json.getString("adol15a");
                this.adol15b = json.getString("adol15b");
                this.adol15c = json.getString("adol15c");
                this.adol15d = json.getString("adol15d");
                this.adol15e = json.getString("adol15e");
                this.adol1596 = json.getString("adol1596");
                this.adol1596x = json.getString("adol1596x");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
