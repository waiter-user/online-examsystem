package com.java.mapper;

import com.java.pojo.Paper;
import com.java.pojo.Subject;
import com.java.vo.SubjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    //查询所有试题
    List<Subject> selectList(@Param("content") String scontent);
    //根据试卷名称查询试题列表
    List<Subject> selectListByPname(String pname);
    //查询试题名称和id
    List<Subject> selectListForPaper();
    //查询用户的错题库
    List<SubjectVO> selectListById(Integer userid);
    //查询用户的某个试卷错题库
    List<SubjectVO> selectListByIdAndPname(@Param("id") Integer userid,@Param("pname") String pname);

}