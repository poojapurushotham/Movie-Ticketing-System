package com.pooja.movieticketing.enitity.impl;

import java.util.Date;
import java.util.List;

import com.pooja.movieticketing.enitity.Screen;

public class ScreenImpl implements Screen {
	private String seats;
	private Date showTime;
	private String screenName;
	private List<String> reserved;
	
	public String getScreenName() {
		return screenName;
	}
	public List<String> getReserved() {
		return reserved;
	}
	public void setReserved(List<String> reserved) {
		this.reserved = reserved;
	}
	public ScreenImpl(String screenName) {
		this.screenName = screenName;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
}
