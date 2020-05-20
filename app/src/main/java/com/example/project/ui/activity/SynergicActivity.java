package com.example.project.ui.activity;

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
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SynergicActivity extends BaseActivity implements SynergiContract.View {
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
            if (id == 0) {
                Toast.makeText(context, "id=0", Toast.LENGTH_SHORT).show();

                onShuju.setVisibility(View.VISIBLE);
                scrollShow.setVisibility(View.GONE);
            } else {
                Toast.makeText(context, "id", Toast.LENGTH_SHORT).show();
                onShuju.setVisibility(View.GONE);
                scrollShow.setVisibility(View.VISIBLE);
                String nick_name = synergicBean.getInTeam().getNick_name();
                tvPlace.setText(nick_name);

                if (synergicBean.getTeamListLV1().size() > 0) {
                    Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
                    teamListLV1 = synergicBean.getTeamListLV1();
                    list.clear();
                    list.addAll(teamListLV1);
                    synergicAdapter.notifyDataSetChanged();


                } else {//无合作数据
                    Toast.makeText(context, "0", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }


}
