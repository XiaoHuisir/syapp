package com.example.shiyuankeji.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.SynXingAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.SynergicBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.SynergiContract;
import com.example.shiyuankeji.presenter.SynergicPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SynergicXingActivity extends BaseActivity implements SynergiContract.View {

    @BindView(R.id.lin_wbeak)
    LinearLayout linWbeak;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.recyc_xing)
    RecyclerView recycXing;
    private int e_id;
    private ArrayList<SynergicBean.DataBean> datalist;
    private String nic_name;
    private SynXingAdapter synXingAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new SynergicPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_synxing;
    }

    @Override
    protected void initView() {
        e_id = getIntent().getIntExtra("e_id", 0);
        nic_name = getIntent().getStringExtra("nic_name");
        textName.setText(nic_name);
        datalist = new ArrayList<>();
        recycXing.setLayoutManager(new LinearLayoutManager(context));
        synXingAdapter = new SynXingAdapter(datalist);
        recycXing.setAdapter(synXingAdapter);
    }

    @Override
    protected void initData() {
        ((SynergicPersenter) mPresenter).synergicxings(String.valueOf(e_id));
    }

    @Override
    public void synergicRean(SynergicBean synergicBean) {

    }

    @Override
    public void synergicxingRean(SynergicBean synergicBean) {
        if (synergicBean == null) {
            return;
        }
        List<SynergicBean.DataBean> data = synergicBean.getData();
        datalist.clear();
        datalist.addAll(data);
        synXingAdapter.notifyDataSetChanged();
    }


    @OnClick({R.id.lin_wbeak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_wbeak:
                finish();
                break;
        }
    }
}
