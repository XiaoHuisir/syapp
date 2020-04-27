package com.example.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.bean.HomeBean;
import com.example.project.ui.activity.ExchangeActivity;
import com.example.project.ui.activity.ProductDetailsActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHodler> {
    private ArrayList<HomeBean.MainListTitleBean> listTetle;
    private Context context;
    private List<HomeBean.MainListTitleBean.ItemsListBean> itemsList;

    public HomeAdapter(ArrayList<HomeBean.MainListTitleBean> listTetle, Context context) {
        this.listTetle = listTetle;
        this.context = context;
    }


    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.adapter_home, null);
        ViewHodler hodler = new ViewHodler(inflate);
        return hodler;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        if (listTetle.size() > 0 && listTetle != null) {
            HomeBean.MainListTitleBean mainListTitleBean = listTetle.get(i);
            viewHodler.textTilte.setText(mainListTitleBean.getTitle_content()); //设置标题
            itemsList = mainListTitleBean.getItemsList();
            if (itemsList != null && itemsList.size() > 0) {
                viewHodler.recyclerHomeadpater.setLayoutManager(new GridLayoutManager(context, 2));
                HomeListAdpater homeListAdpater = new HomeListAdpater(itemsList, context);
                viewHodler.recyclerHomeadpater.setAdapter(homeListAdpater);
            } else {
                return;
            }
        }
    }


    @Override
    public int getItemCount() {
        return listTetle.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        public RecyclerView recyclerHomeadpater;
        public TextView textTilte;

        public ViewHodler(View itemView) {
            super(itemView);
            recyclerHomeadpater = itemView.findViewById(R.id.recycler_homeadpater);
            textTilte = itemView.findViewById(R.id.text_tilte);

        }
    }
}
