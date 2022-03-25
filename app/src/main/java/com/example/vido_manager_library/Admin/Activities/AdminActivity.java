package com.example.vido_manager_library.Admin.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.vido_manager_library.Adapters.ViewPageAdapter;
import com.example.vido_manager_library.Fragment.Admin.HomeAdminFragment;
import com.example.vido_manager_library.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AdminActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //get id for Tab and View
        /*mTabLayout = (TabLayout) findViewById(R.id.admin_AddInfor);
        mViewPager = (ViewPager2) findViewById(R.id.admin_viewpagerAddInfor);

        viewPageAdapter = new ViewPageAdapter();
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
        }).attach();*/
    }
}