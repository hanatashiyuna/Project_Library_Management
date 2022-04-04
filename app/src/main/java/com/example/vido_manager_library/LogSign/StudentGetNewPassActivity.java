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

import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentGetNewPassActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private EditText LG_inputNewPass, LG_inputNewPassAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_get_new_pass);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        UserStu userStu = (UserStu) bundle.get("Forgot_userLogin");

        LG_inputNewPass = findViewById(R.id.LG_inputNewPass);
        LG_inputNewPassAgain = findViewById(R.id.LG_inputNewPassAgain);
        checkBox = findViewById(R.id.checkbox);



        Button btn_ChangePassStu = findViewById(R.id.btn_ChangePassStu);
        // Project UPDATE HERE.....
        btn_ChangePassStu.setOnClickListener(view -> {
            String newPass = LG_inputNewPass.getText().toString().trim();
            String newPassAgain = LG_inputNewPassAgain.getText().toString().trim();
            if (String.valueOf(newPass).equals(String.valueOf(newPassAgain))) {
                int MSSV = userStu.getSinhvienId();
                userStu.setMatkhau(newPassAgain);
                updateAccount(MSSV, userStu,newPassAgain);

            }else {
                Toast.makeText(StudentGetNewPassActivity.this, "Xác Nhận Mật Khẩu Không Trùng Nhau", Toast.LENGTH_SHORT).show();

            }

        });

        checkBox.setOnClickListener(view -> {
            if(checkBox.isChecked()) {
                //Password visible
                LG_inputNewPassAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                LG_inputNewPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{
                //Password not visible
                LG_inputNewPassAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                LG_inputNewPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
    }

    private void updateAccount(int id, UserStu userStu, String newPassAgain) {
        ApiService.apiService.updateDataStu(id, userStu).enqueue(new Callback<UserStu>() {
            @Override
            public void onResponse(Call<UserStu> call, Response<UserStu> response) {

                if(response.isSuccessful()) {
                    if (AccountModify.serchDB()) {
                        AccountModify.delete(userStu.getSinhvienId());
                    }
                    Toast.makeText(StudentGetNewPassActivity.this, "Đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StudentGetNewPassActivity.this, StudentLoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserStu> call, Throwable t) {
                Log.e("Error", "Api dont put data.");
            }
        });
    }
}