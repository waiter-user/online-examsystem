package com.java.mapper;

import com.java.pojo.Studentpaper;
import com.java.vo.StudentPaperVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentpaperMapper {
    int deleteByPrimaryKey(String spid);

    int insert(Studentpaper record);

    int insertSelective(Studentpaper record);

    Studentpaper selectByPrimaryKey(String spid);

    int updateByPrimaryKeySelective(Studentpaper record);

    int updateByPrimaryKey(Studentpaper record);

    //批量插入学生答题记录
    void insertBatch(@Param("papers") List<Studentpaper> studentpapers);

    //查询做题记录结果
    List<StudentPaperVO> selectPaperVOList(Integer userid);

    //查询某套试卷用户所需的最小时间
    String selectMinTime(@Param("userid") Integer userid, @Param("pname") String pname);
}