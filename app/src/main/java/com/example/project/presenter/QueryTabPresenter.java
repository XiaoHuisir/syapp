package com.example.project.presenter;

import com.example.project.app.Constant;
import com.example.project.base.BasePresenter;
import com.example.project.bean.QueryTabBean;
import com.example.project.bean.SubmitListBean;
import com.example.project.interfaces.contract.QueryTabContract;
import com.example.project.utils.CommonSubscriber;
import com.example.project.utils.HttpUtils;
import com.example.project.utils.RxUtils;

public class QueryTabPresenter extends BasePresenter<QueryTabContract.View> implements QueryTabContract.Presenter {
    @Override
    public void quertytab(String user_name, String phone_number, String name) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).querytabApi(user_name,phone_number,name)
                .compose(RxUtils.<QueryTabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<QueryTabBean>(mView) {
                    @Override
                    public void onNext(QueryTabBean queryTabBean) {
                        if (queryTabBean
                                != null) {
                            if (mView != null) {
                                mView.querytabRean(queryTabBean);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
//                        Log.d(TAG, "onError: " + t);
                    }
                })

        );
    }
}
