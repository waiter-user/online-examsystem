package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.SysuserMapper;
import com.java.pojo.Sysuser;
import com.java.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private SysuserMapper sysuserMapper;
    @Override
    public Sysuser login(Sysuser user,String r) {
        Sysuser sysuser=null;
        if(r.equals("admin")){
            sysuser=sysuserMapper.selectAdminByLogin(user);
        }else{
            sysuser=sysuserMapper.selectStudentByLogin(user);
        }
        return sysuser;
    }

    @Override
    public PageInfo<Sysuser> getPageInfo(Integer pageNum, Integer pageSize, String username) {
        //开启分页插件
        PageHelper.startPage(pageNum,pageSize);
        List<Sysuser> sysusers = sysuserMapper.selectList(username);
        PageInfo<Sysuser> pageInfo=new PageInfo<>(sysusers);
        return pageInfo;
    }

    @Override
    public void addUser(Sysuser sysuser) {
        sysuserMapper.insertSelective(sysuser);
    }

    @Override
    public Sysuser getUser(Integer userid) {
        Sysuser sysuser = sysuserMapper.selectByPrimaryKey(userid);
        return sysuser;
    }

    @Override
    public void updateUser(Sysuser sysuser) {
        sysuserMapper.updateByPrimaryKeySelective(sysuser);
    }
}
