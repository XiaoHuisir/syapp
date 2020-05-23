package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.JoinBean;
import com.example.shiyuankeji.interfaces.contract.JoinContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

import static android.support.constraint.Constraints.TAG;

public class JoinPresenter extends BasePresenter<JoinContract.View> implements JoinContract.Presenter {
    @Override
    public void isjoin(String codes) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).isjoinApi(codes)
                .compose(RxUtils.<JoinBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<JoinBean>(mView) {
                    @Override
                    public void onNext(JoinBean joinBean) {
                        if (joinBean
                                != null) {
                            if (mView != null) {
                                mView.isjoinRrean(joinBean);
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
    public void joins(int mid) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).joinApi(Constant.token,mid)
                .compose(RxUtils.<JoinBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<JoinBean>(mView) {
                    @Override
                    public void onNext(JoinBean joinBean) {
                        if (joinBean
                                != null) {
                            if (mView != null) {
                                mView.joinRrean(joinBean);
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
