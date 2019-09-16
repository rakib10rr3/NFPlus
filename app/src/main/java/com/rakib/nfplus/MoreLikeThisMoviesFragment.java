package com.rakib.nfplus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rakib.nfplus.adapter.MoviesAdapter;
//import com.octoriz.cloudoneplus.model.ex_movies.Movie;
import com.rakib.nfplus.model.movies.Movie;
import com.rakib.nfplus.utility.GridAutoFitLayoutManager;

import java.util.ArrayList;
import java.util.Collections;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MoreLikeThisMoviesFragment extends Fragment {

    private static final String TAG = "MoreLikeThisFragment";
    ArrayList<Movie> moviesList = new ArrayList<>();
    ArrayList<Movie> clonedMoviesList;
    RecyclerView recyclerView;
    MoviesAdapter moviesAdapter;
    GridLayoutManager gridLayoutManager;
    int position;

    public MoreLikeThisMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: " + "Came here");

        moviesList = (ArrayList<Movie>) getActivity().getIntent().getSerializableExtra("movieList");
        position = getActivity().getIntent().getIntExtra("position",0);

        clonedMoviesList = new ArrayList(moviesList);
        clonedMoviesList.remove(position);

        Collections.shuffle(clonedMoviesList);


//        moviesList = new ArrayList<>();
//        moviesList.add(new Movies("Infinity War", "Action","https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
//        moviesList.add(new Movies("Endgame", "Action","https://image.tmdb.org/t/p/original/bJLYrLIHT1r7cikhWGbpZkxlUpA.jpg"));
//        moviesList.add(new Movies("Captain Marvel", "Action","https://image.tmdb.org/t/p/original/ql5jol2TmXFiwKgzt1sL4z5HGrD.jpg"));
//        moviesList.add(new Movies("Ant-Man & the Wasp", "Action","https://image.tmdb.org/t/p/original/rv1AWImgx386ULjcf62VYaW8zSt.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action","https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));
//        moviesList.add(new Movies("Infinity War", "Action","https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
//        moviesList.add(new Movies("Endgame", "Action","https://image.tmdb.org/t/p/original/bJLYrLIHT1r7cikhWGbpZkxlUpA.jpg"));
//        moviesList.add(new Movies("Captain Marvel", "Action","https://image.tmdb.org/t/p/original/ql5jol2TmXFiwKgzt1sL4z5HGrD.jpg"));
//        moviesList.add(new Movies("Ant-Man & the Wasp", "Action","https://image.tmdb.org/t/p/original/rv1AWImgx386ULjcf62VYaW8zSt.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action","https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));
//        moviesList.add(new Movies("Infinity War", "Action","https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
//        moviesList.add(new Movies("Endgame", "Action","https://image.tmdb.org/t/p/original/bJLYrLIHT1r7cikhWGbpZkxlUpA.jpg"));
//        moviesList.add(new Movies("Captain Marvel", "Action","https://image.tmdb.org/t/p/original/ql5jol2TmXFiwKgzt1sL4z5HGrD.jpg"));
//        moviesList.add(new Movies("Ant-Man & the Wasp", "Action","https://image.tmdb.org/t/p/original/rv1AWImgx386ULjcf62VYaW8zSt.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action","https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action","https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action","https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_more_like_this_movies, container, false);
        recyclerView = view.findViewById(R.id.more_like_this_movies_rv);
        moviesAdapter = new MoviesAdapter(getActivity(), clonedMoviesList, 1);
        GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getActivity().getApplicationContext(), 0);
        //gridLayoutManager = new GridLayoutManager(getActivity(), 3, RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(moviesAdapter);
        recyclerView.setLayoutManager(gridAutoFitLayoutManager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
