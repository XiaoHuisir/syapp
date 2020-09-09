package com.example.shiyuankeji.bean;

import java.util.List;

public class SeeMoreBean {

    private List<GrantShareInfoVoBean> grantShareInfoVo;

    public List<GrantShareInfoVoBean> getGrantShareInfoVo() {
        return grantShareInfoVo;
    }

    public void setGrantShareInfoVo(List<GrantShareInfoVoBean> grantShareInfoVo) {
        this.grantShareInfoVo = grantShareInfoVo;
    }

    public static class GrantShareInfoVoBean {
        /**
         * totalprice : 5000
         * createtime : 2019-10
         * grantShareInfoVo2 : [{"create":"2019-10-02","monthTotal":"5000"}]
         * monthTatalPrice : 2019-10   (总:5000)
         */

        private String totalprice;
        private String createtime;
        private String monthTatalPrice;
        private List<GrantShareInfoVo2Bean> grantShareInfoVo2;

        public String getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(String totalprice) {
            this.totalprice = totalprice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getMonthTatalPrice() {
            return monthTatalPrice;
        }

        public void setMonthTatalPrice(String monthTatalPrice) {
            this.monthTatalPrice = monthTatalPrice;
        }

        public List<GrantShareInfoVo2Bean> getGrantShareInfoVo2() {
            return grantShareInfoVo2;
        }

        public void setGrantShareInfoVo2(List<GrantShareInfoVo2Bean> grantShareInfoVo2) {
            this.grantShareInfoVo2 = grantShareInfoVo2;
        }

        public static class GrantShareInfoVo2Bean {
            /**
             * create : 2019-10-02
             * monthTotal : 5000
             */

            private String create;
            private String monthTotal;

            public String getCreate() {
                return create;
            }

            public void setCreate(String create) {
                this.create = create;
            }

            public String getMonthTotal() {
                return monthTotal;
            }

            public void setMonthTotal(String monthTotal) {
                this.monthTotal = monthTotal;
            }
        }
    }
}
