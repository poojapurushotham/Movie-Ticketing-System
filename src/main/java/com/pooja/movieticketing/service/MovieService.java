package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Theater;

public interface MovieService {
	public String addMovie();
	public void getMovie(int movieId);
	public void updateMovie(Movie movie);
	public void deleteMovie(int movieId);
	public List<Theater> viewAllTheaters(int movieId);
}
