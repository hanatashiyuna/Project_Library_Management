package com.example.vido_manager_library.Activities.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_POSITION_DETAIL;
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

import com.example.vido_manager_library.Interface.ApiPositionAdmin;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PositionDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_detail);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());

        TextView title_namePosition = findViewById(R.id.title_namePosition);
        TextView title_bookSelf = findViewById(R.id.title_bookSelf);

        EditText ed_namePosition = findViewById(R.id.ed_namePosition);
        EditText ed_bookSelf = findViewById(R.id.ed_bookSelf);

        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        if(bundle.containsKey(KEY_POSITION_DETAIL)){
            Positions positions = (Positions) bundle.get(KEY_POSITION_DETAIL);

            title_namePosition.setText("Tên Hàng: ");
            ed_namePosition.setHint(positions.getTenhang());

            title_bookSelf.setText("Số Kệ: ");
            ed_bookSelf.setHint(positions.getSoke());

            btn_repair.setOnClickListener(view -> {
                String namePosition = ed_namePosition.getText().toString().trim();
                String bookSelf = ed_bookSelf.getText().toString().trim();
                if(!namePosition.equals("") && !bookSelf.equals("")){
                    positions.setTenhang(namePosition);
                    positions.setSoke(bookSelf);
                    callApiPosition(positions);
                }else if(namePosition.equals("")){
                    positions.setTenhang(positions.getTenhang());
                    positions.setSoke(bookSelf);
                    callApiPosition(positions);
                }else if(bookSelf.equals("")) {
                    positions.setTenhang(namePosition);
                    positions.setSoke(positions.getSoke());
                    callApiPosition(positions);
                }else {
                    Toast.makeText(PositionDetailActivity.this, "Thiếu Tên Hàng hoặc Số Kệ", Toast.LENGTH_SHORT).show();
                }
            });

            btn_delete.setOnClickListener(view -> ApiPositionAdmin.apiPositionAdmin.deleteDataPositionAdmin(positions.getVitriId()).enqueue(new Callback<Positions>() {
                @Override
                public void onResponse(Call<Positions> call, Response<Positions> response) {
                    Toast.makeText(PositionDetailActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }

                @Override
                public void onFailure(Call<Positions> call, Throwable t) {
                    Toast.makeText(PositionDetailActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
                }
            }));

        }else {
            Toast.makeText(PositionDetailActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
        }
    }

    public void switchActivity(){
        Intent intent = new Intent(PositionDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }

    public void callApiPosition(Positions positions){
        ApiPositionAdmin.apiPositionAdmin.updateDataPositionAdmin(positions.getVitriId(), positions).enqueue(new Callback<Positions>() {
            @Override
            public void onResponse(Call<Positions> call, Response<Positions> response) {
                Toast.makeText(PositionDetailActivity.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                switchActivity();
            }

            @Override
            public void onFailure(Call<Positions> call, Throwable t) {
                Toast.makeText(PositionDetailActivity.this, NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });
    }
}