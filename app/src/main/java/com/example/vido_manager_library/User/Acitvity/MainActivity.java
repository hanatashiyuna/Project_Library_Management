package com.example.vido_manager_library.User.Acitvity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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

public class MainActivity extends AppCompatActivity {

    RecyclerView homeHorizontalRec, homeHorizontalRec2, homeHorizontalRec3, homeHorizontalRec4;
    List<HomeHorModels> bookList;
    BooksAdapters booksAdapters;
    ImageView user_detail_circle;
    FloatingActionButton scanner_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onInit();
        //scanner

        scanner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khoi tao intent
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
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

        //detail user - thong tin sinh vien

        user_detail_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
                startActivity(intent);
            }
        });

        //cardView home
        fakeData();

        booksAdapters = new BooksAdapters(this, bookList);//context to activity => getApplication() to this
        //Sách nổi bật
        homeHorizontalRec.setAdapter(booksAdapters);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);

        //Sách Giải Trí
        homeHorizontalRec2.setAdapter(booksAdapters);
        homeHorizontalRec2.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec2.setHasFixedSize(true);

        //Sách chuyên ngành
        homeHorizontalRec3.setAdapter(booksAdapters);
        homeHorizontalRec3.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec3.setHasFixedSize(true);

        //test
        homeHorizontalRec4.setAdapter(booksAdapters);
        homeHorizontalRec4.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec4.setHasFixedSize(true);

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

    //hàm fake data
    public void fakeData(){
        //cardView home
        bookList = new ArrayList<>();

        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));

    }
    //hàm gộp biến
    public void onInit(){
        //scanner
        scanner_btn = findViewById(R.id.fab);
        //detail user - thong tin sinh vien
        user_detail_circle = findViewById(R.id.user_circle);
        //cardView home
        homeHorizontalRec = findViewById(R.id.home_hor_rec);
        homeHorizontalRec2 = findViewById(R.id.home_hor_rec2);
        homeHorizontalRec3 = findViewById(R.id.home_hor_rec3);
        homeHorizontalRec4 = findViewById(R.id.home_hor_rec4);
    }

    //scanner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check condition
        if(intentResult.getContents() != null){
            /**
             * khi content = null: khoi tao alert dialog
             */

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

    //chuyển fragment replaceFragment(new fragment_name);
    /**
     * private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
     */
}