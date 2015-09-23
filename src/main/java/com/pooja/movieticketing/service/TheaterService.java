package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Theater;

public interface TheaterService {
	public Theater addTheater(Theater theater);
	public Theater getTheater(int theaterId);
	public List<Theater> getTheater(long zip);
	public void updateTheater(Theater theater);
	public void deleteTheater(int theaterId);
	public List<Screen> viewAllScreens(String theaterName);
	public void viewAllShowTimes(Screen screen);
	public void viewAllSeats(Screen screen);
	public List<Movie> viewAllMovies(int theaterId);
}
