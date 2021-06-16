package edu.aku.hassannaqvi.smk_ce.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import edu.aku.hassannaqvi.smk_ce.R;
import edu.aku.hassannaqvi.smk_ce.core.MainApp;
import edu.aku.hassannaqvi.smk_ce.models.FemaleMembersModel;
import edu.aku.hassannaqvi.smk_ce.ui.sections.SectionAdolActivity;
import edu.aku.hassannaqvi.smk_ce.ui.sections.SectionMWRAActivity;

public class FemaleMemberAdapter extends RecyclerView.Adapter<FemaleMemberAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    private final Context mContext;
    private List<FemaleMembersModel> femaleMembers;
    private int mExpandedPosition = -1;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param femaleMembers List<FemaleMembersModel> containing the data to populate views to be used by RecyclerView.
     */
    public FemaleMemberAdapter(Context mContext, List<FemaleMembersModel> femaleMembers) {
        this.femaleMembers = femaleMembers;
        this.mContext = mContext;
    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
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
        ImageView fmRow = viewHolder.fmRow;
        TextView addSec = viewHolder.addSec;
        TextView fMaritalStatus = viewHolder.fMatitalStatus;
        TextView secStatus = viewHolder.secStatus;
        View indicator = viewHolder.indicator;

        int mStatus = Integer.parseInt(femaleMember.getHh06());
        int age = Integer.parseInt(femaleMember.getHh05y());
        int mCate = 0;  // 1 = MWRA : 2 = AdolFeMale : 3 = AdolMale
        int gender = Integer.parseInt(femaleMember.getHh03());
        // Set MWRA
        if (mStatus != 2 && age >= MainApp.MIN_MWRA && age < MainApp.MAX_MWRA && gender == 2) {
            mCate = 1;
        }
        // Set Adol
        if (mStatus == 2 && age >= MainApp.MIN_ADOL && age < MainApp.MAX_ADOL) {
            if (gender == 2) {
                // Adol-Female
                mCate = 2;
            } else {
                // Adol-Male
                mCate = 3;
            }
        }
        boolean mPresent = femaleMember.getHh11().equals("2");
        Log.d(TAG, "onBindViewHolder: Memeber - " + femaleMember.getHh02() + " - " + femaleMember.getStatus());
        secStatus.setText(femaleMember.getStatus().equals("1") || mCate == 0 ? "Complete" : "Pending");
        secStatus.setTextColor(femaleMember.getStatus().equals("1") || mCate == 0 ? mContext.getResources().getColor(R.color.redDark) : mContext.getResources().getColor(R.color.green));
        addSec.setClickable((!femaleMember.getStatus().equals("1") || mCate == 0) && mPresent);
        if (femaleMember.getStatus().equals("1") || mCate == 0) {
            Toast.makeText(mContext, femaleMember.getStatus() + " | " + mCate +" | "+position, Toast.LENGTH_SHORT).show();
            fmRow.setImageResource(R.drawable.ic_check_circle_big);
        }

        fName.setText(femaleMember.getHh02());
        fAge.setText(femaleMember.getHh05y() + " | " + (femaleMember.getHh03().equals("1") ? "M" : "F"));
        indicator.setBackgroundColor(mCate == 1 ? mContext.getResources().getColor(R.color.redDark) : mCate == 2 ? mContext.getResources().getColor(R.color.colorPink) : mCate == 3 ? mContext.getResources().getColor(R.color.colorPrimary) : mContext.getResources().getColor(R.color.gray));
        String marStatus = "";
        switch (femaleMember.getHh06()) {
            case "1":
                marStatus = "Married";
                break;
            case "2":
                marStatus = "Unmarried";
                break;
            case "3":
                marStatus = "Widow";
                break;
            case "4":
                marStatus = "Divorced/Seperated";
                break;
            default:
                marStatus = "Value Unknown";
                break;
        }

        fMaritalStatus.setText(marStatus);
        addSec.setClickable(mCate != 0);
        addSec.setText(mCate == 1 ? "Add MWRA Information" : mCate > 1 ? "Add Adolescent Information" : "No Additional Information Required");


        AtomicBoolean expanded = new AtomicBoolean(femaleMember.isExpanded());
        // Set the visibility based on state
        subItem.setVisibility(expanded.get() ? View.VISIBLE : View.GONE);

        viewHolder.itemView.setOnClickListener(v -> {
            // Get the current state of the item
            if (!femaleMember.getStatus().equals("1")) {
                expanded.set(femaleMember.isExpanded());
                // Change the state
                femaleMember.setExpanded(!expanded.get());
                // Notify the adapter that item has changed
                notifyItemChanged(position);
            } else {
                Toast.makeText(mContext, "Form already filled for " + femaleMember.getHh02() + ".", Toast.LENGTH_SHORT).show();
            }
        });

        int finalMCate = mCate;
        viewHolder.addSec.setOnClickListener(v -> {
            // Get the current state of the item
            Intent intent = null;
            switch (finalMCate) {
                case 1: // MWRA
                    intent = new Intent(mContext, SectionMWRAActivity.class);
                    intent.putExtra("position", position);
                    break;
                case 2: // Adol Female
                case 3: // Adol Male
                    intent = new Intent(mContext, SectionAdolActivity.class);
                    intent.putExtra("position", position);
                    break;

            }
            MainApp.selectedFemale = position;
            if (intent != null) {
                mContext.startActivity(intent);
            } else {
                Toast.makeText(mContext, "No Additional Information Required!", Toast.LENGTH_SHORT).show();
            }
        });
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

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView fName;
        private final TextView fAge;
        private final TextView fMatitalStatus;
        private final TextView secStatus;
        private final TextView addSec;
        private final LinearLayout subItem;
        private final ImageView fmRow;
        private final View indicator;


        public ViewHolder(View v) {
            super(v);
            fName = v.findViewById(R.id.hh02);
            fAge = v.findViewById(R.id.hh05);
            fMatitalStatus = v.findViewById(R.id.hh06);
            secStatus = v.findViewById(R.id.secStatus);
            addSec = v.findViewById(R.id.add_section);
            subItem = v.findViewById(R.id.subitem);
            fmRow = v.findViewById(R.id.fmRow);
            indicator = v.findViewById(R.id.indicator);
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

            v.findViewById(R.id.add_section).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        public TextView getTextView() {
            return fName;
        }
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return femaleMembers.size();
    }


}
