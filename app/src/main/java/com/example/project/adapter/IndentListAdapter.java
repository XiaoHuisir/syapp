package com.example.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.annotation.NonNull;
import com.example.project.R;
import com.example.project.bean.IndentBean;
import com.example.project.ui.activity.IineItemActivity;

import java.util.ArrayList;

//ViewHodler
public class IndentListAdapter extends RecyclerView.Adapter<IndentListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<IndentBean> list;


    public IndentListAdapter(Context context, ArrayList<IndentBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.adpater_indent_list, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder viewHolder, int i) {
        IndentBean indentBean = list.get(i);

        viewHolder.mTvOdd.setText(String.valueOf(indentBean.getOrdernumber()));
        viewHolder.mTxtColor.setText(indentBean.getColor());
        viewHolder.mTxtName.setText(indentBean.getName());
//        setQuantity
        viewHolder.mTxtShuliang.setText("X "+String.valueOf(indentBean.getQuantity()));
//             indentBean.setPrice(3333);
        viewHolder.txtjiaqian.setText(String.valueOf(indentBean.getPrice()));
        viewHolder.mTxtZhongji.setText(String.valueOf(indentBean.getTotal()));

        viewHolder.mLinXiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //跳转订单详情
                context.startActivity(new Intent(context, IineItemActivity.class));
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
        private LinearLayout mLinXiangqing;
        private LinearLayout mLiBnt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvOdd = itemView.findViewById(R.id.tv_odd);
            mImager = itemView.findViewById(R.id.imager);
            mTxtName = itemView.findViewById(R.id.txt_name);
            mTxtColor = itemView.findViewById(R.id.txt_color);
            mTxtShuliang = itemView.findViewById(R.id.txt_shuliang);
            mTxtZhongji = itemView.findViewById(R.id.txt_zhongji);
            mLinXiangqing = itemView.findViewById(R.id.lin_xiangqing);
            mLiBnt = itemView.findViewById(R.id.li_bnt);
            txtjiaqian = itemView.findViewById(R.id.txt_jiaqian);
        }
    }
}
