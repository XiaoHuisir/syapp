package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface LoginTokenContract {
    interface  View extends IBaseView{
        void  logintokenReaun(LoginTokenBean loginTokenBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  logintokens();
    }
}
