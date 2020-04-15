package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompleteOrderActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_view_details)
    Button btnViewDetails;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_completeorder;
    }

    @Override
    protected void initView() {
        btnViewDetails.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(context, IineItemActivity.class));
        finish();

}
}
