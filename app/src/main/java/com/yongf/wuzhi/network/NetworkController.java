/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: NetworkController						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-21       新增：Create	
 */

package com.yongf.wuzhi.network;

import com.yongf.wuzhi.util.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * 网络访问模块,负责发起网络请求
 *
 * @author Scott Wang
 * @version 1.0, 16-5-21
 * @see
 * @since WuZhi V0.1
 */
public class NetworkController {

    private static final String TAG = "NetworkController";

    /**
     * 发送http请求,请求方式为GET
     *
     * @param address
     * @param listener
     */
    public static void sendHttpRequest(final String address, final IHttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = null;
                InputStream in = null;
                try {
                    URL url = new URL(address);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(8000);
                    conn.setReadTimeout(8000);
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    in = conn.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    //回调onFinish
                    if (listener != null) {
                        listener.onFinish(response.toString());
                    }
                } catch (ProtocolException e) {
                    e.printStackTrace();

                    if (listener != null) {
                        listener.onError(e);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                    if (listener != null) {
                        listener.onError(e);
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (conn != null) {
                        conn.disconnect();
                    }
                    IOUtils.close(in);
                }
            }
        }).start();
    }
}
