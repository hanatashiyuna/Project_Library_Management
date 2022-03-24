package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vido_manager_library.Api.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;
import com.example.vido_manager_library.User.Acitvity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentForgotActivity extends AppCompatActivity {

    private Button btn_forgotPass;
    private EditText LG_inputUsrename;
    private List<UserAuthor> mListUser;
    private UserAuthor mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_forgot);

        //Run ArrayList and download json User in Database
        mListUser = new ArrayList<>();

        getListUser();//Function down load

        LG_inputUsrename = (EditText) findViewById(R.id.LG_inputUsrename);

        btn_forgotPass = (Button) findViewById(R.id.btn_ForgotPass);

        btn_forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin(); //Treatment click Login
            }
        });
    }

    private void getListUser() {
        ApiService.apiService.covertUserAuthor().enqueue(new Callback<List<UserAuthor>>() {
            @Override
            public void onResponse(Call<List<UserAuthor>> call, Response<List<UserAuthor>> response) {
                mListUser = response.body();
//                Log.e("List User: ", mListUser.size()+"");
            }
            @Override
            public void onFailure(Call<List<UserAuthor>> call, Throwable t) {
                Toast.makeText(StudentForgotActivity.this, "Không Tìm Thấy Tài Khoản", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickLogin() {
        String username = LG_inputUsrename.getText().toString().trim();

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
            Intent intent = new Intent(StudentForgotActivity.this, StudentGetNewPassActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Forgot_userLogin", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Không tìm thấy mssv", Toast.LENGTH_SHORT).show();
        }
    }
}