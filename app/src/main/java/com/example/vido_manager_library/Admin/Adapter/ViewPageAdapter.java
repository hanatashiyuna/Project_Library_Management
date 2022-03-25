package com.example.vido_manager_library.Admin.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vido_manager_library.Admin.Fragment.AdminAuthorFrament;
import com.example.vido_manager_library.Admin.Fragment.AdminBookFrament;
import com.example.vido_manager_library.Admin.Fragment.AdminCategoryFrament;
import com.example.vido_manager_library.Admin.Fragment.AdminPCFrament;
import com.example.vido_manager_library.Admin.Fragment.AdminPositionFrament;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AdminAuthorFrament();
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
