package com.example.vido_manager_library.Fragment.User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vido_manager_library.BuildConfig;
import com.example.vido_manager_library.R;

public class AboutFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about, container, false);
        TextView version = view.findViewById(R.id.version);
        version.setText(String.format("Beta Version %s", BuildConfig.VERSION_NAME));
        return view;
    }


}