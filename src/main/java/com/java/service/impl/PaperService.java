package com.java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.mapper.PaperMapper;
import com.java.service.IPaperService;
import com.java.vo.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//声明事务管理的注解
@Transactional
public class PaperService implements IPaperService {
    @Autowired
    PaperMapper paperMapper;

    /**
     * 分页查询试题
     * @param pageNum
     * @param pageSize
     * @param pname
     * @return
     */
    @Override
    //只读事务
    @Transactional(readOnly = true)
    public PageInfo<PaperVO> getPageInfo(Integer pageNum, Integer pageSize, String pname) {
        PageHelper.startPage(pageNum,pageSize);
        List<PaperVO> paperVOS = paperMapper.selectPaperList(pname);
        PageInfo<PaperVO> pageInfo=new PageInfo<>(paperVOS);
        return pageInfo;
    }

    /**
     * 新增试卷
     * @param sids
     * @param pname
     */
    @Override
    public void addPaper(Integer[] sids, String pname) {
        paperMapper.insertBatch(sids,pname);
    }

    /**
     * 查询试卷列表
     * @return
     */
    @Override
    public List<PaperVO> getPaperList() {
        List<PaperVO> paperVOS = paperMapper.selectPaperList(null);
        return paperVOS;
    }
}
