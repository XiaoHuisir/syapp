package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.CashBean;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface CheckDetailsContract {
    interface View extends IBaseView {
        void  checkRean(CheckDetailsBean checkDetailsBean);
    }
    interface  Presenter extends IBasePresenter<View> {
        void   checks();
    }
}
