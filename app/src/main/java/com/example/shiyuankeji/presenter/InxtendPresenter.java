package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.InxtendBean;
import com.example.shiyuankeji.bean.QueryIntegralBean;
import com.example.shiyuankeji.interfaces.contract.InxtendContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class InxtendPresenter extends BasePresenter<InxtendContract.View> implements InxtendContract.Presenter {
    @Override
    public void inxtends() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).inxtendApi(Constant.token)
                .compose(RxUtils.<InxtendBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<InxtendBean>(mView) {
                    @Override
                    public void onNext(InxtendBean inxtendBean) {
                        if (inxtendBean
                                != null) {
                            if (mView != null) {
                                mView.inxtendRean(inxtendBean);
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
