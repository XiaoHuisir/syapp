package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.SynergicAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.SynergicBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.SynergiContract;
import com.example.shiyuankeji.presenter.SynergicPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SynergicActivity extends BaseActivity implements SynergiContract.View, SynergicAdapter.SynergicClick {
    @BindView(R.id.lin_wbeak)
    LinearLayout linWbeak;
    @BindView(R.id.recyc_synergic)
    RecyclerView recycSynergic;
    @BindView(R.id.scroll_show)
    ScrollView scrollShow;
    //    @BindView(R.id.on_shuju)
//    ImageView onShuju;
    @BindView(R.id.tv_place)
    TextView tvPlace;
    @BindView(R.id.tv_suozai)
    TextView tvsuozai;
    @BindView(R.id.tv_on)
    TextView tvon;
    private List<SynergicBean.TeamListLV1Bean> teamListLV1;
    private ArrayList<SynergicBean.TeamListLV1Bean> list;
    private SynergicAdapter synergicAdapter;


    @Override
    protected IBasePresenter getPresenter() {
        return new SynergicPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_synergic;
    }


    @OnClick({R.id.lin_wbeak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_wbeak:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
        recycSynergic.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        synergicAdapter = new SynergicAdapter(list);
        synergicAdapter.synitemClick = this;
        recycSynergic.setAdapter(synergicAdapter);
    }

    @Override
    protected void initData() {
        ((SynergicPersenter) mPresenter).synergics();
    }

    @Override
    public void synergicRean(SynergicBean synergicBean) {
        if (synergicBean != null) {

            int id = synergicBean.getInTeamVL1().getId();
            if (id == 0) {
                tvPlace.setVisibility(View.GONE);
                tvsuozai.setVisibility(View.VISIBLE);
                tvon.setVisibility(View.VISIBLE);
                recycSynergic.setVisibility(View.GONE);
                return;
            } else {
                tvsuozai.setVisibility(View.GONE);
                tvPlace.setVisibility(View.VISIBLE);
                recycSynergic.setVisibility(View.VISIBLE);
                tvon.setVisibility(View.GONE);
                SynergicBean.InTeamVL1Bean inTeamVL1 = synergicBean.getInTeamVL1();
                if (inTeamVL1 == null) {
                    tvPlace.setVisibility(View.GONE);
                    tvsuozai.setVisibility(View.VISIBLE);
                    return;
                }
                final String nick_name = synergicBean.getInTeamVL1().getNick_name();
                tvPlace.setText(nick_name);
                final int id1 = synergicBean.getInTeamVL1().getId();
                tvPlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(context, SynergicXingActivity.class);
                        intent.putExtra("e_id", id1);
                        intent.putExtra("nic_name", nick_name);
                        startActivity(intent);
                    }
                });
                if (synergicBean.getTeamListLV1().size() > 0) {

                    teamListLV1 = synergicBean.getTeamListLV1();
                    list.clear();
                    list.addAll(teamListLV1);
                    synergicAdapter.notifyDataSetChanged();


                } else {//无合作数据

                }
            }
        }
    }

    @Override
    public void synergicxingRean(SynergicBean synergicBean) {

    }


    @Override
    public void synergiclick(SynergicBean.TeamListLV1Bean listxing) { //回调
        if (listxing == null) {
            return;
        }
        int id = listxing.getId();
        String nick_name = listxing.getNick_name();
        Intent intent = new Intent();
        intent.setClass(context, SynergicXingActivity.class);
        intent.putExtra("e_id", id);
        intent.putExtra("nic_name", nick_name);
        startActivity(intent);

    }
}
