package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * fragment for admin as home page, author*/

public class AdminAuthorFragment extends Fragment {
    List<Authors> mListAuthorAdmin;
    ImageView btnAddAuthor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_authors, container, false);
        mListAuthorAdmin = new ArrayList<>();
        //set button add author
        btnAddAuthor = view.findViewById(R.id.addAuthor);
        btnAddAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Log.e("Loi", String.valueOf(mListAuthorAdmin.size()));

        RecyclerView listAuthorScreen = view.findViewById(R.id.listview_author);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);


        listAuthorScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAuthorScreen.addItemDecoration(itemDecoration);

        getListJSAuthor(listAuthorScreen);

        return view;
    }


    private void getListJSAuthor(RecyclerView listAuthorScreen) {
        ApiAuthorAdmin.apiauthoradmin.covertAuthorAdmin().enqueue(new Callback<List<Authors>>() {
            @Override
            public void onResponse(Call<List<Authors>> call, Response<List<Authors>> response) {
                mListAuthorAdmin = response.body();
                AuthorAdapter authorAdapters = new AuthorAdapter(AdminAuthorFragment.this, mListAuthorAdmin, this::onClickGoToDetail);
                listAuthorScreen.setAdapter(authorAdapters);
            }
            private void onClickGoToDetail(Authors authors) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
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
