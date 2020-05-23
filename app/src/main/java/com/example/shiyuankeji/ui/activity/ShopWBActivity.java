package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class ShopWBActivity extends BaseActivity {
    @BindView(R.id.lin_break)
    LinearLayout linBreak;
    @BindView(R.id.ed_import)
    EditText edImport;
    @BindView(R.id.btn_tixian_ok)
    Button btnTixianOk;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shopwb;
    }



    @OnClick({R.id.lin_break, R.id.btn_tixian_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_break:
                finish();
                break;
            case R.id.btn_tixian_ok:
                startActivity(new Intent(context, VerfiyActivity.class));
                finish();
                break;
        }
    }
}
