package com.example.vido_manager_library.Activities.User;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_FORGOT_USER;

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
import com.example.vido_manager_library.LogSign.StudentGetNewPassActivity;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import com.example.vido_manager_library.*;

public class UserDetailActivity extends AppCompatActivity {

    TextView btnLogOut, btn_signup, myInfo, name, LG_Username, LG_mssv, version;
    ImageView back;
//    UserStu infor_signup;
//    Integer id_mssv;
//    String get_name;
    UserStu infor_sidnup;

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

        List<UserStu> mlistAccount = new ArrayList<UserStu>();
        LG_Username = findViewById(R.id.LG_Username);
        LG_mssv = findViewById(R.id.LG_mssv);

        Cursor cursor = AccountModify.findTheFirst();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String masosinhvien = cursor.getString(6);
            String tensinhvien = cursor.getString(1);
            String matkhau = cursor.getString(2);
            String diachi = cursor.getString(3);
            String lop = cursor.getString(4);
            String email = cursor.getString(5);
            String soCmnd = cursor.getString(7);
            String ngaysinh = cursor.getString(8);
            String khoa = cursor.getString(9);
            mlistAccount.add(new UserStu(id, masosinhvien, tensinhvien, diachi, lop, email, matkhau, soCmnd, ngaysinh, khoa));
            cursor.moveToNext();
        }
        cursor.close();

        for (UserStu userStu: mlistAccount) {
            LG_Username.setText(userStu.getTensinhvien());
            LG_mssv.setText(String.valueOf(userStu.getMasosinhvien()));

            infor_sidnup = userStu;
        }


        //thong tin sinh viên
        myInfo.setOnClickListener(view -> {
            AlertDialog.Builder builder =new AlertDialog.Builder(UserDetailActivity.this);

//      Khai báo layout sẽ đưa vào nơi chỉ định
            LayoutInflater inflater = getLayoutInflater();
            view = inflater.inflate(R.layout.activity_information, null);

            TextView infor_getmssv = view.findViewById(R.id.infor_getmssv);
            TextView infor_getname = view.findViewById(R.id.infor_getname);
            TextView infor_getaddress = view.findViewById(R.id.infor_getaddress);
            TextView infor_getclass = view.findViewById(R.id.infor_getclass);
            TextView infor_getemail = view.findViewById(R.id.infor_getemail);
            TextView infor_getcmnd = view.findViewById(R.id.infor_getcmnd);
            TextView infor_getbirth = view.findViewById(R.id.infor_getbirth);
            TextView infor_getmajors = view.findViewById(R.id.infor_getmajors);


            infor_getmssv.setText(String.valueOf(infor_sidnup.getMasosinhvien()));
            infor_getname.setText(String.valueOf(infor_sidnup.getTensinhvien()));
            infor_getaddress.setText(String.valueOf(infor_sidnup.getDiachi()));
            infor_getclass.setText(String.valueOf(infor_sidnup.getLop()));
            infor_getemail.setText(String.valueOf(infor_sidnup.getEmail()));
            infor_getcmnd.setText(String.valueOf(infor_sidnup.getSoCmnd()));
            infor_getbirth.setText(String.valueOf(infor_sidnup.getNgaysinh()));
            infor_getmajors.setText(String.valueOf(infor_sidnup.getKhoa()));

            builder.setView(view);
            builder.setIcon(R.drawable.ic_baseline_info_24);
            builder.setTitle("Thông tin sinh viên.").setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        });

        //Sign Up

        btn_signup.setOnClickListener(view -> {
            //Do không đồng bộ Api nên không sử dụng được
            Intent intent_Signup = new Intent(UserDetailActivity.this, StudentGetNewPassActivity.class);
            Bundle bundle_Signup = new Bundle();
            bundle_Signup.putSerializable(KEY_FORGOT_USER, infor_sidnup);
            intent_Signup.putExtras(bundle_Signup);
            startActivity(intent_Signup);
        });

        //logout
        btnLogOut.setOnClickListener(view -> {
            AccountModify.delete(infor_sidnup.getSinhvienId());
            switchActivity();
            //xử lý sau đăng xuất
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