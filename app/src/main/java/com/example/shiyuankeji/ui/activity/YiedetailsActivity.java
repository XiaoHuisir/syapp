package com.example.shiyuankeji.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.YiedetailsAdapter;
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

public class YiedetailsActivity extends BaseActivity implements QueryEarningsContract.View {

    @BindView(R.id.lli_back)
    LinearLayout lliBack;
    @BindView(R.id.im_tu)
    ImageView imTu;
    @BindView(R.id.tv_tilet)
    TextView tvTilet;
    @BindView(R.id.tv_code_num)
    TextView tvCodeNum;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.recycler_yiedetailes)
    RecyclerView recyclerYiedetailes;
    private String order = "";
    private ArrayList<YieDetailsBean.ShareInfoVosBean> sharelist;
    private YiedetailsAdapter yiedetailsAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new QueryEarningsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yiedetails;
    }

    @Override
    protected void initView() {
        order = getIntent().getStringExtra("order");
        sharelist = new ArrayList<>();
        recyclerYiedetailes.setLayoutManager(new GridLayoutManager(context,3));
        yiedetailsAdapter = new YiedetailsAdapter(sharelist);
        recyclerYiedetailes.setAdapter(yiedetailsAdapter);
    }

    @Override
    protected void initData() {
        ((QueryEarningsPresenter)mPresenter).yiedetail(order);
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

    }

    @Override
    public void yiedetailsRean(YieDetailsBean yieDetailsBean) {
        if (yieDetailsBean != null) {
            List<YieDetailsBean.ShareInfoVoBean> shareInfoVo = yieDetailsBean.getShareInfoVo();
            if (shareInfoVo.size() > 0 && shareInfoVo != null) {
                YieDetailsBean.ShareInfoVoBean share = shareInfoVo.get(0);
                tvTilet.setText(share.getName());
                tvCodeNum.setText(share.getOrder_num());
                tvTime.setText(share.getCreate_time());

            }
            List<YieDetailsBean.ShareInfoVosBean> shareInfoVos = yieDetailsBean.getShareInfoVos();
            sharelist.addAll(shareInfoVos);
            yiedetailsAdapter.notifyDataSetChanged();
        }
    }
}
