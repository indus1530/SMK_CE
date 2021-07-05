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
import edu.aku.hassannaqvi.smk_ce.contracts.LHWHouseholdContract;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;

public class LHWHouseholdModel extends BaseObservable {

    private final String TAG = "LHWHouseholdModel";

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;


    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String tehsilCode = StringUtils.EMPTY;
    private String tehsilName = StringUtils.EMPTY;
    private String hfCode = StringUtils.EMPTY;
    private String hfName = StringUtils.EMPTY;
    private String lhwCode = StringUtils.EMPTY;
    private String lhwName = StringUtils.EMPTY;
    private String khandanNumber = StringUtils.EMPTY;
    private String randSNo = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;


    // SECTION VARIABLES
    //private String sA = StringUtils.EMPTY;

    //Not saving in DB
    private LocalDate localDate = null;
    private boolean exist = false;

    // FIELD VARIABLES
    //HouseHold Information
    private String lhw01 = StringUtils.EMPTY;
    private String lhw02 = StringUtils.EMPTY;
    private String lhw03 = StringUtils.EMPTY;
    private String lhw04 = StringUtils.EMPTY;
    private String lhwphoto = StringUtils.EMPTY;


    public LHWHouseholdModel() {
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
  //      this.districtCode = dcode;
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

    public LHWHouseholdModel setUid(String uid) {
        this.uid = uid;
        return this;
    }


/*
    @Bindable
    public String getUuid() {
        return uuid;
    }

    public LHWHouseholdModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }


    @Bindable
    public String getSerialNo() {
        return serialNo;
    }

    public LHWHouseholdModel setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }
*/


    @Bindable
    public String getUserName() {
        return userName;
    }

    public LHWHouseholdModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

 /*   @Bindable
    public String getDistrictCode() {
        return districtCode;
    }

    public LHWHouseholdModel setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }


    @Bindable
    public String getDistrictName() {
        return districtName;
    }

    public LHWHouseholdModel setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }
*/

    @Bindable
    public String getTehsilCode() {
        return tehsilCode;
    }

    public LHWHouseholdModel setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
        return this;
    }


    @Bindable
    public String getTehsilName() {
        return tehsilName;
    }

    public LHWHouseholdModel setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
        return this;
    }


    @Bindable
    public String getHfCode() {
        return hfCode;
    }

    public void setHfCode(String hfCode) {
        this.hfCode = hfCode;
    }


    @Bindable
    public String getHfName() {
        return hfName;
    }

    public void setHfName(String hfName) {
        this.hfName = hfName;
    }

    @Bindable
    public String getLhwCode() {
        return lhwCode;
    }

    public void setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
    }


    @Bindable
    public String getLhwName() {
        return lhwName;
    }

    public void setLhwName(String lhwName) {
        this.lhwName = lhwName;
    }


    @Bindable
    public String getKhandanNumber() {
        return khandanNumber;
    }

    public void setKhandanNumber(String khandanNumber) {
        this.khandanNumber = khandanNumber;
    }

 @Bindable
    public String getRandSNo() {
        return randSNo;
    }

    public void setRandSNo(String randSNo) {
        this.randSNo = randSNo;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

 /*   @Bindable
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
*/
    @Bindable
    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

/*

    public String getsA() {
        return sA;
    }

    public LHWModel setsA(String sA) {
        this.sA = sA;
        return this;
    }
*/


  /*  @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

*/
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
    public String getLhwphoto() {
        return lhwphoto;
    }

    public void setLhwphoto(String lhwphoto) {
        this.lhwphoto = lhwphoto;
        notifyPropertyChanged(BR.lhwphoto);
    }

  /*  @Bindable
    public String getLhw04sno() {
        return lhw04sno;
    }

    public void setLhw04sno(String lhw04sno) {
        this.lhw04sno = lhw04sno;
        notifyPropertyChanged(BR.lhw04sno);
    }
*/

    public LHWHouseholdModel Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_ID);
        this.uid = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UID);
     /*   this.uuid = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UUID);
        this.serialNo = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SERIAL_NO);*/
        this.userName = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYSDATE);
   /*     this.districtCode = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DISTRICT_NAME);*/
        this.tehsilCode = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_NAME);
        this.lhwCode = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE);
        this.lhwName = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_NAME);
        this.hfCode = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE);
        this.hfName = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_NAME);
        this.khandanNumber = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_KHANDAN_NUMBER);
        this.randSNo = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_RAND_NUMBERS);
        this.lhwphoto = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHWREG_PHOTO);
        this.deviceId = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_APPVERSION);
       /* this.endTime = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_ENDINGDATETIME);
        this.status = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_STATUS);*/
        this.synced = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED_DATE);

        //this.sA = jsonObject.getString(LHWContract.LHW_HOUSEHOLD_Table.COLUMN_SA);

        return this;

    }


    public LHWHouseholdModel Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UID));
      /*  this.uuid = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UUID));
        this.serialNo = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SERIAL_NO));*/
        this.userName = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYSDATE));
    /*    this.districtCode = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DISTRICT_NAME));*/
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_NAME));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE));
        this.lhwName = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_NAME));
        this.khandanNumber = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_KHANDAN_NUMBER));
        this.randSNo = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_RAND_NUMBERS));
        this.lhwphoto = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHWREG_PHOTO));
        this.deviceId = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_APPVERSION));
    /*    this.endTime = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_ENDINGDATETIME));
        this.status = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_STATUS));*/
        this.synced = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED_DATE));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(HHInfoContract.HHInfoTable.COLUMN_S01HH));

        //sAHydrate(cursor.getString(cursor.getColumnIndex(LHWContract.LHW_HOUSEHOLD_Table.COLUMN_SA)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, LHWHouseholdModel.class);
    }


   /* public String sAtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("lhw01", lhw01)
                    .put("lhw02", lhw02)
                    .put("lhw03", lhw03)
                    .put("lhw04", lhw04)
                    .put("lhw04sno", lhw04sno)
                    .put("lhwphoto", lhwphoto);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }
*/

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
/*            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);*/
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
/*            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DISTRICT_NAME, this.districtName == null ? JSONObject.NULL : this.districtName);*/
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_NAME, this.lhwName == null ? JSONObject.NULL : this.lhwName);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_KHANDAN_NUMBER, this.khandanNumber == null ? JSONObject.NULL : this.khandanNumber);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_RAND_NUMBERS, this.randSNo == null ? JSONObject.NULL : this.randSNo);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHWREG_PHOTO, this.lhwphoto == null ? JSONObject.NULL : this.lhwphoto);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
/*            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);*/
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);
            json.put(LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);

            /*json.put(LHWContract.LHW_HOUSEHOLD_Table.COLUMN_SA, new JSONObject(sAtoString()));


            if (this.sA != null && !this.sA.equals("")) {
                json.put(LHWContract.LHW_HOUSEHOLD_Table.COLUMN_SA, new JSONObject(this.sA));
            }
*/
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


/*    public void sAHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.lhw01 = json.getString("lhw01");
                this.lhw02 = json.getString("lhw02");
                this.lhw03 = json.getString("lhw03");
                this.lhw04 = json.getString("lhw04");
                this.lhw04sno = json.getString("lhw04sno");
                this.lhwphoto = json.getString("lhwphoto");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }*/
}
