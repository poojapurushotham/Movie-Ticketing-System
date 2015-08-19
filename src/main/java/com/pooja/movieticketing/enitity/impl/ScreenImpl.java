package com.pooja.movieticketing.enitity.impl;

import java.util.Date;

import com.pooja.movieticketing.enitity.Screen;

public class ScreenImpl implements Screen {
	private String seats;
	private Date showTime;
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
