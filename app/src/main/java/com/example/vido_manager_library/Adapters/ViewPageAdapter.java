package com.example.vido_manager_library.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vido_manager_library.Fragment.Admin.AdminAuthorFragment;
import com.example.vido_manager_library.Fragment.Admin.AdminBookFragment;
import com.example.vido_manager_library.Fragment.Admin.AdminCategoryFragment;
import com.example.vido_manager_library.Fragment.Admin.AdminPCFragment;
import com.example.vido_manager_library.Fragment.Admin.AdminPositionFragment;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new AdminCategoryFragment();
            case 2:
                return new AdminPositionFragment();
            case 3:
                return new AdminPCFragment();
            case 4:
                return new AdminBookFragment();
            default:
                return new AdminAuthorFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
