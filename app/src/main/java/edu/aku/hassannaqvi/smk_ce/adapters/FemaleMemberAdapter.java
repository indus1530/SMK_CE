package edu.aku.hassannaqvi.smk_ce.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel;

public class FemaleMemberAdapter extends RecyclerView.Adapter<FemaleMemberAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private List<FemaleMembersModel> femaleMembers;
    private int mExpandedPosition = -1;

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
        private TextView addSec;
        private LinearLayout subItem;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d(TAG, "Element " + getBindingAdapterPosition() + " clicked.");
                  /*  if (subItem.getVisibility()==View.VISIBLE)
                        subItem.setVisibility(View.GONE);
                    else
                        subItem.setVisibility(View.VISIBLE);*/
                }
            });
            fName=  v.findViewById(R.id.hh02);
            fAge =  v.findViewById(R.id.hh05);
            fMatitalStatus = v.findViewById(R.id.hh06);
            addSec =  v.findViewById(R.id.add_section);
            subItem =  v.findViewById(R.id.subitem);
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
        LinearLayout subItem = viewHolder.subItem;
        TextView fMaritalStatus = viewHolder.fMatitalStatus;
        fName.setText(femaleMember.getHh02());
        fAge.setText(femaleMember.getHh05y());

        String mStatus = "";
        switch(femaleMember.getHh06()){
            case "1":
                mStatus = "Marrid";
                break;
            case "2":
                mStatus = "Unmarried";
                break;
            case "3":
                mStatus = "Widow";
                break;
            case "4":
                mStatus = "Divorced/Seperated";
                break;
            default:
                mStatus = "Value Unknown";
                break;
        }

        fMaritalStatus.setText(mStatus);
        AtomicBoolean expanded = new AtomicBoolean(femaleMember.isExpanded());
        // Set the visibility based on state
        subItem.setVisibility(expanded.get() ? View.VISIBLE : View.GONE);

        viewHolder.itemView.setOnClickListener(v -> {
            // Get the current state of the item
             expanded.set(femaleMember.isExpanded());
            // Change the state
            femaleMember.setExpanded(!expanded.get());
            // Notify the adapter that item has changed
            notifyItemChanged(position);
        });
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return femaleMembers.size();
    }
}