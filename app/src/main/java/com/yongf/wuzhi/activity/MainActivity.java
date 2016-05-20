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

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStripExtends;
import com.yongf.wuzhi.R;
import com.yongf.wuzhi.adapter.HomeFragmentPagerAdapter;
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
public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    /**
     * 主界面标题栏
     */
    private String[] mMainTitles;

    private View view1, view2, view3;
    private List<View> viewList;// view数组
    private ViewPager viewPager; // 对应的viewPager
    private Toolbar mToolbar;                             //定义toolbar
    private ActionBarDrawerToggle mDrawerToggle;         //定义toolbar左上角的弹出左侧菜单按钮
    private DrawerLayout mDrawerMain;                    //定义左侧滑动布局，其实就是主布局

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();
        initToolbar();
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

        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(),
                mMainTitles);

        viewPager.setAdapter(adapter);

        PagerSlidingTabStripExtends pagerTab = (PagerSlidingTabStripExtends) findViewById(R.id.pagertab);
        pagerTab.setViewPager(viewPager);
    }

    /**
     * 初始化Toolbar，并设置Toolbar中的菜单与标题，并与DrawerLayout.DrawerListener相关联，设置动态图标
     */
    public void initToolbar() {
        mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        mToolbar.setTitle("首页");                     // 标题的文字需在setSupportActionBar之前，不然会无效
        setSupportActionBar(mToolbar);

        //为了生成，工具栏左上角的动态图标，要使用下面的方法
        mDrawerMain = (DrawerLayout) findViewById(R.id.drawer_main);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerMain, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerMain.setDrawerListener(mDrawerToggle);

        //设置Toolbar的item点击事件的监听
        mToolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_toolbar_about:
                showCopyright();

                break;
            case R.id.main_toolbar_register:
                isQuit();

                break;
        }

        return true;
    }

    /**
     * 显示版权信息
     */
    private void showCopyright() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("关于")
                .setMessage("所有内容的版权归属于问题和答案的作者")
                .setNegativeButton("我知道了", null)
                .create();
        dialog.show();
    }

    /**
     * 退出应用的对话框
     */
    private void isQuit() {
        new AlertDialog.Builder(this)
                .setTitle("确认退出?").
                setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("取消", null).create().show();
    }

}
