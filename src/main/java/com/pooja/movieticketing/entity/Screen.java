package com.pooja.movieticketing.entity;

import java.util.List;

public interface Screen {
	public int getScreenId();
	public String getScreenName();
	public List<Integer> getReserved();
	public void setReserved(int seat);
	public int getSeats();
	public void setSeats(int seats);
	public void setScreenName(String screenName);
}
