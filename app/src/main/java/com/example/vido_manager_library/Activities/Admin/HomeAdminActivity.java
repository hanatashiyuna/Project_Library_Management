package com.example.vido_manager_library.Activities.Admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vido_manager_library.Admin.Activities.AdminActivity;
import com.example.vido_manager_library.Fragment.Admin.AdminCategoryFrament;
import com.example.vido_manager_library.Fragment.Admin.AdminPCFrament;
import com.example.vido_manager_library.Fragment.Admin.AdminPositionFrament;
import com.example.vido_manager_library.Fragment.Admin.HomeAdminFragment;
import com.example.vido_manager_library.Fragment.Admin.ManagerFragment;
import com.example.vido_manager_library.Models.Capture;
import com.example.vido_manager_library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HomeAdminActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavView;
    private FloatingActionButton scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        //scanner
        scanner = findViewById(R.id.fab);
        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khoi tao intent
                IntentIntegrator intentIntegrator = new IntentIntegrator(HomeAdminActivity.this);
                //Set prompt text
                intentIntegrator.setPrompt("For flash use volume up key");
                //Set beep
                intentIntegrator.setBeepEnabled(true);
                //locked oritation
                intentIntegrator.setOrientationLocked(true);
                //set capture activity
                intentIntegrator.setCaptureActivity(Capture.class);
                //initiate scan
                intentIntegrator.initiateScan();
            }
        });

        //set bottom navigation menu
        mBottomNavView = findViewById(R.id.bottom_nav);
        mBottomNavView.setBackground(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeAdminFragment()).commit();

        mBottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.managerBooks:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ManagerFragment()).commit();
                        break;
                    case R.id.managerAccount:
                    case R.id.infomation:
                        break;
                    case R.id.home:
                    default:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeAdminFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
    //scanner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check condition
        if(intentResult.getContents() != null){
            /**
             * khi content = null: khoi tao alert dialog
             */

            AlertDialog.Builder builder = new AlertDialog.Builder(HomeAdminActivity.this);
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
            /**
             * khi content ko null: in ra 1 doan hoi thoai
             */
            Toast.makeText(getApplication(), "Bạn vẫn chưa scan thứ gì...", Toast.LENGTH_SHORT).show();
        }
    }
}