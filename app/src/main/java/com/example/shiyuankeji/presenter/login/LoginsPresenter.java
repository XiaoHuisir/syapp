package com.example.shiyuankeji.presenter.login;


import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.LoginsBean;
import com.example.shiyuankeji.interfaces.contract.LoginsContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

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
