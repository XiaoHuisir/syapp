package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.QueryTabBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.contract.QueryTabContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class QueryTabPresenter extends BasePresenter<QueryTabContract.View> implements QueryTabContract.Presenter {
    @Override
    public void quertytab(String user_name, String phone_number, String name) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).querytabApi(user_name,phone_number,name)
                .compose(RxUtils.<QueryTabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QueryTabBean>(mView) {
                    @Override
                    public void onNext(QueryTabBean queryTabBean) {
                        if (queryTabBean
                                != null) {
                            if (mView != null) {
                                mView.querytabRean(queryTabBean);
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

    @Override
    public void smssend(String pho) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).smsSendApi(pho)
                        .compose(RxUtils.<SmsSendBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<SmsSendBean>(mView) {
                            @Override
                            public void onNext(SmsSendBean smsSendBean) {
                                if (smsSendBean
                                        != null) {
                                    if (mView != null) {
                                        mView.smssendRean(smsSendBean);
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

    @Override
    public void isverifycode(String phos, String isv) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).isVerifyCodeApi(phos,isv)
                        .compose(RxUtils.<SmsSendBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<SmsSendBean>(mView) {
                            @Override
                            public void onNext(SmsSendBean smsSendBean) {
                                if (smsSendBean
                                        != null) {
                                    if (mView != null) {
                                        mView.isVerifyCode(smsSendBean);
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
