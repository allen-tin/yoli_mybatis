package com.yoli.staticProxy;

public class ShopProxy  implements Shop{

    //真实角色
    private Shop shop;

    public ShopProxy(Shop shop) {
        this.shop = shop;
    }


    @Override
    public void purchase() {
        System.out.println("进货前, 和厂商洽谈并签订进货单。");
        shop.purchase();
        System.out.println("进货后，组织发货，并支付进货款。");
    }
}
