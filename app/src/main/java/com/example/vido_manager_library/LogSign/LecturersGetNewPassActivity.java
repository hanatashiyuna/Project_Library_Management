package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LecturersGetNewPassActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private EditText LG_inputPassAdmin, LG_inputPassAdminAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers_get_new_pass);

        Button btn_ChangePassLec = findViewById(R.id.btn_ChangePassLec);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        UserAuthor userLecturer = (UserAuthor) bundle.get("infor_userLecturerLogin");

        checkBox = findViewById(R.id.checkbox);
        LG_inputPassAdmin = findViewById(R.id.LG_inputPassAdmin);
        LG_inputPassAdminAgain = findViewById(R.id.LG_inputPassAdminAgain);

        // Project UPDATE HERE.....
        btn_ChangePassLec.setOnClickListener(view -> {
            if (LG_inputPassAdmin == LG_inputPassAdminAgain) {
                int tacgiaId = userLecturer.getTacgiaId();
                String tentacgia = LG_inputPassAdminAgain.getText().toString().trim();
                userLecturer.setTentacgia(tentacgia);

                if(!TextUtils.isEmpty(tentacgia)) {
                    updateAccount(tacgiaId, userLecturer);
                }
            }else {
                Toast.makeText(LecturersGetNewPassActivity.this, "Xác Nhận Mật Khẩu Không Trùng Nhau", Toast.LENGTH_SHORT).show();
            }

        });

        checkBox.setOnClickListener(view -> {
            if(checkBox.isChecked()) {
                //Password visible
                LG_inputPassAdminAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                LG_inputPassAdmin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{
                //Password not visible
                LG_inputPassAdminAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                LG_inputPassAdmin.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
    }

    private void updateAccount(int id, UserAuthor userAuthor) {
        ApiService.apiService.updateData(id, userAuthor).enqueue(new Callback<UserAuthor>() {
            @Override
            public void onResponse(Call<UserAuthor> call, Response<UserAuthor> response) {

                if(response.isSuccessful()) {
                    Intent intent = new Intent(LecturersGetNewPassActivity.this, LecturersLoginActivity.class);
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