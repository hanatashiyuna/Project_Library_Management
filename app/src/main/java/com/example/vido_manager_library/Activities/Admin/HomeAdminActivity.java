package com.example.vido_manager_library.Activities.Admin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Emtity.AccountAdminModify;
import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.Fragment.Admin.AboutAdminFragment;
import com.example.vido_manager_library.Fragment.Admin.HomeAdminFragment;
import com.example.vido_manager_library.Fragment.Admin.ManagerAccountFragment;
import com.example.vido_manager_library.Fragment.Admin.ManagerFragment;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.UserLectuters;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.QRCode.Capture;
import com.example.vido_manager_library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Activity Basic for Administrator*/
public class HomeAdminActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        if (!AccountAdminModify.serchDBAdmin()) {
            Intent intent_inforAdminMain = getIntent();
            Bundle bundleInforAdmin = intent_inforAdminMain.getExtras();
            UserLectuters userLectuters = (UserLectuters) bundleInforAdmin.get("infor_userLecturersLogin");
            DB_Helper.getInstance(this);
            AccountAdminModify.insert(userLectuters);
        }

        //scanner
        FloatingActionButton scanner = findViewById(R.id.fab);
        scanner.setOnClickListener(view -> {
            //khoi tao intent
            IntentIntegrator intentIntegrator = new IntentIntegrator(HomeAdminActivity.this);
            //Set prompt text
            intentIntegrator.setPrompt("For flash use volume up key");
            //Set beep
            intentIntegrator.setBeepEnabled(true);
            //locked orientation
            intentIntegrator.setOrientationLocked(true);
            //set capture activity
            intentIntegrator.setCaptureActivity(Capture.class);
            //initiate scan
            intentIntegrator.initiateScan();
        });

        //set bottom navigation menu
        BottomNavigationView mBottomNavView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeAdminFragment()).commit();

        mBottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeAdminFragment(), "home").commit();
                    break;
                case R.id.managerBooks:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ManagerFragment(), "managerBook").commit();
                    break;
                case R.id.managerAccount:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ManagerAccountFragment(), "managerAccount").commit();
                    break;
                case R.id.information:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutAdminFragment(), "about").commit();
                    break;
                default:
                    return false;
            }
            return true;
        });
    }
    //scanner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check condition
        if(intentResult.getContents() != null){
            /*
             * khi content = null: khoi tao alert dialog
             */

            AlertDialog.Builder builder = new AlertDialog.Builder(HomeAdminActivity.this);
            builder.setTitle("Kết quả");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        }else{
            /*
             * khi content ko null: in ra 1 ket qua
             */
            Toast.makeText(getApplication(), "Bạn vẫn chưa scan thứ gì...", Toast.LENGTH_SHORT).show();
        }
    }


}