package edu.aku.hassannaqvi.smk_ce.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel;

public class FemaleMemberAdapter extends RecyclerView.Adapter<FemaleMemberAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private List<FemaleMembersModel> femaleMembers;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param femaleMembers List<FemaleMembersModel> containing the data to populate views to be used by RecyclerView.
     */
    public FemaleMemberAdapter(List<FemaleMembersModel> femaleMembers) {
        this.femaleMembers = femaleMembers;
    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fName;
        private TextView fAge;
        private TextView fMatitalStatus;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getBindingAdapterPosition() + " clicked.");
                }
            });
            fName= (TextView) v.findViewById(R.id.hh02);
            fAge = (TextView) v.findViewById(R.id.hh05);
            fMatitalStatus = (TextView) v.findViewById(R.id.hh06);
        }

        public TextView getTextView() {
            return fName;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)




    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public FemaleMemberAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
       // Context context = parent.getContext();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.female_member_row, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
FemaleMembersModel femaleMember = this.femaleMembers.get(position);        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        TextView fName = viewHolder.fName;
        TextView fAge = viewHolder.fAge;
        TextView fMaritalStatus = viewHolder.fMatitalStatus;
        fName.setText(femaleMember.getHh02());
        fAge.setText(femaleMember.getHh05y());
        fMaritalStatus.setText(femaleMember.getHh06());



    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return femaleMembers.size();
    }
}
