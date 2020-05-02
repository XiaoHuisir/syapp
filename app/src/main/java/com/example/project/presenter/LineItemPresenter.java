package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.LineItemBean;
import com.example.project.interfaces.contract.LineItemConreact;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

public class LineItemPresenter extends BasePresenter<LineItemConreact.View> implements LineItemConreact.Presenter {
    private static final String TAG = "lineitem";

    @Override
    public void lineitems(int id) {
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
