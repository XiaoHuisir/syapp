package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.LoginsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface LoginsContract {

interface Views extends IBaseView {
    void loginsReturn(LoginsBean result);
}
    interface Presenter extends IBasePresenter<Views> {
        void logins(String mobile, String password);
    }
}
