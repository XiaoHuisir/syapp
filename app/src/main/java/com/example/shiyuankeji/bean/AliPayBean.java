package com.example.shiyuankeji.bean;

public class AliPayBean {


    /**
     * body : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2021001165677698&biz_content=%7B%22body%22%3A%22%E6%B5%8B%E8%AF%95%E6%94%AF%E4%BB%98%E5%AE%9D%E6%94%AF%E4%BB%98%22%2C%22out_trade_no%22%3A%22122%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%E6%94%AF%E4%BB%98%E5%AE%9D%22%2C%22timeout_express%22%3A%2290m%22%2C%22total_amount%22%3A%220.1%22%7D&charset=utf-8&format=JSON&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Flocalhost%3A8080%2Falipay.trade.page.pay-JAVA-UTF-8%2Fnotify_url.jsp&sign=EgjDnek2E%2BHCZVn5sbbS7fWEM3RgNH44lXjMMEZbeLlDAsSGEAteYCASQlmi27IDozgC0UOpTXuljfJCDeBYZXggRjSpHm%2BV9Gkr%2FXk62UeqdT%2FAZ%2BFs21%2F%2B8XyCRWPNvUSG6x8CTSQYI8IpgAXoZMDKo8UIdiWqme0ZaRYB7943dL6U8HnhG7ciMdxYkf1V7og351%2FGmca09A09hbVtUu2YjvSFpNLqQsToZ1%2FuTIfamwj%2Fx2YkSsQ3NU%2BubhBPLsacEHJVcIaocRIfmjCwxmw%2FfjzTmdhy6dCPvMBieW9z3n09c9%2Bb%2BfbjpyVD5LogXNMPe%2B4rXK%2F5FdtTeoweMQ%3D%3D&sign_type=RSA2&timestamp=2020-06-05+11%3A06%3A05&version=1.0
     */

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
