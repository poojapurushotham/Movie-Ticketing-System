package com.pooja.movieticketing.entity;

public interface Ticket {
	public String getMovieName();

	public void setMovieName(String movieName);

	public String getTheaterName();

	public void setTheaterName(String theaterName);

	public String getScreenName();

	public void setScreenName(String screenName);

	public int getTicketId();

	public int getSeatNum();
	
	public void setSeatNum(int seatNum);
	
	public String getCutomerType();
	
	public void setCutomerType(String cutomerType);
	
	public double getDiscount();
	
	public void setDiscount(double discount);
	
	public double getPrice();
	
	public void setPrice(double price);

	public void setAccountId(int accountId);

	public int getAccountId();

}
