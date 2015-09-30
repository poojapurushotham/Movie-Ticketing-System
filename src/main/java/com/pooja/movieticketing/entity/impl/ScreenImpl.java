package com.pooja.movieticketing.entity.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Theater;

@Entity
@Table(name="screen")
public class ScreenImpl implements Screen {
	
	@Id
	@Column(name="idscreen")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int screenId;
	
	@Column(name="screen_name")
	private String screenName;
	
	@Column(name="seats")
	private int seats;
	
	@Column(name="reserved_seats")
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> reserved;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=TheaterImpl.class)
	@JoinColumn(name="theater_idtheater")
	private Theater theater;
	
	@OneToMany(mappedBy = "screen", targetEntity=ShowtimeImpl.class, cascade=CascadeType.ALL)	
    private List<Showtime> showtimes;
	
	//constructor
	public ScreenImpl() {}
	
	public String getScreenName() {
		return screenName;
	}
	public int getScreenId() {
		return screenId;
	}

	public List<Integer> getReserved() {
		return reserved;
	}
	public void setReserved(int seat) {
		this.reserved.add(seat);
	}
	
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setScreenName(String screenName) {
		this.screenName=screenName;
		
	}

}
