package com.example.shiyuankeji.bean;

import java.util.List;

public class NewIndentBean {
    private List<OrderListListBean> order_listList;

    public List<OrderListListBean> getOrder_listList() {
        return order_listList;
    }

    public void setOrder_listList(List<OrderListListBean> order_listList) {
        this.order_listList = order_listList;
    }

    public static class OrderListListBean {
        /**
         * id : 2
         * order_num : 1001011
         * order_state : 2
         * num : 1
         * addressid : 87
         * idsa : 2222
         * userid : 8
         * item_freight : 0
         * order_price : 800
         * paymentPrice : 600
         * payPoints : 300
         * paymentMethod : 1
         * create_time : 2020-06-12
         * payment_time : 2020-06-22T14:58:46.000+0000
         * tab_user : null
         * user_address : {"id":0,"user_name":"","is_default":0,"name":"","phone":"","address":""}
         * items : {"id":2,"idsa":2222,"name":"大大泡泡糖","img":"https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg","img2":"22","imges":"https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg","code_price":1,"src_price_code":1,"rmb_price":500,"src_price_rmb":0,"stock":500,"weight":1,"cateid":1,"isshow":1,"imgs":"https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg","freight":1,"buynum":2,"des":"","list":"","times":"2020-06-20T09:43:13.000+0000","addtime":"2020-06-05T14:22:36.000+0000","listing_Time":"2020-06-22T08:15:43.215+0000","offshelf_Time":"2020-06-22T08:15:43.215+0000","cate":{"id":0,"cateid":0,"name":"","weight":0,"isshow":1,"itemsList":[]}}
         */

        private int id;
        private String order_num;
        private int order_state;
        private int num;
        private int addressid;
        private int idsa;
        private int userid;
        private int item_freight;
        private int order_price;
        private int paymentPrice;
        private int payPoints;
        private int paymentMethod;
        private String create_time;
        private String payment_time;
        private Object tab_user;
        private UserAddressBean user_address;
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

        public int getOrder_state() {
            return order_state;
        }

