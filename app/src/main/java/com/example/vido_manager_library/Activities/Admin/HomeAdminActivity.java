package com.example.vido_manager_library.Activities.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_ADMIN_LOGIN;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Emtity.AccountAdminModify;
import com.example.vido_manager_library.Fragment.Admin.AboutAdminFragment;
import com.example.vido_manager_library.Fragment.Admin.HomeAdminFragment;
import com.example.vido_manager_library.Fragment.Admin.ManagerAccountFragment;
import com.example.vido_manager_library.Fragment.Admin.ManagerFragment;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.UserLectuters;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.QRCode.Capture;
import com.example.vido_manager_library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Activity Basic for Administrator*/
public class HomeAdminActivity extends AppCompatActivity {
    private List<UserStu> mListUser;
    private UserStu mUser;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        if (!AccountAdminModify.serchDBAdmin()) {
            Intent intent_inforAdminMain = getIntent();
            Bundle bundleInforAdmin = intent_inforAdminMain.getExtras();
            UserLectuters userLectuters = (UserLectuters) bundleInforAdmin.get(KEY_ADMIN_LOGIN);
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
            String qrcode = intentResult.getContents();
            getListUser(qrcode);

        }else{
            /*
             * khi content ko null: in ra 1 ket qua
             */
            Toast.makeText(getApplication(), "Bạn vẫn chưa scan thứ gì...", Toast.LENGTH_SHORT).show();
        }
    }
    private void getListUser(String qrcode) {
        ApiService.apiService.covertUserStu().enqueue(new Callback<List<UserStu>>() {
            @Override
            public void onResponse(Call<List<UserStu>> call, Response<List<UserStu>> response) {
                mListUser = response.body();
                QrTreatment(qrcode);
            }
            @Override
            public void onFailure(Call<List<UserStu>> call, Throwable t) {
                Toast.makeText(HomeAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void QrTreatment(String qrcode) {
        //to upper case qr_treatment
        String qrTreatment = qrcode.trim();

        if (!qrTreatment.equals("")) {
            if (mListUser == null || mListUser.isEmpty()){
                return;
            }

            boolean isHasUser = false;

            for (UserStu userStu: mListUser) {
                //set password
                if (qrTreatment.equals(userStu.getMasosinhvien())){
                    isHasUser = true;
                    mUser = userStu;
                    mListUser = null;
                    break;
                }
            }


            if (isHasUser) {
                Intent intent = new Intent(HomeAdminActivity.this, BorrowDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("infor_userLogin", mUser);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(HomeAdminActivity.this, "Sai Mật Khẩu Hoặc Tài Khoản", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getApplicationContext(), "Sai Tài Khoản Hoặc Mật Khẩu.", Toast.LENGTH_SHORT).show();

        }

    }

}