package com.example.shiyuankeji.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.bean.NewIndentBean;
import com.example.shiyuankeji.utils.GlideRoundTransform;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

import java.util.ArrayList;

//ViewHodler
public class IndentListAdapter extends RecyclerView.Adapter<IndentListAdapter.ViewHolder> {
    public IndentItemClick itemClick;
    private Context context;
    private ArrayList<NewIndentBean.OrderListListBean> list;
    //    0，订单待确认、1，待发货、2，待收货、3，兑换完成、4，积分不够

    public IndentListAdapter(Context context, ArrayList<NewIndentBean.OrderListListBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.adpater_indent_list, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        NewIndentBean.OrderListListBean orderListsBean = list.get(i);
//      -  order_state //订单状态
        int order_state = orderListsBean.getOrder_state(); //订单状态
        if (order_state == Constant.ORDER_STATE_0) {
            viewHolder.txtOrderStatus.setText("未支付");
        } else if (order_state == Constant.ORDER_STATE_1) {
            viewHolder.txtOrderStatus.setText("待发货");
        } else if (order_state == Constant.ORDER_STATE_2) {
            viewHolder.txtOrderStatus.setText("待收货");
        } else if (order_state == Constant.ORDER_STATE_3) {
            viewHolder.txtOrderStatus.setText("完成");
        } else if (order_state == Constant.ORDER_STATE_4) {
            viewHolder.txtOrderStatus.setText("数据异常");
        } else {
            viewHolder.txtOrderStatus.setText("订单待确认");
        }

        viewHolder.mTvOdd.setText("订单号:" + orderListsBean.getOrder_num());//订单号
        viewHolder.mTxtName.setText(orderListsBean.getItems().getName()); //name
        viewHolder.txtjiaqian.setText(orderListsBean.getItems().getRmb_price() + "积分");//价格
        viewHolder.mTxtZhongji.setText(orderListsBean.getOrder_price() + "积分");//交易价格
        viewHolder.txtItem_freight.setText("(含运费:" + orderListsBean.getItem_freight() + "积分)");//运费 (含运费:0积分)
        viewHolder.mTxtShuliang.setText("X" + orderListsBean.getNum());//数量
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.no_banner) //预加载图片
                .error(R.drawable.no_banner) //加载失败图片
                .priority(Priority.HIGH) //优先级
                .diskCacheStrategy(DiskCacheStrategy.NONE) //缓存
                .transform(new GlideRoundTransform(3)); //圆角
        Glide.with(context).load(orderListsBean.getItems().getImg()).apply(options).into(viewHolder.mImager);


// 回调 跳转订单详情
        viewHolder.mLiBnt.setTag(list.get(i));
        viewHolder.mLiBnt.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                NewIndentBean.OrderListListBean indentlist = (NewIndentBean.OrderListListBean) v.getTag();
                itemClick.indentclick(indentlist);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvOdd;
        private ImageView mImager;
        private TextView mTxtName;
        private TextView mTxtColor;
        private TextView mTxtShuliang;
        private TextView txtjiaqian;
        private TextView mTxtZhongji;
        private TextView txtItem_freight;
        private TextView txtOrderStatus;
        private LinearLayout mLinXiangqing;
        private LinearLayout mLiBnt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvOdd = itemView.findViewById(R.id.tv_odd);
            mImager = itemView.findViewById(R.id.imager);
            mTxtName = itemView.findViewById(R.id.txt_name);
//            mTxtColor = itemView.findViewById(R.id.txt_color);
            mTxtShuliang = itemView.findViewById(R.id.txt_shuliang);
            mTxtZhongji = itemView.findViewById(R.id.txt_zhongji);
            mLinXiangqing = itemView.findViewById(R.id.lin_xiangqing);
            mLiBnt = itemView.findViewById(R.id.li_bnt);
            txtjiaqian = itemView.findViewById(R.id.txt_jiaqian);
            txtItem_freight = itemView.findViewById(R.id.txt_item_freight);
            txtOrderStatus = itemView.findViewById(R.id.txt_order_status);
        }
    }

    public interface IndentItemClick {
        void indentclick(NewIndentBean.OrderListListBean orderListsBean);
    }
}
