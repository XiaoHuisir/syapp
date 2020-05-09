package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.HomeBean;
import com.example.project.bean.NewIndentBean;
import com.example.project.interfaces.contract.IndentContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

import static android.support.constraint.Constraints.TAG;

public class IndentPresenter extends BasePresenter<IndentContract.View> implements IndentContract.Presenter {
    @Override
    public void indents() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).indentApi(Constant.token)
                .compose(RxUtils.<NewIndentBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<NewIndentBean>(mView) {
                    @Override
                    public void onNext(NewIndentBean newIndentBean) {
                        if (newIndentBean
                                != null) {
                            if (mView != null) {
                                mView.indentRean(newIndentBean);
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
