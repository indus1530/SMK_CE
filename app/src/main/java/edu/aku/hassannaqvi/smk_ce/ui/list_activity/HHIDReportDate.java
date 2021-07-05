package edu.aku.hassannaqvi.smk_ce.ui.list_activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.adapters.FormsAdapter;
import edu.aku.hassannaqvi.smk_ce.adapters.HHIDAdapter;
import edu.aku.hassannaqvi.smk_ce.adapters.LHWNamesAdapter;
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper;
import edu.aku.hassannaqvi.smk_ce.models.Form;
import edu.aku.hassannaqvi.smk_ce.models.HHIDModel;
import edu.aku.hassannaqvi.smk_ce.models.LHW;


public class HHIDReportDate extends AppCompatActivity {
    DatabaseHelper db;
    Collection<HHIDModel> hhidModels;
    String sysdateToday = new SimpleDateFormat("dd-MM-yy").format(new Date());
    AutoCompleteTextView dtFilter;
    TextView noresult;
    ArrayList<String> LHWList;
    ArrayList<String> LHWcodes;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter HHIDAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Collection<LHW> lhw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hhid_report_date);
        recyclerView = findViewById(R.id.fc_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dtFilter = findViewById(R.id.dtFilter);
        noresult = findViewById(R.id.noresult);
        db = new DatabaseHelper(this);
        hhidModels = db.getHHIDByLHW("");
        // specify an adapter (see also next example)
        HHIDAdapter = new HHIDAdapter((List<HHIDModel>) hhidModels, this);
        recyclerView.setAdapter(HHIDAdapter);

        lhw = db.getAllLHW();
        LHWList = new ArrayList<String>();
        LHWcodes = new ArrayList<String>();
        for (LHW lhw : lhw
        ) {
            LHWList.add(lhw.getLhw_Name() + " (" + lhw.getLhw_Code() + ")");
            LHWcodes.add(lhw.getLhw_Code());
            // Log.d(TAG, "onCreate: "+lhw.getLhw_Name()+ " ("+lhw.getLhw_Code()+")");
        }

//initilaze this array with your data
        LHWNamesAdapter adapter = new LHWNamesAdapter(this, android.R.layout.simple_dropdown_item_1line, android.R.id.text1, LHWList);
        dtFilter.setAdapter(adapter);
        // specify an adapter (see also next example)

    }

    public void filterForms(View view) {
        if (!dtFilter.getText().toString().equals("")) {
            hhidModels = db.getHHIDByLHW(LHWcodes.get(LHWList.indexOf(dtFilter.getText().toString())));
        } else {
            hhidModels = db.getHHIDByLHW("");
        }
        if (hhidModels.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            noresult.setVisibility(View.GONE);

            Toast.makeText(this, "updated: " + hhidModels.size(), Toast.LENGTH_SHORT).show();
            HHIDAdapter= new HHIDAdapter((List<HHIDModel>) hhidModels, this);
            HHIDAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(HHIDAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            noresult.setVisibility(View.VISIBLE);
        }

    }
}