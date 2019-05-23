package com.honor.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 查看JDK自动生成的代理类源码
 *
 * @author sky
 */
public class ViewProxyClass {
    public static void main(String[] args) throws Exception {
        Game zs = new GamePalyer("张三");
        ClassLoader classLoader = zs.getClass().getClassLoader();
        Class<?>[] interfaces = zs.getClass().getInterfaces();
        Game proxy = (Game) Proxy.newProxyInstance(classLoader, interfaces, new GameIH(zs));
        System.out.println(proxy.getClass());
        proxy.paly();
        byte[] bts = ProxyGenerator.generateProxyClass("$GameProxy", interfaces);
        FileOutputStream fos = new FileOutputStream(new File("E:/$GameProxy.class"));
        fos.write(bts);
        fos.flush();
        fos.close();
    }
}

interface Game {
    public void paly();
}

class GamePalyer implements Game {
    private String name;

    public GamePalyer(String name) {
        this.name = name;
    }

    @Override
    public void paly() {
        System.out.println(this.name + " playing ...");
    }
}

class GameIH implements InvocationHandler {
    private Game target;

    public GameIH(Game target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(target + "被代理");
        method.invoke(this.target, args);
        return proxy;
    }
}