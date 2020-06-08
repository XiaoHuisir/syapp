package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;

import java.util.List;

public class YieldAdapter extends BaseAdapter {
    public YieldAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_list;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {

    }

}
