package com.pooja.movieticketing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.repository.TheaterRepository;
import com.pooja.movieticketing.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public Movie addMovie(Movie movie) {
		int id = movieRepository.addMovie(movie);
		return getMovie(id);
	}

	@Transactional
	public Movie getMovie(int movieId) {
		return movieRepository.getMovie(movieId);
		
	}
	
	@Transactional
	public List<Movie> getMovie(String movieName) {
		return movieRepository.searchMovie(movieName);
		
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
