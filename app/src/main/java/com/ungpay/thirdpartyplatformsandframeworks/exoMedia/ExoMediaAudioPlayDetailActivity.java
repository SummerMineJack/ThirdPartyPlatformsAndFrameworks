package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.devbrackets.android.exomedia.core.audio.ExoAudioPlayer;
import com.ungpay.thirdpartyplatformsandframeworks.MyApplication;
import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.manager.PlaylistManager;

import org.jetbrains.annotations.NotNull;

public class ExoMediaAudioPlayDetailActivity extends AppCompatActivity {

    private String audioUrl;
    private String audioImage;
    private String audioTitle;

    private ImageView artworkView;
    private ProgressBar loadingBar;
    private SeekBar seekBar;
    private ImageButton previousButton;
    private ImageButton playPauseButton;
    private ImageButton nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play_detail);
        initView();
    }

    private void initView() {
        audioUrl = getIntent().getStringExtra("audioUrl");
        audioImage = getIntent().getStringExtra("audioImage");
        audioTitle = getIntent().getStringExtra("audioTitle");
        artworkView = findViewById(R.id.artworkView);
        loadingBar = findViewById(R.id.loadingBar);
        seekBar = findViewById(R.id.seekBar);
        previousButton = findViewById(R.id.previousButton);
        playPauseButton = findViewById(R.id.playPauseButton);
        nextButton = findViewById(R.id.nextButton);
        init();
    }

    private void init() {
        setupListeners();
    }

    private void setupListeners() {
        seekBar.setOnSeekBarChangeListener(new SeekBarChanged());
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                MyApplication.getInstance().getPlaylistManager().invokePausePlay();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    private final class SeekBarChanged implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
        }

        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        }

        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        }

        public SeekBarChanged() {
        }
    }
}
