package com.pooja.movieticketing.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.service.MovieService;
import com.pooja.movieticketing.service.TheaterService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private TheaterService theaterService;
	
	public String createMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	public void readMovie(String movieName) {
		// TODO Auto-generated method stub
		
	}

	public void updateMovie(String movieName) {
		// TODO Auto-generated method stub
		
	}

	public void deleteMovie(String movieName) {
		// TODO Auto-generated method stub
		
	}

	public List<Theater> viewAllTheaters(String movieName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
