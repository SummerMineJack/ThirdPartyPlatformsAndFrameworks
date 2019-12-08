package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ExoMediaAudioPlayDetailActivity extends AppCompatActivity implements View.OnClickListener, Player.EventListener {

    private String extraAudiUrl;
    private String extraAudiImage;

    //
    private ImageView exo_audio_play;
    private ImageView exo_audio_image;
    private TextView exo_start_time;
    private TextView exo_end_time;
//    private SeekBar exo_seek_bar;

    //
    private SimpleExoPlayer simpleExoPlayer;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play_detail);
        extraAudiImage = getIntent().getStringExtra("audioImage");
        extraAudiUrl = getIntent().getStringExtra("audioUrl");
        initView();
    }

    private void initView() {
        initHandler();
        exo_audio_play = findViewById(R.id.exo_audio_play);
        exo_audio_image = findViewById(R.id.exo_audio_image);
        exo_start_time = findViewById(R.id.exo_start_time);
        exo_end_time = findViewById(R.id.exo_end_time);
        exo_seek_bar = findViewById(R.id.exo_seek_bar);
        Glide.with(this).load(extraAudiImage).into(exo_audio_image);
        exo_audio_play.setOnClickListener(this);
        initExoPlayer();
    }


    private void initExoPlayer() {
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
        DataSource.Factory defaultDataSourceFactory = new DefaultDataSourceFactory(this, "audio/mpeg");
        ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource();
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(extraAudiUrl));
        concatenatingMediaSource.addMediaSource(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
        simpleExoPlayer.prepare(concatenatingMediaSource);
        exo_audio_play.setImageDrawable(getDrawable(android.R.drawable.ic_media_pause));
        simpleExoPlayer.addListener(this);
    }

    private void initHandler() {
        handler = new Handler();
        runnable = () -> {
            long a = (simpleExoPlayer.getCurrentPosition() * 100) / simpleExoPlayer.getDuration();
            exo_seek_bar.setProgress((int) a);
            Log.e("~~setProgress", "setProgress:" + exo_seek_bar.getProgress() + " a:" + a);
            long progress = simpleExoPlayer.getCurrentPosition();
            String progressString = String.format(Locale.getDefault(), "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(progress) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(progress)),
                    TimeUnit.MILLISECONDS.toSeconds(progress) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(progress)));
            exo_start_time.setText(progressString);
            handler.postDelayed(runnable, 1000);
        };
        handler.postDelayed(runnable, 0);
    }

    private boolean durationSet;

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        if (playbackState == ExoPlayer.STATE_READY && !durationSet) {
            long realDurationMillis = simpleExoPlayer.getDuration();
            durationSet = true;
            String time = String.format(Locale.getDefault(), "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(realDurationMillis),
                    TimeUnit.MILLISECONDS.toSeconds(realDurationMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(realDurationMillis)));
            exo_end_time.setText(time);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.stop();
        simpleExoPlayer.release();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exo_audio_play:
                simpleExoPlayer.setPlayWhenReady(!simpleExoPlayer.getPlayWhenReady());
                if (!simpleExoPlayer.getPlayWhenReady()) {
                    exo_audio_play.setImageDrawable(getDrawable(android.R.drawable.ic_media_play));
                } else {
                    exo_audio_play.setImageDrawable(getDrawable(android.R.drawable.ic_media_pause));
                }
                break;
        }
    }
}
