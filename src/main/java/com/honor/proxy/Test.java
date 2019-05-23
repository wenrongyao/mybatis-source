package com.honor.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by rongyaowen
 * on 2019/5/23.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Tank tank = new Tank();
        InvocationHandler invocationHandler = new TankHandler(tank);
        MoveAble moveAble = (MoveAble) Proxy.newProxyInstance(MoveAble.class.getClassLoader(), new Class[]{MoveAble.class},
                invocationHandler);
        moveAble.move();

//        MoveAble moveAble = (MoveAble) Proxy.newProxyInstance(MoveAble.class.getClassLoader(), new Class[]{MoveAble.class}, new TankHandler2());
//        moveAble.move();
//        byte[] bts = ProxyGenerator.generateProxyClass("$TankProxy", Tank.class.getInterfaces());
//        FileOutputStream fos = new FileOutputStream(new File("E:/$TankProxy.class"));
//        fos.write(bts);
//        fos.flush();
//        fos.close();
    }
}
