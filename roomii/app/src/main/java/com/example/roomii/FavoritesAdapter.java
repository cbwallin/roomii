package com.example.roomii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ProfileViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Profile> profileList;

    //getting the context and product list with constructor
    public FavoritesAdapter(Context mCtx, List<Profile> productList) {
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

    }


    @Override
    public int getItemCount() {
        return profileList.size();
    }


    class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewMatchPercent;
        ImageView imageView;

        public ProfileViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);
            textViewMatchPercent = itemView.findViewById(R.id.textViewMatchPercent);
        }
    }
}
