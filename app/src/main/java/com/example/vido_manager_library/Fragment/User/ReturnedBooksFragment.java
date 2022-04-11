package com.example.vido_manager_library.Fragment.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vido_manager_library.Activities.User.BookDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Models.Books;
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recReturnedBook.setLayoutManager(gridLayoutManager);
        BooksAdapters booksAdapters = new BooksAdapters(getActivity(), getListBooks(), this::onClickGoToDetail);
        recReturnedBook.setAdapter(booksAdapters);

        return view;
    }
    private List<Books> getListBooks() {
        List<Books> list = new ArrayList<>();
        /*list.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        list.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        list.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        list.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        list.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        list.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));*/

        return list;
    }

    private void onClickGoToDetail(Books books) {
        Intent intent = new Intent(getActivity(), BookDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book_information", books);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}