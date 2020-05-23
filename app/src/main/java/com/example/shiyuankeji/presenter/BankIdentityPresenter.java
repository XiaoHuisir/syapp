package com.example.shiyuankeji.presenter;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.BankBean;
import com.example.shiyuankeji.bean.IdentityBean;
import com.example.shiyuankeji.interfaces.contract.BankIdentityContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

public class BankIdentityPresenter extends BasePresenter<BankIdentityContract.View> implements BankIdentityContract.Presenter {
    private String TAG="tag";

    @Override
    public void identitys(String identity) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).updateidentityApi(Constant.token,identity)
                .compose(RxUtils.<IdentityBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IdentityBean>(mView) {
                    @Override
                    public void onNext(IdentityBean identityBean) {
                        if (identityBean
                                != null) {
                            if (mView != null) {
                                mView.identityRrean(identityBean);
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
    public void banks(String bankname, String banknum, String bankaddress) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).updatebankApi(Constant.token,bankname,banknum,bankaddress)
                .compose(RxUtils.<BankBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BankBean>(mView) {
                    @Override
                    public void onNext(BankBean bankBean) {
                        if (bankBean
                                != null) {
                            if (mView != null) {
                                mView.BankRrean(bankBean);
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
