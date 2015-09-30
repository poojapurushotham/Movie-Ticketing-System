package com.pooja.movieticketing.repository;

import java.util.Date;
import java.util.List;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Theater;

public interface ShowtimeRepository {

	public List<Showtime> getShowtimes(int movieId, int theaterId, int screenId);
	
	public Showtime getShowtime(int showtimeId);
	
	public List<Theater> viewAllTheatersforMovie(int movieId);
	
	public List<Movie> viewAllMoviesInTheater(int theaterId);

	public void updateShowtime(Showtime showtime);
	
}	