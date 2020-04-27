package com.example.project.presenter;

import android.util.Log;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.AnddressBean;
import com.example.project.bean.ClassBean;
import com.example.project.interfaces.contract.AddressContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

public class AddressPresenter extends BasePresenter<AddressContract.View>implements AddressContract.Presenter {


    private static final String TAG = "addresspresentertag";

    @Override
    public void addressRe(String user, String name, int id, int is_default, String phone, String address) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).address(user,name,id,is_default,phone,address)
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
}
