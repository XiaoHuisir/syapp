package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

import java.util.List;

public class NotWeekAdapter extends BaseAdapter {
    public ClickNotWeekItem clickWeekItems;
    public NotWeekAdapter(List<CheckDetailsBean.NotShareInfoVoBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_week;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        CheckDetailsBean.NotShareInfoVoBean list = (CheckDetailsBean.NotShareInfoVoBean) mDatas.get(positon);
        LinearLayout linShowweek = (LinearLayout) holder.getView(R.id.lin_showweek);
        TextView tvTimeWeek = (TextView) holder.getView(R.id.tv_timeweek);
        TextView tvPriceWeek = (TextView) holder.getView(R.id.tv_priceweek);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        tvName.setText("周分配收益");
        tvTimeWeek.setText(list.getCreatetime());
        tvPriceWeek.setText(String.valueOf(list.getTotalprice()));

        linShowweek.setTag(list.getCreatetime());
        linShowweek.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                String createtime = (String) v.getTag();
                clickWeekItems.clickweekitem(createtime);
            }
        });


    }
    public  interface ClickNotWeekItem{
        void  clickweekitem(String createtime);
    }


}
