package com.example.vido_manager_library.Activities.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;

public class BookAdminDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_admin_detail);

        TextView name = findViewById(R.id.name);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        Authors authors = (Authors) bundle.get("books_informationAuthor");
        name.setText(authors.getTentacgia());
    }
}