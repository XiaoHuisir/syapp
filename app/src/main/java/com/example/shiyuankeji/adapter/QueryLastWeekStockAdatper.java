package com.example.shiyuankeji.adapter;

import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.QueryLastWeekStockBean;

import java.util.List;

public class QueryLastWeekStockAdatper extends BaseAdapter {
    public QueryLastWeekStockAdatper(List<QueryLastWeekStockBean.UserAddLogListBean> mDatas) {
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
        QueryLastWeekStockBean.UserAddLogListBean list = (QueryLastWeekStockBean.UserAddLogListBean) mDatas.get(positon);
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
