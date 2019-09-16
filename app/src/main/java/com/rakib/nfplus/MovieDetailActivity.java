package com.rakib.nfplus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.rakib.nfplus.adapter.GenreAdapter;
import com.rakib.nfplus.model.ex_movies.Actor;
import com.rakib.nfplus.model.ex_movies.Director;
import com.rakib.nfplus.model.movies.BackdropList;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener {

    CollapsingToolbarLayout collapsingToolbarLayout;

    ImageView thumbnailImageView;
    ImageView playImageView;
    AppBarLayout appBarLayout;
    ImageButton favImageButton;

    TextView titleTextView;
    TextView descriptionTextView;
    TextView runTimeTextView;
    TextView actorsTextView;

    RecyclerView genreRecyclerView;
    GenreAdapter genreAdapter;

    List<String> genreList;
    List<Actor> actorList;
    List<Director> directorList;

    List<BackdropList> backdropLists;

    String url;
    String title;
    String actors;
    String joined = "";

    int duration;

    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Logger.addLogAdapter(new AndroidLogAdapter());

        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.darkBlue));

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        genreList = (List<Genre>) getIntent().getSerializableExtra("genreList");
//        actorList = (List<Actor>) getIntent().getSerializableExtra("actorList");
//        directorList = (List<Director>) getIntent().getSerializableExtra("directorList");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        title = getIntent().getStringExtra("title");
        Logger.d(title);
        String description = getIntent().getStringExtra("description");

        String durationString = getIntent().getStringExtra("runtime");

        actors = getIntent().getStringExtra("actors");

        String genre = getIntent().getStringExtra("genres");
        genreList = Arrays.asList(genre.split(","));


        try {
            String foo = actors;

            String[] split = foo.split(",");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                sb.append(split[i]);
                if (i != 2) {
                    sb.append(", ");
                }
                if (i == 2)
                    break;
            }
            joined = sb.toString();

        } catch (Exception e) {
            joined = "N/A";
        }


        Logger.d(durationString);

        //durationString = durationString.substring(0, durationString.length() - 3);


        try {
            duration = Integer.valueOf(durationString);

        } catch (Exception e) {
            e.printStackTrace();
        }

        int hours = duration / 60;
        int minutes = duration % 60;
        String runtime;

        if (hours > 0)
            runtime = hours + "h" + " " + minutes + "m";
        else
            runtime = minutes + "m";

        backdropLists = (ArrayList<BackdropList>) getIntent().getSerializableExtra("backdropList");

        url = getIntent().getStringExtra("url");

        initializeViews();

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        runTimeTextView.setText(runtime);

        Random rand = new Random();

        try {
            Glide.with(getApplicationContext()).load(backdropLists.get(rand.nextInt(backdropLists.size())).getBackdrop()).into(thumbnailImageView);

        } catch (Exception e) {
            e.printStackTrace();
        }

        actorsTextView.setText(joined);


        if (!genreList.get(0).equals("")) {
            genreAdapter = new GenreAdapter(MovieDetailActivity.this, genreList,1);
            gridLayoutManager = new GridLayoutManager(MovieDetailActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
            genreRecyclerView.setAdapter(genreAdapter);
            genreRecyclerView.setLayoutManager(gridLayoutManager);
        } else {
            genreRecyclerView.setVisibility(View.INVISIBLE);
        }


//        for (int i = 0; i < 3; i++) {
//            actorsTextView.append(actorList.get(i).getName());
//            if (i != 2)
//                actorsTextView.append(", ");
//        }
//
//        for (int i = 0; i < directorList.size(); i++) {
//            directorsTextView.append(directorList.get(i).getName());
//            if (directorList.size() > 1 && i != 2)
//                directorsTextView.append(", ");
//        }


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(final AppBarLayout appBarLayout, final int verticalOffset) {
                appBarLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                            // Collapsed
                            //Toast.makeText(MenuList.this, "Collapsed", Toast.LENGTH_SHORT).show();
                            toolbar.setTitle(title);
                        } else if (verticalOffset == 0) {
                            // Expanded
                            toolbar.setTitle(" ");
                            // Toast.makeText(MenuList.this, "Expanded", Toast.LENGTH_SHORT).show();
                        } else {
                            // Somewhere in between
                            // toolbar.setTitle(" ");
                        }
                    }
                });

            }
        });

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    replaceFragment(new MoreLikeThisMoviesFragment());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initializeViews() {
        appBarLayout = findViewById(R.id.movies_app_bar);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);

        collapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        thumbnailImageView = findViewById(R.id.thumbnail_image);
        playImageView = findViewById(R.id.detail_play);
        favImageButton = findViewById(R.id.detail_movie_fav_btn);

        titleTextView = findViewById(R.id.detail_movie_title);
        descriptionTextView = findViewById(R.id.detail_movie_desc);
        runTimeTextView = findViewById(R.id.detail_movie_runtime);

        actorsTextView = findViewById(R.id.stars);

        genreRecyclerView = findViewById(R.id.detail_chip_rv);

        favImageButton.setOnClickListener(this);

        playImageView.setOnClickListener(this);


        Handler handler = new Handler();

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
        replaceFragment(new MoreLikeThisMoviesFragment());
//            }
//        }, 200);

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_play:
                Intent intent = new Intent(this, PlayerActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("title", title);
                startActivity(intent);
                break;

            case R.id.detail_movie_fav_btn:
                if (favImageButton.getTag().equals("not_fav")) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                            "Added to favourite", Snackbar.LENGTH_LONG);
                    mySnackbar.setAction("Undo", new MyUndoListener());
                    mySnackbar.setActionTextColor(getResources().getColor(R.color.blue));
                    mySnackbar.show();
                    favImageButton.setBackgroundResource(R.drawable.ic_favorite);
                    favImageButton.setTag("fav");
                } else {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                            "Removed from favourite", Snackbar.LENGTH_LONG);
                    mySnackbar.setAction("Undo", new MyUndoListener());
                    mySnackbar.setActionTextColor(getResources().getColor(R.color.blue));
                    mySnackbar.show();
                    favImageButton.setBackgroundResource(R.drawable.ic_favorite_border);
                    favImageButton.setTag("not_fav");
                }
                break;
        }
    }

    private class MyUndoListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (favImageButton.getTag().equals("fav")) {
                favImageButton.setBackgroundResource(R.drawable.ic_favorite_border);
                favImageButton.setTag("not_fav");
            } else {
                favImageButton.setBackgroundResource(R.drawable.ic_favorite);
                favImageButton.setTag("fav");
            }

        }
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
