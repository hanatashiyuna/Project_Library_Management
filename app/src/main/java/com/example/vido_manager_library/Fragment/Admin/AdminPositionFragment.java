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
import com.example.vido_manager_library.Adapters.PositionAdapter;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
 * fragment for admin as home, position bookSelf*/
public class AdminPositionFragment extends Fragment {

    ImageView btn_add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_positions, container, false);

        //set button add position
        btn_add = view.findViewById(R.id.addPosition);
        btn_add.setOnClickListener(view1 -> {

        });

        RecyclerView listPositionsScreen = view.findViewById(R.id.listview_positions);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listPositionsScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listPositionsScreen.addItemDecoration(itemDecoration);
        PositionAdapter positionAdapter = new PositionAdapter(this, getListPosition(), this::onClickGoToDetail);
        listPositionsScreen.setAdapter(positionAdapter);
        return view;
    }

    private List<Positions> getListPosition() {
        List<Positions> listPositions = new ArrayList<>();
        listPositions.add(new Positions(1, "A"));
        listPositions.add(new Positions(2, "A"));
        listPositions.add(new Positions(3, "A"));
        listPositions.add(new Positions(4, "A"));
        listPositions.add(new Positions(5, "A"));
        listPositions.add(new Positions(1, "B"));
        return listPositions;
    }

    private void onClickGoToDetail(Positions positions) {
        Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("books_self", positions);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
