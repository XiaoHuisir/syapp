package com.example.project.bean;

public class JoinBean {

    /**
     * status : 500
     * data :
     * msg : 您已经加入其它的合作组！
     */

    private int status;
    private String data;
    private String msg;
    /**
     * id : 34
     * nick_name : N号初级合作组
     * level : 1
     * affiliated_userid : 8
     * people_num : 4
     * create_time : 2020-05-19T15:04:36.000+0000
     * tab_user : null
     */

    private int id;
    private String nick_name;
    private int level;
    private int affiliated_userid;
    private int people_num;
    private String create_time;
    private Object tab_user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAffiliated_userid() {
        return affiliated_userid;
    }

    public void setAffiliated_userid(int affiliated_userid) {
        this.affiliated_userid = affiliated_userid;
    }

    public int getPeople_num() {
        return people_num;
    }

    public void setPeople_num(int people_num) {
        this.people_num = people_num;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Object getTab_user() {
        return tab_user;
    }

    public void setTab_user(Object tab_user) {
        this.tab_user = tab_user;
    }
}
