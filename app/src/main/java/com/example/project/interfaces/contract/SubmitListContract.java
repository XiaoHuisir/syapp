package com.example.project.interfaces.contract;

import com.example.project.bean.SubmitBean;
import com.example.project.bean.SubmitListBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface SubmitListContract {
    interface  View extends IBaseView{
        void   submitlistReane(SubmitListBean submitListBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   submitList(String user_name);
    }
}
