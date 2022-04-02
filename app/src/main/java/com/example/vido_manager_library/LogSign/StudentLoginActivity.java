package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.Activities.User.MainActivity;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLoginActivity extends AppCompatActivity {
    EditText LG_inputUsername, LG_inputPass;
    private CheckBox checkBox;
    Button btn_Login;
    TextView btn_loginAdmin, btn_forgotPass;
    private List<UserAuthor> mListUser;
    private UserAuthor mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        DB_Helper.getInstance(this);
        if (AccountModify.serchDB()) {
            Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
            btn_forgotPass = findViewById(R.id.btn_ForgotPass);
            btn_loginAdmin = findViewById(R.id.btn_LoginAdmin);

            LG_inputUsername = findViewById(R.id.LG_inputUsrename);
            LG_inputPass = findViewById(R.id.LG_inputPass);
            btn_Login = findViewById(R.id.btn_Login);

            checkBox = findViewById(R.id.checkbox);

            //Run ArrayList and download json User in Database
            mListUser = new ArrayList<>();

            getListUser();//Function down load

            btn_Login.setOnClickListener(view -> {
                clickLogin(); //Treatment click Login
            });

            btn_forgotPass.setOnClickListener(view -> {
                Intent intent = new Intent(StudentLoginActivity.this, StudentForgotActivity.class);
                startActivity(intent);
            });

            btn_loginAdmin.setOnClickListener(view -> {
                Intent intent = new Intent(StudentLoginActivity.this, LecturersLoginActivity.class);
                startActivity(intent);
            });

            checkBox.setOnClickListener(v -> {
                if(!checkBox.isChecked()) {
                    //Password visible
                    LG_inputPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    //Password not visible
                    LG_inputPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            });
        }
    }


    private void getListUser() {
        ApiService.apiService.covertUserAuthor().enqueue(new Callback<List<UserAuthor>>() {
            @Override
            public void onResponse(Call<List<UserAuthor>> call, Response<List<UserAuthor>> response) {
                mListUser = response.body();
            }
            @Override
            public void onFailure(Call<List<UserAuthor>> call, Throwable t) {
                Toast.makeText(StudentLoginActivity.this, "Hệ Thống Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickLogin() {
        String username = LG_inputUsername.getText().toString().trim();

        if (mListUser == null || mListUser.isEmpty()){
            return;
        }

        boolean isHasUser = false;

        for (UserAuthor userAuthor: mListUser) {
            if (username.equals(userAuthor.getTentacgia())){
                isHasUser = true;
                mUser = userAuthor;
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
    }
}