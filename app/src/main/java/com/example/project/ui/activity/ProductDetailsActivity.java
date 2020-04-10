package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailsActivity extends BaseActivity {
    @BindView(R.id.lin_home)
    LinearLayout linHome;
    @BindView(R.id.lin_classfy)
    LinearLayout linClassfy;
    @BindView(R.id.btn_exchang)
    Button btnExchang;
    @BindView(R.id.im_beak)
    ImageView imBeak;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_details;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.lin_home, R.id.lin_classfy, R.id.btn_exchang,R.id.im_beak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_home:
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("id", Constant.ONE_TYPE_1);
//                startActivity(intent);
                startActivityForResult(intent, Constant.ONE_TYPE_1);
                finish();
                break;
            case R.id.lin_classfy:
                Intent intent1 = new Intent(context, MainActivity.class);
                intent1.putExtra("id", Constant.TWO_TYPE_2);
                startActivityForResult(intent1, Constant.TWO_TYPE_2);
//                startActivity(intent1);
                finish();
                break;
            case R.id.btn_exchang:
                startActivity(new Intent(context, ExchangeActivity.class));

                break;
            case R.id.im_beak:
                finish();
                break;
        }
    }



}
