package com.example.project.interfaces.contract;

import com.example.project.bean.LoginTokenBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface LoginTokenContract {
    interface  View extends IBaseView{
        void  logintokenReaun(LoginTokenBean loginTokenBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  logintokens(String tokens);
    }
}
