package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.AddUserBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface RegisterContract {
    interface  View extends IBaseView{
        void  registerRean(AddUserBean addUserBean);
        void smssendRean(SmsSendBean smsSendBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  registers(String user_name,String veify,String password);
        void smssend(String pho);
    }
}
