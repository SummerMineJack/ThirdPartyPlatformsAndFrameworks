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

public class ExoMediaAudioPlayActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView audio_list_view;
    private LinkedList<AudioEntity> audioEntities;
    private String audioImages = "https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=92afee66fd36afc3110c39658318eb85/908fa0ec08fa513db777cf78376d55fbb3fbd9b3.jpg";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_media_audio_play);
        audio_list_view = findViewById(R.id.audio_list_view);
        initDatas();
        audio_list_view.setAdapter(new AudioAdapter());
        audio_list_view.setOnItemClickListener(this);
    }

    private void initDatas() {
        audioEntities = new LinkedList<>();
        audioEntities.add(new AudioEntity("卢根 - 安娜的日记", "https://www.audio-lingua.eu/IMG/mp3/lu_gen_-_anna_de_riji.mp3", audioImages));
        audioEntities.add(new AudioEntity("任伟 - 盐一样的智慧", "https://www.audio-lingua.eu/IMG/mp3/renwei_yan_yiyang_de_zhihui.mp3", audioImages));
        audioEntities.add(new AudioEntity("任伟 - 民间故事", "https://www.audio-lingua.eu/IMG/mp3/renwei_minjian_gushi.mp3", audioImages));
        audioEntities.add(new AudioEntity("历史名城北京", "https://www.audio-lingua.eu/IMG/mp3/mingcheng_beijing_yan.mp3", audioImages));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(ExoMediaAudioPlayActivity.this, ExoMediaAudioPlayDetailActivity.class).putExtra("audioUrl", audioEntities.get(position).getAudioUrl()).putExtra(
                "audioTitle", audioEntities.get(position).getAudioTitle()).putExtra("audioImage", audioEntities.get(position).getAudioImage()));
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
                convertView = LayoutInflater.from(ExoMediaAudioPlayActivity.this).inflate(R.layout.activity_main_list_item, null);
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
