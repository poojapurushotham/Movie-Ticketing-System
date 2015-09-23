package com.pooja.movieticketing.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Theater;

@Entity
@Table(name="movie_showtime")
public class ShowtimeImpl {
	
	@Id
	@Column(name="movie_idmovie")
	private int movieId;

	@Id
	@Column(name="theater_idtheater")
	private int theaterId;
	
	@Id
	@Column(name="screen_idscreen")
	private int screenId;
	
	@Column(name="showtime")
	private Date showtime;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=TheaterImpl.class)
	@JoinColumn(name="theater_idtheater")
	private Theater theater;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=ScreenImpl.class)
	@JoinColumn(name="screen_idscreen")
	private Screen screen;

	//constructor
	public ShowtimeImpl() {}
	
	public int getMovieId() {
		return movieId;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public int getScreenId() {
		return screenId;
	}
	public Date getShowtime() {
		return showtime;
	}
	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}

	@Override
	public String toString() {
		return "ShowtimeImpl [showtime=" + showtime + ", movie=" + movie
				+ ", theater=" + theater + ", screen=" + screen + "]";
	}
	
}
