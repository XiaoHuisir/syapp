package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.ScanCodeBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface ScancodeContract {
    interface  View extends IBaseView{
        void  scancodeRean(ScanCodeBean scanCodeBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void  scancodes();
    }
}
