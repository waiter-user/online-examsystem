package com.java.service.impl;

import com.java.mapper.StudentpaperMapper;
import com.java.pojo.Studentpaper;
import com.java.service.IStudentpaperService;
import com.java.vo.StudentPaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentpaperService implements IStudentpaperService {
    @Autowired
    private StudentpaperMapper studentpaperMapper;
    @Override
    public void addBatch(List<Studentpaper> list) {
        studentpaperMapper.insertBatch(list);
    }

    @Override
    public List<StudentPaperVO> getPaperVOList(Integer userid) {
        List<StudentPaperVO> studentPaperVOS = studentpaperMapper.selectPaperVOList(userid);
        for (StudentPaperVO paperVO : studentPaperVOS) {
            String s = studentpaperMapper.selectMinTime(userid, paperVO.getPname());
            paperVO.setSpid(s);
        }
        return studentPaperVOS;
    }
}
