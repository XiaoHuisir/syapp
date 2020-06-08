package com.example.shiyuankeji.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.interfaces.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;

import butterknife.OnClick;

public class YieldActivity extends BaseActivity {
    @BindView(R.id.lli_back)
    LinearLayout lliBack;
    @BindView(R.id.ree_yield)
    RecyclerView reeYield;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yield;
    }

    @Override
    protected void initView() {
//        TODO 适配器逻辑 （等接口）未完。。。。。。。。。。。。。。。。。
//        ArrayList<String> listyieid = new ArrayList<>();
//        reeYield.setLayoutManager(new LinearLayoutManager(context));//管理器
//        YieldAdapter yieldAdapter = new YieldAdapter(listyieid); //适配器
//        reeYield.setAdapter(yieldAdapter);
    }

    @OnClick({R.id.lli_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lli_back:
                finish();
                break;
        }
    }
}
