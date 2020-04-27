package com.example.project.bean;

import java.util.List;

public class SubmitListBean {


    private List<UserAddressLIstBean> user_addressLIst;

    public List<UserAddressLIstBean> getUser_addressLIst() {
        return user_addressLIst;
    }

    public void setUser_addressLIst(List<UserAddressLIstBean> user_addressLIst) {
        this.user_addressLIst = user_addressLIst;
    }

    public static class UserAddressLIstBean {
        /**
         * id : 7
         * user_name : sf003
         * is_default : 0
         * name : 呼呼呼
         * phone : 11025463576
         * address : 山东路陪你你先去咯了
         */

        private int id;
        private String user_name;
        private int is_default;
        private String name;
        private String phone;
        private String address;

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

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
