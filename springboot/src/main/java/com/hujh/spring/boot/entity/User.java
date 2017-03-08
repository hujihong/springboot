package com.hujh.spring.boot.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	
	private int id;
	private String name;
	
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	@JSONField(serialize=false)  // 不json化
	private String remark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User(){}
	
	public User(int id, String name, Date date, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
