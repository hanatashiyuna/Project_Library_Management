package com.example.vido_manager_library.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vido_manager_library.Fragment.Admin.ManagerBorrowFragment;
import com.example.vido_manager_library.Fragment.Admin.ManagerGiveBackBooksFragment;

public class FragmentPagerAdminAdapter extends FragmentStateAdapter {

    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private final String[] admin_title = new String[]{"Sinh Viên Đang Mượn", "Sinh Viên Đã Trả"};

    public FragmentPagerAdminAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ManagerBorrowFragment();
            case 1:
                return new ManagerGiveBackBooksFragment();
        }
        return new ManagerBorrowFragment();
    }

    @Override
    public int getItemCount() {
        return admin_title.length;
    }
}
