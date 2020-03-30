package com.yoli.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    //被代理的真实角色
    private Object obj;

    public DynamicProxy(Object obj) {
        super();
        this.obj = obj;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进货前, 和厂商洽谈并签订进货单。");
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }
        Object invoke = method.invoke(obj, args);
        System.out.println("进货后，组织发货，并支付进货款。");

        return invoke;
    }
}
