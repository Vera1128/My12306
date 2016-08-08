package com.neuedu.my12306.usermgr.domain;

public class Train {
	private Integer id;
	private String train_number;
	private String fromplace;
	private String toplace;
	private String begin;
	private String end;
	private double price;
	private String duration;
	private String date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrain_number() {
		return train_number;
	}
	public void setTrain_number(String train_number) {
		this.train_number = train_number;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getFromplace() {
		return fromplace;
	}
	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}
	public String getToplace() {
		return toplace;
	}
	public void setToplace(String toplace) {
		this.toplace = toplace;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Train [id=" + id + ", train_number=" + train_number
				+ ", fromplace=" + fromplace + ", toplace=" + toplace
				+ ", begin=" + begin + ", end=" + end + ", price=" + price
				+ ", duration=" + duration + "]";
	}
	
}
