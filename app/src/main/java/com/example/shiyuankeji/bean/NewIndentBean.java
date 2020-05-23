package com.example.shiyuankeji.bean;

import java.util.List;

public class NewIndentBean {

    private List<OrderListsBean> order_lists;

    public List<OrderListsBean> getOrder_lists() {
        return order_lists;
    }

    public void setOrder_lists(List<OrderListsBean> order_lists) {
        this.order_lists = order_lists;
    }

    public static class OrderListsBean {
        /**
         * id : 26
         * name : sf005
         * order_num : 1583806859353
         * order_state : 0
         * num : 1
         * user_name : 在上
         * user_phone : 13865495796
         * user_add : 去上睡起来了战胜自己玩凸环球政
         * user_id : 8
         * create_time : 2020-03-10T10:21:00.000+0000
         * item_img : https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/00.jpg
         * item_name : 小西科技拼读机
         * item_price : 499
         * item_freight : 10
         * order_price : 0
         */

        private int id;
        private String name;
        private String order_num;
        private int order_state;
        private int num;
        private String user_name;
        private String user_phone;
        private String user_add;
        private int user_id;
        private String create_time;
        private String item_img;
        private String item_name;
        private int item_price;
        private int item_freight;
        private int order_price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public int getOrder_state() {
            return order_state;
        }

        public void setOrder_state(int order_state) {
            this.order_state = order_state;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_add() {
            return user_add;
        }

        public void setUser_add(String user_add) {
            this.user_add = user_add;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getItem_img() {
            return item_img;
        }

        public void setItem_img(String item_img) {
            this.item_img = item_img;
        }

        public String getItem_name() {
            return item_name;
        }

        public void setItem_name(String item_name) {
            this.item_name = item_name;
        }

        public int getItem_price() {
            return item_price;
        }

        public void setItem_price(int item_price) {
            this.item_price = item_price;
        }

        public int getItem_freight() {
            return item_freight;
        }

        public void setItem_freight(int item_freight) {
            this.item_freight = item_freight;
        }

        public int getOrder_price() {
            return order_price;
        }

        public void setOrder_price(int order_price) {
            this.order_price = order_price;
        }
    }
}
