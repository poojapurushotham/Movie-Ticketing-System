package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Movie;

public interface MovieService {
	public Movie addMovie(Movie movie);
	public Movie getMovie(int movieId);
	public List<Movie> getMovie(String movieName);
	public void updateMovie(Movie movie);
	public void deleteMovie(int movieId);
}
