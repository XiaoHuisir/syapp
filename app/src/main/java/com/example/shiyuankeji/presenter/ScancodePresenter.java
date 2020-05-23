package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.ScanCodeBean;
import com.example.shiyuankeji.interfaces.contract.ScancodeContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class ScancodePresenter extends BasePresenter<ScancodeContract.View> implements ScancodeContract.Presenter {
    @Override
    public void scancodes() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).scancodeApi(Constant.token)
                .compose(RxUtils.<ScanCodeBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ScanCodeBean>(mView) {
                    @Override
                    public void onNext(ScanCodeBean scanCodeBean) {
                        if (scanCodeBean
                                != null) {
                            if (mView != null) {
                                mView.scancodeRean(scanCodeBean);
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
