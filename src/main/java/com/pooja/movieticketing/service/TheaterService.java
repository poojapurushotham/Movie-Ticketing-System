package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Theater;

public interface TheaterService {
	public String createTheater();
	public void readTheater(String theaterName);
	public void updateTheater(String theaterName);
	public void deleteTheater(String theaterName);
	public List<Screen> viewAllScreens(String theaterName);
	public void viewAllShowTimes(Screen screen);
	public void viewAllSeats(Screen screen);
	public List<Movie> viewAllMovies(int theaterId);
}
