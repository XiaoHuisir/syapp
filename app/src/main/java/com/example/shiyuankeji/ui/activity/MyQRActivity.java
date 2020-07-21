package com.example.shiyuankeji.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.ScanCodeBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.ScancodeContract;
import com.example.shiyuankeji.presenter.ScancodePresenter;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.utils.UtilsClicktime;
import com.jwkj.libzxing.QRCodeManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;
import q.rorbin.verticaltablayout.util.DisplayUtil;

public class MyQRActivity extends BaseActivity implements ScancodeContract.View {
    @BindView(R.id.im_view_qr)
    ImageView imViewQr;
    @BindView(R.id.im_bug)
    ImageView imbug;
    //    @BindView(R.id.txt_user_name)
//    TextView txtUserName;
    @BindView(R.id.btn_na_back)
    LinearLayout btnNaBack;
    @BindView(R.id.lin_poster)
    LinearLayout linPoster;
    @BindView(R.id.btn_na_back_no)
    LinearLayout btnNoBack;
    @BindView(R.id.re_ok)
    RelativeLayout reOk;
    @BindView(R.id.re_no_data)
    RelativeLayout reNoData;
    private Bitmap screenShot;
    private Uri uri;//照片uri
    private String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private File cameraSavePath;
    private String photoPath;
    private List<String> photolist = new ArrayList<>();
    @Override
    protected IBasePresenter getPresenter() {
        return new ScancodePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_myqr;
    }

    @Override
    protected void initView() {
//        String qr_ = getIntent().getStringExtra("qr_");
        String user_names = getIntent().getStringExtra("user_names_");
//        txtUserName.setText("用户名：" + user_names);

        if (EasyPermissions.hasPermissions(MyQRActivity.this, permissions)) {
            //已经打开权限
//            goPhotoAlbum();
        } else {
            //没有打开相关权限、申请权限
            EasyPermissions.requestPermissions(MyQRActivity.this, "需要获取您的相册、照相使用权限", 1, permissions);
        }

    }
    //激活相册操作
    private void goPhotoAlbum() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //框架要求必须这么写
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @OnClick({R.id.btn_na_back, R.id.lin_poster,R.id.btn_na_back_no})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_na_back:
                finish();
                break;
                case R.id.btn_na_back_no:
                finish();
                break;
                case R.id.lin_poster:
                    if (UtilsClicktime.isFastDoubleClick()){
                        return;
                    }
                    screenShot = getScreenShot();
                    imbug.setImageBitmap(screenShot);
                    saveScreenShot(screenShot);
//                    goPhotoAlbum(); //打开相机
                    break;
        }

    }
    private void saveScreenShot(Bitmap bitmap)  {
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        OutputStream outStream = null;
        String filename;//声明文件名
        //以保存时间为文件名
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyyMMddHHmmss");
        filename =  sdf.format(date);
        File file = new File(extStorageDirectory, filename+".JPEG");//创建文件，第一个参数为路径，第二个参数为文件名
        try {
            outStream = new FileOutputStream(file);//创建输入流
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.close();
//*       这三行可以实现相册更新
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);intent.setData(uri);
            sendBroadcast(intent);//这个广播的目的就是更新图库，发了这个广播进入相册就可以找到你保存的图片了！
            Toast.makeText(context,"海报生成成功，已保存到相册",Toast.LENGTH_SHORT).show();
//            ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "生成成功！");
//            toastUtil2.show();
        } catch(Exception e) {
//            Toast.makeText(this, "exception:" + e,
//                    Toast.LENGTH_SHORT).show();
//            ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "生成失败！");
//            toastUtil2.show();
            Toast.makeText(context,"生成失败！",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获取屏幕截图
     *
     * @return
     */
    public Bitmap getScreenShot() {
        // 获取windows中最顶层的view
        View view = getWindow().getDecorView();
        view.buildDrawingCache();

        // 获取状态栏高度
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int statusBarHeights = rect.top;
        Display display = getWindowManager().getDefaultDisplay();

        // 获取屏幕宽和高
        int widths = display.getWidth();
        int heights = display.getHeight();

        // 允许当前窗口保存缓存信息
        view.setDrawingCacheEnabled(true);

        // 去掉状态栏
        Bitmap bmp = Bitmap.createBitmap(view.getDrawingCache(), 0,
                statusBarHeights, widths, heights - statusBarHeights);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 10, bos);

        byte[] bytes = bos.toByteArray();
        bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        // 销毁缓存信息
        view.destroyDrawingCache();

        return bmp;
    }


        public static String savePhoto(Context c, Bitmap photoBitmap,
                                       String photoName) {
            String localPath = null;
            if (android.os.Environment.getExternalStorageState().equals(
                    android.os.Environment.MEDIA_MOUNTED)) {
                String fileString = "mnt/sdcard/weitehui/";
                File dirFile = new File(String.valueOf(Environment.getExternalStorageDirectory()));
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }

                File photoFile = new File(dirFile, photoName + ".png");
                if (!photoFile.exists()) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(photoFile);
                        if (photoBitmap != null) {
                            if (photoBitmap.compress(Bitmap.CompressFormat.PNG, 100,
                                    fileOutputStream)) { // 转换完成
                                localPath = photoFile.getPath();
                                fileOutputStream.flush();
                            }
                        }
                    } catch (FileNotFoundException e) {
                        photoFile.delete();
                        localPath = null;
                        e.printStackTrace();
                    } catch (IOException e) {
                        photoFile.delete();
                        localPath = null;
                        e.printStackTrace();
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                } else {
                    localPath = photoFile.getPath();
                }

            }
            if (localPath != null) {
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.fromFile(new File(localPath));
                intent.setData(uri);
                c.sendBroadcast(intent);//发送广播，是更新图库。
//                DisplayUtil.showLongToast(c, "成功保存图片到" + localPath);
            }

            return localPath;
        }


    @Override
    protected void initData() {
        ((ScancodePresenter) mPresenter).scancodes();
    }

    @Override
    public void scancodeRean(ScanCodeBean scanCodeBean) {
        int status = scanCodeBean.getStatus();
        if (status == 200) {
            reNoData.setVisibility(View.INVISIBLE);
//            txtUserName.setVisibility(View.VISIBLE);
            reOk.setVisibility(View.VISIBLE);
            String data = scanCodeBean.getData();
            myqr(data);
        } else {
            reNoData.setVisibility(View.VISIBLE);
//            txtUserName.setVisibility(View.INVISIBLE);
            reOk.setVisibility(View.INVISIBLE);
            return;
        }
    }

    //生成不带头像的二维码
    private void myqr(String qr) {
        Bitmap bitmap = QRCodeManager.getInstance().createQRCode(qr, 400, 400);
        imViewQr.setImageBitmap(bitmap);
    }
}
