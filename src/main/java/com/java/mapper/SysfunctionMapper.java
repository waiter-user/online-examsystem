package com.java.mapper;

import com.java.pojo.Subject;
import com.java.pojo.Sysfunction;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SysfunctionMapper {
    int deleteByPrimaryKey(Integer funid);

    int insert(Sysfunction record);

    int insertSelective(Sysfunction record);

    Sysfunction selectByPrimaryKey(Integer funid);

    int updateByPrimaryKeySelective(Sysfunction record);

    int updateByPrimaryKey(Sysfunction record);
    //查询系统功能列表
    List<Sysfunction> selectListByRoleId(@Param("rid") Integer rid);
    //查询系统功能列表
    List<Sysfunction> selectList();
    //查询一个系统功能
    Sysfunction selectByFunId(Integer funId);
    //修改系统功能
    void updateFunction(Sysfunction  sysfunction);
    //编辑权限(系统功能)先删除，在插入
    void update(Integer[] funids,Integer roleid);
}