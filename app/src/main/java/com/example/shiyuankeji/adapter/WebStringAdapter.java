package com.example.shiyuankeji.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.utils.UIUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WebStringAdapter extends BaseAdapter {
    public  WebClickItem webClickItem;

    public WebStringAdapter(ArrayList<String> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_string;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        String im = (String) mDatas.get(positon);

        final ImageView imag = (ImageView) holder.getView(R.id.image_string);
        final LinearLayout lin = (LinearLayout) holder.getView(R.id.lin);

        //计算图片左右间距之和
        int padding = 4;
        int spacePx = (int) (UIUtil.dp2px(mContext, padding) * 2);
        //计算图片宽度
        int imageWidth = UIUtil.getScreenWidth(mContext) - spacePx;
        //计算宽高比，注意数字后面要加上f表示浮点型数字
        float scale = 9f / 16f;
        //根据图片宽度和比例计算图片高度
        int imageHeight = (int) (imageWidth / scale);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(imageWidth, imageHeight);
        //设置左右边距
        params.leftMargin = (int) UIUtil.dp2px(mContext, padding);
        params.rightMargin = (int) UIUtil.dp2px(mContext, padding);
        imag.setLayoutParams(params);
        imag.setImageResource(R.drawable.no_banner);
        //判断是否存在视频
        boolean indxler = im.contains(Constant.CONTAINS);
        boolean iframe = im.contains(Constant.IFRAME);
        if (indxler == true || iframe == true) {
            imag.setVisibility(View.GONE);
        } else {
            imag.setVisibility(View.VISIBLE);
            Picasso.with(mContext)
                    .load(im)
                    .placeholder(R.drawable.no_banner)
                    .error(R.drawable.no_banner)
                    .into(imag);
        }
        imag.setTag(mDatas.get(positon));
        imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = (String) v.getTag();
                if (tag != null) {

                    webClickItem.webclickitem(tag);
                }
            }
        });
    }
//        Glide.with(mContext).load(o1).into(imag);
//        RequestOptions options = new RequestOptions()
////                .centerCrop()
//                .placeholder(R.drawable.no_banner) //预加载图片
//                .error(R.drawable.no_banner) //加载失败图片
//                .priority(Priority.HIGH)//优先级
//                .diskCacheStrategy(DiskCacheStrategy.NONE); //缓存
//        Glide.with(mContext).load(o1).apply(options).into(imag);

    public interface WebClickItem {
        void webclickitem(String items);

    }
}
