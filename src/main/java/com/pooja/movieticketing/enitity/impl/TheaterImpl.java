package com.pooja.movieticketing.enitity.impl;

import com.pooja.movieticketing.enitity.Theater;

public class TheaterImpl implements Theater {
	private String theaterName;
	private String address;
	private String phone;
	private String aminities;
	
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
