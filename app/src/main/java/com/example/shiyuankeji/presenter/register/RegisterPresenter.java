package com.example.shiyuankeji.presenter.register;

import android.util.Log;

import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BasePresenter;
import com.example.shiyuankeji.bean.AddUserBean;
import com.example.shiyuankeji.interfaces.contract.RegisterContract;
import com.example.shiyuankeji.utils.CommonSubscriber;
import com.example.shiyuankeji.utils.HttpUtils;
import com.example.shiyuankeji.utils.RxUtils;

import static cn.jzvd.JZVideoPlayer.TAG;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    @Override
    public void registers(String user_name, String password) {
            addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).registerApi(user_name,password)
                    .compose(RxUtils.<AddUserBean>rxScheduler())
                    .subscribeWith(new CommonSubscriber<AddUserBean>(mView) {
                        @Override
                        public void onNext(AddUserBean addUserBean) {
                            if (addUserBean
                                    != null) {
                                if (mView != null) {
                                    mView.registerRean(addUserBean);
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
