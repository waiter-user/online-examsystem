package com.java.mapper;

import com.java.pojo.Sysrole;

import java.util.List;

public interface SysroleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Sysrole record);

    int insertSelective(Sysrole record);

    Sysrole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Sysrole record);

    int updateByPrimaryKey(Sysrole record);
    //查询所有的角色
    List<Sysrole> selectList();
}