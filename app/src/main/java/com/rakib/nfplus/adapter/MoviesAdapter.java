package com.rakib.nfplus.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.rakib.nfplus.MovieDetailActivity;
import com.rakib.nfplus.R;
//import com.octoriz.cloudoneplus.model.ex_movies.Actor;
//import com.octoriz.cloudoneplus.model.ex_movies.Director;
//import com.octoriz.cloudoneplus.model.ex_movies.Genre;
//import com.octoriz.cloudoneplus.model.ex_movies.Movie;

import com.rakib.nfplus.model.movies.Movie;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    ArrayList<Movie> moviesList = new ArrayList<>();
    ArrayList<Movie> moreLikeThisList = new ArrayList<>();
//    ArrayList<Genre> genreArrayList = new ArrayList<>();
//    ArrayList<Director> directors = new ArrayList<>();
//    ArrayList<Actor> actors = new ArrayList<>();

    int mode;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView poster;

        public MyViewHolder(View view) {
            super(view);
            poster = view.findViewById(R.id.movies_poster);
        }
    }


    public MoviesAdapter(Context mContext, ArrayList<Movie> moviesList, int mode) {
        this.mContext = mContext;
        this.moviesList = moviesList;
        this.mode = mode;
        this.moreLikeThisList = moviesList;
    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = null;

        if (mode == 0)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_movie_item, parent, false);
        if (mode == 1)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_more_like_this_movie_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Movie movie = moviesList.get(position);

        final String title = movie.getMovieTitle();
        String description = Html.fromHtml(movie.getMovieStory()).toString().replaceAll("\n", "").trim();
        final String runTime = movie.getMovieRuntime();
        String thumbnail = movie.getPoster();
        String url = movie.getMovieWatchLink();
        String actors = movie.getMovieActors();
        String genres = movie.getMovieGenre();

        final Intent intent = new Intent(mContext, MovieDetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("runtime", runTime);
        intent.putExtra("thumbnail", thumbnail);
        intent.putExtra("url", url);
        intent.putExtra("movieList", (Serializable) moreLikeThisList);
        intent.putExtra("actors", actors);
        intent.putExtra("genres", genres);
        intent.putExtra("backdropList", (Serializable) movie.getBackdropList());

//        intent.putExtra("genreList", (Serializable) movie.getGenres());
//        intent.putExtra("actorList", (Serializable) movie.getActors());
//        intent.putExtra("directorList", (Serializable) movie.getDirectors());


        // loading album cover using Glide library
        Glide.
                with(mContext).
                load(movie.getPosterUrl()).
                transition(DrawableTransitionOptions.withCrossFade(300)).
                listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.poster.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.no_poster));
                        return true;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                }).
                into(holder.poster);

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(mContext, String.valueOf(runTime), Toast.LENGTH_SHORT).show();
                //Toast.makeText(mContext, String.valueOf(movie.getGenres().size()), Toast.LENGTH_SHORT).show();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("position", position);
                //Toast.makeText(mContext, String.valueOf(position), Toast.LENGTH_SHORT).show();
                mContext.startActivity(intent);
            }
        });

        holder.poster.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, moreLikeThisList.get(position).getMovieTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}