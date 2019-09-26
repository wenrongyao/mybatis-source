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
//        Object[] args = invocation.getArgs();
//        MappedStatement mappedStatement = (MappedStatement) args[0];
//        String sqlCommandType = mappedStatement.getSqlCommandType().toString();
//        BoundSql boundSql = mappedStatement.getBoundSql(args[1]);
//        String sql = boundSql.getSql().toLowerCase();
//        String newSql;
//        if (sqlCommandType != null && sqlCommandType.equals("UPDATE")) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(sql.substring(0, sql.indexOf("set") + 3));
//            sb.append(" last_update_by = 1, last_update_time = sysdate(), ");
//            sb.append(sql.substring(sql.indexOf("set") + 3));
//            newSql = sb.toString();
//            System.out.println(newSql);
//
//            //通过反射修改sql语句
//            Field field = boundSql.getClass().getDeclaredField("sql");
//            field.setAccessible(true);
//            field.set(boundSql, newSql);
//        }
        Object result = invocation.proceed();
        return result;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
