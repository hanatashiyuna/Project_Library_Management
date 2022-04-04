package com.example.vido_manager_library.Activities.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.vido_manager_library.Models.UserDetailModels;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    //RecyclerView informationVerRec;
    List<UserDetailModels> userDetailModelsList;
    //UserDetailAdapters userDetailAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        userDetailModelsList = new ArrayList<>();

        userDetailModelsList.add(new UserDetailModels("Nguyen Van A", "", "? Go Vap", 2006010003, "04/09/2002", "0123456789", 14, ""));
    }

}