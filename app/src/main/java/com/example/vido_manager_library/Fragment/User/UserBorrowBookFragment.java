package com.example.vido_manager_library.Fragment.User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vido_manager_library.Adapters.FragmentPagerAdapter;
import com.example.vido_manager_library.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class UserBorrowBookFragment extends Fragment {

    View view;
    private final String[] title = new String[]{"Sách đã mượn", "Sách đã trả"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_borrow_book, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(Objects.requireNonNull(getActivity()));
        viewPager2.setAdapter(fragmentPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(title[position]))).attach();
        return view;
    }
}