package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.Timer;
import java.util.TimerTask;

public class ExoMediaAudioPlayDetailActivity extends AppCompatActivity implements OnSeekBarChangeListener, OnClickListener {

    private String audioUrl;
    private String audioImage;
    private String audioTitle;
    private TextView audio_time_start;
    private TextView audio_time_end;


    private SeekBar audio_seek_bar;
    private MediaPlayer mediaPlayer;
    private ToggleButton toggleButton;
    private TextView audio_title;
    private ImageView audio_bg_image;
    private Button audio_fast_forward_15;
    private Button audio_go_back_15;
    private Timer timer;
    private TimerTask timerTask;


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
        audio_time_end = findViewById(R.id.audio_time_end);
        audio_time_start = findViewById(R.id.audio_time_start);
        audio_seek_bar = findViewById(R.id.audio_seek_bar);
        toggleButton = findViewById(R.id.audio_toggle_play_stop);
        audio_title = findViewById(R.id.audio_title);
        audio_bg_image = findViewById(R.id.audio_bg_image);
        audio_fast_forward_15 = findViewById(R.id.audio_fast_forward_15);
        audio_go_back_15 = findViewById(R.id.audio_go_back_15);
        audio_seek_bar.setOnSeekBarChangeListener(this);
        Glide.with(this).load(audioImage).into(audio_bg_image);
        initMediaPlayer();
    }

    private void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, Uri.parse(audioUrl));
        audio_seek_bar.setMax(mediaPlayer.getDuration());
        checkPlayProgress();
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                mediaPlayer.start();
            }else{
                mediaPlayer.stop();
            }
        });
    }

    private void checkPlayProgress() {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                audio_seek_bar.setProgress(mediaPlayer.getCurrentPosition());
            }
        };
        timer.schedule(timerTask, 0, 10);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mediaPlayer.seekTo(seekBar.getProgress());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.audio_go_back_15:
                break;
            case R.id.audio_fast_forward_15:
                break;
        }
    }
}
