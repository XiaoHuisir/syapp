package com.example.project.interfaces.contract;

import com.example.project.bean.QueryTabBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

import retrofit2.http.Field;

public interface QueryTabContract {
    interface  View extends IBaseView{
        void  querytabRean(QueryTabBean queryTabBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  quertytab(String user_name,String phone_number,String name);
    }
}
