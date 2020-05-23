package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.UpdatePwdtBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface UpdatePwdContract {
    interface  View extends IBaseView{
        void   updatepwdRean(UpdatePwdtBean updatePwdtBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   updatepwds(String pwds);
    }
}
