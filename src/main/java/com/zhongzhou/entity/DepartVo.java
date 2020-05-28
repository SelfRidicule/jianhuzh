package com.zhongzhou.entity;

import java.util.ArrayList;
import java.util.List;

public class DepartVo {
	
	private Integer value;
	private String name;
	private List<UserVo> children=new ArrayList<UserVo>();
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserVo> getChildren() {
		return children;
	}
	public void setChildren(List<UserVo> children) {
		this.children = children;
	}
	
	
	
}
