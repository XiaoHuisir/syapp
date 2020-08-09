package com.example.shiyuankeji.bean;

import java.util.List;

public class RatepayingBean {

    /**
     * status : 200
     * data : [{"id":223,"user_name":"15188941137","score3":4000,"real_income":3400,"score2":400,"charge":0.05,"tax":0,"status":1,"createtime":"2020-014-02","deduct":0},{"id":224,"user_name":"15188941137","score3":1000,"real_income":850,"score2":100,"charge":0.05,"tax":0,"status":1,"createtime":"2020-014-02","deduct":0},{"id":225,"user_name":"15188941137","score3":3000,"real_income":2460,"score2":300,"charge":0.05,"tax":0.03,"status":1,"createtime":"2020-014-02","deduct":90},{"id":226,"user_name":"15188941137","score3":9000,"real_income":6750,"score2":900,"charge":0.05,"tax":0.1,"status":1,"createtime":"2020-014-02","deduct":900},{"id":228,"user_name":"15188941137","score3":13000,"real_income":8450,"score2":1300,"charge":0.05,"tax":0.2,"status":1,"createtime":"2020-014-02","deduct":2600}]
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
         * id : 223
         * user_name : 15188941137
         * score3 : 4000
         * real_income : 3400
         * score2 : 400
         * charge : 0.05
         * tax : 0.0
         * status : 1
         * createtime : 2020-014-02
         * deduct : 0.0
         */

        private int id;
        private String user_name;
        private int score3;
        private int real_income;
        private int score2;
        private double charge;
        private double tax;
        private int status;
        private String createtime;
        private double deduct;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getScore3() {
            return score3;
        }

        public void setScore3(int score3) {
            this.score3 = score3;
        }

        public int getReal_income() {
            return real_income;
        }

        public void setReal_income(int real_income) {
            this.real_income = real_income;
        }

        public int getScore2() {
            return score2;
        }

        public void setScore2(int score2) {
            this.score2 = score2;
        }

        public double getCharge() {
            return charge;
        }

        public void setCharge(double charge) {
            this.charge = charge;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public double getDeduct() {
            return deduct;
        }

        public void setDeduct(double deduct) {
            this.deduct = deduct;
        }
    }



}
