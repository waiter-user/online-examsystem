package com.java.controller;

import com.github.pagehelper.PageInfo;
import com.java.pojo.Sysfunction;
import com.java.pojo.Sysrole;
import com.java.pojo.Sysuser;
import com.java.service.IFunService;
import com.java.service.IUserService;
import com.java.service.impl.PaperService;
import com.java.service.impl.RoleService;
import com.java.vo.PaperVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理用户相关的请求
 */
@Controller
public class UserController {
    @Resource
    private IUserService iUserServiceImpl;
    @Resource
    private IFunService ifunServiceImpl;
    @Resource
    private RoleService roleService;
    @Resource
    private PaperService paperService;

    /**
     * 用户登录  r表示admin或者student
     *
     * @param sysuser
     * @param r
     * @return
     */
    @RequestMapping("/userLogin/{r}")
    public String login(Sysuser sysuser, @PathVariable("r") String r, HttpServletRequest request) {
        //调用service的业务方法，
        Sysuser loginUser = iUserServiceImpl.login(sysuser, r);
        if (null != loginUser) {
            //登陆成功，将用户存储到session中
            request.getSession().setAttribute("user", loginUser);
            //进行不同的跳转
            if (r.equals("admin")) {
                //获取到管理员能操作的菜单
                Integer roleid = loginUser.getRoleid();
                //获取系统功能列表
                List<Sysfunction> list = ifunServiceImpl.getList(roleid);
                request.setAttribute("funList", list);
                //跳转到管理员主页上
                return "index";
            } else {
                //获取试题信息
                List<PaperVO> paperList = paperService.getPaperList();
                request.setAttribute("paperList",paperList);
                //跳转到学生主页
                return "user/index";
            }
        }
        //将错误的信息存储到request域中
        request.setAttribute("msg", "用户名或密码错误");
        return "login";
    }

    @RequestMapping("/userlogOut")
    public String logOut(HttpSession session) {
        //销毁session
        session.invalidate();
        //跳转到登录页面
        return "redirect:/";
    }

    /**
     * 分页查询用户
     * @param pageNum
     * @param pageSize
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value = "/sys/user",params = {"cmd=list"})
    public String queryByPagae(@RequestParam(name = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize",required = false, defaultValue = "3") Integer pageSize,
                               String username,Model model){
        PageInfo<Sysuser> pageInfo = iUserServiceImpl.getPageInfo(pageNum, pageSize, username);
        model.addAttribute("username",username);
        model.addAttribute("pageInfo",pageInfo);
        return "sys/user/list";
    }

    /**
     * 准备添加，跳转到添加页面
     * @return
     */
    @RequestMapping("/sys/user/toAdd")
    public String toAdd(Model model){
        List<Sysrole> sysroles = roleService.getAll();
        model.addAttribute("roles",sysroles);
        return "user/add";
    }

    /***
     * 添加用户
     * @param sysuser
     * @return
     */
    @RequestMapping("/sys/user/add")
    public String add(Sysuser sysuser){
        iUserServiceImpl.addUser(sysuser);
        return "redirect:/sys/user?cmd=list";
    }

    /**
     * 准备修改，获取用户数据，跳转到修改页面
     * @param
     * @return
     */
    @RequestMapping("/sys/user/toEdit/{userid}")
    public String toEdit(@PathVariable("userid") Integer userid,Model model){
        List<Sysrole> sysroles = roleService.getAll();
        model.addAttribute("roles",sysroles);
        Sysuser user = iUserServiceImpl.getUser(userid);
        model.addAttribute("user",user);
        return "redirect:/sys/user/edit";
    }

    /**
     * 修改用户
     * @param sysuser
     * @return
     */
    @RequestMapping("/sys/user/edit")
    public String edit(Sysuser sysuser){
        iUserServiceImpl.updateUser(sysuser);
        return "redirect:/sys/user?cmd=list";
    }
}
