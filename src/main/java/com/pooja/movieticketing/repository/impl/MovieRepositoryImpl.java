package com.pooja.movieticketing.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pooja.movieticketing.enitity.Customer;
import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.repository.CustomerAccountRepository;
import com.pooja.movieticketing.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	//customer
	public int addMovie(Movie movie) {
		return (int) this.sessionFactory.getCurrentSession().save(movie);
		
	}

	public Movie getMovie(int movieId) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieId);
	}

	public void updateMovie(Movie movie) {
		this.sessionFactory.getCurrentSession().update(movie);
	}
	
	public void deleteMovie(int movieId) {
		this.sessionFactory.getCurrentSession().delete(this.get(movieId));
	}
	
	@SuppressWarnings("unchecked")
	public List<Theater> getTheaterList(int movieId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterServiceImpl.class)
				.add(Restrictions.eq("theater_has_movie.movie_idmovie", movieId));		
		List<Theater> theaters = crit.list();
		return theaters;
	}

}