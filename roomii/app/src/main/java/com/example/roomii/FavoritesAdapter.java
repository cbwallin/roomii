package com.example.roomii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
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
        View view = inflater.inflate(R.layout.layout_favorite_profiles, null);
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


    class ProfileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewShortDesc, textViewMatchPercent;
        ImageView imageView;

        public ProfileViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            imageView = itemView.findViewById(R.id.imageView);
            textViewMatchPercent = itemView.findViewById(R.id.textViewMatchPercent);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String val = "";
            switch(this.getLayoutPosition()) {
                case 0:
                    val = "adeeb";
                    break;
                case 1:
                    val = "cole";
                    break;
                case 2:
                    val = "kennedy";
                    break;
                case 3:
                    val = "zach";
                    break;
            }
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getIntent().putExtra("key", val);
            MessagesFragment nextFrag = new MessagesFragment();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
        }
    }
}
