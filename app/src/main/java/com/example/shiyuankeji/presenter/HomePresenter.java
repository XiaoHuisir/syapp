package com.example.shiyuankeji.presenter;

import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.HomeBean;
import com.example.shiyuankeji.interfaces.contract.HomeCotract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;
import com.example.shiyuankeji.utils.ToastUtil;

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

//                    @Override
//                    public void onError(Throwable t) {
//                        super.onError(t);
//                        Log.d(TAG, "onError: " + t);
//
//                    }
                })

        );
    }
}
