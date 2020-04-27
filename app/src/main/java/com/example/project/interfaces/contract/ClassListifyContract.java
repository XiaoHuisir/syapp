package com.example.project.interfaces.contract;

import com.example.project.base.BasePresenter;
import com.example.project.bean.ClassBean;
import com.example.project.bean.ClassListBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface ClassListifyContract {
    interface View extends IBaseView {

        void classListReturn(ClassListBean result);

    }
    interface Presenter extends IBasePresenter<View> {


        void cifyList(int type);
    }
}
