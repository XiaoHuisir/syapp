package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.HomeBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface HomeCotract {
    interface View extends IBaseView {
        void homeReturn(HomeBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void home();
    }
}
