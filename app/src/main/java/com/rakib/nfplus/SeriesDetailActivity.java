package com.rakib.nfplus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.rakib.nfplus.adapter.GenreAdapter;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SeriesDetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView titleTextView;
    TextView storyTextView;


    ImageView backDropImageView;
    ImageView playImageView;
    AppBarLayout appBarLayout;
    ImageButton favImageButton;

    String title;
    String story;
    String backdrop;
    String runTime;
    String genres;

    List<String> genreList;
    RecyclerView genreRecyclerView;
    GenreAdapter genreAdapter;

    GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detail);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //replaceFragment(new EpisodesFragment());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        title = getIntent().getStringExtra("title");
        backdrop = getIntent().getStringExtra("backdrop");
        story = getIntent().getStringExtra("story");

        String genre = getIntent().getStringExtra("genres");
        genreList = Arrays.asList(genre.split(","));

        try {
            runTime = getIntent().getStringExtra("runTime");
        } catch (Exception e) {
            runTime = " ";
        }

        initializeViews();

        titleTextView.setText(title);
        Glide.with(getApplicationContext()).load(backdrop).into(backDropImageView);
        storyTextView.setText(story);

        if (!genreList.get(0).equals("")) {
            genreAdapter = new GenreAdapter(SeriesDetailActivity.this, genreList,2);
            gridLayoutManager = new GridLayoutManager(SeriesDetailActivity.this, 1, GridLayoutManager.HORIZONTAL, false);
            genreRecyclerView.setAdapter(genreAdapter);
            genreRecyclerView.setLayoutManager(gridLayoutManager);
        } else {
            genreRecyclerView.setVisibility(View.GONE);
        }


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(final AppBarLayout appBarLayout,final int verticalOffset) {
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
                    Fragment fragment = new EpisodesFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("runTime", runTime);
                    fragment.setArguments(bundle);
                    replaceFragment(fragment);
                }

                if (tab.getPosition() == 1) {
                    replaceFragment(new MoreLikeThisSeriesFragment());
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

        appBarLayout = findViewById(R.id._series_app_bar);

        titleTextView = findViewById(R.id.detail_series_title);
        storyTextView = findViewById(R.id.detail_series_story);

        favImageButton = findViewById(R.id.detail_series_fav_btn);
        favImageButton.setOnClickListener(this);

        backDropImageView = findViewById(R.id.thumbnail_image);
        playImageView = findViewById(R.id.detail_play);
        genreRecyclerView = findViewById(R.id.detail_chip_rv);

        playImageView.setOnClickListener(this);

        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/original/9nC9onD2z30RciJdG4UcTNYw0RU.jpg").into(backDropImageView);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment fragment = new EpisodesFragment();
                Bundle bundle = new Bundle();
                bundle.putString("runTime", runTime);
                fragment.setArguments(bundle);
                replaceFragment(fragment);
            }
        }, 200);
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
                startActivity(new Intent(this, PlayerActivity.class));
                break;
            case R.id.detail_series_fav_btn:
                if (favImageButton.getTag().equals("not_fav")) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                            "Added to favourite", Snackbar.LENGTH_LONG);
                    mySnackbar.setAction("Undo", new MyUndoListener());
                    mySnackbar.setActionTextColor(getResources().getColor(R.color.colorPrimary));
                    mySnackbar.show();
                    favImageButton.setBackgroundResource(R.drawable.ic_favorite_series);
                    favImageButton.setTag("fav");
                } else {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                            "Removed from favourite", Snackbar.LENGTH_LONG);
                    mySnackbar.setAction("Undo", new MyUndoListener());
                    mySnackbar.setActionTextColor(getResources().getColor(R.color.colorPrimary));
                    mySnackbar.show();
                    favImageButton.setBackgroundResource(R.drawable.ic_favorite_border_series);
                    favImageButton.setTag("not_fav");
                }
                break;
        }
    }

    private class MyUndoListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (favImageButton.getTag().equals("fav")) {
                favImageButton.setBackgroundResource(R.drawable.ic_favorite_border_series);
                favImageButton.setTag("not_fav");
            } else {
                favImageButton.setBackgroundResource(R.drawable.ic_favorite_series);
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
