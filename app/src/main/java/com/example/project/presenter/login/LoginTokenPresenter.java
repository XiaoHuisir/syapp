package com.example.project.presenter.login;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.LoginTokenBean;
import com.example.project.bean.LoginsBean;
import com.example.project.interfaces.contract.LoginTokenContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

public class LoginTokenPresenter extends BasePresenter<LoginTokenContract.View> implements LoginTokenContract.Presenter {
    @Override
    public void logintokens(String tokens) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).logintoken(tokens)
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
