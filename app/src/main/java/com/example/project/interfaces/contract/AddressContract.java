package com.example.project.interfaces.contract;

import com.example.project.bean.AddRBean;
import com.example.project.bean.AnddressBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

// Flowable<AnddressBean> address(@Field("user_name") String user, @Field("name") String name, @Field("id") int id, @Field("is_default") int is_default, @Field("phone") int phone, @Field("address") String address);
public interface AddressContract {
    //修改
    // 添加
    interface View extends IBaseView {
        void addressReaun(AnddressBean anddressBean);

        void addReaun(AddRBean addRBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void addressRe(String user, String name, int id, int is_default, String phone, String address);

        void addR(String user, String name, int is_default, String phone, String address);

    }


    interface ViewM extends IBaseView {

    }

    interface PresenterM extends IBasePresenter<ViewM> {
    }
}
