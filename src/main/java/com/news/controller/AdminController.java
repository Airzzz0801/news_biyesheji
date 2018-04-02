package com.news.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.news.entity.Admin;
import com.news.service.AdminService;

@Controller
@SessionAttributes("user")
public class AdminController {
	
	@Resource
	AdminService adminservice;
	
	@RequestMapping("admin")
	public ModelAndView adminlogin(HttpServletRequest request,ModelMap map,HttpSession session){
		/*if (request.getParameter("username")==null&&request.getParameter("password")==null) {
			return "admin_login";
		}
		List<Admin> admins = adminservice.getAllAdmins();
		for(Iterator<Admin> iterator = admins.iterator();iterator.hasNext();){
			Admin admin = iterator.next();
			if(request.getParameter("username").equals(admin.getUsername())&&request.getParameter("password").equals(admin.getPassword()))
			{
				map.addAttribute("admin",admin);
				session.setAttribute("user", admin);
				return"forward:/changeNews.html";
		}
		}
		map.put("message", "账号密码错误");
		return "admin_login";*/
		 // 表面校验
		if (request.getParameter("username")==null&&request.getParameter("password")==null) {
			return new ModelAndView("admin_login");
		}
		Admin user = new Admin();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
       
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        try{
            // 调用安全认证框架的登录方法
            subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
        }catch(AuthenticationException ex){
            System.out.println("登陆失败: " + ex.getMessage());
            return new ModelAndView("admin_login")
                    .addObject("message", "用户不存在")
                    .addObject("failuser", user);
        }
        // 登录成功后重定向到首页
        session.setAttribute("user", user);
        return new ModelAndView("redirect:/changeNews.html");
    }
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("admin");
		return "admin_login";
	}
	
/*	@ModelAttribute("abc")
	public String lllz(){
		return "123";
	}
	
	@RequestMapping("123")
	public ModelAndView s123(@PathVariable("regexp1") String regexp1,@ModelAttribute("abc") String sr1){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin_login");
		modelAndView.addObject("ssss", "123");
		return modelAndView;
	}*/
}
