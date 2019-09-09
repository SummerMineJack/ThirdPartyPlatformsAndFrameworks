package com.ungpay.thirdpartyplatformsandframeworks.ui.alipayui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.blankj.utilcode.util.SizeUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

public class AlipayHomeActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private AppBarLayout abl_bar;
    private View v_title_big_mask;
    private View v_toolbar_small_mask;
    private View v_toolbar_search_mask;
    private View include_toolbar_search;
    private View include_toolbar_small;
    private Toolbar toolbars;
    private int mMaskColor;

    private SmartRefreshLayout swipeRefreshLayout;

    private RecycleViewAdapter recycleViewAdapter;
    private ArrayList<String> datas;
    private RecyclerView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置沉浸式状态栏,可参考https://github.com/gyf-dev/ImmersionBar
        setContentView(R.layout.activity_alipay_home);
        //AppBarLayout
        abl_bar = findViewById(R.id.abl_bar);
        abl_bar.addOnOffsetChangedListener(this);
        listView = findViewById(R.id.recycleView);
        listView.setLayoutManager(new LinearLayoutManager(AlipayHomeActivity.this));

        include_toolbar_search = findViewById(R.id.include_toolbar_search);
        include_toolbar_small = findViewById(R.id.include_toolbar_small);
        toolbars = findViewById(R.id.toolbars);
        v_toolbar_search_mask = findViewById(R.id.v_toolbar_search_mask);
        v_title_big_mask = findViewById(R.id.v_title_big_mask);
        v_toolbar_small_mask = findViewById(R.id.v_toolbar_small_mask);
        mMaskColor = getResources().getColor(R.color.bar_color);
        swipeRefreshLayout = findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setDragRate(1.8f);
        swipeRefreshLayout.setRefreshHeader(new ClassicsHeader(this));
        setRecycler_views();
    }

    private void setRecycler_views() {
        initData();
        recycleViewAdapter = new RecycleViewAdapter(AlipayHomeActivity.this, datas);
        listView.setAdapter(recycleViewAdapter);
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("这是数据;" + i);
        }
    }

    //AppBarLayout的监听方法
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        Log.d("aaa", "verticalOffset=" + verticalOffset);
        //720*1080手机 verticalOffset取值范围[0-200]px
        int absVerticalOffset = Math.abs(verticalOffset);//AppBarLayout竖直方向偏移距离px
        int totalScrollRange = appBarLayout.getTotalScrollRange();//AppBarLayout总的距离px
        //背景颜色转化成RGB的渐变色
        int argb = Color.argb(absVerticalOffset, Color.red(mMaskColor), Color.green(mMaskColor), Color.blue(mMaskColor));
        int argbDouble = Color.argb(absVerticalOffset * 2, Color.red(mMaskColor), Color.green(mMaskColor), Color.blue(mMaskColor));
        //appBarLayout上滑一半距离后小图标应该由渐变到全透明
        int title_small_offset = (200 - absVerticalOffset) < 0 ? 0 : 200 - absVerticalOffset;
        int title_small_argb = Color.argb(title_small_offset * 2, Color.red(mMaskColor),
                Color.green(mMaskColor), Color.blue(mMaskColor));
        //appBarLayout上滑不到一半距离
        if (absVerticalOffset <= totalScrollRange / 2) {
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbars.getLayoutParams();
            layoutParams.width = CollapsingToolbarLayout.LayoutParams.MATCH_PARENT;
            layoutParams.height = SizeUtils.dp2px(150);
            toolbars.setLayoutParams(layoutParams);
            include_toolbar_search.setVisibility(View.VISIBLE);
            include_toolbar_small.setVisibility(View.GONE);
            //为了和下面的大图标渐变区分,乘以2倍渐变
            v_toolbar_search_mask.setBackgroundColor(argbDouble);
        } else {
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbars.getLayoutParams();
            layoutParams.width = CollapsingToolbarLayout.LayoutParams.MATCH_PARENT;
            layoutParams.height = SizeUtils.dp2px(70);
            toolbars.setLayoutParams(layoutParams);
            include_toolbar_search.setVisibility(View.GONE);
            include_toolbar_small.setVisibility(View.VISIBLE);
            //appBarLayout上滑一半距离后小图标应该由渐变到全透明
            v_toolbar_small_mask.setBackgroundColor(title_small_argb);

        }
        //上滑时遮罩由全透明到半透明
        v_title_big_mask.setBackgroundColor(argb);
    }
}
