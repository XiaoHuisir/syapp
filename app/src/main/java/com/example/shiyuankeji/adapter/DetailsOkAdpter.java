package com.example.shiyuankeji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsOkAdpter extends RecyclerView.Adapter<DetailsOkAdpter.ViewHolder> {
    public ClickDetailsOkItem clickDetailsOkItem;
    private final static int TYPE_NORMAL = 0;//正常条目
    private final static int TYPE_SEE_MORE = 1;//查看更多
    private final static int TYPE_HIDE = 2;//收起
    private boolean mOpen = false;//是否是展开状态
    private Context context;
    private ArrayList<CheckDetailsBean.AlreadyShareInfoVoBean> list;

    public DetailsOkAdpter(Context context, ArrayList<CheckDetailsBean.AlreadyShareInfoVoBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_details_ok, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == TYPE_HIDE) {
//            viewHolder.show_hide.setVisibility(View.GONE);
//            viewHolder.show_hide.setText("收起");

        } else if (getItemViewType(i) == TYPE_SEE_MORE) {
//            viewHolder.show_hide.setVisibility(View.VISIBLE);
//            viewHolder.show_hide.setText("查看更多");
        } else {
//            textView.setText(mList.get(position));
//            textView.setClickable(false);
//            Html.fromHtml("<u>"+"0123456"+"</u>")
//            viewHolder.tvName.setText(Html.fromHtml("<u>"+list.get(i).getName()+"</u>"));
//            viewHolder.tvTilte.setText(list.get(i).getAge()+"");
//            viewHolder.tvName.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
//            tvTest.getPaint().setAntiAlias(true);//抗锯齿

            viewHolder.tvPrices.setText(list.get(i).getTotalprice() + "");
            viewHolder.tvTimes.setText(list.get(i).getCreatetime());
            viewHolder.re_ck.setTag(list.get(i).getCreatetime());
            viewHolder.re_ck.setOnClickListener(new NoDoubleClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
                    String createtime = (String) v.getTag();
                    clickDetailsOkItem.clickdetailsokitem(createtime);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.size() <= 4) {
            return TYPE_NORMAL;
        }
        if (mOpen) {
            if (position == list.size()) {
                return TYPE_HIDE;
            } else {
                return TYPE_NORMAL;
            }
        } else {
            if (position == 4) {
                return TYPE_SEE_MORE;
            } else {
                return TYPE_NORMAL;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (list == null || list.size() == 0) {
            return 0;
        }
        if (list.size() > 4) {
            //若现在是展开状态 条目数量需要+1 "收起"条目
            if (mOpen) {
                return list.size() + 1;
            } else {
                return 4;
            }
        } else {
            return list.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTimes;
        TextView tvPrices;
        RelativeLayout re_ck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTimes = itemView.findViewById(R.id.tv_times);
            tvPrices = itemView.findViewById(R.id.tv_prices);
            re_ck = itemView.findViewById(R.id.re_ck);
        }
    }

    public interface ClickDetailsOkItem {
        void clickdetailsokitem(String createtime);
    }
//    public ClickDetailsOkItem clickDetailsOkItem;
//    public DetailsOkAdpter(List<CheckDetailsBean.AlreadyShareInfoVoBean> mDatas) {
//        super(mDatas);
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.adapter_details_ok;
//    }
//
//    @Override
//    protected void bindData(BaseViewHolder holder, int positon, Object o) {
//        CheckDetailsBean.AlreadyShareInfoVoBean list = (CheckDetailsBean.AlreadyShareInfoVoBean) mDatas.get(positon);
//        TextView tvTimes = (TextView) holder.getView(R.id.tv_times);
//        TextView tvPrices = (TextView) holder.getView(R.id.tv_prices);
//        RelativeLayout re_ck = (RelativeLayout) holder.getView(R.id.re_ck);
//        tvPrices.setText(list.getTotalprice()+"");
//        tvTimes.setText(list.getCreatetime());
//        re_ck.setTag(list.getCreatetime());
//        re_ck.setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
//                String createtime = (String) v.getTag();
//                clickDetailsOkItem.clickdetailsokitem(createtime);
//            }
//        });
//    }
//    public  interface ClickDetailsOkItem{
//        void  clickdetailsokitem(String createtime);
//    }

}
