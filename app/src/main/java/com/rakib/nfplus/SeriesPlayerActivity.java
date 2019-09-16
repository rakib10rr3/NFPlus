package com.rakib.nfplus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.rakib.nfplus.model.series.Episode;
import com.rakib.nfplus.receiver.ConnectionChangeReceiver;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class SeriesPlayerActivity extends AppCompatActivity implements Player.EventListener, VideoRendererEventListener, AudioRendererEventListener {

    private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    private static final String TAG = SeriesPlayerActivity.class.getSimpleName();

    private SimpleExoPlayer player;
    private PlayerView playerView;
    private ProgressBar progressBar;

    private long playbackPosition;
    private int currentWindow;
    private long bufferedPosition;
    private boolean playWhenReady = true;
    boolean connected = false;
    ConnectionChangeReceiver connectionChangeReceiver;
    MediaSource mediaSource;


    LinearLayout playbackButtonsll;

    String url, url1;
    boolean doubleBackToExitPressedOnce = false;

    TextView titleTextView;
    ImageButton imageButton;

    View leftViewLayout;
    View rightViewLayout;

    List<Episode> episodes;
    int totalEpisodes;
    int episodeIndex;
    List<MediaSource> mediaSources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_player);

        playerView = findViewById(R.id.video_view);
        progressBar = findViewById(R.id.progress_bar);
        playbackButtonsll = findViewById(R.id.playback_buttons);

        titleTextView = findViewById(R.id.player_title);
        imageButton = findViewById(R.id.img_btn_player_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        episodes = (ArrayList<Episode>) getIntent().getSerializableExtra("episodes");
        episodeIndex = getIntent().getIntExtra("episodeIndex",0);

        titleTextView.setText(episodes.get(episodeIndex).getEpisodeData().getName());

        connectionChangeReceiver = new ConnectionChangeReceiver();

        url = getIntent().getStringExtra("url");
        url = "http://www.ctghall.com/Data/TV-Series/TV-Series1/Friends/Season%201/Friends%20-%201x01%20-%20The%20One%20Where%20Monica%20Gets%20A%20Roommate.mkv";
        url1 = "http://www.ctghall.com/Data/TV-Series/TV-Series1/Friends/Season%201/Friends%20-%201x02%20-%20The%20One%20With%20The%20Sonogram%20At%20The%20End.mkv";

        //titleTextView.setText(getIntent().getStringExtra("title"));

        leftViewLayout = findViewById(R.id.leftViewLayout);

        leftViewLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {

                if (doubleBackToExitPressedOnce) {
                    doubleBackToExitPressedOnce = false;
                    //Toast.makeText(PlayerActivity.this, "lkajsdflkjaklsd", Toast.LENGTH_SHORT).show();
                    player.seekTo(player.getCurrentPosition() - 10000);
                    return false;
                }

                doubleBackToExitPressedOnce = true;

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;

                    }
                }, 1000);

                return false;
            }
        });

        rightViewLayout = findViewById(R.id.rightViewLayout);
        rightViewLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {

                if (doubleBackToExitPressedOnce) {
                    doubleBackToExitPressedOnce = false;
                    //Toast.makeText(PlayerActivity.this, "lkajsdflkjaklsd", Toast.LENGTH_SHORT).show();
                    player.seekTo(player.getCurrentPosition() + 10000);
                    return false;
                }

                doubleBackToExitPressedOnce = true;

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;

                    }
                }, 1000);

                return false;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
            Logger.w("onStart SDK > 23");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //registerReceiver(connectionChangeReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        if ((Util.SDK_INT <= 23 || player == null)) {
            Logger.w("onResume If");
            initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //unregisterReceiver(connectionChangeReceiver);
        if (Util.SDK_INT <= 23) {
            Logger.d("onPause SDK <= 23");
            releasePlayer();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
            Logger.d("onStop SDK > 23");
        }
    }

    private void initializePlayer() {

        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(this, DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON), new DefaultTrackSelector(), new DefaultLoadControl());
            progressBar.setVisibility(View.VISIBLE);
            playbackButtonsll.setVisibility(View.GONE);
            playerView.setPlayer(player);
            player.setPlayWhenReady(playWhenReady);
            Logger.w("initializePlayer: current window " + String.valueOf(currentWindow) + " current position " + String.valueOf(playbackPosition));
            player.seekTo(currentWindow, playbackPosition);
        }
        mediaSource = buildMediaSource();
        player.prepare(mediaSource, false, false);
        player.seekTo(episodeIndex, C.TIME_UNSET);
        //Toast.makeText(this, "seek", Toast.LENGTH_SHORT).show();
        player.addListener(this);
    }

    private void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            Logger.d("releasePlayer: playbackPosition " + String.valueOf(playbackPosition));
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
            player.release();
            player = null;
        }
    }

    private MediaSource buildMediaSource() {
        final String userAgent = "rakib-exoplayer";

        mediaSources = new ArrayList<>();
        for (int i = 0; i < episodes.size(); i++) {
            mediaSources.add(new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent)).createMediaSource(Uri.parse(episodes.get(i).getEpisodeData().getWatchlink())));
        }

        MediaSource[] mediaSourceArr = new MediaSource[mediaSources.size()];
        mediaSourceArr = mediaSources.toArray(mediaSourceArr);

