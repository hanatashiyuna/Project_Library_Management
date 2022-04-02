package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vido_manager_library.BuildConfig;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.R;

public class AboutAdminFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_admin, container, false);
        TextView version = view.findViewById(R.id.version);
        version.setText(String.format("Beta version %s", BuildConfig.VERSION_NAME));

        TextView logOut = view.findViewById(R.id.logOut);
        logOut.setOnClickListener(view -> switchActivity());
        return view;
    }

    public void switchActivity(){
        Intent intent = new Intent(getActivity(), StudentLoginActivity.class);
        startActivity(intent);
    }

}