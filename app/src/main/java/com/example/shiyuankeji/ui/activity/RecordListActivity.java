package com.example.shiyuankeji.ui.activity;

import android.widget.LinearLayout;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.interfaces.IBasePresenter;

import butterknife.BindView;
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
