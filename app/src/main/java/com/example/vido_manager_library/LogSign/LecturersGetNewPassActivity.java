package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.vido_manager_library.R;

public class LecturersGetNewPassActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private EditText LG_inputPassAdmin, LG_inputPassAdminAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers_get_new_pass);

        checkBox = (CheckBox) findViewById(R.id.checkbox);
        LG_inputPassAdmin = (EditText) findViewById(R.id.LG_inputPass);
        LG_inputPassAdminAgain = (EditText) findViewById(R.id.LG_inputPassAgain);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()) {
                    //Password visible
                    LG_inputPassAdminAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    LG_inputPassAdmin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //Password not visible
                    LG_inputPassAdminAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    LG_inputPassAdmin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}