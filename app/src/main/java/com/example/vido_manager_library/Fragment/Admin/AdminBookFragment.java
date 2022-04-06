package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/*
 * fragment for admin as home page, book list*/

public class AdminBookFragment extends Fragment {
    /**khởi tạo arraylist
    List<Books> mListBooksAdmin;*/

    ImageView btnAddBook;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_books, container, false);
        /**gọi arraylist vào chương trình
        mListBooksAdmin = new ArrayList<>();*/
        //set button add book
        btnAddBook = view.findViewById(R.id.addBook);
        btnAddBook.setOnClickListener(view1 -> {

        });

        RecyclerView listBookScreen = view.findViewById(R.id.listview_book);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        listBookScreen.setLayoutManager(gridLayoutManager);
        /**Gọi phương thức và truyền tham số RecyclerView
        getListJS(listBookScreen);*/
        return view;
    }

    private List<Books> getListBooks() {
        List<Books> listBooks = new ArrayList<>();
        listBooks.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        listBooks.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        listBooks.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        listBooks.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        listBooks.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        listBooks.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        listBooks.add(new Books(202,"Android Program", 1, 5, 3, "2003", 5, 1));
        return listBooks;
    }


    /**Lấy dữ liệu từ api
    private void getListJS(RecyclerView listBookScreen) {
        //Gọi interface api trùng với api mình cần
        ApiBookAdmin.apiBookAdmin.covertBookAdmin().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                mListBooksAdmin = response.body();
                BooksAdapters booksAdapters = new BooksAdapters(getActivity(),mListBooksAdmin , this::onClickGoToDetail);
                listBookScreen.setAdapter(booksAdapters);
            }
            private void onClickGoToDetail(Books books) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("book_information", books);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }*/
}