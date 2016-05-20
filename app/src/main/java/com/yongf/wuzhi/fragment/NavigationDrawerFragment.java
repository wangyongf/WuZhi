/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014
 * 文件名: NavigationDrawerFragment.java
 * 描述:
 * 修改历史:
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-20        新增:Create
 */

package com.yongf.wuzhi.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.yongf.wuzhi.R;
import com.yongf.wuzhi.adapter.MainDrawerListViewAdapter;
import com.yongf.wuzhi.bean.MainDrawerMenuBean;
import com.yongf.wuzhi.factory.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 左侧导航
 *
 * @author Scott Wang
 * @version 1.0, 16-5-20
 * @see
 * @since WuZhi V0.1
 */
public class NavigationDrawerFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView lv_main_drawer_leftmenu;                                                 //定义菜单的listView
    private List<MainDrawerMenuBean> list_menu;
    private OnMenuClickListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_drawer, container, false);

        initLeftMenuControl(view);

        return view;
    }

    /**
     * 初始化左侧菜单列表listView,并为菜单设置点击事件
     *
     * @param view
     */
    private void initLeftMenuControl(View view) {
        lv_main_drawer_leftmenu = (ListView) view.findViewById(R.id.lv_main_drawer_leftmenu);
        list_menu = getMenuItem();
        lv_main_drawer_leftmenu.setAdapter(new MainDrawerListViewAdapter(getActivity(), list_menu));
        lv_main_drawer_leftmenu.setOnItemClickListener(this);

        //设置的点击事件
        LinearLayout llSetting = (LinearLayout) view.findViewById(R.id.ll_setting);
        llSetting.setOnClickListener(this);

        //切换主题的点击事件
        LinearLayout llSwitchTheme = (LinearLayout) view.findViewById(R.id.ll_switchtheme);
        llSwitchTheme.setOnClickListener(this);
    }

    /**
     * 从arrays.xml中取出数据
     *
     * @return
     */
    private List<MainDrawerMenuBean> getMenuItem() {
        List<MainDrawerMenuBean> listMenu = new ArrayList<>();

        String[] itemTitle = getResources().getStringArray(R.array.item_title);
        TypedArray itemIconRes = getResources().obtainTypedArray(R.array.item_icon_res);

        for (int i = 0; i < itemTitle.length; i++) {

            MainDrawerMenuBean lmi = new MainDrawerMenuBean();
            lmi.setMainDrawer_icon(itemIconRes.getResourceId(i, 0));
            lmi.setMainDrawer_menuName(itemTitle[i]);
            listMenu.add(lmi);
        }

        return listMenu;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        if (mListener != null) {
//            mListener.onMenuClick(list_menu.get(position).getMainDrawer_menuName());
//        }
        switch (position) {
//            case
        }
    }

    /**
     * 设置菜单点击接口，以方便外部Activity调用
     */
    public void setOnMenuClickListener(OnMenuClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_setting:
                //进入设置界面
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_content, FragmentFactory.getFragment(FragmentFactory.FRAGMENT_SETTING))
                        .commit();

                break;
            case R.id.ll_switchtheme:
                //切换主题

                break;
        }
    }

    public interface OnMenuClickListener {
        void onMenuClick(String menuName);
    }
}

