package com.honor.mybatis.mapper;

import com.honor.mybatis.model.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * Created by rongyaowen
 * on 2019/5/22.
 */
public interface SysRoleMapper {
    SysRole selectById(Integer id);

    int updateSysRole(@Param("sysRole") SysRole sysRole);
}
