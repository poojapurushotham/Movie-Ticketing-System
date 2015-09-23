package com.pooja.movieticketing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.repository.TheaterRepository;
import com.pooja.movieticketing.service.MovieService;
import com.pooja.movieticketing.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Transactional
	public Theater addTheater(Theater theater) {
		int id = theaterRepository.addTheater(theater);
		return getTheater(id);
	}

	@Transactional
	public Theater getTheater(int theaterId) {
		return theaterRepository.getTheater(theaterId);		
	}

	@Transactional
	public List<Theater> getTheater(long zip) {
		return theaterRepository.searchTheater(zip);
	}
	
	@Transactional
	public void updateTheater(Theater theater) {
		theaterRepository.updateTheater(theater);		
	}

	@Transactional
	public void deleteTheater(int theaterId) {
		theaterRepository.deleteTheater(theaterId);		
	}

	@Transactional
	public List<Screen> viewAllScreens(String theaterName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void viewAllShowTimes(Screen screen) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void viewAllSeats(Screen screen) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	public List<Movie> viewAllMovies(int theaterId) {
		//make sure user is valid
		Theater theater = theaterRepository.getTheater(theaterId);
		if(theater==null){
			throw new IllegalArgumentException("Invalid theater Id");
		}
				
		//get accounts		
		return theaterRepository.getMovieList(theaterId);
	}

}
