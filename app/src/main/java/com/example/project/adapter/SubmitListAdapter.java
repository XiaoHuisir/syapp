package com.example.project.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.base.BaseAdapter;
import com.example.project.bean.SubmitListBean;
import com.example.project.ui.activity.AddressMessage;

import java.util.List;

public class SubmitListAdapter extends BaseAdapter {
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
        tvUserAdd.setText(listSubmit.getAddress());
        tvUserName.setText(listSubmit.getName());
        textUserPhone.setText(String.valueOf(listSubmit.getPhone()));
        holder.itemView.setTag(positon);
       tvEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int is_default = listSubmit.getIs_default();
                Intent intent = new Intent(mContext, AddressMessage.class);
                intent.putExtra("add_ress",listSubmit.getAddress());
                intent.putExtra("names",listSubmit.getName());
                intent.putExtra("id_dizhi",listSubmit.getId());
                intent.putExtra("is_defaults",is_default); //判断是否设置成默认收货地址
                intent.putExtra("phone",listSubmit.getPhone());
                mContext.startActivity(intent);
            }
        });

    }


}
