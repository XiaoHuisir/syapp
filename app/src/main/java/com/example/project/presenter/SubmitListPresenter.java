package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.HomeBean;
import com.example.project.bean.SubmitBean;
import com.example.project.bean.SubmitListBean;
import com.example.project.interfaces.contract.SubmitListContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

import static android.content.ContentValues.TAG;


public class SubmitListPresenter extends BasePresenter<SubmitListContract.View> implements SubmitListContract.Presenter {
    @Override
    public void submitList(String user_name) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).submitLists(user_name)
                .compose(RxUtils.<SubmitListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SubmitListBean>(mView) {
                    @Override
                    public void onNext(SubmitListBean submitListBean) {
                        if (submitListBean
                                != null) {
                            if (mView != null) {
                                mView.submitlistReane(submitListBean);
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
