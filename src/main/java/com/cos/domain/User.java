package com.cos.domain;

import lombok.Data;

@Data
public class User {
	private String uid;
	private String upw;
	private String uname;
	private Integer upoint;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUpoint() {
		return upoint;
	}
	public void setUpoint(Integer upoint) {
		this.upoint = upoint;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", upoint=" + upoint + "]";
	}
	
	
}
