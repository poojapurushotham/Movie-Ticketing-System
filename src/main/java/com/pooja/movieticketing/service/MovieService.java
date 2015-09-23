package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Theater;

public interface MovieService {
	public Movie addMovie(Movie movie);
	public Movie getMovie(int movieId);
	public List<Movie> getMovie(String movieName);
	public void updateMovie(Movie movie);
	public void deleteMovie(int movieId);
	public List<Theater> viewAllTheaters(int movieId);
}
