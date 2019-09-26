package com.honor.mybatis.interceptor;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by rongyaowen
 * on 2019/5/29.
 */
@Intercepts({
        @Signature(type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class})
})
public class BaseFieldInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截器拦截");
        Object result = invocation.proceed();
        return result;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
