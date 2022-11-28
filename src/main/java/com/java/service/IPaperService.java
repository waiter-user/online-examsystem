package com.java.service;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Subject;
import com.java.vo.PaperVO;

import java.util.List;

public interface IPaperService {
    //分页获取试卷列表
    PageInfo<PaperVO> getPageInfo(Integer pageNum,Integer pageSize,String pname);
    //新增试卷
    void addPaper(Integer[] sids,String pname);
    //获取试卷列表
    List<PaperVO> getPaperList();
}
