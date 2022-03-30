package com.example.vido_manager_library.Activities.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vido_manager_library.Activities.Admin.HomeAdminActivity;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;

public class BookAdminDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_admin_detail);

        ImageView imgAdminBook = findViewById(R.id.imgBookAdmin);
        TextView name = findViewById(R.id.nameBook);
        TextView amount = findViewById(R.id.amountBook);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        if(bundle.containsKey("books_informationAuthor")){
            Authors authors = (Authors) bundle.get("books_informationAuthor");
            name.setText(authors.getTentacgia());
            amount.setText(authors.getNgaysinh());
        }else if(bundle.containsKey("book_information")){
            HomeHorModels homeHorModels = (HomeHorModels) bundle.get("book_information");
            name.setText(homeHorModels.getBookName());
            imgAdminBook.setImageResource(homeHorModels.getImage());
            amount.setText(String.valueOf(homeHorModels.getAmountBooks()));
        }

        ImageView back =  findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());

        Button btn_add = findViewById(R.id.btn_add);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);
    }

    public void switchActivity(){
        Intent intent = new Intent(BookAdminDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }
}