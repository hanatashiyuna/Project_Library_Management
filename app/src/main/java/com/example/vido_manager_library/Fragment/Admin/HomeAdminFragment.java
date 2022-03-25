package com.example.vido_manager_library.Fragment.Admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Adapters.ViewPageAdapter;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeAdminFragment extends Fragment {

    private View view;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private ViewPageAdapter viewPageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home_admin, container, false);
        //get id for Tab and View
        mTabLayout = (TabLayout) view.findViewById(R.id.admin_AddInfor);
        mViewPager = (ViewPager2) view.findViewById(R.id.admin_viewpagerAddInfor);

        viewPageAdapter = new ViewPageAdapter(HomeAdminFragment.this);
        mViewPager.setAdapter(viewPageAdapter);

        getTabView();

        return view;
    }

    public void getTabView(){
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