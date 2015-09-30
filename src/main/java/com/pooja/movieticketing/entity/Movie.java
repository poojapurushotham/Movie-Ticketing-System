package com.pooja.movieticketing.entity;

public interface Movie {
	public String getMovieName();
	public int getMovieId();
	public String getLanguage();
	public String getGenre();
	public double getRating();
	public void setMovieName(String movieName);
	public void setLanguage(String language);
	public void setGenre(String genre);
	public void setRating(double rating);
}
