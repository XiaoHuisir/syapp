package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.YieldAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.QueryEarningsBean;
import com.example.shiyuankeji.bean.YieDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.QueryEarningsContract;
import com.example.shiyuankeji.presenter.QueryEarningsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YieldActivity extends BaseActivity implements QueryEarningsContract.View, YieldAdapter.YieContextItem {
    @BindView(R.id.lli_back)
    LinearLayout lliBack;
    @BindView(R.id.ree_yield)
    RecyclerView reeYield;
    @BindView(R.id.tv_now)
    TextView tvNow;
    @BindView(R.id.tv_zong)
    TextView tvZong;
    private ArrayList<QueryEarningsBean.ShareInfoVoBean> listyieid;
    private YieldAdapter yieldAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new QueryEarningsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yield;
    }

    @Override
    protected void initData() {
        ((QueryEarningsPresenter) mPresenter).earnings();
    }

    @Override
    protected void initView() {
//        TODO 适配器逻辑 （等接口）未完。。。。。。。。。。。。。。。。。
        listyieid = new ArrayList<>();
        reeYield.setLayoutManager(new LinearLayoutManager(context));//管理器
        //适配器
        yieldAdapter = new YieldAdapter(listyieid);
        yieldAdapter.yieContextItem = this;
        reeYield.setAdapter(yieldAdapter);
    }

    @OnClick({R.id.lli_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lli_back:
                finish();
                break;
        }
    }

    @Override
    public void earningsRean(QueryEarningsBean queryEarningsBean) {
        if (queryEarningsBean != null) {
            List<QueryEarningsBean.ShareInfoVoBean> shareInfoVo = queryEarningsBean.getShareInfoVo();
            listyieid.addAll(shareInfoVo);

            yieldAdapter.notifyDataSetChanged();

            tvNow.setText(String.valueOf(queryEarningsBean.getTotalprice()));
            tvZong.setText(String.valueOf(queryEarningsBean.getProfit()));
        }
    }

    @Override
    public void yiedetailsRean(YieDetailsBean yieDetailsBean) {

    }

    //回调
    @Override
    public void yiecontextitem(QueryEarningsBean.ShareInfoVoBean list) {
        if (list != null) {
            String order_num = list.getOrder_num();
            Intent intent = new Intent();
            intent.setClass(context,YiedetailsActivity.class);
            intent.putExtra("order",order_num);
            startActivity(intent);
        }
    }
}
