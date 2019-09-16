package com.rakib.nfplus.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rakib.nfplus.R;
import com.rakib.nfplus.SeriesPlayerActivity;
import com.rakib.nfplus.model.series.Episode;


import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.MyViewHolder> {

    private Context mContext;
    List<Episode> episodeList;

    @NonNull
    @Override
    public EpisodesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_episode_item, parent, false);

        return new EpisodesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodesAdapter.MyViewHolder holder, int position) {
        final Episode episode = episodeList.get(position);
        Glide.with(mContext).load("http://image.tmdb.org/t/p/w780/"+episode.getEpisodeData().getStillPath()).into(holder.thumbnailImageView);

        holder.nameTextView.setText(episode.getEpisodeData().getName());
        holder.descriptionTextView.setText(episode.getEpisodeData().getOverview());

        String runTime = String.valueOf("90" + " min");
        holder.runtimeTextView.setText(runTime);
        holder.episodeNoTextView.setText(String.valueOf(episode.getEpisodeNumber()+"."));

        holder.thumbnailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, SeriesPlayerActivity.class);
                intent.putExtra("episodes", (Serializable) episodeList);
                intent.putExtra("episodeIndex", position);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount(){
        return episodeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailImageView;
        public TextView nameTextView;
        public TextView descriptionTextView;
        public TextView runtimeTextView;
        public TextView episodeNoTextView;

        public MyViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.episode_name);
            descriptionTextView = view.findViewById(R.id.episode_description);
            thumbnailImageView = view.findViewById(R.id.episode_thumbnail);
            runtimeTextView = view.findViewById(R.id.episode_duration);
            episodeNoTextView = view.findViewById(R.id.episode_number);
        }
    }


    public EpisodesAdapter(Context mContext, List<Episode> episodeList) {
        this.mContext = mContext;
        this.episodeList = episodeList;
        //Toast.makeText(mContext, "Sina khao " + String.valueOf(episodeList.size()), Toast.LENGTH_SHORT).show();
    }
}
