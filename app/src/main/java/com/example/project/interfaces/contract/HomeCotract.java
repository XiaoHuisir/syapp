package com.example.project.interfaces.contract;

import com.example.project.bean.HomeBean;
import com.example.project.bean.LoginBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface HomeCotract {
    interface View extends IBaseView {
        void homeReturn(HomeBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void home();
    }
}
