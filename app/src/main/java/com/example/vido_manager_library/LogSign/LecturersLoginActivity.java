package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Activities.Admin.HomeAdminActivity;
import com.example.vido_manager_library.R;

public class LecturersLoginActivity extends AppCompatActivity {
    private EditText LG_inputUsernameAdmin, LG_inputPassAdmin;
    private Button btn_LoginAdmin;
    private TextView btn_ForgotPassAdmin;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers_login);

        btn_LoginAdmin = (Button) findViewById(R.id.btn_LoginAdmin);
        btn_ForgotPassAdmin = (TextView) findViewById(R.id.btn_ForgotPassAdmin);
        //btn_loginStudent = (TextView) findViewById(R.id.btn_LoginStudent);

        LG_inputUsernameAdmin = (EditText) findViewById(R.id.LG_inputUsernameAdmin);
        LG_inputPassAdmin = (EditText) findViewById(R.id.LG_inputPassAdmin);

        checkBox = (CheckBox) findViewById(R.id.checkbox);

        //=================================================================
        //Phần Xử lí chạm chuyển activity
        btn_LoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;
                username = String.valueOf(LG_inputUsernameAdmin.getText());
                password = String.valueOf(LG_inputPassAdmin.getText());

                if (!username.equals("") && !password.equals("")){

                    /*Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.1.9/CDVienDongLibary/LoginAndSignUp/loginadmin.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginAdmin.this, MenuAdmin.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });*/
                }else {
                    Toast.makeText(getApplicationContext(), "All Fields Required", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }
            }
        });

        btn_ForgotPassAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LecturersLoginActivity.this, LecturersForgotActivity.class);
                startActivity(intent);
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBox.isChecked()) {
                    //Password visible
                    LG_inputPassAdmin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    //Password not visible
                    LG_inputPassAdmin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
    public void switchActivity(){
        Intent intent = new Intent(LecturersLoginActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }
}