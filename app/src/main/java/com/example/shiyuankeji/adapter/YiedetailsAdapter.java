package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.YieDetailsBean;

import java.util.List;

public class YiedetailsAdapter extends BaseAdapter {

    public YiedetailsAdapter(List<YieDetailsBean.ShareInfoVosBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_yiedetails;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        YieDetailsBean.ShareInfoVosBean list = (YieDetailsBean.ShareInfoVosBean) mDatas.get(positon);
        LinearLayout le_ = (LinearLayout) holder.getView(R.id.le_);
        TextView tname = (TextView) holder.getView(R.id.t_name);
        TextView tqian = (TextView) holder.getView(R.id.t_qian);

        int sharetype = list.getSharetype();
        if (sharetype == 1) {
            tname.setText("商务责任人分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 2) {
            tname.setText("商务组员分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 3) {
            tname.setText("单元责任人分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 4) {
            tname.setText("单元成员分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 5) {
            tname.setText("销售人分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 6) {
            tname.setText("个人代理分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 7) {
            tname.setText("现分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 8) {
            tname.setText("月工资");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 9) {
            tname.setText("季工资");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 10) {
            tname.setText("季分红");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 11) {
            tname.setText("年分红");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 12) {
            tname.setText("周分利");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 13) {
            tname.setText("组织代理分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 14) {
            tname.setText("转化率");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 15) {
            tname.setText("本级因转化");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 16) {
            tname.setText("上级因转化");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 17) {
            tname.setText("间级因转化");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 18) {
            tname.setText("商务合作人分成（中）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 19) {
            tname.setText("商务合作人分成（北）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 20) {
            tname.setText("商务合作人分成（西）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 21) {
            tname.setText("商务合作人分成（南）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 22) {
            tname.setText("商务合作人分成（东）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 23) {
            tname.setText("商务合作人分成（D）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 24) {
            tname.setText("商务合作人分成（C）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 25) {
            tname.setText("商务合作人分成（B）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        } else if (sharetype == 26) {
            tname.setText("商务合作人分成（A）");
            tqian.setText(String.valueOf(list.getTotalprice()));
        }else {
            le_.setVisibility(View.GONE);
        }

    }


}
