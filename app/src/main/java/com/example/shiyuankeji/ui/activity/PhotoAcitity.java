package com.example.shiyuankeji.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.example.shiyuankeji.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoAcitity extends Activity {
    @BindView(R.id.photoview)
    PhotoView photoview;
    @BindView(R.id.im_photo_beak)
    ImageView imPhotoBeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
    }

    private void initView() {
        String photo = getIntent().getStringExtra("photo");
        photoview.enable();
        photoview.setAdjustViewBounds(true);
        Glide.with(this).load(photo).into(photoview);
    }

    @OnClick(R.id.im_photo_beak)
    public void onViewClicked() {
        finish();
    }
}
