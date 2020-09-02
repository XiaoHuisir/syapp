package com.example.shiyuankeji.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.utils.UIUtil;
import com.example.shiyuankeji.utils.ZoomImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoAcitity extends Activity {
    @BindView(R.id.photoview)
    ZoomImageView photoview;
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
        if (photo==null)return;
//        photoview.enable();
//        photoview.setAdjustViewBounds(true);
//        Glide.with(this).load(photo).into(photoview);

        photoview.setImageResource(R.drawable.no_banner);
        Picasso.with(this)
                .load(photo)
                .placeholder(R.drawable.no_banner)
                .error(R.drawable.no_banner)
                .into(photoview);
    }

    @OnClick(R.id.im_photo_beak)
    public void onViewClicked() {
        finish();
    }
}
