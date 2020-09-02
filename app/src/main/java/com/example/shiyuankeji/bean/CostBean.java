package com.example.shiyuankeji.bean;

public class CostBean {

    /**
     * msg : 提现金额需要大于100积分,且是100积分的倍数,同时提箱将扣除5%的手续费。
     */

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
