package com.example.project.interfaces;



public interface IBasePresenter<V extends IBaseView> {
    void attchView(V view);
    void detachView();
}
