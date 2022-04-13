package com.example.vido_manager_library.Fragment.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_SET_GIVE_BACK;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vido_manager_library.Activities.Admin.SetGiveBackAdminActivity;
import com.example.vido_manager_library.Adapters.BorrowAdapter;
import com.example.vido_manager_library.Interface.ApiBorrowAdmin;
import com.example.vido_manager_library.Models.Borrow;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * code by Yuna
 */
public class ManagerBorrowFragment extends Fragment {

    View view;
    private List<Borrow> mListBorrowAdmin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manager_borrow, container, false);
        mListBorrowAdmin = new ArrayList<>();

        RecyclerView listBooksScreen = view.findViewById(R.id.rec_manager_borrow);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listBooksScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listBooksScreen.addItemDecoration(itemDecoration);
        getListJS(listBooksScreen);
        return view;
    }

    private void getListJS(RecyclerView listBooksScreen) {
        ApiBorrowAdmin.apiBorrowAdmin.covertBorrowkAdmin().enqueue(new Callback<List<Borrow>>() {
            @Override
            public void onResponse(Call<List<Borrow>> call, Response<List<Borrow>> response) {
                mListBorrowAdmin = response.body();
                BorrowAdapter borrowAdapter = new BorrowAdapter(ManagerBorrowFragment.this, mListBorrowAdmin, this::onClickGoToDetail);
                listBooksScreen.setAdapter(borrowAdapter);
            }
            private void onClickGoToDetail(Borrow borrow) {
                Intent intent = new Intent(getActivity(), SetGiveBackAdminActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_SET_GIVE_BACK, borrow);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<List<Borrow>> call, Throwable t) {
                Toast.makeText(getActivity(), NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });

    }
}