package com.example.vido_manager_library.Activities.Admin;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Adapters.BorrowAdapter;
import com.example.vido_manager_library.Adapters.PositionAdapter;
import com.example.vido_manager_library.Fragment.Admin.AdminPositionFragment;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Interface.ApiBorrowAdmin;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Borrow;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.QRCode.Capture;
import com.example.vido_manager_library.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BorrowDetailActivity extends AppCompatActivity {
    Books searchBook;
    List<Borrow> mListBorrow;
    public int IDUserStu;
    public String MSSVUserStu;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_detail);
        Intent intent_inforMain = getIntent();
        Bundle bundleInfor = intent_inforMain.getExtras();
        UserStu userStu = (UserStu) bundleInfor.get("infor_userLogin");

        mListBorrow = new ArrayList<>();

        IDUserStu = userStu.getSinhvienId();
        MSSVUserStu = userStu.getMasosinhvien();
        TextView name_borrow = findViewById(R.id.name_borrow);
        TextView class_borrow = findViewById(R.id.class_borrow);
        TextView id_borrow = findViewById(R.id.id_borrow);
        Button btn_save_borow = findViewById(R.id.btn_save_borow);

        RecyclerView listBorrowScreen = findViewById(R.id.list_view_borrow);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(BorrowDetailActivity.this, DividerItemDecoration.VERTICAL);
        //Tạo list khi chưa có API
        LocalDate today = LocalDate.now();
        mListBorrow.add(new Borrow(1, 1, 1, "2006010004", String.valueOf(today)));

        listBorrowScreen.setLayoutManager(new LinearLayoutManager(BorrowDetailActivity.this));
        listBorrowScreen.addItemDecoration(itemDecoration);
        BorrowAdapter borrowAdapter = new BorrowAdapter(BorrowDetailActivity.this, mListBorrow);
        listBorrowScreen.setAdapter(borrowAdapter);


        name_borrow.setText(userStu.getTensinhvien());
        class_borrow.setText(userStu.getLop());
        id_borrow.setText(String.valueOf(userStu.getMasosinhvien()));

        btn_save_borow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Borrow borrow: mListBorrow) {
                    ApiBorrowAdmin.apiBorrowAdmin.insertDataBorrowAdmin(borrow).enqueue(new Callback<Borrow>() {
                        @Override
                        public void onResponse(Call<Borrow> call, Response<Borrow> response) {

                        }
                        @Override
                        public void onFailure(Call<Borrow> call, Throwable t) {
                            Toast.makeText(BorrowDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                Intent intent = new Intent(BorrowDetailActivity.this, HomeAdminActivity.class);
                startActivity(intent);


            }
        });

        TextView scanner = findViewById(R.id.btn_add_new_borrow);
        scanner.setOnClickListener(view -> {
            //khoi tao intent
            IntentIntegrator intentIntegrator = new IntentIntegrator(BorrowDetailActivity.this);
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
    }
    //scanner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        //check condition
        if(intentResult.getContents() != null){
            String qrcode = intentResult.getContents();

            QrTreatment(qrcode, MSSVUserStu, IDUserStu);

        }else{
            Toast.makeText(getApplication(), "Bạn vẫn chưa scan thứ gì...", Toast.LENGTH_SHORT).show();
        }
    }

    private void QrTreatment(String qrcode, String MSSVUserStu, int IDUserStu) {
        ApiBookAdmin.apiBookAdmin.covertBookSAdmin(qrcode).enqueue(new Callback<Books>() {
            //@RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                searchBook = response.body();
                //LocalDate today = LocalDate.now();
                mListBorrow.add(new Borrow(IDUserStu, 1, searchBook.getSachID(), MSSVUserStu, String.valueOf("2022-04-11")));
            }
            @Override
            public void onFailure(Call<Books> call, Throwable t) {
                Toast.makeText(BorrowDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });
    }


}