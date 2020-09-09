package com.example.shiyuankeji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.bean.SeeMoreBean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<SeeMoreBean.GrantShareInfoVoBean> list;

    public RecyclerViewAdapter(Context context, ArrayList<SeeMoreBean.GrantShareInfoVoBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerViewAdapter.ViewHolder viewHolder = null;
        if (viewHolder == null) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_text, viewGroup, false);
            viewHolder = new RecyclerViewAdapter.ViewHolder(itemView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List<SeeMoreBean.GrantShareInfoVoBean.GrantShareInfoVo2Bean> grantShareInfoVo2 = list.get(i).getGrantShareInfoVo2();
//        viewHolder.tvPrice.setText(String.valueOf();
//                viewHolder.tvTiem.setText(String.valueOf(list.get(i).getGrantShareInfoVo2().get(i).getCreate()));
        viewHolder.recycler.setLayoutManager(new LinearLayoutManager(context));
        MseeWoreadapter mseeWoreadapter = new MseeWoreadapter(grantShareInfoVo2);
        viewHolder.recycler.setAdapter(mseeWoreadapter);
        mseeWoreadapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
    /**
     * 判断position对应的Item是否是组的第一项
     *
     * @param position
     * @return
     */
    public boolean isItemHeader(int position) {
        if (position == 0) {
            return true;
        } else {
            String lastGroupName = list.get(position - 1).getMonthTatalPrice();
            String currentGroupName = list.get(position).getMonthTatalPrice();
            //判断上一个数据的组别和下一个数据的组别是否一致，如果不一致则是不同组，也就是为第一项（头部）
            if (lastGroupName.equals(currentGroupName)) {
                return false;
            } else {
                return true;
            }
        }
    }
    /**
     * 获取position对应的Item组名
     *
     * @param position
     * @return
     */
    public String getGroupName(int position) {
        return list.get(position).getMonthTatalPrice();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTiem;
        TextView tvPrice;
        RecyclerView recycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
         recycler = itemView.findViewById(R.id.recycler);
//            tvTiem = itemView.findViewById(R.id.tv_time);
//            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
