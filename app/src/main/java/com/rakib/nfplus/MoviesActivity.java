package com.rakib.nfplus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rakib.nfplus.adapter.MoviesAdapter;
import com.rakib.nfplus.app.AppController;
//import com.octoriz.cloudoneplus.model.Movies;
//import com.octoriz.cloudoneplus.model.ex_movies.Movie;

import com.rakib.nfplus.model.movies.Movie;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesActivity extends AppCompatActivity implements View.OnClickListener {


    Movie movie;
    List<Movie> moviesList;

    ArrayList<Movie> latestMoviesList;
    ArrayList<Movie> actionMoviesList;
    ArrayList<Movie> animationMoviesList;
    ArrayList<Movie> comedyMoviesList;
    ArrayList<Movie> crimeMoviesList;
    ArrayList<Movie> dramaMoviesList;
    ArrayList<Movie> historyMoviesList;
    ArrayList<Movie> horrorMoviesList;
    ArrayList<Movie> musicMoviesList;
    ArrayList<Movie> mysteryMoviesList;
    ArrayList<Movie> romanceMoviesList;
    ArrayList<Movie> warMoviesList;
    ArrayList<Movie> westernMoviesList;

    MoviesAdapter moviesAdapter;
    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;
    SliderLayout sliderLayout;
    MaterialButton moreFavButton, moreActionButton, moreAnimationButton, moreComedyButton, moreCrimeButton, moreDramaButton, moreHistoryButton, moreHorrorButton, moreMusicButton, moreMysteryButton, moreRomanceButton, moreWarButton, moreWesternButton;
    private String TAG = MoviesActivity.class.getSimpleName();

    Gson gson;
    GsonBuilder gsonBuilder;

    ShimmerFrameLayout shimmerActionLayout, shimmerAnimationLayout ,shimmerComedyLayout, shimmerCrimeLayout, shimmerDramaLayout, shimmerHistoryLayout, shimmerHorrorLayout, shimmerMusicLayout, shimmerMysteryLayout, shimmerRomanceLayout, shimmerWarLayout, shimmerwesternLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Logger.addLogAdapter(new AndroidLogAdapter());

        shimmerActionLayout = findViewById(R.id.shimmer_action_container);
        shimmerComedyLayout = findViewById(R.id.shimmer_comedy_container);
        shimmerAnimationLayout = findViewById(R.id.shimmer_animation_container);
        shimmerCrimeLayout = findViewById(R.id.shimmer_crime_container);
        shimmerDramaLayout = findViewById(R.id.shimmer_drama_container);
        shimmerHistoryLayout = findViewById(R.id.shimmer_history_container);
        shimmerHorrorLayout = findViewById(R.id.shimmer_horror_container);
        shimmerMusicLayout = findViewById(R.id.shimmer_music_container);
        shimmerMysteryLayout = findViewById(R.id.shimmer_mystery_container);
        shimmerRomanceLayout = findViewById(R.id.shimmer_romance_container);
        shimmerWarLayout = findViewById(R.id.shimmer_war_container);
        shimmerwesternLayout = findViewById(R.id.shimmer_western_container);

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        latestMoviesList = new ArrayList<>();
        actionMoviesList = new ArrayList<>();
        animationMoviesList = new ArrayList<>();
        comedyMoviesList = new ArrayList<>();
        crimeMoviesList = new ArrayList<>();
        dramaMoviesList = new ArrayList<>();
        historyMoviesList = new ArrayList<>();
        horrorMoviesList = new ArrayList<>();
        musicMoviesList = new ArrayList<>();
        mysteryMoviesList = new ArrayList<>();
        romanceMoviesList = new ArrayList<>();
        warMoviesList = new ArrayList<>();
        westernMoviesList = new ArrayList<>();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0f);
        }

        makeLatestMoviesRequest();
        makeActionMovieRequest();
        makeAnimationMovieRequest();
        makeComedyMovieRequest();
        makeCrimeMovieRequest();
        makeDramaMovieRequest();
        makeHistoryMovieRequest();
        makeHorrorMovieRequest();
        makeMusicMovieRequest();
        makeMysteryMovieRequest();
        makeRomanceMovieRequest();
        makeWarMovieRequest();
        makeWesternMovieRequest();


        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SCALE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :

    }



    private void makeLatestMoviesRequest() {
        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=4&sort=DESC&w=grid";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //Log.d(TAG, response.toString());
                            Logger.json(response.toString());
                            latestMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                            setSliderViews(latestMoviesList);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeActionMovieRequest() {
        moreActionButton = findViewById(R.id.movies_action_all_btn);
        moreActionButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Action&sort=DESC&w=grid";

        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if(entry != null){

            try {
                String data = new String(entry.data ,"UTF-8");
                // Get JSON from the data
                Logger.json(data);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            //Make network call
        }

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //Log.d(TAG, response.toString());
                            Logger.json(response.toString());
                            actionMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                            //Log.d(TAG, "onResponse: " + String.valueOf(actionMoviesList.get(0).getVideoQuality()));
                            recyclerView = findViewById(R.id.movies_action_rv);
                            moviesAdapter = new MoviesAdapter(MoviesActivity.this, actionMoviesList, 0);
                            gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                            recyclerView.setAdapter(moviesAdapter);
                            recyclerView.setLayoutManager(gridLayoutManager);


                            shimmerActionLayout.stopShimmer();
                            shimmerActionLayout.setVisibility(View.GONE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeAnimationMovieRequest() {
        moreAnimationButton = findViewById(R.id.movies_animation_all_btn);
        moreAnimationButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Animation&sort=DESC&w=grid";

        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if(entry != null){

            try {
                String data = new String(entry.data ,"UTF-8");
                // Get JSON from the data
                Logger.json(data);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            //Make network call
        }

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //Log.d(TAG, response.toString());
                            Logger.json(response.toString());
                            animationMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                            //Log.d(TAG, "onResponse: " + String.valueOf(actionMoviesList.get(0).getVideoQuality()));
                            recyclerView = findViewById(R.id.movies_animation_rv);
                            moviesAdapter = new MoviesAdapter(MoviesActivity.this, animationMoviesList, 0);
                            gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                            recyclerView.setAdapter(moviesAdapter);
                            recyclerView.setLayoutManager(gridLayoutManager);


                            shimmerAnimationLayout.stopShimmer();
                            shimmerAnimationLayout.setVisibility(View.GONE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeComedyMovieRequest() {
        moreComedyButton = findViewById(R.id.movies_comedy_all_btn);
        moreComedyButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Comedy&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        comedyMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_comedy_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, comedyMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerComedyLayout.stopShimmer();
                        shimmerComedyLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeCrimeMovieRequest() {
        moreCrimeButton = findViewById(R.id.movies_crime_all_btn);
        moreCrimeButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Crime&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        crimeMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_crime_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, crimeMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerCrimeLayout.stopShimmer();
                        shimmerCrimeLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeDramaMovieRequest() {
        moreDramaButton = findViewById(R.id.movies_drama_all_btn);
        moreDramaButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Drama&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        dramaMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_drama_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, dramaMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerDramaLayout.stopShimmer();
                        shimmerDramaLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeHistoryMovieRequest() {
        moreHistoryButton = findViewById(R.id.movies_history_all_btn);
        moreHistoryButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=History&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        historyMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_history_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, historyMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerHistoryLayout.stopShimmer();
                        shimmerHistoryLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeHorrorMovieRequest() {
        moreHorrorButton = findViewById(R.id.movies_horror_all_btn);
        moreHorrorButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Horror&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        horrorMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_horror_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, horrorMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerHorrorLayout.stopShimmer();
                        shimmerHorrorLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeMusicMovieRequest() {
        moreMusicButton = findViewById(R.id.movies_music_all_btn);
        moreMusicButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Music&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        musicMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_music_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, musicMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerMusicLayout.stopShimmer();
                        shimmerMusicLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeMysteryMovieRequest() {
        moreMysteryButton = findViewById(R.id.movies_mystery_all_btn);
        moreMysteryButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Mystery&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        mysteryMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_mystery_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, mysteryMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerMysteryLayout.stopShimmer();
                        shimmerMysteryLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeRomanceMovieRequest() {
        moreRomanceButton = findViewById(R.id.movies_romance_all_btn);
        moreRomanceButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Romance&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        romanceMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_romance_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, romanceMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerRomanceLayout.stopShimmer();
                        shimmerRomanceLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeWarMovieRequest() {
        moreWarButton = findViewById(R.id.movies_war_all_btn);
        moreWarButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=War&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        warMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_war_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, warMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerWarLayout.stopShimmer();
                        shimmerWarLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    private void makeWesternMovieRequest() {
        moreWesternButton = findViewById(R.id.movies_western_all_btn);
        moreWesternButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/getallmovies.php?page=1&entries=24&Category=Hollywood&Genre=Western&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        westernMoviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                        recyclerView = findViewById(R.id.movies_western_rv);
                        moviesAdapter = new MoviesAdapter(MoviesActivity.this, westernMoviesList, 0);
                        gridLayoutManager = new GridLayoutManager(MoviesActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
                        recyclerView.setAdapter(moviesAdapter);
                        recyclerView.setLayoutManager(gridLayoutManager);

                        shimmerwesternLayout.stopShimmer();
                        shimmerwesternLayout.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }


    private void setSliderViews(ArrayList<Movie> latestMoviesList) {


        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl(latestMoviesList.get(0).getBackdropList().get(new Random().nextInt(latestMoviesList.get(0).getBackdropList().size())).getBackdrop());
                    break;
                case 1:
                    sliderView.setImageUrl(latestMoviesList.get(1).getBackdropList().get(new Random().nextInt(latestMoviesList.get(1).getBackdropList().size())).getBackdrop());
                    break;
                case 2:
                    sliderView.setImageUrl(latestMoviesList.get(2).getBackdropList().get(new Random().nextInt(latestMoviesList.get(2).getBackdropList().size())).getBackdrop());
                    break;
                case 3:
                    sliderView.setImageUrl(latestMoviesList.get(3).getBackdropList().get(new Random().nextInt(latestMoviesList.get(3).getBackdropList().size())).getBackdrop());
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderView.setDescription(latestMoviesList.get(i).getMovieTitle());
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //Toast.makeText(MoviesActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MoviesActivity.this, PlayerActivity.class);
                    intent.putExtra("title", (latestMoviesList.get(finalI).getMovieTitle()));
                    intent.putExtra("url", latestMoviesList.get(finalI).getMovieWatchLink());
                    startActivity(intent);

                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MoreMoviesActivity.class);

        switch (view.getId()) {
            case R.id.movies_fav_all_btn:
                break;

            case R.id.movies_action_all_btn:
                intent.putExtra("actionMoviesList", (Serializable) actionMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_animation_all_btn:
                intent.putExtra("animationMoviesList", (Serializable) animationMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_comedy_all_btn:
                intent.putExtra("comedyMoviesList", (Serializable) comedyMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_crime_all_btn:
                intent.putExtra("crimeMoviesList", (Serializable) crimeMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_drama_all_btn:
                intent.putExtra("dramaMoviesList", (Serializable) dramaMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_history_all_btn:
                intent.putExtra("historyMoviesList", (Serializable) historyMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_horror_all_btn:
                intent.putExtra("horrorMoviesList", (Serializable) horrorMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_music_all_btn:
                intent.putExtra("musicMoviesList", (Serializable) musicMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_mystery_all_btn:
                intent.putExtra("mysteryMoviesList", (Serializable) mysteryMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_romance_all_btn:
                intent.putExtra("romanceMoviesList", (Serializable) romanceMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_war_all_btn:
                intent.putExtra("warMoviesList", (Serializable) warMoviesList);
                startActivity(intent);
                break;

            case R.id.movies_western_all_btn:
                intent.putExtra("westernMoviesList", (Serializable) westernMoviesList);
                startActivity(intent);
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra("type","movie");
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        shimmerActionLayout.startShimmer();
        shimmerComedyLayout.startShimmer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerActionLayout.stopShimmer();
        shimmerComedyLayout.stopShimmer();
    }
}
