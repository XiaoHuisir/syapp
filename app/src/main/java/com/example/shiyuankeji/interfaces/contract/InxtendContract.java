package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.InxtendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface InxtendContract {

    interface View extends IBaseView{
        void  inxtendRean(InxtendBean inxtendBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  inxtends();
    }
}
