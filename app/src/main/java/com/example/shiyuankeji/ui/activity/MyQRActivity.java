package com.example.shiyuankeji.ui.activity;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.ScanCodeBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.ScancodeContract;
import com.example.shiyuankeji.presenter.ScancodePresenter;
import com.jwkj.libzxing.QRCodeManager;

import butterknife.BindView;
import butterknife.OnClick;

public class MyQRActivity extends BaseActivity implements ScancodeContract.View {
    @BindView(R.id.im_view_qr)
    ImageView imViewQr;
    @BindView(R.id.im_bug)
    ImageView imbug;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.btn_na_back)
    LinearLayout btnNaBack;


    @Override
    protected IBasePresenter getPresenter() {
        return new ScancodePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_myqr;
    }

    @Override
    protected void initView() {
//        String qr_ = getIntent().getStringExtra("qr_");
        String user_names = getIntent().getStringExtra("user_names_");
        txtUserName.setText("用户名：" + user_names);


    }


    @OnClick(R.id.btn_na_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void initData() {
        ((ScancodePresenter) mPresenter).scancodes();
    }

    @Override
    public void scancodeRean(ScanCodeBean scanCodeBean) {
        int status = scanCodeBean.getStatus();
        if (status == 200) {
            imbug.setVisibility(View.INVISIBLE);
            txtUserName.setVisibility(View.VISIBLE);
            imViewQr.setVisibility(View.VISIBLE);
            String data = scanCodeBean.getData();
            myqr(data);
        } else {
            imbug.setVisibility(View.VISIBLE);
            txtUserName.setVisibility(View.INVISIBLE);
            imViewQr.setVisibility(View.INVISIBLE);
            return;
        }
    }

    //生成不带头像的二维码
    private void myqr(String qr) {
        Bitmap bitmap = QRCodeManager.getInstance().createQRCode(qr, 400, 400);
        imViewQr.setImageBitmap(bitmap);
    }
}
