package com.example.shiyuankeji.bean;

import java.util.List;

public class QueryMinuteStockBean {


    private List<UserAddLogListBean> user_add_logList;

    public List<UserAddLogListBean> getUser_add_logList() {
        return user_add_logList;
    }

    public void setUser_add_logList(List<UserAddLogListBean> user_add_logList) {
        this.user_add_logList = user_add_logList;
    }

    public static class UserAddLogListBean {
        /**
         * id : 654
         * user_name : sf003
         * phone_number : 12312312311
         * type : 3
         * type1 : 1
         * add_val : 100
         * time : 2019-06-10
         * tab_user : null
         */

        private int id;
        private String user_name;
        private String phone_number;
        private int type;
        private int type1;
        private int add_val;
        private String time;
        private Object tab_user;

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

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType1() {
            return type1;
        }

        public void setType1(int type1) {
            this.type1 = type1;
        }

        public int getAdd_val() {
            return add_val;
        }

        public void setAdd_val(int add_val) {
            this.add_val = add_val;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Object getTab_user() {
            return tab_user;
        }

        public void setTab_user(Object tab_user) {
            this.tab_user = tab_user;
        }
    }
}
