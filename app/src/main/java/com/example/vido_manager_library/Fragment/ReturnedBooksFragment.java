package com.example.vido_manager_library.Fragment;

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


public class ReturnedBooksFragment extends Fragment {

    RecyclerView recReturnedBook;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_returned_books, container, false);
        //set borrowing books
        recReturnedBook = view.findViewById(R.id.returned_book_rec);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        recReturnedBook.setLayoutManager(gridLayoutManager);
        BooksAdapters booksAdapters = new BooksAdapters(this, getListBooks());
        recReturnedBook.setAdapter(booksAdapters);

        return view;
    }
    private List<HomeHorModels> getListBooks() {
        List<HomeHorModels> list = new ArrayList<>();

        list.add(new HomeHorModels(R.drawable.logo, "Sách đã trả", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "Sách đã trả", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "Sách đã trả", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "Sách đã trả", HomeHorModels.TYPE_BOOK_2));
        list.add(new HomeHorModels(R.drawable.logo, "Sách đã trả", HomeHorModels.TYPE_BOOK_2));

        return list;
    }
}