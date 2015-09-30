package com.pooja.movieticketing.entity;

public interface Theater {
	public int getTheaterId();
	public String getTheaterName();
	public int getScreens();
	public long getZip();
	public String getAddress();
	public void setTheaterName(String theaterName);
	public void setScreens(int screens);
	public void setZip(long zip);
}
