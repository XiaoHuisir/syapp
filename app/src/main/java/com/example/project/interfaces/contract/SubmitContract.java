package com.example.project.interfaces.contract;

import com.example.project.bean.SubmitBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface SubmitContract {
    interface View extends IBaseView {
        void submitRetrun(SubmitBean submitBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  submit(String user,int id);
    }
}
