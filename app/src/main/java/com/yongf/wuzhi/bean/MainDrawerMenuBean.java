/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: MainDrawerMenu						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-4-29       新增：Create	
 */

package com.yongf.wuzhi.bean;

/**
 * ${description}
 *
 * @author Scott Wang
 * @version 1.0, 16-4-29
 * @see
 * @since GooglePlay1.0
 */

/**
 * 左侧侧滑菜单内容类
 * Created by cg on 2015/10/23.
 */
public class MainDrawerMenuBean {
    private int mainDrawer_icon;                      //菜单的图标
    private String mainDrawer_menuName;               //菜单的名称

    public MainDrawerMenuBean() {
    }

    public MainDrawerMenuBean(int mainDrawer_icon, String mainDrawer_menuName) {
        this.mainDrawer_icon = mainDrawer_icon;
        this.mainDrawer_menuName = mainDrawer_menuName;
    }

    /**
     * 得到菜单图标
     *
     * @return
     */
    public int getMainDrawer_icon() {
        return mainDrawer_icon;
    }

    /**
     * 设置菜单图标
     *
     * @param mainDrawer_icon
     */
    public void setMainDrawer_icon(int mainDrawer_icon) {
        this.mainDrawer_icon = mainDrawer_icon;
    }

    /**
     * 得到菜单名称
     *
     * @return
     */
    public String getMainDrawer_menuName() {
        return mainDrawer_menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param mainDrawer_menuName
     */
    public void setMainDrawer_menuName(String mainDrawer_menuName) {
        this.mainDrawer_menuName = mainDrawer_menuName;
    }
}

