package com.example.vido_manager_library.Fragment.User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vido_manager_library.Adapters.FragmentPagerAdapter;
import com.example.vido_manager_library.R;
import com.google.android.material.tabs.TabLayout;

public class UserBorrowBookFragment extends Fragment {

    View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_borrow_book, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        FragmentPagerAdapter fragmentPagerAdapter= new FragmentPagerAdapter(getParentFragmentManager(), androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentPagerAdapter.addFragment(new BorrowingBooksFragment(), "Borrowing Books");
        fragmentPagerAdapter.addFragment(new ReturnedBooksFragment(), "Returned Books");
        viewPager.setAdapter(fragmentPagerAdapter);
        return view;
    }
}