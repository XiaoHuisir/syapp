package com.example.shiyuankeji.adapter;

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
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.bean.HomeBean;
import com.example.shiyuankeji.ui.activity.ProductDetailsActivity;

import java.util.List;


public class HomeListAdpater extends RecyclerView.Adapter<HomeListAdpater.ViewHolder> {

    private List<HomeBean.MainListTitleBean.ItemsListBean> itemsList;
    private Context context;

    public HomeListAdpater(List<HomeBean.MainListTitleBean.ItemsListBean> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.adpater_home_list, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (itemsList != null) {


            final HomeBean.MainListTitleBean.ItemsListBean list = itemsList.get(i);
            //img
            Glide.with(context).load(list.getImg()).into(viewHolder.imImg);
            viewHolder.textName.setText(list.getName()); //src_price_code  code_price
            viewHolder.textPrice.setText(String.valueOf(list.getSrc_price_code()));
            viewHolder.textSrcPrice.setText(String.valueOf(list.getCode_price()));
            viewHolder.textPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);


            viewHolder.linearItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idsa = list.getIdsa();
                    Intent intent = new Intent();
                    intent.setClass(context, ProductDetailsActivity.class);
                    intent.putExtra("idsa", String.valueOf(idsa));
                    context.startActivity(intent);

                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imImg;
        TextView textName;
        TextView textSrcPrice;
        TextView textPrice;
        LinearLayout linearItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imImg = itemView.findViewById(R.id.im_img);
            textName = itemView.findViewById(R.id.text_name);
            textSrcPrice = itemView.findViewById(R.id.text_src_price);
            textPrice = itemView.findViewById(R.id.text_price);
            linearItem = itemView.findViewById(R.id.linear_item);


        }
    }
}
