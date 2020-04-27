package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.ClassBean;
import com.example.project.bean.ClassListBean;
import com.example.project.bean.HomeBean;
import com.example.project.interfaces.contract.ClassifyContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;


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
