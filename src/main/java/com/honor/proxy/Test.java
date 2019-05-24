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
//        moveAble.toString();

        // 第一个参数是类加载器，用来加载生成的代理类
        // 第二个参数是代理类实现的接口
        // 第三个参数是调用处理程序
//        MoveAble moveAble = (MoveAble) Proxy.newProxyInstance(MoveAble.class.getClassLoader(), new Class[]{MoveAble.class}, new MoveAbleHandler());
//        moveAble.move();
//        byte[] bts = ProxyGenerator.generateProxyClass("$MoveAble", Tank.class.getInterfaces());
//        FileOutputStream fos = new FileOutputStream(new File("H:/$MoveAble.class"));
//        fos.write(bts);
//        fos.flush();
//        fos.close();

//        MoveAble moveAble = new Tank();
//        Class c = moveAble.getClass();
//        System.out.println(c.getMethod("move", null).getDeclaringClass());
    }
}
