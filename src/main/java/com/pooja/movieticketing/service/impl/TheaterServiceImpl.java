package com.pooja.movieticketing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.enitity.impl.TheaterImpl;
import com.pooja.movieticketing.service.MovieService;
import com.pooja.movieticketing.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private MovieService movieService;
	
	public String createTheater() {
		// TODO Auto-generated method stub
		return null;
	}

	public void readTheater(String theaterName) {
		// TODO Auto-generated method stub
		
	}

	public void updateTheater(String theaterName) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTheater(String theaterName) {
		// TODO Auto-generated method stub
		
	}

	public List<Screen> viewAllScreens(String theaterName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Theater> viewAllMovies(String theaterName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void viewAllShowTimes(Screen screen) {
		// TODO Auto-generated method stub
		
	}

	public void viewAllSeats(Screen screen) {
		// TODO Auto-generated method stub
		
	}

}
