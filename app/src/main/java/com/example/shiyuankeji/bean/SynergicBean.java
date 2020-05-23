package com.example.shiyuankeji.bean;

import java.util.List;

public class SynergicBean {

    /**
     * inTeam : {"id":9,"nick_name":"1号商务拼团","level":2,"affiliated_userid":8,"people_num":9,"create_time":"2020-05-19T09:55:49.000+0000","tab_user":null}
     * teamListLV1 : [{"id":34,"nick_name":"N号初级合作组","level":1,"affiliated_userid":8,"people_num":4,"create_time":"2020-05-19T15:04:36.000+0000","tab_user":null}]
     * teamListLV2 : [{"id":9,"nick_name":"1号商务拼团","level":2,"affiliated_userid":8,"people_num":9,"create_time":"2020-05-19T09:55:49.000+0000","tab_user":null},{"id":35,"nick_name":"2号商务拼团","level":2,"affiliated_userid":8,"people_num":2,"create_time":"2020-05-19T07:17:14.000+0000","tab_user":null}]
     * teamListLV3 : [{"id":35,"nick_name":"2号商务拼团","level":2,"affiliated_userid":8,"people_num":2,"create_time":"2020-05-19T07:17:14.000+0000","tab_user":null}]
     */

    private InTeamBean inTeam;
    private List<TeamListLV1Bean> teamListLV1;
    private List<TeamListLV2Bean> teamListLV2;
    private List<TeamListLV3Bean> teamListLV3;
    /**
     * status : 200
     * data : [{"user_name":"j5ysz01","name":"杨素振"}]
     * msg : 该组内的用户信息。
     */

    private int status;
    private String msg;
    private List<DataBean> data;
    /**
     * inTeamVL1 : {"id":47,"nick_name":"1号初期合作组","level":1,"affiliated_userid":8,"people_num":1,"create_time":"2020-05-21T17:22:32.000+0000","tab_user":null}
     * inTeamVL2 : {"id":47,"nick_name":"1号初期合作组","level":1,"affiliated_userid":8,"people_num":1,"create_time":"2020-05-21T17:22:32.000+0000","tab_user":null}
     * inTeamVL3 : {"id":47,"nick_name":"1号初期合作组","level":1,"affiliated_userid":8,"people_num":1,"create_time":"2020-05-21T17:22:32.000+0000","tab_user":null}
     */

    private InTeamVL1Bean inTeamVL1;
    private InTeamVL2Bean inTeamVL2;
    private InTeamVL3Bean inTeamVL3;

    public InTeamBean getInTeam() {
        return inTeam;
    }

    public void setInTeam(InTeamBean inTeam) {
        this.inTeam = inTeam;
    }

    public List<TeamListLV1Bean> getTeamListLV1() {
        return teamListLV1;
    }

    public void setTeamListLV1(List<TeamListLV1Bean> teamListLV1) {
        this.teamListLV1 = teamListLV1;
    }

    public List<TeamListLV2Bean> getTeamListLV2() {
        return teamListLV2;
    }

    public void setTeamListLV2(List<TeamListLV2Bean> teamListLV2) {
        this.teamListLV2 = teamListLV2;
    }

    public List<TeamListLV3Bean> getTeamListLV3() {
        return teamListLV3;
    }

    public void setTeamListLV3(List<TeamListLV3Bean> teamListLV3) {
        this.teamListLV3 = teamListLV3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public InTeamVL1Bean getInTeamVL1() {
        return inTeamVL1;
    }

    public void setInTeamVL1(InTeamVL1Bean inTeamVL1) {
        this.inTeamVL1 = inTeamVL1;
    }

    public InTeamVL2Bean getInTeamVL2() {
        return inTeamVL2;
    }

    public void setInTeamVL2(InTeamVL2Bean inTeamVL2) {
        this.inTeamVL2 = inTeamVL2;
    }

    public InTeamVL3Bean getInTeamVL3() {
        return inTeamVL3;
    }

    public void setInTeamVL3(InTeamVL3Bean inTeamVL3) {
        this.inTeamVL3 = inTeamVL3;
    }

    public static class InTeamBean {
        /**
         * id : 9
         * nick_name : 1号商务拼团
         * level : 2
         * affiliated_userid : 8
         * people_num : 9
         * create_time : 2020-05-19T09:55:49.000+0000
         * tab_user : null
         */

        private int id;
        private String nick_name;
        private int level;
        private int affiliated_userid;
        private int people_num;
        private String create_time;
        private Object tab_user;

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

    public static class TeamListLV1Bean {
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

    public static class TeamListLV2Bean {
        /**
         * id : 9
         * nick_name : 1号商务拼团
         * level : 2
         * affiliated_userid : 8
         * people_num : 9
         * create_time : 2020-05-19T09:55:49.000+0000
         * tab_user : null
         */

        private int id;
        private String nick_name;
        private int level;
        private int affiliated_userid;
        private int people_num;
        private String create_time;
        private Object tab_user;

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

    public static class TeamListLV3Bean {
        /**
         * id : 35
         * nick_name : 2号商务拼团
         * level : 2
         * affiliated_userid : 8
         * people_num : 2
         * create_time : 2020-05-19T07:17:14.000+0000
         * tab_user : null
         */

        private int id;
        private String nick_name;
        private int level;
        private int affiliated_userid;
        private int people_num;
        private String create_time;
        private Object tab_user;

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

    public static class DataBean {
        /**
         * user_name : j5ysz01
         * name : 杨素振
         */

        private String user_name;
        private String name;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class InTeamVL1Bean {
        /**
         * id : 47
         * nick_name : 1号初期合作组
         * level : 1
         * affiliated_userid : 8
         * people_num : 1
         * create_time : 2020-05-21T17:22:32.000+0000
         * tab_user : null
         */

        private int id;
        private String nick_name;
        private int level;
        private int affiliated_userid;
        private int people_num;
        private String create_time;
        private Object tab_user;

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

    public static class InTeamVL2Bean {
        /**
         * id : 47
         * nick_name : 1号初期合作组
         * level : 1
         * affiliated_userid : 8
         * people_num : 1
         * create_time : 2020-05-21T17:22:32.000+0000
         * tab_user : null
         */

        private int id;
        private String nick_name;
        private int level;
        private int affiliated_userid;
        private int people_num;
        private String create_time;
        private Object tab_user;

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

    public static class InTeamVL3Bean {
        /**
         * id : 47
         * nick_name : 1号初期合作组
         * level : 1
         * affiliated_userid : 8
         * people_num : 1
         * create_time : 2020-05-21T17:22:32.000+0000
         * tab_user : null
         */

        private int id;
        private String nick_name;
        private int level;
        private int affiliated_userid;
        private int people_num;
        private String create_time;
        private Object tab_user;

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
}
