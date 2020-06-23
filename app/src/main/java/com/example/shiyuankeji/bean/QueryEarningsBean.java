package com.example.shiyuankeji.bean;

import java.util.List;

public class QueryEarningsBean {


    /**
     * shareInfoVo : [{"id":0,"order_num":"1008611","userid":0,"sharetype":0,"sharestate":0,"totalprice":1050,"createtime":"2020-06-23 15:20:27","items":{"id":0,"idsa":0,"name":"识缘手机 K1","img":"","img2":"","imges":"","code_price":0,"src_price_code":0,"rmb_price":500,"src_price_rmb":0,"stock":0,"weight":0,"cateid":0,"isshow":1,"imgs":"","freight":0,"buynum":0,"des":"","list":"","times":"2020-06-23T07:20:27.921+0000","addtime":"2020-06-23T07:20:27.921+0000","listing_Time":"2020-06-23T07:20:27.921+0000","offshelf_Time":"2020-06-23T07:20:27.921+0000","cate":{"id":0,"cateid":0,"name":"","weight":0,"isshow":1,"itemsList":[]}}},{"id":0,"order_num":"1000222","userid":0,"sharetype":0,"sharestate":0,"totalprice":1000,"createtime":"2020-06-23 15:20:27","items":{"id":0,"idsa":0,"name":"识缘手机 K1","img":"","img2":"","imges":"","code_price":0,"src_price_code":0,"rmb_price":500,"src_price_rmb":0,"stock":0,"weight":0,"cateid":0,"isshow":1,"imgs":"","freight":0,"buynum":0,"des":"","list":"","times":"2020-06-23T07:20:27.921+0000","addtime":"2020-06-23T07:20:27.921+0000","listing_Time":"2020-06-23T07:20:27.921+0000","offshelf_Time":"2020-06-23T07:20:27.921+0000","cate":{"id":0,"cateid":0,"name":"","weight":0,"isshow":1,"itemsList":[]}}},{"id":0,"order_num":"1001011","userid":0,"sharetype":0,"sharestate":0,"totalprice":150,"createtime":"2020-06-23 15:20:27","items":{"id":0,"idsa":0,"name":"大大泡泡糖","img":"","img2":"","imges":"","code_price":0,"src_price_code":0,"rmb_price":500,"src_price_rmb":0,"stock":0,"weight":0,"cateid":0,"isshow":1,"imgs":"","freight":0,"buynum":0,"des":"","list":"","times":"2020-06-23T07:20:27.921+0000","addtime":"2020-06-23T07:20:27.921+0000","listing_Time":"2020-06-23T07:20:27.921+0000","offshelf_Time":"2020-06-23T07:20:27.921+0000","cate":{"id":0,"cateid":0,"name":"","weight":0,"isshow":1,"itemsList":[]}}}]
     * profit : 3700
     * ftotalprice : null
     * shareInfoVos : null
     * totalprice : 500
     */

    private int profit;
    private Object ftotalprice;
    private Object shareInfoVos;
    private int totalprice;
    private List<ShareInfoVoBean> shareInfoVo;

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Object getFtotalprice() {
        return ftotalprice;
    }

    public void setFtotalprice(Object ftotalprice) {
        this.ftotalprice = ftotalprice;
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
         * id : 0
         * order_num : 1008611
         * userid : 0
         * sharetype : 0
         * sharestate : 0
         * totalprice : 1050
         * createtime : 2020-06-23 15:20:27
         * items : {"id":0,"idsa":0,"name":"识缘手机 K1","img":"","img2":"","imges":"","code_price":0,"src_price_code":0,"rmb_price":500,"src_price_rmb":0,"stock":0,"weight":0,"cateid":0,"isshow":1,"imgs":"","freight":0,"buynum":0,"des":"","list":"","times":"2020-06-23T07:20:27.921+0000","addtime":"2020-06-23T07:20:27.921+0000","listing_Time":"2020-06-23T07:20:27.921+0000","offshelf_Time":"2020-06-23T07:20:27.921+0000","cate":{"id":0,"cateid":0,"name":"","weight":0,"isshow":1,"itemsList":[]}}
         */

        private int id;
        private String order_num;
        private int userid;
        private int sharetype;
        private int sharestate;
        private int totalprice;
        private String createtime;
        private ItemsBean items;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getSharetype() {
            return sharetype;
        }

        public void setSharetype(int sharetype) {
            this.sharetype = sharetype;
        }

        public int getSharestate() {
            return sharestate;
        }

        public void setSharestate(int sharestate) {
            this.sharestate = sharestate;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public ItemsBean getItems() {
            return items;
        }

        public void setItems(ItemsBean items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * id : 0
             * idsa : 0
             * name : 识缘手机 K1
             * img :
             * img2 :
             * imges :
             * code_price : 0
             * src_price_code : 0
             * rmb_price : 500
             * src_price_rmb : 0
             * stock : 0
             * weight : 0.0
             * cateid : 0
             * isshow : 1
             * imgs :
             * freight : 0
             * buynum : 0
             * des :
             * list :
             * times : 2020-06-23T07:20:27.921+0000
             * addtime : 2020-06-23T07:20:27.921+0000
             * listing_Time : 2020-06-23T07:20:27.921+0000
             * offshelf_Time : 2020-06-23T07:20:27.921+0000
             * cate : {"id":0,"cateid":0,"name":"","weight":0,"isshow":1,"itemsList":[]}
             */

            private int id;
            private int idsa;
            private String name;
            private String img;
            private String img2;
            private String imges;
            private int code_price;
            private int src_price_code;
            private int rmb_price;
            private int src_price_rmb;
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
            private String listing_Time;
            private String offshelf_Time;
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

            public String getListing_Time() {
                return listing_Time;
            }

            public void setListing_Time(String listing_Time) {
                this.listing_Time = listing_Time;
            }

            public String getOffshelf_Time() {
                return offshelf_Time;
            }

            public void setOffshelf_Time(String offshelf_Time) {
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
                 * id : 0
                 * cateid : 0
                 * name :
                 * weight : 0.0
                 * isshow : 1
                 * itemsList : []
                 */

                private int id;
                private int cateid;
                private String name;
                private double weight;
                private int isshow;
                private List<?> itemsList;

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

                public List<?> getItemsList() {
                    return itemsList;
                }

                public void setItemsList(List<?> itemsList) {
                    this.itemsList = itemsList;
                }
            }
        }
    }
}
