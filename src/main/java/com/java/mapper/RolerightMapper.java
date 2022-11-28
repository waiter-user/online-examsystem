package com.java.mapper;

import com.java.pojo.Roleright;
import org.apache.ibatis.annotations.Param;

public interface RolerightMapper {
    int deleteByPrimaryKey(Integer rrid);

    int insert(Roleright record);

    int insertSelective(Roleright record);

    Roleright selectByPrimaryKey(Integer rrid);

    int updateByPrimaryKeySelective(Roleright record);

    int updateByPrimaryKey(Roleright record);

    //根据角色编号删除和角色相关的权限
    void deleteBatch(Integer roleid);
    //批量插入
    int insertBatch(@Param("funIds") Integer[] funIds,@Param("rid") Integer roleId);
}