/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: AboutFragment						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-21       新增：Create	
 */

package com.yongf.wuzhi.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yongf.wuzhi.R;
import com.yongf.wuzhi.base.BaseFragment;
import com.yongf.wuzhi.util.UIUtils;

/**
 * AboutFragment
 *
 * @author Scott Wang
 * @version 1.0, 16-5-21
 * @see
 * @since WuZhi V0.1
 */
public class AboutFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "AboutFragment";

    /**
     * 联系作者
     */
    private TextView tvContact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        tvContact = (TextView) view.findViewById(R.id.tv_contact);
        tvContact.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_contact:
                ContactMe();

                break;
        }
    }

    /**
     * 联系作者
     */
    private void ContactMe() {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("联系作者")
                .setView(R.layout.contact_author)
                .setPositiveButton("我知道了", null)
                .setNegativeButton("发送邮件", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //这里是发送邮件的逻辑
                        Toast.makeText(UIUtils.getContext(), "给我发邮件吧...", Toast.LENGTH_SHORT).show();
                    }
                }).create();
        dialog.show();
    }
}
