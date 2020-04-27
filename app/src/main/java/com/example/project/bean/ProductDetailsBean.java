package com.example.project.bean;

public class ProductDetailsBean {

    /**
     * id : 4
     * idsa : 3
     * name : 小缘在家机器人
     * img : https://cdn.knowfate.com.cn/web/images/product/201.jpg
     * img2 : 22
     * price : 13999
     * src_price : 5999
     * stock : 999
     * weight : 111.0
     * cateid : 2
     * isshow : 1
     * imgs : https://cdn.knowfate.com.cn/web/images/product/61.png,https://cdn.knowfate.com.cn/web/images/product/62.png,https://cdn.knowfate.com.cn/web/images/product/63.png,https://cdn.knowfate.com.cn/web/images/product/64.png,https://cdn.knowfate.com.cn/web/images/product/65.png,https://cdn.knowfate.com.cn/web/images/product/66.png,https://cdn.knowfate.com.cn/web/images/product/67.png,https://cdn.knowfate.com.cn/web/images/product/68.png,https://cdn.knowfate.com.cn/web/images/product/69.png,https://cdn.knowfate.com.cn/web/images/product/70.png
     * freight : 100
     * buynum : 100
     * des : 小缘机器人
     * list : 小缘机器人
     * times : 2020-04-21T14:57:43.000+0000
     * addtime : 2020-04-13T22:36:47.000+0000
     * listing_Time : null
     * offshelf_Time : null
     * cate : {"id":4,"cateid":2,"name":"小缘在家机器人","weight":111,"isshow":1,"itemsList":null}
     */

    private int id;
    private int idsa;
    private String name;
    private String img;
    private String img2;
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
         * id : 4
         * cateid : 2
         * name : 小缘在家机器人
         * weight : 111.0
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
