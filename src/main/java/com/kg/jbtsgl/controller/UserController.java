package com.kg.jbtsgl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kg.jbtsgl.pojo.User;


@Controller
@RequestMapping(value="/Manager")
public class UserController extends BaseController{
	@RequestMapping(value="/Login")
	public  ModelAndView login(String username,String password ){
		ModelAndView mv = new ModelAndView();
		User user  = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(username!=null&&password!=null){
			User user1= userService.login(user);
			mv.addObject("user", user1);
			mv.setViewName("Index.jsp");
		}
		return mv;
	}
	@RequestMapping(value="/Logout")
	public  ModelAndView logout(){
		ModelAndView mv = new ModelAndView();
		mv.clear();
		mv.setViewName("Login.jsp");
		return mv;
	}
}
