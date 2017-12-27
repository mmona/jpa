package com.kg.jbtsgl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	private Integer uid;//用户id
	private String username;//用户名
	private String password;//登录密码
	private String name;//用户姓名
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=4)
	public Integer getId() {
		return uid;
	}
	public void setId(Integer uid) {
		this.uid = uid;
	}
	@Column(length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
