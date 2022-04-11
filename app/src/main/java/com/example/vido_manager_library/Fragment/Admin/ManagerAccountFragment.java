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

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManagerAccountFragment extends Fragment {

    View view;
    private List<Authors> mListAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manager_account, container, false);
        mListAccount = new ArrayList<>();
        RecyclerView recAccount = view.findViewById(R.id.rec_account);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        recAccount.setLayoutManager(new LinearLayoutManager(getActivity()));
        recAccount.addItemDecoration(itemDecoration);

        getJs(recAccount);
        return view;
    }

    public void getJs(RecyclerView listAuthorScreen){
        AuthorAdapter adapter = new AuthorAdapter(this, mListAccount, this::onClickGoToDetail);
        listAuthorScreen.setAdapter(adapter);
    }

    public void onClickGoToDetail(Authors authors){
        Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("account", authors);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}