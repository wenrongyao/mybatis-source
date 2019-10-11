package com.honor.mybatis.interceptor;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by rongyaowen
 * on 2019/5/29.
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class BaseFieldInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        invocation.getMethod();
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        SqlSource sqlSource = ms.getSqlSource();
        Class<SqlSource> sqlSourceClass = (Class<SqlSource>) sqlSource.getClass();
        Field field = sqlSourceClass.getDeclaredField("sqlSource");
        field.setAccessible(true);

        SqlSource staticSqlSource = (SqlSource) field.get(sqlSource);
        Class<SqlSource> staticSqlSourceClass = (Class<SqlSource>) staticSqlSource.getClass();
        Field field1 = staticSqlSourceClass.getDeclaredField("sql");
        field1.setAccessible(true);
        String oldSql = (String) field1.get(staticSqlSource);
        System.out.println("原始sql：" + oldSql);
        String newSql = processSql(oldSql);
        field1.set(staticSqlSource, newSql);
        System.out.println("改造以后的sql：" + field1.get(staticSqlSource));
        return invocation.proceed();
    }

    /**
     * sql处理
     *
     * @param sql
     * @return
     */
    private String processSql(String sql) {
        int setIndex = sql.indexOf("set");
        String startSql = sql.substring(0, setIndex + 3);
        String endSql = sql.substring(setIndex + 3);
        StringBuilder sb = new StringBuilder();
        sb.append(startSql);
        sb.append(" last_update_by = 1");
        sb.append(",");
        sb.append(" last_update_time = SYSDATE()");
        sb.append(",");
        sb.append(endSql);
        return sb.toString();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}
