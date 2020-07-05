package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.bean.MineBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface MineContract{
    interface  View extends IBaseView{
        void  logintokenReaun(LoginTokenBean loginTokenBean);
        void  mineReand(MineBean mineBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  logintokens();
        void  mines();
    }
}
