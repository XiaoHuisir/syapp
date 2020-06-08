package com.example.shiyuankeji.widgets.verificationcode;

/**
 * Created by zhanghui on 16/8/3.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

/**
 * 网络判断
 */
public class NetUtil {
    private static Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");

    public static boolean checkNet(Context context) {
        // 判断是否具有可以用于通信渠道
        boolean mobileConnection = isMobileConnection(context);
        boolean wifiConnection = isWIFIConnection(context);
        if ( mobileConnection == false && wifiConnection == false ) {
            // 没有网络
            return false;
        } else {
            if ( mobileConnection ) {
                // IP是10.0.0.172 端口是80 010.000.000.172
                // 读取apn内正在处于使用状态的接入点的代理和端口

                // 访问联系人
                // ContentProvider
//				setApn(context);
            }
        }
        return true;
    }

    /**
     * 查询当前系统中处于活动状态的apn信息
     *
     * @param context
     */
/*	private static void setApn(Context context)
    {
		ContentResolver resolver = context.getContentResolver();
		Cursor query = resolver.query(PREFERRED_APN_URI, null, null, null, null);
		if (query != null && query.moveToFirst())
		{
			GlobalParams.PROXY_IP = query.getString(query.getColumnIndex("proxy"));
			GlobalParams.PROXY_PORT = query.getInt(query.getColumnIndex("port"));
			query.close();
		}

	}*/

    /**
     * 判断手机接入点（APN）是否处于可以使用的状态
     *
     * @param context
     * @return
     */
    public static boolean isMobileConnection(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ( networkInfo != null && networkInfo.isConnected() ) {
            return true;
        }
        return false;
    }

    /**
     * 判断当前wifi是否是处于可以使用状态
     *
     * @param context
     * @return
     */
    public static boolean isWIFIConnection(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if ( networkInfo != null && networkInfo.isConnected() ) {
            return true;
        }
        return false;
    }

    /**
     * 判断当前的网络是否为WIFI网络 是 true 否 false
     *
     * @param ctx
     * @return
     */
    public static boolean isWiFiNetwork(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if ( connectivityManager != null ) {
            final NetworkInfo net = connectivityManager.getActiveNetworkInfo();
            if ( net != null && net.getType() == ConnectivityManager.TYPE_WIFI ) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
