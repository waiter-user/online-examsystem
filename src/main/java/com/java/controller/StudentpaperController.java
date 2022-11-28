package com.java.controller;

import com.java.pojo.Studentpaper;
import com.java.service.IStudentpaperService;
import com.java.vo.StudentPaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentpaperController {
    @Autowired
    private IStudentpaperService iStudentpaperService;

    @RequestMapping("/user/studentpaper/add")
    @ResponseBody
    public String add(@RequestBody List<Studentpaper> list) {
        String spid = null;
        for (Studentpaper studentpaper : list) {
            //获取当前时间
            spid =String.valueOf(System.currentTimeMillis());
            try {
                //当前线程睡眠5ms
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            studentpaper.setSpid(spid);
        }
        iStudentpaperService.addBatch(list);
        return "ok";
    }

    @RequestMapping("/user/studentpaper/list/{uid}")
    public String list(@PathVariable("uid") Integer uid, Model model) {
        List<StudentPaperVO> paperVOList = iStudentpaperService.getPaperVOList(uid);
        model.addAttribute("paperVOList",paperVOList);
        return "user/paper/studentpaper";
    }

}
