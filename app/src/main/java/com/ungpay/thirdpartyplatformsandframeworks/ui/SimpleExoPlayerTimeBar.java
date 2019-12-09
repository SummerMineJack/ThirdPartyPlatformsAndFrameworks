package com.ungpay.thirdpartyplatformsandframeworks.ui;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.TimeBar;
import com.ungpay.thirdpartyplatformsandframeworks.R;

public class SimpleExoPlayerTimeBar extends AppCompatActivity implements DefaultTimeBar.OnScrubListener {


    private Handler handler;
    private Runnable runnable;
    private int position;
    private DefaultTimeBar defaultTimeBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_exo_player_time_bar);
        defaultTimeBar = findViewById(R.id.exo_progress);
        handler = new Handler();
        runnable = () -> {
            position++;
            defaultTimeBar.setPosition(position);
            handler.postDelayed(runnable, 500);
        };
        handler.post(runnable);

    }

    @Override
    public void onScrubStart(TimeBar timeBar, long position) {

    }

    @Override
    public void onScrubMove(TimeBar timeBar, long position) {

    }

    @Override
    public void onScrubStop(TimeBar timeBar, long position, boolean canceled) {

    }

}
