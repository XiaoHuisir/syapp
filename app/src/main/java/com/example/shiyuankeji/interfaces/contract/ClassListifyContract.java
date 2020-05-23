package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.ClassListBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface ClassListifyContract {
    interface View extends IBaseView {

        void classListReturn(ClassListBean result);

    }
    interface Presenter extends IBasePresenter<View> {


        void cifyList(int type);
    }
}
