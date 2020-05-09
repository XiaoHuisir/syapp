package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.LineItemBean;
import com.example.project.bean.QueryIntegralBean;
import com.example.project.bean.QueryLastWeekStockBean;
import com.example.project.bean.QueryMinuteStockBean;
import com.example.project.bean.QueryStockBean;
import com.example.project.interfaces.contract.IntegralDetailsContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class IntegraIBetailsPresenter extends BasePresenter<IntegralDetailsContract.View> implements IntegralDetailsContract.Presenter {
    @Override
    public void queryIntegrals() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).queryIntegralApi(Constant.token)
                .compose(RxUtils.<QueryIntegralBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QueryIntegralBean>(mView) {
                    @Override
                    public void onNext(QueryIntegralBean queryIntegralBean) {
                        if (queryIntegralBean
                                != null) {
                            if (mView != null) {
                                mView.queryIntegralRrean(queryIntegralBean);
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
    public void queryStocks() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).queryStockApi(Constant.token)
                .compose(RxUtils.<QueryStockBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QueryStockBean>(mView) {
                    @Override
                    public void onNext(QueryStockBean queryStockBean) {
                        if (queryStockBean
                                != null) {
                            if (mView != null) {
                                mView.queryStockRrean(queryStockBean);
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
    public void queryMinuteStocks() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).queryMinuteStockApi(Constant.token)
                .compose(RxUtils.<QueryMinuteStockBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QueryMinuteStockBean>(mView) {
                    @Override
                    public void onNext(QueryMinuteStockBean queryMinuteStockBean) {
                        if (queryMinuteStockBean
                                != null) {
                            if (mView != null) {
                                mView.queryMinuteStockRrean(queryMinuteStockBean);
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
    public void queryLastWeekStocks() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).queryLastWeekStockApi(Constant.token)
                .compose(RxUtils.<QueryLastWeekStockBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QueryLastWeekStockBean>(mView) {
                    @Override
                    public void onNext(QueryLastWeekStockBean queryLastWeekStockBean) {
                        if (queryLastWeekStockBean
                                != null) {
                            if (mView != null) {
                                mView.queryLastWeekStockRrean(queryLastWeekStockBean);
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
