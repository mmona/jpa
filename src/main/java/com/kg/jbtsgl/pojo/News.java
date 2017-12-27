package com.kg.jbtsgl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.MAX;

@Entity
@Table(name="news")
public class News {
	private Integer nid;//新闻编号
	private String title;//新闻标题
	private String  content;//新闻内容
	private Integer tid;//类别id
	private String publishtime;//发布时间
	@Id
	@GeneratedValue
	@Column(length=4)
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	@Column(length=200)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(length=4)
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@Column(length=200)
	public String getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", content=" + content + ", tid=" + tid + ", publishtime="
				+ publishtime + "]";
	}
	
	
}
