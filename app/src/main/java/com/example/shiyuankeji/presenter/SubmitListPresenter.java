package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.SubmitListBean;
import com.example.shiyuankeji.interfaces.contract.SubmitListContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

import static android.content.ContentValues.TAG;


public class SubmitListPresenter extends BasePresenter<SubmitListContract.View> implements SubmitListContract.Presenter {


    @Override
    public void submitList(int idsas, int num) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).submitLists(Constant.token,idsas,num)
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
