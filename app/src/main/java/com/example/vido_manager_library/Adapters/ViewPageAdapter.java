package com.example.vido_manager_library.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vido_manager_library.Fragment.Admin.AdminAuthorFrament;
import com.example.vido_manager_library.Fragment.Admin.AdminBookFrament;
import com.example.vido_manager_library.Fragment.Admin.AdminCategoryFrament;
import com.example.vido_manager_library.Fragment.Admin.AdminPCFrament;
import com.example.vido_manager_library.Fragment.Admin.AdminPositionFrament;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new AdminCategoryFrament();
            case 2:
                return new AdminPositionFrament();
            case 3:
                return new AdminPCFrament();
            case 4:
                return new AdminBookFrament();
            default:
                return new AdminAuthorFrament();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
