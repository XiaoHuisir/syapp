package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.BankBean;
import com.example.shiyuankeji.bean.IdentityBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface BankIdentityContract {
    interface View extends IBaseView{
        void  identityRrean(IdentityBean identityBean);
        void  BankRrean(BankBean bankBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void  identitys(String identity);
        void  banks(String bankname,String banknum,String bankaddress);
    }
}
