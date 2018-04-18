package com.samsoft.cookbook.concurrency.basics;

import java.util.Date;

public class Event {
	private Date date;
	private String state;
	public Event(Date date, String state) {
		super();
		this.date = date;
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
