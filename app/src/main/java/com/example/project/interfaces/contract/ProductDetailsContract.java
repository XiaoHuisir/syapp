package com.example.project.interfaces.contract;

import com.example.project.bean.ProductDetailsBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface ProductDetailsContract {

    interface View extends IBaseView {
        void ProductDetailsReturn(ProductDetailsBean result);

    }

    interface Presenter extends IBasePresenter<View> {
        void productDetails(int idsa);

    }
}
