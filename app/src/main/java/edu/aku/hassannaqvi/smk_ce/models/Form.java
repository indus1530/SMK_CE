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
    private String dcode = StringUtils.EMPTY;
    private String ucode = StringUtils.EMPTY;
    private String cluster = StringUtils.EMPTY;
    private String hhno = StringUtils.EMPTY;
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
    private String sC = StringUtils.EMPTY;
    private String sD = StringUtils.EMPTY;
    private String sE = StringUtils.EMPTY;

    //Not saving in DB
    private LocalDate localDate = null;
    private boolean exist = false;
    // FIELD VARIABLES
    //L H W and HouseHold Information
    private String lhw01 = StringUtils.EMPTY;
    private String lhw04 = StringUtils.EMPTY;
    private String hhi04a = StringUtils.EMPTY;
    private String hhi04b = StringUtils.EMPTY;
    private String hhi04c = StringUtils.EMPTY;
    private String hhi04d = StringUtils.EMPTY;
    private String hhi04e = StringUtils.EMPTY;
    private String hhi04f = StringUtils.EMPTY;
    private String lhwphoto = StringUtils.EMPTY;
    private String hhv01 = StringUtils.EMPTY;
    private String hhv02 = StringUtils.EMPTY;
    private String hhv03a = StringUtils.EMPTY;
    private String hhv03b = StringUtils.EMPTY;
    private String hhv03c = StringUtils.EMPTY;
    private String hhv03d = StringUtils.EMPTY;
    private String hhv03e = StringUtils.EMPTY;
    private String hhv03f = StringUtils.EMPTY;
    //HouseHold Information verify
    private String hh01 = StringUtils.EMPTY;
    private String hh05y = StringUtils.EMPTY;
    private String hh05m = StringUtils.EMPTY;
    //M W R A
    private String mwra01 = StringUtils.EMPTY;
    //ADOLESCENT
    private String adol01 = StringUtils.EMPTY;
    // V H C
    private String vhc01 = StringUtils.EMPTY;

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
        this.dcode = dcode;
        this.ucode = ucode;
        this.cluster = cluster;
        this.hhno = hhno;
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
    public String getDcode() {
        return dcode;
    }

    public Form setDcode(String dcode) {
        this.dcode = dcode;
        return this;
    }

    @Bindable
    public String getUcode() {
        return ucode;
    }

    public Form setUcode(String ucode) {
        this.ucode = ucode;
        return this;
    }

    @Bindable
    public String getCluster() {
        return cluster;
    }

    public Form setCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    @Bindable
    public String getHhno() {
        return hhno;
    }

    public Form setHhno(String hhno) {
        this.hhno = hhno;
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

    private String lhw02 = StringUtils.EMPTY;
    private String lhw03 = StringUtils.EMPTY;

    @Bindable
    public String getSynced() {
        return synced;
    }

    private String hhi01 = StringUtils.EMPTY;
    private String hhi02 = StringUtils.EMPTY;
    private String hhi03 = StringUtils.EMPTY;

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

    public String getsC() {
        return sC;
    }

    public Form setsC(String sC) {
        this.sC = sC;
        return this;
    }

    public String getsD() {
        return sD;
    }

    public Form setsD(String sD) {
        this.sD = sD;
        return this;
    }

    public String getsE() {
        return sE;
    }

    public Form setsE(String sE) {
        this.sE = sE;
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
    public String getHhv01() {
        return hhv01;
    }

    public void setHhv01(String hhv01) {
        this.hhv01 = hhv01;
        notifyPropertyChanged(BR.hhv01);
    }

    @Bindable
    public String getHhv02() {
        return hhv02;
    }

    public void setHhv02(String hhv02) {
        this.hhv02 = hhv02;
        notifyPropertyChanged(BR.hhv02);
    }

    @Bindable
    public String getHhv03a() {
        return hhv03a;
    }

    public void setHhv03a(String hhv03a) {
        this.hhv03a = hhv03a;
        notifyPropertyChanged(BR.hhv03a);
    }

    @Bindable
    public String getHhv03b() {
        return hhv03b;
    }

    public void setHhv03b(String hhv03b) {
        this.hhv03b = hhv03b;
        notifyPropertyChanged(BR.hhv03b);
    }

    @Bindable
    public String getHhv03c() {
        return hhv03c;
    }

    public void setHhv03c(String hhv03c) {
        this.hhv03c = hhv03c;
        notifyPropertyChanged(BR.hhv03c);
    }

    @Bindable
    public String getHhv03d() {
        return hhv03d;
    }

    private String hh02 = StringUtils.EMPTY;
    private String hh03 = StringUtils.EMPTY;
    private String hh04a = StringUtils.EMPTY;
    private String hh04b = StringUtils.EMPTY;
    private String hh04c = StringUtils.EMPTY;

    public void setHhv03d(String hhv03d) {
        this.hhv03d = hhv03d;
        notifyPropertyChanged(BR.hhv03d);
    }

    @Bindable
    public String getHhv03e() {
        return hhv03e;
    }

    private String hh06 = StringUtils.EMPTY;
    private String hh07 = StringUtils.EMPTY;
    private String hh08 = StringUtils.EMPTY;
    private String hh09 = StringUtils.EMPTY;
    private String hh10 = StringUtils.EMPTY;
    private String hh11 = StringUtils.EMPTY;

    public void setHhv03e(String hhv03e) {
        this.hhv03e = hhv03e;
        notifyPropertyChanged(BR.hhv03e);
    }

    @Bindable
    public String getHhv03f() {
        return hhv03f;
    }

    public void setHhv03f(String hhv03f) {
        this.hhv03f = hhv03f;
        notifyPropertyChanged(BR.hhv03f);
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

    @Bindable
    public String getHh11() {
        return hh11;
    }

    public void setHh11(String hh11) {
        this.hh11 = hh11;
        notifyPropertyChanged(BR.hh11);
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

    public void setMwra24(String mwra24) {
        this.mwra24 = mwra24;
        notifyPropertyChanged(BR.mwra24);
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
        this.dcode = jsonObject.getString(FormsContract.FormsTable.COLUMN_DCODE);
        this.ucode = jsonObject.getString(FormsContract.FormsTable.COLUMN_UCODE);
        this.cluster = jsonObject.getString(FormsContract.FormsTable.COLUMN_CLUSTER);
        this.hhno = jsonObject.getString(FormsContract.FormsTable.COLUMN_HHNO);
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
        this.sC = jsonObject.getString(FormsContract.FormsTable.COLUMN_SC);
        this.sD = jsonObject.getString(FormsContract.FormsTable.COLUMN_SD);
        this.sE = jsonObject.getString(FormsContract.FormsTable.COLUMN_SE);

        return this;

    }


    public Form Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYSDATE));
        this.dcode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DCODE));
        this.ucode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UCODE));
        this.cluster = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_CLUSTER));
        this.hhno = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_HHNO));
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
        sCHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SC)));
        sDHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SD)));
        sEHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SE)));

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
                    .put("lhwphoto", lhwphoto)
                    .put("hhv01", hhv01)
                    .put("hhv02", hhv02)
                    .put("hhv03a", hhv03a)
                    .put("hhv03b", hhv03b)
                    .put("hhv03c", hhv03c)
                    .put("hhv03d", hhv03d)
                    .put("hhv03e", hhv03e)
                    .put("hhv03f", hhv03f);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public String sBtoString() {
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
                    .put("hh11", hh11);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public String sCtoString() {
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


    public String sDtoString() {
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


    public String sEtoString() {
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
            json.put(FormsContract.FormsTable.COLUMN_DCODE, this.dcode == null ? JSONObject.NULL : this.dcode);
            json.put(FormsContract.FormsTable.COLUMN_UCODE, this.ucode == null ? JSONObject.NULL : this.ucode);
            json.put(FormsContract.FormsTable.COLUMN_CLUSTER, this.cluster == null ? JSONObject.NULL : this.cluster);
            json.put(FormsContract.FormsTable.COLUMN_HHNO, this.hhno == null ? JSONObject.NULL : this.hhno);
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
            json.put(FormsContract.FormsTable.COLUMN_SC, new JSONObject(sCtoString()));
            json.put(FormsContract.FormsTable.COLUMN_SD, new JSONObject(sDtoString()));
            json.put(FormsContract.FormsTable.COLUMN_SE, new JSONObject(sEtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SA, new JSONObject(this.sA));
            }

            if (this.sB != null && !this.sB.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SB, new JSONObject(this.sB));
            }

            if (this.sC != null && !this.sC.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SC, new JSONObject(this.sC));
            }

            if (this.sD != null && !this.sD.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SD, new JSONObject(this.sD));
            }

            if (this.sE != null && !this.sE.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SE, new JSONObject(this.sE));
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
                this.hhv01 = json.getString("hhv01");
                this.hhv02 = json.getString("hhv02");
                this.hhv03a = json.getString("hhv03a");
                this.hhv03b = json.getString("hhv03b");
                this.hhv03c = json.getString("hhv03c");
                this.hhv03d = json.getString("hhv03d");
                this.hhv03e = json.getString("hhv03e");
                this.hhv03f = json.getString("hhv03f");
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void sCHydrate(String string) {

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


    public void sDHydrate(String string) {

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


    public void sEHydrate(String string) {

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
