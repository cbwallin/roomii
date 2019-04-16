package com.example.roomii;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MessagesFragment extends Fragment {

    private MessagesArrayAdapter adapter;
    private ListView lv;
    private EditText editText1;
    private Button btnSend;

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        getContext().getTheme().applyStyle(R.style.AppTheme_NoActionBar, true);
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        lv = view.findViewById(R.id.listView1);

        adapter = new MessagesArrayAdapter(getActivity(), R.layout.listitem_message);
        lv.setAdapter(adapter);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);

        String val = getActivity().getIntent().getExtras().getString("key");
        if (val == "cole") {
            addItems("hello ?");
            addSends("hey! what's up?");
            addItems("not much just looking for roommates");
        } else if (val == "adeeb") {
            addSends("hey");
            addItems("hey");
            addSends("you need a roommate?");
            addItems("yea I've been looking!");
        } else if (val == "kennedy") {
            addItems("hey");
            addItems("hey");
            addSends("hello");
            addItems("hey what's up");
        } else {
            addSends("hey hey");
            addSends("i'm looking for a clean roommate!");
            addSends("would you consider yourself a clean person?");
            addItems("yeah I think so");
        }

        editText1 = (EditText)view.findViewById(R.id.chatText);
        editText1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if (editText1.getText().toString().trim().length() != 0) {
                        if (editText1.getText().toString().charAt(0) == '\n') {
                            String msg = editText1.getText().toString().substring(1);
                            editText1.setText(msg);
                        }
                        receiveMessage();
                        editText1.getText().clear();
                        return true;
                    }
                    editText1.getText().clear();
                }
                return false;
            }
        });

        btnSend = (Button)view.findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().trim().length() != 0) {
                    if (editText1.getText().toString().charAt(0) == '\n') {
                        String msg = editText1.getText().toString().substring(1);
                        editText1.setText(msg);
                    }
                    receiveMessage();
                    editText1.setText("");
                }
            }
        });

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getFragmentManager().popBackStackImmediate();
                /*MessageListFragment nextFrag = new MessageListFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();*/
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void receiveMessage(){
        String msg = editText1.getText().toString();
        addSends(msg);
    }


    private void addItems(String msg) {
        adapter.add(new Message(true, msg));
    }
    private void addSends(String msg) { adapter.add(new Message(false, msg)); }

}

