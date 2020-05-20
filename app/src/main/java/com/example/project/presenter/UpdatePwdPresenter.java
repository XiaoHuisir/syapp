package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.SubmitBean;
import com.example.project.bean.UpdatePwdtBean;
import com.example.project.interfaces.contract.UpdatePwdContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

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