        public void setOrder_state(int order_state) {
            this.order_state = order_state;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getAddressid() {
            return addressid;
        }

        public void setAddressid(int addressid) {
            this.addressid = addressid;
        }

        public int getIdsa() {
            return idsa;
        }

        public void setIdsa(int idsa) {
            this.idsa = idsa;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getItem_freight() {
            return item_freight;
        }

        public void setItem_freight(int item_freight) {
            this.item_freight = item_freight;
        }

        public int getOrder_price() {
            return order_price;
        }

        public void setOrder_price(int order_price) {
            this.order_price = order_price;
        }

        public int getPaymentPrice() {
            return paymentPrice;
        }

        public void setPaymentPrice(int paymentPrice) {
            this.paymentPrice = paymentPrice;
        }

        public int getPayPoints() {
            return payPoints;
        }

        public void setPayPoints(int payPoints) {
            this.payPoints = payPoints;
        }

        public int getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(int paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getPayment_time() {
            return payment_time;
        }

        public void setPayment_time(String payment_time) {
            this.payment_time = payment_time;
        }

        public Object getTab_user() {
            return tab_user;
        }

        public void setTab_user(Object tab_user) {
            this.tab_user = tab_user;
        }

        public UserAddressBean getUser_address() {
            return user_address;
        }

        public void setUser_address(UserAddressBean user_address) {
            this.user_address = user_address;
        }

        public ItemsBean getItems() {
            return items;
        }

        public void setItems(ItemsBean items) {
            this.items = items;
        }

        public static class UserAddressBean {
            /**
             * id : 0
             * user_name :
             * is_default : 0
             * name :
             * phone :
             * address :
             */

            private int id;
            private String user_name;
            private int is_default;
            private String name;
            private String phone;
            private String address;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
        }

        public static class ItemsBean {
            /**
             * id : 2
             * idsa : 2222
             * name : 大大泡泡糖
             * img : https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg
             * img2 : 22
             * imges : https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg
             * code_price : 1
             * src_price_code : 1
             * rmb_price : 500
             * src_price_rmb : 0
             * stock : 500
             * weight : 1.0
             * cateid : 1
             * isshow : 1
             * imgs : https://cdn.knowfate.com.cn/web/images/product/10.00/1.jpg
             * freight : 1
             * buynum : 2
             * des :
             * list :
             * times : 2020-06-20T09:43:13.000+0000
             * addtime : 2020-06-05T14:22:36.000+0000
             * listing_Time : 2020-06-22T08:15:43.215+0000
             * offshelf_Time : 2020-06-22T08:15:43.215+0000
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

//    private List<OrderListsBean> order_lists;
//
//    public List<OrderListsBean> getOrder_lists() {
//        return order_lists;
//    }
//
//    public void setOrder_lists(List<OrderListsBean> order_lists) {
//        this.order_lists = order_lists;
//    }
//
//    public static class OrderListsBean {
//        /**
//         * id : 26
//         * name : sf005
//         * order_num : 1583806859353
//         * order_state : 0
//         * num : 1
//         * user_name : 在上
//         * user_phone : 13865495796
//         * user_add : 去上睡起来了战胜自己玩凸环球政
//         * user_id : 8
//         * create_time : 2020-03-10T10:21:00.000+0000
//         * item_img : https://cdn.knowfate.com.cn/web/images/product/xxkjpdj/00.jpg
//         * item_name : 小西科技拼读机
//         * item_price : 499
//         * item_freight : 10
//         * order_price : 0
//         */
//
//        private int id;
//        private String name;
//        private String order_num;
//        private int order_state;
//        private int num;
//        private String user_name;
//        private String user_phone;
//        private String user_add;
//        private int user_id;
//        private String create_time;
//        private String item_img;
//        private String item_name;
//        private int item_price;
//        private int item_freight;
//        private int order_price;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getOrder_num() {
//            return order_num;
//        }
//
//        public void setOrder_num(String order_num) {
//            this.order_num = order_num;
//        }
//
//        public int getOrder_state() {
//            return order_state;
//        }
//
//        public void setOrder_state(int order_state) {
//            this.order_state = order_state;
//        }
//
//        public int getNum() {
//            return num;
//        }
//
//        public void setNum(int num) {
//            this.num = num;
//        }
//
//        public String getUser_name() {
//            return user_name;
//        }
//
//        public void setUser_name(String user_name) {
//            this.user_name = user_name;
//        }
//
//        public String getUser_phone() {
//            return user_phone;
//        }
//
//        public void setUser_phone(String user_phone) {
//            this.user_phone = user_phone;
//        }
//
//        public String getUser_add() {
//            return user_add;
//        }
//
//        public void setUser_add(String user_add) {
//            this.user_add = user_add;
//        }
//
//        public int getUser_id() {
//            return user_id;
//        }
//
//        public void setUser_id(int user_id) {
//            this.user_id = user_id;
//        }
//
//        public String getCreate_time() {
//            return create_time;
//        }
//
//        public void setCreate_time(String create_time) {
//            this.create_time = create_time;
//        }
//
//        public String getItem_img() {
//            return item_img;
//        }
//
//        public void setItem_img(String item_img) {
//            this.item_img = item_img;
//        }
//
//        public String getItem_name() {
//            return item_name;
//        }
//
//        public void setItem_name(String item_name) {
//            this.item_name = item_name;
//        }
//
//        public int getItem_price() {
//            return item_price;
//        }
//
//        public void setItem_price(int item_price) {
//            this.item_price = item_price;
//        }
//
//        public int getItem_freight() {
//            return item_freight;
//        }
//
//        public void setItem_freight(int item_freight) {
//            this.item_freight = item_freight;
//        }
//
//        public int getOrder_price() {
//            return order_price;
//        }
//
//        public void setOrder_price(int order_price) {
//            this.order_price = order_price;
//        }
//    }

}
