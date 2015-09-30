package com.pooja.movieticketing.entity.impl;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Ticket;

@Entity
@Table(name="ticket")
public class TicketImpl implements Ticket {
	
	@Id
	@Column(name="idticket")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketId;
	
	@Column(name="seat_num")
	private int seatNum;
	
	@Column(name="cust_type")
	private String cutomerType;
	
	@Column(name="discount")
	private double discount;
	
	@Column(name="price")
	private double price;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="theater_name")
	private String theaterName;
		
	@Column(name="screen_name")
	private String screenName;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=AccountImpl.class)
	@JoinColumn(name="account_idaccount")
	private Account account;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=ShowtimeImpl.class)
	@JoinColumn(name="movie_showtime_showtimeId" )
	private Showtime movie_showtime;
	
	//constructor
	public TicketImpl() {}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
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

	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum=seatNum;
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

	@Override
	public void setAccountId(int accountId) {
		this.setAccountId(accountId);
		
	}

	@Override
	public int getAccountId() {
		return 	this.getAccountId();
	}

	
}
