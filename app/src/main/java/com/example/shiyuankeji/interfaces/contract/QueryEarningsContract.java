package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.QueryEarningsBean;
import com.example.shiyuankeji.bean.YieDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface QueryEarningsContract {
    interface  View extends IBaseView{
        void   earningsRean(QueryEarningsBean queryEarningsBean);
        void  yiedetailsRean(YieDetailsBean yieDetailsBean);
    }
    interface  Presenter extends IBasePresenter<View>{
        void   earnings();
        void   yiedetail(String order);
    }
}
