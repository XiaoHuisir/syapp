package com.example.shiyuankeji.bean;

import java.util.List;

public class GrantDetailsBean {

    /**
     * status : 200
     * data : [{"id":0,"order_num":"202009021727571583162057","userid":0,"sharetype":1,"sharestate":2,"totalprice":555,"createtime":"2020-09-02"}]
     * msg :
     */

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 0
         * order_num : 202009021727571583162057
         * userid : 0
         * sharetype : 1
         * sharestate : 2
         * totalprice : 555
         * createtime : 2020-09-02
         */

        private int id;
        private String order_num;
        private int userid;
        private int sharetype;
        private int sharestate;
        private int totalprice;
        private String createtime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getSharetype() {
            return sharetype;
        }

        public void setSharetype(int sharetype) {
            this.sharetype = sharetype;
        }

        public int getSharestate() {
            return sharestate;
        }

        public void setSharestate(int sharestate) {
            this.sharestate = sharestate;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }
    }
}
