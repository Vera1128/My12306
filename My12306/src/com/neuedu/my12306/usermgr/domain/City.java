package com.neuedu.my12306.usermgr.domain;

public class City {
	private Integer id;
	private String cityid;
	private String city;
	private Province father;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public Province getFather() {
		return father;
	}
	public void setFather(Province father) {
		this.father = father;
	}
	@Override
	public String toString() {
		return "City:	ID = " + id + "	" + "cityID = " + cityid + "	" + "city = " + city + "	" + "father = " + father;
	}
}
