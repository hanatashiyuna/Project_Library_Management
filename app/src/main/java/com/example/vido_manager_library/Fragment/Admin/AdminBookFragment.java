package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * fragment for admin as home page, book list
 * code by Yuna
 */

public class AdminBookFragment extends Fragment {
    /**khởi tạo arraylist*/
    List<Books> mListBooksAdmin;
    ImageView btnAddBook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_books, container, false);
        /** gọi array list */
        mListBooksAdmin = new ArrayList<>();
        //set button add book
        btnAddBook = view.findViewById(R.id.addBook);
        btnAddBook.setOnClickListener(view1 -> showDialog());

        RecyclerView listBookScreen = view.findViewById(R.id.listview_book);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        listBookScreen.setLayoutManager(gridLayoutManager);
        /** Gọi method và truyền PARAMETER RecyclerView*/
        getListJS(listBookScreen);
        return view;
    }

    /**Lấy dữ liệu từ api*/
    private void getListJS(RecyclerView listBookScreen) {
        //Gọi interface api trùng với api cần
        ApiBookAdmin.apiBookAdmin.covertBookAdmin().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                mListBooksAdmin = response.body();
                BooksAdapters booksAdapters = new BooksAdapters(getActivity(), mListBooksAdmin, this::onClickGoToDetail);
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

    }

    //dialog add book
    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getLayoutInflater();
        View viewDf = inflater.inflate(R.layout.dialog_add_book, null);

        final EditText edIDBook = viewDf.findViewById(R.id.df_add_book_id);
        final EditText edNameBook = viewDf.findViewById(R.id.df_add_book_name);
        final EditText edIDAuthor = viewDf.findViewById(R.id.df_add_book_idAuthor);
        final EditText edIDCategory = viewDf.findViewById(R.id.df_add_book_idCategory);
        final EditText edYear = viewDf.findViewById(R.id.df_add_book_year);
        final EditText edIDPublisher = viewDf.findViewById(R.id.df_add_book_idPC);
        final EditText edAmount = viewDf.findViewById(R.id.df_add_book_amount);
        final EditText edPosition = viewDf.findViewById(R.id.df_add_book_position);

        builder.setView(viewDf);
        builder.setTitle("Add Book").setPositiveButton("Save", (dialogInterface, i) -> {
            int idBook = Integer.parseInt(edIDBook.getText().toString());
            String nameBook = edNameBook.getText().toString();
            int idAuthor = Integer.parseInt(edIDAuthor.getText().toString());
            int idCategory = Integer.parseInt(edIDCategory.getText().toString());
            String year = edYear.getText().toString();
            int publisher = Integer.parseInt(edIDPublisher.getText().toString());
            int amount = Integer.parseInt(edAmount.getText().toString());
            int position = Integer.parseInt(edPosition.getText().toString());

            mListBooksAdmin.add(new Books(idBook, nameBook, idAuthor, idCategory, publisher, year, amount, position));
        }).setNegativeButton("Cancel", (dialogInterface, i) -> {

        });
        builder.show();
    }
}