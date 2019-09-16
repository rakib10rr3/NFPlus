package com.rakib.nfplus;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rakib.nfplus.adapter.SeriesAdapter;
import com.rakib.nfplus.model.series.Series;
import com.rakib.nfplus.utility.GridAutoFitLayoutManager;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MoreLikeThisSeriesFragment extends Fragment {

    ArrayList<Series> seriesList;
    RecyclerView recyclerView;
    SeriesAdapter seriesAdapter;
    GridLayoutManager gridLayoutManager;

    public MoreLikeThisSeriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        seriesList = new ArrayList<>();
//        seriesList.add(new Series("Friends", "Comedy", "https://image.tmdb.org/t/p/original/7buCWBTpiPrCF5Lt023dSC60rgS.jpg", 10));
//        seriesList.add(new Series("Game of Thrones", "Adventure", "https://image.tmdb.org/t/p/original/gwPSoYUHAKmdyVywgLpKKA4BjRr.jpg", 1));
//        seriesList.add(new Series("Sherlock", "Action", "https://image.tmdb.org/t/p/original/f9zGxLHGyQB10cMDZNY5ZcGKhZi.jpg", 2));
//        seriesList.add(new Series("The Big Bang Theory", "Comedy", "https://image.tmdb.org/t/p/original/ooBGRQBdbGzBxAVfExiO8r7kloA.jpg", 3));
//        seriesList.add(new Series("Daredevil", "Action", "https://image.tmdb.org/t/p/original/wVadC1BT2w3hDh5Vq0J0LFFTrLP.jpg", 4));
//
//        seriesList.add(new Series("Friends", "Comedy", "https://image.tmdb.org/t/p/original/7buCWBTpiPrCF5Lt023dSC60rgS.jpg", 10));
//        seriesList.add(new Series("Game of Thrones", "Adventure", "https://image.tmdb.org/t/p/original/gwPSoYUHAKmdyVywgLpKKA4BjRr.jpg", 1));
//        seriesList.add(new Series("Sherlock", "Action", "https://image.tmdb.org/t/p/original/f9zGxLHGyQB10cMDZNY5ZcGKhZi.jpg", 2));
//        seriesList.add(new Series("The Big Bang Theory", "Comedy", "https://image.tmdb.org/t/p/original/ooBGRQBdbGzBxAVfExiO8r7kloA.jpg", 3));
//        seriesList.add(new Series("Daredevil", "Action", "https://image.tmdb.org/t/p/original/wVadC1BT2w3hDh5Vq0J0LFFTrLP.jpg", 4));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_like_this_series, container, false);
        recyclerView = view.findViewById(R.id.more_like_this_series_rv);
        seriesAdapter = new SeriesAdapter(getActivity(), seriesList,1);
        gridLayoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getActivity().getApplicationContext(), 0);
        recyclerView.setAdapter(seriesAdapter);
        recyclerView.setLayoutManager(gridAutoFitLayoutManager);
        return view;
    }

}
