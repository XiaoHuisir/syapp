package com.example.project.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.app.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExchangeActivity extends Activity {
    @BindView(R.id.cancel)
    View cancel;
    @BindView(R.id.im_add)
    ImageView imAdd;
    @BindView(R.id.im_jian)
    ImageView imMinus;
    @BindView(R.id.btn_exchang)
    Button btnExchang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        ButterKnife.bind(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.cancel, R.id.btn_exchang, R.id.im_jian, R.id.im_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                finish();
                break;
            case R.id.im_add:

                break;
            case R.id.im_jian:

                break;
            case R.id.btn_exchang:
                startActivity(new Intent(ExchangeActivity.this, Submit0rdersActivity.class));
                finish();
                break;
        }
    }
}
