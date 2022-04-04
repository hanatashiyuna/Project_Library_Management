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
import com.example.vido_manager_library.Adapters.PCAdapter;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
 * fragment for admin as home page, pushing company(pc or psc)
 */
public class AdminPCFragment extends Fragment {

    ImageView btnAddPC;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_pc, container, false);

        //set button add pushing company
        btnAddPC = view.findViewById(R.id.addPushingCompany);
        btnAddPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RecyclerView listPCScreen = view.findViewById(R.id.listview_pc);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listPCScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listPCScreen.addItemDecoration(itemDecoration);
        PCAdapter pcAdapter = new PCAdapter(this, getListPC(), this::onClickGoToDetail);
        listPCScreen.setAdapter(pcAdapter);
        return view;
    }

    private List<PC> getListPC() {
        List<PC> listPC = new ArrayList<>();
        listPC.add(new PC(1, "PC","? Go Vap","yuna@gmail.com", "abc"));
        listPC.add(new PC(2, "PC","? Go Vap","yuna@gmail.com", "abc"));
        listPC.add(new PC(3, "PC","? Go Vap","yuna@gmail.com", "abc"));
        listPC.add(new PC(4, "PC","? Go Vap","yuna@gmail.com", "abc"));
        listPC.add(new PC(5, "PC","? Go Vap","yuna@gmail.com", "abc"));
        return listPC;
    }

    private void onClickGoToDetail(PC pc) {
        Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("pushing_company", pc);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
