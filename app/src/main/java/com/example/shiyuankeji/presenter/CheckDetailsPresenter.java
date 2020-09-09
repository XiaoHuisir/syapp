package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.AnddressBean;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.interfaces.contract.CheckDetailsContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class CheckDetailsPresenter extends BasePresenter<CheckDetailsContract.View> implements CheckDetailsContract.Presenter {
    @Override
    public void checks() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).checkdetailsApi(Constant.token)
                .compose(RxUtils.<CheckDetailsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CheckDetailsBean>(mView) {
                    @Override
                    public void onNext(CheckDetailsBean checkDetailsBean) {
                        if (checkDetailsBean
                                != null) {
                            if (mView != null) {
                                mView.checkRean(checkDetailsBean);
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
