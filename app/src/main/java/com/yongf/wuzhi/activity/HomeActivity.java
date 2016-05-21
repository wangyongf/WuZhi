/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014
 * 文件名: MainActivity.java
 * 描述:
 * 修改历史:
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-20        新增:Create
 *  1.1         Scott Wang     16-5-20        新增:创建主界面的3个Fragment
 *  1.2         Scott Wang     16-5-21        新增:去掉NavigationDrawerFragment,直接使用FrameLayout
 */

package com.yongf.wuzhi.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.yongf.wuzhi.R;
import com.yongf.wuzhi.adapter.MainDrawerListViewAdapter;
import com.yongf.wuzhi.bean.MainDrawerMenuBean;
import com.yongf.wuzhi.factory.FragmentFactory;
import com.yongf.wuzhi.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 *
 * @author Scott Wang
 * @version 1.2, 16-5-20
 * @see
 * @since WuZhi V0.1
 */
public class HomeActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, View.OnClickListener, AdapterView.OnItemClickListener {

    private Toolbar mToolbar;                             //定义toolbar
    private ActionBarDrawerToggle mDrawerToggle;         //定义toolbar左上角的弹出左侧菜单按钮
    private DrawerLayout mDrawerMain;                    //定义左侧滑动布局，其实就是主布局
    private ListView mLvMainDrawerLeftMenu;                                                 //定义菜单的listView
    private List<MainDrawerMenuBean> listMenu = new ArrayList<>();
    private FragmentManager mFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

        setDefaultFragment();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        getMenuItem();
        mFm = getSupportFragmentManager();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        initLeftMenuControl();
        initToolbar();
    }

    /**
     * 设置默认的Fragment
     */
    private void setDefaultFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_content, new HomeFragment())
                .commit();
    }

    /**
     * 从arrays.xml中取出数据
     *
     * @return
     */
    private void getMenuItem() {
        String[] itemTitle = getResources().getStringArray(R.array.item_title);
        TypedArray itemIconRes = getResources().obtainTypedArray(R.array.item_icon_res);

        for (int i = 0; i < itemTitle.length; i++) {

            MainDrawerMenuBean lmi = new MainDrawerMenuBean();
            lmi.setMainDrawer_icon(itemIconRes.getResourceId(i, 0));
            lmi.setMainDrawer_menuName(itemTitle[i]);
            listMenu.add(lmi);
        }
    }

    /**
     * 初始化左侧菜单列表listView,并为菜单设置点击事件
     */
    private void initLeftMenuControl() {
        mLvMainDrawerLeftMenu = (ListView) findViewById(R.id.lv_main_drawer_leftmenu);
        mLvMainDrawerLeftMenu.setAdapter(new MainDrawerListViewAdapter(this, listMenu));
        mLvMainDrawerLeftMenu.setOnItemClickListener(this);

        //设置
        LinearLayout llSetting = (LinearLayout) findViewById(R.id.ll_setting);
        llSetting.setOnClickListener(this);

        //切换主题
        LinearLayout llSwitchTheme = (LinearLayout) findViewById(R.id.ll_switchtheme);
        llSwitchTheme.setOnClickListener(this);

        //关于
        LinearLayout llAbout = (LinearLayout) findViewById(R.id.ll_about);
        llAbout.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        mDrawerMain.closeDrawers();

        switch (v.getId()) {
            case R.id.ll_setting:
                //进入设置界面
                mFm.beginTransaction()
                        .replace(R.id.fl_content, FragmentFactory.getFragment(FragmentFactory.FRAGMENT_SETTING))
                        .commit();

                break;
            case R.id.ll_switchtheme:
                //切换主题
                mFm.beginTransaction()
                        .replace(R.id.fl_content, FragmentFactory.getFragment(FragmentFactory.FRAGMENT_SWITCHTHEME))
                        .commit();

                break;
            case R.id.ll_about:
                //关于
                mFm.beginTransaction()
                        .replace(R.id.fl_content, FragmentFactory.getFragment(FragmentFactory.FRAGMENT_ABOUT))
                        .commit();

                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mDrawerMain.closeDrawers();

        switch (position) {
            case 0:     //首页
                mFm.beginTransaction()
                        .replace(R.id.fl_content, new HomeFragment())
                        .commit();

                break;
        }
    }
}
