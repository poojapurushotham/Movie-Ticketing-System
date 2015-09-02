package com.pooja.movieticketing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.irahul.tbtf.entity.User;
import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.repository.CustomerAccountRepository;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.repository.TheaterRepository;
import com.pooja.movieticketing.service.MovieService;
import com.pooja.movieticketing.service.TheaterService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public int addMovie(Movie movie) {
		return movieRepository.addMovie(movie);
	}

	@Transactional
	public void getMovie(int movieId) {
		movieRepository.getMovie(movieId);
		
	}

	@Transactional
	public void updateMovie(Movie movie) {
		movieRepository.updateMovie(movie);
		
	}

	@Transactional
	public void deleteMovie(int movieId) {
		movieRepository.deleteMovie(movieId);
		
	}

	@Transactional
	public List<Theater> viewAllTheaters(int movieId) {
		//make sure user is valid
		Movie movie = movieRepository.getMovie(movieId);
		if(movie==null){
			throw new IllegalArgumentException("Invalid movie Id");
		}
				
		//get accounts		
		return movieRepository.getTheaterList(movieId);
	}
	
}
