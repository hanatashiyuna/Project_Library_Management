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
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.AuthorDetailActivity;
import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * fragment for admin as home page, author
 * code by Yuna*/

public class AdminAuthorFragment extends Fragment {

    List<Authors> mListAuthorAdmin;
    ImageView btnAddAuthor;
    SearchView searchViewAuthor;
    //private static String searchAuthor = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_authors, container, false);
        mListAuthorAdmin = new ArrayList<>();
        //set button add author
        btnAddAuthor = view.findViewById(R.id.addAuthor);
        btnAddAuthor.setOnClickListener(view1 -> showDialog());



        RecyclerView listAuthorScreen = view.findViewById(R.id.listview_author);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listAuthorScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAuthorScreen.addItemDecoration(itemDecoration);

        getListJS(listAuthorScreen);

        searchViewAuthor = view.findViewById(R.id.search_inputAuthor);
        /*searchViewAuthor.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override public boolean onQueryTextChange(String newText) {
                //searchAuthor = newText;
                //getListJS(listAuthorScreen, searchAuthor);
                return true;
            }
        });*/

        return view;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getLayoutInflater();
        View viewDf = inflater.inflate(R.layout.dialog_add_author, null);

        final EditText edNameAuthor = viewDf.findViewById(R.id.df_add_nameAuthor);
        final EditText edBirthdayAuthor = viewDf.findViewById(R.id.df_add_birthdayAuthor);

        builder.setView(viewDf);
        builder.setTitle("Thêm Tác Giả").setPositiveButton("Lưu", (dialogInterface, i) -> {
            String nameAuthor = edNameAuthor.getText().toString().trim();
            String birthdayAuthor = edBirthdayAuthor.getText().toString().trim();

            if (!nameAuthor.equals("") || !birthdayAuthor.equals("")) {
                Authors authors = new Authors(nameAuthor, birthdayAuthor);

                ApiAuthorAdmin.apiauthoradmin.insertDataAuthorAdmin(authors).enqueue(new Callback<Authors>() {
                    @Override
                    public void onResponse(Call<Authors> call, Response<Authors> response) {
                        Toast.makeText(getActivity(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<Authors> call, Throwable t) {
                        Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                Toast.makeText(getActivity(), "Thiếu Tên Tác Giả Hoặc Ngày Sinh", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Hủy", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.show();
    }

    /*private void getListJS(RecyclerView listBookScreen, String search) {
        //Gọi interface api trùng với api cần
        ApiService.apiService.convertAuthor(search).enqueue(new Callback<List<Authors>>() {
            @Override
            public void onResponse(Call<List<Authors>> call, Response<List<Authors>> response) {
                mListAuthorAdmin = response.body();
                AuthorAdapter authorAdapter = new AuthorAdapter(AdminAuthorFragment.this, mListAuthorAdmin, this::onClickGoToDetail);
                listBookScreen.setAdapter(authorAdapter);
            }
            private void onClickGoToDetail(Authors authors) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("book_information", authors);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<List<Authors>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }*/

    private void getListJS(RecyclerView listAuthorScreen) {
        ApiAuthorAdmin.apiauthoradmin.covertAuthorAdmin().enqueue(new Callback<List<Authors>>() {
            @Override
            public void onResponse(Call<List<Authors>> call, Response<List<Authors>> response) {
                mListAuthorAdmin = response.body();
                AuthorAdapter authorAdapters = new AuthorAdapter(AdminAuthorFragment.this, mListAuthorAdmin, this::onClickGoToDetail);
                listAuthorScreen.setAdapter(authorAdapters);
            }
            private void onClickGoToDetail(Authors authors) {
                Intent intent = new Intent(getActivity(), AuthorDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("books_informationAuthor", authors);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<List<Authors>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }
}