package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.UpdatePwdtBean;
import com.example.shiyuankeji.interfaces.contract.UpdatePwdContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

import static android.support.constraint.Constraints.TAG;

public class UpdatePwdPresenter extends BasePresenter<UpdatePwdContract.View> implements UpdatePwdContract.Presenter {

    @Override
    public void updatepwds(String pwds) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).updatepwdApi(Constant.token, pwds)
                        .compose(RxUtils.<UpdatePwdtBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<UpdatePwdtBean>(mView) {
                            @Override
                            public void onNext(UpdatePwdtBean updatePwdtBean) {
                                if (updatePwdtBean
                                        != null) {
                                    if (mView != null) {
                                        mView.updatepwdRean(updatePwdtBean);
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
