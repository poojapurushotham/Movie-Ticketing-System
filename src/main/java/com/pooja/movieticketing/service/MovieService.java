package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.enitity.Theater;

public interface MovieService {
	public String createMovie();
	public void readMovie(String movieName);
	public void updateMovie(String movieName);
	public void deleteMovie(String movieName);
	public List<Theater> viewAllTheaters(String movieName);
}
