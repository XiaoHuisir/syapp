package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.ProductDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface ProductDetailsContract {

    interface View extends IBaseView {
        void ProductDetailsReturn(ProductDetailsBean result);

    }

    interface Presenter extends IBasePresenter<View> {
        void productDetails(int idsa);

    }
}
