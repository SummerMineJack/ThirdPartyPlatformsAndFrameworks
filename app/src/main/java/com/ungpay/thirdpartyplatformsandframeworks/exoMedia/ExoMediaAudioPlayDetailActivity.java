package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.ungpay.thirdpartyplatformsandframeworks.R;

public class ExoMediaAudioPlayDetailActivity extends AppCompatActivity {

    private String audioUrl;
    private String audioImage;
    private String audioTitle;
    private ImageView book_bgImg;
    private TextView audio_title;
    private SeekBar seekBar;
    private PlayListManager playListManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play_detail);
        book_bgImg = findViewById(R.id.book_bgImg);
        audio_title = findViewById(R.id.audio_title);
        seekBar = findViewById(R.id.seekBar);

        audioUrl = getIntent().getStringExtra("audioUrl");
        audioImage = getIntent().getStringExtra("audioImage");
        audioTitle = getIntent().getStringExtra("audioTitle");
        Glide.with(this).load(audioImage).into(book_bgImg);
        audio_title.setText(audioTitle);
        playListManager=new PlayListManager(getApplication(),Mediasev);
        playListManager.invokePausePlay();
    }

}
