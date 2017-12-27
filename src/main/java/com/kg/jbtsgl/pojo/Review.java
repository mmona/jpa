package com.kg.jbtsgl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	private Integer rid;
	private String content;//评论内容
	private String  username;//评论者昵称
	private String revtime;//
	private int nid;//新闻编号
	@Id
	@GeneratedValue
	@Column(length=4)
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	@Column
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(length=100)
	public String getRevtime() {
		return revtime;
	}
	public void setRevtime(String revtime) {
		this.revtime = revtime;
	}
	@Column(length=4)
	@ManyToOne
	@JoinColumn(name="nid")
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
 
}
