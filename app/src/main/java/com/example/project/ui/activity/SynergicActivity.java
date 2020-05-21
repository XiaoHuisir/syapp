package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.adapter.SynergicAdapter;
import com.example.project.base.BaseActivity;
import com.example.project.bean.SynergicBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.SynergiContract;
import com.example.project.presenter.SynergicPersenter;

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
    @BindView(R.id.on_shuju)
    ImageView onShuju;
    @BindView(R.id.tv_place)
    TextView tvPlace;
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
            int id = synergicBean.getInTeam().getId();
            if (id == 0 ) {
                onShuju.setVisibility(View.VISIBLE);
                scrollShow.setVisibility(View.GONE);
                return;
            } else {
                onShuju.setVisibility(View.GONE);
                scrollShow.setVisibility(View.VISIBLE);
                final String nick_name = synergicBean.getInTeam().getNick_name();
                tvPlace.setText(nick_name);
                final int id1 = synergicBean.getInTeam().getId();
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
