package com.example.project.utils;

/**
 * Created by louyulin on 2019/3/18.
 * okhttp回调接口
 */

public interface NetDownResponse {
    void success(String str);

    void errowithresponse(String str);

    void erro();

    void finish();

}
