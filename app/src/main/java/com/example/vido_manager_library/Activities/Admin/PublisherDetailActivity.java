package com.example.vido_manager_library.Activities.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_PUBLISHER_DETAIL;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Interface.ApiPublishingHouseAdmin;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PublisherDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher_detail);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());

        TextView title_namePublisher = findViewById(R.id.title_namePublisher);
        TextView title_address = findViewById(R.id.title_address);
        TextView title_email = findViewById(R.id.title_email);
        TextView title_last = findViewById(R.id.title_last);

        EditText ed_namePublisher = findViewById(R.id.ed_namePublisher);
        EditText ed_address = findViewById(R.id.ed_address);
        EditText ed_email = findViewById(R.id.ed_email);
        EditText ed_last = findViewById(R.id.ed_last);

        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        if(bundle.containsKey(KEY_PUBLISHER_DETAIL)){
            PC pc = (PC) bundle.get(KEY_PUBLISHER_DETAIL);

            title_namePublisher.setText("Tên Nhà Xuất Bản: ");
            ed_namePublisher.setHint(pc.getTenxuatban());

            title_address.setText("Địa Chỉ: ");
            ed_address.setHint(pc.getDiachi());

            title_email.setText("Email: ");
            ed_email.setHint(pc.getEmail());

            title_last.setText("Người Đại Diện: ");
            ed_last.setHint(pc.getThongtinnguoidaidien());

            btn_repair.setOnClickListener(view -> {
                String namePublisher = ed_namePublisher.getText().toString().trim();
                String address = ed_address.getText().toString().trim();
                String email = ed_email.getText().toString().trim();
                String last = ed_last.getText().toString().trim();

                if(!namePublisher.equals("") && !address.equals("") && !email.equals("") && !last.equals("")){
                    pc.setTenxuatban(namePublisher);
                    pc.setDiachi(address);
                    pc.setEmail(email);
                    pc.setThongtinnguoidaidien(last);
                    ApiPublishingHouseAdmin.apiPublishingHouseAdmin.updateDataPublishingHouseAdmin(pc.getNhaxbID(), pc).enqueue(new Callback<PC>() {
                        @Override
                        public void onResponse(Call<PC> call, Response<PC> response) {
                            Toast.makeText(PublisherDetailActivity.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                            switchActivity();
                        }

                        @Override
                        public void onFailure(Call<PC> call, Throwable t) {
                            Toast.makeText(PublisherDetailActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    Toast.makeText(PublisherDetailActivity.this, "Thiếu Tên Hàng hoặc Số Kệ", Toast.LENGTH_SHORT).show();
                }
            });

            btn_delete.setOnClickListener(view -> ApiPublishingHouseAdmin.apiPublishingHouseAdmin.deleteDataPublishingHouseAdmin(pc.getNhaxbID()).enqueue(new Callback<PC>() {
                @Override
                public void onResponse(Call<PC> call, Response<PC> response) {
                    Toast.makeText(PublisherDetailActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }

                @Override
                public void onFailure(Call<PC> call, Throwable t) {
                    Toast.makeText(PublisherDetailActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
                }
            }));

        }else {
            Toast.makeText(PublisherDetailActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
        }
    }

    public void switchActivity(){
        Intent intent = new Intent(PublisherDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }
}