package com.ungpay.thirdpartyplatformsandframeworks.exoMedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.LinkedList;

public class ExoMediaVideoPlayActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView audio_list_view;
    private LinkedList<AudioEntity> audioEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_video_play);
        audio_list_view = findViewById(R.id.audio_list_view);
        initDatas();
        audio_list_view.setAdapter(new AudioAdapter());
        audio_list_view.setOnItemClickListener(this);
    }

    private void initDatas() {
        audioEntities = new LinkedList<>();
        audioEntities.add(new AudioEntity("视频1", "https://mp4.vjshi.com/2018-04-24/b8b3f99ce0a309fef608ce5b25cecd98.mp4", ""));
        audioEntities.add(new AudioEntity("视频2", "https://mp4.vjshi.com/2017-08-11/2bf01372409e582488a0e624289f1d05.mp4", ""));
        audioEntities.add(new AudioEntity("视频3", "https://mp4.vjshi.com/2017-08-08/1927e316b477a0b7a98b1251aab4f0d9.mp4", ""));
        audioEntities.add(new AudioEntity("视频4", "https://mp4.vjshi.com/2019-07-21/e92aeaf3e09ba0adf1f0bdc234587d04.mp4", ""));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(ExoMediaVideoPlayActivity.this, ExoMediaVideoPlayDetailActivity.class).putExtra("videoUrl", audioEntities.get(position).getAudioUrl()));
    }

    class AudioAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return audioEntities.size();
        }

        @Override
        public Object getItem(int position) {
            return audioEntities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(ExoMediaVideoPlayActivity.this).inflate(R.layout.activity_main_list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = convertView.findViewById(R.id.item_button);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.textView.setText(audioEntities.get(position).getAudioTitle());
            return convertView;
        }

        class ViewHolder {
            TextView textView;
        }
    }

}
