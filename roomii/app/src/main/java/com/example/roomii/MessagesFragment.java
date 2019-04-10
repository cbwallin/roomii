package com.example.roomii;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class MessagesFragment extends Fragment {

    private MessagesArrayAdapter adapter;
    private ListView lv;
    private EditText editText1;
    private Button btnSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        lv = view.findViewById(R.id.listView1);

        adapter = new MessagesArrayAdapter(getActivity(), R.layout.listitem_message);
        lv.setAdapter(adapter);

        editText1 = (EditText)view.findViewById(R.id.chatText);
        editText1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    //adapter.add(new OneComment(false, editText1.getText().toString()));
                    receiveMessage();
                    editText1.setText("");
                    return true;
                }
                return false;
            }
        });

        btnSend = (Button)view.findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adapter.add(new OneComment(false, editText1.getText().toString()));
                receiveMessage();
                editText1.setText("");
            }
        });

        return  view;
    }




    private void receiveMessage(){
        String msg = editText1.getText().toString();
        Log.d("MESSAGE", msg);
        addItems(msg);
        //new ChatDAO().receiveMessage("");
    }


    /** recebe msg */
    private void addItems(String msg) {
        adapter.add(new OneComment(true, msg));
    }

}

