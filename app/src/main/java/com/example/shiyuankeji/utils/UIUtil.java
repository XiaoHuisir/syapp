package com.example.shiyuankeji.utils;

import android.content.Context;
import android.util.TypedValue;

public class UIUtil {
    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float dp2px(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, float px) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, context.getResources().getDisplayMetrics());
    }
}
