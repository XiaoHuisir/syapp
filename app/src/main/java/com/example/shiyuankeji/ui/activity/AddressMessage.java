package com.example.shiyuankeji.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.AddRBean;
import com.example.shiyuankeji.bean.AnddressBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.AddressContract;
import com.example.shiyuankeji.presenter.AddressPresenter;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.Validator;
import com.lljjcoder.style.citypickerview.CityPickerView;

import butterknife.BindView;
import butterknife.OnClick;

/*
 *
 * */
//updateUser_AddressById    Flowable<AnddressBean> address(@Field("user_name") String user, @Field("name") String name, @Field("id") int id, @Field("is_default") int is_default, @Field("phone") int phone, @Field("address") String address);
public class AddressMessage extends BaseActivity implements AddressContract.View {//, View.OnClickListener
    @BindView(R.id.btn_hold_site)
    Button btnHoldSite;
    @BindView(R.id.re_break)
    RelativeLayout reBreak;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_company)
    EditText etCompany;
    @BindView(R.id.et_post)
    EditText etPost;
    @BindView(R.id.tv_tilet)
    TextView tvTilet;
    @BindView(R.id.ed_street)
    EditText edStreet;
    @BindView(R.id.lin_ed_street)
    LinearLayout linEdStreet;


    private String name;
    private int id_dizhi;
    private int is_defaults;
    private boolean is_appid = false;
    private boolean is_upid = false;
    private String phone;
    private String add_ress;
    private String bian_ji;
    private Intent intent;
    private String add_s;
    private CityPickerView mPicker = new CityPickerView(); //三级联动
    private InputMethodManager imm;
    private int id_s;
    private int nu_m;
    private boolean inxdlers = false;
    private int addid;
    private int upid;
    private String getname = "";
    private String getphone = "";
    private String edstreets = "";
    private String getaddress = "";


    @Override
    protected IBasePresenter getPresenter() {
        return new AddressPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_addressmessage;
    }


    @OnClick({R.id.btn_hold_site, R.id.re_break})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_hold_site:  //保存修改后的地址
                getname = etName.getText().toString();
                getphone = etCompany.getText().toString();
                //详细地址
                edstreets = edStreet.getText().toString();
                //地址
                getaddress = etPost.getText().toString();

                if (Constant.IS_MINE_IS.equals("2")) {
                    if (Constant.CURTYPE.equals("编辑")) {
                        tvTilet.setText(R.string.addre_up_site_string);
//                        Toast.makeText(context, "编辑001124545", Toast.LENGTH_SHORT).show();
                        biajineirong(getname, getphone, getaddress, edstreets);
                    } else if (Constant.CURTYPE.equals("添加")) {
                        tvTilet.setText(R.string.addre_add_site_string);
//                        Toast.makeText(context, "添加收货地址0000000", Toast.LENGTH_SHORT).show();
                        biajineirong(getname, getphone, getaddress, edstreets);
                    }
                } else {


                    if (Constant.CURTYPE.equals("编辑")) {
                        tvTilet.setText(R.string.addre_up_site_string);
//                        Toast.makeText(context, "编辑001124545", Toast.LENGTH_SHORT).show();
                        biajineirong(getname, getphone, getaddress, edstreets);
                    } else if (Constant.CURTYPE.equals("添加")) {
                        tvTilet.setText(R.string.addre_add_site_string);
//                        Toast.makeText(context, "添加收货地址0000000", Toast.LENGTH_SHORT).show();
                        biajineirong(getname, getphone, getaddress, edstreets);
                    }

                }
                break;
            case R.id.re_break:
                finish();
                break;
        }
    }

    private void biajineirong(final String getname, final String getphone, final String getaddress, String edstreets) {
        if (TextUtils.isEmpty(getname) || TextUtils.isEmpty(getphone) || TextUtils.isEmpty(getaddress)) {
            Toast.makeText(context, R.string.addre_pho_site_string, Toast.LENGTH_SHORT).show();
            if (!TextUtils.isEmpty(getname) && TextUtils.isEmpty(getphone)) {
                Toast.makeText(context, R.string.regoster_pho_string, Toast.LENGTH_SHORT).show();

            }

            if (TextUtils.isEmpty(getname) && !TextUtils.isEmpty(getphone)) {
                Toast.makeText(context, R.string.addre_name_string, Toast.LENGTH_SHORT).show();

            }

            return;
        }
        if (Validator.isChinese(getname) == false) {
            Toast.makeText(context, R.string.addre_name_format_string, Toast.LENGTH_SHORT).show();
            return;
        }
        if (Validator.newisMobile(getphone) == false) {
            Toast.makeText(context, R.string.addre_pho_format_string, Toast.LENGTH_SHORT).show();
            return;
        }
        LayoutInflater inflater = getLayoutInflater();
        //引入自定义好的对话框.xml布局
        View layout = inflater.inflate(R.layout.is_default_layout, null);
        //实列提示对话框对象，并将加载的试图对象设置给对话框对象
        final AlertDialog alertDialog = new AlertDialog.Builder(AddressMessage.this).setTitle(" ").setView(layout).show();
        final RelativeLayout yes = layout.findViewById(R.id.relative_update);
        final RelativeLayout no = layout.findViewById(R.id.relative_cancel);
        if (Constant.IS_MINE_IS.equals("2")) {  //我的模块打开
            if (Constant.CURTYPE.equals("编辑")) {
                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addressRe(getname, id_dizhi, Constant.STUDY_TYPE_2, getphone, getaddress);//+ " " + edstreets
                        is_appid = true;
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addressRe(getname, id_dizhi, Constant.STUDY_TYPE_1, getphone, getaddress);//+ " " + edstreets
                        is_appid = false;
                    }
                });

            } else if (Constant.CURTYPE.equals("添加")) {

                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addR(getname, Constant.STUDY_TYPE_2, getphone, getaddress);//+ " " + edstreets
                        is_upid = true;

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addR(getname, Constant.STUDY_TYPE_1, getphone, getaddress);//+ " " + edstreets
                        is_upid = false;

                    }
                });
            }
        } else {  //地址管理模块打开

            if (Constant.CURTYPE.equals("编辑")) {
                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addressRe(getname, id_dizhi, Constant.STUDY_TYPE_2, getphone, getaddress);//+ " " + edstreets
                        is_appid = true;
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addressRe(getname, id_dizhi, Constant.STUDY_TYPE_1, getphone, getaddress);//+ " " + edstreets
                        is_appid = false;

                    }
                });

            } else if (Constant.CURTYPE.equals("添加")) {

                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addR(getname, Constant.STUDY_TYPE_2, getphone, getaddress);//+ " " + edstreets
                        is_upid = true;
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        ((AddressPresenter) mPresenter).addR(getname, Constant.STUDY_TYPE_1, getphone, getaddress);//+ " " + edstreets
                        is_upid = false;

                    }
                });
            }
        }

    }

    @Override
    protected void initView() {
        id_s = getIntent().getIntExtra("id_s", 0);
        nu_m = getIntent().getIntExtra("nu_m", 0);
//        inxdlers = getIntent().getBooleanExtra("is_mine_is", true);
//        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);//软键盘
        if (Constant.CURTYPE.equals("编辑")) {
            tvTilet.setText(R.string.addre_up_site_string);

        } else if (Constant.CURTYPE.equals("添加")) {
            tvTilet.setText(R.string.addre_add_site_string);

        }
        intent = getIntent();
        //用户姓名
        name = intent.getStringExtra("names");
        //用户手机号
        phone = intent.getStringExtra("phone");
        //用户地址
        add_ress = intent.getStringExtra("add_ress");
        //id
        id_dizhi = intent.getIntExtra("id_dizhi", 0);
        //判断是否设置成默认收货地址
        is_defaults = intent.getIntExtra("is_defaults", 0);
        //初始化信息
        startup(); //编辑地址时初始化信息


    }

