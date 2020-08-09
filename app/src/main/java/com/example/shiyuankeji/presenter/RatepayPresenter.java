package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.QueryTabBean;
import com.example.shiyuankeji.bean.RatepayingBean;
import com.example.shiyuankeji.interfaces.contract.RatepayContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class RatepayPresenter extends BasePresenter<RatepayContract.View> implements RatepayContract.Presenter {
    @Override
    public void retepays() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).rateApi(Constant.token)
                        .compose(RxUtils.<RatepayingBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<RatepayingBean>(mView) {
                            @Override
                            public void onNext(RatepayingBean ratepayingBean) {
                                if (ratepayingBean
                                        != null) {
                                    if (mView != null) {
                                        mView.ratepayRean(ratepayingBean);
                                    }
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                super.onError(t);
//                        Log.d(TAG, "onError: " + t);
                            }
                        })

        );
    }
}
