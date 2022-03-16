package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Activities.MainActivity;
import com.example.vido_manager_library.R;

import java.util.logging.Handler;

public class StudentLoginActivity extends AppCompatActivity {
    private EditText LG_inputUsrename, LG_inputPass;
    private ImageView ivEye;
    private boolean isOpenEye = false;
    private Button btn_Login;
    private TextView btn_loginAdmin, btn_forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        btn_Login = (Button) findViewById(R.id.btn_Login);
        btn_forgotpass = (TextView) findViewById(R.id.btn_ForgotPass);
        btn_loginAdmin = (TextView) findViewById(R.id.btn_LoginAdmin);

        ivEye = (ImageView) findViewById(R.id.iv_eye);

        LG_inputUsrename = (EditText) findViewById(R.id.LG_inputUsrename);
        LG_inputPass = (EditText) findViewById(R.id.LG_inputPass);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mssv, password;
                mssv = String.valueOf(LG_inputUsrename.getText());
                password = String.valueOf(LG_inputPass.getText());

                if (!mssv.equals("") && !password.equals("")){

                    /* error to library
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "mssv";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = mssv;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.1.9/CDVienDongLibary/LoginAndSignUp/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Login.this, Account.class);
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

        btn_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLoginActivity.this, StudentForgotActivity.class);
                startActivity(intent);
            }
        });

        btn_loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLoginActivity.this, LecturersLoginActivity.class);
                startActivity(intent);
            }
        });

        ivEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpenEye) {
                    ivEye.setSelected(true);
                    isOpenEye = true;
                    //Password visible
                    LG_inputPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    ivEye.setSelected(false);
                    isOpenEye = false;
                    //Password not visible
                    LG_inputPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    public void switchActivity(){
        Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}