package com.example.shiyuankeji.utils;

import android.text.TextUtils;
import android.util.Log;


import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.interfaces.IBaseView;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private IBaseView mView;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(IBaseView view){
        mView = view;
    }

    protected CommonSubscriber(IBaseView view, String emsg){
        mView = view;
        errorMsg = emsg;
    }

    protected CommonSubscriber(IBaseView view, boolean isError){
        mView = view;
        isShowErrorState = isError;
    }

    protected CommonSubscriber(IBaseView view, String emsg, boolean isError){
        mView = view;
        errorMsg = emsg;
        isShowErrorState = isError;
    }

    @Override
    public void onError(Throwable t) {
        Log.e("Tabss",t+"");
        //LoadingUtil.getInstance().hideLoading();
        if(mView == null)
            return;
        if(errorMsg != null && TextUtils.isEmpty(errorMsg)){
            mView.showError(errorMsg);
        }else{
            mView.showError();
        }
        //检测服务器是否中断(后加的不属于框架中的)
        InterceptorUtil.InterceptorCallback callBack = InterceptorUtil.getInstance().getCallBack();
        if (callBack != null) {
            callBack.on401();
        }

    }

    @Override
    public void onComplete() {
        //LoadingUtil.getInstance().hideLoading();
    }
}
