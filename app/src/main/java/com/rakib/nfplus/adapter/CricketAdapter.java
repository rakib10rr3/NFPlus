package com.rakib.nfplus.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rakib.nfplus.R;
import com.rakib.nfplus.model.Cricket;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.MyViewHolder> {

    private Context mContext;
    List<Cricket> cricketList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView statusTv;
        public TextView overviewtv;
        public TextView homeTeamNametv;
        public TextView homeTeamFullNameTv;
        public TextView homeTeamScoretv;
        public TextView homeTeamTargettv;
        public TextView awayTeamNametv;
        public TextView awayTeamFullNameTv;
        public TextView awayTeamScoretv;
        public TextView awayTeamTargettv;
        public TextView resultTv;

        public ImageView homeTeamLogoIv;
        public ImageView awayTeamLogoIv;

        public MyViewHolder(View view) {
            super(view);
            statusTv = view.findViewById(R.id.status);
            overviewtv = view.findViewById(R.id.overview);
            homeTeamNametv = view.findViewById(R.id.home_team_name);
            homeTeamFullNameTv = view.findViewById(R.id.home_team_full_name);
            homeTeamScoretv = view.findViewById(R.id.home_team_score);
            homeTeamTargettv = view.findViewById(R.id.home_team_target);
            awayTeamNametv = view.findViewById(R.id.away_team_name);
            awayTeamFullNameTv = view.findViewById(R.id.away_team_full_name);
            awayTeamScoretv = view.findViewById(R.id.away_team_score);
            awayTeamTargettv = view.findViewById(R.id.away_team_target);
            resultTv = view.findViewById(R.id.result);

            homeTeamLogoIv = view.findViewById(R.id.home_team_logo);
            awayTeamLogoIv = view.findViewById(R.id.away_team_logo);
        }
    }


    public CricketAdapter(Context mContext, List<Cricket> cricketList) {
        this.mContext = mContext;
        this.cricketList = cricketList;
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_cricket_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Cricket cricket = cricketList.get(position);

        String targetAway = cricket.getAwayTeamScore();

        if (targetAway.isEmpty()) {
            holder.awayTeamTargettv.setVisibility(View.GONE);
            holder.awayTeamScoretv.setVisibility(View.GONE);

        } else {
            String[] partsAway = targetAway.split(" \\(");
            if (partsAway.length == 1) {
                holder.awayTeamScoretv.setText(partsAway[0]);
                holder.awayTeamTargettv.setVisibility(View.GONE);

            } else {
                holder.awayTeamScoretv.setText(partsAway[0]);
                holder.awayTeamTargettv.setText("(" + partsAway[1]);
            }
        }

        String targetHome = cricket.getHomeTeamScore();

        if (targetHome.isEmpty()) {
            holder.homeTeamTargettv.setVisibility(View.GONE);
            holder.homeTeamScoretv.setVisibility(View.GONE);

        } else {
            String[] partsHome = targetHome.split(" \\(");
            if (partsHome.length == 1) {
                holder.homeTeamScoretv.setText(partsHome[0]);
                holder.homeTeamTargettv.setVisibility(View.GONE);

            } else {
                holder.homeTeamScoretv.setText(partsHome[0]);
                holder.homeTeamTargettv.setText("("+partsHome[1]);
            }
        }

        if (cricket.getStatus().equals("LIVE"))
            holder.statusTv.setTextColor(Color.GREEN);

        holder.homeTeamFullNameTv.setText("( " + cricket.getHomeTeamName() + " )");
        holder.awayTeamFullNameTv.setText("( " + cricket.getAwayTeamName() + " )");

        holder.statusTv.setText(cricket.getStatus());
        holder.overviewtv.setText(cricket.getOverview());
        holder.homeTeamNametv.setText(cricket.getHomeTeamShortName());
        //holder.homeTeamScoretv.setText(cricket.getHomeTeamScore());
        holder.awayTeamNametv.setText(cricket.getAwayTeamShortName());

        if (!cricket.getResult().isEmpty())
            holder.resultTv.setText(cricket.getResult());
        else
            holder.resultTv.setVisibility(View.GONE);

        Glide.with(mContext).load(cricket.getHomeTeamLogo()).into(holder.homeTeamLogoIv);
        Glide.with(mContext).load(cricket.getAwayTeamLogo()).into(holder.awayTeamLogoIv);

    }


    @Override
    public int getItemCount() {
        return cricketList.size();
    }
}