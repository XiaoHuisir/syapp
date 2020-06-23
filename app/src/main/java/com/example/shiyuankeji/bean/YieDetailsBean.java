package com.example.shiyuankeji.bean;

import java.util.List;

public class YieDetailsBean {

    /**
     * shareInfoVo : [{"order_num":"1008611","totalprice":null,"name":"识缘手机 K1","rmb_price":null,"create_time":"2020-06-12 08:00:00.0","sharetype":null}]
     * totalprice : null
     * ftotalprice : null
     * shareInfoVos : [{"order_num":null,"totalprice":500,"name":null,"rmb_price":null,"create_time":null,"sharetype":3},{"order_num":null,"totalprice":50,"name":null,"rmb_price":null,"create_time":null,"sharetype":5}]
     * ztotalprice : null
     */

    private Object totalprice;
    private Object ftotalprice;
    private Object ztotalprice;
    private List<ShareInfoVoBean> shareInfoVo;
    private List<ShareInfoVosBean> shareInfoVos;

    public Object getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Object totalprice) {
        this.totalprice = totalprice;
    }

    public Object getFtotalprice() {
        return ftotalprice;
    }

    public void setFtotalprice(Object ftotalprice) {
        this.ftotalprice = ftotalprice;
    }

    public Object getZtotalprice() {
        return ztotalprice;
    }

    public void setZtotalprice(Object ztotalprice) {
        this.ztotalprice = ztotalprice;
    }

    public List<ShareInfoVoBean> getShareInfoVo() {
        return shareInfoVo;
    }

    public void setShareInfoVo(List<ShareInfoVoBean> shareInfoVo) {
        this.shareInfoVo = shareInfoVo;
    }

    public List<ShareInfoVosBean> getShareInfoVos() {
        return shareInfoVos;
    }

    public void setShareInfoVos(List<ShareInfoVosBean> shareInfoVos) {
        this.shareInfoVos = shareInfoVos;
    }

    public static class ShareInfoVoBean {
        /**
         * order_num : 1008611
         * totalprice : null
         * name : 识缘手机 K1
         * rmb_price : null
         * create_time : 2020-06-12 08:00:00.0
         * sharetype : null
         */

        private String order_num;
        private Object totalprice;
        private String name;
        private Object rmb_price;
        private String create_time;
        private Object sharetype;

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public Object getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(Object totalprice) {
            this.totalprice = totalprice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getRmb_price() {
            return rmb_price;
        }

        public void setRmb_price(Object rmb_price) {
            this.rmb_price = rmb_price;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public Object getSharetype() {
            return sharetype;
        }

        public void setSharetype(Object sharetype) {
            this.sharetype = sharetype;
        }
    }

    public static class ShareInfoVosBean {
        /**
         * order_num : null
         * totalprice : 500
         * name : null
         * rmb_price : null
         * create_time : null
         * sharetype : 3
         */

        private Object order_num;
        private int totalprice;
        private Object name;
        private Object rmb_price;
        private Object create_time;
        private int sharetype;

        public Object getOrder_num() {
            return order_num;
        }

        public void setOrder_num(Object order_num) {
            this.order_num = order_num;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getRmb_price() {
            return rmb_price;
        }

        public void setRmb_price(Object rmb_price) {
            this.rmb_price = rmb_price;
        }

        public Object getCreate_time() {
            return create_time;
        }

        public void setCreate_time(Object create_time) {
            this.create_time = create_time;
        }

        public int getSharetype() {
            return sharetype;
        }

        public void setSharetype(int sharetype) {
            this.sharetype = sharetype;
        }
    }
}
