package edu.aku.hassannaqvi.smk_ce.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;
import edu.aku.hassannaqvi.smk_ce.database.DatabaseHelper;
import edu.aku.hassannaqvi.smk_ce.models.Form;
import edu.aku.hassannaqvi.smk_ce.models.HHIDModel;
import edu.aku.hassannaqvi.smk_ce.ui.FemaleMembersActivity;


/**
 * Created by hassan.naqvi on 8/1/2016.
 */
public class HHIDAdapter extends RecyclerView.Adapter<HHIDAdapter.ViewHolder> {
    Context c;
    DatabaseHelper db;
    private List<HHIDModel> hHIDModel = Collections.emptyList();

    // Provide a suitable constructor (depends on the kind of dataset)
    public HHIDAdapter(List<HHIDModel> hHIDModel, Context c) {
        this.hHIDModel = hHIDModel;
        this.c = c;
  //      Log.d("TAG:count", String.valueOf(getItemCount()));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pendingform_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        db = new DatabaseHelper(c);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

/*        int childCount = 0;
        childCount = db.getChildrenByUUID(fc.get(position).getUid());
        int photoChild = 0;
        photoChild = db.getChildrenPhotoCheck(fc.get(position).getUid());
        int cardChild = 0;
        cardChild = db.getChildrenCardCheck(fc.get(position).getUid());*/

       /* Collection<HHIDModel> hhids = new ArrayList<>();
        hhids = db.getHHIDByLHW(hHIDModel.get(position).getLhwCode());*/


        Form forms = db.getFormByKhandanNumber(hHIDModel.get(position).getLhwCode(), hHIDModel.get(position).getKhandanNumber());

/*        int mStatus = 0;
        for (Form form : forms
             ) {
            mStatus += form.getIStatus().equals("1")?1:0;

        }
*/
        String iStatus;
        
        int iColor = 0;
       /*switch (forms.getIStatus()) {
            case "1":
                holder.status.setBackgroundColor(c.getResources().getColor(R.color.colorAccent));
                holder.status.setImageResource(R.drawable.male);
                break;
            case "2":
                holder.status.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));
                holder.status.setImageResource(R.drawable.female);
                break;
        }*/
        switch (forms.getIStatus()) {
            case "1":
                iStatus = "Complete";
                iColor = Color.GREEN;
                break;
            case "2":
                iStatus = "No Respondent";
                iColor = Color.RED;
                break;
            case "3":
                iStatus = "Memebers Absent";
                iColor = Color.RED;
                break;
            case "4":
                iStatus = "Refused";
                iColor = Color.RED;
                break;
            case "5":
                iStatus = "Empty";
                iColor = Color.RED;
                break;
            case "6":
                iStatus = "Not Found";
                iColor = Color.RED;
                break;
            case "96":
                iStatus = "Other Reason";
                iColor = Color.RED;
                break;
            default:
                iStatus = "Open LHW";
                iColor = Color.RED;
                break;
        

        }

        holder.cluster.setText(hHIDModel.get(position).getKhandanNumber() );
        holder.father.setText(" ( " + hHIDModel.get(position).getHhi03() + " )");
        holder.hhno.setText(hHIDModel.get(position).getHfName() +" | " + hHIDModel.get(position).getLhwName());
        holder.istatus.setText(iStatus);
       // Log.d("TAG", "onBindViewHolder: gender " + fc.get(position).getMh010());
        holder.sysdate.setText(hHIDModel.get(position).getSysDate()/*+"\t\t-\t\tMember: "+mStatus+"/"+hhids.size()*/);
        holder.status.setBackgroundColor(iColor);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                MainApp.HHIDModel = new HHIDModel();
                MainApp.HHIDModel = db.getHHIDModelByKhandanNumber(hHIDModel.get(position).getHHIDModelCode(), hHIDModel.get(position).getKhandanNumber());

                Intent intent = null;
                intent = new Intent(c, FemaleMembersActivity.class);

                ((Activity) c).startActivity(intent);*/

            }
        });
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return hHIDModel.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rv;
        public TextView sysdate;
        public TextView cluster;
        public TextView hhno;
        public TextView istatus;
        public ImageView status;
        public TextView father;
        public View indicator;
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);
//            rv = v.findViewById(R.id.HHIDModelsList);
            sysdate = v.findViewById(R.id.sysdate);
            cluster = v.findViewById(R.id.cluster);
            hhno = v.findViewById(R.id.hhno);
            istatus = v.findViewById(R.id.istatus);
            status = v.findViewById(R.id.status);
            father = v.findViewById(R.id.fathername);
            indicator = v.findViewById(R.id.indicator);

        }


    }


}