package com.example.shiyuankeji.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.utils.GlideRoundTransform;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

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
    //    @BindView(R.id.btn_exchang)
//    Button btnExchang;
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
    private int stock;
    private Button btnExchang;

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

    }

    private void initshow() {
        Intent intent = getIntent();
//        freight = intent.getIntExtra("freight_", 0);//运费
        imgs = intent.getStringExtra("imgs");     //图片
        price = intent.getIntExtra("price", 0);//价格
        ids = intent.getIntExtra("idsas", 0);
        buynums = intent.getIntExtra("buynums", 0); //限购数量
        //库存数量
        stock = intent.getIntExtra("stock_", 0);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.no_banner) //预加载图片
                .error(R.drawable.no_banner) //加载失败图片
                .priority(Priority.HIGH) //优先级
                .diskCacheStrategy(DiskCacheStrategy.NONE) //缓存
                .transform(new GlideRoundTransform(3)); //圆角
        Glide.with(this).load(imgs).apply(options).into(imStyling);
        //初始化兑换数量 1
        tvShu.setText("兑换数量：" + String.valueOf(Constant.DYNAMIC_DIGITAL));
        textShuRAM.setText(String.valueOf(Constant.DYNAMIC_DIGITAL));
        textPrice.setText(price + "积分");//价格

        initFindViewById();

    }

    private void initFindViewById() {
        btnExchang = findViewById(R.id.btn_exchang);
        btnExchang.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent(ExchangeActivity.this, Submit0rdersActivity.class);
                intent.putExtra("type_id", ids);//id
                intent.putExtra("num", Constant.DYNAMIC_DIGITAL); // 交易数量
                startActivity(intent);
                Constant.DYNAMIC_DIGITAL=1;

                finish();
            }
        });

    }

    @OnClick({R.id.cancel, R.id.im_jian, R.id.im_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                Constant.DYNAMIC_DIGITAL=1;
                finish();
                break;
            case R.id.im_add: //++

                if (Constant.DYNAMIC_DIGITAL <= buynums -1 && Constant.DYNAMIC_DIGITAL < stock) {
                    Constant.DYNAMIC_DIGITAL++;
                    tvShu.setText("兑换数量：" + String.valueOf(Constant.DYNAMIC_DIGITAL));
                    textShuRAM.setText(String.valueOf(Constant.DYNAMIC_DIGITAL));

                } else {
                    Toast.makeText(this, "以是峰值", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.im_jian:  //--
                if (Constant.DYNAMIC_DIGITAL > 1) {
                    Constant.DYNAMIC_DIGITAL--;
                    tvShu.setText("兑换数量：" + Constant.DYNAMIC_DIGITAL);
                    textShuRAM.setText(String.valueOf(Constant.DYNAMIC_DIGITAL));


                } else {

                    Toast.makeText(this, "以是最低 峰值", Toast.LENGTH_SHORT).show();

                }
                break;

        }
    }
}
