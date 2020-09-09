package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.bean.GrantDetailsBean;
import com.example.shiyuankeji.interfaces.contract.GrantDeatailContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class GrantDeatailPresenter extends BasePresenter<GrantDeatailContract.View> implements GrantDeatailContract.Presenter {
    @Override
    public void grants(String time) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).grantdetailsApi(Constant.token,time)
                        .compose(RxUtils.<GrantDetailsBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<GrantDetailsBean>(mView) {
                            @Override
                            public void onNext(GrantDetailsBean grantDetailsBean) {
                                if (grantDetailsBean
                                        != null) {
                                    if (mView != null) {
                                        mView.grantRean(grantDetailsBean);
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
