package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

public class ListViewGroups extends AppCompatActivity {
    private CategoryAdapter mCustomBaseAdapter;
    private ArrayList<HomeBookTestQuestionTestBeanContent> homeBookTestQuestionTestBeanContents;
    private ArrayList<HomeBookTestQuestionTestBean> homeBookTestQuestionTestBeans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_groups);

        ListView listView = findViewById(R.id.list_view);

        // 数据
        ArrayList<HomeBookTestQuestionTestBean> listData = initData();

        mCustomBaseAdapter = new CategoryAdapter(getBaseContext(), listData);

        // 适配器与ListView绑定
        listView.setAdapter(mCustomBaseAdapter);

        listView.setOnItemClickListener(new ItemClickListener());
    }


    private class ItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Toast.makeText(getBaseContext(), (String) mCustomBaseAdapter.getItem(position),
                    Toast.LENGTH_SHORT).show();
        }

    }


    private ArrayList<HomeBookTestQuestionTestBean> initData() {
        homeBookTestQuestionTestBeanContents = new ArrayList<>();
        homeBookTestQuestionTestBeans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            HomeBookTestQuestionTestBeanContent homeBookTestQuestionTestBeanContent = new HomeBookTestQuestionTestBeanContent();
            homeBookTestQuestionTestBeanContent.setQuestionContent(i + "、问题内容");
            homeBookTestQuestionTestBeanContents.add(homeBookTestQuestionTestBeanContent);
        }

        for (int i = 0; i < 10; i++) {
            HomeBookTestQuestionTestBean homeBookTestQuestionTestBean = new HomeBookTestQuestionTestBean();
            homeBookTestQuestionTestBean.setOrderList(homeBookTestQuestionTestBeanContents);
            homeBookTestQuestionTestBean.setQuestionTitle(i + "、问题标题");
            homeBookTestQuestionTestBeans.add(homeBookTestQuestionTestBean);
        }
        return homeBookTestQuestionTestBeans;
    }
}
