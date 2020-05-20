package com.example.project.interfaces.contract;

import com.example.project.bean.SynergicBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface SynergiContract {
    interface  View extends IBaseView{
        void   synergicRean(SynergicBean synergicBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   synergics();
    }
}
