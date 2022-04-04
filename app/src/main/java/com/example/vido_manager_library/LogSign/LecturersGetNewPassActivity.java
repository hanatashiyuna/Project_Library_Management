package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vido_manager_library.Interface.ApiLecturers;
import com.example.vido_manager_library.Models.UserLectuters;
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

        UserLectuters userLecturers = (UserLectuters) bundle.get("infor_userLecturerLogin");

        checkBox = findViewById(R.id.checkbox);
        LG_inputPassAdmin = findViewById(R.id.LG_inputPassAdmin);
        LG_inputPassAdminAgain = findViewById(R.id.LG_inputPassAdminAgain);

        // Project UPDATE HERE.....
        btn_ChangePassLec.setOnClickListener(view -> {
            String newPassAdmin = LG_inputPassAdmin.getText().toString().trim();
            String newPassAgainAdmin = LG_inputPassAdminAgain.getText().toString().trim();
            if (newPassAdmin.equals(newPassAgainAdmin)) {
                int idLecturer = userLecturers.getThuthuId();
                userLecturers.setMatkhau(newPassAgainAdmin);
                updateAccount(idLecturer, userLecturers);
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

    private void updateAccount(int id, UserLectuters userLectuters) {
        ApiLecturers.apiLecturers.updateDataLecturers(id, userLectuters).enqueue(new Callback<UserLectuters>() {
            @Override
            public void onResponse(Call<UserLectuters> call, Response<UserLectuters> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(LecturersGetNewPassActivity.this, "Đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LecturersGetNewPassActivity.this, LecturersLoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserLectuters> call, Throwable t) {
                Log.e("Error", "Api dont put data.");
                Toast.makeText(LecturersGetNewPassActivity.this, "Đang có vấn đề về mạng. Vui lòng thử lại.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}