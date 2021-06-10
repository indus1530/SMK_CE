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
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.adapters.FemaleMemberAdapter;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper;

import static edu.aku.hassannaqvi.smk_ce.core.MainApp.femalemembers;
import static edu.aku.hassannaqvi.smk_ce.core.MainApp.form;

public class FemaleMembersActivity extends AppCompatActivity {

    FemaleMemberAdapter fmAdapter;
    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        //Intent data = result.getData();
                        Intent data = result.getData();

                        MainApp.fm.add(femalemembers);
                        MainApp.fmCount++;
                        fmAdapter.notifyItemInserted(MainApp.fm.size() - 1);
                    }
                    if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Toast.makeText(FemaleMembersActivity.this, "No family member added.", Toast.LENGTH_SHORT).show();
                    }

                }
            });


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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_members);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = MainApp.appInfo.dbHelper;

        RecyclerView rvFemaleMembers = (RecyclerView) findViewById(R.id.rvFemaleMembers);

        String lhwcode = form.getLhwCode();
        String kno = form.getKhandanNumber();

        MainApp.fm = db.getFamilyMembersBYUID(lhwcode, kno);
        MainApp.fmCount = MainApp.fm.size();
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

        someActivityResultLauncher.launch(intent);
    }
}











