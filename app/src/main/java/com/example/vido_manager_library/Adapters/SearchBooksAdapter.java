package com.example.vido_manager_library.Adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Interface.IClickItemBook;
import com.example.vido_manager_library.Interface.IClickItemBooks;
import com.example.vido_manager_library.Interface.IClickItemSearchBooks;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.SearchBooks;
import com.example.vido_manager_library.R;

import java.util.List;

public class SearchBooksAdapter extends RecyclerView.Adapter<SearchBooksAdapter.ViewHolder>{
    Context context;
    Activity activity;
    Fragment fragment;
    List<SearchBooks> list;
    private IClickItemSearchBooks iClickItemSearchBooks;

    //Context to Activity
    public SearchBooksAdapter(Activity activity, List<SearchBooks> list) {
        this.activity = activity;
        this.list = list;
    }

    public SearchBooksAdapter(Activity activity, List<SearchBooks> list, IClickItemSearchBooks iClickItemSearchBooks) {
        this.activity = activity;
        this.list = list;
        this.iClickItemSearchBooks = iClickItemSearchBooks;
    }

    public SearchBooksAdapter(Context context, List<SearchBooks> list) {
        this.context = context;
        this.list = list;
    }

    public SearchBooksAdapter(Fragment fragment, List<SearchBooks> list) {
        this.fragment = fragment;
        this.list = list;
    }

    public SearchBooksAdapter(Fragment fragment, List<SearchBooks> list, IClickItemSearchBooks iClickItemSearchBooks) {
        this.fragment = fragment;
        this.list = list;
        this.iClickItemSearchBooks = iClickItemSearchBooks;
    }



    @NonNull
    @Override
    public SearchBooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchBooksAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchBooksAdapter.ViewHolder holder, int position) {
        SearchBooks searchBooks = list.get(position);
        holder.imageView.setImageResource(R.drawable.androidprogram);
        holder.textView.setText(list.get(position).getTensach());
        if(searchBooks != null){
            holder.cardView.setOnClickListener(view -> iClickItemSearchBooks.onClickItemBooks(searchBooks));
        }else {
            holder.cardView.setOnClickListener(view -> {

            });
        }
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

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
