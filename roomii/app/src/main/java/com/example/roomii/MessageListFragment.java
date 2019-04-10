package com.example.roomii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class MessageListFragment extends Fragment {

    private MessagesArrayAdapter adapter;
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);
        lv = view.findViewById(R.id.listView2);

        adapter = new MessagesArrayAdapter(getActivity(), R.layout.listitem_message);
        lv.setAdapter(adapter);

        addItems("Potential Roommate");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                MessagesFragment nextFrag= new MessagesFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });


        return  view;
    }




    private void receiveMessage(){
        //new ChatDAO().receiveMessage("");
    }


    /** recebe msg */
    private void addItems(String msg) {
        adapter.add(new OneComment(true, msg));
    }

}
