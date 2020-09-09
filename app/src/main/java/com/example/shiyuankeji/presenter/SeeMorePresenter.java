package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.bean.SeeMoreBean;
import com.example.shiyuankeji.interfaces.contract.SeeMoreContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class SeeMorePresenter extends BasePresenter<SeeMoreContract.View> implements SeeMoreContract.Presenter {
    @Override
    public void seemores() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).seemoreApi(Constant.token)
                        .compose(RxUtils.<SeeMoreBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<SeeMoreBean>(mView) {
                            @Override
                            public void onNext(SeeMoreBean seeMoreBean) {
                                if (seeMoreBean
                                        != null) {
                                    if (mView != null) {
                                        mView.seemoreRean(seeMoreBean);
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
