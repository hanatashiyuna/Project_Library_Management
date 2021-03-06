package com.example.vido_manager_library.Fragment.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_PUBLISHER_DETAIL;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Activities.Admin.PublisherDetailActivity;
import com.example.vido_manager_library.Adapters.PCAdapter;
import com.example.vido_manager_library.Interface.ApiPublishingHouseAdmin;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * fragment for admin as home page, pushing company(pc or psc)
 * code by Yuna
 */
public class AdminPCFragment extends Fragment {
    List<PC> mListPCAdmin;
    ImageView btnAddPC;
    SearchView searchViewPc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_pc, container, false);
        mListPCAdmin = new ArrayList<>();
        //set button add pushing company
        btnAddPC = view.findViewById(R.id.addPushingCompany);
        btnAddPC.setOnClickListener(view1 -> showDialog());

        RecyclerView listPCScreen = view.findViewById(R.id.listview_pc);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listPCScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listPCScreen.addItemDecoration(itemDecoration);
        getListJS(listPCScreen);
        searchViewPc = view.findViewById(R.id.search_inputpc);
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
                Intent intent = new Intent(getActivity(), PublisherDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_PUBLISHER_DETAIL, pc);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<List<PC>> call, Throwable t) {
                Toast.makeText(getActivity(), NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getLayoutInflater();
        View viewDf = inflater.inflate(R.layout.dialog_add_publisher, null);

        final EditText edPublisher = viewDf.findViewById(R.id.df_add_namePublisher);
        final EditText edAddress = viewDf.findViewById(R.id.df_add_address);
        final EditText edEmail = viewDf.findViewById(R.id.df_add_email);
        final EditText edRepresentative = viewDf.findViewById(R.id.df_add_representative);

        builder.setView(viewDf);
        builder.setTitle("Th??m T??c Gi???").setPositiveButton("L??u", (dialogInterface, i) -> {
            String nameAuthor = edPublisher.getText().toString().trim();
            String address = edAddress.getText().toString().trim();
            String email = edEmail.getText().toString().trim();
            String representative = edRepresentative.getText().toString().trim();

            if (!nameAuthor.equals("") || !address.equals("") || !email.equals("") || !representative.equals("")) {
                PC publisher = new PC(nameAuthor, address, email, representative);

                ApiPublishingHouseAdmin.apiPublishingHouseAdmin.insertDataPublishingHouseAdmin(publisher).enqueue(new Callback<PC>() {
                    @Override
                    public void onResponse(Call<PC> call, Response<PC> response) {
                        Toast.makeText(getActivity(), "L??u Th??nh C??ng", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<PC> call, Throwable t) {
                        Toast.makeText(getActivity(), NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                Toast.makeText(getActivity(), "Thi???u T??n T??c Gi??? Ho???c Ng??y Sinh", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("H???y", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.show();
    }
}
