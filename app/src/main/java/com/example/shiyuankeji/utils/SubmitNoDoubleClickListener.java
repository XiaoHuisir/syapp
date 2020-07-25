package com.example.shiyuankeji.utils;

import android.view.View;

import java.util.Calendar;
/**
 * Created by zhanghui on 20/7/4.
 * 提交订单专用
 */
public abstract class SubmitNoDoubleClickListener implements View.OnClickListener{

    public static final int MIN_CLICK_DELAY_TIME = 3000;//这里设置不能超过多长时间

    private long lastClickTime = 0;


    protected abstract void onNoDoubleClick(View v);

    @Override

    public void onClick(View v) {

        long currentTime = Calendar.getInstance().getTimeInMillis();

        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {

            lastClickTime = currentTime;

            onNoDoubleClick(v);

        }

    }

}
