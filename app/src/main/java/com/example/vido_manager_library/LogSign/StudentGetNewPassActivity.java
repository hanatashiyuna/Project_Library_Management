package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vido_manager_library.Api.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class StudentGetNewPassActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private EditText LG_inputPass, LG_inputPassAgain;
    private Button btn_ChangePassStu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_get_new_pass);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

            UserAuthor userAuthor = (UserAuthor) bundle.get("Forgot_userLogin");


        checkBox = (CheckBox) findViewById(R.id.checkbox);
        LG_inputPass = (EditText) findViewById(R.id.LG_inputPass);
        LG_inputPassAgain = (EditText) findViewById(R.id.LG_inputPassAgain);
        btn_ChangePassStu = (Button) findViewById(R.id.btn_ChangePassStu);
        // Project UPDATE HERE.....
        btn_ChangePassStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tacgiaId = userAuthor.getTacgiaId();
                String tentacgia = LG_inputPassAgain.getText().toString().trim();
                String ngaysinh = userAuthor.getNgaysinh().trim();
                String saches = userAuthor.getSaches().trim();

                if(!TextUtils.isEmpty(tentacgia)) {
                    sendPost(tacgiaId, tentacgia, ngaysinh, saches);
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()) {
                    //Password visible
                    LG_inputPassAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    LG_inputPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //Password not visible
                    LG_inputPassAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    LG_inputPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    public void sendPost(int tacgiaId, String tentacgia, String ngaysinh, String saches) {
        ApiService.apiService.updateData(tacgiaId, tentacgia, ngaysinh, saches).enqueue(new Callback<UserAuthor>() {
            @Override
            public void onResponse(Call<UserAuthor> call, Response<UserAuthor> response) {

                if(response.isSuccessful()) {
//                    showResponse(response.body().toString());
                    //Log.e(StudentGetNewPassActivity.this, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<UserAuthor> call, Throwable t) {
                //Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

//    public void showResponse(String response) {
//        if(mResponseTv.getVisibility() == View.GONE) {
//            mResponseTv.setVisibility(View.VISIBLE);
//        }
//        mResponseTv.setText(response);
//    }
}