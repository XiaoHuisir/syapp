package com.example.shiyuankeji.presenter;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.bean.PhoneBean;
import com.example.shiyuankeji.interfaces.contract.PhoneContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class PhonePresenter extends BasePresenter<PhoneContract.View> implements PhoneContract.Presenter {
    @Override
    public void phoneget(String phone) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).PhoneApi(phone)
                .compose(RxUtils.<PhoneBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<PhoneBean>(mView) {
                    @Override
                    public void onNext(PhoneBean phoneBean) {
                        if (phoneBean != null) {
                            if (mView != null) {
                                mView.phoneReaner(phoneBean);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
//                        Log.d("tag", "onError: " + t);
                    }
                })

        );
    }
}
