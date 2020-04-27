package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.bean.AnddressBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.AddressContract;
import com.example.project.presenter.AddressPresenter;
import com.example.project.utils.Validator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//updateUser_AddressById    Flowable<AnddressBean> address(@Field("user_name") String user, @Field("name") String name, @Field("id") int id, @Field("is_default") int is_default, @Field("phone") int phone, @Field("address") String address);
public class AddressMessage extends BaseActivity implements AddressContract.View {
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
    private String name;
    private int id_dizhi;
    private int is_defaults;
    private String phone;
    private String add_ress;

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
                String getname = etName.getText().toString();
                String getphone = etCompany.getText().toString();
                String getaddress = etPost.getText().toString();
                if (TextUtils.isEmpty(getname) || TextUtils.isEmpty(getphone) || TextUtils.isEmpty(getaddress)) {
                    Toast.makeText(context, "请输入姓名和手机号、地址", Toast.LENGTH_SHORT).show();
                    if (!TextUtils.isEmpty(getname) && TextUtils.isEmpty(getphone)) {
                        Toast.makeText(context, "请输入手机号", Toast.LENGTH_SHORT).show();

                    }

                    if (TextUtils.isEmpty(getname) && !TextUtils.isEmpty(getphone)) {
                        Toast.makeText(context, "请输入姓名", Toast.LENGTH_SHORT).show();

                    }

                    return;
                }
                if (Validator.isChinese(getname) == false) {
                    Toast.makeText(context, "请输入正确的姓名格式", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Validator.isMobile(getphone) == false) {
                    Toast.makeText(context, "请输入正确的手机号格式", Toast.LENGTH_SHORT).show();
                    return;
                }
                ((AddressPresenter) mPresenter).addressRe("sf003", getname, id_dizhi, is_defaults, getphone, getaddress);
                Intent intent = new Intent(context, Submit0rdersActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.re_break:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {

//        intent.putExtra("add_ress",listSubmit.getAddress());
//        intent.putExtra("name",listSubmit.getName());
//        intent.putExtra("id_dizhi",listSubmit.getId());
//        intent.putExtra("phone",String.valueOf(listSubmit.getPhone()));
//         intent.putExtra("is_default",is_default); //判断是否设置成默认收货地址
        Intent intent = getIntent();
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
        startup();
    }

    private void startup() {
        etName.setText(name);
        etCompany.setText(phone);
        etPost.setText(add_ress);
    }

    @Override
    public void addressReaun(AnddressBean anddressBean) {
        Toast.makeText(context, "修改成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {

    }


}
