package com.example.shiyuankeji.bean;

public class SmsSendBean {

    /**
     * code : 0
     * msgId : 20060709083200202014000007757391
     * time : 20200607090832
     * errorMsg :
     */

    private String code;
    private String msgId;
    private String time;
    private String errorMsg;
    /**
     * status : 200
     * data :
     * msg : 验证成功。
     */

    private int status;
    private String data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
