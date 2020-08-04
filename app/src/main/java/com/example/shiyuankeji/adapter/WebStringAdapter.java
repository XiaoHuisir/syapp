package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.utils.GlideRoundTransform;

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
//        Glide.with(mContext).load(o1).into(imag);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.no_banner) //预加载图片
                .error(R.drawable.no_banner) //加载失败图片
                .priority(Priority.HIGH) //优先级
                .diskCacheStrategy(DiskCacheStrategy.NONE); //缓存
        Glide.with(mContext).load(o1).apply(options).into(imag);

    }


}
