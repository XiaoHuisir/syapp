package com.example.project.interfaces.contract;

import com.example.project.bean.LineItemBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface LineItemConreact {
    interface  View extends IBaseView{
        void  lineitemReant(LineItemBean lineItemBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void  lineitems(int id);
    }
}
