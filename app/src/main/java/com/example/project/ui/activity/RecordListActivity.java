package com.example.project.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordListActivity extends BaseActivity {
    @BindView(R.id.lin_wlist_break)
    LinearLayout linWlistBreak;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_record_list;
    }


    @OnClick(R.id.lin_wlist_break)
    public void onViewClicked() {
        finish();
    }
}
