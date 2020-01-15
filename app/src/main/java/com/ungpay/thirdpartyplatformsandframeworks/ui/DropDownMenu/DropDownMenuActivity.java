package com.ungpay.thirdpartyplatformsandframeworks.ui.DropDownMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DropDownMenuActivity extends Activity {

    private DropDownMenu mDropDownMenu;
    private TextView content;
    private String headers[] = {"附近", "智能排序"};
    private List<View> popupViews = new ArrayList<>();

    private ListDropDownAdapter sexAdapter;
    private ConstellationAdapter constellationAdapter;

    private String sexs[] = {"不限", "男", "女"};
    private String constellations[] = {"不限", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};

    private int constellationPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_menu);
        mDropDownMenu = findViewById(R.id.dropDownMenu);
        content = findViewById(R.id.content);
        initView();
    }

    private void initView() {
        //init sex menu
        final ListView sexView = new ListView(this);
        sexView.setDividerHeight(0);
        sexAdapter = new ListDropDownAdapter(this, Arrays.asList(sexs));
        sexView.setAdapter(sexAdapter);

        //init constellation
        final View constellationView = getLayoutInflater().inflate(R.layout.custom_layout, null);
        ListView lsLeft = constellationView.findViewById(R.id.list_view_left);
        ListView lsRight = constellationView.findViewById(R.id.list_view_right);
        constellationAdapter = new ConstellationAdapter(this, Arrays.asList(constellations));
        lsLeft.setAdapter(constellationAdapter);
        lsRight.setAdapter(constellationAdapter);
        popupViews.add(sexView);
        popupViews.add(constellationView);
        sexView.setOnItemClickListener((parent, view, position, id) -> {
            sexAdapter.setCheckItem(position);
            mDropDownMenu.setTabText(position == 0 ? headers[2] : sexs[position]);
            mDropDownMenu.closeMenu();
        });

        lsLeft.setOnItemClickListener((parent, view, position, id) -> {
            constellationAdapter.setCheckItem(position);
            constellationPosition = position;
        });

        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, content);
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
