package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.ClassBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface ClassifyContract {
    interface View extends IBaseView {
        void classifyReturn(ClassBean result);


    }

    interface Presenter extends IBasePresenter<View> {
        void classify();

    }
}
