package com.honor.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by rongyaowen
 * on 2019/5/23.
 */
public class TankHandler implements InvocationHandler {

    private MoveAble moveAble;

    public TankHandler(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getDeclaringClass());
        System.out.println("代理开始");
        Object object = method.invoke(moveAble, args);
        System.out.println("代理结束");
        return object;
    }
}
