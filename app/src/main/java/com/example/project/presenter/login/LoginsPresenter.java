package com.example.project.presenter.login;


import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.LoginsBean;
import com.example.project.interfaces.contract.LoginsContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

public class LoginsPresenter extends BasePresenter<LoginsContract.Views> implements LoginsContract.Presenter {
    @Override
    public void logins(String mobile, String password) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).logins(mobile, password)
                .compose(RxUtils.<LoginsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<LoginsBean>(mView) {
                    @Override
                    public void onNext(LoginsBean result) {
                        if (result != null) {
                            if (mView != null) {
                                mView.loginsReturn(result);
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
