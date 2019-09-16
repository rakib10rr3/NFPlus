package com.rakib.nfplus;

import android.os.Bundle;

import com.rakib.nfplus.adapter.NewsAdapter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Logger.addLogAdapter(new AndroidLogAdapter());


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0f);
        }

//        WebView webView = findViewById(R.id.news_web);
//        webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSettings.setSupportMultipleWindows(false);
//        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        webView.loadUrl("https://portal.kslbd.net/news/");

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = obj.getJSONArray("news");
            ArrayList<HashMap<String, String>> finalList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> tempList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                //Add your values in your `ArrayList` as below:
                tempList = new HashMap<String, String>();
                tempList.put("name", jsonObject.getString("name"));
                tempList.put("link", jsonObject.getString("link"));
                tempList.put("img", jsonObject.getString("img"));

                finalList.add(tempList);
            }
            //Logger.d(String.valueOf(finalList.size()));
            Logger.d(finalList.get(0).get("name"));
            recyclerView = findViewById(R.id.rv_news);
            newsAdapter = new NewsAdapter(this, finalList);
            gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
           // GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(getApplicationContext(), 0);

            recyclerView.setAdapter(newsAdapter);
            recyclerView.setLayoutManager(gridLayoutManager);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("news_list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Logger.d(json);
        return json;
    }

}
