package com.java.mapper;

import com.java.pojo.Sysuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysuserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    Sysuser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);
    //查找管理员
    Sysuser selectAdminByLogin(Sysuser sysuser);
    //查找学生
    Sysuser selectStudentByLogin(Sysuser sysuser);
    //查询用户列表(不想用Parma默认注解，并且要在动态的SQL标签中通过key获取该参数值，就必须用@parm("xxx")
    // 不用动态SQL标签，且参数只有一个时，这是要用#{xxx},xxx可以任意)
    List<Sysuser> selectList(@Param("username") String username);
}