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

import com.example.vido_manager_library.Api.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.Activities.User.MainActivity;
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
    private List<UserAuthor> mListUser;
    private UserAuthor mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        btn_Login = (Button) findViewById(R.id.btn_Login);
        btn_forgotpass = (TextView) findViewById(R.id.btn_ForgotPass);
        btn_loginAdmin = (TextView) findViewById(R.id.btn_LoginAdmin);

        checkBox = (CheckBox) findViewById(R.id.checkbox);

        LG_inputUsrename = (EditText) findViewById(R.id.LG_inputUsrename);
        LG_inputPass = (EditText) findViewById(R.id.LG_inputPass);

        //Run ArrayList and download json User in Database
        mListUser = new ArrayList<>();

        getListUser();//Function down load

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin(); //Treatment click Login
                /*Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
                startActivity(intent);*/
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

    private void getListUser() {
        ApiService.apiService.covertUserAuthor().enqueue(new Callback<List<UserAuthor>>() {
            @Override
            public void onResponse(Call<List<UserAuthor>> call, Response<List<UserAuthor>> response) {
                mListUser = response.body();
                //Log.e("List User : ", mListUser.size()+"");
            }
            @Override
            public void onFailure(Call<List<UserAuthor>> call, Throwable t) {
                Toast.makeText(StudentLoginActivity.this, "Sai Mật Khẩu Hoặc Tài Khoản", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickLogin() {
        String username = LG_inputUsrename.getText().toString().trim();
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
            Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("infor_userLogin", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(StudentLoginActivity.this, "Sai Mật Khẩu Hoặc Tài Khoản", Toast.LENGTH_SHORT).show();
            /* TO DO CODING */
            Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}