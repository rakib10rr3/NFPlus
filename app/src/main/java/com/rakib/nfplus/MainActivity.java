package com.rakib.nfplus;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;

import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.rakib.nfplus.receiver.ConnectionChangeReceiver;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    ConnectionChangeReceiver connectionChangeReceiver;


    SliderLayout sliderLayout;

    AppBarLayout appBarLayout;

    RelativeLayout tvRelativeLayout, moviesRelativeLayout, seriesRelativeLayout, newsRelativeLayout, sportsRelativeLayout, moreRelativeLayout, serverErrorRelativeLayout, mainContentRelativeLayout;
    boolean connected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initializeViews();

        connectionChangeReceiver = new ConnectionChangeReceiver();

    }

    private void initializeViews() {
        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SCALE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :
        setSliderViews();

        appBarLayout = findViewById(R.id.main_app_bar);
        mainContentRelativeLayout = findViewById(R.id.rl_main_content);
        tvRelativeLayout = findViewById(R.id.main_tv_rl);
        moviesRelativeLayout = findViewById(R.id.main_movie_rl);
        seriesRelativeLayout = findViewById(R.id.main_series_rl);
        newsRelativeLayout = findViewById(R.id.main_news_rl);
        sportsRelativeLayout = findViewById(R.id.main_sports_rl);
        moreRelativeLayout = findViewById(R.id.main_more_rl);
        serverErrorRelativeLayout = findViewById(R.id.rl_server_error);

        tvRelativeLayout.setOnClickListener(this);
        moviesRelativeLayout.setOnClickListener(this);
        seriesRelativeLayout.setOnClickListener(this);
        newsRelativeLayout.setOnClickListener(this);
        sportsRelativeLayout.setOnClickListener(this);
        moreRelativeLayout.setOnClickListener(this);

    }


    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);


            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg");
                    break;
                case 1:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg");
                    break;
                case 2:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/8Qsr8pvDL3s1jNZQ4HK1d1Xlvnh.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("https://image.tmdb.org/t/p/original/o5T8rZxoWSBMYwjsUFUqTt6uMQB.jpg");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_tv_rl:
                //Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, TVActivity.class));
                break;
            case R.id.main_movie_rl:
                startActivity(new Intent(MainActivity.this, MoviesActivity.class));
                break;
            case R.id.main_series_rl:
                startActivity(new Intent(MainActivity.this, SeriesActivity.class));
                break;
            case R.id.main_news_rl:
                //Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, NewsActivity.class));
                break;
            case R.id.main_sports_rl:
                startActivity(new Intent(MainActivity.this, SportsActivity.class));
                //Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_more_rl:
                Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void updateInternetConnectionStatusView(boolean isConnected) {

        if (isConnected) {
            connected = true;
            serverErrorRelativeLayout.setVisibility(View.INVISIBLE);
//            appBarLayout.setVisibility(View.VISIBLE);
            mainContentRelativeLayout.setVisibility(View.VISIBLE);
        } else {
            connected = false;
            serverErrorRelativeLayout.setVisibility(View.VISIBLE);
//            appBarLayout.setVisibility(View.INVISIBLE);
            mainContentRelativeLayout.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(connectionChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(connectionChangeReceiver);
    }
}
