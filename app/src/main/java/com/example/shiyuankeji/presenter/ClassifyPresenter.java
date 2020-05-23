package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.ClassBean;
import com.example.shiyuankeji.interfaces.contract.ClassifyContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;


public class ClassifyPresenter extends BasePresenter<ClassifyContract.View> implements ClassifyContract.Presenter {
    private static final String TAG = "tag";

    @Override
    public void classify() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).clasify()
                .compose(RxUtils.<ClassBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ClassBean>(mView) {
                    @Override
                    public void onNext(ClassBean classBean) {
                        if (classBean
                                != null) {
                            if (mView != null) {
                                mView.classifyReturn(classBean);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        Log.d(TAG, "onError: " + t);
                    }
                })

        );
    }



}
