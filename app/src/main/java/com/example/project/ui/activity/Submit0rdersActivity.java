package com.example.project.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.bean.AddOrderistBean;
import com.example.project.bean.SubmitBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.SubmitContract;
import com.example.project.presenter.AddressPresenter;
import com.example.project.presenter.SubmitPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

//http://192.168.124.13:8080/toConfirmOrderList?user_name=sf003&idsa=2011
public class Submit0rdersActivity extends BaseActivity implements SubmitContract.View {


    @BindView(R.id.re_on)
    RelativeLayout reOn;
    @BindView(R.id.re_site_ok)
    RelativeLayout reSiteOk;
    @BindView(R.id.relative_on_)
    RelativeLayout relativeOn_;
    @BindView(R.id.btn_exchangOn)
    Button btnExchangOn;
    @BindView(R.id.im_1)
    ImageView im_;
    @BindView(R.id.tv_iphone_name)
    TextView tvIphoneName;
    @BindView(R.id.text_jifen)
    TextView textJifen;
    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.tv_num)
    TextView tvNum;
    //    @BindView(R.id.tv_order_num)
//    TextView tvOrderNum;
    @BindView(R.id.text_zhong)
    TextView textZong;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.text_dahao)
    TextView textDahao;
    @BindView(R.id.text_dizhi)
    TextView textDizhi;
    @BindView(R.id.tv_jifenOn)
    TextView tvJifenOn;
    private int typeid;
    private int add_price;
    private int num;
    private boolean indxler = true;
    private String get_name;
    private String get_phone;
    private String get_address;

    private String getname;
    private String getphone;
    private String getaddress;

    private int type = 0;
    private String img;
    private int idsas;
    private int src_price;
    private int freight;

    @Override
    protected IBasePresenter getPresenter() {
        return new SubmitPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_submitorder;
    }


    //TODO
    @OnClick({R.id.re_site_ok, R.id.btn_exchangOn, R.id.relative_on_, R.id.re_on})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re_site_ok: //有 地址管理
                Intent intent = new Intent();
                intent.setClass(context, SelectAddressActivity.class);
                intent.putExtra("typeid_", typeid);
                intent.putExtra("num_", num);
                Constant.IS_MINE=false;
                Constant.IS_MINE_IS="1";
                startActivity(intent);
                finish();
                break;
            case R.id.re_on: //无 地址管理
                Intent intent1 = new Intent();
                intent1.setClass(context, SelectAddressActivity.class);
                intent1.putExtra("typeid_", typeid);
                intent1.putExtra("num_", num);
                Constant.IS_MINE=false;
                Constant.IS_MINE_IS="1";
                startActivity(intent1);
                finish();
                break;
            case R.id.btn_exchangOn: //有 立即兑换 提交订单
//                String tvnum = tvNum.getText().toString(); //数量
                String tvname = txtName.getText().toString();//用户姓名
                String tvDahao = textDahao.getText().toString();//用户电话
                String tvDizhi = textDizhi.getText().toString();//用户地址
                String tviphoneName = tvIphoneName.getText().toString();//商品名称
//                String tvJifen = textJifen.getText().toString();//商品价格
//                String tvfreight = tvFreight.getText().toString();//运费
                String tvZong = textZong.getText().toString();//总价格
                HashMap<String, String> maps = new HashMap<>();
//                maps.put("name", "sf003");
                maps.put("num", String.valueOf(Constant.NUM));//num
                maps.put("user_name", tvname);
                maps.put("user_phone", tvDahao);
                maps.put("user_add", tvDizhi);
//                maps.put("user_id", String.valueOf(15));//用户id
                maps.put("item_img", Constant.IMG);//img
                maps.put("item_name", Constant.NAME);//tviphoneName
                maps.put("item_price", String.valueOf(Constant.SRC_PRICE));//src_price
                maps.put("item_freight", String.valueOf(freight));
                maps.put("order_price", String.valueOf(Constant.ZONG_JIA));//tvZong
                maps.put("idsa", String.valueOf(Constant.IDSAS)); //商品编号idsas
                ((SubmitPresenter) mPresenter).addOrders(maps);


                break;
            case R.id.relative_on_:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
//        type_id

        typeid = getIntent().getIntExtra("type_id", 0);
