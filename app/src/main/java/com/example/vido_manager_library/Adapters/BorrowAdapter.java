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

import com.example.vido_manager_library.Activities.Admin.BorrowDetailActivity;
import com.example.vido_manager_library.Interface.IClickItemPositions;
import com.example.vido_manager_library.Models.Borrow;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.R;

import java.util.List;

public class BorrowAdapter extends RecyclerView.Adapter<BorrowAdapter.ViewHolder>{
    //Context context;
    Activity activity;
    Fragment fragment;
    List<Borrow> list;
    IClickItemPositions iClickItemPositions;

    //Context to Activity
    public BorrowAdapter(Activity activity, List<Borrow> list) {
        this.activity = activity;
        this.list = list;
    }

    public BorrowAdapter(Fragment fragment, List<Borrow> list, IClickItemPositions iClickItemPositions) {
        this.fragment = fragment;
        this.list = list;
        this.iClickItemPositions = iClickItemPositions;
    }

    @NonNull
    @Override
    public BorrowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BorrowAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Borrow borrow = list.get(position);
        holder.name_item.setText(list.get(position).getMasosinhvien());
        holder.category_item.setText(String.valueOf(list.get(position).getNgaymuon()));

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
