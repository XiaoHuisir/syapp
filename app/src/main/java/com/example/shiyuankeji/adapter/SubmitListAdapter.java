package com.example.shiyuankeji.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.SubmitListBean;
import com.example.shiyuankeji.utils.UtilsClicktime;

import java.util.List;

public class SubmitListAdapter extends BaseAdapter {
   public AddressItemClick itemClick;
   public Submit0rdersItemClick  submitordersClick;
    public SubmitListAdapter(List<SubmitListBean.UserAddressLIstBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_submit_list;
    }

    @Override
    protected void bindData(final BaseViewHolder holder, int positon, Object o) {
        final SubmitListBean.UserAddressLIstBean listSubmit = (SubmitListBean.UserAddressLIstBean) mDatas.get(positon);
        TextView tvUserAdd = (TextView) holder.getView(R.id.text_user_add);//用户地址
        TextView tvUserName = (TextView) holder.getView(R.id.txt_user_name);//用户姓名
        TextView textUserPhone = (TextView) holder.getView(R.id.text_user_phone);//用户手机号
        TextView tvEditor = (TextView) holder.getView(R.id.text_editor);//编辑
        RelativeLayout re_choose = (RelativeLayout) holder.getView(R.id.re_choose);//选择
        LinearLayout linMoren = (LinearLayout) holder.getView(R.id.lin_moren);//选择
        tvUserAdd.setText("地址："+listSubmit.getAddress());
        tvUserName.setText("姓名："+listSubmit.getName());
        textUserPhone.setText("手机号："+String.valueOf(listSubmit.getPhone()));
        int is_default = listSubmit.getIs_default();//判断是否为默认地址 1 默认 0 不是
        if (is_default==1){
            linMoren.setVisibility(View.VISIBLE);
        }
        holder.itemView.setTag(positon);
//          layout.setTag(String.valueOf(data.getCurriculum_id()));
//        layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String id = (String) v.getTag();
//                if (itemClick != null) {
//                    itemClick.trainclick(id);
//                }
//            }
//        });
        tvEditor.setTag(mDatas.get(positon));
       tvEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UtilsClicktime.isFastDoubleClick()){
                    return;
                }
                SubmitListBean.UserAddressLIstBean addresslist =(SubmitListBean.UserAddressLIstBean) v.getTag();
                if (itemClick!=null){
                    itemClick.addressclick(addresslist);
                }
//                int is_default = listSubmit.getIs_default();
//                Intent intent = new Intent();
//                intent.setClass(mContext, AddressMessage.class);
//                intent.putExtra("add_ress",listSubmit.getAddress());
//                intent.putExtra("names",listSubmit.getName());
//                intent.putExtra("id_dizhi",listSubmit.getId());
//                intent.putExtra("is_defaults",is_default); //判断是否设置成默认收货地址
//                intent.putExtra("phone",listSubmit.getPhone());
//                mContext.startActivity(intent);
            }
        });
        re_choose.setTag(mDatas.get(positon));
        re_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UtilsClicktime.isFastDoubleClick()){
                    return;
                }
                SubmitListBean.UserAddressLIstBean submitorerslist =(SubmitListBean.UserAddressLIstBean) v.getTag();
                if (submitordersClick!=null){
                    submitordersClick.Submit0rdersclick(submitorerslist);
                }
//                Intent intent = new Intent();
//                intent.setClass(mContext, Submit0rdersActivity.class);
//                intent.putExtra("getaddress",listSubmit.getAddress());
//                intent.putExtra("getname",listSubmit.getName());
//                intent.putExtra("getphone",listSubmit.getPhone());
//                intent.putExtra("indx_0",100);
//                mContext.startActivity(intent);

            }
        });

    }
    public interface AddressItemClick {
        void addressclick(SubmitListBean.UserAddressLIstBean listSubmit);
    }
    public interface Submit0rdersItemClick {
        void Submit0rdersclick(SubmitListBean.UserAddressLIstBean listSubmit);
    }

}
