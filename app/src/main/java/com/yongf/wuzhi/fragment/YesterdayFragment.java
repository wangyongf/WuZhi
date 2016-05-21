/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: YesterdayFragment						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-20       新增：Create	
 */

package com.yongf.wuzhi.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yongf.wuzhi.R;
import com.yongf.wuzhi.adapter.YesterdayPagerAdapter;
import com.yongf.wuzhi.base.BaseFragment;
import com.yongf.wuzhi.bean.GetPostAnswersBean;
import com.yongf.wuzhi.bean.GetPostAnswersBean.AnswersBean;
import com.yongf.wuzhi.conf.Constants;
import com.yongf.wuzhi.network.IHttpCallbackListener;
import com.yongf.wuzhi.network.NetworkController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 昨日最新
 *
 * @author Scott Wang
 * @version 1.0, 16-5-20
 * @see
 * @since WuZhi V0.1
 */
public class YesterdayFragment extends BaseFragment {

    private static final String TAG = "YesterdayFragment";

    /**
     * getpostanswers成功
     */
    private static final int GETPOSTANSWERS_SUCCESS = 1;
    /**
     * getpostanswers出错
     */
    private static final int GETPOSTANSWERS_ERROR = 0;
    /**
     * 类型: yesterday | recent | archive
     */
    private static final String TYPE = "yesterday";
    private SwipeRefreshLayout mSrlRefresh;
    private GetPostAnswersBean mPostAnswers;
    private RecyclerView mRv;
    private YesterdayPagerAdapter mAdapter;
    private List<AnswersBean> mAnswers = new ArrayList<>();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GETPOSTANSWERS_ERROR:        //getpostanswers出错
                    mSrlRefresh.setRefreshing(false);
                    Toast.makeText(getActivity(), "出错了,稍后再试吧 =_= ||", Toast.LENGTH_LONG).show();

                    break;
                case GETPOSTANSWERS_SUCCESS:        //getpostanswers成功
                    mSrlRefresh.setRefreshing(false);
                    updateAnswers();
            }
        }
    };

    /**
     * 更新列表信息
     */
    private void updateAnswers() {
        mAnswers.clear();
        mAnswers.addAll(mPostAnswers.getAnswers());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_yesterday, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSrlRefresh = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh);
        mSrlRefresh.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        mSrlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        //初始化RecyclerView
        mRv = (RecyclerView) view.findViewById(R.id.rv_yesterday);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new YesterdayPagerAdapter(getActivity(), mAnswers);
        mRv.setAdapter(mAdapter);

        loadData();     //开始加载数据
    }

    /**
     * 加载数据
     */
    private void loadData() {
        mSrlRefresh.setRefreshing(true);

        NetworkController.sendHttpRequest(Constants.URLs.GET_POST_ANSWERS + getDate() + "/" + TYPE,
                new IHttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        parseJson(response);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

    /**
     * 返回一个时间戳,
     * eg: 20160521
     *
     * @return
     */
    private String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        String str = formatter.format(date);

//        return str;
        return "20160521";
    }

    /**
     * 解析getposts返回的JSON
     *
     * @param response
     */
    private void parseJson(String response) {
        Gson gson = new Gson();
        mPostAnswers = gson.fromJson(response,
                new TypeToken<GetPostAnswersBean>() {
                }.getType());

        Message message = Message.obtain();
        if (!TextUtils.isEmpty(mPostAnswers.getError())) {
            message.what = GETPOSTANSWERS_ERROR;
        } else {
            message.what = GETPOSTANSWERS_SUCCESS;

            Log.d(TAG, "parseJson: " + response);
        }
        mHandler.sendMessage(message);
    }
}
