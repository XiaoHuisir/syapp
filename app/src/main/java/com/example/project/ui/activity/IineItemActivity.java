package com.example.project.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IineItemActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.lin_return)
    LinearLayout linreturn;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lineltem;
    }


    @OnClick({R.id.lin_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_return:
                finish();
                break;

        }
    }
}
