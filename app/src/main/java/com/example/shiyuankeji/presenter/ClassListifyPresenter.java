package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.ClassListBean;
import com.example.shiyuankeji.interfaces.contract.ClassListifyContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class ClassListifyPresenter extends BasePresenter<ClassListifyContract.View>implements ClassListifyContract.Presenter {
    private static final String TAG = "tag";

    @Override
    public void cifyList(int type) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).classlist(type)
                .compose(RxUtils.<ClassListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ClassListBean>(mView) {
                    @Override
                    public void onNext(ClassListBean classListBean) {
                        if (classListBean
                                != null) {
                            if (mView != null) {
                                mView.classListReturn(classListBean);
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
