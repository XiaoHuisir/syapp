package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.AddUserBean;
import com.example.shiyuankeji.bean.AlterBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface AlterContract {
    interface  View extends IBaseView {
        void  alterRean(AlterBean alterBean);
        void smssendRean(SmsSendBean smsSendBean);
    }
    interface  Presenter extends IBasePresenter<View> {
        void  alters(String phot,String pwd,String codes);
        void smssend(String pho);
    }
}
