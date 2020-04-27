package com.example.project.interfaces.contract;

import com.example.project.bean.ClassBean;
import com.example.project.bean.ClassListBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface ClassifyContract {
    interface View extends IBaseView {
        void classifyReturn(ClassBean result);


    }

    interface Presenter extends IBasePresenter<View> {
        void classify();

    }
}
