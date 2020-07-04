package com.example.shiyuankeji.utils;
/**
 * /**
 *  * Created by zhanghui on 20/7/4.
 *
 * */
//防止连续点击的触发事件
public class UtilsClicktime {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {

        long time = System.currentTimeMillis();

        if (time - lastClickTime < 1000) {

            return true;

        }

        lastClickTime = time;

        return false;

    }
}
