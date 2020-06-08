package com.example.shiyuankeji.widgets.verificationcode;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by zhanghui on 2018/5/10.
 */

public class ProgressDialogShowUtil {
    private static ProgressDialog progressDialog;


    public static ProgressDialog showProgressDialog(Context context , String msg) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        return  progressDialog;
    }

    public static void dismisDialog () {
        if (progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
