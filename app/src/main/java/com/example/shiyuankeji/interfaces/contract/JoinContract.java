package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.JoinBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface JoinContract {
    interface View extends IBaseView {
        void isjoinRrean(JoinBean joinBean);

        void joinRrean(JoinBean joinBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void isjoin(String codes);

        void joins(int mid);
    }
}
