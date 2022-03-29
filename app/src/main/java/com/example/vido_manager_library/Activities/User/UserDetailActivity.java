package com.example.vido_manager_library.Activities.User;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Adapters.UserDetailAdapters;
import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.LogSign.StudentGetNewPassActivity;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.Models.UserDetailModels;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.example.vido_manager_library.*;

public class UserDetailActivity extends AppCompatActivity {

    TextView btnLogOut,btn_signup,myInfo, name,LG_Username,LG_mssv;
    RecyclerView informationVerRec;
    List<UserDetailModels> userDetailModelsList;
    UserDetailAdapters userDetailAdapters;
    UserAuthor infor_sidnup;
    Integer id_mssv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        //parameters
//        informationVerRec = findViewById(R.id.information_ver_rec);

        btnLogOut = findViewById(R.id.log_out_btn);
        btn_signup = findViewById(R.id.btn_signup);
        myInfo = findViewById(R.id.my_info);
        name = findViewById(R.id.tv_name);


        List<UserStu> mlistAccount = new ArrayList<UserStu>();
        LG_Username = findViewById(R.id.LG_Username);
        LG_mssv = findViewById(R.id.LG_mssv);

        Cursor cursor = AccountModify.findTheFirst();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String password = "123456";
            mlistAccount.add(new UserStu(id,name,password));
            cursor.moveToNext();
        }
        cursor.close();

        for (UserStu userStu: mlistAccount) {
            LG_Username.setText(userStu.getName());
            LG_mssv.setText(String.valueOf(userStu.getMssv()));
            id_mssv = userStu.getMssv();
        }


        //thong tin sinh vien
        myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView infor_mssv = view.findViewById(R.id.infor_mssv);
                final TextView infor_getmssv = view.findViewById(R.id.infor_getmssv);
                final TextView infor_name  = view.findViewById(R.id.infor_name);
                final TextView infor_getname = view.findViewById(R.id.infor_getname);
                AlertDialog.Builder builder = new AlertDialog.Builder(UserDetailActivity.this);
                builder.setTitle("Thông tin");
//                builder.setIcon(R.drawable.ic_baseline_info_24);

                builder.setView(R.layout.activity_information);
                /*infor_mssv = setTitle(id_mssv);
                infor_getmssv = findViewById(R.id.infor_getmssv);
                infor_name  = findViewById(R.id.infor_name);
                infor_getname = findViewById(R.id.infor_getname);*/
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        //Sign Up

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*infor_sidnup = MainActivity.inforUser;
                Intent intent_Signup = new Intent(UserDetailActivity.this, StudentGetNewPassActivity.class);
                Bundle bundle_Signup = new Bundle();

                bundle_Signup.putSerializable("Forgot_userLogin", inforUser);
                intent_Signup.putExtras(bundle_Signup);
                startActivity(intent_Signup);
                finish();*/
            }
        });

        //logout
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountModify.delete(id_mssv);
                switchActivity();
                //xử lý sau đăng xuất
                //none
                finish();
            }
        });
    }

    //trả về trang đăng nhập của sinh viên
    public void switchActivity(){
        Intent intent = new Intent(UserDetailActivity.this, StudentLoginActivity.class);
        startActivity(intent);

    }
}