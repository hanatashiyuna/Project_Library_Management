package com.example.vido_manager_library.Admin.Activities;

import android.os.Bundle;

import com.example.vido_manager_library.R;
import com.example.vido_manager_library.databinding.ActivityHomeAdminBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeAdminActivity extends AppCompatActivity {

    private ActivityHomeAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfigurationAdmin = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build();
//        NavController navControllerAdmin = Navigation.findNavController(HomeAdminActivity.this, R.id.nav_host_fragment_activity_bottom_navigation);
////        NavigationUI.setupActionBarWithNavController(HomeAdminActivity.this, navControllerAdmin, appBarConfigurationAdmin);
////        NavigationUI.setupWithNavController(binding.navView, navControllerAdmin);

    }

}