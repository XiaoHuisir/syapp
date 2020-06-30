package com.example.shiyuankeji.bean;

import java.util.List;

public class QueryEarningsBean {


    /**
     * shareInfoVo : [{"order_num":"1008611","totalprice":550,"name":"识缘手机 K1","rmb_price":6999,"create_time":"2020-06-12 00:00:00.0","img":"https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg"},{"order_num":"1001011","totalprice":150,"name":"大大泡泡糖","rmb_price":8,"create_time":"2020-06-12 00:00:00.0","img":"https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg"},{"order_num":"1000222","totalprice":1000,"name":"识缘手机 K1","rmb_price":6999,"create_time":"2020-06-22 21:20:23.0","img":"https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg"},{"order_num":"sy202006281742491379385968","totalprice":400,"name":"大大泡泡糖","rmb_price":8,"create_time":"2020-06-28 17:42:49.0","img":"https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg"}]
     * profit : 2600
     * shareInfoVos : null
     * totalprice : 400
     */

    private int profit;
    private Object shareInfoVos;
    private int totalprice;
    private List<ShareInfoVoBean> shareInfoVo;

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Object getShareInfoVos() {
        return shareInfoVos;
    }

    public void setShareInfoVos(Object shareInfoVos) {
        this.shareInfoVos = shareInfoVos;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public List<ShareInfoVoBean> getShareInfoVo() {
        return shareInfoVo;
    }

    public void setShareInfoVo(List<ShareInfoVoBean> shareInfoVo) {
        this.shareInfoVo = shareInfoVo;
    }

    public static class ShareInfoVoBean {
        /**
         * order_num : 1008611
         * totalprice : 550
         * name : 识缘手机 K1
         * rmb_price : 6999
         * create_time : 2020-06-12 00:00:00.0
         * img : https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg
         */

        private String order_num;
        private int totalprice;
        private String name;
        private int rmb_price;
        private String create_time;
        private String img;

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRmb_price() {
            return rmb_price;
        }

        public void setRmb_price(int rmb_price) {
            this.rmb_price = rmb_price;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
