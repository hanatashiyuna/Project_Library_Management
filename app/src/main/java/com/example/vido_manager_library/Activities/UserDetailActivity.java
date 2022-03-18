package com.example.vido_manager_library.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.R;

public class UserDetailActivity extends AppCompatActivity {

    TextView btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        //logout
        btnLogOut = findViewById(R.id.log_out_btn);
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