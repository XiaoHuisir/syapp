package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.QueryTabBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface QueryTabContract {
    interface  View extends IBaseView{
        void  querytabRean(QueryTabBean queryTabBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  quertytab(String user_name,String phone_number,String name);
    }
}
