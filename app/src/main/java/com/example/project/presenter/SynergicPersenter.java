package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.SynergicBean;
import com.example.project.bean.UpdatePwdtBean;
import com.example.project.interfaces.contract.SynergiContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

import static android.support.constraint.Constraints.TAG;

public class SynergicPersenter extends BasePresenter<SynergiContract.View> implements SynergiContract.Presenter {
    @Override
    public void synergics() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).synergicApi(Constant.token)
                .compose(RxUtils.<SynergicBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SynergicBean>(mView) {
                    @Override
                    public void onNext(SynergicBean synergicBean) {
                        if (synergicBean
                                != null) {
                            if (mView != null) {
                                mView.synergicRean(synergicBean);
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

    @Override
    public void synergicxings(String teamId) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).sybergicxingApi(teamId)
                .compose(RxUtils.<SynergicBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SynergicBean>(mView) {
                    @Override
                    public void onNext(SynergicBean synergicBean) {
                        if (synergicBean
                                != null) {
                            if (mView != null) {
                                mView.synergicxingRean(synergicBean);
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
