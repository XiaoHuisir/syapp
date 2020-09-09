package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.bean.SeeMoreBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface SeeMoreContract {
    interface View extends IBaseView {
        void  seemoreRean(SeeMoreBean seeMoreBean);
    }
    interface  Presenter extends IBasePresenter<View> {
        void   seemores();
    }
}
