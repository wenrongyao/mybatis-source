package com.honor.mybatis;

import com.honor.mybatis.mapper.SysRoleMapper;
import com.honor.mybatis.model.SysRole;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rongyaowen
 * on 2019/5/22.
 */
public class Test {
    public static void main(String[] args) {
        try {
            String resource = "mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = sysRoleMapper.selectById(1);
            System.out.println(sysRole);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
