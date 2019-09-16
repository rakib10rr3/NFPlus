package com.rakib.nfplus.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rakib.nfplus.LivePlayerActivity;
import com.rakib.nfplus.R;
import com.rakib.nfplus.model.Tv;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.MyViewHolder> {

    private Context mContext;
    List<Tv> tvList;
    int mode;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailImageView;

        public MyViewHolder(View view) {
            super(view);
            thumbnailImageView = view.findViewById(R.id.tv_thumbnail);
        }
    }


    public TvAdapter(Context mContext, List<Tv> tvList, int mode) {
        this.mContext = mContext;
        this.tvList = tvList;
        this.mode = mode;
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = null;

        if (mode == 0)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_tv_item, parent, false);
        if (mode == 1)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_tv_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Tv tv = tvList.get(position);


        // loading album cover using Glide library
        Glide.with(mContext).load(tv.getThumbnail()).into(holder.thumbnailImageView);

        holder.thumbnailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, movies.getName(), Toast.LENGTH_SHORT).show();
                String url = "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_30mb.mp4";
                Intent intent = new Intent(mContext, LivePlayerActivity.class);
                intent.putExtra("url", url);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return tvList.size();
    }
}