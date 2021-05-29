package edu.aku.hassannaqvi.smk_ce.ui.sections;


/**
        guides.codepath.com
        /android5
        /using-the-recyclerview
*/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

import java.util.List;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.adapters.FemaleMemberAdapter;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper;
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel;

import static edu.aku.hassannaqvi.smk_ce.core.MainApp.femalemembers;

public class FemaleMembersActivity extends AppCompatActivity {

    List<FemaleMembersModel> fm;
    FemaleMemberAdapter fmAdapter;
    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        fm.add(femalemembers);
                        fmAdapter.notifyItemInserted(fm.size() - 1);
                    }
                }
            });
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_members);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = MainApp.appInfo.dbHelper;

        RecyclerView rvFemaleMembers = (RecyclerView) findViewById(R.id.rvFemaleMembers);

        fm = null;

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
        Intent intent = new Intent(this, Section02Activity.class);
        someActivityResultLauncher.launch(intent);
    }
}











