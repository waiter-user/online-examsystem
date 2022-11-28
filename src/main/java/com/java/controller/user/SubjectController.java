package com.java.controller.user;

import com.java.pojo.Subject;
import com.java.service.ISubjectService;
import com.java.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SubjectController {
@Autowired
    private ISubjectService iSubjectService;

    @RequestMapping("/user/subject/errorList/{id}")
    public String geterrorList(@PathVariable("id") Integer id, Model model){
        List<SubjectVO> subjects = iSubjectService.getListById(id);
        model.addAttribute("subjects",subjects);
        return "user/paper/studenterror";
    }

    @RequestMapping("/user/subject/errorList/{id}/{pname}")
    public String geterrorList(@PathVariable("id") Integer id,@PathVariable("pname") String pname, Model model){
        List<SubjectVO> subjects = iSubjectService.getListByIdAndPname(id, pname);
        model.addAttribute("subjects",subjects);
        return "user/paper/studenterror";
    }
}
