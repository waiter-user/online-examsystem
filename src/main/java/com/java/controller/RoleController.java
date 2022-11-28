package com.java.controller;

import com.java.pojo.Sysfunction;
import com.java.service.IFunService;
import com.java.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private IFunService iFunService;
    @Autowired
    private IRoleService iRoleService;

    /**
     * 根据角色id和名称初始化角色，获取角色的权限跳转到列表页面
     *
     * @param rid
     * @param rolename
     * @param model
     * @return
     */
    @RequestMapping("/sys/role/initrole/{rid}/{rname}")
    public String initRole(@PathVariable("rid") Integer rid, @PathVariable("rname") String rolename, Model model) {
        //获取所有的权限(和角色id无关)
        List<Sysfunction> list = iFunService.getList(-1);
        model.addAttribute("list", list);
        List<Sysfunction> childList = iFunService.getList(rid);
        for (Sysfunction sysfunction : list) {
            for (Sysfunction childFun : childList) {
                if(sysfunction.getFunid()==childFun.getFunid()){
                    sysfunction.setChecked(true);
                }
            }
        }
        model.addAttribute("rid",rid);
        model.addAttribute("childList", childList);
        model.addAttribute("rolename", rolename);
        return "sys/role/right";
    }

    /**
     * 修改权限
     * @return
     */
    @RequestMapping("/sys/role/saveright")
    public String update(Integer [] ckrr,Integer roleid){
        iFunService.update(ckrr,roleid);
        return "redirect:/sys/role?cmd=list";
    }
}
