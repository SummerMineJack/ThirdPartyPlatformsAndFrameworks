package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.ungpay.thirdpartyplatformsandframeworks.R;

public class ExoMediaAudioPlayDetailActivity extends AppCompatActivity {

    private String audioUrl;
    private String audioImage;
    private String audioTitle;

    private DefaultTimeBar exo_progress;
    private ImageView play;
    private ImageView pause;
    private TextView text;
    private TextView tv_start_time;
    private TextView tv_end_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play_detail);
        audioImage = getIntent().getStringExtra("audioImage");
        audioUrl = getIntent().getStringExtra("audioUrl");
        audioTitle = getIntent().getStringExtra("audioTitle");
        initView();
    }

    private void initView() {
        exo_progress = findViewById(R.id.exo_progress);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        text = findViewById(R.id.text);
        tv_start_time = findViewById(R.id.tv_start_time);
        tv_end_time = findViewById(R.id.tv_end_time);


    }
}
