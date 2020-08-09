package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.RatepayingBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface RatepayContract {
    interface  View extends IBaseView{
        void  ratepayRean(RatepayingBean ratepayingBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  retepays();
    }
}
