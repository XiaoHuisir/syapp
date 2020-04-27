package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.HomeBean;
import com.example.project.bean.ProductDetailsBean;
import com.example.project.interfaces.contract.ProductDetailsContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

import static cn.jzvd.JZVideoPlayer.TAG;

public class ProductDetailsPresenter extends BasePresenter<ProductDetailsContract.View> implements ProductDetailsContract.Presenter {
    @Override
    public void productDetails(int idsa) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).ProductDetails(idsa)
                .compose(RxUtils.<ProductDetailsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ProductDetailsBean>(mView) {
                    @Override
                    public void onNext(ProductDetailsBean productDetailsBean) {
                        if (productDetailsBean
                                != null) {
                            if (mView != null) {
                                mView.ProductDetailsReturn(productDetailsBean);
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
