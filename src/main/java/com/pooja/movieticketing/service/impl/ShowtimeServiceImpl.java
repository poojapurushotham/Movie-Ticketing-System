package com.pooja.movieticketing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.repository.ScreenRepository;
import com.pooja.movieticketing.repository.ShowtimeRepository;
import com.pooja.movieticketing.repository.TheaterRepository;
import com.pooja.movieticketing.service.ShowtimeService;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private ScreenRepository screenRepository;
	
	@Autowired
	private ShowtimeRepository showtimeRepository;

	@Transactional
	@Override
	public List<Theater> viewAllTheatersforMovie(int movieId) {
		//make sure movie is valid
		Movie movie = movieRepository.getMovie(movieId);
		if(movie==null){
			throw new IllegalArgumentException("Invalid movie Id");
		}
	
		return showtimeRepository.viewAllTheatersforMovie(movieId);
	}
	
	@Transactional
	@Override
	public List<Movie> viewAllMoviesInTheater(int theaterId) {
		//make sure theater is valid
		Theater theater = theaterRepository.getTheater(theaterId);
		if(theater==null){
			throw new IllegalArgumentException("Invalid theater Id");
		}
		
		return showtimeRepository.viewAllMoviesInTheater(theaterId);
	}

/*	@Transactional
	@Override
	public List<Screen> viewAllScreens(int theaterId) {
		//make sure theater is valid
		Theater theater = theaterRepository.getTheater(theaterId);
		if(theater==null){
			throw new IllegalArgumentException("Invalid theater Id");
		}
		
		return screenRepository.getScreenList(theaterId);
	}*/

	@Transactional
	@Override
	public List<Showtime> viewAllShowTimes(int movieId, int theaterId, int screenId) {
		//make sure theater is valid
		Theater theater = theaterRepository.getTheater(theaterId);
		if(theater==null){
			throw new IllegalArgumentException("Invalid theater Id");
		}
		//make sure movie is valid
		Movie movie = movieRepository.getMovie(movieId);
		if(movie==null){
			throw new IllegalArgumentException("Invalid movie Id");
		}
		//make sure screen is valid
		Screen screen = screenRepository.getScreen(screenId);
		if(screen==null){
			throw new IllegalArgumentException("Invalid screen Id");
		}
		
		return showtimeRepository.getShowtimes(movieId, theaterId, screenId);
		
	}

	@Override
	public Showtime viewShowTimes(int showtimeId) {	
		//make sure movie is valid
		Showtime showtime = showtimeRepository.getShowtime(showtimeId);
		if(showtime==null){
			throw new IllegalArgumentException("Invalid showtime Id");
		}
		return showtimeRepository.getShowtime(showtimeId);
	}

}
