package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.User.BookAdminDetailActivity;
import com.example.vido_manager_library.Activities.User.BookDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Interface.IClickItemAuthor;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminAuthorFrament extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_authors, container, false);

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
        listAuthor.add(new Authors(1, "Tran Minh Tan", "07-09-2002"));
        listAuthor.add(new Authors(1, "Tran Minh Tan", "07-09-2002"));
        listAuthor.add(new Authors(1, "Tran Minh Tan", "07-09-2002"));
        listAuthor.add(new Authors(1, "Tran Minh Tan", "07-09-2002"));
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
