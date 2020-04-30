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

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.bean.ClassListBean;
import com.example.project.bean.InfoBean;
import com.example.project.ui.activity.ProductDetailsActivity;

import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;

public class ShowClassAdapter extends RecyclerView.Adapter<ShowClassAdapter.ViewHodler> {
    private Context context;
    private ArrayList<ClassListBean.ItemsListBean> list;


    public ShowClassAdapter(Context context, ArrayList<ClassListBean.ItemsListBean> list) {
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
        if (list.size() > 0 && list != null) {
            final ClassListBean.ItemsListBean listBean = list.get(i);
            String img = listBean.getImg();
            Glide.with(context).load(img).into(viewHodler.mIm);

            viewHodler.mTvJi.setText(String.valueOf(listBean.getSrc_price()));
            viewHodler.mTvName.setText(listBean.getName());
            viewHodler.jian.setText(String.valueOf(listBean.getPrice()));
            viewHodler.jian.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线
            viewHodler.linearNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idsa = listBean.getIdsa();
                    Intent intent = new Intent(context, ProductDetailsActivity.class);
                    intent.putExtra("idsa", String.valueOf(idsa));
                    context.startActivity(intent);
                }
            });
        }

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
