package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.bean.ExperienceBean;
import com.example.shiyuankeji.interfaces.contract.ExperienceContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class ExperiencePresenter extends BasePresenter<ExperienceContract.View> implements ExperienceContract.Presenter {
    @Override
    public void expers() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).experienceApi(Constant.token)
                        .compose(RxUtils.<ExperienceBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<ExperienceBean>(mView) {
                            @Override
                            public void onNext(ExperienceBean experienceBean) {
                                if (experienceBean
                                        != null) {
                                    if (mView != null) {
                                        mView.experRean(experienceBean);
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
