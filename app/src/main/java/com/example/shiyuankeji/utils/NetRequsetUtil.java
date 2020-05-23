package com.example.shiyuankeji.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


import com.example.shiyuankeji.app.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class NetRequsetUtil {
    public OkHttpClient okHttpClient;

    public static NetRequsetUtil instance;



    private NetRequsetUtil() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());//创建拦截对象
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addNetworkInterceptor(logInterceptor)
                .build();
    }

    public static NetRequsetUtil getInstance() {
        if (instance == null) {
            synchronized (NetRequsetUtil.class) {
                if (instance == null) {
                    instance = new NetRequsetUtil();
                }
            }
        }
        return instance;
    }

    public class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Log.d("HttpLogInfo", message);//okHttp的详细日志会打印出来
        }
    }

    //传json参数的post请求
    public void netRequestPostJson(final String url, final String parma, final NetDownResponse netDownResponse) {

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case 101:
                        netDownResponse.erro();
                        break;
                    case 102:
                        int responeCode = msg.arg1;
                        netDownResponse.finish();
                        if (responeCode == 200) {
                            netDownResponse.success((String) msg.obj);
                        } else {
                            netDownResponse.errowithresponse((String) msg.obj);
                        }
                        break;
                }
                return false;
            }
        });


        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, parma);
        Request request = new Request.Builder().url(Constant.BaseUrl + url)
                .addHeader("x-access-token", Constant.token).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HttpLogInfo", "e:" + e);
                handler.sendEmptyMessage(101);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = Message.obtain();
                msg.what = 102;
                //传递应答信息
                msg.obj = response.body().string();
                msg.arg1 = response.code();
                handler.sendMessage(msg);
            }
        });


    }

    //不传递参数时候的get请求
    public void netRequestGet(final String url, final NetDownResponse netDownResponse) {
        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case 101:
                        netDownResponse.erro();
                        break;
                    case 102:
                        netDownResponse.finish();
                        int responeCode = msg.arg1;
                        if (responeCode == 200) {
                            netDownResponse.success((String) msg.obj);
                        } else {
                            netDownResponse.errowithresponse((String) msg.obj);
                        }
                        break;
                }
                return false;
            }
        });


        Request request = new Request.Builder().url(Constant.BaseUrl + url)
                .addHeader("x-access-token", Constant.token).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(101);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = Message.obtain();
                msg.what = 102;
                //传递应答信息
                msg.obj = response.body().string();
                msg.arg1 = response.code();
                handler.sendMessage(msg);
            }
        });


    }


    public void netRequestGet2(final String url, final NetDownResponse netDownResponse) {

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case 101:
                        netDownResponse.erro();
                        break;
                    case 102:
                        netDownResponse.finish();
                        int responeCode = msg.arg1;
                        if (responeCode == 200) {
                            netDownResponse.success((String) msg.obj);
                        } else {
                            netDownResponse.errowithresponse((String) msg.obj);
                        }
                        break;
                }
                return false;
            }
        });


        Request request = new Request.Builder().url(url)
                .addHeader("x-access-token", Constant.token).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(101);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = Message.obtain();
                msg.what = 102;
                //传递应答信息
