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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manager_account, container, false);
        RecyclerView recAccount = view.findViewById(R.id.rec_account);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        recAccount.setLayoutManager(new LinearLayoutManager(getActivity()));
        recAccount.addItemDecoration(itemDecoration);

        AuthorAdapter adapter = new AuthorAdapter(this, getListAcc(), this::onClickGoToDetail);
        recAccount.setAdapter(adapter);
        return view;
    }
    public List<Authors> getListAcc(){
        List<Authors> listAccount = new ArrayList<>();
        listAccount.add(new Authors(1, "Yuna", "20/02/2002"));
        listAccount.add(new Authors(1, "Yuna", "20/02/2002"));
        listAccount.add(new Authors(1, "Yuna", "20/02/2002"));
        listAccount.add(new Authors(1, "Yuna", "20/02/2002"));
        return listAccount;
    }

    public void onClickGoToDetail(Authors authors){
        Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("account", authors);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}