package com.example.shiyuankeji.ui.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.InxtendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.InxtendContract;
import com.example.shiyuankeji.presenter.InxtendPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MyInxtendActivity extends BaseActivity implements InxtendContract.View {
    @BindView(R.id.lin_back)
    LinearLayout linBack;
    @BindView(R.id.re1)
    RelativeLayout re1;
    @BindView(R.id.tv_inxtend)
    TextView tvInxtend;
    @BindView(R.id.lin_btn_inxtend)
    LinearLayout linBtnInxtend;
    @BindView(R.id.lin_myindxtend)
    LinearLayout linMyIndxtend;
    @BindView(R.id.re_no_data)
    RelativeLayout reNoData;

    @Override
    protected IBasePresenter getPresenter() {
        return new InxtendPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_inxtend;
    }



    @OnClick({R.id.lin_back, R.id.lin_btn_inxtend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_back:
                finish();
                break;
            case R.id.lin_btn_inxtend:
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(tvInxtend.getText().toString());
                Toast.makeText(context,R.string.copy_string,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void inxtendRean(InxtendBean inxtendBean) {
        if (inxtendBean==null){
            return;
        }
        String invitation_code = inxtendBean.getInvitation_code();
        if (invitation_code==null){
            return;
        }
        if (invitation_code.equals("")){
            linMyIndxtend.setVisibility(View.GONE);
            reNoData.setVisibility(View.VISIBLE);
        }
        tvInxtend.setText(invitation_code);
    }

    @Override
    protected void initData() {
        ((InxtendPresenter)mPresenter).inxtends();
    }
}
