package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.LineItemBean;
import com.example.project.bean.MineBean;
import com.example.project.interfaces.contract.MineContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter {
    private static final String TAG = "mine";

    @Override
    public void mines() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).MinesApi(Constant.token)
                .compose(RxUtils.<MineBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<MineBean>(mView) {
                    @Override
                    public void onNext(MineBean mineBean) {
                        if (mineBean
                                != null) {
                            if (mView != null) {
                                mView.mineReand(mineBean);
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
