package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.net.Uri;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.ungpay.thirdpartyplatformsandframeworks.R;

public class ExoMediaAudioPlayDetailActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private SeekBar seekBar;

    private String audioUrl;
    private String audioImage;
    private String audioTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play_detail);
        initView();
    }

    private void initView() {
        audioImage = getIntent().getStringExtra("audioImage");
        audioUrl = getIntent().getStringExtra("audioUrl");
        audioTitle = getIntent().getStringExtra("audioTitle");
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        ExoPlayer exoPlayer = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
        DataSource.Factory defaultDataSourceFactory = new DefaultDataSourceFactory(this, "audio/mpeg");
        ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource();
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(audioUrl));
        concatenatingMediaSource.addMediaSource(mediaSource);
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.prepare(concatenatingMediaSource);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