//        add_price = getIntent().getIntExtra("add_price", 0);//交易价格
        num = getIntent().getIntExtra("num", 0);//交易数量
        Constant.NUM = num;

//        Intent intent = getIntent();
        boolean type_0 = getIntent().getBooleanExtra("type_0", true);
        get_name = getIntent().getStringExtra("get_name");
        get_phone = getIntent().getStringExtra("get_phone");
        get_address = getIntent().getStringExtra("get_address");
        indxler = type_0;


        getname = getIntent().getStringExtra("getname");
        getphone = getIntent().getStringExtra("getphone");
        getaddress = getIntent().getStringExtra("getaddress");
        int indx_0 = getIntent().getIntExtra("indx_0", 0);
        type = indx_0;
    }

    @Override
    protected void initData() {//typeid
        ((SubmitPresenter) mPresenter).submit(typeid);
    }


    @Override
    public void submitRetrun(SubmitBean submitBean) {


        Integer is_id = submitBean.getUser_address().getId();
        if (is_id != Constant.IS_ID) {
            reOn.setVisibility(View.GONE);
            Toast.makeText(context, "有地址", Toast.LENGTH_SHORT).show();
        } else {
            reSiteOk.setVisibility(View.GONE);
            Toast.makeText(context, "无地址", Toast.LENGTH_SHORT).show();
        }
//        items
        SubmitBean.ItemsBean items = submitBean.getItems();
        if (items != null) {
            String namess = items.getName(); //产品名称
            //运费
            freight = items.getFreight();
            img = items.getImg(); //图
            //产品价格
            src_price = items.getPrice();
            idsas = items.getIdsa(); //商品编号

            Constant.IMG = img; //图
            Constant.NAME = namess; //产品名
            Constant.FREIGHT = freight;
            Constant.SRC_PRICE = src_price;//产品价格
            Constant.IDSAS = idsas; //商品编号
            Constant.ZONG_JIA = src_price * num + freight; //总价
            Glide.with(context).load(Constant.IMG).into(im_); //img
            tvIphoneName.setText(Constant.NAME);//namess
            textJifen.setText(Constant.SRC_PRICE + "积分");//src_price
            tvFreight.setText(Constant.FREIGHT + "积分");//freight
            tvNum.setText("X" + Constant.NUM);//num
            //add_price
            textZong.setText(Constant.ZONG_JIA + "");//总价钱(src_price * num + freight)
            tvJifenOn.setText(Constant.ZONG_JIA + "积分");//(src_price * num + freight)

        }
        SubmitBean.UserAddressBean user_address = submitBean.getUser_address();
        if (user_address != null) {
            String name = user_address.getName();//用户姓名
            String phone = user_address.getPhone();//手机号
            String user_name = user_address.getUser_name();//用户账号
            String address = user_address.getAddress();//用户地址
//            tvOrderNum.setText("订单号 "+phone);
            if (indxler == true) {
                txtName.setText(name);
                textDahao.setText(phone);
                textDizhi.setText(address);
            } else {
                txtName.setText(get_name);
                textDahao.setText(get_phone);
                textDizhi.setText(get_address);
            }
            if (type == 100) {
                txtName.setText(getname);
                textDahao.setText(getphone);
                textDizhi.setText(getaddress);
            }


        }
    }

    @Override
    public void addOrderRean(AddOrderistBean addOrderistBean) {
        if (addOrderistBean != null) {
            int order_state = addOrderistBean.getOrder_state();
            if (order_state == Constant.ORDER_STATE_0) {
                Toast.makeText(context, "提交订单成功", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent();
                intent2.setClass(context, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putExtra("id", Constant.TWO_TYPE_3);
                startActivityForResult(intent2, Constant.TWO_TYPE_3);
                finish();
            } else if (order_state == Constant.ORDER_STATE_4) {
                LayoutInflater inflater = getLayoutInflater();
                //引入自定义好的对话框.xml布局
                View layout = inflater.inflate(R.layout.is_submit_layout, null);
                //实列提示对话框对象，并将加载的试图对象设置给对话框对象
                final AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(" ").setView(layout).show();
                final RelativeLayout yes = layout.findViewById(R.id.relative_update);
                final RelativeLayout no = layout.findViewById(R.id.relative_cancel);
                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        Toast.makeText(context, "还未实现，敬请期待！", Toast.LENGTH_SHORT).show();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();

                    }
                });
            }
        }
    }
}
