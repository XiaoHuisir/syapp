package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.PhoneBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface PhoneContract {
    interface View extends IBaseView{
    void  phoneReaner(PhoneBean phoneBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   phoneget(String phone);
    }
}

