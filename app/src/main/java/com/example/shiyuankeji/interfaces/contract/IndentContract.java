package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.NewIndentBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface IndentContract {
    interface View extends IBaseView {
        void indentRean(NewIndentBean newIndentBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void indents();
    }
}
