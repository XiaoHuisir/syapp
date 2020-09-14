package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.ExperienceBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface ExperienceContract {

    interface View extends IBaseView{
        void   experRean(ExperienceBean experienceBean);

    }
    interface  Presenter extends IBasePresenter<View>{
        void  expers();
    }
}
