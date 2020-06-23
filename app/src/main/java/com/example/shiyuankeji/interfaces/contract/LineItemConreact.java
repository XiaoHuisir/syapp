package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.LineItemBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface LineItemConreact {
    interface  View extends IBaseView{
        void  lineitemReant(LineItemBean lineItemBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void  lineitems(String id);
    }
}
