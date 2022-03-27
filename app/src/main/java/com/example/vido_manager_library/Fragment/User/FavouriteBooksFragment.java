package com.example.vido_manager_library.Fragment.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vido_manager_library.Activities.User.BookDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteBooksFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourite_books, container, false);
        RecyclerView recLikeBooks = view.findViewById(R.id.recyclerViewLikeBooks);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recLikeBooks.setLayoutManager(gridLayoutManager);
        BooksAdapters booksAdapters = new BooksAdapters(getActivity(), getListBooks(), this::onClickGoToDetail);
        recLikeBooks.setAdapter(booksAdapters);

        return view;
    }
    private List<HomeHorModels> getListBooks() {
        List<HomeHorModels> list = new ArrayList<>();
        //First
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.curriculums_android, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_1));
        // Second
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.curriculums_android, "The First Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_2));

        //Third
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_3));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_3));
        list.add(new HomeHorModels(R.drawable.curriculums_android, "The First Book", HomeHorModels.TYPE_BOOK_3));
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_3));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_3));
        list.add(new HomeHorModels(R.drawable.microsoft_firewall_isa_server, "The First Book", HomeHorModels.TYPE_BOOK_3));
        list.add(new HomeHorModels(R.drawable.androidprogram, "The First Book", HomeHorModels.TYPE_BOOK_3));

        return list;
    }

    private void onClickGoToDetail(HomeHorModels homeHorModels) {
        Intent intent = new Intent(getActivity(), BookDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book_information", homeHorModels);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}