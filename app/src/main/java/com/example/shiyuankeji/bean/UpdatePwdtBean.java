package com.example.shiyuankeji.bean;

public class UpdatePwdtBean {

    /**
     * status : 200
     * data : {"token":"42cf91fd-66de-4656-8fa9-48be816b2691","data1":"17526625697","data2":"779","data3":"456789","genTime":"Mon Jun 08 10:48:48 CST 2020"}
     * msg : 1
     */

    private int status;
    private DataBean data;
    private String msg;

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

    public static class DataBean {
        /**
         * token : 42cf91fd-66de-4656-8fa9-48be816b2691
         * data1 : 17526625697
         * data2 : 779
         * data3 : 456789
         * genTime : Mon Jun 08 10:48:48 CST 2020
         */

        private String token;
        private String data1;
        private String data2;
        private String data3;
        private String genTime;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

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
    }
}
