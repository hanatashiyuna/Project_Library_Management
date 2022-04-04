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
import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Emtity.AccountAdminModify;
import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Activities.User.MainActivity;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLoginActivity extends AppCompatActivity {
    private EditText LG_inputUsrename, LG_inputPass;
    private CheckBox checkBox;
    private Button btn_Login;
    private TextView btn_loginAdmin, btn_forgotpass;
    private List<UserStu> mListUser;
    private UserStu mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        DB_Helper.getInstance(this);
        if (AccountModify.serchDB() && !AccountAdminModify.serchDBAdmin()) {
            if (AccountModify.serchDB()) {
                Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                btn_forgotpass = (TextView) findViewById(R.id.btn_ForgotPass);
                btn_loginAdmin = (TextView) findViewById(R.id.btn_LoginAdmin);

                LG_inputUsrename = (EditText) findViewById(R.id.LG_inputUsrename);
                LG_inputPass = (EditText) findViewById(R.id.LG_inputPass);
                btn_Login = (Button) findViewById(R.id.btn_Login);

                checkBox = (CheckBox) findViewById(R.id.checkbox);

                //Run ArrayList and download json User in Database
                mListUser = new ArrayList<>();

                getListUser();//Function down load

                btn_Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clickLogin(); //Treatment click Login
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

                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!checkBox.isChecked()) {
                            //Password visible
                            LG_inputPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }else{
                            //Password not visible
                            LG_inputPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        }
                    }
                });
            }
        }else if(!AccountModify.serchDB() && AccountAdminModify.serchDBAdmin()) {
            if (AccountAdminModify.serchDBAdmin()) {
                Intent intent = new Intent(StudentLoginActivity.this, HomeAdminActivity.class);
                startActivity(intent);
                finish();
            }else {
                Intent intent = new Intent(StudentLoginActivity.this, LecturersLoginActivity.class);
                startActivity(intent);

            }
        }else if(!AccountModify.serchDB() && !AccountAdminModify.serchDBAdmin()) {
            btn_forgotpass = (TextView) findViewById(R.id.btn_ForgotPass);
            btn_loginAdmin = (TextView) findViewById(R.id.btn_LoginAdmin);

            LG_inputUsrename = (EditText) findViewById(R.id.LG_inputUsrename);
            LG_inputPass = (EditText) findViewById(R.id.LG_inputPass);
            btn_Login = (Button) findViewById(R.id.btn_Login);

            checkBox = (CheckBox) findViewById(R.id.checkbox);

            //Run ArrayList and download json User in Database
            mListUser = new ArrayList<>();

            getListUser();//Function down load

            btn_Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickLogin(); //Treatment click Login
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

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!checkBox.isChecked()) {
                        //Password visible
                        LG_inputPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }else{
                        //Password not visible
                        LG_inputPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                }
            });
        }

    }


    private void getListUser() {
        ApiService.apiService.covertUserStu().enqueue(new Callback<List<UserStu>>() {
            @Override
            public void onResponse(Call<List<UserStu>> call, Response<List<UserStu>> response) {
                mListUser = response.body();
            }
            @Override
            public void onFailure(Call<List<UserStu>> call, Throwable t) {
                Toast.makeText(StudentLoginActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickLogin() {
        String MSSV =LG_inputUsrename.getText().toString().trim();
        String password = LG_inputPass.getText().toString().trim();
        if (!password.equals("")) {
            if (mListUser == null || mListUser.isEmpty()){
                return;
            }

            boolean isHasUser = false;

            for (UserStu userStu: mListUser) {
                //set password
                if (MSSV.equals(userStu.getMasosinhvien()) && password.equals(userStu.getMatkhau())){
                    isHasUser = true;
                    mUser = userStu;
                    mListUser = null;
                    break;
                }
            }

            if (isHasUser) {
                Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("infor_userLogin", mUser);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(StudentLoginActivity.this, "Sai Mật Khẩu Hoặc Tài Khoản", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getApplicationContext(), "Sai Tài Khoản Hoặc Mật Khẩu.", Toast.LENGTH_SHORT).show();

        }

    }
}