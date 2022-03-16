package com.example.vido_manager_library.FlashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.vido_manager_library.Activities.MainActivity;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        CountDownTimer timer = new CountDownTimer(3500, 3500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                switchActivity();
            }
        };
        timer.start();
    }

    private void switchActivity() {
        Intent intent = new Intent(WelcomeActivity.this, StudentLoginActivity.class);
        startActivity(intent);
    }
}