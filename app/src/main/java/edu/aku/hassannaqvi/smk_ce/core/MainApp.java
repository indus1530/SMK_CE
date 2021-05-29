package edu.aku.hassannaqvi.smk_ce.core;

import android.app.Application;
import android.content.SharedPreferences;
import android.view.View;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.json.JSONArray;

import java.io.File;
import java.util.List;
import java.util.Random;

import edu.aku.hassannaqvi.smk_ce.models.ADOLModel;
import edu.aku.hassannaqvi.smk_ce.models.Child;
import edu.aku.hassannaqvi.smk_ce.models.ChildInformation;
import edu.aku.hassannaqvi.smk_ce.models.Form;
import edu.aku.hassannaqvi.smk_ce.models.HHIDModel;
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel;
import edu.aku.hassannaqvi.smk_ce.models.Immunization;
import edu.aku.hassannaqvi.smk_ce.models.LHWModel;
import edu.aku.hassannaqvi.smk_ce.models.MWRAModel;
import edu.aku.hassannaqvi.smk_ce.models.MobileHealth;
import edu.aku.hassannaqvi.smk_ce.models.Users;

public class MainApp extends Application {

    public static final String PROJECT_NAME = "SMK HH Community Engagement";
    public static final String DIST_ID = null;
    public static final String SYNC_LOGIN = "sync_login";
    //public static final String _IP = "https://vcoe1.aku.edu";// .LIVE server
    public static final String _IP = "http://f38158";// .TEST server
    //public static final String _IP = "http://43.245.131.159:8080";// .TEST server
    public static final String _HOST_URL = MainApp._IP + "/naunehal/api/";// .TEST server;
    public static final String _SERVER_URL = "sync.php";
    public static final String _SERVER_GET_URL = "getData.php";
    public static final String _PHOTO_UPLOAD_URL = _HOST_URL + "uploads.php";
    public static final String _UPDATE_URL = MainApp._IP + "/naunehal/app/mhs/";
    public static File sdDir;
    public static String[] downloadData;
    public static Form form;
    public static LHWModel lhw;
    public static HHIDModel hhid;
    public static FemaleMembersModel femalemembers;
    public static MWRAModel mwra;
    public static ADOLModel adol;
    public static Child child;
    public static Immunization immunization;
    public static MobileHealth mobileHealth;
    public static ChildInformation childInformation;
    public static String DeviceURL = "devices.php";
    public static AppInfo appInfo;
    public static Users user;
    public static Boolean admin = false;
    public static List<JSONArray> uploadData;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    public static int[] randHHNo;
    public static int randHHNoIndex;
    String[] marker = new String[10];


    public static void hideSystemUI(View decorView) {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Initiate DateTime
        AndroidThreeTen.init(this);
        //Initializ App info
        appInfo = new AppInfo(this);

    }

    public static void genBlockRand() {

        int total = 123;
        Long blockSize = Long.valueOf(total/10);
        int randQuat = new Random().nextInt((int) (blockSize-1))+1;

        System.out.println("Q: "+blockSize+"\n");
        int c =0;
        for(int i=1;i<total;i+=blockSize){
            c++;
            Long high =  (blockSize *c);
            int low = i;
            System.out.println(c+" - "+high+"-"+low+"\r");
            System.out.println(c+" -> "+(new Random().nextInt((int) (high-low))+low)+"\n");

        }
    }

    public static void genSysRand() {


        int total = 123;
        Long blockSize = Long.valueOf(total/10);
        int randQuat = new Random().nextInt((int) (blockSize-1))+1;


        for(int i=1;i<=10;i++){


            System.out.println(i+" -> "+randQuat+"\n");
            //    System.out.println(c+" -> "+(new Random().nextInt((int) (high-low))+low)+"\n");
            randQuat+=blockSize;

        }

    }
    public static int[] genNum3(int gn){
        int total = gn;
        System.out.println(" Total: "+total+"\n");


        Long blockSize = Long.valueOf(total/10);
        System.out.println(" blockSize: "+blockSize+"\n");

        int randQuat = new Random().nextInt((int) (blockSize-1))+1;
        System.out.println(" randQuat: "+randQuat+"\n");

        int[] hhno = new int[10];
        for(int i=0;i<10;i++){
            hhno[i] =randQuat;


            System.out.println(i+" -> "+randQuat+"\n");
            //    System.out.println(c+" -> "+(new Random().nextInt((int) (high-low))+low)+"\n");
            randQuat+=blockSize;

        }
        return hhno;
    }
    public static void genRandNum(int gn){
        int total = gn;
        System.out.println(" Total: "+total+"\n");


        Double blockSize = Double.valueOf(total)/10.0;
        System.out.println(" blockSize: "+blockSize+"\n");

        int randQuat = new Random().nextInt((int) (blockSize-1))+1;
        System.out.println(" randQuat: "+randQuat+"\n");

        int[] hhno = new int[10];
        int c =0;
        for(int i=1;c<10;i+=blockSize){
            c++;
            int high =  (int) (blockSize *c);
            int low = i;
            hhno[c - 1] = new Random().nextInt(high - low) + low;
            System.out.println(c + " - " + low + "-" + high + "\r");
            System.out.println(c+" -> "+hhno[c-1]+"\n");

        }
        MainApp.randHHNo = new int[10];
        MainApp.randHHNo =  hhno;
    }

}
