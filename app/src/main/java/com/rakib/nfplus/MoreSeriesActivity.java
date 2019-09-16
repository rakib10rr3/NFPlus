package com.rakib.nfplus;

import android.content.Intent;
import android.os.Bundle;

import com.rakib.nfplus.adapter.SeriesAdapter;
import com.rakib.nfplus.model.series.Series;
import com.rakib.nfplus.utility.GridAutoFitLayoutManager;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MoreSeriesActivity extends AppCompatActivity {

    ArrayList<Series> seriesList = new ArrayList<>();
    SeriesAdapter seriesAdapter;
    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_series);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0f);
        }

        Intent intent = getIntent();
        seriesList = (ArrayList<Series>) intent.getSerializableExtra("seriesList");


        recyclerView = findViewById(R.id.more_series_rv);
        seriesAdapter = new SeriesAdapter(this, seriesList, 1);
        GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getApplicationContext(), 0);
        recyclerView.setAdapter(seriesAdapter);
        recyclerView.setLayoutManager(gridAutoFitLayoutManager);
    }

}
