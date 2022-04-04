package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * fragment for admin as home page, author*/

public class AdminAuthorFragment extends Fragment {

    ImageView btnAddAuthor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_authors, container, false);

        //set button add author
        btnAddAuthor = view.findViewById(R.id.addAuthor);
        btnAddAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RecyclerView listAuthorScreen = view.findViewById(R.id.listview_author);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listAuthorScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAuthorScreen.addItemDecoration(itemDecoration);
        AuthorAdapter authorAdapters = new AuthorAdapter(this, getListAuthor(), this::onClickGoToDetail);
        listAuthorScreen.setAdapter(authorAdapters);
        return view;
    }

    private List<Authors> getListAuthor() {
        List<Authors> listAuthor = new ArrayList<>();
        listAuthor.add(new Authors(1, "Tran Minh Tan", "07-09-2002"));
        listAuthor.add(new Authors(2, "Tran Minh Tan", "07-09-2002"));
        listAuthor.add(new Authors(3, "Tran Minh Tan", "07-09-2002"));
        listAuthor.add(new Authors(4, "Tran Minh Tan", "07-09-2002"));
        listAuthor.add(new Authors(5, "Tran Minh Tan", "07-09-2002"));
        return listAuthor;
    }

    private void onClickGoToDetail(Authors authors) {
        Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("books_informationAuthor", authors);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}