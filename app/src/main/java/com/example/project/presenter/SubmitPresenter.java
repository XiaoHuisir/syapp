package com.example.project.presenter;


import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.ClassBean;
import com.example.project.bean.SubmitBean;
import com.example.project.interfaces.contract.SubmitContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

import static android.content.ContentValues.TAG;

public class SubmitPresenter extends BasePresenter<SubmitContract.View> implements SubmitContract.Presenter {
    @Override
    public void submit(String user, int id) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).submits(user,id)
                .compose(RxUtils.<SubmitBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SubmitBean>(mView) {
                    @Override
                    public void onNext(SubmitBean submitBean) {
                        if (submitBean
                                != null) {
                            if (mView != null) {
                                mView.submitRetrun(submitBean);
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
