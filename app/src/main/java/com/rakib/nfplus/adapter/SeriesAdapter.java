package com.rakib.nfplus.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rakib.nfplus.R;
import com.rakib.nfplus.SeriesDetailActivity;
import com.rakib.nfplus.model.series.Season;
import com.rakib.nfplus.model.series.Series;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.MyViewHolder> {

    private Context mContext;
    ArrayList<Series> seriesList = new ArrayList<>();
    int mode;

    @NonNull
    @Override
    public SeriesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;

        if (mode == 0)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_series_item, parent, false);
        if (mode == 1)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_more_like_this_series_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesAdapter.MyViewHolder holder, int position) {
        final Series series = seriesList.get(position);
        String title = series.getTVtitle();
        List<Season> seasonList = series.getSeasons();
        String runTime = series.getTVruntime();
        String story = series.getTVstory();
        String genres = series.getTVgenre();
        String backDrop = series.getBackdrop();


        Glide.with(mContext).load(series.getTVposter()).into(holder.poster);

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, SeriesDetailActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("runTime", runTime);
                intent.putExtra("story", story);
                intent.putExtra("genres", genres);
                intent.putExtra("backdrop", backDrop);
                intent.putExtra("seasonList", (Serializable) seasonList);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView poster;

        public MyViewHolder(View view) {
            super(view);
            poster = view.findViewById(R.id.series_poster);
        }
    }


    public SeriesAdapter(Context mContext, ArrayList<Series> seriesList, int mode) {
        this.mContext = mContext;
        this.seriesList = seriesList;
        this.mode = mode;
    }


}