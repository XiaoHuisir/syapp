package com.example.project.ui.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.bean.ProductDetailsBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.ProductDetailsContract;
import com.example.project.presenter.ProductDetailsPresenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

//toItemsDetail idsa
public class ProductDetailsActivity extends BaseActivity implements ProductDetailsContract.View {
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
    @BindView(R.id.im_head)
    ImageView imHead;
    @BindView(R.id.tv_telet)
    TextView tvTelet;
    @BindView(R.id.tv_price)
    TextView tvPrice;

    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.tv_stock)
    TextView tvStock;
    @BindView(R.id.im_xiang)
    ImageView imX;

    private String ids;
    private ArrayList<StringBuffer> ims;
    private String img;
    private int price;
    private int buynum;
    private int idsa;
    private int freight;
    //   @BindView(R.id.tv_old_integral)
//    TextView imBeak;

    @Override
    protected IBasePresenter getPresenter() {
        return new ProductDetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_new;
    }

    @Override
    protected void initView() {
        ids = getIntent().getStringExtra("idsa");
        tvOldIntegral.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线
    }

    @Override
    protected void initData() {
        ((ProductDetailsPresenter) mPresenter).productDetails(Integer.parseInt(ids));

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
                Intent intent2 = new Intent(context, ExchangeActivity.class);
                intent2.putExtra("price", price);
                intent2.putExtra("imgs", img);
                intent2.putExtra("buynums", buynum);
                intent2.putExtra("idsas",idsa);
//                intent2.putExtra("freight_",freight);
                startActivity(intent2);

                break;
            case R.id.im_beak:
                finish();
                break;
        }
    }


    @Override
    public void ProductDetailsReturn(ProductDetailsBean result) {
        if (result != null) {
            winings(result);
        } else {
            failedings();
        }
    }

    private void winings(ProductDetailsBean result) {
        Toast.makeText(context, "商品详情成功", Toast.LENGTH_SHORT).show();
        idsa = result.getIdsa();
        String name = result.getName();
        //价格
        price = result.getPrice();
        int src_price = result.getSrc_price(); //原价
        int stock = result.getStock();//库存
        //图
        img = result.getImg();
        //运费
        freight = result.getFreight();
        //限购数量
        buynum = result.getBuynum();

        Glide.with(context).load(img).into(imHead);
        tvTelet.setText(name);
        tvPrice.setText(String.valueOf(price));
        tvOldIntegral.setText(String.valueOf(src_price));
        tvFreight.setText("运费：" + String.valueOf(freight));
        tvStock.setText("库存：" + String.valueOf(stock));


        xiangqing(result); // TODO 详情 ？？？
    }

    private void xiangqing(ProductDetailsBean result) {

        String im = result.getImgs();

        StringBuffer sb = new StringBuffer();
//        以>对数据进行切割 返回一个字符串数组
        String[] split = im.split(",");

        for (int i = 0; i < split.length; i++) {
//            用<img src=“http:  来替换<img src=”
//            这里的\是为了保留当前的“
            String replace = split[i].replace("<img src=\"", "<img src=\"https:");
            //拼接
            sb.append(replace + " ");

        }
        //转成字符串
        String s = sb.toString();
        ArrayList<String> listimage = new ArrayList<>();
        listimage.add(s);

    }

    private void failedings() {
        Toast.makeText(context, "商品详情请求失败", Toast.LENGTH_SHORT).show();
    }
}
