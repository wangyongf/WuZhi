/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: Main_Drawer_lv_Adapter						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-4-29       新增：Create	
 */

package com.yongf.wuzhi.adapter;

/**
 * ${description}
 *
 * @author Scott Wang
 * @version 1.0, 16-4-29
 * @see
 * @since GooglePlay1.0
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yongf.wuzhi.R;
import com.yongf.wuzhi.bean.MainDrawerMenuBean;

import java.util.List;

/**
 * 左侧侧滑菜单的adpter
 * Created by cg on 2015/10/26.
 */
public class MainDrawerListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<MainDrawerMenuBean> list_menu;                   //菜单名称与图标的list,采用了一个类

    public MainDrawerListViewAdapter(Context context, List<MainDrawerMenuBean> list_menu) {
        inflater = LayoutInflater.from(context);
        this.list_menu = list_menu;
    }

    @Override
    public int getCount() {
        return list_menu.size();
    }

    @Override
    public Object getItem(int position) {
        return list_menu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        menuItem mItem;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_main_drawer_item, null);
            mItem = new menuItem();
            mItem.icon = (ImageView) convertView.findViewById(R.id.item_icon);
            mItem.title = (TextView) convertView.findViewById(R.id.item_title);
            convertView.setTag(mItem);
        } else {
            mItem = (menuItem) convertView.getTag();
        }

        mItem.icon.setImageResource(list_menu.get(position).getMainDrawer_icon());
        mItem.title.setText(list_menu.get(position).getMainDrawer_menuName());

        return convertView;
    }

    class menuItem {
        ImageView icon;
        TextView title;
    }
}

