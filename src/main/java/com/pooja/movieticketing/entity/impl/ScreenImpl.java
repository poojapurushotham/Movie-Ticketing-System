package com.pooja.movieticketing.entity.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Ticket;

@Entity
@Table(name="screen")
public class ScreenImpl implements Screen {
	
	@Id
	@Column(name="screen_id")
	private int screenId;
	
	@Column(name="screen_name")
	private String screenName;
	
	@Column(name="seats")
	private String seats;
	
	@Column(name="show_time")
	private Date showTime;
	
	@Column(name="reserved")
	private List<String> reserved;
	
	@OneToMany(mappedBy = "tickets", targetEntity=TicketImpl.class, cascade=CascadeType.ALL)
	private List<Ticket> ticketsList;
	
	@OneToMany(mappedBy = "movie", targetEntity=MovieImpl.class, cascade=CascadeType.ALL)
	private List<Movie> movies;
	
	//constructor
	public ScreenImpl() {}
	
	public String getScreenName() {
		return screenName;
	}
	public List<String> getReserved() {
		return reserved;
	}
	public void setReserved(List<String> reserved) {
		this.reserved = reserved;
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
