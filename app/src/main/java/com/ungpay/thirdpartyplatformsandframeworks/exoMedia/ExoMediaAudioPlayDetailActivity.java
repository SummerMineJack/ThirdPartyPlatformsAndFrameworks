package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.devbrackets.android.exomedia.util.TimeFormatUtil;
import com.devbrackets.android.playlistcore.api.PlaylistItem;
import com.devbrackets.android.playlistcore.data.MediaProgress;
import com.devbrackets.android.playlistcore.data.PlaybackState;
import com.devbrackets.android.playlistcore.data.PlaylistItemChange;
import com.devbrackets.android.playlistcore.listener.PlaylistListener;
import com.devbrackets.android.playlistcore.listener.ProgressListener;
import com.ungpay.thirdpartyplatformsandframeworks.MyApplication;
import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.manager.PlaylistManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExoMediaAudioPlayDetailActivity extends AppCompatActivity implements PlaylistListener, ProgressListener {

    private String audioUrl;
    private String audioImage;
    private String audioTitle;

    private ImageView artworkView;
    private ProgressBar loadingBar;
    private SeekBar seekBar;
    private ImageButton previousButton;
    private ImageButton playPauseButton;
    private ImageButton nextButton;
    private TextView currentPositionView;


    private PlaylistManager playlistManager;
    private boolean shouldSetDuration;
    private boolean userInteracting;
    private RequestManager glide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play_detail);
        initView();
    }

    private void initView() {
        glide = Glide.with(this);
        playlistManager = MyApplication.getInstance().getPlaylistManager();
        audioUrl = getIntent().getStringExtra("audioUrl");
        audioImage = getIntent().getStringExtra("audioImage");
        audioTitle = getIntent().getStringExtra("audioTitle");
        currentPositionView = findViewById(R.id.currentPositionView);
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
        playlistManager.play(0, false);
    }


    private void setupListeners() {
        seekBar.setOnSeekBarChangeListener(new SeekBarChanged());
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlistManager.invokePrevious();
            }
        });
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlistManager.invokePausePlay();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlistManager.invokeNext();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        playlistManager.unRegisterPlaylistListener(this);
        playlistManager.unRegisterProgressListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        playlistManager = MyApplication.getInstance().getPlaylistManager();
        playlistManager.registerPlaylistListener(this);
        playlistManager.registerProgressListener(this);
        updateCurrentPlaybackInformation();
    }
    private void updateCurrentPlaybackInformation() {
       playlistManager.getCurrentItemChange();
    }

    @Override
    public boolean onPlaybackStateChanged(@NotNull PlaybackState playbackState) {
        switch (playbackState) {
            case STOPPED:
                finish();
                break;
            case PREPARING:
            case SEEKING:
            case RETRIEVING:
                restartLoading();
                break;
            case PLAYING:
                doneLoading(true);
                break;
            case PAUSED:
                doneLoading(false);
                break;
        }
        return false;
    }

    private void doneLoading(boolean isPlaying) {
        loadCompleted();
        updatePlayPauseImage(isPlaying);
    }

    private void updatePlayPauseImage(boolean isPlaying) {
        int resId;
        if (isPlaying) {
            resId = R.drawable.playlistcore_ic_pause_black;
        } else {
            resId = R.drawable.playlistcore_ic_play_arrow_black;
        }
        playPauseButton.setImageResource(resId);
    }

    private void restartLoading() {
        playPauseButton.setVisibility(View.INVISIBLE);
        previousButton.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        loadingBar.setVisibility(View.VISIBLE);
    }

    private void loadCompleted() {
        playPauseButton.setVisibility(View.VISIBLE);
        previousButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        loadingBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public boolean onPlaylistItemChanged(@Nullable PlaylistItem playlistItem, boolean b, boolean b1) {
        return false;
    }

    @Override
    public boolean onProgressUpdated(@NotNull MediaProgress mediaProgress) {
        return false;
    }

    private final class SeekBarChanged implements SeekBar.OnSeekBarChangeListener {
        private int seekPosition;


        public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
            if (!fromUser)
                return;
            seekPosition = progress;
            currentPositionView.setText(TimeFormatUtil.formatMs(progress));
        }

        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            userInteracting = true;
            seekPosition = seekBar.getProgress();
            playlistManager.invokeSeekStarted();
        }

        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            userInteracting = false;
            playlistManager.invokeSeekEnded(seekPosition);
            seekPosition = -1;
        }

    }
}
