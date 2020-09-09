package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.bean.GrantDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface GrantDeatailContract {
    interface View extends IBaseView {
        void  grantRean(GrantDetailsBean grantDetailsBean);
    }
    interface  Presenter extends IBasePresenter<View> {
        void   grants(String time);
    }
}
