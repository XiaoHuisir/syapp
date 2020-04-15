package com.example.project.ui.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;

import butterknife.BindView;
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
    @BindView(R.id.tv_old_price)
    TextView tvOldIntegral;
//   @BindView(R.id.tv_old_integral)
//    TextView imBeak;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_new;
    }

    @Override
    protected void initView() {
        tvOldIntegral.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线
    }

    @Override
    protected void initData() {


    }


    @OnClick({R.id.lin_home, R.id.lin_classfy, R.id.btn_exchang, R.id.im_beak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_home: //TODO 这里是跳转到 mainActivity的 HomeFragment(首页)
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("id", Constant.ONE_TYPE_1);
//
                startActivityForResult(intent, Constant.ONE_TYPE_1);
                finish();
                break;
            case R.id.lin_classfy://TODO 这里是跳转到 mainActivity的 ClassfyFragment（分类）
                Intent intent1 = new Intent(context, MainActivity.class);
                intent1.putExtra("id", Constant.TWO_TYPE_2);
                startActivityForResult(intent1, Constant.TWO_TYPE_2);
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
