package com.example.shiyuankeji.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.RecyclerViewAdapter;
import com.example.shiyuankeji.adapter.StickHeaderDecoration;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.SeeMoreBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.SeeMoreContract;
import com.example.shiyuankeji.presenter.SeeMorePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeeMoreActivity extends BaseActivity implements SeeMoreContract.View {
    @BindView(R.id.lli_back)
    LinearLayout lliBack;
    @BindView(R.id.recycler_seemore)
    RecyclerView recyclerSeemore;
//    @BindView(R.id.scroll_view)
//    ScrollView scrollView;
//    @BindView(R.id.smartRef)
//    SwipeRefreshLayout smartRef;
    private RecyclerViewAdapter mAdapter;
    ArrayList<SeeMoreBean.GrantShareInfoVoBean> list = new ArrayList<>();
    @Override
    protected IBasePresenter getPresenter() {
        return new SeeMorePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_seemore;
    }

    @Override
    protected void initView() {

        mAdapter = new RecyclerViewAdapter(context,list);
        recyclerSeemore.addItemDecoration(new StickHeaderDecoration(context));
        recyclerSeemore.setLayoutManager(new LinearLayoutManager(context));
        recyclerSeemore.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        ((SeeMorePresenter) mPresenter).seemores();
    }

    @Override
    public void seemoreRean(SeeMoreBean seeMoreBean) {
        if (seeMoreBean.getGrantShareInfoVo()!=null){
            List<SeeMoreBean.GrantShareInfoVoBean> grantShareInfoVo = seeMoreBean.getGrantShareInfoVo();
            list.clear();
            list.addAll(grantShareInfoVo);
            mAdapter.notifyDataSetChanged();
        }

    }



    @OnClick(R.id.lli_back)
    public void onViewClicked() {
        finish();
    }
}
