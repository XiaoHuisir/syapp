package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.RatepayingBean;

import java.util.List;

public class RatepAdapter extends BaseAdapter {
    public RatepAdapter(List<RatepayingBean.DataBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_rate;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        RatepayingBean.DataBean list = (RatepayingBean.DataBean) mDatas.get(positon);
        TextView tvAdd = (TextView) holder.getView(R.id.tvadd);
        TextView tvTime = (TextView) holder.getView(R.id.tvtime);
        LinearLayout linGone = (LinearLayout) holder.getView(R.id.lin_gone);
        int real_income = list.getReal_income();
        double deduct = list.getDeduct();
        String sdeduct = String.valueOf(deduct);
        if (sdeduct.equals("0.0")){
            linGone.setVisibility(View.GONE);
        }
        tvAdd.setText(""+sdeduct);
        String createtime = list.getCreatetime();
        tvTime.setText(""+createtime);
    }


}
