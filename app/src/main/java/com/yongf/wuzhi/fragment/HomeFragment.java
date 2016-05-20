/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: HomeFragment						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-21       新增：Create	
 */

package com.yongf.wuzhi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStripExtends;
import com.yongf.wuzhi.R;
import com.yongf.wuzhi.adapter.HomeFragmentPagerAdapter;
import com.yongf.wuzhi.base.BaseFragment;
import com.yongf.wuzhi.util.UIUtils;

/**
 * 主页Fragment
 *
 * @author Scott Wang
 * @version 1.0, 16-5-21
 * @see
 * @since WuZhi V0.1
 */
public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";

    private ViewPager viewPager; // 对应的viewPager

    /**
     * 主界面标题栏
     */
    private String[] mMainTitles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getChildFragmentManager(),
                mMainTitles);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        PagerSlidingTabStripExtends pagerTab = (PagerSlidingTabStripExtends) view.findViewById(R.id.pagertab);
        pagerTab.setViewPager(viewPager);

        return view;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mMainTitles = UIUtils.getStringArray(R.array.main_titles);
    }
}
