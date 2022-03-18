package com.example.vido_manager_library.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Adapters.UserDetailAdapters;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.Models.UserDetailModels;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

public class UserDetailActivity extends AppCompatActivity {

    TextView btnLogOut,myInfo;
    ListView listUserDetail;
    List<UserDetailModels> userDetailModelsList;
    UserDetailAdapters userDetailAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        //parameters
        btnLogOut = findViewById(R.id.log_out_btn);
        myInfo = findViewById(R.id.my_info);
        listUserDetail = findViewById(R.id.lv_user_detail);

        //data test
        userDetailModelsList = new ArrayList<>();

        userDetailModelsList.add(new UserDetailModels("Nguyen Van A", "14THDH", "? Go Vap", 2006010003, "04/09/2002", "0123456789", 14, "CNTT"));
        //userDetailAdapters = new UserDetailAdapters(this, userDetailModelsList);
        //thong tin sinh vien
        myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserDetailActivity.this);
                builder.setTitle("Thông tin");
                builder.setIcon(R.drawable.ic_baseline_info_24);
                builder.setView(R.layout.information_student);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        //logout
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity();
                //xử lý sau đăng xuất
                //none
            }
        });
    }

    //trả về trang đăng nhập của sinh viên
    public void switchActivity(){
        Intent intent = new Intent(UserDetailActivity.this, StudentLoginActivity.class);
        startActivity(intent);
    }
}