package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Theater;

public interface ShowtimeService {
	public List<Theater> viewAllTheatersforMovie(int movieId);
	
	public List<Showtime> viewAllShowTimes(int movieId, int theaterId, int screenId);
	
	public Showtime viewShowTimes(int showtimeId);
	
	public List<Movie> viewAllMoviesInTheater(int theaterId);
}
