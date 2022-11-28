package com.java.service;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Sysfunction;

import java.util.List;

/**
 * 系统功能业务接口
 */
public interface IFunService {
    List<Sysfunction> getList(Integer rid);
    //分页查询方法
    PageInfo<Sysfunction> getPageInfo(Integer pageNo,Integer pageSize);
    //添加系统功能
    void addFunction(Sysfunction sysfunction);
    //获取一个系统功能数据
    Sysfunction getSysFunction(Integer funId);
    //修改系统功能
    void updateFunction(Sysfunction sysfunction);

    void update(Integer[] funids,Integer roleid);
}
