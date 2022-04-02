package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
/**
 * fragment for admin as home page, book list*/

public class AdminBookFragment extends Fragment {

    ImageView btnAddBook;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_books, container, false);

        //set button add book
        btnAddBook = view.findViewById(R.id.addBook);
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RecyclerView listBookScreen = view.findViewById(R.id.listview_book);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        listBookScreen.setLayoutManager(gridLayoutManager);
        BooksAdapters booksAdapters = new BooksAdapters(this, getListBooks(), this::onClickGoToDetail);
        listBookScreen.setAdapter(booksAdapters);
        return view;
    }

    private List<HomeHorModels> getListBooks() {
        List<HomeHorModels> listBooks = new ArrayList<>();
        listBooks.add(new HomeHorModels("000200", 4, 1, 5, HomeHorModels.TYPE_BOOK_1, R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels("000201", 4, 1, 4, HomeHorModels.TYPE_BOOK_1, R.drawable.androidprogram, "Android Program", "Mavis", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels("000202", 4, 1, 7, HomeHorModels.TYPE_BOOK_1, R.drawable.androidprogram, "Android Program", "Mavis", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels("000199", 4, 1, 5, HomeHorModels.TYPE_BOOK_1, R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels("200200", 4, 1, 1, HomeHorModels.TYPE_BOOK_1, R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels("000204", 4, 1, 3, HomeHorModels.TYPE_BOOK_1, R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels("200202", 4, 1, 3, HomeHorModels.TYPE_BOOK_1, R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        return listBooks;
    }

    private void onClickGoToDetail(HomeHorModels homeHorModels) {
        Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book_information", homeHorModels);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
