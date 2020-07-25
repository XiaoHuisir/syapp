package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.CashBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface CashContract {
    interface View extends IBaseView{
        void  cashRean(CashBean cashBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   cashs(int score);
    }
}