//                msg.obj = response.body().string();
                msg.arg1 = response.code();
                handler.sendMessage(msg);
            }
        });


    }


    //下载(带进度)
    public void downLoadFile (final Context context, final String url, final String filename, final DownResponseInterface downResponseInterface) {

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case 101:
                        downResponseInterface.erro();
                        break;
                    case 102:
                        downResponseInterface.successFinish();
                        break;
                    case 103:
                        //进度从0到100
                        downResponseInterface.progress(Integer.valueOf(String.valueOf(msg.obj)));
                        break;
                }
                return false;
            }
        });

        Request request = new Request.Builder().url(url)

                .addHeader("x-access-token", Constant.token).build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            private File file;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("NetRequsetUtil", "e:" + e);
                handler.sendEmptyMessage(101);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    long contentLength = response.body().contentLength();
                    FileOutputStream fileOutputStream = null;
                    InputStream is = response.body().byteStream();
                    if (is != null) {

                        File File = new File(Environment.getExternalStorageDirectory(), filename);
                        if (File.exists()) {
                            OpenFileUtil.openFiles(context, File.getAbsolutePath());
                            Message msg = Message.obtain();
                            msg.what = 103;
                            msg.obj = 100;
                            handler.sendMessage(msg);
                            handler.sendEmptyMessage(102);
                            //之前存在直接打开
                            return;
                        }

                        file = new File(
                                Environment.getExternalStorageDirectory(), filename);
                        fileOutputStream = new FileOutputStream(file);
                        //这个是缓冲区，即一次读取10个比特，我弄的小了点，因为在本地，所以数值太大一下就下载完了,
                        //看不出progressbar的效果。
                        byte[] buf = new byte[1024];
                        int len = -1;
                        int process = 0;
                        long time = System.currentTimeMillis();
                        while ((len = is.read(buf)) != -1) {
                            fileOutputStream.write(buf, 0, len);
                            process += len;
                            if (System.currentTimeMillis() - time > 200) {
                                time = System.currentTimeMillis();
                                Message msg = Message.obtain();
                                msg.what = 103;
                                msg.obj = (int) process * 100 / contentLength;
                                handler.sendMessage(msg);
                            }
                        }

                        Message msg = Message.obtain();
                        msg.what = 103;
                        msg.obj = 100;
                        handler.sendMessage(msg);

                        fileOutputStream.flush();

                        handler.sendEmptyMessage(102);

                        OpenFileUtil.openFiles(context,
                                file.getAbsolutePath());


                    }
                } catch (Exception e) {
                    if (file != null) {
                        file.delete();
                        //下载异常的时候删除破损文件
                    }
                    Log.d("NetRequsetUtil", "e:" + e);
                    handler.sendEmptyMessage(101);
                }

            }
        });
    }

    //更新app(带进度)
    public void upApk(final String url, final String filename, final DownResponseInterface downResponseInterface) {


        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case 101:
                        downResponseInterface.erro();
                        break;
                    case 102:
                        downResponseInterface.successFinish();
                        break;
                    case 103:
                        //进度从0到100
                        downResponseInterface.progress(Integer.valueOf(String.valueOf(msg.obj)));
                        break;
                }
                return false;
            }
        });

        Request request = new Request.Builder().url(url)
                .addHeader("x-access-token", Constant.token).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("NetRequsetUtil", "e:" + e);
                handler.sendEmptyMessage(101);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    long contentLength = response.body().contentLength();
                    FileOutputStream fileOutputStream = null;
                    InputStream is = response.body().byteStream();
                    if (is != null) {

                        File apkFile = new File(Environment.getExternalStorageDirectory(), filename);
                        if (apkFile.exists()) {
                            apkFile.delete();
                        }

                        File file = new File(
                                Environment.getExternalStorageDirectory(), filename);
                        fileOutputStream = new FileOutputStream(file);
                        //这个是缓冲区，即一次读取10个比特，我弄的小了点，因为在本地，所以数值太大一下就下载完了,
                        //看不出progressbar的效果。
                        byte[] buf = new byte[3072];
                        int len = -1;
                        long process = 0;
                        long time = System.currentTimeMillis();
                        while ((len = is.read(buf)) != -1) {
                            if (System.currentTimeMillis() - time > 1) {
                                time = System.currentTimeMillis();
                                Message msg = Message.obtain();
                                msg.what = 103;
                                msg.obj =  process * 100 / contentLength;
                                handler.sendMessage(msg);
                            }
                            process += len;
                            fileOutputStream.write(buf, 0, len);
                        }

                        Message msg = Message.obtain();
                        msg.what = 103;
                        msg.obj = 100;
                        handler.sendMessage(msg);

                        fileOutputStream.flush();

                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }

                        handler.sendEmptyMessage(102);
                    }
                } catch (Exception e) {
                    Log.d("NetRequsetUtil", "e:" + e);
                    handler.sendEmptyMessage(101);
                }

            }
        });
    }



    public void cancel() {
        if (okHttpClient == null) return;
        for (Call call : okHttpClient.dispatcher().queuedCalls()) {
            call.cancel();
        }
        for (Call call : okHttpClient.dispatcher().runningCalls()) {
            call.cancel();
        }
    }
}
