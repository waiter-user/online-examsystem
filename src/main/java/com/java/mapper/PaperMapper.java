package com.java.mapper;

import com.java.pojo.Paper;
import com.java.vo.PaperVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
    //分组查询试卷列表
    List<PaperVO> selectPaperList(@Param("pname") String pname);
    //批量添加试卷
    void insertBatch(@Param("sids") Integer[] sids,@Param("pname") String pname);
}