//            MediaSource firstSource = new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent)).createMediaSource(Uri.parse(url));
//        MediaSource secondSource = new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent)).createMediaSource(Uri.parse(url1));


//        if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4") || uri.getLastPathSegment().contains("mkv")) {
//            return new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent))
//                    .createMediaSource(uri);
//        } else if (uri.getLastPathSegment().contains("m3u8")) {
//            return new HlsMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent))
//                    .createMediaSource(uri);
//        } else {
//            DashChunkSource.Factory dashChunkSourceFactory = new DefaultDashChunkSource.Factory(
//                    new DefaultHttpDataSourceFactory(userAgent, BANDWIDTH_METER));
//            DataSource.Factory manifestDataSourceFactory = new DefaultHttpDataSourceFactory(userAgent);
//            return new DashMediaSource.Factory(dashChunkSourceFactory, manifestDataSourceFactory).createMediaSource(uri);
//        }
        return new ConcatenatingMediaSource(mediaSourceArr);
    }

    @Override
    public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {

    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        //Toast.makeText(this, "Track Changed", Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, String.valueOf(player.getCurrentWindowIndex()), Toast.LENGTH_SHORT).show();
        titleTextView.setText(episodes.get(player.getCurrentWindowIndex()).getEpisodeData().getName());
        //titleTextView.setText("Khao");


    }

    @Override
    public void onLoadingChanged(boolean isLoading) {

    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        String stateString;
        switch (playbackState) {
            case Player.STATE_IDLE:
                progressBar.setVisibility(View.VISIBLE);
                playbackButtonsll.setVisibility(View.INVISIBLE);
                playbackPosition = bufferedPosition;
                Logger.d("onPlayerStateChanged: " + String.valueOf(playbackPosition));
                stateString = "ExoPlayer.STATE_IDLE      -";
                break;
            case Player.STATE_BUFFERING:
                playbackButtonsll.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                stateString = "ExoPlayer.STATE_BUFFERING -";
                break;
            case Player.STATE_READY:
                playbackButtonsll.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);

                stateString = "ExoPlayer.STATE_READY     -";
                break;
            case Player.STATE_ENDED:
                stateString = "ExoPlayer.STATE_ENDED     -";
                break;
            default:
                stateString = "UNKNOWN_STATE             -";
                break;
        }
        Logger.d("changed state to " + stateString + " playWhenReady: " + playWhenReady);

        if (playbackState == Player.STATE_IDLE || playbackState == Player.STATE_ENDED ||
                !playWhenReady) {

            playerView.setKeepScreenOn(false);
        } else { // STATE_IDLE, STATE_ENDED
            // This prevents the screen from getting dim/lock
            playerView.setKeepScreenOn(true);
        }
    }

    @Override
    public void onRepeatModeChanged(int repeatMode) {

    }

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {

    }

    @Override
    public void onPositionDiscontinuity(int reason) {

    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

    }

    @Override
    public void onSeekProcessed() {

    }


    // Implementing VideoRendererEventListener.

    @Override
    public void onVideoEnabled(DecoderCounters counters) {
        // Do nothing.
    }

    @Override
    public void onVideoDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
        // Do nothing.
    }

    @Override
    public void onVideoInputFormatChanged(Format format) {
        // Do nothing.
    }

    @Override
    public void onDroppedFrames(int count, long elapsedMs) {
        // Do nothing.
    }

    @Override
    public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
        // Do nothing.
    }

    @Override
    public void onRenderedFirstFrame(Surface surface) {
        // Do nothing.
    }

    @Override
    public void onVideoDisabled(DecoderCounters counters) {
        // Do nothing.
    }

    // Implementing AudioRendererEventListener.

    @Override
    public void onAudioEnabled(DecoderCounters counters) {
        // Do nothing.
    }

    @Override
    public void onAudioSessionId(int audioSessionId) {
        // Do nothing.
    }

    @Override
    public void onAudioDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs) {
        // Do nothing.
    }

    @Override
    public void onAudioInputFormatChanged(Format format) {
        // Do nothing.
    }

    @Override
    public void onAudioSinkUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
        // Do nothing.
    }

    @Override
    public void onAudioDisabled(DecoderCounters counters) {
        // Do nothing.
    }


    public void updateInternetConnectionStatusView(boolean isConnected) {

        if (isConnected) {
            Log.d(TAG, "updateInternetConnectionStatusView: Connected");
            Log.d(TAG, "updateInternetConnectionStatusView: " + String.valueOf(playbackPosition));
//            if (playbackPosition == bufferedPosition) {
//                player.seekTo(currentWindow, bufferedPosition);
//            } else {
//                player.seekTo(currentWindow, playbackPosition);
//            }
            player.seekTo(currentWindow, playbackPosition);
            player.prepare(mediaSource, false, false);

            connected = true;
        } else {
            connected = false;
            Log.d(TAG, "updateInternetConnectionStatusView: not Connected");
            playbackPosition = player.getCurrentPosition();
            bufferedPosition = player.getBufferedPosition();
            Log.d(TAG, "updateInternetConnectionStatusView: " + String.valueOf(playbackPosition));
            Log.d(TAG, "updateInternetConnectionStatusView: " + String.valueOf(player.getBufferedPosition()));
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Toast.makeText(this, "Khao", Toast.LENGTH_SHORT).show();
        releasePlayer();
    }

}
