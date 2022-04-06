package com.example.vido_manager_library.Activities.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Fragment.Admin.AdminAuthorFragment;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.LogSign.StudentGetNewPassActivity;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookAdminDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_admin_detail);

        ImageView imgAdminBook = findViewById(R.id.imgBookAdmin);
        TextView name = findViewById(R.id.nameBook);
        TextView amount = findViewById(R.id.amountBook);
        TextView author = findViewById(R.id.author);
        /**Tiêu đề của file BookAdminDetailActivity
        TextView title_editText2 = findViewById(R.id.title_editText2);
        TextView title_editText3 = findViewById(R.id.title_editText3);
        //Nhận Dữ Liệu
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);*/


        Bundle bundle = getIntent().getExtras();

        /**xu ly btn delete & repair
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);*/

        if(bundle == null){
            return;
        }
        if(bundle.containsKey("books_informationAuthor")){
            Authors authors = (Authors) bundle.get("books_informationAuthor");
            name.setText(String.format("Tên: %s", authors.getTentacgia()));
            amount.setText(String.format("Ngày sinh: %s", authors.getNgaysinh()));
            /**lấy dữ liệu và cách hoạt động của các chức năng
            title_editText2.setText("Tên Tác Giả: ");
            editText2.setHint(authors.getTentacgia());
            title_editText3.setText("Năm Sinh (yyyy-mm-dd): ");
            editText3.setHint(authors.getNgaysinh());
            btn_repair.setOnClickListener(view -> {
                String name_author = editText2.getText().toString().trim();
                String birth_author = editText3.getText().toString().trim();
                if (!String.valueOf(name_author).equals("") && !String.valueOf(birth_author).equals("")) {
                    authors.setTentacgia(name_author);
                    authors.setNgaysinh(birth_author);
                    ApiAuthorAdmin.apiauthoradmin.updateDataAuthorAdmin(authors.getTacgiaId(), authors).enqueue(new Callback<Authors>() {
                        @Override
                        public void onResponse(Call<Authors> call, Response<Authors> response) {
                            Toast.makeText(BookAdminDetailActivity.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                            switchActivity();
                        }
                        @Override
                        public void onFailure(Call<Authors> call, Throwable t) {
                            Toast.makeText(BookAdminDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else {
                    Toast.makeText(BookAdminDetailActivity.this, "Thiếu Tên Tác Giả Hoặc Ngày Sinh", Toast.LENGTH_SHORT).show();

                }
            });
            btn_delete.setOnClickListener(view -> {
                ApiAuthorAdmin.apiauthoradmin.deleteAuthorAdmin(authors.getTacgiaId()).enqueue(new Callback<Authors>() {
                @Override
                public void onResponse(Call<Authors> call, Response<Authors> response) {
                    Toast.makeText(BookAdminDetailActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }
                @Override
                public void onFailure(Call<Authors> call, Throwable t) {
                    Toast.makeText(BookAdminDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                }
            });
            });*/
        }else if(bundle.containsKey("book_information")){
            Books books = (Books) bundle.get("book_information");
            name.setText(String.format("Tên Sách: %s", books.getTensach()));
            imgAdminBook.setImageResource(R.drawable.androidprogram);
            amount.setText(String.format("Số lượng sách: %s", books.getSoban()));
            author.setText(String.format("Tác Giả: %s", books.getTacgiaID()));
        }else if(bundle.containsKey("books_self")){
            Positions positions = (Positions) bundle.get("books_self");
            name.setText(String.format("Hàng: %s", positions.getTenhang()));
            amount.setText(String.format("Vị trí: %s", positions.getVitriId()));
        }else if(bundle.containsKey("pushing_company")){
            PC pc = (PC) bundle.get("pushing_company");
            name.setText(String.format("NXB: %s", pc.getTenxuatban()));
            amount.setText(String.format("ID NXB: %s", pc.getNhaxbID()));
        }else if(bundle.containsKey("books_category")){
            Categorys categorys = (Categorys) bundle.get("books_category");
            name.setText(String.format("Thể Loại: %s", categorys.getTentheloai()));
            amount.setText(String.format("ID Thể Loại: %s", categorys.getTheloaiID()));
        }else if(bundle.containsKey("account")){
            Authors authors = (Authors) bundle.get("account");
            name.setText(String.format("Tên: %s", authors.getTentacgia()));
            amount.setText(String.format("Ngày sinh: %s", authors.getNgaysinh()));
        }

        ImageView back =  findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());


    }

    public void switchActivity(){
        Intent intent = new Intent(BookAdminDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }


}