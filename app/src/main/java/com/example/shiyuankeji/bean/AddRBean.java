package com.example.shiyuankeji.bean;

public class AddRBean  {


    /**
     * id : null
     * user_name : sf003
     * is_default : 0
     * name : 张文端
     * phone : 17610501038
     * address : 高碑店东方纽伦堡16楼1622号
     */

    private Object id;
    private String user_name;
    private int is_default;
    private String name;
    private String phone;
    private String address;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
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
