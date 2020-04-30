package com.example.project.bean;

public class LoginsBean {

    /**
     * data : {"expTime":"1588081284937","genTime":"Tue Apr 28 21:11:24 CST 2020","token":"105743af-883b-40ad-a865-1097d3a82ee6"}
     * msg : 200
     */

    private DataBean data;
    private String msg;

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

    public static class DataBean {
        /**
         * expTime : 1588081284937
         * genTime : Tue Apr 28 21:11:24 CST 2020
         * token : 105743af-883b-40ad-a865-1097d3a82ee6
         */

        private String expTime;
        private String genTime;
        private String token;

        public String getExpTime() {
            return expTime;
        }

        public void setExpTime(String expTime) {
            this.expTime = expTime;
        }

        public String getGenTime() {
            return genTime;
        }

        public void setGenTime(String genTime) {
            this.genTime = genTime;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
