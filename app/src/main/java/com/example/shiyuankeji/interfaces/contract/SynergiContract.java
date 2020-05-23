package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.SynergicBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface SynergiContract {
    interface  View extends IBaseView{
        void   synergicRean(SynergicBean synergicBean);
        void   synergicxingRean(SynergicBean synergicBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   synergics();
        void   synergicxings(String teamId);
    }
}
