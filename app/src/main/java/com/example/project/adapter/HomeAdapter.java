package com.example.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.bean.InfoBean;
import com.example.project.ui.activity.ExchangeActivity;
import com.example.project.ui.activity.ProductDetailsActivity;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHodler> {
    private ArrayList<InfoBean> rl;
    private Context context;

    public HomeAdapter(ArrayList<InfoBean> rl, Context context) {
        this.rl = rl;
        this.context = context;
    }


    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.itme, null);
        ViewHodler hodler = new ViewHodler(inflate);
        return hodler;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        InfoBean infoBean = rl.get(i);
        viewHodler.img.setBackgroundResource(infoBean.getImg());
        viewHodler.tv_name.setText(infoBean.getName());
        viewHodler.tv_id.setText("兑换");
//        viewHodler.tv_id.setText(infoBean.getPrice());
        viewHodler.tv_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            context.startActivity(new Intent(context, ExchangeActivity.class));
            }
        });
        viewHodler.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProductDetailsActivity.class));
            }
        });
    }



    @Override
    public int getItemCount() {
        return rl.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
       public TextView tv_name;
        public TextView tv_id;
        public ImageView img;

        public ViewHodler( View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
            tv_id = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);
        }
    }
}
