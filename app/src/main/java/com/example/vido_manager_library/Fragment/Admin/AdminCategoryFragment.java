package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Adapters.CategoryAdapter;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiCategoryAdmin;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminCategoryFragment extends Fragment {
    List<Categorys> mListCategoryAdmin;
    ImageView btn_add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_categories, container, false);
        mListCategoryAdmin = new ArrayList<>();
        //set button add category
        btn_add = view.findViewById(R.id.addCategory);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RecyclerView listCategoryScreen = view.findViewById(R.id.listview_category);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listCategoryScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listCategoryScreen.addItemDecoration(itemDecoration);
        getListJSCategory(listCategoryScreen);

        return view;
    }

    private void getListJSCategory(RecyclerView listCategoryScreen) {
        ApiCategoryAdmin.apicategoryadmin.covertCategoryAdmin().enqueue(new Callback<List<Categorys>>() {
            @Override
            public void onResponse(Call<List<Categorys>> call, Response<List<Categorys>> response) {
                mListCategoryAdmin = response.body();
                CategoryAdapter categoryAdapter = new CategoryAdapter(AdminCategoryFragment.this, mListCategoryAdmin, this::onClickGoToDetail);
                listCategoryScreen.setAdapter(categoryAdapter);
            }
            private void onClickGoToDetail(Categorys categorys) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("books_category", categorys);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<List<Categorys>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
