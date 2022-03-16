package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vido_manager_library.R;

public class LecturersForgotActivity extends AppCompatActivity {

    private Button btn_forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers_forgot);

        btn_forgotPass = (Button) findViewById(R.id.btn_ForgotPass);

        btn_forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(false){

                }else {
                    Toast.makeText(getApplicationContext(), "Không tìm thấy mssv", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }
            }
        });
    }

    public void switchActivity(){
        Intent intent = new Intent(LecturersForgotActivity.this, LecturersGetNewPassActivity.class);
        startActivity(intent);
    }
}