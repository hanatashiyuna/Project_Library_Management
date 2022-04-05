package com.example.vido_manager_library.Activities.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.R;

public class BookAdminDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_admin_detail);

        ImageView imgAdminBook = findViewById(R.id.imgBookAdmin);
        TextView name = findViewById(R.id.nameBook);
        TextView amount = findViewById(R.id.amountBook);
        TextView author = findViewById(R.id.author);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        if(bundle.containsKey("books_informationAuthor")){
            Authors authors = (Authors) bundle.get("books_informationAuthor");
            name.setText(String.format("Tên: %s", authors.getTentacgia()));
            amount.setText(String.format("Ngày sinh: %s", authors.getNgaysinh()));
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

        //xu ly btn delete & repair
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);

        btn_repair.setOnClickListener(view -> {});
        btn_delete.setOnClickListener(view -> {});
    }

    public void switchActivity(){
        Intent intent = new Intent(BookAdminDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }
}