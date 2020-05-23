package com.example.shiyuankeji.bean;

import java.util.List;

public class HomeBean {


    private List<MainListBannerBean> mainList_banner;
    private List<MainListTitleBean> mainList_title;

    public List<MainListBannerBean> getMainList_banner() {
        return mainList_banner;
    }

    public void setMainList_banner(List<MainListBannerBean> mainList_banner) {
        this.mainList_banner = mainList_banner;
    }

    public List<MainListTitleBean> getMainList_title() {
        return mainList_title;
    }

    public void setMainList_title(List<MainListTitleBean> mainList_title) {
        this.mainList_title = mainList_title;
    }

    public static class MainListBannerBean {
        /**
         * id : 5
         * type1 : 1
         * type2 : 1
         * icon : 21
         * ids2 : 2014
         * image : https://cdn.knowfate.com.cn/web/images/product/201.jpg
         * weight : 80.0
         * isshow : 1
         * title_content :
         * itemsList : null
         */

        private int id;
        private int type1;
        private int type2;
        private String icon;
        private String ids2;
        private String image;
        private double weight;
        private int isshow;
        private String title_content;
        private Object itemsList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType1() {
            return type1;
        }

        public void setType1(int type1) {
            this.type1 = type1;
        }

        public int getType2() {
            return type2;
        }

        public void setType2(int type2) {
            this.type2 = type2;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIds2() {
            return ids2;
        }

        public void setIds2(String ids2) {
            this.ids2 = ids2;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public String getTitle_content() {
            return title_content;
        }

        public void setTitle_content(String title_content) {
            this.title_content = title_content;
        }

        public Object getItemsList() {
            return itemsList;
        }

        public void setItemsList(Object itemsList) {
            this.itemsList = itemsList;
        }
    }

    public static class MainListTitleBean {
        /**
         * id : 6
         * type1 : 2
         * type2 : 1
         * icon :
         * ids2 : 3011,2014,3
         * image : 222
         * weight : 100.0
         * isshow : 1
         * title_content : 抢购
         * itemsList : [{"id":null,"idsa":2014,"name":"小西科技拼读机","img":"https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/00.jpg","img2":null,"price":499,"src_price":5999,"stock":null,"weight":0,"cateid":null,"isshow":1,"imgs":null,"freight":null,"buynum":null,"des":null,"list":null,"times":null,"addtime":null,"listing_Time":null,"offshelf_Time":null,"cate":null},{"id":null,"idsa":3011,"name":"儿童天赋能力基因检测","img":"https://cdn.knowfate.com.cn/web/images/product/jyjc/ettf00.png","img2":null,"price":1580,"src_price":2658,"stock":null,"weight":0,"cateid":null,"isshow":1,"imgs":null,"freight":null,"buynum":null,"des":null,"list":null,"times":null,"addtime":null,"listing_Time":null,"offshelf_Time":null,"cate":null},{"id":null,"idsa":3,"name":"小缘在家机器人","img":"https://cdn.knowfate.com.cn/web/images/product/201.jpg","img2":null,"price":13999,"src_price":5999,"stock":null,"weight":0,"cateid":null,"isshow":1,"imgs":null,"freight":null,"buynum":null,"des":null,"list":null,"times":null,"addtime":null,"listing_Time":null,"offshelf_Time":null,"cate":null}]
         */

        private int id;
        private int type1;
        private int type2;
        private String icon;
        private String ids2;
        private String image;
        private double weight;
        private int isshow;
        private String title_content;
        private List<ItemsListBean> itemsList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType1() {
            return type1;
        }

        public void setType1(int type1) {
            this.type1 = type1;
        }

        public int getType2() {
            return type2;
        }

        public void setType2(int type2) {
            this.type2 = type2;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIds2() {
            return ids2;
        }

        public void setIds2(String ids2) {
            this.ids2 = ids2;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public String getTitle_content() {
            return title_content;
        }

        public void setTitle_content(String title_content) {
            this.title_content = title_content;
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
             * idsa : 2014
             * name : 小西科技拼读机
             * img : https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/00.jpg
             * img2 : null
             * price : 499
             * src_price : 5999
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
}
