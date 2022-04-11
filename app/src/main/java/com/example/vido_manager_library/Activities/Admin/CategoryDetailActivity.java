package com.example.vido_manager_library.Activities.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiCategoryAdmin;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());

        TextView title_nameCategory = findViewById(R.id.title_nameCategory);
        EditText ed_category = findViewById(R.id.ed_category);

        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        if(bundle.containsKey("books_category")){
            Categorys categorys = (Categorys) bundle.get("books_category");

            title_nameCategory.setText("Thể Loại: ");
            ed_category.setHint(categorys.getTentheloai());

            btn_repair.setOnClickListener(view -> {
                String nameCategory = ed_category.getText().toString().trim();
                if(!nameCategory.equals("")){
                    categorys.setTentheloai(nameCategory);
                    ApiCategoryAdmin.apicategoryadmin.updateDataCategoryAdmin(categorys.getTheloaiID(), categorys).enqueue(new Callback<Categorys>() {
                        @Override
                        public void onResponse(Call<Categorys> call, Response<Categorys> response) {
                            Toast.makeText(CategoryDetailActivity.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                            switchActivity();
                        }

                        @Override
                        public void onFailure(Call<Categorys> call, Throwable t) {
                            Toast.makeText(CategoryDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    Toast.makeText(CategoryDetailActivity.this, "Bạn Không Thể Để Trống", Toast.LENGTH_SHORT).show();
                }
            });

            btn_delete.setOnClickListener(view -> ApiCategoryAdmin.apicategoryadmin.deleteDataCategoryAdmin(categorys.getTheloaiID()).enqueue(new Callback<Categorys>() {
                @Override
                public void onResponse(Call<Categorys> call, Response<Categorys> response) {
                    Toast.makeText(CategoryDetailActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }

                @Override
                public void onFailure(Call<Categorys> call, Throwable t) {
                    Toast.makeText(CategoryDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                }
            }));
        }else {
            Toast.makeText(CategoryDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau", Toast.LENGTH_SHORT).show();
        }
    }

    public void switchActivity(){
        Intent intent = new Intent(CategoryDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }
}