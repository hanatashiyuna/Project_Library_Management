package com.example.vido_manager_library.User.Acitvity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vido_manager_library.Adapters.UserDetailAdapters;
import com.example.vido_manager_library.Models.UserDetailModels;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    RecyclerView informationVerRec;
    List<UserDetailModels> userDetailModelsList;
    UserDetailAdapters userDetailAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        onInit();

        //data test
        userDetailModelsList = new ArrayList<>();

        userDetailModelsList.add(new UserDetailModels("Nguyen Van A", "14THDH", "? Go Vap", 2006010003, "04/09/2002", "0123456789", 14, "CNTT"));
//        userDetailAdapters = new UserDetailAdapters(InformationActivity.this, userDetailModelsList);
//
//        informationVerRec.setAdapter(userDetailAdapters);
//        informationVerRec.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
//        informationVerRec.setHasFixedSize(true);
    }

    public void onInit(){
        informationVerRec = findViewById(R.id.information_ver_rec);
    }
}