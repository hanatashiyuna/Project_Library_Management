package com.example.vido_manager_library.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vido_manager_library.Fragment.User.BorrowingBooksFragment;
import com.example.vido_manager_library.Fragment.User.ReturnedBooksFragment;

public class FragmentPagerAdapter extends FragmentStateAdapter {

    private final String[] title = new String[]{"borrowing", "returned"};

    public FragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BorrowingBooksFragment();
            case 1:
                return new ReturnedBooksFragment();
        }
        return new BorrowingBooksFragment();
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}
