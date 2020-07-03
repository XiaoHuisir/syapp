package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class WebStringAdapter extends BaseAdapter {
    public WebStringAdapter(ArrayList<String>  mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_string;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        String o1 = (String) mDatas.get(positon);

        ImageView imag = (ImageView) holder.getView(R.id.image_string);
        Glide.with(mContext).load(o1).into(imag);
    }


}
