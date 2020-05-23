package com.example.shiyuankeji.interfaces;



public interface IBasePresenter<V extends IBaseView> {
    void attchView(V view);
    void detachView();
}
