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
    List<Profile> profileList;

    // THe recycler view
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View rootView =  inflater.inflate(R.layout.fragment_explore, null);
        //getting a reference to the recycler view
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        profileList = new ArrayList<>();


        //adding some items to our list
        profileList.add(
                new Profile(
                        "Amazing Amanda",
                        R.drawable.amanda,
                        "I cook banana break every day to make sure all my roomiis are never hungry and always happy!",
                        99,
                        21,
                        "House",
                        "Catholic",
                        "18-24"));
        profileList.add(
                new Profile(
                        "Adeeb Ali",
                        R.drawable.adeeb,
                        "It's a rare night that I'm not up til 4am watching Twitch streams!",
                        77,
                        22,
                        "Apartment",
                        "Muslim",
                        "21-23"));
        profileList.add(
                new Profile(
                        "Cole Wallin",
                        R.drawable.cole,
                        "I'm a quiet person who likes to study all the time and go to bed early!",
                        90,
                        23,
                        "Apartment",
                        "Pastafarian",
                        "30+"));
        profileList.add(
                new Profile(
                        "Kennedy Mindermann",
                        R.drawable.kennedy,
                        "I'm a great roommii as long as I've had my coffee first!",
                        64,
                        22,
                        "Apartment",
                        "Catholic",
                        "22-26"));
        profileList.add(
                new Profile(
                        "Zachary Trosvig",
                        R.drawable.zach,
                        "I'm a studious person but I am known to occasionally blast music out my front windows!",
                        85,
                        22,
                        "Apartment",
                        "Buddhist",
                        "18-24"));
        profileList.add(
                new Profile(
                        "Let Down Larry",
                        R.drawable.larry,
                        "Seeking roomii willing to share a studio with me and my mom.",
                        12,
                        20,
                        "House",
                        "Atheist",
                        "18-24"));


        //creating recyclerview adapter
        ExploreProfileAdapter adapter = new ExploreProfileAdapter(getActivity(), profileList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return rootView;

    }
}
