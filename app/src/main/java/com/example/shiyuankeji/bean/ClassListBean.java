package com.example.shiyuankeji.bean;

import java.util.List;

public class ClassListBean {

    /**
     * cateList : null
     * itemsList : [{"id":null,"idsa":3013,"name":"女性疾病易感基因检测","img":"https://cdn.knowfate.com.cn/web/images/product/jyjc/ygjyjc00.png","img2":null,"code_price":6880,"src_price_code":599,"stock":null,"weight":0,"cateid":null,"isshow":1,"imgs":null,"freight":null,"buynum":null,"des":null,"list":null,"times":null,"addtime":null,"listing_Time":null,"offshelf_Time":null,"cate":null},{"id":null,"idsa":3011,"name":"儿童天赋能力基因检测","img":"https://cdn.knowfate.com.cn/web/images/product/jyjc/ettf00.png","img2":null,"code_price":1580,"src_price_code":2658,"stock":null,"weight":0,"cateid":null,"isshow":1,"imgs":null,"freight":null,"buynum":null,"des":null,"list":null,"times":null,"addtime":null,"listing_Time":null,"offshelf_Time":null,"cate":null}]
     */

    private Object cateList;
    private List<ItemsListBean> itemsList;

    public Object getCateList() {
        return cateList;
    }

    public void setCateList(Object cateList) {
        this.cateList = cateList;
    }

    public List<ItemsListBean> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsListBean> itemsList) {
        this.itemsList = itemsList;
    }

    public static class ItemsListBean {
        /**
         * id : null
         * idsa : 3013
         * name : 女性疾病易感基因检测
         * img : https://cdn.knowfate.com.cn/web/images/product/jyjc/ygjyjc00.png
         * img2 : null
         * code_price : 6880
         * src_price_code : 599
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
        private int code_price;
        private int src_price_code;
        private  int rmb_price;
        private  int src_price_rmb;

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

        public int getRmb_price() {
            return rmb_price;
        }

        public void setRmb_price(int rmb_price) {
            this.rmb_price = rmb_price;
        }

        public int getSrc_price_rmb() {
            return src_price_rmb;
        }

        public void setSrc_price_rmb(int src_price_rmb) {
            this.src_price_rmb = src_price_rmb;
        }

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

        public int getCode_price() {
            return code_price;
        }

        public void setCode_price(int code_price) {
            this.code_price = code_price;
        }

        public int getSrc_price_code() {
            return src_price_code;
        }

        public void setSrc_price_code(int src_price_code) {
            this.src_price_code = src_price_code;
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
