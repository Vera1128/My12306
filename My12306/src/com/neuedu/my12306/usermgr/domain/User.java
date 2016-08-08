package com.neuedu.my12306.usermgr.domain;

import java.util.Date;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String rule;
	private String realname;
	private String sex;	
	private City city;
	private CertType cert_type;
	private String cert;	
	
	private String birthday;//
	private UserType user_type;
	private String content;
	private String status;
	private String login_ip;
	private String image_path;

	@Override
	public String toString() {
		return "User:	ID = " + id + "	" + "username = " + username + 
//				"	" + "password = " + password + "	" + "rule = " + rule + 
				"	" + "realname = " + realname + "	" + "sex = " + sex + 
				"	" + "city = " + city.getCity() + "	" + "cert_type = " + cert_type.getContent() + 
				"	" + "cert = " + cert + "	" + "birthday = " + birthday + 
				"	" + "user_type = " + user_type.getContent() + "	" + "content = " + content + 
				"	" + "status = " + status + "	" + "login_ip = " + login_ip + 
				"	" + "image_path = " + image_path;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public CertType getCert_type() {
		return cert_type;
	}
	public void setCert_type(CertType cert_type) {
		this.cert_type = cert_type;
	}
	public String getCert() {
		return cert;
	}
	public void setCert(String cert) {
		this.cert = cert;
	}	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public UserType getUser_type() {
		return user_type;
	}
	public void setUser_type(UserType user_type) {
		this.user_type = user_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

}
