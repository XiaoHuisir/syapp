package com.example.project.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.adapter.BusinessAdapter;
import com.example.project.base.BaseActivity;
import com.example.project.bean.SynergicBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.SynergiContract;
import com.example.project.presenter.SynergicPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BusinessActivity extends BaseActivity implements SynergiContract.View, BusinessAdapter.BusinesClick {
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
    private List<SynergicBean.TeamListLV2Bean> teamListLV2;
    private ArrayList<SynergicBean.TeamListLV2Bean> list;
    private BusinessAdapter businessAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new SynergicPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_business;
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
        businessAdapter = new BusinessAdapter(list);
        businessAdapter.busitemClick = this;
        recycSynergic.setAdapter(businessAdapter);

    }

    @Override
    protected void initData() {
        ((SynergicPersenter) mPresenter).synergics();
    }

    @Override
    public void synergicRean(SynergicBean synergicBean) {
        if (synergicBean != null) {
            int id = synergicBean.getInTeam().getId();
            if (id == 0) {
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
                if (synergicBean.getTeamListLV2().size() > 0) {

                    teamListLV2 = synergicBean.getTeamListLV2();
                    list.clear();
                    list.addAll(teamListLV2);
                    businessAdapter.notifyDataSetChanged();


                } else {//无合作数据

                }
            }

        }
    }

    @Override
    public void synergicxingRean(SynergicBean synergicBean) {

    }

    @Override
    public void busclick(SynergicBean.TeamListLV2Bean listxing) {
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
