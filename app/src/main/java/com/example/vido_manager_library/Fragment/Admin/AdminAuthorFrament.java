package com.example.vido_manager_library.Fragment.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

public class AdminAuthorFrament extends Fragment {

    private RecyclerView listAuthorScreen;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_admin_authors, container, false);
        listAuthorScreen = view.findViewById(R.id.listview_author);
        listAuthorScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        AuthorAdapter authorAdapters = new AuthorAdapter(this, getListAuthor());
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

}
