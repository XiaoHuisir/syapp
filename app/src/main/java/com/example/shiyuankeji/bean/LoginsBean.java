package com.example.shiyuankeji.bean;

public class LoginsBean {

    /**
     * data : {"data1":"17090315292","data2":"15","data3":"456789","genTime":"Sat May 16 16:11:30 CST 2020","token":"155d0f9b-76b3-4eab-93d4-9b55fb317898"}
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
         * data1 : 17090315292
         * data2 : 15
         * data3 : 456789
         * genTime : Sat May 16 16:11:30 CST 2020
         * token : 155d0f9b-76b3-4eab-93d4-9b55fb317898
         */

        private String data1;
        private String data2;
        private String data3;
        private String genTime;
        private String token;

        public String getData1() {
            return data1;
        }

        public void setData1(String data1) {
            this.data1 = data1;
        }

        public String getData2() {
            return data2;
        }

        public void setData2(String data2) {
            this.data2 = data2;
        }

        public String getData3() {
            return data3;
        }

        public void setData3(String data3) {
            this.data3 = data3;
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
