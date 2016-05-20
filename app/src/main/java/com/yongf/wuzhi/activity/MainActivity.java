/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014
 * 文件名: MainActivity.java
 * 描述:
 * 修改历史:
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-20        新增:Create
 *  1.1         Scott Wang     16-5-20        新增:创建主界面的3个Fragment
 */

package com.yongf.wuzhi.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.astuetz.PagerSlidingTabStripExtends;
import com.yongf.wuzhi.R;
import com.yongf.wuzhi.factory.FragmentFactory;
import com.yongf.wuzhi.util.LogUtils;
import com.yongf.wuzhi.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 *
 * @author Scott Wang
 * @version 1.1, 16-5-20
 * @see
 * @since WuZhi V0.1
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 主界面标题栏
     */
    private String[] mMainTitles;

    private View view1, view2, view3;
    private List<View> viewList;// view数组
    private ViewPager viewPager; // 对应的viewPager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mMainTitles = UIUtils.getStringArray(R.array.main_titles);
    }

    /**
     * 初始化视图
     */
    private void initView() {
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.fragment_yesterday, null);
        view2 = inflater.inflate(R.layout.fragment_recent, null);
        view3 = inflater.inflate(R.layout.fragment_history, null);

        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        PagerSlidingTabStripExtends pagerTab = (PagerSlidingTabStripExtends) findViewById(R.id.pagertab);
        pagerTab.setViewPager(viewPager);
    }



    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.getFragment(position);

            LogUtils.sf("初始化: " + mMainTitles[position]);

            return fragment;
        }

        @Override
        public int getCount() {
            return mMainTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mMainTitles[position];
        }
    }
}
