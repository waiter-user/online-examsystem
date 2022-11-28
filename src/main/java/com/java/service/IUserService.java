package com.java.service;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Sysuser;

public interface IUserService {
   //登录操作
   Sysuser login(Sysuser sysuser,String r);
   //分页查询用户列表
   PageInfo<Sysuser> getPageInfo(Integer pageNum,Integer pageSize,String username);
   //添加用户
   void addUser(Sysuser sysuser);
   //根据id获取用户信息
   Sysuser getUser(Integer userid);
   //修改用户
   void updateUser(Sysuser sysuser);
}
