package com.example.vido_manager_library.LogSign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vido_manager_library.R;

public class StudentGetNewPassActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private EditText LG_inputPass, LG_inputPassAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_get_new_pass);

        checkBox = (CheckBox) findViewById(R.id.checkbox);
        LG_inputPass = (EditText) findViewById(R.id.LG_inputPass);
        LG_inputPassAgain = (EditText) findViewById(R.id.LG_inputPassAgain);

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
}