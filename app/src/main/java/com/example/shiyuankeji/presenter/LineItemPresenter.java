package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.LineItemBean;
import com.example.shiyuankeji.interfaces.contract.LineItemConreact;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class LineItemPresenter extends BasePresenter<LineItemConreact.View> implements LineItemConreact.Presenter {
    private static final String TAG = "lineitem";

    @Override
    public void lineitems(String id) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).lineitemApi(id)
                .compose(RxUtils.<LineItemBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<LineItemBean>(mView) {
                    @Override
                    public void onNext(LineItemBean lineItemBean) {
                        if (lineItemBean
                                != null) {
                            if (mView != null) {
                                mView.lineitemReant(lineItemBean);
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