//    //点击空白关闭软键盘
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            if (AddressMessage.this.getCurrentFocus() != null) {
//                if (AddressMessage.this.getCurrentFocus().getWindowToken() != null) {
//                    imm.hideSoftInputFromWindow(AddressMessage.this.getCurrentFocus().getWindowToken(),
//                            InputMethodManager.HIDE_NOT_ALWAYS);
//
//                }
//            }
//        }
//        return super.onTouchEvent(event);
//    }


    private void startup() {
        //        intent.putExtra("add_ress",listSubmit.getAddress());
//        intent.putExtra("name",listSubmit.getName());
//        intent.putExtra("id_dizhi",listSubmit.getId());
//        intent.putExtra("phone",String.valueOf(listSubmit.getPhone()));
//         intent.putExtra("is_default",is_default); //判断是否设置成默认收货地址
        //selectAddressActivity
        etName.setText(name);
        etCompany.setText(phone);
        etPost.setText(add_ress);
//        pickers();  //三级联动地址管理
    }

    private void pickers() {
//        mPicker.init(context); //必须！  初始化城市数据
//        etPost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imm.hideSoftInputFromWindow(AddressMessage.this.getCurrentFocus().getWindowToken(),
//                        InputMethodManager.HIDE_NOT_ALWAYS);
//                if (v == etPost) {  //地区联动选择
//                    //添加默认的配置，可以自己修改
//                    CityConfig cityConfig = new CityConfig.Builder()
//                            .province("河北") //设置默认显示省份
//                            .build();
//                    mPicker.setConfig(cityConfig);
//                    //监听选择点击事件及返回结果
//                    mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
//                        @Override
//                        public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
//                            //省份
//                            if (province != null && city != null && district != null) {
//                                etPost.setText(province.toString() + "  " + city.toString() + "  " + district.toString());
//                            }
//                        }
//
//                        @Override
//                        public void onCancel() {
//                            ToastUtils.showLongToast(context, "已取消");
//                        }
//                    });
//                    //显示
//                    mPicker.showCityPicker();
//                    linEdStreet.setVisibility(View.VISIBLE);//显示详细地址输入框
//                }
//
//
//            }
//        });
    }

    @Override
    public void addressReaun(AnddressBean anddressBean) {
        if (Constant.IS_MINE == true) { //等于 true 为 我的模块 打开
            Intent intent = new Intent(context, SelectAddressActivity.class);
            if (is_appid == true) {
                intent.putExtra("type_id", id_s);
                intent.putExtra("num", nu_m);
//                        intent.putExtra("onid",String.valueOf(upid));
            }
            if (is_appid == false) {
                intent.putExtra("get_name", getname);
                intent.putExtra("get_phone", getphone);
                intent.putExtra("get_address", getaddress);
                intent.putExtra("type_0", false);
                intent.putExtra("type_id", id_s);
//                        intent1.putExtra("onid",String.valueOf(upid));
                intent.putExtra("num", nu_m);

            }
            startActivity(intent);
            finish();
        } else {
            SharedPreferencesUtil.setDeliveryAddress(context, true); //保存有、无 地址状态
            upid = anddressBean.getId();
            Toast.makeText(context, R.string.addre_up_ok_string, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, Submit0rdersActivity.class);
            if (is_appid == true) {
                intent.putExtra("type_id", id_s);
                intent.putExtra("num", nu_m);
                intent.putExtra("onid", String.valueOf(upid));
            }
            if (is_appid == false) {

                intent.putExtra("get_name", getname);
                intent.putExtra("get_phone", getphone);
                intent.putExtra("get_address", getaddress);
                intent.putExtra("type_0", false);
                intent.putExtra("type_id", id_s);
                intent.putExtra("onid", String.valueOf(upid));
                intent.putExtra("num", nu_m);
//            startActivity(intent1);
//            finish();
            }
            startActivity(intent);
            finish();
        }
    }


    @Override
    public void addReaun(AddRBean addRBean) {
        if (Constant.IS_MINE == true) {
            Intent intent = new Intent(context, SelectAddressActivity.class);
            if (is_upid == true) {
                intent.putExtra("type_id", id_s);
                intent.putExtra("num", nu_m);
//                        intent.putExtra("onid",String.valueOf(addid));

            }
            if (is_upid == false) {

                intent.putExtra("get_name", getname);
                intent.putExtra("get_phone", getphone);
                intent.putExtra("get_address", getaddress);
                intent.putExtra("type_0", false);
                intent.putExtra("type_id", id_s);
//                        intent1.putExtra("onid",String.valueOf(addid));
                intent.putExtra("num", nu_m);

            }
            startActivity(intent);
            finish();
        } else {
            SharedPreferencesUtil.setDeliveryAddress(context, true); //保存有、无 地址状态
            addid = addRBean.getId();
            Intent intent = new Intent(context, Submit0rdersActivity.class);
            if (is_upid == true) {
                intent.putExtra("type_id", id_s);
                intent.putExtra("num", nu_m);
                intent.putExtra("onid", String.valueOf(addid));

            }
            if (is_upid == false) {
                intent.putExtra("get_name", getname);
                intent.putExtra("get_phone", getphone);
                intent.putExtra("get_address", getaddress);
                intent.putExtra("type_0", false);
                intent.putExtra("type_id", id_s);
                intent.putExtra("onid", String.valueOf(addid));
                intent.putExtra("num", nu_m);

            }
            startActivity(intent);
            finish();
        }

        Toast.makeText(context, R.string.addre_add_ok_string, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void initData() {

    }


}
