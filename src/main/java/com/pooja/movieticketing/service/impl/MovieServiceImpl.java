package com.pooja.movieticketing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	@Override
	public Movie addMovie(Movie movie) {
		int id = movieRepository.addMovie(movie);
		return getMovie(id);
	}

	@Transactional
	@Override
	public Movie getMovie(int movieId) {
		return movieRepository.getMovie(movieId);
		
	}
	
	@Transactional
	@Override
	public List<Movie> getMovie(String movieName) {
		return movieRepository.searchMovie(movieName);
		
	}

	@Transactional
	@Override
	public void updateMovie(Movie movie) {
		movieRepository.updateMovie(movie);
		
	}

	@Transactional
	@Override
	public void deleteMovie(int movieId) {
		movieRepository.deleteMovie(movieId);
		
	}

}
