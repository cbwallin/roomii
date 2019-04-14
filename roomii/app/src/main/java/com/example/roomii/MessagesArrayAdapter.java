package com.example.roomii;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessagesArrayAdapter extends ArrayAdapter<OneComment> {

    private TextView in_comment;
    private TextView out_comment;
    private List<OneComment> countries = new ArrayList<OneComment>();
    private LinearLayout wrapper;

    public MessagesArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(OneComment object) {
        countries.add(object);
        super.add(object);
    }


    public int getCount() {
        return this.countries.size();
    }

    public OneComment getItem(int index) {
        return this.countries.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listitem_message, parent, false);
        }

        wrapper = (LinearLayout) row.findViewById(R.id.wrapper);

        OneComment coment = getItem(position);

        in_comment = (TextView) row.findViewById(R.id.in_comment);

        in_comment.setText(coment.comment);
        in_comment.setTextColor(coment.left_side ? in_comment.getResources().getColor(R.color.black) : in_comment.getResources().getColor(R.color.white));
        in_comment.setBackgroundResource(coment.left_side ? R.drawable.speech_bubble : R.drawable.speech_bubble_out);

        wrapper.setGravity(coment.left_side ? Gravity.LEFT : Gravity.RIGHT);

        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

}