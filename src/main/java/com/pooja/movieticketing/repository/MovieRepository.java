package com.pooja.movieticketing.repository;

import java.util.List;

import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Theater;

public interface MovieRepository {
	
	public int addMovie(Movie movie);

	public Movie getMovie(int movieId);
	
	public void updateMovie(Movie movie);
	
	public void deleteMovie(int movieId);
	
	public List<Theater> getTheaterList(int movieId);
	
}	