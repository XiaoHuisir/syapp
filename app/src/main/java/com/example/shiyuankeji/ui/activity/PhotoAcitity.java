package com.example.shiyuankeji.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.utils.GlideRoundTransform;
import com.example.shiyuankeji.utils.UIUtil;
import com.example.shiyuankeji.utils.ZoomImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoAcitity extends Activity {
    @BindView(R.id.photoview)
    ZoomImageView photoview;
//    @BindView(R.id.im_photo_beak)
//    ImageView imPhotoBeak;

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
//        photoview.setImageResource(R.drawable.no_banner);

//        Glide.with(this).load(photo).into(photoview);
//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.drawable.no_banner) //预加载图片
//                .error(R.drawable.no_banner) //加载失败图片
//                .priority(Priority.HIGH) //优先级
//                .diskCacheStrategy(DiskCacheStrategy.NONE) //缓存
//                .transform(new GlideRoundTransform(3)); //圆角
//        Glide.with(this).load(photo).apply(options).into(photoview);

        Picasso.with(this)
                .load(photo)
//                .placeholder(R.drawable.no_banner)
                .error(R.drawable.no_banner)
                .into(photoview);
    }

//    @OnClick(R.id.im_photo_beak)
//    public void onViewClicked() {
//        finish();
//    }
}
