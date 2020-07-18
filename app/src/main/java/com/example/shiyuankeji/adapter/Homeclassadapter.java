package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.HomeBean;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

import java.util.List;

public class Homeclassadapter extends BaseAdapter {
    public  HomeClassClick homeclassClick;
    public Homeclassadapter(List<HomeBean.CateListBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_homeclasstiy;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        HomeBean.CateListBean list = (HomeBean.CateListBean) mDatas.get(positon);
        ImageView imagetilte = (ImageView) holder.getView(R.id.image_tilte);
        TextView tvtilte = (TextView) holder.getView(R.id.tv_tilte);
        RelativeLayout reclasstiy = (RelativeLayout) holder.getView(R.id.reclasstiy);
        Glide.with(mContext).load(list.getImg()).into(imagetilte);
        tvtilte.setText(list.getName());
        reclasstiy.setTag(mDatas.get(positon));
        reclasstiy.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                HomeBean.CateListBean tag = (HomeBean.CateListBean) v.getTag();
                homeclassClick.cliaasclick(tag);
            }
        });

    }
    public interface HomeClassClick{
        void  cliaasclick(HomeBean.CateListBean listBean);
    }


}
