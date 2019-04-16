package com.example.roomii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ExploreProfileAdapter extends RecyclerView.Adapter<ExploreProfileAdapter.ProfileViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Profile> profileList;

    //getting the context and product list with constructor
    public ExploreProfileAdapter(Context mCtx, List<Profile> productList) {
        this.mCtx = mCtx;
        this.profileList = productList;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_explore_profiles, null);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        //getting the product of the specified position
        Profile profile = profileList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(profile.getName());
        holder.textViewShortDesc.setText(profile.getShortdesc());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(profile.getImage()));
        holder.textViewMatchPercent.setText(Integer.toString(profile.getMatchPercent()) + "% match");
        holder.textViewAge.setText("Age: " + Integer.toString(profile.getAge()));
        holder.textViewHousing.setText("Preferred housing: " + profile.getHousingPref());
        holder.textViewReligion.setText("Religious Affiliation: " + profile.getReligiousAff());
        holder.textViewAgePref.setText("Desired Age Range: " + profile.getAgePref());

    }


    @Override
    public int getItemCount() {
        return profileList.size();
    }


    class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewMatchPercent, textViewAge, textViewHousing, textViewAgePref, textViewReligion;
        ImageView imageView;

        public ProfileViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);
            textViewMatchPercent = itemView.findViewById(R.id.textViewMatchPercent);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewHousing = itemView.findViewById(R.id.textViewHousing);
            textViewAgePref= itemView.findViewById(R.id.textViewAgePref);
            textViewReligion = itemView.findViewById(R.id.textViewReligion);

        }
    }
}
