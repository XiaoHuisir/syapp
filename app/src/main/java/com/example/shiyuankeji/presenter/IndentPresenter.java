package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.NewIndentBean;
import com.example.shiyuankeji.interfaces.contract.IndentContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

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
