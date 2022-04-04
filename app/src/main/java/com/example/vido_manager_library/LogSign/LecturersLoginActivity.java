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
import com.example.vido_manager_library.Interface.ApiLecturers;
import com.example.vido_manager_library.Models.UserLectuters;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LecturersLoginActivity extends AppCompatActivity {
    private EditText LG_inputUsernameAdmin, LG_inputPassAdmin;
    private Button btn_LoginAdmin;
    private TextView btn_ForgotPassAdmin, btn_LoginStudent;
    private CheckBox checkBox;
    private List<UserLectuters> mListUser;
    private UserLectuters mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers_login);

        btn_LoginAdmin = (Button) findViewById(R.id.btn_LoginAdmin);
        btn_ForgotPassAdmin = (TextView) findViewById(R.id.btn_ForgotPassAdmin);
        btn_LoginStudent = (TextView) findViewById(R.id.btn_LoginStu);

        LG_inputUsernameAdmin = (EditText) findViewById(R.id.LG_inputUsernameAdmin);
        LG_inputPassAdmin = (EditText) findViewById(R.id.LG_inputPassAdmin);

        checkBox = (CheckBox) findViewById(R.id.checkbox);

        mListUser = new ArrayList<>();

        getListUser();//Function down load

        //=================================================================
        //Phần Xử lí chạm chuyển activity
        btn_LoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin(); //Treatment click Login

            }
        });

        btn_ForgotPassAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LecturersLoginActivity.this, LecturersForgotActivity.class);
                startActivity(intent);
            }
        });

        btn_LoginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LecturersLoginActivity.this, StudentLoginActivity.class);
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


    private void getListUser() {
        ApiLecturers.apiLecturers.covertUserLectuters().enqueue(new Callback<List<UserLectuters>>() {
            @Override
            public void onResponse(Call<List<UserLectuters>> call, Response<List<UserLectuters>> response) {
                mListUser = response.body();
            }
            @Override
            public void onFailure(Call<List<UserLectuters>> call, Throwable t) {
                Toast.makeText(LecturersLoginActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickLogin() {
        String usernameAdmin = LG_inputUsernameAdmin.getText().toString().trim();
        String password = LG_inputPassAdmin.getText().toString().trim();
        if (!usernameAdmin.equals("")){
            if (mListUser == null || mListUser.isEmpty()){
                return;
            }

            boolean isHasUser = false;

            for (UserLectuters userLectuters: mListUser) {
                //set password
                if (usernameAdmin.equals(userLectuters.getUsername()) && password.equals(userLectuters.getMatkhau())){
                    isHasUser = true;
                    mUser = userLectuters;
                    mListUser = null;
                    break;
                }
            }

            if (isHasUser) {
                Intent intent = new Intent(LecturersLoginActivity.this, HomeAdminActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("infor_userLecturersLogin", mUser);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(LecturersLoginActivity.this, "Sai Mật Khẩu Hoặc Tài Khoản", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "Sai Tài Khoản Hoặc Mật Khẩu.", Toast.LENGTH_SHORT).show();

        }

    }
}