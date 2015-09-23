package com.pooja.movieticketing.entity.impl;

import java.util.List;

import com.pooja.movieticketing.entity.Ticket;

public class TicketImpl implements Ticket {
	private int ticketId;
	private List<String> seatNum;
	private String cutomerType;
	private double discount;
	private double price;
	private String movieName;
	private String threaterName;
	private String screenName;
	
	//constructor
	public TicketImpl(int ticketId) {
		this.ticketId=ticketId;
	}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getThreaterName() {
		return threaterName;
	}

	public void setThreaterName(String threaterName) {
		this.threaterName = threaterName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getTicketId() {
		return ticketId;
	}

	public List<String> getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(List<String> seatNum) {
		this.seatNum.addAll(seatNum);
	}
	public String getCutomerType() {
		return cutomerType;
	}
	public void setCutomerType(String cutomerType) {
		this.cutomerType = cutomerType;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}
