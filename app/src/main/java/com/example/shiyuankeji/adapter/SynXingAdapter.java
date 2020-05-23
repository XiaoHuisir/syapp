package com.example.shiyuankeji.adapter;

import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.SynergicBean;

import java.util.List;

public class SynXingAdapter extends BaseAdapter {
    public SynXingAdapter(List<SynergicBean.DataBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_synxing;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        SynergicBean.DataBean list = (SynergicBean.DataBean) mDatas.get(positon);
        TextView tname = (TextView) holder.getView(R.id.t_name);
        TextView tuname = (TextView) holder.getView(R.id.t_uname);
        tuname.setText(list.getUser_name());
        String name = list.getName();
        if (!name.equals("")) {
            tname.setText("(" + name + ")");
        }

    }


}
