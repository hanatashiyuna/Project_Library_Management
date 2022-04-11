package com.example.vido_manager_library.Activities.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Fragment.Admin.AdminAuthorFragment;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorDetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);

        //Tiêu đề của file BookAdminDetailActivity
        TextView title_editText2 = findViewById(R.id.title_editText2);
        TextView title_editText3 = findViewById(R.id.title_editText3);
        //Nhận Dữ Liệu
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);


        Bundle bundle = getIntent().getExtras();

        //xu ly btn delete & repair
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);

        if(bundle == null){
            return;
        }
        if(bundle.containsKey("books_informationAuthor")){
            Authors authors = (Authors) bundle.get("books_informationAuthor");
            title_editText2.setText("Tên Tác Giả: ");
            editText2.setHint(authors.getTentacgia());
            title_editText3.setText("Năm Sinh (yyyy-mm-dd): ");
            editText3.setHint(authors.getNgaysinh());
            btn_repair.setOnClickListener(view -> {
                String name_author = editText2.getText().toString().trim();
                String birth_author = editText3.getText().toString().trim();
                if (!name_author.equals("") && !birth_author.equals("")) {
                    authors.setTentacgia(name_author);
                    authors.setNgaysinh(birth_author);
                    ApiAuthorAdmin.apiauthoradmin.updateDataAuthorAdmin(authors.getTacgiaId(), authors).enqueue(new Callback<Authors>() {
                        @Override
                        public void onResponse(Call<Authors> call, Response<Authors> response) {
                            Toast.makeText(AuthorDetailActivity.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                            switchActivity();
                        }
                        @Override
                        public void onFailure(Call<Authors> call, Throwable t) {
                            Toast.makeText(AuthorDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else {
                    Toast.makeText(AuthorDetailActivity.this, "Thiếu Tên Tác Giả Hoặc Ngày Sinh", Toast.LENGTH_SHORT).show();

                }
            });
            btn_delete.setOnClickListener(view -> ApiAuthorAdmin.apiauthoradmin.deleteAuthorAdmin(authors.getTacgiaId()).enqueue(new Callback<Authors>() {
                @Override
                public void onResponse(Call<Authors> call, Response<Authors> response) {
                    Toast.makeText(AuthorDetailActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }
                @Override
                public void onFailure(Call<Authors> call, Throwable t) {
                    Toast.makeText(AuthorDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                }
            }));
        }else {
            Toast.makeText(AuthorDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau", Toast.LENGTH_SHORT).show();
        }

        ImageView back =  findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());


    }

    public void switchActivity(){
        Intent intent = new Intent(AuthorDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }


}