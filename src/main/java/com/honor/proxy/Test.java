package com.honor.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by rongyaowen
 * on 2019/5/23.
 */
public class Test {
    public static void main(String[] args) {
//        InvocationHandler invocationHandler = new TankHandler(new Tank());
//        MoveAble moveAble = (MoveAble) Proxy.newProxyInstance(MoveAble.class.getClassLoader(), new Class[]{MoveAble.class},
//                invocationHandler);
//        moveAble.move();

        MoveAble moveAble = (MoveAble) Proxy.newProxyInstance(MoveAble.class.getClassLoader(), new Class[]{MoveAble.class}, new TankHandler2());
        moveAble.move();
    }
}
