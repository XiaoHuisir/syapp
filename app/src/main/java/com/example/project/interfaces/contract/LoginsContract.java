package com.example.project.interfaces.contract;

import com.example.project.bean.LoginBean;
import com.example.project.bean.LoginsBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface LoginsContract {

interface Views extends IBaseView {
    void loginsReturn(LoginsBean result);
}
    interface Presenter extends IBasePresenter<Views> {
        void logins(String mobile, String password);
    }
}
