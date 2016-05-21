/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: Contants						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-20       新增：Create	
 */

package com.yongf.wuzhi.conf;

import com.yongf.wuzhi.util.LogUtils;

/**
 * ${description}
 *
 * @author Scott Wang
 * @version 1.0, 16-5-20
 * @see
 * @since WuZhi V0.1
 */
public class Constants {

    /**
     * 关闭日志的显示
     */
    public static final int DEBUG_LEVEL = LogUtils.LEVEL_ALL;
    /**
     * 普通线程池核心线程数量
     */
    public static final int NORMAL_POOL_CORE_POOL_SIZE = 5;
    /**
     * 普通线程池最大线程数量
     */
    public static final int NORMAL_POOL_MAX_POOL_SIZE = 5;
    /**
     * 普通线程池线程保持时间
     */
    public static final int NORMAL_POOL_KEEP_ALIVE_TIME = 3000;
    /**
     * 下载线程池核心线程数量
     */
    public static final int DOWNLOAD_POOL_CORE_POOL_SIZE = 3;
    /**
     * 下载线程池最大线程数量
     */
    public static final int DOWNLOAD_POOL_MAX_POOL_SIZE = 3;
    /**
     * 下载线程池线程保持时间
     */
    public static final int DOWNLOAD_POOL_KEEP_ALIVE_TIME = 3000;

    public static final class URLs {

        /**
         * 服务器地址
         */
        public static final String HOST = "http://api.kanzhihu.com/";

        /**
         * getposts
         * eg: http://api.kanzhihu.com/getposts
         */
        public static final String GET_POSTS = HOST + "getposts";

        /**
         * getpostanswers
         * eg: http://api.kanzhihu.com/getpostanswers/20160521/archive
         */
        public static final String GET_POST_ANSWERS = HOST + "getpostanswers/";
    }
}
