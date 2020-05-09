package com.example.project.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.base.BaseAdapter;
import com.example.project.bean.QueryIntegralBean;
import com.example.project.bean.QueryLastWeekStockBean;

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
            namelist.setText("增加" + add_val + "股");
        } else {
            namelist.setText("减少" + add_val + "股");
        }
        String time = list.getTime();
        itmelist.setText(time);
    }


}
