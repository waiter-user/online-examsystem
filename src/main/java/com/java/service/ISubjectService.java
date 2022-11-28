package com.java.service;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Subject;
import com.java.vo.SubjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ISubjectService {

    //分页查询方法
    PageInfo<Subject> getPageInfo(Integer pageNo, Integer pageSize,String scontent);
    //添加试题
    void addSubject(Subject subject);
    //获取试题信息
    Subject getSubDetail(Integer sid);
    //修改试题
    void updateSubject(Subject subject);
    //根据试卷名称获取试题列表
    List<Subject> getSubjectList(String panme);
    //获取试题列表（组试卷）
    List<Subject> getSubjectList();
    //获取用户的错题库
    List<SubjectVO> getListById(Integer userid);
    //获取用户的某个试卷错题库
    List<SubjectVO> getListByIdAndPname(@Param("id") Integer userid, @Param("pname") String pname);
}
