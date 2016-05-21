/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: HttpCallbackListener						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-21       新增：Create	
 */

package com.yongf.wuzhi.network;

/**
 * http请求的回调接口
 *
 * @author Scott Wang
 * @version 1.0, 16-5-21
 * @see
 * @since WuZhi V0.1
 */
public interface IHttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
