package com.example.vido_manager_library.Fragment.Admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vido_manager_library.Adapters.FragmentPagerAdapter;
import com.example.vido_manager_library.Adapters.FragmentPagerAdminAdapter;
import com.example.vido_manager_library.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class ManagerFragment extends Fragment {

    View view;
    private final String[] admin_title = new String[]{"Sinh Viên Đang Mượn", "Sinh Viên Đã Trả"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manager, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPagerAdmin = view.findViewById(R.id.viewPagerAdmin);

        FragmentPagerAdminAdapter fragmentPagerAdminAdapter = new FragmentPagerAdminAdapter(Objects.requireNonNull(getActivity()));
        viewPagerAdmin.setAdapter(fragmentPagerAdminAdapter);
        new TabLayoutMediator(tabLayout, viewPagerAdmin, ((tab, position) -> tab.setText(admin_title[position]))).attach();
        return view;
    }
}