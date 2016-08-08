package com.neuedu.my12306.usermgr.domain;

public class UserType {
	private Integer id;
	private String content;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "UserType:	ID = " + id + "	" + "content = " + content;
	}

}
