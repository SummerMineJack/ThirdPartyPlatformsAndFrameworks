package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {

    private static final int TYPE_CATEGORY_ITEM = 0;
    private static final int TYPE_ITEM = 1;

    private ArrayList<HomeBookTestQuestionTestBean> mListData;
    private LayoutInflater mInflater;


    public CategoryAdapter(Context context, ArrayList<HomeBookTestQuestionTestBean> pData) {
        mListData = pData;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        int count = 0;
        if (null != mListData) {
            //  所有分类中item的总和是ListVIew  Item的总个数  
            for (HomeBookTestQuestionTestBean category : mListData) {
                count += category.getItemCount();
            }
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        // 异常情况处理
        if (null == mListData || position < 0 || position > getCount()) {
            return null;
        }
        // 同一分类内，第一个元素的索引值
        int categroyFirstIndex = 0;
        for (HomeBookTestQuestionTestBean category : mListData) {
            int size = category.getItemCount();
            // 在当前分类中的索引值  
            int categoryIndex = position - categroyFirstIndex;
            // item在当前分类内  
            if (categoryIndex < size) {
                return category.getItem(categoryIndex);
            }

            // 索引移动到当前分类结尾，即下一个分类第一个元素索引  
            categroyFirstIndex += size;
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        // 异常情况处理  
        if (null == mListData || position < 0 || position > getCount()) {
            return TYPE_ITEM;
        }


        int categroyFirstIndex = 0;

        for (HomeBookTestQuestionTestBean category : mListData) {
            int size = category.getItemCount();
            // 在当前分类中的索引值  
            int categoryIndex = position - categroyFirstIndex;
            if (categoryIndex == 0) {
                return TYPE_CATEGORY_ITEM;
            }

            categroyFirstIndex += size;
        }

        return TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case TYPE_CATEGORY_ITEM:
                if (null == convertView) {
                    convertView = mInflater.inflate(R.layout.activity_fragment_home_read_book_test_question_recycle_view_item_header, null);
                }

                TextView textView = convertView.findViewById(R.id.cb_question_option_item_header);
                String itemValue = (String) getItem(position);
                textView.setText(itemValue);
                break;

            case TYPE_ITEM:
                ViewHolder viewHolder = null;
                if (null == convertView) {

                    convertView = mInflater.inflate(R.layout.activity_fragment_home_read_book_test_question_recycle_view_item_data, null);

                    viewHolder = new ViewHolder();
                    viewHolder.checkBox = convertView.findViewById(R.id.cb_question_option_item);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }

                // 绑定数据
                viewHolder.checkBox.setText((String) getItem(position));
                break;
        }

        return convertView;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return getItemViewType(position) != TYPE_CATEGORY_ITEM;
    }


    private class ViewHolder {
        CheckBox checkBox;
    }

}