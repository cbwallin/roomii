package com.example.roomii;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessagesArrayAdapter extends ArrayAdapter<Message> {

    private TextView in_comment;
    private List<Message> messages = new ArrayList<Message>();
    private LinearLayout wrapper;

    public MessagesArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Message object) {
        messages.add(object);
        super.add(object);
    }

    public int getCount() {
        return this.messages.size();
    }

    public Message getItem(int index) {
        return this.messages.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listitem_message, parent, false);
        }

        wrapper = (LinearLayout) row.findViewById(R.id.wrapper);

        Message message = getItem(position);

        in_comment = (TextView) row.findViewById(R.id.in_comment);

        in_comment.setText(message.comment);
        in_comment.setTextColor(message.left_side ? in_comment.getResources().getColor(R.color.black) : in_comment.getResources().getColor(R.color.white));
        in_comment.setBackgroundResource(message.left_side ? R.drawable.speech_bubble : R.drawable.speech_bubble_out);

        wrapper.setGravity(message.left_side ? Gravity.LEFT : Gravity.RIGHT);

        return row;
    }
}
