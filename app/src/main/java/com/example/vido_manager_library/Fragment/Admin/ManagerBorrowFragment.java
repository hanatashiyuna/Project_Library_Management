package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapter;
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
 * code by Yuna
 */
public class ManagerBorrowFragment extends Fragment {

    View view;
    private List<Books> mListBooksAdmin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manager_borrow, container, false);
        mListBooksAdmin = new ArrayList<>();

        RecyclerView listBooksScreen = view.findViewById(R.id.rec_manager_borrow);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listBooksScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listBooksScreen.addItemDecoration(itemDecoration);
        getListJS(listBooksScreen);
        return view;
    }

    private void getListJS(RecyclerView listBooksScreen) {
        ApiBookAdmin.apiBookAdmin.convertBookOriginalAdmin().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                mListBooksAdmin = response.body();
                BooksAdapter booksAdapter = new BooksAdapter(ManagerBorrowFragment.this, mListBooksAdmin, books -> onClickGoToDetail(books));
                listBooksScreen.setAdapter(booksAdapter);
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
}