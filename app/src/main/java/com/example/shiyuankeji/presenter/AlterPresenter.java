package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.AlterBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.contract.AlterContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class AlterPresenter extends BasePresenter<AlterContract.View> implements AlterContract.Presenter {
    @Override
    public void alters(String phot, String pwd, String codes) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).alterApi(phot,pwd,codes)
                .compose(RxUtils.<AlterBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AlterBean>(mView) {
                    @Override
                    public void onNext(AlterBean alterBean) {
                        if (alterBean
                                != null) {
                            if (mView != null) {
                                mView.alterRean(alterBean);
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
}
