package com.example.vido_manager_library.Fragment.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vido_manager_library.Activities.User.AboutActivity;
import com.example.vido_manager_library.Activities.User.UserDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Home Fragment for Users*/
public class HomeFragment extends Fragment {

    View view;
    RecyclerView homeHorizontalRec, homeHorizontalRec2, homeHorizontalRec3, homeHorizontalRec4;
    List<HomeHorModels> bookList;
    BooksAdapters booksAdapters;
    ImageView user_detail_circle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        onInit();
        detailUser();
        fakeData();

        booksAdapters = new BooksAdapters(this, bookList);//context to activity => getApplication() to this
        //Sách nổi bật
        homeHorizontalRec.setAdapter(booksAdapters);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);

        //Sách Giải Trí
        homeHorizontalRec2.setAdapter(booksAdapters);
        homeHorizontalRec2.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec2.setHasFixedSize(true);

        //Sách chuyên ngành
        homeHorizontalRec3.setAdapter(booksAdapters);
        homeHorizontalRec3.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec3.setHasFixedSize(true);

        //test
        homeHorizontalRec4.setAdapter(booksAdapters);
        homeHorizontalRec4.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec4.setHasFixedSize(true);

        return view;
    }

    public void detailUser(){
        user_detail_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity();
            }
        });
    }

    public void switchActivity(){
        Intent intent = new Intent(getActivity(), UserDetailActivity.class);
        startActivity(intent);
    }

    //hàm gộp biến
    public void onInit(){
        user_detail_circle = view.findViewById(R.id.user_circle);
        //cardView home
        homeHorizontalRec = view.findViewById(R.id.home_hor_rec);
        homeHorizontalRec2 = view.findViewById(R.id.home_hor_rec2);
        homeHorizontalRec3 = view.findViewById(R.id.home_hor_rec3);
        homeHorizontalRec4 = view.findViewById(R.id.home_hor_rec4);
    }

    public void fakeData(){
        //cardView home
        bookList = new ArrayList<>();

        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));
        bookList.add(new HomeHorModels(R.drawable.logo, "CDVD Book"));

    }

}