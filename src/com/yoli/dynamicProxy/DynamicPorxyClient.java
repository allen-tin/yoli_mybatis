package com.yoli.dynamicProxy;

import com.yoli.staticProxy.Shop;
import com.yoli.staticProxy.ShopImpl;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class DynamicPorxyClient {
    public static void main(String[] args) {

        //1.创建被代理的接口实现类的对象
        Shop shopImpl = new ShopImpl();

        /**
         * 创建代理对象,
         * 第一个参数是获得被代理的对象的类加载器;
         * 第二个参数获得被代理对象的类的所有接口;
         * 第三个参数是自定义代理类的对象
         */
        System.out.println("================================单个代理===========================");
        Shop shop = (Shop) Proxy.newProxyInstance(shopImpl.getClass().getClassLoader(), shopImpl.getClass().getInterfaces(), new DynamicProxy(shopImpl));
        shop.purchase();

        //2.代理list
        System.out.println("===============================代理list============================");
        List list = new ArrayList();
        List listInstance = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new DynamicProxy(list));
        listInstance.add("我需要进一批苹果");
        listInstance.add("我需要进一批芒果");
    }



}
