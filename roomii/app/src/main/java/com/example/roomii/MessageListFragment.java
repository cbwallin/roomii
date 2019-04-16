package com.example.roomii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MessageListFragment extends Fragment {

    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);
        lv = view.findViewById(R.id.listView2);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        int[] images = new int[]{
                R.drawable.adeeb,
                R.drawable.cole,
                R.drawable.kennedy,
                R.drawable.zach
        };

        String[] names = new String[]{
                "Adeeb Ali",
                "Cole Wallin",
                "Kennedy Mindermann",
                "Zach Trosvig"
        };

        String[] texts = new String[]{
                "yea I've been looking",
                "not much just looking for...",
                "fine",
                "yeah I think so!"
        };

        String[] dates = new String[]{
                "4/11/19",
                "4/10/19",
                "4/05/19",
                "4/04/19"
        };

        for (int i = 0; i < 4; i++ ) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("img", Integer.toString(images[i]));
            hm.put("name", names[i]);
            hm.put("txt", texts[i]);
            hm.put("date", dates[i]);
            aList.add(hm);

        }

        String[] from = { "img", "name", "txt", "date" };

        int[] to = { R.id.messages_profile_pic, R.id.messages_name, R.id.messages_txt, R.id.messages_date };

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), aList, R.layout.message_listview_layout, from, to);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                TextView msg = arg1.findViewById(R.id.messages_name);
                String message = msg.getText().toString();

                if (message == "Cole Wallin") {
                    getActivity().getIntent().putExtra("key", "cole");
                } else if (message == "Adeeb Ali") {
                    getActivity().getIntent().putExtra("key", "adeeb");
                } else if (message == "Kennedy Mindermann") {
                    getActivity().getIntent().putExtra("key", "kennedy");
                } else {
                    getActivity().getIntent().putExtra("key", "zach");
                }

                MessagesFragment nextFrag = new MessagesFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        return  view;
    }
}
