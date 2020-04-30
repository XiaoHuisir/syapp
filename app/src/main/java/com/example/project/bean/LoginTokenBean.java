package com.example.project.bean;

public class LoginTokenBean {

    /**
     * status : 200
     * data : {"id":630,"user_name":"sy001","password":"123456","name":"何建军","head":1,"phone_number":"13703286407","score":93119,"score2":9999,"score3":0,"score4":0,"score3_1":0,"identity_num":"","bank_name":"","bank_num":"","bank_address":"","add_time":1578066120000,"update_time":1578066240000,"fenhong_time":1586817407000,"changeInfo_time":1578737580000}
     * msg : ok
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
         * id : 630
         * user_name : sy001
         * password : 123456
         * name : 何建军
         * head : 1
         * phone_number : 13703286407
         * score : 93119
         * score2 : 9999
         * score3 : 0
         * score4 : 0
         * score3_1 : 0
         * identity_num :
         * bank_name :
         * bank_num :
         * bank_address :
         * add_time : 1578066120000
         * update_time : 1578066240000
         * fenhong_time : 1586817407000
         * changeInfo_time : 1578737580000
         */

        private int id;
        private String user_name;
        private String password;
        private String name;
        private int head;
        private String phone_number;
        private int score;
        private int score2;
        private int score3;
        private int score4;
        private int score3_1;
        private String identity_num;
        private String bank_name;
        private String bank_num;
        private String bank_address;
        private long add_time;
        private long update_time;
        private long fenhong_time;
        private long changeInfo_time;

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHead() {
            return head;
        }

        public void setHead(int head) {
            this.head = head;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getScore2() {
            return score2;
        }

        public void setScore2(int score2) {
            this.score2 = score2;
        }

        public int getScore3() {
            return score3;
        }

        public void setScore3(int score3) {
            this.score3 = score3;
        }

        public int getScore4() {
            return score4;
        }

        public void setScore4(int score4) {
            this.score4 = score4;
        }

        public int getScore3_1() {
            return score3_1;
        }

        public void setScore3_1(int score3_1) {
            this.score3_1 = score3_1;
        }

        public String getIdentity_num() {
            return identity_num;
        }

        public void setIdentity_num(String identity_num) {
            this.identity_num = identity_num;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getBank_num() {
            return bank_num;
        }

        public void setBank_num(String bank_num) {
            this.bank_num = bank_num;
        }

        public String getBank_address() {
            return bank_address;
        }

        public void setBank_address(String bank_address) {
            this.bank_address = bank_address;
        }

        public long getAdd_time() {
            return add_time;
        }

        public void setAdd_time(long add_time) {
            this.add_time = add_time;
        }

        public long getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(long update_time) {
            this.update_time = update_time;
        }

        public long getFenhong_time() {
            return fenhong_time;
        }

        public void setFenhong_time(long fenhong_time) {
            this.fenhong_time = fenhong_time;
        }

        public long getChangeInfo_time() {
            return changeInfo_time;
        }

        public void setChangeInfo_time(long changeInfo_time) {
            this.changeInfo_time = changeInfo_time;
        }
    }
}
