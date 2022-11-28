package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.SubjectMapper;
import com.java.pojo.Subject;
import com.java.service.ISubjectService;
import com.java.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public PageInfo<Subject> getPageInfo(Integer pageNo, Integer pageSize,String scontent) {
        //开启分页插件
        PageHelper.startPage(pageNo, pageSize);
        List<Subject> subjects = subjectMapper.selectList(scontent);
        PageInfo<Subject> pageInfo=new PageInfo<>(subjects);
        return pageInfo;
    }

    @Override
    public void addSubject(Subject subject) {
        subjectMapper.insertSelective(subject);
    }

    @Override
    public Subject getSubDetail(Integer sid) {
        Subject subject = subjectMapper.selectByPrimaryKey(sid);
        return subject;
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectMapper.updateByPrimaryKeySelective(subject);
    }

    @Override
    public List<Subject> getSubjectList(String pname) {
        List<Subject> subjects = subjectMapper.selectListByPname(pname);
        return subjects;
    }

    @Override
    public List<Subject> getSubjectList() {
        //可用试题较多的话，就返回pageInfo
        List<Subject> subjects = subjectMapper.selectListForPaper();
        return subjects;
    }

    @Override
    public List<SubjectVO> getListById(Integer userid) {
        List<SubjectVO> subjects = subjectMapper.selectListById(userid);
        return subjects;
    }

    @Override
    public List<SubjectVO> getListByIdAndPname(Integer userid, String pname) {
        List<SubjectVO> subjects = subjectMapper.selectListByIdAndPname(userid, pname);
        return subjects;
    }
}
