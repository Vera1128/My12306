package com.neuedu.my12306.usermgr.domain;

public class Province {
	private Integer id;
	private String provinceid;
	private String province;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Override
	public String toString() {
		return "Province:	ID = " + id + "	" + "provinceID = " + provinceid + "	" + "province = " + province;
	}
}
