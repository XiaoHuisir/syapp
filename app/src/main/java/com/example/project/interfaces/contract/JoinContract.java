package com.example.project.interfaces.contract;

import com.example.project.bean.JoinBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

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
