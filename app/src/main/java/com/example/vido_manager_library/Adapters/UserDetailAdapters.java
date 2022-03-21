package com.example.vido_manager_library.Adapters;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Models.UserDetailModels;
import com.example.vido_manager_library.R;

import java.util.List;

public class UserDetailAdapters extends CursorAdapter {

    Activity activity;
    //Context context;
    List<UserDetailModels> list;

    public UserDetailAdapters(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }

//    public void UserDetailAdapters(Activity activity, List<UserDetailModels> list) {
//        this.activity = activity;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(activity.getParent()).inflate(R.layout.information_student, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserDetailAdapters.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        holder.name.setText(list.get(position).getName());
//        holder.tv_class.setText(String.valueOf(list.get(position).getClassStudent()));
//        holder.mssv.setText(list.get(position).getMssv());
//        holder.address.setText(list.get(position).getAddress());
//        holder.birthday.setText(list.get(position).getBirthday());
//        holder.phone.setText(list.get(position).getPhone());
//        holder.coursera.setText(String.valueOf(list.get(position).getCoursera()));
//        holder.majors.setText(list.get(position).getMajors());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, tv_class, mssv, address, birthday, phone, coursera, majors;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name);
            tv_class = itemView.findViewById(R.id.tv_class);
            mssv = itemView.findViewById(R.id.tv_mssv);
            address = itemView.findViewById(R.id.tv_address);
            birthday = itemView.findViewById(R.id.tv_birthday);
            phone = itemView.findViewById(R.id.tv_phone);
            coursera = itemView.findViewById(R.id.tv_coursera);
            majors = itemView.findViewById(R.id.tv_majors);
        }
    }
}
