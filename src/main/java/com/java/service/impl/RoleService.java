package com.java.service.impl;

import com.java.mapper.SysroleMapper;
import com.java.pojo.Sysrole;
import com.java.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private SysroleMapper sysroleMapper;

    @Override
    public List<Sysrole> getAll() {
        List<Sysrole> sysroles = sysroleMapper.selectList();
        return sysroles;
    }
}
