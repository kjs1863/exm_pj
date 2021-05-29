package com.cos.vo;

public class ParamVo {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ParamVo [id=" + id + ", name=" + name + "]";
	}
	
	
}
