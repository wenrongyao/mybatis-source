package com.honor.mybatis.model;

/**
 * Created by rongyaowen
 * on 2019/5/22.
 */
public class SysRole {
    private Integer sysRoleId;
    private String roleName;

    public Integer getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "sysRoleId=" + sysRoleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}