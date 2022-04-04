package com.example.vido_manager_library.Activities.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        TextView nameBook = findViewById(R.id.nameBook);
        TextView nameAuthor = findViewById(R.id.nameAuthor);
        ImageView imgBook = findViewById(R.id.img_book);
        ImageView back = findViewById(R.id.back);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        HomeHorModels homeHorModels = (HomeHorModels) bundle.get("book_information");
        nameBook.setText(homeHorModels.getBookName());
        imgBook.setImageResource(homeHorModels.getImage());

        back.setOnClickListener(view -> switchActivity());
    }
    public void switchActivity(){
        Intent intent = new Intent(BookDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}