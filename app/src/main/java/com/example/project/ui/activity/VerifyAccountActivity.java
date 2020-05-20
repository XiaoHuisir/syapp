package com.example.project.ui.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.bean.QueryTabBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.QueryTabContract;
import com.example.project.presenter.QueryTabPresenter;
import com.example.project.ui.activity.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VerifyAccountActivity extends BaseActivity implements QueryTabContract.View {
    @BindView(R.id.ed_username)
    EditText edUsername;
    @BindView(R.id.ed_pho)
    EditText edPho;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.linear_validation)
    LinearLayout linearValidation;
    @BindView(R.id.tv_service)
    TextView tvService;

    @Override
    protected IBasePresenter getPresenter() {
        return new QueryTabPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_verify_account;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.linear_validation, R.id.tv_service})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.linear_validation:  //校验
                String username = edUsername.getText().toString();
                String pho = edPho.getText().toString();
                String name = edName.getText().toString();
                ((QueryTabPresenter) mPresenter).quertytab(username, pho, name);
                break;
            case R.id.tv_service:  //客服
                intent.setClass(context, WebCallCenterActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void querytabRean(QueryTabBean queryTabBean) {
        if (queryTabBean != null) {
            int status = queryTabBean.getStatus();
            if (status == 200) { //匹配成功 去修改密码
                Intent intent = new Intent();
                Constant.DYNAMIC_PRICE = 0;
                intent.setClass(context, UpdatePasswrdActivity.class);
                startActivity(intent);
            } else { //匹配不成功找客服(匹配不成功1次提示找客服 此处记录状态 未实现。。。。)
                new AlertDialog.Builder(this).setTitle("账号验证失败！请重新填写，或找客服")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setClass(context, WebCallCenterActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
            }
        }
    }
}
