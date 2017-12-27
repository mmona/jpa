package com.kg.jbtsgl.service;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.jbtsgl.dao.UserDao;
import com.kg.jbtsgl.pojo.User;
import com.kg.jbtsgl.utils.MD5Util;



@Service
public class UserService extends BaseService  {
	@Autowired
	private UserDao userDao;
	public User login(User user){
		String password = user.getPassword();
		password = MD5Util.md5Hex(password);
		User user1 = userDao.getUser(user);
		if(user1!=null){
			return user1;
		}
		return null;
	}
}
