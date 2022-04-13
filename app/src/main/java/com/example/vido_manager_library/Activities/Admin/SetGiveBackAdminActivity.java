package com.example.vido_manager_library.Activities.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_AUTHOR_DETAIL;
import static com.example.vido_manager_library.Const.ConstUTF8.KEY_SET_GIVE_BACK;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Fragment.Admin.ManagerFragment;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Interface.ApiBorrowAdmin;
import com.example.vido_manager_library.Interface.ApiGiveBackAdmin;
import com.example.vido_manager_library.Interface.ApiLecturers;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Borrow;
import com.example.vido_manager_library.Models.GiveBack;
import com.example.vido_manager_library.Models.UserLectuters;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import java.time.LocalDate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetGiveBackAdminActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_give_back_admin);

        Intent intent_inforMain = getIntent();
        Bundle bundleInfor = intent_inforMain.getExtras();
        Borrow borrow = (Borrow) bundleInfor.get(KEY_SET_GIVE_BACK);

        TextView sgb_mssv = findViewById(R.id.sgb_mssv);
        TextView sgb_nameStu = findViewById(R.id.sgb_namestu);
        TextView sgb_nameLec = findViewById(R.id.sgb_namelec);
        TextView sgb_dayBorrow = findViewById(R.id.sgb_dayborrow);
        TextView nameBook = findViewById(R.id.namebook);
        TextView codebook = findViewById(R.id.codebook);
        Button btn_addNewGiveBack = findViewById(R.id.btn_addnewgiveback);

        sgb_mssv.setText(String.valueOf(borrow.getMasosinhvien()));
        sgb_dayBorrow.setText(String.valueOf(borrow.getNgaymuon()));

        ApiService.apiService.convertSingleUserStu(borrow.getSinhvienId()).enqueue(new Callback<UserStu>() {
            @Override
            public void onResponse(Call<UserStu> call, Response<UserStu> response) {
                UserStu userStu = response.body();
                sgb_nameStu.setText(String.valueOf(userStu.getTensinhvien()));
            }
            @Override
            public void onFailure(Call<UserStu> call, Throwable t) {
                Toast.makeText(SetGiveBackAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });

        ApiLecturers.apiLecturers.covertUserSingleLecturers(borrow.getThuthuId()).enqueue(new Callback<UserLectuters>() {
            @Override
            public void onResponse(Call<UserLectuters> call, Response<UserLectuters> response) {
                UserLectuters userLectuters = response.body();
                sgb_nameLec.setText(String.valueOf(userLectuters.getHoten()));
            }
            @Override
            public void onFailure(Call<UserLectuters> call, Throwable t) {
                Toast.makeText(SetGiveBackAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });

        ApiBookAdmin.apiBookAdmin.convertSingleBookOriginalAdmin(borrow.getSachId()).enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                Books books = response.body();
                nameBook.setText(String.valueOf(books.getTensach()));
                codebook.setText(String.valueOf(books.getMasach()));
            }
            @Override
            public void onFailure(Call<Books> call, Throwable t) {
                Toast.makeText(SetGiveBackAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });

        btn_addNewGiveBack.setOnClickListener(view -> {
            LocalDate today = LocalDate.now();
            GiveBack giveBack = new GiveBack(borrow.getMuonId(), borrow.getThuthuId(), String.valueOf(today));
            insertDataGiveBack(giveBack);
            deleteDataBorrow(borrow.getMuonId());
        });
    }

    public void insertDataGiveBack(GiveBack giveBack) {
        ApiGiveBackAdmin.apiGiveBackAdmin.insertDataGiveBackAdmin(giveBack).enqueue(new Callback<GiveBack>() {
            @Override
            public void onResponse(Call<GiveBack> call, Response<GiveBack> response) {
            }
            @Override
            public void onFailure(Call<GiveBack> call, Throwable t) {
                Toast.makeText(SetGiveBackAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteDataBorrow(int id) {
        ApiBorrowAdmin.apiBorrowAdmin.deleteDataBorrowAdmin(id).enqueue(new Callback<Borrow>() {
            @Override
            public void onResponse(Call<Borrow> call, Response<Borrow> response) {
                Toast.makeText(SetGiveBackAdminActivity.this, "Xử Lí Thành Công", Toast.LENGTH_SHORT).show();
                switchActivity();
            }
            @Override
            public void onFailure(Call<Borrow> call, Throwable t) {
                Toast.makeText(SetGiveBackAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void switchActivity(){
        Intent intent = new Intent(SetGiveBackAdminActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }
}