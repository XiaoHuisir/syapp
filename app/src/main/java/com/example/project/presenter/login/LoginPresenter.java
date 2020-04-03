package com.example.project.presenter.login;


import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.LoginBean;
import com.example.project.interfaces.contract.LoginContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {


    @Override
    public void login(String mobile, String password) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).login(mobile,password)
                .compose(RxUtils.<LoginBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<LoginBean>(mView) {
                @Override
                public void onNext(LoginBean result) {
                    if (result != null) {
                        if (mView != null) {
                            mView.loginReturn(result);
                        }
                    }
                }
        }));
    }

}
