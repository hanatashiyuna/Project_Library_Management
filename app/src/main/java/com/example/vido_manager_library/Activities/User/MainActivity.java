package com.example.vido_manager_library.Activities.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

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

    private BottomNavigationView mBottomNavView;
    private FloatingActionButton mQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //QRCode

        mQRCode = findViewById(R.id.fab);
        mQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(MainActivity.this, CreateQRCodeActivity.class);
                startActivity(intent, bundle);
            }
        });

        //Bottom Menu
        mBottomNavView = findViewById(R.id.bottom_navigation);
        mBottomNavView.setBackground(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        mBottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            }
        });
    }
    //scanner
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check condition
        if(intentResult.getContents() != null){


            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Kết quả");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }else{

            Toast.makeText(getApplication(), "Bạn vẫn chưa scan thứ gì...", Toast.LENGTH_SHORT).show();
        }
    }*/
}