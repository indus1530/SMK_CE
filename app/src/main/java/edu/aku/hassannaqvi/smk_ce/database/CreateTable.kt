package edu.aku.hassannaqvi.smk_ce.database

import edu.aku.hassannaqvi.smk_ce.contracts.*
import edu.aku.hassannaqvi.smk_ce.models.*

object CreateTable {
    const val PROJECT_NAME = "SMKCE2021"
    const val DATABASE_NAME = "$PROJECT_NAME.db"
    const val DATABASE_COPY = "${PROJECT_NAME}_copy.db"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS96x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HF_CODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HF_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_TEHSIL_CODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_TEHSIL_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_LHW_CODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_LHW_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_KHANDAN_NUMBER + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SA + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SB + " TEXT"
            + " );")

    const val SQL_CREATE_HHIDENTIFY = ("CREATE TABLE "
            + HHIDContract.HHIDTable.TABLE_NAME + "("
            + HHIDContract.HHIDTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + HHIDContract.HHIDTable.COLUMN_PROJECT_NAME + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_UID + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_UUID + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_SERIAL_NO + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_USERNAME + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_SYSDATE + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_STATUS + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_DEVICEID + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_DEVICETAGID + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_SYNCED + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_SYNCED_DATE + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_APPVERSION + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_HF_CODE + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_HF_NAME + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_TEHSIL_CODE + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_TEHSIL_NAME + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_LHW_CODE + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_LHW_NAME + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_KHANDAN_NUMBER + " TEXT,"
            + HHIDContract.HHIDTable.COLUMN_SA + " TEXT"
            + " );")

    const val SQL_CREATE_LHW_HOUSEHOLD = ("CREATE TABLE "
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.TABLE_NAME + "("
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_PROJECT_NAME + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_UID + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_USERNAME + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYSDATE + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICEID + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_DEVICETAGID + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_SYNCED_DATE + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_APPVERSION + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_HF_CODE + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_HF_NAME + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_CODE + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_TEHSIL_NAME + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_CODE + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_LHW_NAME + " TEXT,"
            + LHWHouseholdContract.LHW_HOUSEHOLD_Table.COLUMN_KHANDAN_NUMBER + " TEXT"
            + " );")

    const val SQL_CREATE_HHMEMBERS = ("CREATE TABLE "
            + FemaleMembersContract.FemaleMembersTable.TABLE_NAME + "("
            + FemaleMembersContract.FemaleMembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_UID + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_UUID + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_SERIAL_NO + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_USERNAME + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_SYSDATE + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_STATUS + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICEID + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_APPVERSION + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_HF_CODE + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_HF_NAME + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_CODE + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_TEHSIL_NAME + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_CODE + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_LHW_NAME + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_KHANDAN_NUMBER + " TEXT,"
            + FemaleMembersContract.FemaleMembersTable.COLUMN_SA + " TEXT"
            + " );")

    const val SQL_CREATE_MWRA = ("CREATE TABLE "
            + MWRAContract.MWRATable.TABLE_NAME + "("
            + MWRAContract.MWRATable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MWRAContract.MWRATable.COLUMN_PROJECT_NAME + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_UID + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_UUID + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_FMID + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_SERIAL_NO + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_USERNAME + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_SYSDATE + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_STATUS + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_ENDINGDATETIME + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_DEVICEID + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_DEVICETAGID + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_SYNCED + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_SYNCED_DATE + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_APPVERSION + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_DISTRICT_CODE + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_DISTRICT_NAME + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_TEHSIL_CODE + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_TEHSIL_NAME + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_LHW_CODE + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_LHW_NAME + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_KHANDAN_NUMBER + " TEXT,"
            + MWRAContract.MWRATable.COLUMN_SA + " TEXT"
            + " );")

    const val SQL_CREATE_ADOLESCENT = ("CREATE TABLE "
            + ADOLContract.ADOLTable.TABLE_NAME + "("
            + ADOLContract.ADOLTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ADOLContract.ADOLTable.COLUMN_PROJECT_NAME + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_UID + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_UUID + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_FMID + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_SERIAL_NO + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_USERNAME + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_SYSDATE + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_STATUS + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_DEVICEID + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_DEVICETAGID + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_SYNCED + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_SYNCED_DATE + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_APPVERSION + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_DISTRICT_CODE + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_DISTRICT_NAME + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_TEHSIL_CODE + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_TEHSIL_NAME + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_LHW_CODE + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_LHW_NAME + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_KHANDAN_NUMBER + " TEXT,"
            + ADOLContract.ADOLTable.COLUMN_SA + " TEXT"
            + " );")

    const val SQL_CREATE_CHILD_INFO = ("CREATE TABLE "
            + ChildInformationContract.ChildInfoTable.TABLE_NAME + "("
            + ChildInformationContract.ChildInfoTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_UID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_UUID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_USERNAME + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SYSDATE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_STATUS + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_ISSELECTED + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_DEVICEID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SYNCED + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_APPVERSION + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_DCODE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_UCODE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_CLUSTER + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_HHNO + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SCB + " TEXT"
            + " );")

    const val SQL_CREATE_CHILD = ("CREATE TABLE "
            + ChildContract.ChildTable.TABLE_NAME + "("
            + ChildContract.ChildTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildContract.ChildTable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_UID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_UUID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_FMUID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_USERNAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYSDATE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_STATUS + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DEVICEID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYNCED + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_APPVERSION + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DCODE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_UCODE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_CLUSTER + " TEXT,"
            + ChildContract.ChildTable.COLUMN_HHNO + " TEXT,"
            + ChildContract.ChildTable.COLUMN_MOTHER_NAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_CHILD_NAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SERIAL + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SCS + " TEXT"
            + " );")

    const val SQL_CREATE_IMMUNIZATION = ("CREATE TABLE "
            + IMContract.IMTable.TABLE_NAME + "("
            + IMContract.IMTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + IMContract.IMTable.COLUMN_PROJECT_NAME + " TEXT,"
            + IMContract.IMTable.COLUMN_UID + " TEXT,"
            + IMContract.IMTable.COLUMN_UUID + " TEXT,"
            + IMContract.IMTable.COLUMN_FMUID + " TEXT,"
            + IMContract.IMTable.COLUMN_USERNAME + " TEXT,"
            + IMContract.IMTable.COLUMN_SYSDATE + " TEXT,"
            + IMContract.IMTable.COLUMN_STATUS + " TEXT,"
            + IMContract.IMTable.COLUMN_DEVICEID + " TEXT,"
            + IMContract.IMTable.COLUMN_DEVICETAGID + " TEXT,"
            + IMContract.IMTable.COLUMN_SYNCED + " TEXT,"
            + IMContract.IMTable.COLUMN_SYNCED_DATE + " TEXT,"
            + IMContract.IMTable.COLUMN_APPVERSION + " TEXT,"
            + IMContract.IMTable.COLUMN_DCODE + " TEXT,"
            + IMContract.IMTable.COLUMN_UCODE + " TEXT,"
            + IMContract.IMTable.COLUMN_CLUSTER + " TEXT,"
            + IMContract.IMTable.COLUMN_HHNO + " TEXT,"
            + IMContract.IMTable.COLUMN_MOTHER_NAME + " TEXT,"
            + IMContract.IMTable.COLUMN_CHILD_NAME + " TEXT,"
            + IMContract.IMTable.COLUMN_SERIAL + " TEXT,"
            + IMContract.IMTable.COLUMN_SIM + " TEXT"
            + " );")

    const val SQL_CREATE_MOBILE_HEALTH = ("CREATE TABLE "
            + MHContract.MHTable.TABLE_NAME + "("
            + MHContract.MHTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MHContract.MHTable.COLUMN_PROJECT_NAME + " TEXT,"
            + MHContract.MHTable.COLUMN_UID + " TEXT,"
            + MHContract.MHTable.COLUMN_USERNAME + " TEXT,"
            + MHContract.MHTable.COLUMN_SYSDATE + " TEXT,"
            + MHContract.MHTable.COLUMN_STATUS + " TEXT,"
            + MHContract.MHTable.COLUMN_DEVICEID + " TEXT,"
            + MHContract.MHTable.COLUMN_DEVICETAGID + " TEXT,"
            + MHContract.MHTable.COLUMN_SYNCED + " TEXT,"
            + MHContract.MHTable.COLUMN_SYNCED_DATE + " TEXT,"
            + MHContract.MHTable.COLUMN_APPVERSION + " TEXT,"
            + MHContract.MHTable.COLUMN_SERIAL + " TEXT,"
            + MHContract.MHTable.COLUMN_MH01 + " TEXT,"
            + MHContract.MHTable.COLUMN_MH02 + " TEXT,"
            + MHContract.MHTable.COLUMN_MH03 + " TEXT,"
            + MHContract.MHTable.COLUMN_MH04 + " TEXT,"
            + MHContract.MHTable.COLUMN_MH05 + " TEXT,"
            + MHContract.MHTable.COLUMN_MH06 + " TEXT,"
            + MHContract.MHTable.COLUMN_MH07 + " TEXT,"
            + MHContract.MHTable.COLUMN_SA + " TEXT"
            + " );")

    const val SQL_CREATE_USERS = ("CREATE TABLE " + Users.UsersTable.TABLE_NAME + "("
            + Users.UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Users.UsersTable.COLUMN_USERNAME + " TEXT,"
            + Users.UsersTable.COLUMN_PASSWORD + " TEXT,"
            + Users.UsersTable.COLUMN_FULLNAME + " TEXT,"
            + Users.UsersTable.COLUMN_DIST_ID + " TEXT"
            + " );")

    const val SQL_CREATE_DISTRICTS = ("CREATE TABLE " + Districts.TableDistricts.TABLE_NAME + "("
            + Districts.TableDistricts.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Districts.TableDistricts.COLUMN_DISTRICT_NAME + " TEXT,"
            + Districts.TableDistricts.COLUMN_DISTRICT_CODE + " TEXT"
            + " );")

    const val SQL_CREATE_UCS = ("CREATE TABLE " + UCs.TableUCs.TABLE_NAME + "("
            + UCs.TableUCs.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCs.TableUCs.COLUMN_UC_NAME + " TEXT,"
            + UCs.TableUCs.COLUMN_UC_CODE + " TEXT,"
            + UCs.TableUCs.COLUMN_DISTRICT_CODE + " TEXT"
            + " );")

    const val SQL_CREATE_CLUSTERS = ("CREATE TABLE " + Clusters.TableClusters.TABLE_NAME + "("
            + Clusters.TableClusters.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Clusters.TableClusters.COLUMN_DIST_CODE + " TEXT,"
            + Clusters.TableClusters.COLUMN_CLUSTER_NAME + " TEXT,"
            + Clusters.TableClusters.COLUMN_CLUSTER_CODE + " TEXT"
            + " );")

    const val SQL_CREATE_BL_RANDOM = ("CREATE TABLE " + BLRandom.TableRandom.TABLE_NAME + "("
            + BLRandom.TableRandom.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + BLRandom.TableRandom.COLUMN_CLUSTER_CODE + " TEXT,"
            + BLRandom.TableRandom.COLUMN_DIST_CODE + " TEXT,"
            + BLRandom.TableRandom.COLUMN_LUID + " TEXT,"
            + BLRandom.TableRandom.COLUMN_HH + " TEXT,"
            + BLRandom.TableRandom.COLUMN_STRUCTURE_NO + " TEXT,"
            + BLRandom.TableRandom.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + BLRandom.TableRandom.COLUMN_HH_HEAD + " TEXT,"
            + BLRandom.TableRandom.COLUMN_CONTACT + " TEXT,"
            + BLRandom.TableRandom.COLUMN_UPDATEDT + " TEXT,"
            + BLRandom.TableRandom.COLUMN_RANDOMDT + " TEXT,"
            + BLRandom.TableRandom.COLUMN_SNO_HH + " TEXT );")

    const val SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionApp.VersionAppTable.TABLE_NAME + " (" +
            VersionApp.VersionAppTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionApp.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionApp.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionApp.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");"

    const val SQL_CREATE_CAMP = ("CREATE TABLE " + Camps.TableCamp.TABLE_NAME + "("
            + Camps.TableCamp.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Camps.TableCamp.COLUMN_ID_CAMP + " TEXT,"
            + Camps.TableCamp.COLUMN_CAMP_NO + " TEXT,"
            + Camps.TableCamp.COLUMN_DIST_ID + " TEXT,"
            + Camps.TableCamp.COLUMN_DISTRICT + " TEXT,"
            + Camps.TableCamp.COLUMN_UC_CODE + " TEXT,"
            + Camps.TableCamp.COLUMN_UC_NAME + " TEXT,"
            + Camps.TableCamp.COLUMN_AREA_NAME + " TEXT,"
            + Camps.TableCamp.COLUMN_PLAN_DATE + " TEXT"
            + " );")

    const val SQL_CREATE_DOCTOR = ("CREATE TABLE " + Doctor.TableDoctor.TABLE_NAME + "("
            + Doctor.TableDoctor.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Doctor.TableDoctor.COLUMN_ID_CAMP + " TEXT,"
            + Doctor.TableDoctor.COLUMN_ID_DOCTOR + " TEXT,"
            + Doctor.TableDoctor.COLUMN_STAFF_NAME + " TEXT"
            + " );")

    const val SQL_CREATE_LHW = ("CREATE TABLE " + LHW.TableLhw.TABLE_NAME + "("
            + LHW.TableLhw.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + LHW.TableLhw.COLUMN_HF_CODE + " TEXT,"
            + LHW.TableLhw.COLUMN_LHW_CODE + " TEXT,"
            + LHW.TableLhw.COLUMN_LHW_NAME + " TEXT,"
            + LHW.TableLhw.COLUMN_TEHSIL_ID + " TEXT,"
            + LHW.TableLhw.COLUMN_UC_ID + " TEXT"
            + " );")

    const val SQL_CREATE_TEHSIL = ("CREATE TABLE " + Tehsil.TableTehsil.TABLE_NAME + "("
            + Tehsil.TableTehsil.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Tehsil.TableTehsil.COLUMN_DIST_ID + " TEXT,"
            + Tehsil.TableTehsil.COLUMN_TEHSIL + " TEXT,"
            + Tehsil.TableTehsil.COLUMN_TEHSIL_ID + " TEXT"
            + " );")

    const val SQL_CREATE_LHW_HF = ("CREATE TABLE " + HealthFacilities.TableHealthFacilities.TABLE_NAME + "("
            + HealthFacilities.TableHealthFacilities.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + HealthFacilities.TableHealthFacilities.COLUMN_HF_CODE + " TEXT,"
            + HealthFacilities.TableHealthFacilities.COLUMN_UC_ID + " TEXT,"
            + HealthFacilities.TableHealthFacilities.COLUMN_HF_NAME + " TEXT,"
            + HealthFacilities.TableHealthFacilities.COLUMN_TEHSIL_ID + " TEXT"
            + " );")

    const val SQL_CREATE_PROVINCE = ("CREATE TABLE " + Province.TableProvince.TABLE_NAME + "("
            + Province.TableProvince.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Province.TableProvince.COLUMN_PROVINCE + " TEXT,"
            + Province.TableProvince.COLUMN_PRO_ID + " TEXT"
            + " );")

    const val SQL_CREATE_RSD_HF = ("CREATE TABLE " + RsdHF.TablersdHF.TABLE_NAME + "("
            + RsdHF.TablersdHF.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + RsdHF.TablersdHF.COLUMN_PRO_ID + " TEXT,"
            + RsdHF.TablersdHF.COLUMN_DIST_ID + " TEXT,"
            + RsdHF.TablersdHF.COLUMN_TEHSIL_ID + " TEXT,"
            + RsdHF.TablersdHF.COLUMN_UC_ID + " TEXT,"
            + RsdHF.TablersdHF.COLUMN_HF_CODE + " TEXT"
            + " );")
}