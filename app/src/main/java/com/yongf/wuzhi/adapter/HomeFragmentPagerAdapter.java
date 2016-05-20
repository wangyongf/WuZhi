/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014 		
 * 文件名: MyPagerAdapter.java						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-20        新增:Create	
 */

package com.yongf.wuzhi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yongf.wuzhi.factory.FragmentFactory;
import com.yongf.wuzhi.util.LogUtils;

/**
 * 主界面ViewPager的Adapter
 *
 * @author Scott Wang
 * @version 1.0, 16-5-20
 * @see
 * @since WuZhi V0.1
 */
public class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {

    /**
     * 标题栏数据
     */
    private String[] mData;

    public HomeFragmentPagerAdapter(FragmentManager fm, String[] data) {
        super(fm);

        this.mData = data;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = FragmentFactory.getFragment(position);

        LogUtils.sf("初始化: " + mData[position]);

        return fragment;
    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mData[position];
    }
}
