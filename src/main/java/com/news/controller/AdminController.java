package com.news.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
@SessionAttributes("admin")
public class AdminController {
	
	@Resource
	AdminService adminservice;
	
	@RequestMapping("admin")
	public String adminlogin(HttpServletRequest request,ModelMap map){
		if (request.getParameter("username")==null&&request.getParameter("password")==null) {
			return "admin_login";
		}
		List<Admin> admins = adminservice.getAllAdmins();
		for(Iterator<Admin> iterator = admins.iterator();iterator.hasNext();){
			Admin admin = iterator.next();
			if(request.getParameter("username").equals(admin.getUsername())&&request.getParameter("password").equals(admin.getPassword()))
			{
				map.addAttribute("admin",admin);
				return"forward:/changeNews.html";
		}
		}
		map.put("message", "账号密码错误");
		return "admin_login";
		}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("admin");
		return "admin_login";
	}
	
	@ModelAttribute("abc")
	public String lllz(){
		return "123";
	}
	
	@RequestMapping("123")
	public ModelAndView s123(@PathVariable("regexp1") String regexp1,@ModelAttribute("abc") String sr1){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin_login");
		modelAndView.addObject("ssss", "123");
		return modelAndView;
	}
}
