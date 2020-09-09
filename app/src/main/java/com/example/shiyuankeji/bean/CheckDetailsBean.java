package com.example.shiyuankeji.bean;

import java.util.List;

public class CheckDetailsBean {

    private List<NotShareInfoVoBean> notShareInfoVo;
    private List<NotMonthShareInfosBean> notMonthShareInfos;
    private List<NotSeasonShareInfosBean> notSeasonShareInfos;
    private List<NotYearShareInfosBean> notYearShareInfos;
    private List<AlreadyShareInfoVoBean> alreadyShareInfoVo;

    public List<NotShareInfoVoBean> getNotShareInfoVo() {
        return notShareInfoVo;
    }

    public void setNotShareInfoVo(List<NotShareInfoVoBean> notShareInfoVo) {
        this.notShareInfoVo = notShareInfoVo;
    }

    public List<NotMonthShareInfosBean> getNotMonthShareInfos() {
        return notMonthShareInfos;
    }

    public void setNotMonthShareInfos(List<NotMonthShareInfosBean> notMonthShareInfos) {
        this.notMonthShareInfos = notMonthShareInfos;
    }

    public List<NotSeasonShareInfosBean> getNotSeasonShareInfos() {
        return notSeasonShareInfos;
    }

    public void setNotSeasonShareInfos(List<NotSeasonShareInfosBean> notSeasonShareInfos) {
        this.notSeasonShareInfos = notSeasonShareInfos;
    }

    public List<NotYearShareInfosBean> getNotYearShareInfos() {
        return notYearShareInfos;
    }

    public void setNotYearShareInfos(List<NotYearShareInfosBean> notYearShareInfos) {
        this.notYearShareInfos = notYearShareInfos;
    }

    public List<AlreadyShareInfoVoBean> getAlreadyShareInfoVo() {
        return alreadyShareInfoVo;
    }

    public void setAlreadyShareInfoVo(List<AlreadyShareInfoVoBean> alreadyShareInfoVo) {
        this.alreadyShareInfoVo = alreadyShareInfoVo;
    }

    public static class NotShareInfoVoBean {
        /**
         * createtime : 2020-09-07
         * totalprice : 600
         * sharestate : 1
         */

        private String createtime;
        private int totalprice;
        private int sharestate;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public int getSharestate() {
            return sharestate;
        }

        public void setSharestate(int sharestate) {
            this.sharestate = sharestate;
        }
    }

    public static class NotMonthShareInfosBean {
        /**
         * createtime : 2020-11-01
         * totalprice : 500
         * sharestate : 1
         */

        private String createtime;
        private int totalprice;
        private int sharestate;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public int getSharestate() {
            return sharestate;
        }

        public void setSharestate(int sharestate) {
            this.sharestate = sharestate;
        }
    }

    public static class NotSeasonShareInfosBean {
        /**
         * createtime : 2020-11-01
         * totalprice : 500
         * sharestate : 1
         */

        private String createtime;
        private int totalprice;
        private int sharestate;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public int getSharestate() {
            return sharestate;
        }

        public void setSharestate(int sharestate) {
            this.sharestate = sharestate;
        }
    }

    public static class NotYearShareInfosBean {
        /**
         * createtime : 2020-11-01
         * totalprice : 500
         * sharestate : 1
         */

        private String createtime;
        private int totalprice;
        private int sharestate;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public int getSharestate() {
            return sharestate;
        }

        public void setSharestate(int sharestate) {
            this.sharestate = sharestate;
        }
    }

    public static class AlreadyShareInfoVoBean {
        /**
         * createtime : 2020-09-07
         * totalprice : 200
         * sharestate : 2
         */

        private String createtime;
        private int totalprice;
        private int sharestate;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public int getSharestate() {
            return sharestate;
        }

        public void setSharestate(int sharestate) {
            this.sharestate = sharestate;
        }
    }
}
