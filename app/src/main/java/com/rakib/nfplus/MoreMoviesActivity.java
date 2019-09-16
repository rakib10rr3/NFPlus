package com.rakib.nfplus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import com.rakib.nfplus.adapter.MoviesAdapter;
//import com.octoriz.cloudoneplus.model.ex_movies.Movie;
import com.rakib.nfplus.model.movies.Movie;
import com.rakib.nfplus.utility.GridAutoFitLayoutManager;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MoreMoviesActivity extends AppCompatActivity {

    ArrayList<Movie> moviesList;
    MoviesAdapter moviesAdapter;
    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_movies);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        moviesList = new ArrayList<>();

        Intent intent = getIntent();

        if (intent.hasExtra("actionMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("actionMoviesList");
        else if (intent.hasExtra("comedyMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("comedyMoviesList");
        else if (intent.hasExtra("animationMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("animationMoviesList");
        else if (intent.hasExtra("dramaMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("dramaMoviesList");
        else if (intent.hasExtra("crimeMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("crimeMoviesList");
        else if (intent.hasExtra("historyMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("historyMoviesList");
        else if (intent.hasExtra("horrorMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("horrorMoviesList");
        else if (intent.hasExtra("musicMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("musicMoviesList");
        else if (intent.hasExtra("mysteryMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("mysteryMoviesList");
        else if (intent.hasExtra("romanceMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("romanceMoviesList");
        else if (intent.hasExtra("warMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("warMoviesList");
        else if (intent.hasExtra("westernMoviesList"))
            moviesList = (ArrayList<Movie>) intent.getSerializableExtra("westernMoviesList");



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        moviesList = new ArrayList<>();
//        moviesList.add(new Movies("Infinity War", "Action", "https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
//        moviesList.add(new Movies("Endgame", "Action", "https://image.tmdb.org/t/p/original/bJLYrLIHT1r7cikhWGbpZkxlUpA.jpg"));
//        moviesList.add(new Movies("Captain Marvel", "Action", "https://image.tmdb.org/t/p/original/ql5jol2TmXFiwKgzt1sL4z5HGrD.jpg"));
//        moviesList.add(new Movies("Ant-Man & the Wasp", "Action", "https://image.tmdb.org/t/p/original/rv1AWImgx386ULjcf62VYaW8zSt.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action", "https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));
//
//        moviesList.add(new Movies("Infinity War", "Action", "https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
//        moviesList.add(new Movies("Endgame", "Action", "https://image.tmdb.org/t/p/original/bJLYrLIHT1r7cikhWGbpZkxlUpA.jpg"));
//        moviesList.add(new Movies("Captain Marvel", "Action", "https://image.tmdb.org/t/p/original/ql5jol2TmXFiwKgzt1sL4z5HGrD.jpg"));
//        moviesList.add(new Movies("Ant-Man & the Wasp", "Action", "https://image.tmdb.org/t/p/original/rv1AWImgx386ULjcf62VYaW8zSt.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action", "https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));
//
//        moviesList.add(new Movies("Infinity War", "Action", "https://image.tmdb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
//        moviesList.add(new Movies("Endgame", "Action", "https://image.tmdb.org/t/p/original/bJLYrLIHT1r7cikhWGbpZkxlUpA.jpg"));
//        moviesList.add(new Movies("Captain Marvel", "Action", "https://image.tmdb.org/t/p/original/ql5jol2TmXFiwKgzt1sL4z5HGrD.jpg"));
//        moviesList.add(new Movies("Ant-Man & the Wasp", "Action", "https://image.tmdb.org/t/p/original/rv1AWImgx386ULjcf62VYaW8zSt.jpg"));
//        moviesList.add(new Movies("Spider-Man Homecoming", "Action", "https://image.tmdb.org/t/p/original/5x00yQZ3Mcz7duwMKc9GE8oZjFf.jpg"));


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0f);
        }

        recyclerView = findViewById(R.id.more_movies_rv);
        moviesAdapter = new MoviesAdapter(this, moviesList, 1);
        //gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getApplicationContext(), 0);

        recyclerView.setAdapter(moviesAdapter);
        recyclerView.setLayoutManager(gridAutoFitLayoutManager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

}
