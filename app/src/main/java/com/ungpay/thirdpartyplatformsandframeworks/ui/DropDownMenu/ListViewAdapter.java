package com.ungpay.thirdpartyplatformsandframeworks.ui.DropDownMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

/**
 * created by Summer on 2020/1/15
 */
public class ListViewAdapter extends BaseAdapter {


    private ArrayList<String> datas;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListViewAdapter(ArrayList<String> datas, Context context) {
        this.datas = datas;
        this.context = context;
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
            convertView = layoutInflater.inflate(R.layout.item_constellation_layout, null, true);
            viewHolder.textView = convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(datas.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }

}
