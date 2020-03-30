package com.yoli.staticProxy;

/**
 *
 * 代理类ShopProxy，目的是让店铺(shop)在进货前后（purchase）进行代理动作，包括进货之前的和厂商洽谈并签订进货单和进货之后组织发货，并支付进货款等动作。
 * 我们这边说的比较写意，其实对于程序来说，我们希望在程序运行前后加上权限检查，时间日志记录，事务管理等待，都需要用到代理。
 * 但是静态代理的局限在于，它只能对某一个类实现进行代理，如果按照静态代理的思路，对其他类进行系统的代理，那么需要写好多代理类，比如ShopProxy1,ShopProxy2,ActorProxyN等等，
 * 那么下面就需要动态代理，可以干预任意类的任意方法。
 */
public class StaticProxyClient {
    public static void main(String[] args) {
        Shop shop = new ShopProxy(new ShopImpl());
        shop.purchase();
    }

}
