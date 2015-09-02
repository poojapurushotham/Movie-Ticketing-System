package com.pooja.movieticketing.enitity.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.enitity.Ticket;

@Entity
@Table(name="theater")
public class TheaterImpl implements Theater {
	
	@Id
	@Column(name="idtheater")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String theaterid;
	
	@Column(name="theater_name")
	private String theaterName;
	
	@Column(name="theater_address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="aminities")
	private String aminities;
	
	@Column(name="screens")
	private int screens;
	
	@OneToMany(mappedBy = "screen", targetEntity=ScreenImpl.class, cascade=CascadeType.ALL)
	private List<Screen> screensList;
	
	@OneToMany(mappedBy = "tickets", targetEntity=TicketImpl.class, cascade=CascadeType.ALL)
	private List<Ticket> ticketsList;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "theater_has_movie", targetEntity=MovieImpl.class)	
	private List<Movie> movies;
	
	public TheaterImpl() {}
	
	public String getTheaterid() {
		return theaterid;
	}
	public int getScreens() {
		return screens;
	}
	public void setScreens(int screens) {
		this.screens = screens;
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

	@Override
	public String toString() {
		return "TheaterImpl [theaterid=" + theaterid + ", theaterName="
				+ theaterName + ", address=" + address + ", phone=" + phone
				+ ", aminities=" + aminities + ", screens=" + screens + "]";
	}
	
}
