package com.example.shiyuankeji.bean;

public class AlterBean {

    /**
     * status : 200
     * data : {"token":null,"data1":"17526625697","data2":"zh1234567","data3":null,"genTime":null}
     * msg : 修改成功
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
         * token : null
         * data1 : 17526625697
         * data2 : zh1234567
         * data3 : null
         * genTime : null
         */

        private Object token;
        private String data1;
        private String data2;
        private Object data3;
        private Object genTime;

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
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

        public Object getData3() {
            return data3;
        }

        public void setData3(Object data3) {
            this.data3 = data3;
        }

        public Object getGenTime() {
            return genTime;
        }

        public void setGenTime(Object genTime) {
            this.genTime = genTime;
        }
    }
}
