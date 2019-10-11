package com.honor.test;

import com.github.pagehelper.util.MetaObjectUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by rongyaowen
 * on 2019/10/10.
 */
public class MetaObjectUtilTest {

    @Test
    public void test0010() {
        User user = new User("张三", 20);

        MetaObject metaObject = MetaObjectUtil.forObject(user);
//        MetaObject metaObject = MetaObject.forObject(user, null, null, null);
        System.out.println(metaObject.getValue("name"));
    }

    @Test
    public void test0020() throws Exception {
        User user = new User("张三", 20);

        Class<User> userClass = (Class<User>) user.getClass();
        Field field = userClass.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(user));

        field.set(user, "李四");

        System.out.println(field.get(user));
    }
}
