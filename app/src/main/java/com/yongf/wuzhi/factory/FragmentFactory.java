/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: FragmentFactory						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-20       新增：Create	
 */

package com.yongf.wuzhi.factory;

import android.support.v4.util.SparseArrayCompat;

import com.yongf.wuzhi.base.BaseFragment;
import com.yongf.wuzhi.fragment.HistoryFragment;
import com.yongf.wuzhi.fragment.RecentFragment;
import com.yongf.wuzhi.fragment.YesterdayFragment;

/**
 * Fragment工厂类,负责生产Fragment
 *
 * @author Scott Wang
 * @version 1.0, 16-5-20
 * @see
 * @since WuZhi V0.1
 */
public class FragmentFactory {

    public static final int FRAGMENT_YESTERDAY = 0;
    public static final int FRAGMENT_RECENT = 1;
    public static final int FRAGMENT_HISTORY = 2;

    private static final String TAG = "FragmentFactory";
    private static SparseArrayCompat<BaseFragment> cacheFragment = new SparseArrayCompat<>();

    /**
     * 获取具体的Fragment
     *
     * @param position
     *
     * @return
     */
    public static BaseFragment getFragment(int position) {
        BaseFragment fragment = null;

        //如果缓存中存在,直接从缓存中取出并返回
        BaseFragment tmpFragment = cacheFragment.get(position);
        if (tmpFragment != null) {
            fragment = tmpFragment;

            return fragment;
        }

        //缓存中不存在
        switch (position) {
            case FRAGMENT_YESTERDAY:        //昨日最新
                fragment = new YesterdayFragment();

                break;
            case FRAGMENT_RECENT:       //近日热门
                fragment = new RecentFragment();

                break;
            case FRAGMENT_HISTORY:      //历史精华
                fragment = new HistoryFragment();

                break;
        }

        //保存对应的Fragment
        cacheFragment.put(position, fragment);

        return fragment;
    }
}
