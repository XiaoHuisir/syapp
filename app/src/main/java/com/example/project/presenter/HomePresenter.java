package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.HomeBean;
import com.example.project.bean.LoginBean;
import com.example.project.interfaces.contract.HomeCotract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

import static cn.jzvd.JZVideoPlayer.TAG;

public class HomePresenter extends BasePresenter<HomeCotract.View> implements HomeCotract.Presenter {
    @Override
    public void home() {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).home()
                .compose(RxUtils.<HomeBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBean>(mView) {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        if (homeBean
                                != null) {
                            if (mView != null) {
                                mView.homeReturn(homeBean);
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
