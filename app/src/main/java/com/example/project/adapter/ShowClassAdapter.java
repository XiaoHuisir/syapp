package com.example.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.bean.InfoBean;
import com.example.project.ui.activity.ProductDetailsActivity;

import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;

public class ShowClassAdapter extends RecyclerView.Adapter<ShowClassAdapter.ViewHodler> {
    private Context context;
    private ArrayList<InfoBean> list;


    public ShowClassAdapter(Context context, ArrayList<InfoBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.showclass_adapter, null);
        return new ViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodler viewHodler, int i) {
        InfoBean infoBean = list.get(i);
        if (i / 2 == 0) {
            viewHodler.mIm.setBackgroundResource(infoBean.getImg());
            viewHodler.mTvJi.setText(infoBean.getPrice() + "积分");
            viewHodler.mTvName.setText(infoBean.getName());
            viewHodler.jian.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线
        }
        if (i / 2 != 0) {
            viewHodler.mIm.setBackgroundResource(R.drawable.icon);
            viewHodler.mTvJi.setText("200积分");
            viewHodler.mTvName.setText("手机");
            viewHodler.jian.setText("100");
            viewHodler.jian.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线
        }
        viewHodler.linearNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProductDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView mIm;
        private TextView mTvName;
        private TextView mTvJi;
        private TextView jian;
        private LinearLayout linearNew;

        public ViewHodler(View itemView) {
            super(itemView);
            mIm = itemView.findViewById(R.id.im);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvJi = itemView.findViewById(R.id.tv_ji);
            jian = itemView.findViewById(R.id.tv_ji_jian);
            linearNew = itemView.findViewById(R.id.linear_new);
        }
    }
}
