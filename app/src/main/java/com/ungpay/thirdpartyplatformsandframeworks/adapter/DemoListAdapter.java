package com.ungpay.thirdpartyplatformsandframeworks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

public class DemoListAdapter extends BaseAdapter {

    private ArrayList<String> datas;
    private LayoutInflater layoutInflater;

    public DemoListAdapter(ArrayList<String> datas, Context context) {
        this.datas = datas;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.activity_main_list_item, null);
            viewHolder.btnDemo = convertView.findViewById(R.id.item_button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.btnDemo.setText(datas.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView btnDemo;
    }
}