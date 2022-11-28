package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.RolerightMapper;
import com.java.mapper.SysfunctionMapper;
import com.java.pojo.Sysfunction;
import com.java.service.IFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FunService implements IFunService {
    @Autowired
    private SysfunctionMapper sysfunctionMapper;
    @Autowired
    private RolerightMapper rolerightMapper;
    @Override
    public List<Sysfunction> getList(Integer rid) {
        List<Sysfunction> list = sysfunctionMapper.selectListByRoleId(rid);
        return list;
    }

    @Override
    public PageInfo<Sysfunction> getPageInfo(Integer pageNo, Integer pageSize) {
        //开启分页插件
        PageHelper.startPage(pageNo,pageSize);
        List<Sysfunction> sysfunctions = sysfunctionMapper.selectList();
        PageInfo<Sysfunction> pageInfo=new PageInfo<>(sysfunctions);
        return pageInfo;
    }

    @Override
    public void addFunction(Sysfunction sysfunction) {
        sysfunctionMapper.insertSelective(sysfunction);
    }

    @Override
    public Sysfunction getSysFunction(Integer funId) {
        return sysfunctionMapper.selectByFunId(funId);
    }

    @Override
    public void updateFunction(Sysfunction sysfunction) {
        sysfunctionMapper.updateByPrimaryKeySelective(sysfunction);
    }

    @Override
    @Transactional
    //申明数组
    public void update(Integer[] funids, Integer roleid) {
        //调用mapper的删除方法，将角色和关联的权限删除掉
        rolerightMapper.deleteBatch(roleid);
        //调用mapper的批量插入方法
        rolerightMapper.insertBatch(funids,roleid);
    }
}
