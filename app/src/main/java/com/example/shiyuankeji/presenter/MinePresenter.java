package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.bean.MineBean;
import com.example.shiyuankeji.interfaces.contract.MineContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter {
    private static final String TAG = "mine";

    @Override
    public void logintokens() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).logintoken(Constant.token)
                .compose(RxUtils.<LoginTokenBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<LoginTokenBean>(mView) {
                    @Override
                    public void onNext(LoginTokenBean loginTokenBean) {
                        if (loginTokenBean != null) {
                            if (mView != null) {
                                mView.logintokenReaun(loginTokenBean);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("tag", "onError: " + t);
                    }
                })

        );
    }

    @Override
    public void mines() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).MinesApi(Constant.token)
                .compose(RxUtils.<MineBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<MineBean>(mView) {
                    @Override
                    public void onNext(MineBean mineBean) {
                        if (mineBean
                                != null) {
                            if (mView != null) {
                                mView.mineReand(mineBean);
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
