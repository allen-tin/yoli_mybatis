package com.yoli.staticProxy;

public class ShopImpl implements Shop {
    @Override
    public void purchase() {
        System.out.println("我需要进一批货。。");
    }
}
