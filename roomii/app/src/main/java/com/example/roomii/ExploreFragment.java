package com.example.roomii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExploreFragment extends Fragment {

    //a list to store all the products
    List<ExploreProfile> profileList;

    // THe recycler view
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View rootView =  inflater.inflate(R.layout.fragment_explore, null);
        //getting a reference to the recycler view
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        profileList = new ArrayList<>();


        //adding some items to our list
        profileList.add(
                new ExploreProfile(
                        "cole",
                        R.drawable.face,
                        "13.3 inch, Silver, 1.35 kg"));

        profileList.add(
                new ExploreProfile(
                        "Troz",
                        R.drawable.face,
                        "13.3 inch, Silver, 1.35 kg"));

        //creating recyclerview adapter
        ExploreProfileAdapter adapter = new ExploreProfileAdapter(getActivity(), profileList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return rootView;

    }
}
