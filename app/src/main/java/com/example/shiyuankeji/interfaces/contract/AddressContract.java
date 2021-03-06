package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.AddRBean;
import com.example.shiyuankeji.bean.AnddressBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

// Flowable<AnddressBean> address(@Field("user_name") String user, @Field("name") String name, @Field("id") int id, @Field("is_default") int is_default, @Field("phone") int phone, @Field("address") String address);
public interface AddressContract {
    //修改
    // 添加
    interface View extends IBaseView {
        void addressReaun(AnddressBean anddressBean);

        void addReaun(AddRBean addRBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void addressRe( String name, int id, int is_default, String phone, String address);

        void addR( String name, int is_default, String phone, String address);

    }


    interface ViewM extends IBaseView {

    }

    interface PresenterM extends IBasePresenter<ViewM> {
    }
}
