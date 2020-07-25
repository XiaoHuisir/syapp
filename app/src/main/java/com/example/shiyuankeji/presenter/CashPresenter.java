package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.CashBean;
import com.example.shiyuankeji.bean.ClassBean;
import com.example.shiyuankeji.interfaces.contract.CashContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class CashPresenter extends BasePresenter<CashContract.View> implements CashContract.Presenter {
    @Override
    public void cashs(int score) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).cashApi(Constant.token,score)
                .compose(RxUtils.<CashBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CashBean>(mView) {
                    @Override
                    public void onNext(CashBean cashBean) {
                        if (cashBean
                                != null) {
                            if (mView != null) {
                                mView.cashRean(cashBean);
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
