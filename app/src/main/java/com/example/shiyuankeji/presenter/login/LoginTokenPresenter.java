package com.example.shiyuankeji.presenter.login;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.interfaces.contract.LoginTokenContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class LoginTokenPresenter extends BasePresenter<LoginTokenContract.View> implements LoginTokenContract.Presenter {
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
}
