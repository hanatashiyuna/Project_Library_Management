package com.example.vido_manager_library.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.vido_manager_library.Models.UserDetailModels;
import com.example.vido_manager_library.R;

import java.util.List;

public class UserDetailAdapters {

    /*Activity activity;
    public UserDetailAdapters(Activity activity, Cursor c) {
        super(activity, c);
        this.activity = activity;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater =activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_phone,null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name_phone = view.findViewById(R.id.IN_name);
        TextView number_phone = view.findViewById(R.id.IN_number);
        TextView email_phone = view.findViewById(R.id.IN_email);
        TextView date_save_phone = view.findViewById(R.id.IN_date);

        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
        @SuppressLint("Range") String number = cursor.getString(cursor.getColumnIndex("number"));
        @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex("email"));
        @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex("date"));

        name_phone.setText(name);
        number_phone.setText(number);
        email_phone.setText(email);
        date_save_phone.setText(date);
    }*/
}
