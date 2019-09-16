package com.rakib.nfplus;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.rakib.nfplus.adapter.TvAdapter;
import com.rakib.nfplus.model.Tv;
import com.rakib.nfplus.utility.ItemOffsetDecoration;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TVActivity extends AppCompatActivity implements View.OnClickListener {

    List<Tv> tvList;
    List<Tv> sportsTvList;
    TvAdapter tvAdapter;
    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;
    SliderLayout sliderLayout;
    MaterialButton moreFavButton, moreSportsButton, moreComedyButton;
    ItemOffsetDecoration itemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvList = new ArrayList<>();
        sportsTvList = new ArrayList<>();

        tvList.add(new Tv("HBO", "http://www.logospng.com/images/43/hbo-logo-logok-43742.png", "hbo.com"));
        tvList.add(new Tv("HBO", "http://www.logospng.com/images/43/hbo-logo-logok-43742.png", "hbo.com"));
        tvList.add(new Tv("HBO", "http://www.logospng.com/images/43/hbo-logo-logok-43742.png", "hbo.com"));
        tvList.add(new Tv("HBO", "http://www.logospng.com/images/43/hbo-logo-logok-43742.png", "hbo.com"));
        tvList.add(new Tv("HBO", "http://www.logospng.com/images/43/hbo-logo-logok-43742.png", "hbo.com"));
        tvList.add(new Tv("HBO", "http://www.logospng.com/images/43/hbo-logo-logok-43742.png", "hbo.com"));


        sportsTvList.add(new Tv("Star Sports 2", "https://banner2.kisspng.com/20180920/hqu/kisspng-logo-star-sports-television-channel-5ba332dba39855.6830968815374220436701.jpg", "hbo.com"));
        sportsTvList.add(new Tv("Star Sports 2", "https://banner2.kisspng.com/20180920/hqu/kisspng-logo-star-sports-television-channel-5ba332dba39855.6830968815374220436701.jpg", "hbo.com"));
        sportsTvList.add(new Tv("Star Sports 2", "https://banner2.kisspng.com/20180920/hqu/kisspng-logo-star-sports-television-channel-5ba332dba39855.6830968815374220436701.jpg", "hbo.com"));
        sportsTvList.add(new Tv("Star Sports 2", "https://banner2.kisspng.com/20180920/hqu/kisspng-logo-star-sports-television-channel-5ba332dba39855.6830968815374220436701.jpg", "hbo.com"));
        sportsTvList.add(new Tv("Star Sports 2", "https://banner2.kisspng.com/20180920/hqu/kisspng-logo-star-sports-television-channel-5ba332dba39855.6830968815374220436701.jpg", "hbo.com"));
        sportsTvList.add(new Tv("Star Sports 2", "https://banner2.kisspng.com/20180920/hqu/kisspng-logo-star-sports-television-channel-5ba332dba39855.6830968815374220436701.jpg", "hbo.com"));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0f);
        }

        moreFavButton = findViewById(R.id.tv_fav_all_btn);
        moreFavButton.setOnClickListener(this);
        recyclerView = findViewById(R.id.tv_favourite_rv);
        tvAdapter = new TvAdapter(this, tvList, 0);
        gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(tvAdapter);
        itemDecoration = new ItemOffsetDecoration(getApplicationContext(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(gridLayoutManager);


        moreSportsButton = findViewById(R.id.tv_sports_all_btn);
        moreSportsButton.setOnClickListener(this);
        recyclerView = findViewById(R.id.tv_sports_rv);
        tvAdapter = new TvAdapter(this, sportsTvList, 0);
        gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(tvAdapter);
        itemDecoration = new ItemOffsetDecoration(getApplicationContext(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onClick(View v) {

    }
}
