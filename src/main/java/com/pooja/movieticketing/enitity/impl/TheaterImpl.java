package com.pooja.movieticketing.enitity.impl;

import java.util.List;

import com.pooja.movieticketing.enitity.Theater;

public class TheaterImpl implements Theater {
	private String theaterName;
	private String address;
	private String phone;
	private String aminities;
	private int screens;
	private List<ScreenImpl> screensList;
	
	public TheaterImpl(String theaterName, int screens) {
		this.theaterName=theaterName;
		for(int i=1;i<=screens;i++) {
			screensList.add(new ScreenImpl("Screen"+screens));
		}
	}
	
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAminities() {
		return aminities;
	}
	public void setAminities(String aminities) {
		this.aminities = aminities;
	}
}
