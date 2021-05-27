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
import edu.aku.hassannaqvi.smk_ce.contracts.MWRAContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class MWRAModel extends BaseObservable {

    private final String TAG = "MWRAModel";

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

    //M W R A
    private String mwra01 = StringUtils.EMPTY;
    private String mwra02 = StringUtils.EMPTY;
    private String mwra03 = StringUtils.EMPTY;
    private String mwra04 = StringUtils.EMPTY;
    private String mwra05a = StringUtils.EMPTY;
    private String mwra05b = StringUtils.EMPTY;
    private String mwra06 = StringUtils.EMPTY;
    private String mwra07 = StringUtils.EMPTY;
    private String mwra08 = StringUtils.EMPTY;
    private String mwra08a = StringUtils.EMPTY;
    private String mwra08b = StringUtils.EMPTY;
    private String mwra08c = StringUtils.EMPTY;
    private String mwra08d = StringUtils.EMPTY;
    private String mwra08e = StringUtils.EMPTY;
    private String mwra08f = StringUtils.EMPTY;
    private String mwra08g = StringUtils.EMPTY;
    private String mwra0896 = StringUtils.EMPTY;
    private String mwra0896x = StringUtils.EMPTY;
    private String mwra09 = StringUtils.EMPTY;
    private String mwra10 = StringUtils.EMPTY;
    private String mwra11 = StringUtils.EMPTY;
    private String mwra12 = StringUtils.EMPTY;
    private String mwra12a = StringUtils.EMPTY;
    private String mwra12b = StringUtils.EMPTY;
    private String mwra12c = StringUtils.EMPTY;
    private String mwra12d = StringUtils.EMPTY;
    private String mwra12e = StringUtils.EMPTY;
    private String mwra12f = StringUtils.EMPTY;
    private String mwra12g = StringUtils.EMPTY;
    private String mwra12h = StringUtils.EMPTY;
    private String mwra12i = StringUtils.EMPTY;
    private String mwra12j = StringUtils.EMPTY;
    private String mwra12k = StringUtils.EMPTY;
    private String mwra12l = StringUtils.EMPTY;
    private String mwra12m = StringUtils.EMPTY;
    private String mwra1296 = StringUtils.EMPTY;
    private String mwra1296x = StringUtils.EMPTY;
    private String mwra13 = StringUtils.EMPTY;
    private String mwra14 = StringUtils.EMPTY;
    private String mwra1496x = StringUtils.EMPTY;
    private String mwra15 = StringUtils.EMPTY;
    private String mwra16 = StringUtils.EMPTY;
    private String mwra17 = StringUtils.EMPTY;
    private String mwra17a = StringUtils.EMPTY;
    private String mwra17b = StringUtils.EMPTY;
    private String mwra17c = StringUtils.EMPTY;
    private String mwra17d = StringUtils.EMPTY;
    private String mwra17e = StringUtils.EMPTY;
    private String mwra1796 = StringUtils.EMPTY;
    private String mwra1796x = StringUtils.EMPTY;
    private String mwra18 = StringUtils.EMPTY;
    private String mwra18a = StringUtils.EMPTY;
    private String mwra18b = StringUtils.EMPTY;
    private String mwra18c = StringUtils.EMPTY;
    private String mwra18d = StringUtils.EMPTY;
    private String mwra18e = StringUtils.EMPTY;
    private String mwra18f = StringUtils.EMPTY;
    private String mwra18g = StringUtils.EMPTY;
    private String mwra18h = StringUtils.EMPTY;
    private String mwra1896 = StringUtils.EMPTY;
    private String mwra1896x = StringUtils.EMPTY;
    private String mwra19 = StringUtils.EMPTY;
    private String mwra20 = StringUtils.EMPTY;
    private String mwra2096x = StringUtils.EMPTY;
    private String mwra21 = StringUtils.EMPTY;
    private String mwra22 = StringUtils.EMPTY;
    private String mwra23 = StringUtils.EMPTY;
    private String mwra23a = StringUtils.EMPTY;
    private String mwra23b = StringUtils.EMPTY;
    private String mwra23c = StringUtils.EMPTY;
    private String mwra23d = StringUtils.EMPTY;
    private String mwra23e = StringUtils.EMPTY;
    private String mwra23f = StringUtils.EMPTY;
    private String mwra23g = StringUtils.EMPTY;
    private String mwra23h = StringUtils.EMPTY;
    private String mwra23i = StringUtils.EMPTY;
    private String mwra23j = StringUtils.EMPTY;
    private String mwra2396 = StringUtils.EMPTY;
    private String mwra2396x = StringUtils.EMPTY;
    private String mwra24 = StringUtils.EMPTY;


    public MWRAModel() {
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

    public MWRAModel setUid(String uid) {
        this.uid = uid;
        return this;
    }


    @Bindable
    public String getUuid() {
        return uuid;
    }

    public MWRAModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }


    @Bindable
    public String getSerialNo() {
        return serialNo;
    }

    public MWRAModel setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }


    @Bindable
    public String getUserName() {
        return userName;
    }

    public MWRAModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Bindable
    public String getDistrictCode() {
        return districtCode;
    }

    public MWRAModel setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }


    @Bindable
    public String getDistrictName() {
        return districtName;
    }

    public MWRAModel setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }


    @Bindable
    public String getTehsilCode() {
        return tehsilCode;
    }

    public MWRAModel setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
        return this;
    }


    @Bindable
    public String getTehsilName() {
        return tehsilName;
    }

    public MWRAModel setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
        return this;
    }


    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public MWRAModel setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
        return this;
    }


    @Bindable
    public String getLhwName() {
        return lhwName;
    }

    public MWRAModel setLhwName(String lhwName) {
        this.lhwName = lhwName;
        return this;
    }


    @Bindable
    public String getKhandanNumber() {
        return khandanNumber;
    }

    public MWRAModel setKhandanNumber(String khandanNumber) {
        this.khandanNumber = khandanNumber;
        return this;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public MWRAModel setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public MWRAModel setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        return this;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public MWRAModel setAppver(String appver) {
        this.appver = appver;
        return this;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public MWRAModel setSysDate(String sysDate) {
        this.sysDate = sysDate;
        return this;
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public MWRAModel setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Bindable
    public String getSynced() {
        return synced;
    }

    public MWRAModel setSynced(String synced) {
        this.synced = synced;
        return this;
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public MWRAModel setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        return this;
    }


    public String getsA() {
        return sA;
    }

    public MWRAModel setsA(String sA) {
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
    public String getMwra01() {
        return mwra01;
    }

    public void setMwra01(String mwra01) {
        this.mwra01 = mwra01;
        notifyPropertyChanged(BR.mwra01);
    }

    @Bindable
    public String getMwra02() {
        return mwra02;
    }

    public void setMwra02(String mwra02) {
        this.mwra02 = mwra02;
        notifyPropertyChanged(BR.mwra02);
    }

    @Bindable
    public String getMwra03() {
        return mwra03;
    }

    public void setMwra03(String mwra03) {
        this.mwra03 = mwra03;
        notifyPropertyChanged(BR.mwra03);
    }

    @Bindable
    public String getMwra04() {
        return mwra04;
    }

    public void setMwra04(String mwra04) {
        this.mwra04 = mwra04;
        notifyPropertyChanged(BR.mwra04);
    }

    @Bindable
    public String getMwra05a() {
        return mwra05a;
    }

    public void setMwra05a(String mwra05a) {
        this.mwra05a = mwra05a;
        notifyPropertyChanged(BR.mwra05a);
    }

    @Bindable
    public String getMwra05b() {
        return mwra05b;
    }

    public void setMwra05b(String mwra05b) {
        this.mwra05b = mwra05b;
        notifyPropertyChanged(BR.mwra05b);
    }

    @Bindable
    public String getMwra06() {
        return mwra06;
    }

    public void setMwra06(String mwra06) {
        this.mwra06 = mwra06;
        notifyPropertyChanged(BR.mwra06);
    }

    @Bindable
    public String getMwra07() {
        return mwra07;
    }

    public void setMwra07(String mwra07) {
        this.mwra07 = mwra07;
        notifyPropertyChanged(BR.mwra07);
    }

    @Bindable
    public String getMwra08() {
        return mwra08;
    }

    public void setMwra08(String mwra08) {
        this.mwra08 = mwra08;
        notifyPropertyChanged(BR.mwra08);
    }

    @Bindable
    public String getMwra08a() {
        return mwra08a;
    }

    public void setMwra08a(String mwra08a) {
        this.mwra08a = mwra08a;
        notifyPropertyChanged(BR.mwra08a);
    }

    @Bindable
    public String getMwra08b() {
        return mwra08b;
    }

    public void setMwra08b(String mwra08b) {
        this.mwra08b = mwra08b;
        notifyPropertyChanged(BR.mwra08b);
    }

    @Bindable
    public String getMwra08c() {
        return mwra08c;
    }

    public void setMwra08c(String mwra08c) {
        this.mwra08c = mwra08c;
        notifyPropertyChanged(BR.mwra08c);
    }

    @Bindable
    public String getMwra08d() {
        return mwra08d;
    }

    public void setMwra08d(String mwra08d) {
        this.mwra08d = mwra08d;
        notifyPropertyChanged(BR.mwra08d);
    }

    @Bindable
    public String getMwra08e() {
        return mwra08e;
    }

    public void setMwra08e(String mwra08e) {
        this.mwra08e = mwra08e;
        notifyPropertyChanged(BR.mwra08e);
    }

    @Bindable
    public String getMwra08f() {
        return mwra08f;
    }

    public void setMwra08f(String mwra08f) {
        this.mwra08f = mwra08f;
        notifyPropertyChanged(BR.mwra08f);
    }

    @Bindable
    public String getMwra08g() {
        return mwra08g;
    }

    public void setMwra08g(String mwra08g) {
        this.mwra08g = mwra08g;
        notifyPropertyChanged(BR.mwra08g);
    }

    @Bindable
    public String getMwra0896() {
        return mwra0896;
    }

    public void setMwra0896(String mwra0896) {
        this.mwra0896 = mwra0896;
        notifyPropertyChanged(BR.mwra0896);
    }

    @Bindable
    public String getMwra0896x() {
        return mwra0896x;
    }

    public void setMwra0896x(String mwra0896x) {
        this.mwra0896x = mwra0896x;
        notifyPropertyChanged(BR.mwra0896x);
    }

    @Bindable
    public String getMwra09() {
        return mwra09;
    }

    public void setMwra09(String mwra09) {
        this.mwra09 = mwra09;
        notifyPropertyChanged(BR.mwra09);
    }

    @Bindable
    public String getMwra10() {
        return mwra10;
    }

    public void setMwra10(String mwra10) {
        this.mwra10 = mwra10;
        notifyPropertyChanged(BR.mwra10);
    }

    @Bindable
    public String getMwra11() {
        return mwra11;
    }

    public void setMwra11(String mwra11) {
        this.mwra11 = mwra11;
        notifyPropertyChanged(BR.mwra11);
    }

    @Bindable
    public String getMwra12() {
        return mwra12;
    }

    public void setMwra12(String mwra12) {
        this.mwra12 = mwra12;
        notifyPropertyChanged(BR.mwra12);
    }

    @Bindable
    public String getMwra12a() {
        return mwra12a;
    }

    public void setMwra12a(String mwra12a) {
        this.mwra12a = mwra12a;
        notifyPropertyChanged(BR.mwra12a);
    }

    @Bindable
    public String getMwra12b() {
        return mwra12b;
    }

    public void setMwra12b(String mwra12b) {
        this.mwra12b = mwra12b;
        notifyPropertyChanged(BR.mwra12b);
    }

    @Bindable
    public String getMwra12c() {
        return mwra12c;
    }

    public void setMwra12c(String mwra12c) {
        this.mwra12c = mwra12c;
        notifyPropertyChanged(BR.mwra12c);
    }

    @Bindable
    public String getMwra12d() {
        return mwra12d;
    }

    public void setMwra12d(String mwra12d) {
        this.mwra12d = mwra12d;
        notifyPropertyChanged(BR.mwra12d);
    }

    @Bindable
    public String getMwra12e() {
        return mwra12e;
    }

    public void setMwra12e(String mwra12e) {
        this.mwra12e = mwra12e;
        notifyPropertyChanged(BR.mwra12e);
    }

    @Bindable
    public String getMwra12f() {
        return mwra12f;
    }

    public void setMwra12f(String mwra12f) {
        this.mwra12f = mwra12f;
        notifyPropertyChanged(BR.mwra12f);
    }

    @Bindable
    public String getMwra12g() {
        return mwra12g;
    }

    public void setMwra12g(String mwra12g) {
        this.mwra12g = mwra12g;
        notifyPropertyChanged(BR.mwra12g);
    }

    @Bindable
    public String getMwra12h() {
        return mwra12h;
    }

    public void setMwra12h(String mwra12h) {
        this.mwra12h = mwra12h;
        notifyPropertyChanged(BR.mwra12h);
    }

    @Bindable
    public String getMwra12i() {
        return mwra12i;
    }

    public void setMwra12i(String mwra12i) {
        this.mwra12i = mwra12i;
        notifyPropertyChanged(BR.mwra12i);
    }

    @Bindable
    public String getMwra12j() {
        return mwra12j;
    }

    public void setMwra12j(String mwra12j) {
        this.mwra12j = mwra12j;
        notifyPropertyChanged(BR.mwra12j);
    }

    @Bindable
    public String getMwra12k() {
        return mwra12k;
    }

    public void setMwra12k(String mwra12k) {
        this.mwra12k = mwra12k;
        notifyPropertyChanged(BR.mwra12k);
    }

    @Bindable
    public String getMwra12l() {
        return mwra12l;
    }

    public void setMwra12l(String mwra12l) {
        this.mwra12l = mwra12l;
        notifyPropertyChanged(BR.mwra12l);
    }

    @Bindable
    public String getMwra12m() {
        return mwra12m;
    }

    public void setMwra12m(String mwra12m) {
        this.mwra12m = mwra12m;
        notifyPropertyChanged(BR.mwra12m);
    }

    @Bindable
    public String getMwra1296() {
        return mwra1296;
    }

    public void setMwra1296(String mwra1296) {
        this.mwra1296 = mwra1296;
        notifyPropertyChanged(BR.mwra1296);
    }

    @Bindable
    public String getMwra1296x() {
        return mwra1296x;
    }

    public void setMwra1296x(String mwra1296x) {
        this.mwra1296x = mwra1296x;
        notifyPropertyChanged(BR.mwra1296x);
    }

    @Bindable
    public String getMwra13() {
        return mwra13;
    }

    public void setMwra13(String mwra13) {
        this.mwra13 = mwra13;
        notifyPropertyChanged(BR.mwra13);
    }

    @Bindable
    public String getMwra14() {
        return mwra14;
    }

    public void setMwra14(String mwra14) {
        this.mwra14 = mwra14;
        notifyPropertyChanged(BR.mwra14);
    }

    @Bindable
    public String getMwra1496x() {
        return mwra1496x;
    }

    public void setMwra1496x(String mwra1496x) {
        this.mwra1496x = mwra1496x;
        notifyPropertyChanged(BR.mwra1496x);
    }

    @Bindable
    public String getMwra15() {
        return mwra15;
    }

    public void setMwra15(String mwra15) {
        this.mwra15 = mwra15;
        notifyPropertyChanged(BR.mwra15);
    }

    @Bindable
    public String getMwra16() {
        return mwra16;
    }

    public void setMwra16(String mwra16) {
        this.mwra16 = mwra16;
        notifyPropertyChanged(BR.mwra16);
    }

    @Bindable
    public String getMwra17() {
        return mwra17;
    }

    public void setMwra17(String mwra17) {
        this.mwra17 = mwra17;
        notifyPropertyChanged(BR.mwra17);
    }

    @Bindable
    public String getMwra17a() {
        return mwra17a;
    }

    public void setMwra17a(String mwra17a) {
        this.mwra17a = mwra17a;
        notifyPropertyChanged(BR.mwra17a);
    }

    @Bindable
    public String getMwra17b() {
        return mwra17b;
    }

    public void setMwra17b(String mwra17b) {
        this.mwra17b = mwra17b;
        notifyPropertyChanged(BR.mwra17b);
    }

    @Bindable
    public String getMwra17c() {
        return mwra17c;
    }

    public void setMwra17c(String mwra17c) {
        this.mwra17c = mwra17c;
        notifyPropertyChanged(BR.mwra17c);
    }

    @Bindable
    public String getMwra17d() {
        return mwra17d;
    }

    public void setMwra17d(String mwra17d) {
        this.mwra17d = mwra17d;
        notifyPropertyChanged(BR.mwra17d);
    }

    @Bindable
    public String getMwra17e() {
        return mwra17e;
    }

    public void setMwra17e(String mwra17e) {
        this.mwra17e = mwra17e;
        notifyPropertyChanged(BR.mwra17e);
    }

    @Bindable
    public String getMwra1796() {
        return mwra1796;
    }

    public void setMwra1796(String mwra1796) {
        this.mwra1796 = mwra1796;
        notifyPropertyChanged(BR.mwra1796);
    }

    @Bindable
    public String getMwra1796x() {
        return mwra1796x;
    }

    public void setMwra1796x(String mwra1796x) {
        this.mwra1796x = mwra1796x;
        notifyPropertyChanged(BR.mwra1796x);
    }

    @Bindable
    public String getMwra18() {
        return mwra18;
    }

    public void setMwra18(String mwra18) {
        this.mwra18 = mwra18;
        notifyPropertyChanged(BR.mwra18);
    }

    @Bindable
    public String getMwra18a() {
        return mwra18a;
    }

    public void setMwra18a(String mwra18a) {
        this.mwra18a = mwra18a;
        notifyPropertyChanged(BR.mwra18a);
    }

    @Bindable
    public String getMwra18b() {
        return mwra18b;
    }

    public void setMwra18b(String mwra18b) {
        this.mwra18b = mwra18b;
        notifyPropertyChanged(BR.mwra18b);
    }

    @Bindable
    public String getMwra18c() {
        return mwra18c;
    }

    public void setMwra18c(String mwra18c) {
        this.mwra18c = mwra18c;
        notifyPropertyChanged(BR.mwra18c);
    }

    @Bindable
    public String getMwra18d() {
        return mwra18d;
    }

    public void setMwra18d(String mwra18d) {
        this.mwra18d = mwra18d;
        notifyPropertyChanged(BR.mwra18d);
    }

    @Bindable
    public String getMwra18e() {
        return mwra18e;
    }

    public void setMwra18e(String mwra18e) {
        this.mwra18e = mwra18e;
        notifyPropertyChanged(BR.mwra18e);
    }

    @Bindable
    public String getMwra18f() {
        return mwra18f;
    }

    public void setMwra18f(String mwra18f) {
        this.mwra18f = mwra18f;
        notifyPropertyChanged(BR.mwra18f);
    }

    @Bindable
    public String getMwra18g() {
        return mwra18g;
    }

    public void setMwra18g(String mwra18g) {
        this.mwra18g = mwra18g;
        notifyPropertyChanged(BR.mwra18g);
    }

    @Bindable
    public String getMwra18h() {
        return mwra18h;
    }

    public void setMwra18h(String mwra18h) {
        this.mwra18h = mwra18h;
        notifyPropertyChanged(BR.mwra18h);
    }

    @Bindable
    public String getMwra1896() {
        return mwra1896;
    }

    public void setMwra1896(String mwra1896) {
        this.mwra1896 = mwra1896;
        notifyPropertyChanged(BR.mwra1896);
    }

    @Bindable
    public String getMwra1896x() {
        return mwra1896x;
    }

    public void setMwra1896x(String mwra1896x) {
        this.mwra1896x = mwra1896x;
        notifyPropertyChanged(BR.mwra1896x);
    }

    @Bindable
    public String getMwra19() {
        return mwra19;
    }

    public void setMwra19(String mwra19) {
        this.mwra19 = mwra19;
        notifyPropertyChanged(BR.mwra19);
    }

    @Bindable
    public String getMwra20() {
        return mwra20;
    }

    public void setMwra20(String mwra20) {
        this.mwra20 = mwra20;
        notifyPropertyChanged(BR.mwra20);
    }

    @Bindable
    public String getMwra2096x() {
        return mwra2096x;
    }

    public void setMwra2096x(String mwra2096x) {
        this.mwra2096x = mwra2096x;
        notifyPropertyChanged(BR.mwra2096x);
    }

    @Bindable
    public String getMwra21() {
        return mwra21;
    }

    public void setMwra21(String mwra21) {
        this.mwra21 = mwra21;
        notifyPropertyChanged(BR.mwra21);
    }

    @Bindable
    public String getMwra22() {
        return mwra22;
    }

    public void setMwra22(String mwra22) {
        this.mwra22 = mwra22;
        notifyPropertyChanged(BR.mwra22);
    }

    @Bindable
    public String getMwra23() {
        return mwra23;
    }

    public void setMwra23(String mwra23) {
        this.mwra23 = mwra23;
        notifyPropertyChanged(BR.mwra23);
    }

    @Bindable
    public String getMwra23a() {
        return mwra23a;
    }

    public void setMwra23a(String mwra23a) {
        this.mwra23a = mwra23a;
        notifyPropertyChanged(BR.mwra23a);
    }

    @Bindable
    public String getMwra23b() {
        return mwra23b;
    }

    public void setMwra23b(String mwra23b) {
        this.mwra23b = mwra23b;
        notifyPropertyChanged(BR.mwra23b);
    }

    @Bindable
    public String getMwra23c() {
        return mwra23c;
    }

    public void setMwra23c(String mwra23c) {
        this.mwra23c = mwra23c;
        notifyPropertyChanged(BR.mwra23c);
    }

    @Bindable
    public String getMwra23d() {
        return mwra23d;
    }

    public void setMwra23d(String mwra23d) {
        this.mwra23d = mwra23d;
        notifyPropertyChanged(BR.mwra23d);
    }

    @Bindable
    public String getMwra23e() {
        return mwra23e;
    }

    public void setMwra23e(String mwra23e) {
        this.mwra23e = mwra23e;
        notifyPropertyChanged(BR.mwra23e);
    }

    @Bindable
    public String getMwra23f() {
        return mwra23f;
    }

    public void setMwra23f(String mwra23f) {
        this.mwra23f = mwra23f;
        notifyPropertyChanged(BR.mwra23f);
    }

    @Bindable
    public String getMwra23g() {
        return mwra23g;
    }

    public void setMwra23g(String mwra23g) {
        this.mwra23g = mwra23g;
        notifyPropertyChanged(BR.mwra23g);
    }

    @Bindable
    public String getMwra23h() {
        return mwra23h;
    }

    public void setMwra23h(String mwra23h) {
        this.mwra23h = mwra23h;
        notifyPropertyChanged(BR.mwra23h);
    }

    @Bindable
    public String getMwra23i() {
        return mwra23i;
    }

    public void setMwra23i(String mwra23i) {
        this.mwra23i = mwra23i;
        notifyPropertyChanged(BR.mwra23i);
    }

    @Bindable
    public String getMwra23j() {
        return mwra23j;
    }

    public void setMwra23j(String mwra23j) {
        this.mwra23j = mwra23j;
        notifyPropertyChanged(BR.mwra23j);
    }

    @Bindable
    public String getMwra2396() {
        return mwra2396;
    }

    public void setMwra2396(String mwra2396) {
        this.mwra2396 = mwra2396;
        notifyPropertyChanged(BR.mwra2396);
    }

    @Bindable
    public String getMwra2396x() {
        return mwra2396x;
    }

    public void setMwra2396x(String mwra2396x) {
        this.mwra2396x = mwra2396x;
        notifyPropertyChanged(BR.mwra2396x);
    }

    @Bindable
    public String getMwra24() {
        return mwra24;
    }

    public void setMwra24(String mwra24) {
        this.mwra24 = mwra24;
        notifyPropertyChanged(BR.mwra24);
    }


    public MWRAModel Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(MWRAContract.MWRATable.COLUMN_ID);
        this.uid = jsonObject.getString(MWRAContract.MWRATable.COLUMN_UID);
        this.uuid = jsonObject.getString(MWRAContract.MWRATable.COLUMN_UUID);
        this.serialNo = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SERIAL_NO);
        this.userName = jsonObject.getString(MWRAContract.MWRATable.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SYSDATE);
        this.districtCode = jsonObject.getString(MWRAContract.MWRATable.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(MWRAContract.MWRATable.COLUMN_DISTRICT_NAME);
        this.tehsilCode = jsonObject.getString(MWRAContract.MWRATable.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(MWRAContract.MWRATable.COLUMN_TEHSIL_NAME);
        this.lhwCode = jsonObject.getString(MWRAContract.MWRATable.COLUMN_LHW_CODE);
        this.lhwName = jsonObject.getString(MWRAContract.MWRATable.COLUMN_LHW_NAME);
        this.khandanNumber = jsonObject.getString(MWRAContract.MWRATable.COLUMN_KHANDAN_NUMBER);
        this.deviceId = jsonObject.getString(MWRAContract.MWRATable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(MWRAContract.MWRATable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(MWRAContract.MWRATable.COLUMN_APPVERSION);
        this.endTime = jsonObject.getString(MWRAContract.MWRATable.COLUMN_ENDINGDATETIME);
        this.status = jsonObject.getString(MWRAContract.MWRATable.COLUMN_STATUS);
        this.synced = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SYNCED_DATE);

        this.sA = jsonObject.getString(MWRAContract.MWRATable.COLUMN_SA);

        return this;

    }


    public MWRAModel Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_UUID));
        this.serialNo = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SERIAL_NO));
        this.userName = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SYSDATE));
        this.districtCode = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_DISTRICT_NAME));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_TEHSIL_NAME));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_LHW_CODE));
        this.lhwName = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_LHW_NAME));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_KHANDAN_NUMBER));
        this.deviceId = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_APPVERSION));
        this.endTime = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_ENDINGDATETIME));
        this.status = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_STATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SYNCED_DATE));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(MwraContract.MwraTable.COLUMN_S01HH));

        sAHydrate(cursor.getString(cursor.getColumnIndex(MWRAContract.MWRATable.COLUMN_SA)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, MWRAModel.class);
    }

    public String sAtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("mwra01", mwra01)
                    .put("mwra02", mwra02)
                    .put("mwra03", mwra03)
                    .put("mwra04", mwra04)
                    .put("mwra05a", mwra05a)
                    .put("mwra05b", mwra05b)
                    .put("mwra06", mwra06)
                    .put("mwra07", mwra07)
                    .put("mwra08", mwra08)
                    .put("mwra08a", mwra08a)
                    .put("mwra08b", mwra08b)
                    .put("mwra08c", mwra08c)
                    .put("mwra08d", mwra08d)
                    .put("mwra08e", mwra08e)
                    .put("mwra08f", mwra08f)
                    .put("mwra08g", mwra08g)
                    .put("mwra0896", mwra0896)
                    .put("mwra0896x", mwra0896x)
                    .put("mwra09", mwra09)
                    .put("mwra10", mwra10)
                    .put("mwra11", mwra11)
                    .put("mwra12", mwra12)
                    .put("mwra12a", mwra12a)
                    .put("mwra12b", mwra12b)
                    .put("mwra12c", mwra12c)
                    .put("mwra12d", mwra12d)
                    .put("mwra12e", mwra12e)
                    .put("mwra12f", mwra12f)
                    .put("mwra12g", mwra12g)
                    .put("mwra12h", mwra12h)
                    .put("mwra12i", mwra12i)
                    .put("mwra12j", mwra12j)
                    .put("mwra12k", mwra12k)
                    .put("mwra12l", mwra12l)
                    .put("mwra12m", mwra12m)
                    .put("mwra1296", mwra1296)
                    .put("mwra1296x", mwra1296x)
                    .put("mwra13", mwra13)
                    .put("mwra14", mwra14)
                    .put("mwra1496x", mwra1496x)
                    .put("mwra15", mwra15)
                    .put("mwra16", mwra16)
                    .put("mwra17", mwra17)
                    .put("mwra17a", mwra17a)
                    .put("mwra17b", mwra17b)
                    .put("mwra17c", mwra17c)
                    .put("mwra17d", mwra17d)
                    .put("mwra17e", mwra17e)
                    .put("mwra1796", mwra1796)
                    .put("mwra1796x", mwra1796x)
                    .put("mwra18", mwra18)
                    .put("mwra18a", mwra18a)
                    .put("mwra18b", mwra18b)
                    .put("mwra18c", mwra18c)
                    .put("mwra18d", mwra18d)
                    .put("mwra18e", mwra18e)
                    .put("mwra18f", mwra18f)
                    .put("mwra18g", mwra18g)
                    .put("mwra18h", mwra18h)
                    .put("mwra1896", mwra1896)
                    .put("mwra1896x", mwra1896x)
                    .put("mwra19", mwra19)
                    .put("mwra20", mwra20)
                    .put("mwra2096x", mwra2096x)
                    .put("mwra21", mwra21)
                    .put("mwra22", mwra22)
                    .put("mwra23", mwra23)
                    .put("mwra23a", mwra23a)
                    .put("mwra23b", mwra23b)
                    .put("mwra23c", mwra23c)
                    .put("mwra23d", mwra23d)
                    .put("mwra23e", mwra23e)
                    .put("mwra23f", mwra23f)
                    .put("mwra23g", mwra23g)
                    .put("mwra23h", mwra23h)
                    .put("mwra23i", mwra23i)
                    .put("mwra23j", mwra23j)
                    .put("mwra2396", mwra2396)
                    .put("mwra2396x", mwra2396x)
                    .put("mwra24", mwra24);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(MWRAContract.MWRATable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(MWRAContract.MWRATable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
            json.put(MWRAContract.MWRATable.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
            json.put(MWRAContract.MWRATable.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);
            json.put(MWRAContract.MWRATable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(MWRAContract.MWRATable.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
            json.put(MWRAContract.MWRATable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
            json.put(MWRAContract.MWRATable.COLUMN_DISTRICT_NAME, this.districtName == null ? JSONObject.NULL : this.districtName);
            json.put(MWRAContract.MWRATable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(MWRAContract.MWRATable.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
            json.put(MWRAContract.MWRATable.COLUMN_LHW_CODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(MWRAContract.MWRATable.COLUMN_LHW_NAME, this.lhwName == null ? JSONObject.NULL : this.lhwName);
            json.put(MWRAContract.MWRATable.COLUMN_KHANDAN_NUMBER, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(MWRAContract.MWRATable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(MWRAContract.MWRATable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(MWRAContract.MWRATable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(MWRAContract.MWRATable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(MWRAContract.MWRATable.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
            json.put(MWRAContract.MWRATable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(MWRAContract.MWRATable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);

            json.put(MWRAContract.MWRATable.COLUMN_SA, new JSONObject(sAtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(MWRAContract.MWRATable.COLUMN_SA, new JSONObject(this.sA));
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
                this.mwra01 = json.getString("mwra01");
                this.mwra02 = json.getString("mwra02");
                this.mwra03 = json.getString("mwra03");
                this.mwra04 = json.getString("mwra04");
                this.mwra05a = json.getString("mwra05a");
                this.mwra05b = json.getString("mwra05b");
                this.mwra06 = json.getString("mwra06");
                this.mwra07 = json.getString("mwra07");
                this.mwra08 = json.getString("mwra08");
                this.mwra08a = json.getString("mwra08a");
                this.mwra08b = json.getString("mwra08b");
                this.mwra08c = json.getString("mwra08c");
                this.mwra08d = json.getString("mwra08d");
                this.mwra08e = json.getString("mwra08e");
                this.mwra08f = json.getString("mwra08f");
                this.mwra08g = json.getString("mwra08g");
                this.mwra0896 = json.getString("mwra0896");
                this.mwra0896x = json.getString("mwra0896x");
                this.mwra09 = json.getString("mwra09");
                this.mwra10 = json.getString("mwra10");
                this.mwra11 = json.getString("mwra11");
                this.mwra12 = json.getString("mwra12");
                this.mwra12a = json.getString("mwra12a");
                this.mwra12b = json.getString("mwra12b");
                this.mwra12c = json.getString("mwra12c");
                this.mwra12d = json.getString("mwra12d");
                this.mwra12e = json.getString("mwra12e");
                this.mwra12f = json.getString("mwra12f");
                this.mwra12g = json.getString("mwra12g");
                this.mwra12h = json.getString("mwra12h");
                this.mwra12i = json.getString("mwra12i");
                this.mwra12j = json.getString("mwra12j");
                this.mwra12k = json.getString("mwra12k");
                this.mwra12l = json.getString("mwra12l");
                this.mwra12m = json.getString("mwra12m");
                this.mwra1296 = json.getString("mwra1296");
                this.mwra1296x = json.getString("mwra1296x");
                this.mwra13 = json.getString("mwra13");
                this.mwra14 = json.getString("mwra14");
                this.mwra1496x = json.getString("mwra1496x");
                this.mwra15 = json.getString("mwra15");
                this.mwra16 = json.getString("mwra16");
                this.mwra17 = json.getString("mwra17");
                this.mwra17a = json.getString("mwra17a");
                this.mwra17b = json.getString("mwra17b");
                this.mwra17c = json.getString("mwra17c");
                this.mwra17d = json.getString("mwra17d");
                this.mwra17e = json.getString("mwra17e");
                this.mwra1796 = json.getString("mwra1796");
                this.mwra1796x = json.getString("mwra1796x");
                this.mwra18 = json.getString("mwra18");
                this.mwra18a = json.getString("mwra18a");
                this.mwra18b = json.getString("mwra18b");
                this.mwra18c = json.getString("mwra18c");
                this.mwra18d = json.getString("mwra18d");
                this.mwra18e = json.getString("mwra18e");
                this.mwra18f = json.getString("mwra18f");
                this.mwra18g = json.getString("mwra18g");
                this.mwra18h = json.getString("mwra18h");
                this.mwra1896 = json.getString("mwra1896");
                this.mwra1896x = json.getString("mwra1896x");
                this.mwra19 = json.getString("mwra19");
                this.mwra20 = json.getString("mwra20");
                this.mwra2096x = json.getString("mwra2096x");
                this.mwra21 = json.getString("mwra21");
                this.mwra22 = json.getString("mwra22");
                this.mwra23 = json.getString("mwra23");
                this.mwra23a = json.getString("mwra23a");
                this.mwra23b = json.getString("mwra23b");
                this.mwra23c = json.getString("mwra23c");
                this.mwra23d = json.getString("mwra23d");
                this.mwra23e = json.getString("mwra23e");
                this.mwra23f = json.getString("mwra23f");
                this.mwra23g = json.getString("mwra23g");
                this.mwra23h = json.getString("mwra23h");
                this.mwra23i = json.getString("mwra23i");
                this.mwra23j = json.getString("mwra23j");
                this.mwra2396 = json.getString("mwra2396");
                this.mwra2396x = json.getString("mwra2396x");
                this.mwra24 = json.getString("mwra24");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
