package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.SubmitListBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface SubmitListContract {
    interface View extends IBaseView {
        void submitlistReane(SubmitListBean submitListBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void submitList(int idsas, int num);
    }
}
