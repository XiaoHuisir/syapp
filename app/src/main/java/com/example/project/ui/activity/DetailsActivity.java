package com.example.project.ui.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity {
    @BindView(R.id.lin_wbeak)
    LinearLayout linWbeak;
    @BindView(R.id.lin_WD)
    LinearLayout linWD;
    @BindView(R.id.tv_record)
    TextView tvRecord;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
        tvRecord.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tvRecord.getPaint().setAntiAlias(true);//抗锯齿
    }

    @OnClick({R.id.lin_wbeak, R.id.lin_WD, R.id.tv_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_wbeak:
                finish();
                break;
            case R.id.lin_WD:  //提现
                startActivity(new Intent(context, ShopWBActivity.class));
                finish();
                break;
            case R.id.tv_record: //提现记录
                startActivity(new Intent(context, RecordListActivity.class));
                finish();
                break;
        }
    }
}
