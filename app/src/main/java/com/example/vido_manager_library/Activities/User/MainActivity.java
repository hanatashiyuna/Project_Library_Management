package com.example.vido_manager_library.Activities.User;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.Fragment.User.AboutFragment;
import com.example.vido_manager_library.Fragment.User.FavouriteBooksFragment;
import com.example.vido_manager_library.Fragment.User.HomeFragment;
import com.example.vido_manager_library.Fragment.User.UserBorrowBookFragment;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.QRCode.CreateQRCodeActivity;
import com.example.vido_manager_library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!AccountModify.serchDB()) {
            Intent intent_inforMain = getIntent();
            Bundle bundleInfor = intent_inforMain.getExtras();
            UserAuthor userStu = (UserAuthor) bundleInfor.get("infor_userLogin");
            DB_Helper.getInstance(this);
            AccountModify.insert(userStu);
        }
        //print QRCode
        FloatingActionButton mQRCode = findViewById(R.id.fab);
        mQRCode.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CreateQRCodeActivity.class);
            startActivity(intent);
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
}