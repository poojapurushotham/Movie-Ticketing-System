package com.pooja.movieticketing.enitity.impl;

import com.pooja.movieticketing.enitity.Ticket;

public class TicketImpl implements Ticket {
	private String ticketId;
	private String seatNum;
	private String cutomerType;
	private double discount;
	private double price;
	
	public TicketImpl(String ticketId) {
		this.ticketId=ticketId;
	}
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
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
