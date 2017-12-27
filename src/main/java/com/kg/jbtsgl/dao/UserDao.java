package com.kg.jbtsgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kg.jbtsgl.pojo.User;


@Repository
public class UserDao extends CommonDao{
	public User getUser(User user){
		String sql="select u from User u where u.username=:username and u.password=:password";
		Map<String, Object> params = CommonDao.BuildParameterMap("username", user.getUsername(),"password", user.getPassword());
		List<User> userList = this.query(sql, User.class,params);
		if(userList != null && !userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}

}
