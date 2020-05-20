package com.example.project.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;
import com.jwkj.libzxing.QRCodeManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyQRActivity extends BaseActivity {
    @BindView(R.id.im_view_qr)
    ImageView imViewQr;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.btn_na_back)
    LinearLayout btnNaBack;


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_myqr;
    }

    @Override
    protected void initView() {
        String qr_ = getIntent().getStringExtra("qr_");
        String user_names = getIntent().getStringExtra("user_names_");
        txtUserName.setText("用户名：" + user_names);
        myqr(qr_);


    }

    //生成不带头像的二维码
    private void myqr(String qr) {
        Bitmap bitmap = QRCodeManager.getInstance().createQRCode(qr, 400, 400);
        imViewQr.setImageBitmap(bitmap);
    }



    @OnClick(R.id.btn_na_back)
    public void onViewClicked() {
        finish();
    }
}
