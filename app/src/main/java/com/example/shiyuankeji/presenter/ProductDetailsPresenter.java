package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.ProductDetailsBean;
import com.example.shiyuankeji.interfaces.contract.ProductDetailsContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

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
