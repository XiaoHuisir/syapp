package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.PhoneBean;
import com.example.shiyuankeji.bean.QueryTabBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface QueryTabContract {
    interface View extends IBaseView {
        void querytabRean(QueryTabBean queryTabBean);
        void smssendRean(SmsSendBean smsSendBean);
        void  isVerifyCode(SmsSendBean smsSendBean);
        void  phoneReaner(PhoneBean phoneBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void quertytab(String user_name, String phone_number, String name);

        void smssend(String pho);
        void  isverifycode(String phos,String isv);
        void   phoneget(String phone);
    }
}
