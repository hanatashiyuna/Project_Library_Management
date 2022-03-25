package com.example.vido_manager_library.Admin.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ListView;

import com.example.vido_manager_library.Admin.Adapter.ViewPageAdapter;
import com.example.vido_manager_library.Admin.Model.Authors;
import com.example.vido_manager_library.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //get id for Tab and View
        mTabLayout = (TabLayout) findViewById(R.id.admin_AddInfor);
        mViewPager = (ViewPager2) findViewById(R.id.admin_viewpagerAddInfor);

        viewPageAdapter = new ViewPageAdapter(this);
        mViewPager.setAdapter(viewPageAdapter);
        new TabLayoutMediator(mTabLayout, mViewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Tác Giả");
                    break;
                case 1:
                    tab.setText("Thể Loại");
                    break;
                case 2:
                    tab.setText("Vị Trí");
                    break;
                case 3:
                    tab.setText("NXB");
                    break;
                case 4:
                    tab.setText("Sách");
                    break;
            }
        }).attach();
    }
}