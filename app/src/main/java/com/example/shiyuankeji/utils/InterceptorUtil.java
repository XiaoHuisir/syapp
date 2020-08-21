package com.example.shiyuankeji.utils;

public class InterceptorUtil {

    private InterceptorUtil() {
    }

    private static class ClzHolder {
        private static InterceptorUtil instance = new InterceptorUtil();
    }

    public static InterceptorUtil getInstance() {
        return ClzHolder.instance;
    }


    private InterceptorCallback callback;

    public InterceptorCallback getCallBack() {
        return callback;
    }

    public void registerCallBack(InterceptorCallback cb) {
        callback = cb;
    }


    public interface InterceptorCallback {
        void on401();
    }
}

