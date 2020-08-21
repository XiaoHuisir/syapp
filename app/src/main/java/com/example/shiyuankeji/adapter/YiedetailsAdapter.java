package com.example.shiyuankeji.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
        RelativeLayout le_ = (RelativeLayout) holder.getView(R.id.le_);
        TextView tname = (TextView) holder.getView(R.id.t_name);
        TextView tqian = (TextView) holder.getView(R.id.t_qian);
        TextView tvCreatetime = (TextView) holder.getView(R.id.tv_createtime);

        int sharetype = list.getSharetype();
        if (sharetype == 1) {
            tname.setText("商务责任人分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 2) {
            tname.setText("商务组员分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 3) {
            tname.setText("单元责任人分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 4) {
            tname.setText("单元成员分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 5) {
            tname.setText("销售人分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 6) {
            tname.setText("个人代理分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 7) {
            tname.setText("现分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 8) {
            tname.setText("月工资");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 9) {
            tname.setText("季工资");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 10) {
            tname.setText("季分红");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 11) {
            tname.setText("年分红");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 12) {
            tname.setText("周分利责任人");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 13) {
            tname.setText("组织代理分成");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 14) {
            tname.setText("转化率");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 15) {
            tname.setText("本级因转化");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 16) {
            tname.setText("上级因转化");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 17) {
            tname.setText("间级因转化");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 18) {
            tname.setText("中");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 19) {
            tname.setText("北");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 20) {
            tname.setText("西");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 21) {
            tname.setText("南");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 22) {
            tname.setText("东");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 23) {
            tname.setText("商务合作人分成（D）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 24) {
            tname.setText("商务合作人分成（C）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 25) {
            tname.setText("商务合作人分成（B）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 26) {
            tname.setText("商务合作人分成（A）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 27){
            tname.setText("中部");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 28){
            tname.setText("北部");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 29){
            tname.setText("西部");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 30){
            tname.setText("南部");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 31){
            tname.setText("东部");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 32) {
            tname.setText("土");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 33) {
            tname.setText("金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 34) {
            tname.setText("水");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 35) {
            tname.setText("木");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 36) {
            tname.setText("火");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 37) {
            tname.setText("上级单元负责人分配奖 (考核)");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 38) {
            tname.setText("上级单元成员分配奖(考核)");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 39) {
            tname.setText("上级单元责任人（周分）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 40) {
            tname.setText("上级单元人加权（周分）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 41) {
            tname.setText("间级单元责任人（周分）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 42) {
            tname.setText("间级单元人加权（周分）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }else if (sharetype == 43) {
            tname.setText("代理身份标准人");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 44) {
            tname.setText("周分利单元人加权");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 45) {
            tname.setText("上级单元责任人（现分）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 46) {
            tname.setText("间级单元责任人（现分）");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 47) {
            tname.setText("本-月奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 48) {
            tname.setText("上-月奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 49) {
            tname.setText("间-月奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 50) {
            tname.setText("本-季奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 51) {
            tname.setText("上-季奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 52) {
            tname.setText("间-季奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 53) {
            tname.setText("本-年奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 54) {
            tname.setText("上-年奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 55) {
            tname.setText("间-年奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        } else if (sharetype == 56) {
            tname.setText("A级现-奖金");
            tqian.setText(String.valueOf(list.getTotalprice()));
            tvCreatetime.setText(list.getCreatetime());
        }
        else {
            le_.setVisibility(View.GONE);
        }

    }


}
