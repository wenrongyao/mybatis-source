package com.honor.mybatis.mapper;

import com.honor.mybatis.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by rongyaowen
 * on 2019/5/22.
 */
public interface SysRoleMapper {
    SysRole selectById(Integer id);

    int updateSysRole(@Param("sysRole") SysRole sysRole);

    List<SysRole> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
