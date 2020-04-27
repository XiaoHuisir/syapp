package com.example.project.interfaces.contract;

import com.example.project.bean.AnddressBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

// Flowable<AnddressBean> address(@Field("user_name") String user, @Field("name") String name, @Field("id") int id, @Field("is_default") int is_default, @Field("phone") int phone, @Field("address") String address);
public interface AddressContract {
    interface View extends IBaseView {
        void addressReaun(AnddressBean anddressBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void addressRe(String user, String name, int id, int is_default, String phone, String address);
    }
}
