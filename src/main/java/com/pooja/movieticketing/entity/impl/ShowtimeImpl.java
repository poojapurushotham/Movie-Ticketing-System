package com.pooja.movieticketing.entity.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.Ticket;

@Entity
@Table(name="movie_showtime")
public class ShowtimeImpl implements Showtime {

	@Id
	@Column(name="showtimeId")
	private int showtimeId;
	
	@Column(name="showtime")
	private Date screenTimings;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=TheaterImpl.class)
	@JoinColumn(name="theater_idtheater")
	private Theater theater;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=ScreenImpl.class)
	@JoinColumn(name="screen_idscreen")
	private Screen screen;

	@OneToMany(mappedBy = "movie_showtime", targetEntity=TicketImpl.class, cascade=CascadeType.ALL)	
    private List<Ticket> tickets;
	
	//constructor
	public ShowtimeImpl() {}
	
	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public Screen getScreen() {
		return screen;
	}
	public Date getMovieScreenTime() {
		return screenTimings;
	}
	public void setMovieScreenTime(Date screenTimings) {
		this.screenTimings = screenTimings;
	}

	@Override
	public String toString() {
		return "ShowtimeServiceImpl [screenTimings=" + screenTimings + ", movie=" + movie
				+ ", theater=" + theater + ", screen=" + screen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((screen == null) ? 0 : screen.hashCode());
		result = prime * result + ((screenTimings == null) ? 0 : screenTimings.hashCode());
		result = prime * result + showtimeId;
		result = prime * result + ((theater == null) ? 0 : theater.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowtimeImpl other = (ShowtimeImpl) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (screen == null) {
			if (other.screen != null)
				return false;
		} else if (!screen.equals(other.screen))
			return false;
		if (screenTimings == null) {
			if (other.screenTimings != null)
				return false;
		} else if (!screenTimings.equals(other.screenTimings))
			return false;
		if (showtimeId != other.showtimeId)
			return false;
		if (theater == null) {
			if (other.theater != null)
				return false;
		} else if (!theater.equals(other.theater))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}


}
