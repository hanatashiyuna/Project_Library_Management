package com.example.vido_manager_library.Fragment.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vido_manager_library.Activities.User.BookDetailActivity;
import com.example.vido_manager_library.Activities.User.UserDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Home Fragment for Users*/
public class HomeFragment extends Fragment {

    View view;
    RecyclerView homeHorizontalRec, homeHorizontalRec2, homeHorizontalRec3, homeHorizontalRec4;
    List<Books> bookList;
    BooksAdapters booksAdapters;
    ImageView user_detail_circle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        onInit();
        detailUser();

        //Sách nổi bật
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        //Sách Giải Trí
        homeHorizontalRec2.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec2.setHasFixedSize(true);
        //Sách chuyên ngành
        homeHorizontalRec3.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec3.setHasFixedSize(true);
        //test
        homeHorizontalRec4.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec4.setHasFixedSize(true);

        getListJS(homeHorizontalRec);
        getListJS(homeHorizontalRec2);
        getListJS(homeHorizontalRec3);
        getListJS(homeHorizontalRec4);
        return view;
    }

    public void detailUser(){
        user_detail_circle.setOnClickListener(view -> switchActivity());
    }

    public void switchActivity(){
        Intent intent = new Intent(getActivity(), UserDetailActivity.class);
        startActivity(intent);
    }

    //khởi tạo
    public void onInit(){
        bookList = new ArrayList<>();
        user_detail_circle = view.findViewById(R.id.user_circle);
        //cardView home
        homeHorizontalRec = view.findViewById(R.id.home_hor_rec);
        homeHorizontalRec2 = view.findViewById(R.id.home_hor_rec2);
        homeHorizontalRec3 = view.findViewById(R.id.home_hor_rec3);
        homeHorizontalRec4 = view.findViewById(R.id.home_hor_rec4);
    }

    private void getListJS(RecyclerView listBookScreen) {
        //Gọi interface api trùng với api cần
        ApiBookAdmin.apiBookAdmin.convertBookOriginalAdmin().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                bookList = response.body();
                booksAdapters = new BooksAdapters(getActivity(), bookList, this::onClickGoToDetail);
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