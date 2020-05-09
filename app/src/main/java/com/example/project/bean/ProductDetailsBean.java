package com.example.project.bean;

public class ProductDetailsBean {


    /**
     * id : 7
     * idsa : 2014
     * name : 小西科技拼读机
     * img : https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/00.jpg
     * img2 : 22
     * imges : http://bc.knowfate.com.cn/4g.html
     * price : 499
     * src_price : 5999
     * stock : 55
     * weight : 9.0
     * cateid : 4
     * isshow : 1
     * imgs : https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/01.jpg,https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/02.jpg,https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/03.jpg,https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/04.jpg,https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/05.jpg
     * freight : 10
     * buynum : 10
     * des :
     * list :
     * times : 2020-05-05T15:36:22.000+0000
     * addtime : 2020-04-13T22:36:47.000+0000
     * listing_Time : null
     * offshelf_Time : null
     * cate : {"id":7,"cateid":4,"name":"小西科技拼读机","weight":9,"isshow":1,"itemsList":null}
     */

    private int id;
    private int idsa;
    private String name;
    private String img;
    private String img2;
    private String imges;
    private int price;
    private int src_price;
    private int stock;
    private double weight;
    private int cateid;
    private int isshow;
    private String imgs;
    private int freight;
    private int buynum;
    private String des;
    private String list;
    private String times;
    private String addtime;
    private Object listing_Time;
    private Object offshelf_Time;
    private CateBean cate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImges() {
        return imges;
    }

    public void setImges(String imges) {
        this.imges = imges;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public int getIsshow() {
        return isshow;
    }

    public void setIsshow(int isshow) {
        this.isshow = isshow;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public int getFreight() {
        return freight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
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

    public CateBean getCate() {
        return cate;
    }

    public void setCate(CateBean cate) {
        this.cate = cate;
    }

    public static class CateBean {
        /**
         * id : 7
         * cateid : 4
         * name : 小西科技拼读机
         * weight : 9.0
         * isshow : 1
         * itemsList : null
         */

        private int id;
        private int cateid;
        private String name;
        private double weight;
        private int isshow;
        private Object itemsList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
}
