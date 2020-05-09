package com.example.project.interfaces.contract;

import com.example.project.bean.MineBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface MineContract{
    interface  View extends IBaseView{
        void  mineReand(MineBean mineBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  mines();
    }
}
