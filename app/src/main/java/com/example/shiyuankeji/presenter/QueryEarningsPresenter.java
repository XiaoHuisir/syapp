package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.LineItemBean;
import com.example.shiyuankeji.bean.QueryEarningsBean;
import com.example.shiyuankeji.bean.YieDetailsBean;
import com.example.shiyuankeji.interfaces.contract.QueryEarningsContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class QueryEarningsPresenter extends BasePresenter<QueryEarningsContract.View> implements QueryEarningsContract.Presenter {
    @Override
    public void earnings() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).queryEarningsApi(Constant.token)
                .compose(RxUtils.<QueryEarningsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QueryEarningsBean>(mView) {
                    @Override
                    public void onNext(QueryEarningsBean queryEarningsBean) {
                        if (queryEarningsBean
                                != null) {
                            if (mView != null) {
                                mView.earningsRean(queryEarningsBean);
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
    public void yiedetail(String order) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).querydetailApi(Constant.token,order)
                        .compose(RxUtils.<YieDetailsBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<YieDetailsBean>(mView) {
                            @Override
                            public void onNext(YieDetailsBean yieDetailsBean) {
                                if (yieDetailsBean
                                        != null) {
                                    if (mView != null) {
                                        mView.yiedetailsRean(yieDetailsBean);
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
