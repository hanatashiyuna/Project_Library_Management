package com.example.vido_manager_library.Activities.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.vido_manager_library.Fragment.User.AboutFragment;
import com.example.vido_manager_library.Fragment.User.FavouriteBooksFragment;
import com.example.vido_manager_library.Fragment.User.HomeFragment;
import com.example.vido_manager_library.Fragment.User.UserBorrowBookFragment;
import com.example.vido_manager_library.QRCode.CreateQRCodeActivity;
import com.example.vido_manager_library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //print QRCode
        FloatingActionButton mQRCode = findViewById(R.id.fab);
        mQRCode.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(MainActivity.this, CreateQRCodeActivity.class);
            startActivity(intent, bundle);
        });

        //Bottom Menu
        BottomNavigationView mBottomNavView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        mBottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                    break;
                case R.id.favoriteBook:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavouriteBooksFragment()).commit();
                    break;
                case R.id.borrowBooks:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new UserBorrowBookFragment()).commit();
                    break;
                case R.id.information:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutFragment()).commit();
                    break;
                default:
                    break;
            }
            return true;
        });
    }
//    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
//
//        Window win = activity.getWindow();
//        WindowManager.LayoutParams winParams = win.getAttributes();
//        if (on) {
//            winParams.flags |= bits;
//        } else {
//            winParams.flags &= ~bits;
//        }
//        win.setAttributes(winParams);
//    }
}