package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.DemoListAdapter;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

public class ExoMediaChooseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView audio_video;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_choose);
        audio_video = findViewById(R.id.audio_video);
        initDatas();
        audio_video.setAdapter(new DemoListAdapter(datas, ExoMediaChooseActivity.this));
        audio_video.setOnItemClickListener(this);
    }

    private void initDatas() {
        datas = new ArrayList<>();
        datas.add("音频播放");
        datas.add("视频播放");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(ExoMediaChooseActivity.this, ExoMediaAudioPlayActivity.class));
                break;
            case 1:
                startActivity(new Intent(ExoMediaChooseActivity.this, ExoMediaVideoPlayActivity.class));
                break;
        }
    }
}
