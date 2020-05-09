package com.example.project.interfaces.contract;

import com.example.project.bean.NewIndentBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface IndentContract {
    interface View extends IBaseView {
        void indentRean(NewIndentBean newIndentBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void indents();
    }
}
