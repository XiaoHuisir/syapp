package com.example.shiyuankeji.presenter;


import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.AddOrderistBean;
import com.example.shiyuankeji.bean.AliPayBean;
import com.example.shiyuankeji.bean.SubmitBean;
import com.example.shiyuankeji.interfaces.contract.SubmitContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class SubmitPresenter extends BasePresenter<SubmitContract.View> implements SubmitContract.Presenter {
    @Override
    public void submit(int id) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).submits(Constant.token, id)
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

    @Override
    public void addOrders(Map<String, String> map) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).addOrderApi(Constant.token, map)
                .compose(RxUtils.<AddOrderistBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AddOrderistBean>(mView) {
                    @Override
                    public void onNext(AddOrderistBean addOrderistBean) {
                        if (addOrderistBean
                                != null) {
                            if (mView != null) {
                                mView.addOrderRean(addOrderistBean);
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
    public void alipay(String bianhao, double jiaqian, String namecheng) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).alipayApi(bianhao,jiaqian,namecheng)
                .compose(RxUtils.<AliPayBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AliPayBean>(mView) {
                    @Override
                    public void onNext(AliPayBean aliPayBean) {
                        if (aliPayBean
                                != null) {
                            if (mView != null) {
                                mView.alipayRean(aliPayBean);
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
