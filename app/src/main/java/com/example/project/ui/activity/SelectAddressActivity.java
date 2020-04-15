package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectAddressActivity extends BaseActivity {
    @BindView(R.id.btn_exchang)
    Button btnExchang;
    @BindView(R.id.tv_add_site)
    TextView tvAddSite;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_selectaddress;
    }

    @OnClick({R.id.btn_exchang, R.id.tv_add_site})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_exchang:
                Intent intent1 = new Intent(context, Submit0rdersActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.tv_add_site:
                Intent intent = new Intent(context, AddressMessage.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
