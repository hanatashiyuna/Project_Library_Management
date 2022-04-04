package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Adapters.PCAdapter;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiPublishingHouseAdmin;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * fragment for admin as home page, pushing company(pc or psc)
 */
public class AdminPCFragment extends Fragment {
    List<PC> mListPCAdmin;
    ImageView btnAddPC;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_pc, container, false);
        mListPCAdmin = new ArrayList<>();
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
        getListJS(listPCScreen);
        return view;
    }

    private void getListJS(RecyclerView listPCScreen) {
        ApiPublishingHouseAdmin.apiPublishingHouseAdmin.covertPublishingHouseAdmin().enqueue(new Callback<List<PC>>() {
            @Override
            public void onResponse(Call<List<PC>> call, Response<List<PC>> response) {
                mListPCAdmin = response.body();
                PCAdapter pcAdapter = new PCAdapter(AdminPCFragment.this, mListPCAdmin, this::onClickGoToDetail);
                listPCScreen.setAdapter(pcAdapter);
            }
            private void onClickGoToDetail(PC pc) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pushing_company", pc);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<List<PC>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
