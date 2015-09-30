package com.pooja.movieticketing.entity;

import java.util.Date;

public interface Showtime {
	public Movie getMovie();
	public Theater getTheater();
	public Screen getScreen();
	public Date getMovieScreenTime();
	public void setMovieScreenTime(Date screenTimings);
}
