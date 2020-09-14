package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.ExperienceBean;
import com.example.shiyuankeji.bean.QueryIntegralBean;

import java.util.List;

public class EperienceAdapter extends BaseAdapter {
    public EperienceAdapter(List<ExperienceBean.UserAddLogListBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.integral_details_list;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        TextView namelist = (TextView) holder.getView(R.id.tv_name_lsit);
        TextView itmelist = (TextView) holder.getView(R.id.tv_itme_list);
        ExperienceBean.UserAddLogListBean list = (ExperienceBean.UserAddLogListBean) mDatas.get(positon);
        int add_val = list.getAdd_val();
        if (add_val >= 0) {
            namelist.setTextColor(mContext.getResources().getColor(R.color.newnew_bg));
            namelist.setText("增加" + add_val + "积分");
        } else {
            namelist.setTextColor(mContext.getResources().getColor(R.color.col_score));
            namelist.setText("减少" + add_val + "积分");
        }
        String time = list.getTime();
        itmelist.setText(time);
    }


}
