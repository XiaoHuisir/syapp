package com.example.shiyuankeji.interfaces;


import com.example.shiyuankeji.bean.AddOrderistBean;
import com.example.shiyuankeji.bean.AddRBean;
import com.example.shiyuankeji.bean.AddUserBean;
import com.example.shiyuankeji.bean.AliPayBean;
import com.example.shiyuankeji.bean.AnddressBean;
import com.example.shiyuankeji.bean.BankBean;
import com.example.shiyuankeji.bean.CashBean;
import com.example.shiyuankeji.bean.ClassBean;
import com.example.shiyuankeji.bean.ClassListBean;
import com.example.shiyuankeji.bean.HomeBean;
import com.example.shiyuankeji.bean.IdentityBean;
import com.example.shiyuankeji.bean.InxtendBean;
import com.example.shiyuankeji.bean.JoinBean;
import com.example.shiyuankeji.bean.LineItemBean;
import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.bean.LoginsBean;
import com.example.shiyuankeji.bean.MineBean;
import com.example.shiyuankeji.bean.NewIndentBean;
import com.example.shiyuankeji.bean.PhoneBean;
import com.example.shiyuankeji.bean.ProductDetailsBean;
import com.example.shiyuankeji.bean.QueryEarningsBean;
import com.example.shiyuankeji.bean.QueryIntegralBean;
import com.example.shiyuankeji.bean.QueryLastWeekStockBean;
import com.example.shiyuankeji.bean.QueryMinuteStockBean;
import com.example.shiyuankeji.bean.QueryStockBean;
import com.example.shiyuankeji.bean.QueryTabBean;
import com.example.shiyuankeji.bean.RatepayingBean;
import com.example.shiyuankeji.bean.ScanCodeBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.bean.SubmitBean;
import com.example.shiyuankeji.bean.SubmitListBean;
import com.example.shiyuankeji.bean.SynergicBean;
import com.example.shiyuankeji.bean.UpdatePwdtBean;
import com.example.shiyuankeji.bean.YieDetailsBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {


    //---------------------------------------
//login
    @POST("user_login")
    @FormUrlEncoded
    Flowable<LoginsBean> logins(@Field("user_name") String mobile, @Field("password") String password);

    //     验证token 是否有效  http://192.168.124.14:8080/user_login?token=
    @POST("checkLogin")
//    @FormUrlEncoded
    Flowable<LoginTokenBean> logintoken(@Header("token") String logintoken);

    //注册
    @POST("addUser")
    @FormUrlEncoded
    Flowable<AddUserBean> registerApi(@Field("user_name") String mobile, @Field("verifyCode") String verify, @Field("password") String password);

    //    修改密码   http://192.168.124.14:8080/updatePassword?password=456789
    @POST("updatePassword")
    @FormUrlEncoded
    Flowable<UpdatePwdtBean> updatepwdApi(@Field("user_name") String username, @Field("password") String pwds);

    //    匹配不成功校验  http://192.168.124.14:8080/queryTab_user?user_name=sf005&phone_number=18500398400&name=测试账号2
    @POST("queryTab_user")
    @FormUrlEncoded
    Flowable<QueryTabBean> querytabApi(@Field("user_name") String user_name, @Field("phone_number") String phone_number, @Field("name") String name);

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
    Flowable<SubmitBean> submits(@Header("token") String tokens, @Field("idsa") int id);

//toUser_AddressIndex 地址管理list

    //收货地址列表
    @POST("toUser_AddressIndex")
    @FormUrlEncoded
    Flowable<SubmitListBean> submitLists(@Header("token") String tokens, @Field("idsa") int idsas, @Field("num") int num);

    //修改收货地址
    @POST("updateUser_AddressById")
    @FormUrlEncoded
    Flowable<AnddressBean> address(@Header("token") String tokens, @Field("name") String name, @Field("id") int id, @Field("is_default") int is_default, @Field("phone") String phone, @Field("address") String address);

    //添加收货地址
    @POST("addUser_Address")
    @FormUrlEncoded
    Flowable<AddRBean> addr(@Header("token") String tokens, @Field("name") String name, @Field("is_default") int is_default, @Field("phone") String phone, @Field("address") String address);

    //提交订单（积分支付）
    @POST("addOrder_list")  //TODO ?????
    @FormUrlEncoded
    Flowable<AddOrderistBean> addOrderApi(@Header("token") String tokens, @FieldMap Map<String, String> map);

    //订单列表
    @POST("toOrderIndex")
    //@Field("userId") int user_id TODO
//    @FormUrlEncoded
    Flowable<NewIndentBean> indentApi(@Header("token") String tokens);

    //订单详情页
    @POST("detailOrder_listById")
    @FormUrlEncoded
    Flowable<LineItemBean> lineitemApi(@Field("order_num") String id);

    //我的模块
    @POST("query_User")
//    @FormUrlEncoded
    Flowable<MineBean> MinesApi(@Header("token") String tokens);

    //身份证号修改   update_identity
    @POST("update_identity")
    @FormUrlEncoded
    Flowable<IdentityBean> updateidentityApi(@Header("token") String tokens, @Field("identity_num") String identity);

    //银行卡号修改
    @POST("update_bank")
    @FormUrlEncoded
    Flowable<BankBean> updatebankApi(@Header("token") String tokens, @Field("name") String bankname, @Field("bank_num") String banknum, @Field("bank_address") String bankaddress);


    //IntegralDetails
    //购物积分明细: http://192.168.124.14:8080/queryIntegral
    @POST("queryIntegral")
    Flowable<QueryIntegralBean> queryIntegralApi(@Header("token") String tokens);

    //识缘股明细: http://192.168.124.14:8080/queryStock
    @POST("queryStock")
    Flowable<QueryStockBean> queryStockApi(@Header("token") String tokens);

    //分红识缘股明细: http://192.168.124.14:8080/queryMinuteStock
    @POST("queryMinuteStock")
    Flowable<QueryMinuteStockBean> queryMinuteStockApi(@Header("token") String tokens);

    //赠送积分: http://192.168.124.14:8080/queryLastWeekStock
    @POST("queryLastWeekStock")
    Flowable<QueryLastWeekStockBean> queryLastWeekStockApi(@Header("token") String tokens);


    //二维码      TODO ???????
    @POST("qrCode")
    Flowable<ScanCodeBean> scancodeApi(@Header("token") String tokens);


    //判断是否要加入合作组 1
    @POST("toJoinTeam")
    @FormUrlEncoded
    Flowable<JoinBean> isjoinApi(@Field("shiyuanInvitation_code") String codes);

    //  加入合作组  2
    //  http://192.168.124.14:8080/doJoinTeam?token=111&id=36
    @POST("doJoinTeam")
    @FormUrlEncoded
    Flowable<JoinBean> joinApi(@Header("token") String tokens, @Field("id") int mid);

    // （商，合）组 展示
    @POST("toTeamIndex")
    Flowable<SynergicBean> synergicApi(@Header("token") String tokens);

    // （商，合）组 展示详情
    @POST("toDetailTeam")
    @FormUrlEncoded
    Flowable<SynergicBean> sybergicxingApi(@Field("teamId") String tramid);

    //支付宝
    @POST("apppay")
    @FormUrlEncoded
    Flowable<AliPayBean> alipayApi(@Field("outTradeNo") String outtradeno, @Field("totalAmount") double totalamount, @Field("subject") String subjec);

    //获取验证码
    @POST("smsSend")
    @FormUrlEncoded
    Flowable<SmsSendBean> smsSendApi(@Field("phone") String outtradeno);

    //    校验验证码
    @POST("isVerifyCode")
    @FormUrlEncoded
    Flowable<SmsSendBean> isVerifyCodeApi(@Field("phone") String outtradeno, @Field("verifyCode") String outr);

    //我的收益
    @POST("queryEarnings")
    Flowable<QueryEarningsBean> queryEarningsApi(@Header("token") String tokens);

    //我的收益详情
    @POST("queryDetail")
    @FormUrlEncoded
    Flowable<YieDetailsBean> querydetailApi(@Header("token") String tokens, @Field("order_num") String order);

    //获取手机号
    @POST("queryPhone")
    @FormUrlEncoded
    Flowable<PhoneBean> PhoneApi(@Field("user_name") String phone);

    //提现
    @POST("updateType3")
    @FormUrlEncoded
    Flowable<CashBean> cashApi(@Header("token") String tokens, @Field("score3") int order);
   //new  邀请码  getInvitationCode
   @POST("getInvitationCode")
   Flowable<InxtendBean> inxtendApi(@Header("token") String tokens);

   //new  纳税专区  queryPractical
   @POST("queryPractical")
   Flowable<RatepayingBean> rateApi(@Header("token") String tokens);

//    {
//    "id": 34,
//    "nick_name": "N号初级合作组",
//    "level": 1,
//    "affiliated_userid": 8,
//    "people_num": 4,
//    "create_time": "2020-05-19T15:04:36.000+0000",
//    "tab_user": null
//}
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


