package com.stephen.study.modules.test.entity;

import java.util.Date;

import com.stephen.study.core.persistence.BaseEntity;

public class Room extends BaseEntity<Room> {
	
	private static final long serialVersionUID = 1L;
	private String name;	// 名字
	protected Date createDate;	// 创建日期

	@Override
	public void preInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate() {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
