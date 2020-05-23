package com.example.shiyuankeji.bean;

import java.util.List;

public class ClassBean {

    private List<CateListBean> cateList;
    private List<ItemsListBean> itemsList;

    public List<CateListBean> getCateList() {
        return cateList;
    }

    public void setCateList(List<CateListBean> cateList) {
        this.cateList = cateList;
    }

    public List<ItemsListBean> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsListBean> itemsList) {
        this.itemsList = itemsList;
    }

    public static class CateListBean {
        /**
         * id : null
         * cateid : 1
         * name : 手机
         * weight : 0.0
         * isshow : 1
         * itemsList : null
         */

        private Object id;
        private int cateid;
        private String name;
        private double weight;
        private int isshow;
        private Object itemsList;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public int getCateid() {
            return cateid;
        }

        public void setCateid(int cateid) {
            this.cateid = cateid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public int getIsshow() {
            return isshow;
        }

        public void setIsshow(int isshow) {
            this.isshow = isshow;
        }

        public Object getItemsList() {
            return itemsList;
        }

        public void setItemsList(Object itemsList) {
            this.itemsList = itemsList;
        }
    }

    public static class ItemsListBean {
        /**
         * id : null
         * idsa : 1002
         * name : 识缘手机 K1
         * img : https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg
         * img2 : null
         * price : 6999
         * src_price : 7999
         * stock : null
         * weight : 0.0
         * cateid : null
         * isshow : 1
         * imgs : null
         * freight : null
         * buynum : null
         * des : null
         * list : null
         * times : null
         * addtime : null
         * listing_Time : null
         * offshelf_Time : null
         * cate : null
         */

        private Object id;
        private int idsa;
        private String name;
        private String img;
        private Object img2;
        private int price;
        private int src_price;
        private Object stock;
        private double weight;
        private Object cateid;
        private int isshow;
        private Object imgs;
        private Object freight;
        private Object buynum;
        private Object des;
        private Object list;
        private Object times;
        private Object addtime;
        private Object listing_Time;
        private Object offshelf_Time;
        private Object cate;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public int getIdsa() {
            return idsa;
        }

        public void setIdsa(int idsa) {
            this.idsa = idsa;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public Object getImg2() {
            return img2;
        }

        public void setImg2(Object img2) {
            this.img2 = img2;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSrc_price() {
            return src_price;
        }

        public void setSrc_price(int src_price) {
            this.src_price = src_price;
        }

        public Object getStock() {
            return stock;
        }

        public void setStock(Object stock) {
            this.stock = stock;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Object getCateid() {
            return cateid;
        }

        public void setCateid(Object cateid) {
            this.cateid = cateid;
        }

        public int getIsshow() {
            return isshow;
        }

        public void setIsshow(int isshow) {
            this.isshow = isshow;
        }

        public Object getImgs() {
            return imgs;
        }

        public void setImgs(Object imgs) {
            this.imgs = imgs;
        }

        public Object getFreight() {
            return freight;
        }

        public void setFreight(Object freight) {
            this.freight = freight;
        }

        public Object getBuynum() {
            return buynum;
        }

        public void setBuynum(Object buynum) {
            this.buynum = buynum;
        }

        public Object getDes() {
            return des;
        }

        public void setDes(Object des) {
            this.des = des;
        }

        public Object getList() {
            return list;
        }

        public void setList(Object list) {
            this.list = list;
        }

        public Object getTimes() {
            return times;
        }

        public void setTimes(Object times) {
            this.times = times;
        }

        public Object getAddtime() {
            return addtime;
        }

        public void setAddtime(Object addtime) {
            this.addtime = addtime;
        }

        public Object getListing_Time() {
            return listing_Time;
        }

        public void setListing_Time(Object listing_Time) {
            this.listing_Time = listing_Time;
        }

        public Object getOffshelf_Time() {
            return offshelf_Time;
        }

        public void setOffshelf_Time(Object offshelf_Time) {
            this.offshelf_Time = offshelf_Time;
        }

        public Object getCate() {
            return cate;
        }

        public void setCate(Object cate) {
            this.cate = cate;
        }
    }
}
