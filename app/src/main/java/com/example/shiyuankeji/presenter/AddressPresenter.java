package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.AddRBean;
import com.example.shiyuankeji.bean.AnddressBean;
import com.example.shiyuankeji.interfaces.contract.AddressContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class AddressPresenter extends BasePresenter<AddressContract.View>implements AddressContract.Presenter {


    private static final String TAG = "addresspresentertag";

    @Override
    public void addressRe( String name, int id, int is_default, String phone, String address) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).address(Constant.token,name,id,is_default,phone,address)
                .compose(RxUtils.<AnddressBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AnddressBean>(mView) {
                    @Override
                    public void onNext(AnddressBean anddressBean) {
                        if (anddressBean
                                != null) {
                            if (mView != null) {
                                mView.addressReaun(anddressBean);
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

    @Override
    public void addR( String name, int is_default, String phone, String address) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).addr(Constant.token,name,is_default,phone,address)
                .compose(RxUtils.<AddRBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AddRBean>(mView) {
                    @Override
                    public void onNext(AddRBean addRBean) {
                        if (addRBean
                                != null) {
                            if (mView != null) {
                                mView.addReaun(addRBean);
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
