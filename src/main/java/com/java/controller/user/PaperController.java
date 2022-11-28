package com.java.controller.user;


import com.java.pojo.Subject;
import com.java.service.impl.PaperService;
import com.java.service.impl.SubjectService;

import com.java.vo.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 处理学生登陆后的事务处理
 */
@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private SubjectService subjectService;
    /**
     * 获取试卷列表
     * @return
     */
    @RequestMapping(value = "/user/paper/list")
    public String list(Model model){
        List<PaperVO> paperList = paperService.getPaperList();
        model.addAttribute("paperList",paperList);
        return "user/paper/list";
    }

    /**
     * 根据试卷名称获取试卷的题目列表
     * @param pname
     * @return
     */
    @RequestMapping("/user/paper/subjectList/{pname}")
    public String subjectList(@PathVariable("pname")String pname, Model model){
        List<Subject> subjectList = subjectService.getSubjectList(pname);
        model.addAttribute("pname",pname);
        model.addAttribute("subjects",subjectList);
        return "user/paper/paper";
    }


}
