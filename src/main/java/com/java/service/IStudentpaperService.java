package com.java.service;

import com.java.pojo.Studentpaper;
import com.java.vo.StudentPaperVO;

import java.util.List;

public interface IStudentpaperService {
    //批量添加
    void addBatch(List<Studentpaper> list);
    //获取某个用户的答题结果
    List<StudentPaperVO> getPaperVOList(Integer userid);
}
