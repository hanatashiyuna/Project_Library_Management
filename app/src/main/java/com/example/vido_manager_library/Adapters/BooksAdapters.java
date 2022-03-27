package com.example.vido_manager_library.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.User.BookDetailActivity;
import com.example.vido_manager_library.Activities.User.InformationActivity;
import com.example.vido_manager_library.Activities.User.UserDetailActivity;
import com.example.vido_manager_library.Interface.IClickItemBook;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;

import java.util.List;

public class BooksAdapters extends RecyclerView.Adapter<BooksAdapters.ViewHolder> {

    Context context;
    Activity activity;
    Fragment fragment;
    List<HomeHorModels> list;
    private IClickItemBook iClickItemBook;

    //Context to Activity
    public BooksAdapters(Activity activity, List<HomeHorModels> list) {
        this.activity = activity;
        this.list = list;
    }

    public BooksAdapters(Activity activity, List<HomeHorModels> list, IClickItemBook iClickItemBook) {
        this.activity = activity;
        this.list = list;
        this.iClickItemBook = iClickItemBook;
    }

    public BooksAdapters(Context context, List<HomeHorModels> list) {
        this.context = context;
        this.list = list;
    }

    public BooksAdapters(Fragment fragment, List<HomeHorModels> list) {
        this.fragment = fragment;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeHorModels homeModels = list.get(position);
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getBookName());
        holder.cardView.setOnClickListener(view -> {
            iClickItemBook.onClickItemBook(homeModels);
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.book_img);
            textView = itemView.findViewById(R.id.book_name);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
