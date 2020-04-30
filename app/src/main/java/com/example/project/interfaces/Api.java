package com.example.project.interfaces;


import com.example.project.bean.AddRBean;
import com.example.project.bean.AnddressBean;
import com.example.project.bean.ClassBean;
import com.example.project.bean.ClassListBean;
import com.example.project.bean.HomeBean;
import com.example.project.bean.LoginBean;
import com.example.project.bean.LoginTokenBean;
import com.example.project.bean.LoginsBean;
import com.example.project.bean.ProductDetailsBean;
import com.example.project.bean.SubmitBean;
import com.example.project.bean.SubmitListBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {


    //---------------------------------------
//login
    @POST("user_login")
    @FormUrlEncoded
    Flowable<LoginsBean> logins(@Field("user_name") String mobile, @Field("password") String password);

    //     验证token 是否有效  http://192.168.124.14:8080/user_login?token=
    @POST("checkLogin")
    @FormUrlEncoded
    Flowable<LoginTokenBean> logintoken(@Field("token") String logintoken);


    //home
    @POST("toIndex")
//    @FormUrlEncoded
    Flowable<HomeBean> home();

    //商品 详情
    @POST("toItemsDetail")
    @FormUrlEncoded
    Flowable<ProductDetailsBean> ProductDetails(@Field("idsa") int id);


    //classify
    @POST("toCateIndex")
//    @FormUrlEncoded
    Flowable<ClassBean> clasify();

    // classifylist
    @POST("toCatePage")
    @FormUrlEncoded
    Flowable<ClassListBean> classlist(@Field("cateid") int type);


    //订单确认页(地址)
    @POST("toConfirmOrderList")
    @FormUrlEncoded
    Flowable<SubmitBean> submits(@Field("user_name") String user, @Field("idsa") int id);

//toUser_AddressIndex 地址管理list

    //收货地址列表
    @POST("toUser_AddressIndex")
    @FormUrlEncoded
    Flowable<SubmitListBean> submitLists(@Field("user_name") String user);

    //修改收货地址
    @POST("updateUser_AddressById")
    @FormUrlEncoded
    Flowable<AnddressBean> address(@Field("user_name") String user, @Field("name") String name, @Field("id") int id, @Field("is_default") int is_default, @Field("phone") String phone, @Field("address") String address);

    //添加收货地址
    @POST("addUser_Address")
    @FormUrlEncoded
    Flowable<AddRBean> addr(@Field("user_name") String user, @Field("name") String name, @Field("is_default") int is_default, @Field("phone") String phone, @Field("address") String address);

    //----------------------------------------


//    @POST("index/user/login")
//    @FormUrlEncoded
//    Flowable<LoginBean> login(@Field("mobile") String mobile, @Field("password") String password);
//    //
//    @POST("index/train/index")
//    @FormUrlEncoded
//    Flowable<IndexBean> getIndex(@Header("x-access-token") String token, @FieldMap Map<String, String> map);
//
//    @POST("index/train/type_index")
//    @FormUrlEncoded
//    Flowable<TypeIndexBean> getTypeIndex(@Header("x-access-token") String token, @Field("type") String type, @Field("page") String page);
//
//    @POST("index/train/curriculum_show")
//    @FormUrlEncoded
//    Flowable<CurriculumBean> getCurriculum(@Header("x-access-token") String token, @Field("curriculum_id") String curriculum_id);
//
//    @POST("index/train/evaluation_show")
//    @FormUrlEncoded
//    Flowable<ExercisesBean> getEvaluation(@Header("x-access-token") String token, @Field("curriculum_id") String curriculum_id);
//
//    @POST("index/train/evaluation_submit")
//    @Headers({
//            "Content-type:application/json"
//    })
//    Flowable<EvaluationSubmitBean> submitEvaluation(@Header("x-access-token") String token, @Body RequestBody body);
//
//    @POST("index/train/evaluation_result_show")
//    @FormUrlEncoded
//    Flowable<EvaluatShowResultBean> showEvaluationResult(@Header("x-access-token") String token, @Field("evaluat_id") String evaluatId);
//
//
//    //个人中心
//    @POST("index/train/user_center")
//    Flowable<UserCenterBean> usercenter(@Header("x-access-token") String token);
//
//    @POST("index/train/userinfo_update")
//    @FormUrlEncoded
//    Flowable<UserInfoUpdateBean> updateUserInfo(@Header("x-access-token") String token, @Field("nickname") String nickname,
//                                                @Field("zw") String zw, @Field("avatar") String avatar);
//
//    @POST("index/user/get_token")
//    Flowable<TokenBean> getToken(@Header("x-access-token") String token);
//
//    @POST("index/train/study_record")
//    @FormUrlEncoded
//    Flowable<ToadayBean> porfolio(@Header("x-access-token") String token, @Field("type") String type, @Field("page") String page);
//
//    @POST("index/train/my_file_list")
//    @FormUrlEncoded
//    Flowable<MyfilelistBean> myfilelist(@Header("x-access-token") String token, @Field("page") int page);
//
//
//    @POST("index/train/get_unread_notice_num")
//    Flowable<UnredNoticeBean> unreadNotice(@Header("x-access-token") String token);
//
//
//    @POST("index/train/notice_list")
//    @FormUrlEncoded
//    Flowable<NoticeListBean> noticeList(@Header("x-access-token") String token, @Field("page") String page);
//
//    @POST("index/train/curriculum_serach")
//    @FormUrlEncoded
//    Flowable<SearchBean> search(@Header("x-access-token") String token, @Field("keyword") String keyword, @Field("type") String type, @Field("page") String page);
//
//
//    @POST("index/train/down_file")
//    @FormUrlEncoded
//    Flowable<DownFileBean> downfile(@Header("x-access-token") String token, @FieldMap Map<String, String> map);
//
//    @POST("index/train/evaluation_record")
//    @FormUrlEncoded
//    Flowable<NotcieRecordBean> notice_records(@Header("x-access-token") String token, @Field("page") String page);
//    @POST("index/train/version_update")
//    Flowable<VerBean> getVersionInfo(@Header("x-access-token") String token);

}


