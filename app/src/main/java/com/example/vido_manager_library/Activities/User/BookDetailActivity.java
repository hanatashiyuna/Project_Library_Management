package com.example.vido_manager_library.Activities.User;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_USER_BOOK_DETAIL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.R;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        TextView nameBook = findViewById(R.id.nameBook);
        TextView codeBook = findViewById(R.id.codeBook);
        ImageView imgBook = findViewById(R.id.img_book);
        ImageView back = findViewById(R.id.back);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Books books = (Books) bundle.get(KEY_USER_BOOK_DETAIL);
        nameBook.setText(books.getTensach());
        imgBook.setImageResource(R.drawable.androidprogram);
        codeBook.setText(books.getMasach());

        back.setOnClickListener(view -> switchActivity());
    }
    public void switchActivity(){
        Intent intent = new Intent(BookDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}