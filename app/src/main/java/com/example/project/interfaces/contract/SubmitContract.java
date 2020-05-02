package com.example.project.interfaces.contract;

import com.example.project.bean.AddOrderistBean;
import com.example.project.bean.SubmitBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

import java.util.Map;

import retrofit2.http.FieldMap;

public interface SubmitContract {
    interface View extends IBaseView {
        void submitRetrun(SubmitBean submitBean);
        void addOrderRean(AddOrderistBean addOrderistBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  submit(String user,int id);
        void addOrders(@FieldMap Map<String, String> map);
    }

}
