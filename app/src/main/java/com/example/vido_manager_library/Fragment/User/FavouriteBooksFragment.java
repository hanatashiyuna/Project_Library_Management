package com.example.vido_manager_library.Fragment.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vido_manager_library.Activities.User.BookDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavouriteBooksFragment extends Fragment {

    View view;
    List<Books> listFavourite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourite_books, container, false);
        RecyclerView recLikeBooks = view.findViewById(R.id.recyclerViewLikeBooks);
        listFavourite = new ArrayList<>();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recLikeBooks.setLayoutManager(gridLayoutManager);

        getListJS(recLikeBooks);

        return view;
    }

    private void getListJS(RecyclerView listBookScreen) {
        //Gọi interface api trùng với api cần
        ApiBookAdmin.apiBookAdmin.convertBookOriginalAdmin().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                listFavourite = response.body();
                BooksAdapters booksAdapters = new BooksAdapters(getActivity(), listFavourite, this::onClickGoToDetail);
                listBookScreen.setAdapter(booksAdapters);
            }
            private void onClickGoToDetail(Books books) {
                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
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