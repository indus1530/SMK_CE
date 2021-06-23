package edu.aku.hassannaqvi.smk_ce.ui.sections;


/**
        guides.codepath.com
        /android5
        /using-the-recyclerview
*/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Comparator;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.adapters.FemaleMemberAdapter;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper;
import edu.aku.hassannaqvi.smk_ce.databinding.ActivityFemaleMembersBinding;
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel;
import edu.aku.hassannaqvi.smk_ce.ui.MainActivity;

import static edu.aku.hassannaqvi.smk_ce.core.MainApp.femalemembers;
import static edu.aku.hassannaqvi.smk_ce.core.MainApp.fm;
import static edu.aku.hassannaqvi.smk_ce.core.MainApp.fmCount;
import static edu.aku.hassannaqvi.smk_ce.core.MainApp.fmCountComplete;
import static edu.aku.hassannaqvi.smk_ce.core.MainApp.form;
import static edu.aku.hassannaqvi.smk_ce.core.MainApp.selectedFemale;

public class FemaleMembersActivity extends AppCompatActivity {

    private static final String TAG = "FemaleMembersActivity";
    ActivityFemaleMembersBinding bi;
    FemaleMemberAdapter fmAdapter;
    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> MemberInfoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        //Intent data = result.getData();
                        Intent data = result.getData();
                      /*  int age = Integer.parseInt(femalemembers.getHh05y());
                        boolean isFemale = femalemembers.getHh03().equals("2");
                        boolean notMarried = femalemembers.getHh06().equals("2");
                        if (
                            // Adolescent: Male + Female - 10 to 19
                                (age >= 10 && age < 20 && notMarried)
                                        ||
                                        // MWRA: Married females between 14 to 49
                                        (age >= 14 && age < 50 && !notMarried && isFemale )

                        ) {*/
                        MainApp.fm.add(femalemembers);

                        MainApp.fmCount++;

                        fmAdapter.notifyItemInserted(MainApp.fm.size() - 1);
                      //  Collections.sort(MainApp.fm, new SortByStatus());
                        //fmAdapter.notifyDataSetChanged();

                        //        }

                        checkCompleteFm(1);
                    }
                    if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Toast.makeText(FemaleMembersActivity.this, "No family member added.", Toast.LENGTH_SHORT).show();
                    }

                }
            });


    private void checkCompleteFm(int n) {
        int compCount = 0;
        for(FemaleMembersModel fm : fm){
            compCount += fm.getStatus().equals("1") ? 1 : 0;
            Log.d(TAG, "checkCompleteFm: fmName("+n+"): "+fm.getHh02() +" | Status: "+fm.getStatus());
        }
        fmCountComplete = compCount;
        bi.btnContinue.setVisibility(compCount == fmCount? View.VISIBLE:View.GONE);
        bi.btnContinue.setEnabled(compCount == fmCount && !MainApp.form.getIStatus().equals("1"));
    }


    private DatabaseHelper db;

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity Resumed!", Toast.LENGTH_SHORT).show();

        MainApp.adol = null;
        MainApp.mwra = null;
        if(MainApp.fm.size()>0) {
            //MainApp.fm.get(Integer.parseInt(String.valueOf(MainApp.selectedFemale))).setStatus("1");
            fmAdapter.notifyItemChanged(Integer.parseInt(String.valueOf(MainApp.selectedFemale)));
        }
        checkCompleteFm(2);
        bi.totalmember.setText(fm.size()+ " members added");
        bi.completedmember.setText(fmCountComplete+ " members completed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_female_members);
        bi.setCallback(this);

      /*  Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Female Members Roster");*/
        db = MainApp.appInfo.dbHelper;

        RecyclerView rvFemaleMembers = findViewById(R.id.rvFemaleMembers);


        String lhwcode = form.getLhwCode();
        String kno = form.getKhandanNumber();

        MainApp.fm = db.getFamilyMembersBYUID(lhwcode, kno);
        MainApp.fmCount = MainApp.fm.size();
        //Collections.sort(MainApp.fm, new SortByStatus());
        fmAdapter = new FemaleMemberAdapter(this, MainApp.fm);
        rvFemaleMembers.setAdapter(fmAdapter);
        rvFemaleMembers.setLayoutManager(new LinearLayoutManager(this));
        //TODO: Implement startActivityForResult()


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //TODO: Implement startActivityForResult()
                addFemale();
            }
        });


    }

    public void addFemale() {
        Intent intent = new Intent(this, SectionMemberInfoActivity.class);
     //   finish();
        MemberInfoLauncher.launch(intent);
    }

    public void BtnContinue(View view) {

        finish();
        startActivity(new Intent(this, SectionVHCActivity.class));
        /*   } else {
               Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
           }*/
    }

    public void BtnEnd(View view) {

        finish();
        startActivity(new Intent(this, MainActivity.class));
        /*   } else {
               Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
           }*/
    }

    public class SortByStatus implements Comparator {

        public int compare(Object o1, Object o2) {
            FemaleMembersModel p1 = (FemaleMembersModel) o1;
            FemaleMembersModel p2 = (FemaleMembersModel) o2;
            if(p2.getStatus().equals("")) p2.setStatus("0");
            if(p1.getStatus().equals("")) p1.setStatus("0");
            // return -1, 0, 1 to determine less than, equal to or greater than
            //  return (Integer.parseInt(p1.getStatus()) > Integer.parseInt(p2.getStatus()) ? 1 : (Integer.parseInt(p1.getStatus()) == Integer.parseInt(p2.getStatus()) ? 0 : -1));
            // **or** the previous return statement can be simplified to:
            return Integer.parseInt(p1.getStatus()) - Integer.parseInt(p2.getStatus());
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
        //Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                MainApp.fm.get(selectedFemale).setExpanded(false);
                checkCompleteFm(3);
                fmAdapter.notifyItemChanged(selectedFemale);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
                Toast.makeText(this, "Information for "+MainApp.fm.get(selectedFemale).getHh02()+" was not saved.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}