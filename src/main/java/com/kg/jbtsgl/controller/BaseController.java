package com.kg.jbtsgl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.kg.jbtsgl.service.NewService;
import com.kg.jbtsgl.service.ReviewService;
import com.kg.jbtsgl.service.TypeService;
import com.kg.jbtsgl.service.UserService;



public class BaseController {
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected NewService newService;
	
	@Autowired 
	protected TypeService typeService;
	
	@Autowired
	protected ReviewService reviewService;
}
