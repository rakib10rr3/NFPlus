package com.rakib.nfplus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rakib.nfplus.adapter.SeriesAdapter;
import com.rakib.nfplus.app.AppController;
import com.rakib.nfplus.model.series.Series;
import com.rakib.nfplus.utility.GridAutoFitLayoutManager;
import com.orhanobut.logger.Logger;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SeriesActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SeriesActivity.class.getSimpleName();
    ArrayList<Series> seriesList = new ArrayList<>();
    SeriesAdapter seriesAdapter;
    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;
    SliderLayout sliderLayout;

    MaterialButton moreFavButton, moreActionButton, moreComedyButton;

    Gson gson;
    GsonBuilder gsonBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

//        seriesList = new ArrayList<>();
//        seriesList.add(new Series("Friends", "Comedy", "https://image.tmdb.org/t/p/original/7buCWBTpiPrCF5Lt023dSC60rgS.jpg", 10));
//        seriesList.add(new Series("Game of Thrones", "Adventure", "https://image.tmdb.org/t/p/original/gwPSoYUHAKmdyVywgLpKKA4BjRr.jpg", 1));
//        seriesList.add(new Series("Sherlock", "Action", "https://image.tmdb.org/t/p/original/f9zGxLHGyQB10cMDZNY5ZcGKhZi.jpg", 2));
//        seriesList.add(new Series("The Big Bang Theory", "Comedy", "https://image.tmdb.org/t/p/original/ooBGRQBdbGzBxAVfExiO8r7kloA.jpg", 3));
//        seriesList.add(new Series("Daredevil", "Action", "https://image.tmdb.org/t/p/original/wVadC1BT2w3hDh5Vq0J0LFFTrLP.jpg", 4));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0f);
        }

//        moreFavButton = findViewById(R.id.series_fav_all_btn);
//        moreFavButton.setOnClickListener(this);
//        recyclerView = findViewById(R.id.series_favourite_rv);
//        seriesAdapter = new SeriesAdapter(this, seriesList, 0);
//        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
//        recyclerView.setAdapter(seriesAdapter);
//        recyclerView.setLayoutManager(gridLayoutManager);

//        moreActionButton = findViewById(R.id.series_action_all_btn);
//        moreActionButton.setOnClickListener(this);
//        recyclerView = findViewById(R.id.series_action_rv);
//        seriesAdapter = new SeriesAdapter(this, seriesList, 0);
//        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
//        recyclerView.setAdapter(seriesAdapter);
//        recyclerView.setLayoutManager(gridLayoutManager);

        makeDramaSeriesRequest();


        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SCALE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :
        setSliderViews();
    }

    private void makeDramaSeriesRequest() {

        moreComedyButton = findViewById(R.id.series_all_btn);
        moreComedyButton.setOnClickListener(this);

        String tag_json_arry = "json_array_req";
        String url = "http://103.115.24.6/api/gettvseries.php?page=1&Category=all&sort=DESC&w=grid";


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            Logger.json(response.toString());
                            seriesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Series[].class)));
                            recyclerView = findViewById(R.id.series_all_rv);
                            seriesAdapter = new SeriesAdapter(SeriesActivity.this, seriesList, 1);
                            GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getApplicationContext(), 0);
                            recyclerView.setAdapter(seriesAdapter);
                            recyclerView.setLayoutManager(gridAutoFitLayoutManager);
////
//                            shimmerActionLayout.stopShimmer();
//                            shimmerActionLayout.setVisibility(View.GONE);
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

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/jhFjwNNUWRkCPKabugpYUutAr0c.jpg");
                    break;
                case 1:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/gX8SYlnL9ZznfZwEH4KJUePBFUM.jpg");
                    break;
                case 2:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/bvS50jBZXtglmLu72EAt5KgJBrL.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/7rRnZrZr1QPlJ6BcrrVMVGoy55X.jpg");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //startActivity(new Intent(SeriesActivity.this, PlayerActivity.class));
                    //Toast.makeText(SeriesActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.series_all_btn:
                Intent intent = new Intent(this, MoreSeriesActivity.class);
                intent.putExtra("seriesList", (Serializable) seriesList);
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
                intent.putExtra("type","series");
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
