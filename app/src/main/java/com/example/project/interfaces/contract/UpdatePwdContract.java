package com.example.project.interfaces.contract;

import com.example.project.bean.UpdatePwdtBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface UpdatePwdContract {
    interface  View extends IBaseView{
        void   updatepwdRean(UpdatePwdtBean updatePwdtBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   updatepwds(String pwds);
    }
}
