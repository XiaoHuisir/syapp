package com.example.project.interfaces.contract;

import com.example.project.bean.BankBean;
import com.example.project.bean.IdentityBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

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
