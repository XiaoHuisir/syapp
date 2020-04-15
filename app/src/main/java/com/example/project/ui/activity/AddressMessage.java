package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressMessage extends BaseActivity {
    @BindView(R.id.btn_hold_site)
    Button btnHoldSite;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addressmessage;
    }


    @OnClick({R.id.btn_hold_site})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_hold_site:
                Intent intent = new Intent(context, Submit0rdersActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
