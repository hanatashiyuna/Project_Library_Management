package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Adapters.CategoryAdapter;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminCategoryFragment extends Fragment {

    ImageView btn_add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_categories, container, false);

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
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, getListCategories(), this::onClickGoToDetail);
        listCategoryScreen.setAdapter(categoryAdapter);
        return view;
    }

    private List<Categorys> getListCategories() {
        List<Categorys> listCategories = new ArrayList<>();
        listCategories.add(new Categorys(1, "Tin Học"));
        listCategories.add(new Categorys(2, "Ngôn Ngữ Học"));
        listCategories.add(new Categorys(3, "Cơ Khí"));
        listCategories.add(new Categorys(4, "Mạng"));
        listCategories.add(new Categorys(5, "Đồ Họa"));
        listCategories.add(new Categorys(6, "Chăm Sóc Sắc Đẹp"));
        return listCategories;
    }

    private void onClickGoToDetail(Categorys categorys) {
        Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("books_category", categorys);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
