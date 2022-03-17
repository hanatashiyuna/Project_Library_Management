package com.example.vido_manager_library.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.vido_manager_library.Activities.AboutActivity;
import com.example.vido_manager_library.Activities.BooksActivity;
import com.example.vido_manager_library.Activities.BorrowBooksActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;
import com.example.vido_manager_library.UserDetailActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView homeHorizontalRec, homeHorizontalRec2;
    List<HomeHorModels> bookList;
    BooksAdapters booksAdapters;
    ImageView user_detail_circle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //detail user - thong tin sinh vien
        user_detail_circle = findViewById(R.id.user_circle);

        user_detail_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
                startActivity(intent);
            }
        });

        //cardView home
        homeHorizontalRec = findViewById(R.id.home_hor_rec);
        homeHorizontalRec2 = findViewById(R.id.home_hor_rec2);
        bookList = new ArrayList<>();

        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));

        booksAdapters = new BooksAdapters(this, bookList);//context to activity => getApplication() to this
        //Sách chuyên ngành
        homeHorizontalRec.setAdapter(booksAdapters);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);

        //Sách Giải Trí
        homeHorizontalRec2.setAdapter(booksAdapters);
        homeHorizontalRec2.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec2.setHasFixedSize(true);

        //Bottom Menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.books:
                        startActivity(new Intent(getApplicationContext(), BooksActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.borrowBooks:
                        startActivity(new Intent(getApplicationContext(), BorrowBooksActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.infomation:
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}