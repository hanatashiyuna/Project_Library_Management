package com.example.vido_manager_library.Fragment.User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        BooksAdapters booksAdapters = new BooksAdapters(this, getListBooks());
        recLikeBooks.setAdapter(booksAdapters);

        return view;
    }
    private List<HomeHorModels> getListBooks() {
        List<HomeHorModels> list = new ArrayList<>();
        //First
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        list.add(new HomeHorModels(R.drawable.logo, "The First Book", HomeHorModels.TYPE_BOOK_1));
        // Second
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Second Book", HomeHorModels.TYPE_BOOK_2));

        //Third
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "The Third Book", HomeHorModels.TYPE_BOOK_2));

        return list;
    }
}