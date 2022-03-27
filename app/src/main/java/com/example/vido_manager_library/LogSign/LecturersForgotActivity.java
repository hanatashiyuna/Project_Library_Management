package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LecturersForgotActivity extends AppCompatActivity {

    private Button btn_forgotPass;
    private EditText LG_inputUsernameAdmin;
    private List<UserAuthor> mListUser;
    private UserAuthor mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers_forgot);

        //Run ArrayList and download json User in Database
        mListUser = new ArrayList<>();

        getListUser();//Function down load

        LG_inputUsernameAdmin = (EditText) findViewById(R.id.LG_inputUsernameAdmin);

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
                Toast.makeText(LecturersForgotActivity.this, "Không Tìm Thấy Tài Khoản", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clickLogin() {
        String username = LG_inputUsernameAdmin.getText().toString().trim();

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
            Intent intent = new Intent(LecturersForgotActivity.this, LecturersGetNewPassActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("infor_userLogin", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Không tìm thấy tài khoản thủ thư", Toast.LENGTH_SHORT).show();
        }
    }
}