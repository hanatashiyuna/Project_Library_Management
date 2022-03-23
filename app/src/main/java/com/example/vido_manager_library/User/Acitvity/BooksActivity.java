package com.example.vido_manager_library.User.Acitvity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Models.Capture;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    RecyclerView recLikeBooks;
    FloatingActionButton scanner_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        //scanner
        scanner_btn = findViewById(R.id.fab);

        scanner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khoi tao intent
                IntentIntegrator intentIntegrator = new IntentIntegrator(BooksActivity.this);
                //Set prompt text
                intentIntegrator.setPrompt("For flash use volume up key");
                //Set beep
                intentIntegrator.setBeepEnabled(true);
                //locked oritation
                intentIntegrator.setOrientationLocked(true);
                //set capture activity
                intentIntegrator.setCaptureActivity(Capture.class);
                //initiate scan
                intentIntegrator.initiateScan();
            }
        });

        //init book
        recLikeBooks = (RecyclerView) findViewById(R.id.recyclerViewLikeBooks);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set Item book with GridLayout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recLikeBooks.setLayoutManager(gridLayoutManager);
        BooksAdapters booksAdapters = new BooksAdapters(this, getListBooks());
        recLikeBooks.setAdapter(booksAdapters);

        //Set navigation Fragment bottom
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.books);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.books:
                        return true;
                    case R.id.borrowBooks:
                        startActivity(new Intent(getApplicationContext(), BorrowBooksActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.infomation:
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private List<HomeHorModels> getListBooks() {
        List<HomeHorModels> list = new ArrayList<>();
        //First
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        // Second
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));

        //Third
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));

        return list;
    }

    //scanner
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check condition
        if(intentResult.getContents() != null){
            /**
             * khi content = null: khoi tao alert dialog
             */

            AlertDialog.Builder builder = new AlertDialog.Builder(BooksActivity.this);
            builder.setTitle("Kết quả");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }else{
            /**
             * khi content ko null: in ra 1 doan hoi thoai
             */
            Toast.makeText(getApplication(), "Bạn vẫn chưa scan thứ gì...", Toast.LENGTH_SHORT).show();
        }
    }
}


