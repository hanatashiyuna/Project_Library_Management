package com.example.vido_manager_library.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Interface.IClickItemBorrow;
import com.example.vido_manager_library.Interface.IClickItemGiveBack;
import com.example.vido_manager_library.Models.Borrow;
import com.example.vido_manager_library.Models.GiveBack;
import com.example.vido_manager_library.R;

import java.util.List;

public class GiveBackAdapter extends RecyclerView.Adapter<GiveBackAdapter.ViewHolder>{
    //Context context;
    Activity activity;
    Fragment fragment;
    List<GiveBack> list;
    IClickItemGiveBack iClickItemGiveBack;

    //Context to Activity
    public GiveBackAdapter(Activity activity, List<GiveBack> list) {
        this.activity = activity;
        this.list = list;
    }

    public GiveBackAdapter(Fragment fragment, List<GiveBack> list, IClickItemGiveBack iClickItemGiveBack) {
        this.fragment = fragment;
        this.list = list;
        this.iClickItemGiveBack =  iClickItemGiveBack;
    }

    @NonNull
    @Override
    public GiveBackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GiveBackAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GiveBack giveBack = list.get(position);
        holder.name_item.setText(String.valueOf(list.get(position).getMuonId()));
        holder.category_item.setText(String.valueOf(list.get(position).getNgaytra()));
        holder.itemSum.setOnClickListener(view -> iClickItemGiveBack.onClickItemGiveBack(giveBack));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_item;
        TextView category_item;
        LinearLayout itemSum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_item = itemView.findViewById(R.id.name_item);
            category_item = itemView.findViewById(R.id.category_item);
            itemSum = itemView.findViewById(R.id.itemSum);
        }
    }
}
