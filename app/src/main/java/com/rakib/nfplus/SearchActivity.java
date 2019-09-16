package com.rakib.nfplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rakib.nfplus.adapter.MoviesAdapter;
import com.rakib.nfplus.adapter.SeriesAdapter;
import com.rakib.nfplus.app.AppController;
import com.rakib.nfplus.model.movies.Movie;
import com.rakib.nfplus.model.series.Series;
import com.rakib.nfplus.utility.GridAutoFitLayoutManager;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SearchActivity.class.getSimpleName();
    private Context mContext;
    EditText searchEditText;
    ImageButton backImageButton, clearImageButton;
    String type;
    String keyword;

    ArrayList<Movie> moviesList;
    ArrayList<Series> seriesList;
    MoviesAdapter moviesAdapter;
    SeriesAdapter seriesAdapter;
    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;

    Gson gson;
    GsonBuilder gsonBuilder;

    ProgressBar progressBar;
    Sprite wave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        moviesList = new ArrayList<>();
        seriesList = new ArrayList<>();

        type = getIntent().getStringExtra("type");

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        progressBar = findViewById(R.id.spin_kit);
        wave = new Wave();
        searchEditText = findViewById(R.id.edt_txt_search);
        backImageButton = findViewById(R.id.img_btn_back);
        clearImageButton = findViewById(R.id.img_btn_clear);

        backImageButton.setOnClickListener(this);
        clearImageButton.setOnClickListener(this);

        searchEditText.requestFocus();

        searchEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    keyword = searchEditText.getText().toString();
                    if (type.equals("movie"))
                        performMovieSearch(keyword);
                    else
                        performSeriesSearch(keyword);
                    Toast.makeText(SearchActivity.this, searchEditText.getText().toString(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setIndeterminateDrawable(wave);
                    return true;
                }
                return false;
            }
        });
    }

    private void performSeriesSearch(String keyword) {



        String tag_json_arry = "json_array_req";
        String searchSeriesUrl = "http://103.115.24.6/api/searchtvseries.php?q=&searchquery=" + keyword + "&q=M";

        Logger.d(searchSeriesUrl);

        JsonArrayRequest req = new JsonArrayRequest(searchSeriesUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //Log.d(TAG, response.toString());
                            progressBar.setVisibility(View.INVISIBLE);
                            Logger.json(response.toString());
                            if (!seriesList.isEmpty())
                                seriesList.clear();
                            seriesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Series[].class)));
                            Logger.d(String.valueOf(seriesList.size()));
                            recyclerView = findViewById(R.id.search_rv);
                            seriesAdapter = new SeriesAdapter(getApplicationContext(), seriesList, 1);
                            //gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
                            GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getApplicationContext(), 0);



                            recyclerView.setAdapter(seriesAdapter);
                            recyclerView.setLayoutManager(gridAutoFitLayoutManager);


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

    private void performMovieSearch(String keyword) {
        String tag_json_arry = "json_array_req";
        String searchMovieUrl = "http://103.115.24.6/api/searchallmovies.php?q=&searchquery=" + keyword + "&q=M";

        Logger.d(searchMovieUrl);

        JsonArrayRequest req = new JsonArrayRequest(searchMovieUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressBar.setVisibility(View.INVISIBLE);
                            //Log.d(TAG, response.toString());
                            Logger.json(response.toString());
                            if (!moviesList.isEmpty())
                                moviesList.clear();
                            moviesList.addAll(Arrays.asList(gson.fromJson(response.toString(), Movie[].class)));
                            Logger.d(String.valueOf(moviesList.size()));
                            recyclerView = findViewById(R.id.search_rv);
                            moviesAdapter = new MoviesAdapter(getApplicationContext(), moviesList, 1);
                            //gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
                            GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getApplicationContext(), 0);

                            recyclerView.setAdapter(moviesAdapter);
                            recyclerView.setLayoutManager(gridAutoFitLayoutManager);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_btn_back:
                finish();
                break;
            case R.id.img_btn_clear:
                searchEditText.getText().clear();
        }
    }
}
