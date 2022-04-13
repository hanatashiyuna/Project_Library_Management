package com.example.vido_manager_library.Activities.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_GIVE_BACK;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Interface.ApiBorrowAdmin;
import com.example.vido_manager_library.Interface.ApiLecturers;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Borrow;
import com.example.vido_manager_library.Models.GiveBack;
import com.example.vido_manager_library.Models.UserLectuters;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GiveBackAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_back_admin);

        Intent intent_inforMain = getIntent();
        Bundle bundleInfor = intent_inforMain.getExtras();
        GiveBack giveBack = (GiveBack) bundleInfor.get(KEY_GIVE_BACK);

        TextView sgb_mssv = findViewById(R.id.sgb_mssv);
        TextView sgb_nameStu = findViewById(R.id.sgb_namestu);
        TextView sgb_nameLec = findViewById(R.id.sgb_namelec);
        TextView sgb_dayBorrow = findViewById(R.id.sgb_daygiveback);
        TextView nameBook = findViewById(R.id.namebook);
        TextView codebook = findViewById(R.id.codebook);

        sgb_dayBorrow.setText(String.valueOf(giveBack.getNgaytra()));

        ApiBorrowAdmin.apiBorrowAdmin.covertBorrowSingleAdmin(giveBack.getMuonId()).enqueue(new Callback<Borrow>() {
            @Override
            public void onResponse(Call<Borrow> call, Response<Borrow> response) {
                Borrow borrow = response.body();

                ApiService.apiService.convertSingleUserStu(borrow.getSinhvienId()).enqueue(new Callback<UserStu>() {
                    @Override
                    public void onResponse(Call<UserStu> call, Response<UserStu> response) {
                        UserStu userStu = response.body();
                        sgb_nameStu.setText(String.valueOf(userStu.getTensinhvien()));
                        sgb_mssv.setText(String.valueOf(userStu.getMasosinhvien()));
                    }
                    @Override
                    public void onFailure(Call<UserStu> call, Throwable t) {
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
                    }
                });

            }
            @Override
            public void onFailure(Call<Borrow> call, Throwable t) {
                Toast.makeText(GiveBackAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });

        ApiLecturers.apiLecturers.covertUserSingleLecturers(giveBack.getThuthuId()).enqueue(new Callback<UserLectuters>() {
            @Override
            public void onResponse(Call<UserLectuters> call, Response<UserLectuters> response) {
                UserLectuters userLectuters = response.body();
                sgb_nameLec.setText(String.valueOf(userLectuters.getHoten()));
            }
            @Override
            public void onFailure(Call<UserLectuters> call, Throwable t) {
                Toast.makeText(GiveBackAdminActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });



    }
}