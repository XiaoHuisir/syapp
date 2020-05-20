package com.example.project.interfaces.contract;

import com.example.project.bean.AddUserBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

import retrofit2.http.Field;

public interface RegisterContract {
    interface  View extends IBaseView{
        void  registerRean(AddUserBean addUserBean);

    }
    interface  Presenter extends IBasePresenter<View>{
        void  registers(String user_name,String password);
    }
}
