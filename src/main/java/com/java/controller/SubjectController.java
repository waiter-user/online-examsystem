package com.java.controller;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Subject;
import com.java.pojo.Sysuser;
import com.java.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("adminSubjectController")
public class SubjectController {
    @Autowired
    private ISubjectService iSubjectService;
    /**
     * 分页查询试题
     * @param pageNum
     * @param pageSize
     * @param scontent
     * @param model
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value = "/sys/subject",params = {"cmd=list"})
    public String queryByPagae(@RequestParam(name = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize",required = false, defaultValue = "3") Integer pageSize,
                               String scontent, Model model){
        PageInfo<Subject> pageInfo = iSubjectService.getPageInfo(pageNum, pageSize, scontent);
        model.addAttribute("scontent",scontent);
        model.addAttribute("pageInfo",pageInfo);
        return "sys/subject/list";
    }

    /**
     * 准备添加试题，跳转到添加页面
     * @param
     * @return
     */
    @RequestMapping("/sys/subject/toAdd")
    public String toAdd(){
        return "sys/subject/add";
    }

    /**
     * 跳转到添加试题页面
     * @param subject
     * @return
     */
    @RequestMapping("/sys/subject/add")
    public String add(Subject subject){
        iSubjectService.addSubject(subject);
        return "redirect:sys/subject?cmd=list";
    }

    /**
     * 预修改试题
     * @param sid
     * @param model
     * @return
     */
    @RequestMapping("/sys/subject/toEdit/{sid}")
    public String toEdit(@PathVariable("sid")Integer sid,Model model){
        //获取试题数据
    Subject detail = iSubjectService.getSubDetail(sid);
    model.addAttribute("subject",detail);
    return "/sys/subject/edit";
}

    /**
     * 修改试题页面
     * @param subject
     * @return
     */
    @RequestMapping("/sys/subject/edit")
    public String edit(Subject subject){
        iSubjectService.updateSubject(subject);
    return "redirect:sys/subject?cmd=list";
    }
}
