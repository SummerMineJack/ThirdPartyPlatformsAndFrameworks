package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.adapter.MediaAdapter;

import java.util.ArrayList;

public class ExoMediaAudioPlayActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView audio_list_view;
    private ArrayList<AudioEntity> audioEntities;
    private String audioImages1 = "http://img1.imgtn.bdimg.com/it/u=1520187695,2225171474&fm=26&gp=0.jpg";
    private String audioImages2 = "http://img3.imgtn.bdimg.com/it/u=1503864203,711345928&fm=26&gp=0.jpg";
    private String audioImages3 = "http://img0.imgtn.bdimg.com/it/u=1497648444,3784776034&fm=11&gp=0.jpg";
    private String audioImages4 = "http://img3.imgtn.bdimg.com/it/u=1207843602,4213974193&fm=26&gp=0.jpg";



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play);
        audio_list_view = findViewById(R.id.audio_list_view);
        initDatas();
        audio_list_view.setAdapter(new MediaAdapter(this, audioEntities));
        audio_list_view.setOnItemClickListener(this);
    }

    private void initDatas() {
        audioEntities = new ArrayList<>();
        audioEntities.add(new AudioEntity("卢根 - 安娜的日记", "https://www.audio-lingua.eu/IMG/mp3/lu_gen_-_anna_de_riji.mp3", audioImages1));
        audioEntities.add(new AudioEntity("任伟 - 盐一样的智慧", "https://www.audio-lingua.eu/IMG/mp3/renwei_yan_yiyang_de_zhihui.mp3", audioImages2));
        audioEntities.add(new AudioEntity("任伟 - 民间故事", "https://www.audio-lingua.eu/IMG/mp3/renwei_minjian_gushi.mp3", audioImages3));
        audioEntities.add(new AudioEntity("历史名城北京", "https://www.audio-lingua.eu/IMG/mp3/mingcheng_beijing_yan.mp3", audioImages4));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(ExoMediaAudioPlayActivity.this, ExoMediaAudioPlayDetailActivity.class).putExtra("audioUrl", audioEntities.get(position).getAudioUrl()).putExtra(
                "audioTitle", audioEntities.get(position).getAudioTitle()).putExtra("audioImage", audioEntities.get(position).getAudioImage()));
    }


}
