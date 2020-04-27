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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.app.Constant;

import org.w3c.dom.Text;

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
    @BindView(R.id.textv_price)
    TextView textPrice;
    @BindView(R.id.im_styling)
    ImageView imStyling;
    @BindView(R.id.tv_shu)
    TextView tvShu;
    @BindView(R.id.text_shu_RAM)
    TextView textShuRAM;
    private int buynums;
    private int ids;
    private int price;
    private boolean addindxler = true;
    private boolean jianindxler = true;
    private int addprice = 0;
    private int jianprice = 0;
    private int freight;
    private String im_g;
    private String imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        ButterKnife.bind(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
    }

    private void initView() {
//        intent2.putExtra("price", price);
//        intent2.putExtra("imgs", img);
        initshow();
        //初始化兑换数量 1
        tvShu.setText("兑换数量：" + String.valueOf(Constant.DYNAMIC_DIGITAL));
        textShuRAM.setText(String.valueOf(Constant.DYNAMIC_DIGITAL));
        textPrice.setText(Constant.DYNAMIC_PRICE + "积分");
    }

    private void initshow() {
        Intent intent = getIntent();
//        freight = intent.getIntExtra("freight_", 0);//运费
        imgs = intent.getStringExtra("imgs");     //图片
        price = intent.getIntExtra("price", 0);
        Constant.DYNAMIC_PRICE = price * Constant.DYNAMIC_DIGITAL;
        ids = intent.getIntExtra("idsas", 0);
        buynums = intent.getIntExtra("buynums", 0); //限购数量

        Glide.with(this).load(imgs).into(imStyling);

    }

    @OnClick({R.id.cancel, R.id.btn_exchang, R.id.im_jian, R.id.im_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel:

                finish();
                break;
            case R.id.im_add: //++
                Constant.DYNAMIC_DIGITAL++;
                if (Constant.DYNAMIC_DIGITAL < buynums + 1) {
                    tvShu.setText("兑换数量：" + String.valueOf(Constant.DYNAMIC_DIGITAL));
                    textShuRAM.setText(String.valueOf(Constant.DYNAMIC_DIGITAL));
//                    Constant.DYNAMIC_PRICE=price+price;
                    textPrice.setText(String.valueOf(Constant.DYNAMIC_PRICE * Constant.DYNAMIC_DIGITAL) + "积分");
                    addprice += Constant.DYNAMIC_PRICE * Constant.DYNAMIC_DIGITAL;
                } else {
                    Toast.makeText(this, "以是峰值", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.im_jian:  //--
                Constant.DYNAMIC_DIGITAL--;
                if (Constant.DYNAMIC_DIGITAL > 0) {
//                Constant.DYNAMIC_PRICE=price-price;
                    tvShu.setText("兑换数量：" + String.valueOf(Constant.DYNAMIC_DIGITAL));
                    textShuRAM.setText(String.valueOf(Constant.DYNAMIC_DIGITAL));
//Constant.DYNAMIC_DIGITAL
                    jianprice = addprice - price;
                    textPrice.setText(String.valueOf(jianprice) + "积分");

                } else {
                    Constant.DYNAMIC_DIGITAL = 1;
//                    Constant.DYNAMIC_PRICE=price;
                    textPrice.setText(String.valueOf(Constant.DYNAMIC_PRICE) + "积分");
                    Toast.makeText(this, "以是最低 峰值", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.btn_exchang:
                Intent intent = new Intent(ExchangeActivity.this, Submit0rdersActivity.class);
                intent.putExtra("type_id", ids);//id
                intent.putExtra("add_price", addprice);//交易价格
                intent.putExtra("num", Constant.DYNAMIC_DIGITAL); // 交易数量
                startActivity(intent);
                finish();
                break;
        }
    }
}
