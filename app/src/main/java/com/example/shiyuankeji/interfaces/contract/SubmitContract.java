package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.AddOrderistBean;
import com.example.shiyuankeji.bean.SubmitBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

import java.util.Map;

import retrofit2.http.FieldMap;

public interface SubmitContract {
    interface View extends IBaseView {
        void submitRetrun(SubmitBean submitBean);
        void addOrderRean(AddOrderistBean addOrderistBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  submit(int id);
        void addOrders(@FieldMap Map<String, String> map);
    }

}
