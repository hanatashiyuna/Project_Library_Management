package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.User.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Adapters.BooksAdapter;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Interface.IClickItemBooks;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminBookFrament extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_books, container, false);

        RecyclerView listBookScreen = view.findViewById(R.id.listview_book);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        listBookScreen.setLayoutManager(gridLayoutManager);
        BooksAdapters booksAdapters = new BooksAdapters(this, getListBooks(), this::onClickGoToDetail);
        listBookScreen.setAdapter(booksAdapters);
        return view;
    }

    private List<HomeHorModels> getListBooks() {
        List<HomeHorModels> listBooks = new ArrayList<>();
        listBooks.add(new HomeHorModels(1, 4, 1, 5, 1,R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels(1, 4, 1, 5, 1,R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels(1, 4, 1, 5, 1,R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels(1, 4, 1, 5, 1,R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels(1, 4, 1, 5, 1,R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels(1, 4, 1, 5, 1,R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
        listBooks.add(new HomeHorModels(1, 4, 1, 5, 1,R.drawable.androidprogram, "Android Program", "Tran Minh Tan", "Vu Cong Chi Thien"));
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
