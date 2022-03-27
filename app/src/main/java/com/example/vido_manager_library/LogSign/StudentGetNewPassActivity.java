package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                if (LG_inputPass == LG_inputPassAgain) {
                    int tacgiaId = userAuthor.getTacgiaId();
                    String tentacgia = LG_inputPassAgain.getText().toString().trim();
                    userAuthor.setTentacgia(tentacgia);

                    if(!TextUtils.isEmpty(tentacgia)) {
                        updateAccount(tacgiaId, userAuthor);
                    }
                }else {
                    Toast.makeText(StudentGetNewPassActivity.this, "Xác Nhận Mật Khẩu Không Trùng Nhau", Toast.LENGTH_SHORT).show();
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

    private void updateAccount(int id, UserAuthor userAuthor) {
        ApiService.apiService.updateData(id, userAuthor).enqueue(new Callback<UserAuthor>() {
            @Override
            public void onResponse(Call<UserAuthor> call, Response<UserAuthor> response) {

                if(response.isSuccessful()) {
                    Intent intent = new Intent(StudentGetNewPassActivity.this, StudentLoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserAuthor> call, Throwable t) {
                Log.e("Error", "Api dont put data.");
            }
        });
    }
}