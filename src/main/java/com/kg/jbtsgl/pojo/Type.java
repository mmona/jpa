package com.kg.jbtsgl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="type")
public class Type {
	private Integer tid;//类别id
	private String name;//类别姓名
	private String  memo;//类别备注
	@Id
	@GeneratedValue
	@Column(length=4)
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=100)
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", name=" + name + ", memo=" + memo + "]";
	}
	
	
}
