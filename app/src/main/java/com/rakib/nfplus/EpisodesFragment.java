package com.rakib.nfplus;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rakib.nfplus.adapter.EpisodesAdapter;
import com.rakib.nfplus.model.series.Episode;
import com.rakib.nfplus.model.series.Season;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodesFragment extends Fragment implements View.OnClickListener {


    String runTime;

    List<Episode> episodesList;
    List<Episode> newEpisodesList;
    List<Season> seasonList;
    List<Season> newSeasonList;
    RecyclerView recyclerView;
    EpisodesAdapter episodesAdapter;
    LinearLayoutManager linearLayoutManager;
    CardView seasonsCardView;
    TextView seasonNoTextView;

    public EpisodesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        seasonList = (ArrayList<Season>) getActivity().getIntent().getSerializableExtra("seasonList");
        episodesList = new ArrayList<>();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            runTime = bundle.getString("runTime");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_episodes, container, false);

        seasonsCardView = view.findViewById(R.id.episodes_season_cv);
        seasonsCardView.setOnClickListener(this);

        seasonNoTextView = view.findViewById(R.id.season_no);

        recyclerView = view.findViewById(R.id.episodes_rv);
        episodesAdapter = new EpisodesAdapter(getActivity(), seasonList.get(0).getEpisode());
        linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(episodesAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onClick(View view) {

        final CharSequence[] items = new CharSequence[seasonList.size()];

        for (int i = 0; i < seasonList.size(); i++) {
            items[i] = "Season " + seasonList.get(i).getSeasonNumber();
        }


        switch (view.getId()) {
            case R.id.episodes_season_cv:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        seasonNoTextView.setText(seasonList.get(item).getSeasonNumber());
                        //Toast.makeText(getActivity().getApplicationContext(), String.valueOf(seasonList.get(item).getEpisode().get(0).getEpisodeData().getName()), Toast.LENGTH_SHORT).show();
                        episodesList.clear();
                        newEpisodesList = new ArrayList<>();
                        newEpisodesList.addAll(seasonList.get(item).getEpisode());
                        //Toast.makeText(getActivity().getApplicationContext(), String.valueOf(newEpisodesList.size()), Toast.LENGTH_SHORT).show();
                        episodesAdapter = new EpisodesAdapter(getActivity(), seasonList.get(item).getEpisode());
                        recyclerView.setAdapter(episodesAdapter);
//                        if (item == 1) {
//                            seasonNoTextView.setText(String.valueOf(item));
//                            episodesList.clear();
//                            newEpisodesList = new ArrayList<>();
//                            newEpisodesList.add(new Episodes(1,"The One with George Stephanopoulos", "This is the one where Ross mourns the anniversary of losing his virginity to Carol while at a hockey game with the guys. Rachel gets her first paycheck, the girls have a slumber party, and George Stephanopoulos's pizza is delivered to Monica by mistake.", "https://image.tmdb.org/t/p/original/ewcHihTEPLvPPW7o0SDc0ZTs66o.jpg", 22));
//                            newEpisodesList.add(new Episodes(2,"The One with the East German Laundry Detergent", "Joey wants to get back together with a former girlfriend he dumped, so he tricks Monica into posing as his new gal pal.", "https://image.tmdb.org/t/p/original/1JLPosNtPdj83jOwwPCBRhuJu3m.jpg", 22));
//                            episodesList.addAll(newEpisodesList);
//                            episodesAdapter.notifyDataSetChanged();
//                        } else if (item == 0) {
//                            seasonNoTextView.setText(String.valueOf(item+1));
//                            episodesList.clear();
//                            newEpisodesList = new ArrayList<>();
//                            newEpisodesList.add(new Episodes(1,"The Pilot", "This is the one where it all began ... Rachel leaves Barry at the altar, meets the gang, and moves in with Monica. Monica, meanwhile, sleeps with Paul the Wine Guy", "https://image.tmdb.org/t/p/original/fbtaoynlPpENx3Ss2laC7wgqLIP.jpg", 22));
//                            newEpisodesList.add(new Episodes(2,"The One with the Sonogram at the End", "Carol, Ross's lesbian ex-wife, tells him at work that she is pregnant with his child, Monica nearly has a breakdown when her parents come for dinner, and Rachel finds out that Barry and her maid of honor Mindy, went on her honeymoon.", "https://image.tmdb.org/t/p/original/q00vWBNdLBIprqA3zQJ3TpfXNhu.jpg", 22));
//                            newEpisodesList.add(new Episodes(3,"The One with the Thumb", "Chandler's reunited with his beloved cigarettes, which the rest of his friends can't stand. Monica dates a man all her buddies love but with whom she's bored.", "https://image.tmdb.org/t/p/original/zLZb1o6dTpUmTNdODdbqH8dJpjc.jpg", 22));
//                            episodesList.addAll(newEpisodesList);
//                            episodesAdapter.notifyDataSetChanged();
//                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
        }
    }
}
