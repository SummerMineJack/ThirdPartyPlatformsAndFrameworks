package com.ungpay.thirdpartyplatformsandframeworks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.AudioEntity;

import java.util.ArrayList;

public class MediaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AudioEntity> audioEntities;

    public MediaAdapter(Context context, ArrayList<AudioEntity> audioEntities) {
        this.context = context;
        this.audioEntities = audioEntities;
    }

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
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_main_list_item, null);
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