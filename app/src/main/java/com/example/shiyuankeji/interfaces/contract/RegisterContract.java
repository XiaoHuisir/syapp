package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.AddUserBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface RegisterContract {
    interface  View extends IBaseView{
        void  registerRean(AddUserBean addUserBean);

    }
    interface  Presenter extends IBasePresenter<View>{
        void  registers(String user_name,String password);
    }
}
