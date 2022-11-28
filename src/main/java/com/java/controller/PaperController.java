package com.java.controller;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Subject;
import com.java.service.impl.PaperService;
import com.java.service.impl.SubjectService;
import com.java.vo.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("adminPaperController")
public class PaperController {
    @Autowired
   private PaperService paperService;
    @Autowired
    private SubjectService subjectService;
    /**
     * 分页获取试卷
     * @return
     */
    @RequestMapping(value = "/sys/paper/",params = ("cmd=list"))
    public String list(@RequestParam(name = "pageNo",required = false, defaultValue = "1") Integer pageNum,
                       @RequestParam(name = "pageSize",required = false, defaultValue = "3") Integer pageSize,String pname, Model model){
        PageInfo<PaperVO> pageInfo = paperService.getPageInfo(pageNum, pageSize, pname);
        model.addAttribute("panme",pname);
        model.addAttribute("pageInfo",pageInfo);
        return "sys/paper/list";
    }

    /**
     * 根据试卷名称获取试卷的题目列表
     * @param pname
     * @return
     */
    @RequestMapping("/sys/paper/subjectList/{pname}")
    public String subjectList(@PathVariable("pname")String pname,Model model){
        List<Subject> subjectList = subjectService.getSubjectList(pname);
        model.addAttribute("subjects",subjectList);
        return "sys/paper/subjects";
    }

    /**
     * 准备添加试卷，需要获取可用的试题列表，跳转到添加页面上
     * @param model
     * @return
     */
    @RequestMapping("/sys/paper/toAdd")
    public String toAdd(Model model){
        List<Subject> subjectList = subjectService.getSubjectList();
        model.addAttribute("subjects",subjectList);
        return "sys/paper/add";
    }

    /**
     * 处理添加试卷
     * @param pname
     * @param sids
     * @param model
     * @return
     */
    @RequestMapping("/sys/paper/add")
    public String add(String pname,Integer[] sids, Model model){
        paperService.addPaper(sids,pname);
        return "redirect:/sys/paper?cmd=list";
    }
}
