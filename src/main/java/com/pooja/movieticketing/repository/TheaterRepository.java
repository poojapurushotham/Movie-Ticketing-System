package com.pooja.movieticketing.repository;

import java.util.List;

import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Theater;

public interface TheaterRepository {
		
	public int addTheater(Theater theater);

	public Theater getTheater(int theaterId);
	
	public void updateTheater(Theater theater);
	
	public void deleteTheater(int theaterId);
	
	public List<Movie> getMovieList(int theaterId);
	
}	
