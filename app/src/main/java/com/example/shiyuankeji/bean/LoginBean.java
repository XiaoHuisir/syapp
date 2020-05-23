package com.example.shiyuankeji.bean;

public class LoginBean {

    /**
     * status : 1
     * data : {"userToken":"70275DC4C5F443ADF8E8FCDDB43D38DDMDAwMDAwMDAwML6Mna-FqrqSib2cgMOHoIC7o36CkY6xfLjQzqGGZIXVuGadr4u5um-LunZ_w4efabGmjmWDo3-gu5SsqIhkp6vHZJ3Ynau-moXTqGG4nZSnyX-ohIONk4a7qbuyiJ-n08hkaqmS3bKHmtBxpbBlmJy-anplhWtuarPRvLCBY326s3l7vZupzI-drnFgsHiGi7dspHSVfnJuyZSokoisib62eJXQmtqhdg"}
     * msg : 登录成功
     * code : 10000
     */

    private int status;
    private DataBean data;
    private String msg;
    private int code;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * userToken : 70275DC4C5F443ADF8E8FCDDB43D38DDMDAwMDAwMDAwML6Mna-FqrqSib2cgMOHoIC7o36CkY6xfLjQzqGGZIXVuGadr4u5um-LunZ_w4efabGmjmWDo3-gu5SsqIhkp6vHZJ3Ynau-moXTqGG4nZSnyX-ohIONk4a7qbuyiJ-n08hkaqmS3bKHmtBxpbBlmJy-anplhWtuarPRvLCBY326s3l7vZupzI-drnFgsHiGi7dspHSVfnJuyZSokoisib62eJXQmtqhdg
         */

        private String userToken;

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }
    }
}
