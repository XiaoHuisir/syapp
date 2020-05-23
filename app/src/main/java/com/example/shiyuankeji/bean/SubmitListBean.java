package com.example.shiyuankeji.bean;

import java.util.List;

public class SubmitListBean {


    /**
     * user_addressLIst : [{"id":54,"user_name":"sf003","is_default":1,"name":"他","phone":"17524434242","address":"河北省  省直辖县级行政区划  定州市 发"},{"id":53,"user_name":"sf003","is_default":0,"name":"其实","phone":"17526625555","address":"河北省  石家庄市  市辖区 14"},{"id":10,"user_name":"sf003","is_default":0,"name":"孙悟空","phone":"17445551111","address":"河北省高阳现金也也行产品"},{"id":5,"user_name":"sf003","is_default":0,"name":"李聪","phone":"18911410154","address":"北京市昌平区哈哈哈哈"},{"id":4,"user_name":"sf003","is_default":0,"name":"xiaomao","phone":"11111111111","address":"北京市就是北京市咋地？"},{"id":1,"user_name":"sf003","is_default":0,"name":"士大二万人","phone":"112","address":"士大夫"}]
     * idsa : 1012
     * num : 1
     */

    private int idsa;
    private int num;
    private List<UserAddressLIstBean> user_addressLIst;

    public int getIdsa() {
        return idsa;
    }

    public void setIdsa(int idsa) {
        this.idsa = idsa;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<UserAddressLIstBean> getUser_addressLIst() {
        return user_addressLIst;
    }

    public void setUser_addressLIst(List<UserAddressLIstBean> user_addressLIst) {
        this.user_addressLIst = user_addressLIst;
    }

    public static class UserAddressLIstBean {
        /**
         * id : 54
         * user_name : sf003
         * is_default : 1
         * name : 他
         * phone : 17524434242
         * address : 河北省  省直辖县级行政区划  定州市 发
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
