package com.rakib.nfplus;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.rakib.nfplus.adapter.CricketAdapter;
import com.rakib.nfplus.model.Cricket;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING;

public class CricketFragment extends Fragment {

    private String url = "http://www.espncricinfo.com/scores";
    private String TAG = SportsActivity.class.getSimpleName();
    private ArrayList<Cricket> cricketList = new ArrayList<>();
    private ArrayList<Cricket> tempCricketList = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;
    String result;
    int mScrollPosition;
    boolean isScrolling = false;
    RecyclerView recyclerView;
    ShimmerFrameLayout cricketShimmerLayout;

    Handler handler;
    Runnable runnable;



    public CricketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cricket, container, false);
        recyclerView = view.findViewById(R.id.cricket_rv);
        cricketShimmerLayout = view.findViewById(R.id.shimmer_cricket_container);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                switch (newState) {
                    case SCROLL_STATE_DRAGGING:
                    case SCROLL_STATE_SETTLING:

                        isScrolling = true;

                        break;

                    case SCROLL_STATE_IDLE:

                        isScrolling = false;

                        break;
                }

            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Toast.makeText(getActivity().getApplicationContext(), "Came", Toast.LENGTH_SHORT).show();
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                new MatchAsyncTask().execute();

            }
        };

        handler.post(runnable);
        cricketShimmerLayout.startShimmer();
    }

    private class MatchAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //cricketShimmerLayout.startShimmer();

            Log.e(TAG, "onPreExecute: 111111111111111");

            tempCricketList.clear();

            Log.e(TAG, "onPreExecute: 2222222222222222");


            recyclerView.setNestedScrollingEnabled(false);

            recyclerView.setItemAnimator(null);

            if (mLayoutManager != null) {
                mScrollPosition = ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
            } else {
                mScrollPosition = 0;
            }

//            recyclerView.setAdapter(null);

            Log.e(TAG, "onPreExecute: 3333333333333333");

        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).get();
                Elements elements = document.select("div[class=cscore cscore--live cricket cscore--watchNotes]");
                int size = elements.size();
                Log.d(TAG, "doInBackground: " + String.valueOf(size));
                for (int i = 0; i < size; i++) {


                    Elements elementStatus = document.select("span[class=cscore_date]").eq(i);
                    String status = elementStatus.text();
                    Log.d(TAG, "doInBackground: Status " + status);

                    Elements elementOverview = document.select("div[class=cscore_info-overview]").eq(i);
                    String overview = elementOverview.text();
                    Log.d(TAG, "doInBackground: Overview " + overview);


                    Elements elementHomeTeamShortName = document.select("li[class=cscore_item cscore_item--home]").select("span[class=cscore_name cscore_name--abbrev]").eq(i);
                    Elements elementAwayTeamShortName = document.select("li[class=cscore_item cscore_item--away]").select("span[class=cscore_name cscore_name--abbrev]").eq(i);

                    Elements elementHomeTeamName = document.select("li[class=cscore_item cscore_item--home]").select("span[class=cscore_name cscore_name--long]").eq(i);
                    Elements elementAwayTeamName = document.select("li[class=cscore_item cscore_item--away]").select("span[class=cscore_name cscore_name--long]").eq(i);

                    String homeTeamName = elementHomeTeamName.text();
                    String awayTeamName = elementAwayTeamName.text();

                    String homeTeamShortName = elementHomeTeamShortName.text();
                    String awayTeamShortName = elementAwayTeamShortName.text();

                    String homeTeamIcon = document.select("li[class=cscore_item cscore_item--home]").select("img").eq(i).attr("data-src");
                    String awayTeamIcon = document.select("li[class=cscore_item cscore_item--away]").select("img").eq(i).attr("data-src");

                    Log.d(TAG, "doInBackground: homeIcon " + homeTeamIcon);
                    Log.d(TAG, "doInBackground: awayIcon " + awayTeamIcon);

                    Log.d(TAG, "doInBackground: Home short " + homeTeamShortName);
                    Log.d(TAG, "doInBackground: Away short " + awayTeamShortName);

                    Log.d(TAG, "doInBackground: Home Full " + homeTeamName);
                    Log.d(TAG, "doInBackground: Away Full " + awayTeamName);


                    Elements elementHomeTeamscore = document.select("li[class=cscore_item cscore_item--home]").select("div[class=cscore_score]").eq(i);
                    String homeTeamScore = elementHomeTeamscore.text();
                    Log.d(TAG, "doInBackground: Home Score " + homeTeamScore);


                    Elements elementAwayTeamScore = document.select("li[class=cscore_item cscore_item--away]").select("div[class=cscore_score]").eq(i);
                    String awayTeamScore = elementAwayTeamScore.text();
                    Log.d(TAG, "doInBackground: Away Score " + awayTeamScore);

                    Elements elementResult = document.select("div[class=cscore_commentary cscore_commentary--footer]").eq(i);
                    if (elementResult != null) {
                        result = elementResult.text();
                    }

                    Log.d(TAG, "doInBackground: Result " + result);


                    tempCricketList.add(new Cricket(status, overview, homeTeamIcon, homeTeamShortName, homeTeamName, homeTeamScore, awayTeamIcon, awayTeamShortName, awayTeamName, awayTeamScore, result));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            try {

                cricketList = (ArrayList<Cricket>) tempCricketList.clone();

                Log.e(TAG, "onPostExecute: 44444444444444444444444");

//                if (mLayoutManager != null) {
//                    mScrollPosition = ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
//                } else {
//                    mScrollPosition = 0;
//                }

                Log.e(TAG, "onPostExecute: 5555555555555555555555555555");

                CricketAdapter cricketAdapter = new CricketAdapter(getActivity().getApplicationContext(), cricketList);
                Log.e(TAG, "onPostExecute: 666666666666666666666666666666");

                mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                Log.e(TAG, "onPostExecute: 77777777777777777777777777");
                recyclerView.setLayoutManager(mLayoutManager);
                Log.e(TAG, "onPostExecute: 888888888888888888888888888888");
                recyclerView.setAdapter(cricketAdapter);

                cricketShimmerLayout.stopShimmer();
                if (mLayoutManager != null && cricketList.size() >= mScrollPosition && !isScrolling) {

                    Log.e(TAG, "onPostExecute: akdjflk;ajkds");
                    mLayoutManager.scrollToPosition(mScrollPosition);

                }

                recyclerView.setNestedScrollingEnabled(true);

            } catch (Exception e) {

            }


            handler.postDelayed(runnable, 45000);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        cricketShimmerLayout.stopShimmer();
    }
}
