package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Admin.Activities.AdminActivity;
import com.example.vido_manager_library.Admin.Activities.HomeAdminActivity;
import com.example.vido_manager_library.Api.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;
import com.example.vido_manager_library.User.Acitvity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LecturersLoginActivity extends AppCompatActivity {
    private EditText LG_inputUsernameAdmin, LG_inputPassAdmin;
    private Button btn_LoginAdmin;
    private TextView btn_ForgotPassAdmin;
    private CheckBox checkBox;
    private List<UserAuthor> mListUser;
    private UserAuthor mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers_login);

        btn_LoginAdmin = (Button) findViewById(R.id.btn_LoginAdmin);
        btn_ForgotPassAdmin = (TextView) findViewById(R.id.btn_ForgotPassAdmin);
        //Run ArrayList and download json User in Database
        mListUser = new ArrayList<>();

        getListUser();//Function down load

        LG_inputUsernameAdmin = (EditText) findViewById(R.id.LG_inputUsernameAdmin);
        LG_inputPassAdmin = (EditText) findViewById(R.id.LG_inputPassAdmin);

        checkBox = (CheckBox) findViewById(R.id.checkbox);

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

    public void getListUser() {
        ApiService.apiService.covertUserAuthor().enqueue(new Callback<List<UserAuthor>>() {
            @Override
            public void onResponse(Call<List<UserAuthor>> call, Response<List<UserAuthor>> response) {
                mListUser = response.body();
//                Log.e("List User: ", mListUser.size()+"");
            }
            @Override
            public void onFailure(Call<List<UserAuthor>> call, Throwable t) {
                Toast.makeText(LecturersLoginActivity.this, "Sai Mật Khẩu Hoặc Tài Khoản", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickLogin() {
        String username = LG_inputUsernameAdmin.getText().toString().trim();
//        String password = LG_inputPass.getText().toString().trim();

        if (mListUser == null || mListUser.isEmpty()){
            return;
        }

        boolean isHasUser = false;

        for (UserAuthor userAuthor: mListUser) {
            //set password
            if (username.equals(userAuthor.getTentacgia())){
                isHasUser = true;
                mUser = userAuthor;
                mListUser = null;
                break;
            }
        }

        if (isHasUser) {
            Intent intent = new Intent(LecturersLoginActivity.this, AdminActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("infor_userLogin", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(LecturersLoginActivity.this, "Sai Mật Khẩu Hoặc Tài Khoản", Toast.LENGTH_SHORT).show();
        }
    }
}