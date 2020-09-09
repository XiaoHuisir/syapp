package com.example.shiyuankeji.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.SeeMoreBean;
import com.example.shiyuankeji.ui.activity.GrantDetailsActivity;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

import java.util.List;

public class MseeWoreadapter extends BaseAdapter {
    public MseeWoreadapter(List<SeeMoreBean.GrantShareInfoVoBean.GrantShareInfoVo2Bean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_mseeworea;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        SeeMoreBean.GrantShareInfoVoBean.GrantShareInfoVo2Bean list = (SeeMoreBean.GrantShareInfoVoBean.GrantShareInfoVo2Bean) mDatas.get(positon);
        TextView tvTiem = (TextView) holder.getView(R.id.tv_time);
        TextView tvPrice = (TextView) holder.getView(R.id.tv_price);
        RelativeLayout relative = (RelativeLayout) holder.getView(R.id.relative);
        tvPrice.setText(String.valueOf(list.getMonthTotal()));
        tvTiem.setText(String.valueOf(list.getCreate()));
        final String create = list.getCreate();
        relative.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContext, GrantDetailsActivity.class);
                intent.putExtra("createtimes",create);
                mContext.startActivity(intent);
            }
        });

    }


}
