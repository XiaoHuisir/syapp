package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.QueryEarningsBean;
import com.example.shiyuankeji.utils.GlideRoundTransform;

import java.util.List;

public class YieldAdapter extends BaseAdapter {
    public YieContextItem yieContextItem;

    public YieldAdapter(List<QueryEarningsBean.ShareInfoVoBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_list;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        QueryEarningsBean.ShareInfoVoBean listbean = (QueryEarningsBean.ShareInfoVoBean) mDatas.get(positon);
        ImageView im = (ImageView) holder.getView(R.id.image_yie);
        TextView order_num = (TextView) holder.getView(R.id.tv_yie_order_num);
        TextView tv_tilet = (TextView) holder.getView(R.id.tv_tilet_yie);
        TextView tv_createtime = (TextView) holder.getView(R.id.tv_createtime);
        TextView tv_code_price = (TextView) holder.getView(R.id.tv_code_price);
        TextView tv_rmb_price = (TextView) holder.getView(R.id.tv_rmb_price);
        LinearLayout lin_yie = (LinearLayout) holder.getView(R.id.lin_yie);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.no_banner) //预加载图片
                .error(R.drawable.no_banner) //加载失败图片
                .priority(Priority.HIGH) //优先级
                .diskCacheStrategy(DiskCacheStrategy.NONE) //缓存
                .transform(new GlideRoundTransform(3)); //圆角
        Glide.with(mContext).load(listbean.getImg()).apply(options).into(im);
        tv_code_price.setText(String.valueOf(listbean.getRmb_price()));
        order_num.setText("订单号："+listbean.getOrder_num());
        tv_rmb_price.setText(String.valueOf(listbean.getTotalprice()));
        tv_tilet.setText(listbean.getName());
        tv_createtime.setText("下单时间："+listbean.getCreate_time());
        lin_yie.setTag(mDatas.get(positon));
        lin_yie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryEarningsBean.ShareInfoVoBean tag = (QueryEarningsBean.ShareInfoVoBean) v.getTag();
                yieContextItem.yiecontextitem(tag);
            }
        });
    }

    public interface YieContextItem {
        void yiecontextitem(QueryEarningsBean.ShareInfoVoBean list);
    }

}
