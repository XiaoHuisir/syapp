package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Submit0rdersActivity extends BaseActivity {

    @BindView(R.id.re_site_ok)
    RelativeLayout reSiteOk;
    @BindView(R.id.lin_one)
    RelativeLayout linOne;
    @BindView(R.id.btn_exchang_ok)
    Button btnExchangOk;


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_submitorder;
    }


    //TODO
    @OnClick({R.id.re_site_ok, R.id.btn_exchang_ok, R.id.lin_one})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re_site_ok: //有 地址管理
                Intent intent = new Intent(context, SelectAddressActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_exchang_ok: //有 提交订单
                Intent intent1 = new Intent(context, CompleteOrderActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.lin_one:
                finish();
                break;
        }
    }
}
