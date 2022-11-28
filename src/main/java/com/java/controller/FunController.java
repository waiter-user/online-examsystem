package com.java.controller;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Sysfunction;
import com.java.service.IFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
public class FunController {
    @Autowired
    private IFunService iFunService;

    /**
     * 分页显示系统功能
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/sys/fun/",params = {"cmd=list"})
    public String funList(@RequestParam(name = "pageNo",required = false, defaultValue = "1") Integer pageNo,
                            @RequestParam(name = "pageSize",required = false, defaultValue = "3") Integer pageSize, Model model){
        PageInfo<Sysfunction> pageInfo = iFunService.getPageInfo(pageNo, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "sys/function/list";
    }

    /**
     * 跳转到添加顶级功能页面
     * @return
     */
    @RequestMapping("/sys/fun/toAdd")
    public String toAdd(){
        return "sys/function/add";
    }

    /**
     * 添加顶级功能
     * @return
     */
    @RequestMapping("/sys/fun/add")
    public String add(Sysfunction sysfunction){
        iFunService.addFunction(sysfunction);
        return "redirect:sys/fun?cmd=list";
    }
    @RequestMapping("/sys/fun/toEdit/{funid}")
    public String toEdit(@PathVariable("funid") Integer funId,Model model){
        //获取系统功能数据
        Sysfunction sysFunction = iFunService.getSysFunction(funId);
        model.addAttribute("fun",sysFunction);
        return "sys/function/edit";
    }
    /**
     * 修改系统功能
     * @param sysfunction
     * @return
     */
    @RequestMapping("/sys/fun/edit")
    public String edit(Sysfunction sysfunction){
        iFunService.updateFunction(sysfunction);
        return "redirect:sys/fun?cmd=list";
    }

    /**
     * 跳转到添加子功能页面
     * @param pname
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("/sys/fun/toAddSubFun/{pname}/{pid}")
    public String toAddSubFun(@PathVariable("pname") String pname,@PathVariable("pid") Integer pid,Model model){
        //存储到model域
        model.addAttribute("pname",pname);
        model.addAttribute("pid",pid);
        return "sys/function/addSubFun";
    }

    /**
     * 添加子功能
     * @param sysfunction
     * @return
     */
    @RequestMapping("/sys/fun/addSubFun")
    public String addSubFun(Sysfunction sysfunction){
        iFunService.addFunction(sysfunction);
        return "redirect:sys/fun?cmd=list";
    }
}
