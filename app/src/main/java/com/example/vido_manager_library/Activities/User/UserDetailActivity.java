package com.example.vido_manager_library.Activities.User;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import com.example.vido_manager_library.*;

public class UserDetailActivity extends AppCompatActivity {

    TextView btnLogOut, btn_signup, myInfo, name, LG_Username, LG_mssv, version;
    ImageView back;
    UserStu infor_signup;
    Integer id_mssv;
    String get_name;

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        //parameters

        btnLogOut = findViewById(R.id.log_out_btn);
        btn_signup = findViewById(R.id.btn_signup);
        myInfo = findViewById(R.id.my_info);
        name = findViewById(R.id.tv_name);
        back = findViewById(R.id.back);
        version = findViewById(R.id.version);

        version.setText(String.format("Beta Version %s", BuildConfig.VERSION_NAME));

        List<UserStu> mListAccount = new ArrayList<UserStu>();
        LG_Username = findViewById(R.id.LG_Username);
        LG_mssv = findViewById(R.id.LG_mssv);

        Cursor cursor = AccountModify.findTheFirst();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String password = "123456";
            mListAccount.add(new UserStu(id,name,password));
            cursor.moveToNext();
        }
        cursor.close();

        for (UserStu userStu: mListAccount) {
            LG_Username.setText(userStu.getName());
            LG_mssv.setText(String.valueOf(userStu.getMssv()));
            id_mssv = userStu.getMssv();
            get_name = userStu.getName();
            infor_signup = userStu;
        }


        //thong tin sinh viên
        myInfo.setOnClickListener(view -> {
            AlertDialog.Builder builder =new AlertDialog.Builder(UserDetailActivity.this);

//      Khai báo layout sẽ đưa vào nơi chỉ định
            LayoutInflater inflater = getLayoutInflater();
            view = inflater.inflate(R.layout.activity_information,null);

            TextView infor_getmssv = view.findViewById(R.id.infor_getmssv);
            TextView infor_getname = view.findViewById(R.id.infor_getname);

            infor_getmssv.setText(String.valueOf(id_mssv));
            infor_getname.setText(String.valueOf(get_name));
            builder.setView(view);
            builder.setIcon(R.drawable.ic_baseline_info_24);
            builder.setTitle("Thông tin sinh viên.").setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        });

        //Sign Up

        btn_signup.setOnClickListener(view -> {
            //Do không đồng bộ Api nên không thể sử dụng
            /*Intent intent_Signup = new Intent(UserDetailActivity.this, StudentGetNewPassActivity.class);
            Bundle bundle_Signup = new Bundle();
            bundle_Signup.putSerializable("Forgot_userLogin", infor_signup);
            intent_Signup.putExtras(bundle_Signup);
            startActivity(intent_Signup);
            */
        });

        //logout
        btnLogOut.setOnClickListener(view -> {
            AccountModify.delete(id_mssv);
            switchActivity();
            //xử lý sau log out
            finish();
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(UserDetailActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    //trả về log in page của sinh viên
    public void switchActivity(){
        Intent intent = new Intent(UserDetailActivity.this, StudentLoginActivity.class);
        startActivity(intent);

    }
}