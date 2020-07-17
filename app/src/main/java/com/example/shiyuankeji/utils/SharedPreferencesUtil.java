package com.example.shiyuankeji.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatDelegate;

public class SharedPreferencesUtil {

    private static SharedPreferences.Editor editor;

    //添加ui模式
    public static void addModeUI(Context context, boolean bool) {
        editor = context.getSharedPreferences("ModeUI", Context.MODE_PRIVATE).edit();
        editor.putBoolean("mode_ui", bool);
        editor.commit();
    }

    /**
     * 是否是夜间模式
     *
     * @param context
     * @return
     */
    public static int getNight(Context context) {
        boolean bool = context.getSharedPreferences("ModeUI", Context.MODE_PRIVATE).getBoolean("mode_ui", false);
        return bool ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO;
    }


    /**
     * 添加用户token
     *
     * @param context
     * @param token
     */
    public static void addUserToken(Context context, String token) {
        editor = context.getSharedPreferences("user", Context.MODE_PRIVATE).edit();
        editor.putString("token", token);
        editor.commit();
    }


    /**
     * 获取用户token
     *
     * @param context
     * @return
     */
    public static String getToken(Context context) {
        return context.getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", "");
    }


    /**
     * 退出登录删除token
     *
     * @param context
     */
    public static void deleteToken(Context context) {
        editor = context.getSharedPreferences("user", Context.MODE_PRIVATE).edit();
        editor.remove("token");
        editor.commit();
    }

    /**
     * 保存用户名和密码
     *
     * @param name
     * @param pw
     */
    public static void saveUserAndPw(Context context, String name, String pw) {
        editor = context.getSharedPreferences("user", Context.MODE_PRIVATE).edit();
        editor.putString("username", name);
        editor.putString("pw", pw);
        editor.commit();
    }

    /**
     * 获取用户名
     *
     * @param context
     * @return
     */
    public static String getUserName(Context context) {
        return context.getSharedPreferences("user", Context.MODE_PRIVATE).getString("username", "");
    }

    public static String getPw(Context context) {
        return context.getSharedPreferences("user", Context.MODE_PRIVATE).getString("pw", "");
    }

    /**
     * 保存版本号不再提示更新
     *
     * @param status
     */
    public static void addUpdate(Context context, int status) {
        context.getSharedPreferences("version", Context.MODE_PRIVATE).edit();
        editor.putInt("status", status);
        editor.commit();
    }

    public static int getUpdate(Context context) {
        return context.getSharedPreferences("version", Context.MODE_PRIVATE).getInt("status", 0);
    }

    /**
     * 保存权限状态
     *
     * @param context
     * @param isbool
     */
    public static void addIsBool(Context context, boolean isbool) {
        editor = context.getSharedPreferences("booleans", Context.MODE_PRIVATE).edit();
        editor.putBoolean("mode_bool", isbool);
        editor.commit();
    }

    /**
     * 获取保存的权限状态
     *
     * @param context;
     */
    public static boolean getIsBool(Context context) {
        return context.getSharedPreferences("booleans", Context.MODE_PRIVATE).getBoolean("mode_bool", false);
    }

    /**
     * 保存(相机)权限状态
     *
     * @param context
     * @param isxiangbool
     */
    public static void addXiangIsBool(Context context, boolean isxiangbool) {
        editor = context.getSharedPreferences("boolxiangeans", Context.MODE_PRIVATE).edit();
        editor.putBoolean("mode_xiangbool", isxiangbool);
        editor.commit();
    }

    /**
     * 获取保存(相机)的权限状态
     *
     * @param context
     */
    public static boolean getXiangIsBool(Context context) {
        return context.getSharedPreferences("boolxiangeans", Context.MODE_PRIVATE).getBoolean("mode_xiangbool", false);
    }

    /**
     * 保存收货地址状态
     *
     * @param context
     * @param setaddress
     */
    public static void setDeliveryAddress(Context context, boolean setaddress) {
        editor = context.getSharedPreferences("isaddress", Context.MODE_PRIVATE).edit();
        editor.putBoolean("okaddress", setaddress);
        editor.commit();
    }

    /**
     * 获取收货地址状态
     *
     * @param context
     */
    public static boolean getDeliveryAddress(Context context) {
        return context.getSharedPreferences("isaddress", Context.MODE_PRIVATE).getBoolean("okaddress", false);
    }


     /**
     * 添加用户名/手机号
     *
     * @param context
     * @param phone
     */
    public static void addPhone(Context context, String phone) {
        editor = context.getSharedPreferences("phone", Context.MODE_PRIVATE).edit();
        editor.putString("phone", phone);
        editor.commit();
    }


    /**
     * 获取用户名/手机号
     *
     * @param context
     * @return
     */
    public static String getPhones(Context context) {
        return context.getSharedPreferences("phone", Context.MODE_PRIVATE).getString("phone", "");
    }


    /**
     * 删除phone
     *
     * @param context
     */
    public static void deletePhone(Context context) {
        editor = context.getSharedPreferences("phone", Context.MODE_PRIVATE).edit();
        editor.remove("phone");
        editor.commit();
    }
}
