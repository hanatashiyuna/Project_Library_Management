package com.example.vido_manager_library.Activities.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vido_manager_library.Adapters.FragmentPagerAdapter;
import com.example.vido_manager_library.Fragment.User.BorrowingBooksFragment;
import com.example.vido_manager_library.Fragment.User.ReturnedBooksFragment;
import com.example.vido_manager_library.Models.Capture;
import com.example.vido_manager_library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class BorrowBooksActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    FloatingActionButton scanner_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_books);

        //set fragment layout
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        FragmentPagerAdapter fragmentPagerAdapter= new FragmentPagerAdapter(getSupportFragmentManager(), androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentPagerAdapter.addFragment(new BorrowingBooksFragment(), "Borrowing Books");
        fragmentPagerAdapter.addFragment(new ReturnedBooksFragment(), "Returned Books");
        viewPager.setAdapter(fragmentPagerAdapter);

        //set bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.borrowBooks);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.books:
                        startActivity(new Intent(getApplicationContext(), BooksActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.borrowBooks:
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

        //scanner
        scanner_btn = findViewById(R.id.fab);

        scanner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khoi tao intent
                IntentIntegrator intentIntegrator = new IntentIntegrator(BorrowBooksActivity.this);
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
    }

    //set scan
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check condition
        if(intentResult.getContents() != null){
            /**
             * khi content = null: khoi tao alert dialog
             */

            AlertDialog.Builder builder = new AlertDialog.Builder(BorrowBooksActivity.this);
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