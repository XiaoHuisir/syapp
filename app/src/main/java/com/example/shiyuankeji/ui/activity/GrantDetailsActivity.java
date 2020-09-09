package com.example.shiyuankeji.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.GrantAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.GrantDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.GrantDeatailContract;
import com.example.shiyuankeji.presenter.GrantDeatailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GrantDetailsActivity extends BaseActivity implements GrantDeatailContract.View {
    @BindView(R.id.lli_back)
    LinearLayout lliBack;
    @BindView(R.id.tv_tilet)
    TextView tvTilet;
    @BindView(R.id.recycler_grantdetails)
    RecyclerView recyclerGrantdetails;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    private String createtime = "";
    private GrantAdapter grantAdapter;
    ArrayList<GrantDetailsBean.DataBean> list = new ArrayList<>();

    @Override
    protected IBasePresenter getPresenter() {
        return new GrantDeatailPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_frantdetails;
    }

    @Override
    protected void initView() {
        recyclerGrantdetails.setHasFixedSize(true);
        recyclerGrantdetails.setNestedScrollingEnabled(false);
        createtime = getIntent().getStringExtra("createtimes");
        tvTilet.setText(createtime);
        recyclerGrantdetails.setLayoutManager(new LinearLayoutManager(context));
        grantAdapter = new GrantAdapter(list);
        recyclerGrantdetails.setAdapter(grantAdapter);
    }

    @Override
    protected void initData() {
        ((GrantDeatailPresenter) mPresenter).grants(createtime);
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
    public void grantRean(GrantDetailsBean grantDetailsBean) {
        if (grantDetailsBean.getStatus() == 200) {
            if (grantDetailsBean.getData() != null) {
                List<GrantDetailsBean.DataBean> data = grantDetailsBean.getData();
                list.clear();
                list.addAll(data);
                grantAdapter.notifyDataSetChanged();
            }
        }
    }
}
