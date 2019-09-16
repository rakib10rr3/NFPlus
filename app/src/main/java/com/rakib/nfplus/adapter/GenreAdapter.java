package com.rakib.nfplus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.chip.Chip;
import com.rakib.nfplus.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.MyViewHolder> {

    private Context mContext;
    List<String> genreArrayList;
    int mode;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Chip chip;

        public MyViewHolder(View view) {
            super(view);
            chip = view.findViewById(R.id.detail_chip);
        }
    }


    public GenreAdapter(Context mContext, List<String> genres, int mode) {
        this.mContext = mContext;
        this.genreArrayList = genres;
        this.mode = mode;
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = null;

        if (mode == 1)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_chip_item, parent, false);
        else itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_chip_item_series, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final String genre = genreArrayList.get(position);
        holder.chip.setText(genre);

    }


    @Override
    public int getItemCount() {
        return genreArrayList.size();
    }
}